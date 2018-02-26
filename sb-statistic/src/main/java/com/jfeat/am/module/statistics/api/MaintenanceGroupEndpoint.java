package com.jfeat.am.module.statistics.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.maintenance.dao.QueryStatisticsGroupDao;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2017-10-19
 */
@Api("统计 [Statistics]")
@RestController
@RequestMapping("/api/adm/statistics/groups")
public class MaintenanceGroupEndpoint extends BaseController {

    @Resource
    StatisticsGroupService statisticsGroupService;

    @Resource
    QueryStatisticsGroupDao queryStatisticsGroupDao;

    /**
     * maintenance of group
     * @return
     */
    /*@ApiOperation("返回所有组")
    @GetMapping
    public Tip getAllStatisticsGroups(@RequestParam(required = false) String chart) {
        List<StatisticsGroup> groups = statisticsGroupService.getGroupTuples("chart", chart);
        return SuccessTip.create(groups);
    }*/

    @ApiOperation("增加组")
    @PostMapping
    public Tip createConfigGroup(@RequestBody StatisticsGroup entity) {
        return SuccessTip.create(statisticsGroupService.createGroup(entity));
    }

    @ApiOperation("获取组")
    @GetMapping("/{id}")
    public Tip getConfigGroup(@PathVariable Long id) {
        return SuccessTip.create(statisticsGroupService.retrieveGroup(id));
    }

    @ApiOperation("修改组")
    @PutMapping("/{id}")
    public Tip updateConfigGroup(@PathVariable Long id, @RequestBody StatisticsGroup entity) {
        entity.setId(id);
        return SuccessTip.create(statisticsGroupService.updateGroup(entity));
    }

    @ApiOperation("删除组")
    @DeleteMapping("/{id}")
    public Tip deleteConfigGroup(@PathVariable Long id) {
        return SuccessTip.create(statisticsGroupService.deleteGroup(id));
    }

    @ApiOperation("分页返回所有数据组")
    @GetMapping
    public Tip queryStatisticsFields(Page<StatisticsGroup> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "chart", required = false) String chart,
                                     @RequestParam(name = "name", required = false) String name,
                                     @RequestParam(name = "desc", required = false) String desc,
                                     @RequestParam(name = "identifier", required = false) String identifier,
                                     @RequestParam(name = "index", required = false) Integer index,
                                     @RequestParam(name = "pid", required = false) Long pid) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        StatisticsGroup statisticsGroup = new StatisticsGroup();
        statisticsGroup.setName(name);
        statisticsGroup.setChart(chart);
        statisticsGroup.setDescription(desc);
        statisticsGroup.setIdentifier(identifier);
        statisticsGroup.setPid(pid);
        statisticsGroup.setIndex(index);

        page.setRecords(queryStatisticsGroupDao.findStatisticsGroupPage(page, statisticsGroup));
        return SuccessTip.create(page);
    }
}
