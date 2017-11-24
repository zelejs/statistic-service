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
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticGroupService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.service.StatisticGroupService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticGroup;

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
@RequestMapping("/api/statistics/statistic-group")
public class StatisticGroupEndpoint extends BaseController {

    @Resource
    StatisticGroupService statisticGroupService;

    @Resource
    QueryStatisticGroupService queryStatisticGroupService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyStatisticGroup() {
        return SuccessTip.create(new StatisticGroup());
    }

    @GetMapping
    public Tip getStatisticGroupList() {
        return SuccessTip.create(statisticGroupService.retrieveMasterList());
    }

    @PostMapping
    public Tip createStatisticGroup(@RequestBody StatisticGroup entity) {
        return SuccessTip.create(statisticGroupService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getStatisticGroup(@PathVariable Long id) {
        return SuccessTip.create(statisticGroupService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    public Tip updateStatisticGroup(@PathVariable Long id, @RequestBody StatisticGroup entity) {
        entity.setId(id);
        return SuccessTip.create(statisticGroupService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticGroup(@PathVariable Long id) {
        return SuccessTip.create(statisticGroupService.deleteMaster(id));
    }

    @GetMapping
    public Tip queryStatisticGroups(Page<StatisticGroup> page,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "pid", required = false) Long pid,
                                    @RequestParam(name = "desc", required = false) String desc,
                                    @RequestParam(name = "chart", required = false) String chart) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticGroup statisticgroup = new StatisticGroup();
        statisticgroup.setId(id);
        statisticgroup.setName(name);
        statisticgroup.setPid(pid);
        statisticgroup.setDesc(desc);
        statisticgroup.setChart(chart);

        page.setRecords(queryStatisticGroupService.findStatisticGroupPage(page, statisticgroup));

        return SuccessTip.create(page);
    }
}
