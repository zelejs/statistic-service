package com.jfeat.am.module.statistics.api.ut;

/**
 * Created by vincenthuang on 18/10/2017.
 */

import com.jfeat.am.base.BaseJunit;
import com.jfeat.am.module.statistics.services.crud.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.crud.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jackyhuang on 2017/10/16.
 */
public class StatisticChartTest extends BaseJunit {

    @Autowired
    StatisticsGroupService groupService;
    @Autowired
    StatisticsFieldService fieldService;
    @Autowired
    StatisticsRecordMapper recordMapper;

    //  数据域api
    StatisticsGroup statisticsGroup = new StatisticsGroup();
    StatisticsField statisticsField = new StatisticsField();
    StatisticsRecord statisticsRecord = new StatisticsRecord();

    @Before
    public void initData() {
        // define group
        statisticsGroup.setId(1l);
        statisticsGroup.setName("group1");
        statisticsGroup.setNote("test");
        groupService.createGroup(statisticsGroup);

        /// set field
        statisticsField.setGroupId(1l);
        statisticsField.setGroupName("Dashboard");
        statisticsField.setPattern("Count");
        statisticsField.setId(1l);
        statisticsField.setName("Done");
        statisticsField.setField("done_rate");
        statisticsField.setAttrInvisible(0);
        statisticsField.setAttrIndex(1);
        statisticsField.setChart("Pie");
        fieldService.createMaster(statisticsField);

        /// insert record
        statisticsRecord.setId(1l);
        statisticsRecord.setRecordName("rate");
        statisticsRecord.setRecordValue("0.75");
        statisticsRecord.setField("done_rate");
        statisticsRecord.setTimeline("M");
        statisticsRecord.setCreateTime(new Date());
        recordMapper.insert(statisticsRecord);
    }

    @Test
    public void testGetField() throws Exception {
        RequestBuilder request = get("/api/stat/fields/done_rate/statistic?type=total");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    //@Test
    public void testGetPieChartData() throws Exception {
        String field = "done_rate";
        RequestBuilder request = get("/api/stat/fields/done_rate/chart/pie");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    //@Test
    public void testGetLineChartData() throws Exception {
        String field = "done_rate";
        RequestBuilder request = get("/api/stat/fields/done_rate/chart/line");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }


    //@Test
    public void testGetGroupLineChartData() throws Exception {
        String field = "done_rate";
        RequestBuilder request = get("/api/stat/groups/rates/chart/line");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    //@Test
    public void testGetGroupFieldData() throws Exception {
        String identifier = "rates";
        RequestBuilder request = get("/api/stat/groups/rates/data");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }
}
