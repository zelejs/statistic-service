package com.jfeat.am.module.statistics.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.maintenance.dao.QueryStatisticsRecordAttrDao;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrChildService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 *  记录不能修改，仅提供其属性修改API
 *
 * @author Code Generator
 * @since 2017-10-19
 */
@RestController
@RequestMapping("/api/adm/statistics/records")
public class MaintenanceRecordEndpoint extends BaseController {

    @Resource
    private StatisticsRecordAttrChildService statisticsRecordAttrChildService;

    @Resource
    private QueryStatisticsRecordAttrDao queryStatisticsRecordAttrDao;

    @ApiOperation("增加记录属性")
    @PostMapping("/{recordId}/attr")
    public Tip createRecordAttr(@PathVariable Long recordId, @RequestBody StatisticsRecordAttr attr){
        return SuccessTip.create(statisticsRecordAttrChildService.updateChild(recordId, attr));
    }

    @ApiOperation("修改记录属性")
    @PutMapping("/{recordId}/attr")
    public Tip updateRecordAttr(@PathVariable Long recordId, @RequestBody StatisticsRecordAttr attr){
        return SuccessTip.create(statisticsRecordAttrChildService.updateChild(recordId, attr));
    }

    @ApiOperation("获取记录属性")
    @GetMapping("/{recordId}/attr")
    public Tip getRecordAttr(@PathVariable Long recordId){
        return SuccessTip.create(statisticsRecordAttrChildService.getChild(recordId));
    }

    @ApiOperation("删除记录属性")
    @DeleteMapping("/{recordId}/attr")
    public Tip deleteRecordAttr(@PathVariable Long recordId){
        return SuccessTip.create(statisticsRecordAttrChildService.deleteChild(recordId));
    }

    @ApiOperation("分页返回记录属性")
    @GetMapping("/attr")
    public Tip queryStatisticsRecordAttrs(Page<StatisticsRecordAttr> page,
                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                      @RequestParam(name = "id", required = false) Long id,
                                      @RequestParam(name = "fieldId", required = false) Long fieldId,
                                      @RequestParam(name = "field", required = false) String field,
                                      @RequestParam(name = "index", required = false) Integer index,
                                      @RequestParam(name = "recordId", required = false) Long recordId,
                                      @RequestParam(name = "recordTime", required = false) Date recordTime,
                                      @RequestParam(name = "monthName", required = false) String monthName,
                                      @RequestParam(name = "attrId", required = false) Long attrId,
                                      @RequestParam(name = "legend", required = false) String legend) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticsRecordAttr attr = new StatisticsRecordAttr();
        attr.setId(id);
        attr.setFieldId(fieldId);
        attr.setField(field);
        attr.setIndex(index);
        attr.setLegend(legend);
        attr.setRecordId(recordId);
        attr.setLegend(legend);

        page.setRecords(queryStatisticsRecordAttrDao.findStatisticsRecordAttrPage(page, attr));

        return SuccessTip.create(page);
    }
}
