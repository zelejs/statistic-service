package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2017-10-19
 */
@RestController
@RequestMapping("/api/adm/statistics/groups")
public class MaintenanceGroupEndpoint extends BaseController {

    @Resource
    StatisticsGroupService statisticsGroupService;

    /**
     * maintenance of group
     * @return
     */
    @ApiOperation("返回所有组")
    @GetMapping
    public Tip getAllStatisticsGroups(@RequestParam(required = false) String chart) {
        List<StatisticsGroup> groups = statisticsGroupService.getGroupTuples("chart", chart);
        return SuccessTip.create(groups);
    }

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
}
