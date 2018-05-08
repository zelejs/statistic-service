package com.jfeat.am.module.statistics.services.service.impl;

import com.google.common.collect.Lists;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.core.support.DateTimeKit;
import com.jfeat.am.module.statistics.api.bean.BarChartBean;
import com.jfeat.am.module.statistics.api.bean.LineChartBean;
import com.jfeat.am.module.statistics.api.bean.PieChartBean;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.service.StatisticsChartService;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordService;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Silent-Y on 2017/12/4.
 */
@Service
public class StatisticsChartServiceImpl implements StatisticsChartService {

    @Resource
    private StatisticsFieldService statisticsFieldService;
    @Resource
    private StatisticsRecordService statisticsRecordService;


    /*饼状图数据结构
    "title":"饼状图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "data":[
    {value:335, name:'直接访问'},
    {value:310, name:'邮件营销'},
    {value:274, name:'联盟广告'},
    {value:235, name:'视频广告'},
    {value:400, name:'搜索引擎'}
    ]*/
    @Override
    public PieChartBean getPieData(String field){
        PieChartBean pieChartBean = new PieChartBean();
        pieChartBean.setData(new ArrayList<>());

        StatisticsFieldModel fieldModel = statisticsFieldService.getFieldModel(field);
        if(fieldModel.getInvisible()==1){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "Current field is invisible");
        }
        pieChartBean.setTitle(fieldModel.getName());
        pieChartBean.setTimestamp(DateTimeKit.formatDateTime(new Date()));

        if(fieldModel.getItems()==null){
            fieldModel.setItems(new ArrayList<>());
        }

        /// convert data
        List<PieChartBean.KeyValue> data = pieChartBean.getData();
        for (StatisticsRecord record : fieldModel.getItems()) {

            PieChartBean.KeyValue keyValue = new PieChartBean.KeyValue();
            keyValue.setName(record.getRecordName());
            keyValue.setValue(record.getRecordValue());

            data.add(keyValue);
        }

        return pieChartBean;
    }


    /*折线图数据结构
    "title":"折线图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];*/
    @Override
    public LineChartBean getLineData(String field) {
        LineChartBean lineChartBean = new LineChartBean();
        lineChartBean.setData(new ArrayList<>());
        lineChartBean.setDataAxis(new ArrayList<>());

        StatisticsFieldModel fieldModel = statisticsFieldService.getFieldModel(field);
        if(fieldModel.getInvisible()==1){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "Current field is invisible");
        }
        lineChartBean.setTitle(fieldModel.getName());
        lineChartBean.setTimestamp(DateTimeKit.formatDateTime(new Date()));

        if(fieldModel.getItems()==null){
            fieldModel.setItems(new ArrayList<>());
        }

        /// convert to chart data
        List<String> data = lineChartBean.getData();
        List<String> dataAxis = lineChartBean.getDataAxis();
        for (StatisticsRecord record : fieldModel.getItems()) {
            data.add(record.getRecordValue());
            dataAxis.add(record.getRecordName());
        }

        return lineChartBean;
    }



    /*柱状图数据结构
    "title":"柱状图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];*/
    @Override
    public BarChartBean getBarData(String field) {
        BarChartBean barChartBean = new BarChartBean();
        barChartBean.setData(new ArrayList<>());
        barChartBean.setDataAxis(new ArrayList<>());


        StatisticsFieldModel fieldModel = statisticsFieldService.getFieldModel(field);
        if(fieldModel.getInvisible()==1){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "Current field is invisible");
        }
        barChartBean.setTitle(fieldModel.getName());
        barChartBean.setTimestamp(DateTimeKit.formatDateTime(new Date()));

        if(fieldModel.getItems()==null){
            fieldModel.setItems(new ArrayList<>());
        }

        /// convert to chart data
        List<String> data = barChartBean.getData();
        List<String> dataAxis = barChartBean.getData();
        for (StatisticsRecord record : fieldModel.getItems()) {
            data.add(record.getRecordValue());
            dataAxis.add(record.getRecordName());
        }

        return barChartBean;
    }



    /*折线图数据结构
        "title":"折线图",
        "timestamp":"数据生成时间",
        "type":"数据图描述类型[line]",
        "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
        "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];
    */
    @Deprecated
    public Map<String, Object> getStatisticLineData(String field, String startTime, String endTime) {
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

        StatisticsField statisticsField = statisticsFieldService.getFieldByFieldName(field);
        if(statisticsField==null){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "Invalid field name: " + field);
        }

        ///
        LineChartBean lineChartBean = new LineChartBean();
        List<String> dataAxis = Lists.newArrayList();
        List<String> data = Lists.newArrayList();

        /*for (Map map:maps){
            dataAxis.add(map.get("recordTime").toString());
            data.add(map.get(field).toString());
        }*/

        lineChartBean.setTitle(statisticsField.getName());
        lineChartBean.setTimestamp(DateTimeKit.formatDateTime(new Date()));
        lineChartBean.setDataAxis(dataAxis);
        lineChartBean.setData(data);


        /*
        if (echart.equals("line")){
            StatisticsField statisticsField = statisticsFieldService.getFieldByFieldName(field);
            if(statisticsField!=null){
                List<StatisticsRecordAttr> statisticsRecordAttrs = statisticsRecordService.getRecordAttrByField(statisticsField.getField());
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
        }*/

        return null;
    }
}
