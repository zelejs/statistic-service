package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.crud.CRUD;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.crud.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.crud.StatisticsGroupByService;
import com.jfeat.am.module.statistics.services.crud.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.crud.converter.StatisticConverter;
import com.jfeat.am.module.statistics.services.crud.converter.statistic.StatisticData;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsGroupModel;
import com.jfeat.am.module.statistics.services.domain.model.StatisticsGroupData;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@Api("统计 [Statistics]")
@RestController
@RequestMapping("/api/stat/groups")
public class StatisticsGroupEndpoint extends BaseController {

    @Resource
    StatisticsGroupService statisticsGroupService;
    @Resource
    StatisticsGroupByService statisticsGroupByService;

    @Resource
    StatisticsFieldService statisticsFieldService;

    @ApiOperation("获取指定分组的统计域")
    @GetMapping("/{group}")
    public Tip getStatisticFieldByGroup(@PathVariable String group,
                                        @RequestParam("identifier") String identifier) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        StatisticsGroupModel groupModel = CRUD.castObject(statisticsGroup, StatisticsGroupModel.class);

        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());

        //每个域的数据
        List<StatisticsField> modelFields = new ArrayList<>();

        for(StatisticsField field : fields) {
            String fieldName = field.getField();
            StatisticsFieldModel statisticsField = (StatisticsFieldModel) statisticsFieldService.getStatisticsFieldModel(fieldName, identifier);

            modelFields.add(statisticsField);
        }

        groupModel.setFields(modelFields);

        return SuccessTip.create(groupModel);
    }

    @ApiOperation("获取指定分组的统计数据")
    @GetMapping("/{group}/statistic")
    public Tip getStatisticFieldStatisticByGroup(@PathVariable String group,
                                                 @RequestParam(name = "type", required = true, defaultValue = "total") String type,
                                                 @RequestParam(name = "identifier", required = false) String identifier) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        if(type!=null && !StatisticData.checkStatisticType(type)){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "统计数据类型错误: select one in [total,rate,tuple,totalTimeline,rateTimeline,tupleTimeline] :" + type);
        }

        StatisticsGroupData groupModel = CRUD.castObject(statisticsGroup, StatisticsGroupData.class);

        //每个域的数据
        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());

        // result
        List<StatisticData> dataFields = new ArrayList<>();

        for(StatisticsField field : fields) {
            String fieldName = field.getField();
            StatisticsFieldModel statisticsField = (StatisticsFieldModel) statisticsFieldService.getStatisticsFieldModel(fieldName, identifier);

            StatisticData statisticData = convertStatisticFieldModel(statisticsField, type);
            dataFields.add(statisticData);
        }

        groupModel.setFields(dataFields);

        return SuccessTip.create(groupModel);
    }

    private StatisticData convertStatisticFieldModel(StatisticsFieldModel fieldModel, String type) {

        StatisticData statistic = null;

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

        return statistic;
    }
}