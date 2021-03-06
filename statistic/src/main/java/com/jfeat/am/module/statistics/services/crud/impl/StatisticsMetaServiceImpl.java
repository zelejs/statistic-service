package com.jfeat.am.module.statistics.services.crud.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.module.statistics.services.crud.SQLSearchLabelService;
import com.jfeat.am.module.statistics.services.crud.StatisticsMetaService;
import com.jfeat.am.module.statistics.services.crud.model.MetaColumns;
import com.jfeat.am.module.statistics.services.gen.crud.service.impl.CRUDStatisticsMetaServiceImpl;
import com.jfeat.am.module.statistics.services.gen.persistence.dao.StatisticsMetaMapper;
import com.jfeat.am.module.statistics.services.gen.persistence.model.StatisticsMeta;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jfeat.am.core.shiro.ShiroKit;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.*;
import java.util.*;

/**
 * <p>
 * implementation
 * </p>
 * CRUDStatisticsMetaService
 *
 * @author Code Generator
 * @since 2018-07-29
 */

@Service
public class StatisticsMetaServiceImpl extends CRUDStatisticsMetaServiceImpl implements StatisticsMetaService {

    @Resource
    DataSource dataSource;
    @Resource
    StatisticsMetaMapper statisticsMetaMapper;

    @Resource
    SQLSearchLabelService sqlSearchLabelService;


    @Override
    public String getQuerySql(String field, String recordName, String tuple, String cluster, String timeline) {
        return null;
    }

    //根据field获取 json化的 表
    @Override
    public  JSONObject getByField(String field, Long current, Long size, HttpServletRequest request){
        //分页 //总页数 pages //每页大小 size
        //总记录数 //当前页数 current
        Long pages=0L;
        Long total = 0L;
        String[] typeArray=null;
        String[] searchArray=null;
        JSONObject date=new JSONObject();
        List<JSONObject> objList=new ArrayList<>();
        try {
            StringBuilder sql=new StringBuilder();
            String countSQL;//用于查询总记录数
            Connection connection = dataSource.getConnection();
            //根据field获取sql
            List<StatisticsMeta> statisticsMetas = statisticsMetaMapper.selectList(new EntityWrapper<StatisticsMeta>()
                    .eq(StatisticsMeta.FIELD, field));
            if(statisticsMetas!=null&&statisticsMetas.size()>0){
                StatisticsMeta meta = statisticsMetas.get(0);
                if(meta.getType()==null||meta.getType().equals("")){throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"需要搜索的类型未配置");}
                if(meta.getSearch()==null||meta.getSearch().equals("")){}else{searchArray=meta.getSearch().split(",");}
                // 如果报表有限制权限 权限判断
                if(meta.getPermission()!=null&&!"".equals(meta.getPermission())){
                    if(!ShiroKit.hasPermission(meta.getPermission())){
                        throw new BusinessException(BusinessCode.AuthorizationError,"没有权限");
                    }
                }
                //字段的说明
                String tips = meta.getTips();
                //调用策略方法解包 tips
                JSONArray endtipArray = tipUnpacking(tips);

                typeArray = meta.getType().split(",");
                date.put("columns",typeArray);
                date.put("searchColumns",searchArray);
                date.put("tips",endtipArray);

                Map<String, String[]> parameterMap = request.getParameterMap();
                //去除所有的‘;’防止拼接出错
                sql.append(meta.getQuerySql().replaceAll(";",""));
                //使用标签
                sql=sqlSearchLabelService.getSQL(parameterMap,sql);
                //替换字符串 查找总数
                countSQL=sql.toString().replaceFirst("(select|SELECT)","SELECT COUNT(*) as total,");
            }
            else  {throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"查找不到field对应的Meta");}
            //创建 可循环滚动的rs
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(countSQL);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int colunmCount = resultSetMetaData.getColumnCount();
            List<String> names=new ArrayList<>();//字段名
            Map<String,String> nameTypeMap=new HashMap<>();//名字 类型映射
            if(typeArray.length!=colunmCount-1){throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"得到的字段数量和类型数量不匹配 请检查sql和type"); }
            //循环获取 字段名
            for (int i = 0; i < colunmCount; i++) {
                String name=resultSetMetaData.getColumnLabel(i+1);
                if(name.equals("total")){}
                else {
                    names.add(name);
                    nameTypeMap.put(name,typeArray[i-1]); }}
            // 添加搜索-----------
            sql=getSearchSQL(sql,request,nameTypeMap);
            // 添加排序-----------
            //sql=orderSQL(sql,nameTypeMap);
            //重新搜索查找总数
            countSQL=sql.toString().replaceFirst("(select|SELECT)","SELECT COUNT(*) as total,");
            rs = stmt.executeQuery(countSQL);
           //指针回到最初位置
            rs.beforeFirst();
            while (rs.next()){
                //使用sql查找总数据行数
                total= Long.parseLong( rs.getObject("total").toString());
                //向上取整
                pages=(long)Math.ceil((double)total/(double)size); }
             //加入分页
            sql.append(" limit "+((current-1)*size)+","+size);
            System.out.println("最终执行的sql:    ");
            System.out.println(sql);
            //更改sql 查全部
            rs = stmt.executeQuery(sql.toString());
            while (rs.next()){
                JSONObject pojoObject=new JSONObject();
                for (String name:names) {
                    //数据为空 则返回空
                    if(rs.getObject(name)!=null){
                        if("P".equals(nameTypeMap.get(name))){
                            pojoObject.put(name,Float.parseFloat(rs.getObject(name).toString())*10000/100);
                        }else
                            pojoObject.put(name,rs.getObject(name).toString());
                    }else {
                        pojoObject.put(name,null);
                    }
                }
                objList.add(pojoObject);
            }
            date.put("header",names);
            date.put("rows",objList);
            date.put("total",total);
            date.put("size",size);
            date.put("pages",pages);
            date.put("current",current);
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE, e.getMessage());
             }
        return date;
            }


