package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-10-19
 */
@RestController
@RequestMapping("/api/adm/statistics/fields")
public class MaintenanceFieldEndpoint extends BaseController {

    @Resource
    private StatisticsFieldService statisticsFieldService;

    @ApiOperation("返回所有图表数据域")
    @GetMapping
    public Tip getAllStatisticsFields(@RequestParam(required = false) String chart) {
        if (chart != null) {
            return SuccessTip.create(statisticsFieldService.getFieldListByChart(chart));
        }
        return SuccessTip.create(statisticsFieldService.retrieveMasterList());
    }

    @ApiOperation("设置数据据域分组")
    @PostMapping("/{id}/assignTo/{groupId}")
    public Tip createConfigField(@PathVariable Long id, @PathVariable Long groupId) {
        StatisticsField entity = new StatisticsField();
        entity.setId(id);
        entity.setGroupId(groupId);
        return SuccessTip.create(statisticsFieldService.updateMaster(entity));
    }

    @ApiOperation("获取数据域")
    @GetMapping("/{id}")
    public Tip getConfigField(@PathVariable Long id) {
        return SuccessTip.create(statisticsFieldService.retrieveMaster(id));
    }

    @ApiOperation("修改数据域")
    @PutMapping("/{id}")
    public Tip updateConfigField(@PathVariable Long id, @RequestBody StatisticsField entity) {
        entity.setId(id);
        return SuccessTip.create(statisticsFieldService.updateMaster(entity));
    }

    @ApiOperation("使数据域可见")
    @PostMapping("/{id}/visible")
    public Tip setFieldVisible(@PathVariable Long id) {
        return SuccessTip.create(statisticsFieldService.deleteMaster(id));
    }

    @ApiOperation("使数据域不可见")
    @PostMapping("/{id}/invisible")
    public Tip setFieldInVisible(@PathVariable Long id) {
        return SuccessTip.create(statisticsFieldService.deleteMaster(id));
    }
}