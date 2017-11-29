package com.jfeat.am.module.statistics.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsRecordService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrChildService;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-10-19
 */
@RestController
@RequestMapping("/api/adm/statistics/records")
public class MaintenanceRecordEndpoint extends BaseController {

    @Resource
    private StatisticsRecordAttrService statisticsRecordAttrService;
    @Resource
    private StatisticsRecordAttrChildService statisticsRecordAttrChildService;
    @Resource
    private QueryStatisticsRecordService queryStatisticsRecordService;

    @ApiOperation("获取所有记录属性")
    @GetMapping("/attrs")
    public Tip getRecordAttributeList(){
        return SuccessTip.create(statisticsRecordAttrService.retrieveMasterList());
    }

    @ApiOperation("修改记录属性")
    @PutMapping("/{recordId}/attr")
    public Tip updateRecordAttribute(@PathVariable Long recordId, @RequestBody StatisticsRecordAttr attr){
        return SuccessTip.create(statisticsRecordAttrChildService.updateChild(recordId, attr));
    }

    //TODO, 批量修改记录属性

    @ApiOperation("获取记录及其属性")
    @GetMapping("/{recordId}")
    public Tip getRecordAttribute(@PathVariable Long recordId){
        return SuccessTip.create(statisticsRecordAttrChildService.getChild(recordId));
    }

    @ApiOperation("返回所有记录")
    @GetMapping
    public Tip queryStatisticsRecords(Page<StatisticsRecord> page,
                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                      @RequestParam(name = "id", required = false) Long id,
                                      @RequestParam(name = "fieldId", required = false) Long fieldId,
                                      @RequestParam(name = "field", required = false) String field,
                                      @RequestParam(name = "recordName", required = false) String recordName,
                                      @RequestParam(name = "recordValue", required = false) String recordValue,
                                      @RequestParam(name = "recordTime", required = false) Date recordTime,
                                      @RequestParam(name = "monthName", required = false) String monthName,
                                      @RequestParam(name = "attrId", required = false) Long attrId,
                                      @RequestParam(name = "legend", required = false) String legend) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticsRecord statisticsrecord = new StatisticsRecord();
        statisticsrecord.setId(id);
        statisticsrecord.setFieldId(fieldId);
        statisticsrecord.setField(field);
        statisticsrecord.setRecordName(recordName);
        statisticsrecord.setRecordValue(recordValue);
        statisticsrecord.setRecordTime(recordTime);
        statisticsrecord.setMonthName(monthName);
        statisticsrecord.setAttrId(attrId);
        statisticsrecord.setLegend(legend);

        page.setRecords(queryStatisticsRecordService.findStatisticsRecordPage(page, statisticsrecord));

        return SuccessTip.create(page);
    }
}
