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
                                        @RequestParam(value = "identifier", required = false) String identifier) {
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
            StatisticsFieldModel statisticsField =
                    (StatisticsFieldModel) statisticsFieldService.getStatisticsFieldModel(fieldName, identifier);

            modelFields.add(statisticsField);
        }

        groupModel.setFields(modelFields);

        return SuccessTip.create(groupModel);
    }

    @ApiOperation("获取指定分组的统计数据")
    @GetMapping("/{group}/statistic")
    public Tip getStatisticFieldStatisticByGroup(@PathVariable String group,
                                                 @RequestParam(name = "identifier", required = false) String identifier) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        // group 内无法固定统计数据类型
        //if(type!=null && !StatisticData.checkStatisticType(type)){
        //    throw new BusinessException(BusinessCode.BadRequest.getCode(), "统计数据类型错误: select one in [total,rate,tuple,totalTimeline,rateTimeline,tupleTimeline] :" + type);
        //}
        List<StatisticsGroup> subgroups = statisticsGroupService.getGroupChildren(statisticsGroup.getId());
        if(subgroups==null || subgroups.size()==0){
            //TODO, handle sub groups
        }

        StatisticsGroupData groupModel = CRUD.castObject(statisticsGroup, StatisticsGroupData.class);

        //每个域的数据
        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());

        // result
        List<StatisticData> dataFields = new ArrayList<>();

        for(StatisticsField field : fields) {
            if(!StatisticData.checkStatisticPattern(field.getPattern())){
                throw new BusinessException(BusinessCode.BadRequest.getCode(), "统计数据模式错误: Select One in [Count,Rate,Tuple or combine with [Timeline,Cluster]] :" + field.getPattern());
            }

            String fieldName = field.getField();
            StatisticsFieldModel statisticsField = (StatisticsFieldModel) statisticsFieldService.getStatisticsFieldModel(fieldName, identifier);

            String pattern = field.getPattern();
            StatisticData statisticData = convertStatisticFieldModel(statisticsField, pattern);
            dataFields.add(statisticData);
        }

        groupModel.setFields(dataFields);

        return SuccessTip.create(groupModel);
    }

    private StatisticData convertStatisticFieldModel(StatisticsFieldModel fieldModel, String pattern) {

        StatisticData statistic = null;

        /// Count pattern
        if (StatisticData.STAT_PATTERN_COUNT.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticCount(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_COUNT_TIMELINE.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticCountTimeline(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_COUNT_CLUSTER.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticCountCluster(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_COUNT_TIMELINE_CLUSTER.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticCountTimelineCluster(fieldModel);
        }

        /// Rate pattern
        if (StatisticData.STAT_PATTERN_RATE.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticRate(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_RATE_TIMELINE.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticRateTimeline(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_RATE_CLUSTER.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticRateCluster(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_RATE_TIMELINE_CLUSTER.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticRateTimelineCluster(fieldModel);
        }

        /// Tuple pattern
        if (StatisticData.STAT_PATTERN_TUPLE.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticTuple(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_TUPLE_TIMELINE.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticTupleTimeline(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_TUPLE_CLUSTER.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticTupleCluster(fieldModel);
        }
        if (StatisticData.STAT_PATTERN_TUPLE_TIMELINE_CLUSTER.equals(pattern)) {
            statistic = StatisticConverter.convertStatisticTupleTimelineCluster(fieldModel);
        }

        return statistic;
    }
}