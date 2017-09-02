package com.jfeat.am.modular.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/statistic_records")
public class StatisticRecordEndpoint extends BaseController{

    @Resource
    StatisticRecordService statisticRecordService;

    @GetMapping("/{typeId}")
    public Tip getStatisticRecordByTypeIdAndStartTimeAndEndTime(@PathVariable long typeId,
                                   @RequestParam(name = "startTime",required = false,defaultValue = "null")String startTime,
                                   @RequestParam(name = "endTime",required = false,defaultValue = "null")String endTime){
        List<StatisticRecord> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(typeId, startTime, endTime);
        return SuccessTip.create(statisticRecords);
    }
}
