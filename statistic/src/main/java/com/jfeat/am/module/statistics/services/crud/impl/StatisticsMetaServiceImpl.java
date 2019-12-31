package com.jfeat.am.module.statistics.services.crud.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.module.statistics.services.crud.StatisticsMetaService;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsMetaMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsMeta;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class StatisticsMetaServiceImpl implements StatisticsMetaService {

    @Autowired
    DataSource dataSource;
    @Resource
    StatisticsMetaMapper statisticsMetaMapper;

    @Override
    public String getQuerySql(String field, String recordName, String tuple, String cluster, String timeline) {
        return null;
    }

    //根据field获取 json化的 表
    @Override
    public  JSONObject getByField(String field,Long current,Long size){
        //分页 //总页数 pages //每页大小 size
        //总记录数 //当前页数 current
        Long pages=0L;
        Long total = 0L;

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
                String[] typeArray = meta.getType().split(",");
                date.put("columns",typeArray);
                //匹配字符串
                countSQL=meta.getQuerySql().replaceFirst("(select|SELECT)","SELECT COUNT(*) as totle,");
                //去除所有的‘;’
                sql.append(meta.getQuerySql().replaceAll(";",""));
                //开始分页
                sql.append("limit "+((current-1)*size)+","+(size+((current-1)*size)));
            }else{
                throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"查找不到field对应的Meta");
            }
              System.out.println("sql=    ");
              System.out.println(sql);
            //可循环滚动的rs
            Statement stmt = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(countSQL);
            while (rs.next()){
                //使用sql查找总数据行数
                total= Long.parseLong( rs.getObject("totle").toString());
                //向上取整

                pages=(long)Math.ceil((double)total/(double)size);
            }
            //更改sql 查全部
            rs = stmt.executeQuery(sql.toString());
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int colunmCount = resultSetMetaData.getColumnCount();
            List<String> names=new ArrayList<>();
            for (int i = 0; i < colunmCount; i++) {
                String name=resultSetMetaData.getColumnName(i+1);
                name=resultSetMetaData.getColumnLabel(i+1);
                names.add(name);}
            //指针回到最初位置
            rs.beforeFirst();
            while (rs.next()){
                JSONObject pojoObject=new JSONObject();
                for (String name:names) {
                    //数据为空 则返回空
                    if(rs.getObject(name)!=null){
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }
}


