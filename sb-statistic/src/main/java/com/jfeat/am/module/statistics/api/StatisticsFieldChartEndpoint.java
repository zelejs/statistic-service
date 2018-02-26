package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.service.StatisticsChartService;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Silent-Y on 2017/10/16.
 */
@Api("统计 [Statistics]")
@RestController
@RequestMapping("/api/statistics/fields")
public class StatisticsFieldChartEndpoint extends BaseController {
    @Resource
    StatisticsFieldService statisticsFieldService;

    @Resource
    StatisticsChartService chartService;

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticField(@PathVariable String field) {
        return SuccessTip.create(statisticsFieldService.getFieldData(field));
    }


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
    @ApiOperation("获取指定数据域数据 [pie]")
    @GetMapping("/{field}/chart/pie")
    public Tip getPieData(@PathVariable String field) {
        return SuccessTip.create(chartService.getPieData(field));
    }


    /*柱状图数据结构
    "title":"柱状图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];*/
    @ApiOperation("获取指定数据域数据 [bar]")
    @GetMapping("/{field}/chart/bar")
    public Tip getBarData(@PathVariable String field) {
        return SuccessTip.create(chartService.getBarData(field));
    }


    /*折线图数据结构
    "title":"折线图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];*/
    @ApiOperation("获取指定数据域数据 [line]")
    @GetMapping("/{field}/chart/line")
    public Tip getLineData(@PathVariable String field) {
        return SuccessTip.create(chartService.getLineData(field));
    }
}