//拼接搜索sql
public StringBuilder getSearchSQL(StringBuilder sql,HttpServletRequest request,Map<String,String> nameType){
        if(nameType==null||nameType.size()==0) {
            throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE, "名字类型映射为空");
        }
       else {
            //无误处理sql
            sql.insert(0,"select t.* from(");
            sql.append(")t where 1=1 ");
        }
    String fieldRequest=null;
    String fieldRequests[]=null;
    String field=null;
    String type=null;
      Iterator<String> iter = nameType.keySet().iterator();
      while (iter.hasNext()) {
        field = iter.next();
        type=nameType.get(field);
        if(type.equals(MetaColumns.STRING)){
            fieldRequest=request.getParameter(field);
            if(fieldRequest!=null&&fieldRequest.length()>0){
                searchSQLByTypeAndField(sql,type,field,fieldRequest);
            }
        }else {
            fieldRequests=request.getParameterValues(field);
            if(fieldRequests!=null&&fieldRequests.length>0){
                searchSQLByTypeAndFields(sql,type,field,fieldRequests);
            }
        }
    }
        return sql;
}

//其他类型 拼接sql
    public StringBuilder   searchSQLByTypeAndFields(StringBuilder sql,String type,String field,String[] fieldRequests){
        String searchSQLLeft=" ";
        String searchSQLRigtht=" ";
        if(type.equals(MetaColumns.TIME)){
            searchSQLLeft = " TO_DAYS(";
            searchSQLRigtht=") ";
        }
            if(fieldRequests[0]!=""){
                sql.append(" AND ");
                sql.append(searchSQLLeft);
                sql.append(field);
                sql.append(searchSQLRigtht);
                sql.append(" >= ");
                sql.append(searchSQLLeft);
                sql.append("'");
                sql.append(fieldRequests[0]);
                sql.append("'");
                sql.append(searchSQLRigtht);
            }
            if(fieldRequests[1]!="") {
                sql.append(" AND ");
                sql.append(searchSQLLeft);
                sql.append(field);
                sql.append(searchSQLRigtht);
                sql.append(" <= ");
                sql.append(searchSQLLeft);
                sql.append("'");
                sql.append(fieldRequests[1]);
                sql.append("'");
                sql.append(searchSQLRigtht);
            }
        return  sql;
    }

    //字符串类型 拼接sql
        public StringBuilder  searchSQLByTypeAndField(StringBuilder sql,String type,String field,String fieldRequest){
           if(type.equals(MetaColumns.STRING)){
              sql.append(" AND ");
              sql.append(field);
              sql.append(" LIKE ");
               sql.append("'%");
              sql.append(fieldRequest);
               sql.append("%'");
           }
        return  sql;
    }

    //排序
    public StringBuilder orderSQL(StringBuilder sql,Map<String,String> nameType){
        StringBuilder orderSQL=new StringBuilder();
        String field=null;
        String type=null;
        Iterator<String> iter = nameType.keySet().iterator();
        while (iter.hasNext()) {
            field = iter.next();
            type=nameType.get(field);
            if(type.equals(MetaColumns.DECIMAL)){
                if(orderSQL.toString()==null||orderSQL.toString().equals("")){
                    orderSQL.append(" order by ");
                    orderSQL.append("`");
                    orderSQL.append(field);
                    orderSQL.append("`");
                    orderSQL.append(" desc ");
                }else{
                    orderSQL.append(",");
                    orderSQL.append("`");
                    orderSQL.append(field);
                    orderSQL.append("`");
                    orderSQL.append(" desc ");
                }
                }
            }
        sql.append(orderSQL);
        return sql;

    }



    //根据field获取 json化的 表
    @Override
    public  String getSQLByField(String field,HttpServletRequest request){
        String[] typeArray=null;
        StringBuilder sql=new StringBuilder();
        try {
            String countSQL;//用于查询总记录数
            Connection connection = dataSource.getConnection();
            //根据field获取sql
            List<StatisticsMeta> statisticsMetas = statisticsMetaMapper.selectList(new EntityWrapper<StatisticsMeta>().eq(StatisticsMeta.FIELD, field));
            if(statisticsMetas!=null&&statisticsMetas.size()>0){
                StatisticsMeta meta = statisticsMetas.get(0);
                typeArray = meta.getType().split(",");
                //替换字符串 查找总数
                countSQL=meta.getQuerySql().replaceFirst("(select|SELECT)","SELECT COUNT(*) as total,");
                //去除所有的‘;’防止拼接出错
                sql.append(meta.getQuerySql().replaceAll(";",""));
            }else{throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"查找不到field对应的Meta");}
            //创建 可循环滚动的rs
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(countSQL);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int colunmCount = resultSetMetaData.getColumnCount();
            List<String> names=new ArrayList<>();//字段名
            Map<String,String> nameTypeMap=new HashMap<>();//名字 类型映射
            if(typeArray.length!=colunmCount-1){throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"得到的字段数量和类型数量不匹配 请检查sql和type"); }
            //循环获取 字段名
            for (int i = 0; i < colunmCount; i++) {
                String name=resultSetMetaData.getColumnLabel(i+1);
                if(name.equals("total")){}
                else {
                    names.add(name);
                    nameTypeMap.put(name,typeArray[i-1]); }}
            // 添加搜索-----------
            sql=getSearchSQL(sql,request,nameTypeMap);
            // 添加排序-----------
            sql=orderSQL(sql,nameTypeMap);
            System.out.println("最终执行的sql:    ");
            System.out.println(sql);
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e)
        { e.printStackTrace(); }
        return sql.toString(); }

        //将tips字段解包成数组形式
        private JSONArray tipUnpacking(String tips){
            JSONArray endtipArray = new JSONArray();
            if(tips!=null&& !"".equals(tips)){
                String[] tipArray = tips.split(",");
                for(String tip:tipArray){
                    JSONObject vk = new JSONObject();
                    String[] split = tip.split(":");
                    if(split.length!=2){
                        throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"字段的说明格式有误，请按照num:value,num2:value2格式配置");
                    }
                    vk.put(split[0],split[1]);
                    endtipArray.add(vk);
                }
            }
            return endtipArray;
        }

}


