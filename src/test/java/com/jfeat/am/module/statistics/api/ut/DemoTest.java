package com.jfeat.am.module.statistics.api.ut;

/**
 * Created by vincenthuang on 18/10/2017.
 */

import com.jfeat.am.base.BaseJunit;
import com.jfeat.am.core.util.JsonKit;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jackyhuang on 2017/10/16.
 */
public class DemoTest extends BaseJunit {

    @Autowired
    StatisticsRecordAttrService statisticsRecordAttrService;
    @Autowired
    StatisticsRecordMapper statisticsRecordMapper;
    @Autowired
    StatisticsFieldMapper statisticsFieldMapper;

    StatisticsRecordAttr statisticsRecordAttr = new StatisticsRecordAttr();
    StatisticsRecord statisticsRecord = new StatisticsRecord();
    StatisticsField statisticsField = new StatisticsField();

    @Before
    public void initData() {
        statisticsRecord.setId(1l);
        statisticsRecord.setAttrId(1l);
        statisticsRecord.setField("文件");
        statisticsRecord.setFieldId(1l);
        statisticsRecord.setRecordName("记录名称");
        statisticsRecord.setLegend("图里名称");
        statisticsRecord.setMonthName("月份名称");
        statisticsRecord.setRecordTime(new Date());
        statisticsRecord.setRecordValue("值");
        statisticsRecordMapper.insert(statisticsRecord);
        statisticsRecordAttr.setId(1l);
        statisticsRecordAttr.setIndex(1);
        statisticsRecordAttr.setLegend("图例名称");
        statisticsRecordAttr.setRecordId(1l);
        statisticsRecordAttrService.createMaster(statisticsRecordAttr);
        statisticsField.setField("文件");
        statisticsField.setIndex(1);
        statisticsField.setChart("图表名称");
        statisticsField.setIndex(1);
        statisticsField.setGroupId(1l);
        statisticsField.setInvisible(1);
        statisticsField.setName("名称");
        statisticsField.setPercent(1);
        statisticsField.setId(1l);
        statisticsFieldMapper.insert(statisticsField);

    }

    //    获取所有属性记录
    @Test
    public void testGetAttrs() throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/records/attrs");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    //    修改记录
    @Test
    public void testPutAttrs() throws Exception {
        String json = "";
        RequestBuilder request = put("/api/adm/statistics/records/1/attr").content(JsonKit.toJson(statisticsRecordAttr));
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    //    获取记录及其属性 500
    @Test
    public void testGetRecordAttrs() throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/records/1");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    //    返回所有记录
    @Test
    public void testGetRecords() throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/records");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    /*//    获取指定数据域数据
    @Test
    public void testGetFields() throws Exception {
        String json = "";
        RequestBuilder request = get("/api/statistics/fields/文件");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    //    获取指定分组标识的数据域组 The database has been closed
    @Test
    public void testGetData() throws Exception {
        String json = "";
        RequestBuilder request = get("/groups/brotherNum/data");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }*/



}
