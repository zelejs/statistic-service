package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.definition.Schemas;
import com.jfeat.am.module.statistics.services.statistic.service.StatisticsFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticField(@PathVariable String field) {

        StatisticsField fieldResult = null;

        StatisticsField statisticsField = statisticsFieldService.getFieldByFieldName(field);

        String schema  = statisticsField.getSchema();

        if(Schemas.amount.toString().equals(schema)){
            fieldResult =  statisticsFieldService.getFieldAmount(field);

        }else if(Schemas.rate.toString().equals(schema)){
            fieldResult =  statisticsFieldService.getFieldAmount(field);

        }else if(Schemas.tupe.toString().equals(schema)){
            fieldResult =  statisticsFieldService.getFieldTuple(field);

        }else if(Schemas.cluster.toString().equals(schema)){
            fieldResult =  statisticsFieldService.getFieldCluster(field);
        }

        return SuccessTip.create(fieldResult);
    }

}
