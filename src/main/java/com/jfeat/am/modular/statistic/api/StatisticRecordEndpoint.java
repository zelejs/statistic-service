package com.jfeat.am.modular.statistic.api;

import com.google.common.collect.Lists;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.persistence.model.StatisticField;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.core.support.DateTimeKit;
import com.jfeat.am.modular.statistic.constant.StatisticPermission;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/adm/statistic_records")
public class StatisticRecordEndpoint extends BaseController{

    @Resource
    StatisticRecordService statisticRecordService;
    @Resource
    StatisticFieldService statisticFieldService;

    @GetMapping("/{typeId}")
    @Permission(StatisticPermission.STATISTIC_VIEW)
    public Tip getStatisticRecordByTypeIdAndStartTimeAndEndTime(@PathVariable long typeId,@RequestParam(required = false)String startTime, @RequestParam(required = false)String endTime){
//        获取fields
        List<StatisticField> statisticFields = statisticFieldService.getStatisticFieldByTypeId(typeId);
        List<String> fields = Lists.newArrayList();
        for (StatisticField statisticField:statisticFields){
            String field = statisticField.getName();
            fields.add(field);
        }
        if (startTime == null && endTime != null){
            /*Calendar lastMonth = Calendar.getInstance();
            lastMonth.add(Calendar.MONTH,-1);
            String startTimeNew = lastMonth.getTime().toString();*/
            String startTimeNew = DateTimeKit.lastMouth().toString();

            List<Map<String,String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(fields, startTimeNew, endTime);
            return SuccessTip.create(statisticRecords);
        }
        if (startTime != null && endTime == null){
            /*Calendar today = Calendar.getInstance();
            String endTimeNew = today.getTime().toString();*/
            String endTimeNew = new Date().toString();

            List<Map<String,String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(fields, startTime, endTimeNew);
            return SuccessTip.create(statisticRecords);
        }
        if (startTime == null && endTime == null){

   /*         Calendar lastMonth = Calendar.getInstance();
            lastMonth.add(Calendar.MONTH,-1);
            String startTimeNew = lastMonth.getTime().toString();
            Calendar today = Calendar.getInstance();
            String endTimeNew = today.getTime().toString();

            System.out.print(today.getTime());
            Date todayNew = today.getTime();
            System.out.print(todayNew);*/
            String startTimeNew = DateTimeKit.lastMouth().toString();
            String endTimeNew = new Date().toString();

            List<Map<String,String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(fields, startTimeNew, endTimeNew);
            return SuccessTip.create(statisticRecords);
        }
        List<Map<String,String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(fields, startTime, endTime);
        return SuccessTip.create(statisticRecords);
    }
}
