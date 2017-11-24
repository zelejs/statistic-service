package com.jfeat.am.module.statistics.api;

import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticChartService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.service.StatisticChartService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticChart;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-24
 */
@RestController
@RequestMapping("/api/statistics/statistic-chart")
public class StatisticChartEndpoint extends BaseController {

    @Resource
    StatisticChartService statisticChartService;

    @Resource
    QueryStatisticChartService queryStatisticChartService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyStatisticChart() {
        return SuccessTip.create(new StatisticChart());
    }

    @GetMapping
    public Tip getStatisticChartList() {
        return SuccessTip.create(statisticChartService.retrieveMasterList());
    }

    @PostMapping
    public Tip createStatisticChart(@RequestBody StatisticChart entity) {
        return SuccessTip.create(statisticChartService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getStatisticChart(@PathVariable Long id) {
        return SuccessTip.create(statisticChartService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    public Tip updateStatisticChart(@PathVariable Long id, @RequestBody StatisticChart entity) {
        entity.setId(id);
        return SuccessTip.create(statisticChartService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticChart(@PathVariable Long id) {
        return SuccessTip.create(statisticChartService.deleteMaster(id));
    }

    @GetMapping
    public Tip queryStatisticCharts(Page<StatisticChart> page,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "field", required = false) String field,
                                    @RequestParam(name = "index", required = false) Integer index,
                                    @RequestParam(name = "invisible", required = false) Integer invisible,
                                    @RequestParam(name = "groupId", required = false) Long groupId,
                                    @RequestParam(name = "chart", required = false) String chart) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticChart statisticchart = new StatisticChart();
        statisticchart.setId(id);
        statisticchart.setName(name);
        statisticchart.setField(field);
        statisticchart.setIndex(index);
        statisticchart.setInvisible(invisible);
        statisticchart.setGroupId(groupId);
        statisticchart.setChart(chart);

        page.setRecords(queryStatisticChartService.findStatisticChartPage(page, statisticchart));

        return SuccessTip.create(page);
    }
}
