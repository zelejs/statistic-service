package com.jfeat.am.module.statistics.services.notify;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jfeat.am.core.support.DateTimeKit;
import com.jfeat.am.core.util.JsonKit;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsGroupMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordAttrMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Silent-Y on 2017/12/4.
 */
@Service
public class StatisticsNotifyServiceImpl implements StatisticsNotifyService {

    @Resource
    private StatisticsGroupMapper statisticsGroupMapper;
    @Resource
    private StatisticsFieldMapper statisticsFieldMapper;
    @Resource
    private StatisticsRecordMapper statisticsRecordMapper;
    @Resource
    private StatisticsRecordAttrMapper statisticsRecordAttrMapper;

    @Resource
    private StatisticsFieldService statisticsFieldService;
    @Resource
    private StatisticsRecordService statisticsRecordService;

    @Override
    @Transactional
    public Boolean insertStatisticRecord(StatisticsDataModel statisticsDataModel) {

        /// field value is settle down before data notify,
        /// below lines are not required

        /*String field = statisticsDataModel.getField().getField();
        StatisticsField statisticsField = new StatisticsField();
        statisticsField.setField(field);
        statisticsField = statisticsFieldMapper.selectOne(statisticsField);

        if (statisticsField == null) {
            statisticsField = statisticsDataModel.getField();
            statisticsField.setGroupId(statisticsGroup.getId());
            statisticsFieldMapper.insert(statisticsField);
        }

        String identifier = statisticsDataModel.getGroup().getIdentifier();
        StatisticsGroup statisticsGroup = new StatisticsGroup();
        statisticsGroup.setIdentifier(identifier);
        statisticsGroup = statisticsGroupMapper.selectOne(statisticsGroup);

        if (statisticsGroup == null){
            statisticsGroup = statisticsDataModel.getGroup();
            statisticsGroupMapper.insert(statisticsGroup);
        }


        for (StatisticsRecord statisticsRecord : statisticsDataModel.getRecords()) {
            statisticsRecord.setFieldId(statisticsField.getId());
            statisticsRecord.setField(statisticsField.getField());
            statisticsRecordMapper.insert(statisticsRecord);
            StatisticsRecordAttr statisticsRecordAttr = new StatisticsRecordAttr();
            statisticsRecordAttr.setLegend(statisticsRecord.getLegend());
            statisticsRecordAttr = statisticsRecordAttrMapper.selectOne(statisticsRecordAttr);
            if (statisticsRecordAttr == null){
                statisticsRecordAttr = new StatisticsRecordAttr();
                statisticsRecordAttr.setFieldId(statisticsField.getId());
                statisticsRecordAttr.setField(statisticsRecord.getField());
                statisticsRecordAttr.setRecordId(statisticsRecord.getId());
                statisticsRecordAttr.setLegend(statisticsRecord.getRecordName());
                statisticsRecordAttrMapper.insert(statisticsRecordAttr);
            }
        }*/

        return true;
    }


    @Resource
    StatisticsRecordService statisticRecordService;
    @Resource
    StatisticsFieldMapper statisticFieldMapper;

    @Transactional
    public boolean insertStatisticRecord(StatisticNotifyData statisticNotifyData) {

        List<Statistic> statisticList = statisticNotifyData.getValues();
        Long group = IdWorker.getId();

         /*

        //插入type
        TypeDefinition query = new TypeDefinition();
        query.setIdentifier(statisticNotifyData.getIdentifier());
        TypeDefinition typeDefinition = typeDefinitionMapper.selectOne(query);
        if (typeDefinition == null) {
            typeDefinition = new TypeDefinition();
            typeDefinition.setName(statisticNotifyData.getDefaultName());
            typeDefinition.setIdentifier(statisticNotifyData.getIdentifier());
            typeDefinitionMapper.insert(typeDefinition);
        }

        //插入field
        for (Statistic statistic : statisticList) {
            Integer count = statisticFieldMapper.selectCount(new EntityWrapper<StatisticField>().eq("type_id", typeDefinition.getId()).eq("name", statistic.getKey()));
            if (count < 1){
                StatisticField statisticField = new StatisticField();
                statisticField.setTypeId(typeDefinition.getId());
                statisticField.setName(statistic.getKey());
                statisticField.setDisplayName(statistic.getName());
                statisticFieldMapper.insert(statisticField);
            }
        }

        //插入record
        for (Statistic statistic : statisticList) {
            StatisticRecord statisticRecord = new StatisticRecord();
            statisticRecord.setRecordTime(statisticNotifyData.getRecordTime());
            statisticRecord.setTypeId(typeDefinition.getId());
            statisticRecord.setFieldName(statistic.getKey());
            statisticRecord.setValue(statistic.getValue());
            statisticRecord.setGroup(group);
            insert(statisticRecord);
        }
        */

        return true;
    }


    @Override
    public Map<String, Object> getEchartData(String field, String echart, String startTime,String endTime) {
        /*
            折线图数据结构
            "titile":"折线图数据结构",
            "timestamp":"数据生成时间",
            "type":"数据图描述类型",
            "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
            "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];
        */

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取前月的第一天
        Calendar cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());
        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
        String lastDay = format.format(cale.getTime());
        if (startTime == null){
            startTime = firstDay;
        }
        if (endTime == null){
            endTime = lastDay;
        }
        if (echart.equals("line")){
            StatisticsField statisticsField = statisticsFieldService.getFieldByFieldName(field);
            if(statisticsField!=null){
                List<StatisticsRecordAttr> statisticsRecordAttrs = statisticsRecordService.getRecordAttrByFieldId(statisticsField.getId());
                List<String> fields = statisticsRecordAttrs.stream().map(StatisticsRecordAttr::getField).collect(Collectors.toList());
                List<Map<String,Object>> maps = statisticsRecordService.getStatisticsRecordByFieldIdAndStartTimeAndEndTime(field, fields, startTime, endTime);
                Map<String,Object> result = Maps.newHashMap();
                List<String> dataAxis = Lists.newArrayList();
                List<String> data = Lists.newArrayList();
                String legend = "";
                for (Map map:maps){
                    if (map != null){
                        legend = map.get("legend").toString();
                    }
                    dataAxis.add(map.get("recordTime").toString());
                    data.add(map.get(field).toString());
                }
                result.put("title",legend);
                result.put("timestamp", DateTimeKit.formatDateTime(new Date()));
                result.put("type",echart);
                result.put("dataAxis",dataAxis);
                result.put("data",data);
                System.out.print(JsonKit.toJson(result));
                return result;
            }
//            throw new BusinessException(1017,"查不到该数据域！");
        }


    /*
    饼状图数据结构
    "titile":"饼状图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "data":[
    {value:335, name:'直接访问'},
    {value:310, name:'邮件营销'},
    {value:274, name:'联盟广告'},
    {value:235, name:'视频广告'},
    {value:400, name:'搜索引擎'}
    ]
    */
        if (echart.equals("pie")){

        }

    /*
    柱状图数据结构
    "titile":"柱状图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];
    */
        if (echart.equals("bar")){

        }
        return null;
    }
}
