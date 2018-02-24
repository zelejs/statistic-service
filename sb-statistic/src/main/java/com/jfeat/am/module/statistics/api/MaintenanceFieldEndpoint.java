package com.jfeat.am.module.statistics.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.maintenance.dao.QueryStatisticsFieldDao;
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

    @Resource
    private QueryStatisticsFieldDao statisticsFieldDao;

    /*@ApiOperation("返回所有图表数据域")
    @GetMapping("/all/")
    public Tip getAllStatisticsFields(@RequestParam(required = false) String chart) {
        if (chart != null) {
            return SuccessTip.create(statisticsFieldService.getFieldListByChart(chart));
        }
        return SuccessTip.create(statisticsFieldService.retrieveMasterList());
    }*/

    @ApiOperation("设置数据据域分组 [转移数据域至其他分组]")
    @PostMapping("/{id}/assignTo/{groupId}")
    public Tip createStatisticsField(@PathVariable Long id, @PathVariable Long groupId) {
        StatisticsField entity = new StatisticsField();
        entity.setId(id);
        entity.setGroupId(groupId);
        return SuccessTip.create(statisticsFieldService.updateMaster(entity));
    }

    @ApiOperation("获取数据域")
    @GetMapping("/{id}")
    public Tip getStatisticsField(@PathVariable Long id) {
        return SuccessTip.create(statisticsFieldService.retrieveMaster(id));
    }

    @ApiOperation("修改数据域")
    @PutMapping("/{id}")
    public Tip updateStatisticsField(@PathVariable Long id, @RequestBody StatisticsField entity) {
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


    @ApiOperation("分页返回所有图表数据域")
    @GetMapping
    public Tip queryStatisticsFields(Page<StatisticsField> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "field", required = false) String field,
                                     @RequestParam(name = "name", required = false) String name,
                                     @RequestParam(name = "index", required = false) Integer index,
                                     @RequestParam(name = "groupId", required = false) Long groupId,
                                     @RequestParam(name = "invisible", required = false) Integer invisible,
                                     @RequestParam(name = "chart", required = false) String chart,
                                     @RequestParam(name = "percent", required = false) Integer percent) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        StatisticsField statisticsField = new StatisticsField();
        statisticsField.setField(field);
        statisticsField.setIndex(index);
        statisticsField.setGroupId(groupId);
        statisticsField.setInvisible(invisible);
        statisticsField.setChart(chart);
        statisticsField.setPercent(percent);
        statisticsField.setName(name);

        page.setRecords(statisticsFieldDao.findStatisticsFieldPage(page, statisticsField));
        return SuccessTip.create(page);
    }
}
