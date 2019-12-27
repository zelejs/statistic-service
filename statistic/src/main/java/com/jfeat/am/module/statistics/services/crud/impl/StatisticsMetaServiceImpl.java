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
    public  JSONObject getByField(String field){
        JSONObject date=new JSONObject();
        List<JSONObject> objList=new ArrayList<>();
        try {
            String sql=null;
            Connection connection = dataSource.getConnection();
            //根据field获取sql
            List<StatisticsMeta> statisticsMetas = statisticsMetaMapper.selectList(new EntityWrapper<StatisticsMeta>()
                    .eq(StatisticsMeta.FIELD, field));
            if(statisticsMetas!=null&&statisticsMetas.size()>0){
                StatisticsMeta meta = statisticsMetas.get(0);
                sql=meta.getQuerySql();
            }else{
                throw new BusinessException(BusinessCode.CRUD_QUERY_FAILURE,"查找不到field对应的Meta");
            }
            //可循环滚动的rs
            Statement stmt = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int colunmCount = resultSetMetaData.getColumnCount();
            List<String> names=new ArrayList<>();
            for (int i = 0; i < colunmCount; i++) {
                String name=resultSetMetaData.getColumnName(i+1);
                name=resultSetMetaData.getColumnLabel(i+1);
                names.add(name);
            }
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }
}


