package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.converter.StatisticConverter;
import com.jfeat.am.module.statistics.services.service.converter.statistic.StatisticData;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Silent-Y on 2017/10/16.
 */
@Api("统计 [Statistics]")
@RestController
@RequestMapping("/api/statistics/fields")
public class StatisticsFieldEndpoint extends BaseController {

    @Resource
    StatisticsFieldService statisticsFieldService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "[total,rate,tuple,totalTimeline,rateTimeline,tupleTimeline]", paramType = "query", dataType = "string")
    })
    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticField(@PathVariable String field,
                                 @RequestParam(name = "type", required = false, defaultValue = "1") String type) {
        if(!StatisticData.checkStatisticType(type)){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "统计数据类型错误:" + type);
        }

        Object statistic = statisticsFieldService.getStatisticsFieldModel(field);

        if(type!=null) {
            StatisticsFieldModel fieldModel = (StatisticsFieldModel) statistic;

            if (StatisticData.STAT_TYPE_TOTAL.equals(type)) {
                statistic = StatisticConverter.convertStatisticTotal(fieldModel);
            }
            if (StatisticData.STAT_TYPE_TOTAL_TIMELINE.equals(type)) {
                statistic = StatisticConverter.convertStatisticTotalTimeline(fieldModel);
            }
            if (StatisticData.STAT_TYPE_RATE.equals(type)) {
                statistic = StatisticConverter.convertStatisticRate(fieldModel);
            }
            if (StatisticData.STAT_TYPE_RATE_TIMELINE.equals(type)) {
                statistic = StatisticConverter.convertStatisticRateTimeline(fieldModel);
            }
            if (StatisticData.STAT_TYPE_TUPLE.equals(type)) {
                statistic = StatisticConverter.convertStatisticTuple(fieldModel);
            }
            if (StatisticData.STAT_TYPE_TUPLE_TIMELINE.equals(type)) {
                statistic = StatisticConverter.convertStatisticTupleTimeline(fieldModel);
            }
        }

        return SuccessTip.create(statistic);
    }
}
