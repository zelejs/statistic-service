package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@RestController
@RequestMapping("/api/statistics/fields")
public class StatisticsFieldEndpoint extends BaseController {

    @Resource
    StatisticsFieldService statisticsFieldService;

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticField(@PathVariable String field) {
        return SuccessTip.create(statisticsFieldService.getFieldData(field));
    }
}