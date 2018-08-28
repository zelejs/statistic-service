package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.crud.CRUD;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.chart.model.*;
import com.jfeat.am.module.statistics.services.chart.service.StatisticsChartService;
import com.jfeat.am.module.statistics.services.crud.StatisticsGroupByService;
import com.jfeat.am.module.statistics.services.crud.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsGroupModel;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/api/statistics/groups")
public class StatisticsGroupEndpoint extends BaseController {

    @Resource
    StatisticsGroupService statisticsGroupService;
    @Resource
    StatisticsGroupByService statisticsGroupByService;


    @Resource
    StatisticsChartService chartService;

    @ApiOperation("获取指定分组标识的数据域组")
    @GetMapping("/{group}")
    public Tip getStatisticFieldByGroup(@PathVariable String group) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        //JSONObject groupData = statisticsGroupByService.groupBy("group_id");
        StatisticsGroupModel groupModel = CRUD.castObject(statisticsGroup, StatisticsGroupModel.class);
        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());
        groupModel.setFields(fields);

        return SuccessTip.create(groupModel);
    }

    @ApiOperation("获取指定分组标识的数据域组 [pie]")
    @GetMapping("/{group}/chart/pie")
    public Tip getStatisticChartPieByGroup(@PathVariable String group) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "Invalid group identifier");
        }

        GroupPieChartData groupPieChartBean = CRUD.castObject(statisticsGroup, GroupPieChartData.class);

        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());
        if(fields==null || fields.size()==0){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "No items in the group");
        }


        List<PieChartData> items = new ArrayList<>();

        for(StatisticsField field : fields){
            PieChartData bean = chartService.getPieData(field.getField());
            items.add(bean);
        }

        groupPieChartBean.setItems(items);

        return SuccessTip.create(groupPieChartBean);
    }

    @ApiOperation("获取指定分组标识的数据域组 [bar]")
    @GetMapping("/{group}/chart/bar")
    public Tip getStatisticChartBarByGroup(@PathVariable String group) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "Invalid group identifier");
        }

        GroupBarChartData groupBarChartBean = CRUD.castObject(statisticsGroup, GroupBarChartData.class);

        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());
        if(fields==null || fields.size()==0){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "No items in the group");
        }


        List<BarChartData> items = new ArrayList<>();

        for(StatisticsField field : fields){
            BarChartData bean = chartService.getBarData(field.getField());
            items.add(bean);
        }

        groupBarChartBean.setItems(items);

        return SuccessTip.create(groupBarChartBean);
    }

    @ApiOperation("获取指定分组标识的数据域组 [line]")
    @GetMapping("/{group}/chart/line")
    public Tip getStatisticChartLineByGroup(@PathVariable String group) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "Invalid group identifier");
        }

        GroupLineChartData groupLineChartBean = CRUD.castObject(statisticsGroup, GroupLineChartData.class);

        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());
        if(fields==null || fields.size()==0){
            throw new BusinessException(BusinessCode.BadRequest.getCode(), "No items in the group");
        }


        List<LineChartData> items = new ArrayList<>();

        for(StatisticsField field : fields){
            LineChartData bean = chartService.getLineData(field.getField());
            items.add(bean);
        }

        groupLineChartBean.setItems(items);

        return SuccessTip.create(groupLineChartBean);
    }
}