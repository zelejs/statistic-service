package com.jfeat.am.module.statistics.api.ut;

/**
 * Created by vincenthuang on 18/10/2017.
 */

import com.jfeat.am.base.BaseJunit;
import com.jfeat.am.core.util.JsonKit;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jackyhuang on 2017/10/16.
 */
public class DemoTest extends BaseJunit {

    @Autowired
    StatisticsFieldService statisticsFieldService;
    @Autowired
    StatisticsFieldMapper statisticsFieldMapper;

//    数据域api
    StatisticsField statisticsField = new StatisticsField();
    StatisticsGroup statisticsGroup = new StatisticsGroup();
    StatisticsRecord statisticsRecord = new StatisticsRecord();
    StatisticsRecordAttr statisticsRecordAttr = new StatisticsRecordAttr();
    @Before
    public void initData() {
   /*     statisticsField.setId(1l);
        statisticsField.setName("werqer");
        statisticsField.setInvisible(1);
        statisticsField.setPercent(1);
        statisticsField.setIndex(1);
        statisticsField.setChart("asdfad");
        statisticsFieldMapper.insert(statisticsField);

        statisticsGroup.setId(1l);
        statisticsGroup.setName("asdfasdf");
        statisticsGroup.setChart("adfasdfsd");
        statisticsGroup.setDescription("adsfasdf");
        statisticsGroup.setIdentifier("adfasdfas");
        statisticsGroup.setPid(1l);
        statisticsGroup.setSort(1);
*/
    }

    @Test
    public void testGetFields()  throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/fields");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testPostAssignTo()  throws Exception {
        String json = "";
        RequestBuilder request = post("/api/adm/statistics/fields/1/assignTo/1");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testGetField()  throws Exception {
        String json = "";
        RequestBuilder request = get("/api/statistics/fields/plan/equipmentFailureRate");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testPutField()  throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/fields").content(JsonKit.toJson(statisticsField));
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testPostFieldVisible()  throws Exception {
        String json = "";
        RequestBuilder request = post("/api/adm/statistics/fields/1/visible");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testPostField()  throws Exception {
        String json = "";
        RequestBuilder request = post("/api/adm/statistics/fields/1/invisible");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

//    组api

//    返回所有组有问题，为什么要根据字段去选择？SELECT  id,name,identifier,pid,desc,sort,chart  FROM st_statistics_group WHERE  (chart = ?)
    @Test
    public void testGetGroups()  throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/groups");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

//    增加组 INSERT INTO st_statistics_group( id,name,identifier,pid,desc,sort,chart )  VALUES( ?,?,?,?,?,?,? )
    @Test
    public void testPostGroups()  throws Exception {
        String json = "";
        RequestBuilder request = post("/api/adm/statistics/groups").content(JsonKit.toJson(statisticsGroup));
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

//    获取组
    @Test
    public void testGetGroup()  throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/groups/1");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

//    修改组
    @Test
    public void testPutGroup()  throws Exception {
        String json = "";
        RequestBuilder request = get("/api/adm/statistics/groups/1");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

}
