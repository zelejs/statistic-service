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
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticLegendService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.service.StatisticLegendService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticLegend;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;
import java.util.Date;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-24
 */
@RestController
@RequestMapping("/api/statistics/statistic-legend")
public class StatisticLegendEndpoint extends BaseController {

    @Resource
    StatisticLegendService statisticLegendService;

    @Resource
    QueryStatisticLegendService queryStatisticLegendService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyStatisticLegend() {
        return SuccessTip.create(new StatisticLegend());
    }

    @GetMapping
    public Tip getStatisticLegendList() {
        return SuccessTip.create(statisticLegendService.retrieveMasterList());
    }

    @PostMapping
    public Tip createStatisticLegend(@RequestBody StatisticLegend entity) {
        return SuccessTip.create(statisticLegendService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getStatisticLegend(@PathVariable Long id) {
        return SuccessTip.create(statisticLegendService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    public Tip updateStatisticLegend(@PathVariable Long id, @RequestBody StatisticLegend entity) {
        entity.setId(id);
        return SuccessTip.create(statisticLegendService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticLegend(@PathVariable Long id) {
        return SuccessTip.create(statisticLegendService.deleteMaster(id));
    }

    @GetMapping
    public Tip queryStatisticLegends(Page<StatisticLegend> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "id", required = false) Long id,
                                     @RequestParam(name = "field", required = false) String field,
                                     @RequestParam(name = "legend", required = false) String legend,
                                     @RequestParam(name = "legendKey", required = false) String legendKey,
                                     @RequestParam(name = "legendValue", required = false) String legendValue,
                                     @RequestParam(name = "index", required = false) Integer index,
                                     @RequestParam(name = "recordTime", required = false) Date recordTime,
                                     @RequestParam(name = "monthName", required = false) String monthName) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticLegend statisticlegend = new StatisticLegend();
        statisticlegend.setId(id);
        statisticlegend.setField(field);
        statisticlegend.setLegend(legend);
        statisticlegend.setLegendKey(legendKey);
        statisticlegend.setLegendValue(legendValue);
        statisticlegend.setIndex(index);
        statisticlegend.setRecordTime(recordTime);
        statisticlegend.setMonthName(monthName);

        page.setRecords(queryStatisticLegendService.findStatisticLegendPage(page, statisticlegend));

        return SuccessTip.create(page);
    }
}
