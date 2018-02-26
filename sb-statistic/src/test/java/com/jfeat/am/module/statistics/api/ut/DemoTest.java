package com.jfeat.am.module.statistics.api.ut;

/**
 * Created by vincenthuang on 18/10/2017.
 */

import com.jfeat.am.base.BaseJunit;
import com.jfeat.am.core.util.JsonKit;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrService;
import com.jfeat.am.module.statistics.services.service.definition.Charts;
import com.jfeat.am.module.statistics.services.service.definition.StatisticsPeriods;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jackyhuang on 2017/10/16.
 */
public class DemoTest extends BaseJunit {

    @Autowired
    StatisticsGroupService groupService;
    @Autowired
    StatisticsFieldService fieldService;
    @Autowired
    StatisticsRecordMapper recordMapper;
    @Autowired
    StatisticsRecordAttrService attrService;

    //  数据域api
    StatisticsGroup statisticsGroup = new StatisticsGroup();
    StatisticsField statisticsField = new StatisticsField();

    StatisticsRecord statisticsRecord = new StatisticsRecord();
    StatisticsRecordAttr statisticsRecordAttr = new StatisticsRecordAttr();

    @Before
    public void initData() {
        // define group
        statisticsGroup.setId(1l);
        statisticsGroup.setName("group1");
        statisticsGroup.setChart(Charts.pie.toString());
        statisticsGroup.setDescription("test");
        statisticsGroup.setIdentifier("rates");
        groupService.createGroup(statisticsGroup);

        /// set field
        statisticsField.setGroupId(1l);
        statisticsField.setId(1l);
        statisticsField.setName("Done");
        statisticsField.setField("done_rate");
        statisticsField.setInvisible(0);
        statisticsField.setPercent(1);
        statisticsField.setIndex(1);
        statisticsField.setChart("Pie");
        fieldService.createMaster(statisticsField);

        /// insert record
        statisticsRecord.setId(1l);
        statisticsRecord.setRecordName("rate");
        statisticsRecord.setRecordValue("0.75");
        statisticsRecord.setFieldId(1l);
        statisticsRecord.setField("done_rate");
        statisticsRecord.setPeriod(StatisticsPeriods.Month.toString());
        statisticsRecord.setRecordTime(new Date());
        recordMapper.insert(statisticsRecord);

        // attr
        statisticsRecordAttr.setId(1l);
        statisticsRecordAttr.setLegend("完成率");
        statisticsRecordAttr.setField("done_rate");
        statisticsRecordAttr.setRecordName("rate");
        attrService.createMaster(statisticsRecordAttr);
    }

    @Test
    public void testGetField() throws Exception {
        RequestBuilder request = get("/api/statistics/fields/done_rate");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetGroupFieldData() throws Exception {
        String identifier = "rates";
        RequestBuilder request = get("/api/statistics/groups/rates/data");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetPieChartData() throws Exception {
        String field = "done_rate";
        RequestBuilder request = get("/api/statistics/fields/done_rate/chart/pie");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetLineChartData() throws Exception {
        String field = "done_rate";
        RequestBuilder request = get("/api/statistics/fields/done_rate/chart/line");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetGroupLineChartData() throws Exception {
        String field = "done_rate";
        RequestBuilder request = get("/api/statistics/groups/rates/chart/line");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

}
