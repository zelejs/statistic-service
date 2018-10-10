package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.crud.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.crud.converter.StatisticConverter;
import com.jfeat.am.module.statistics.services.crud.converter.statistic.StatisticData;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
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
@RequestMapping("/api/stat/fields")
public class StatisticsFieldEndpoint extends BaseController {

    @Resource
    StatisticsFieldService statisticsFieldService;

    //@Resource
    //GeneralStatisticService generalStatisticService;

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticFieldRaw(@PathVariable String field) {
        StatisticsField statisticsField = statisticsFieldService.getStatisticsFieldModel(field, null);
        return SuccessTip.create(statisticsField);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "[total,rate,tuple,totalTimeline,rateTimeline,tupleTimeline]", paramType = "query", dataType = "string")
    })
    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}/statistic")
    public Tip getStatisticField(@PathVariable String field,
                                 @RequestParam(name = "type", required = false, defaultValue = "1") String type) {
        if(type!=null && !StatisticData.checkStatisticType(type)){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "统计数据类型错误: select one in [total,rate,tuple,totalTimeline,rateTimeline,tupleTimeline] :" + type);
        }

        StatisticsField statisticsField = statisticsFieldService.getStatisticsFieldModel(field, null);

        Object statistic = null;

        if(type!=null) {
            if(statisticsField instanceof StatisticsFieldModel) {
                StatisticsFieldModel fieldModel = (StatisticsFieldModel) statisticsField;

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
            }//else if(statisticsField.getQuerySql()!=null){
                //TODO, 考虑StatisticData 与 statement 中的 StatisticRate 区别
            //}
            else{
                throw new BusinessException(BusinessCode.BadRequest.getCode(), "无效的统计域，请检查统计域的querySql字段");
            }
        }

        return SuccessTip.create(statistic);
    }
}
