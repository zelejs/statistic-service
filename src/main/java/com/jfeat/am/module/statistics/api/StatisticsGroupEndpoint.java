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
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsGroupService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.crud.service.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;
import java.util.Date;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@Deprecated
@RestController
@RequestMapping("/api/statistics/statistics-group")
public class StatisticsGroupEndpoint extends BaseController {

    @Resource
    StatisticsGroupService statisticsGroupService;

    @Resource
    QueryStatisticsGroupService queryStatisticsGroupService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyStatisticsGroup() {
        return SuccessTip.create(new StatisticsGroup());
    }

    @PostMapping
    public Tip createStatisticsGroup(@RequestBody StatisticsGroup entity) {
        return SuccessTip.create(statisticsGroupService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getStatisticsGroup(@PathVariable Long id) {
        return SuccessTip.create(statisticsGroupService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    public Tip updateStatisticsGroup(@PathVariable Long id, @RequestBody StatisticsGroup entity) {
        entity.setId(id);
        return SuccessTip.create(statisticsGroupService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticsGroup(@PathVariable Long id) {
        return SuccessTip.create(statisticsGroupService.deleteMaster(id));
    }

    @GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryStatisticsGroups(Page<StatisticsGroup> page,
                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "id", required = false) Long id,
                                        @RequestParam(name = "name", required = false) String name,
                                            @RequestParam(name = "pid", required = false) Long pid,
                                        @RequestParam(name = "desc", required = false) String desc,
                                        @RequestParam(name = "chart", required = false) String chart) {
            page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticsGroup statisticsgroup = new StatisticsGroup();
            statisticsgroup .setId(id);
            statisticsgroup .setName(name);
            statisticsgroup .setPid(pid);
            statisticsgroup .setDesc(desc);
            statisticsgroup .setChart(chart);

        page.setRecords(queryStatisticsGroupService.findStatisticsGroupPage(page, statisticsgroup));

        return SuccessTip.create(page);
    }
}
