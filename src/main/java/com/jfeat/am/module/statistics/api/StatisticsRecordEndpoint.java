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
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsRecordService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.crud.service.StatisticsRecordService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;

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
@RequestMapping("/api/statistics/statistics-record")
public class StatisticsRecordEndpoint extends BaseController {

    @Resource
    StatisticsRecordService statisticsRecordService;

    @Resource
    QueryStatisticsRecordService queryStatisticsRecordService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyStatisticsRecord() {
        return SuccessTip.create(new StatisticsRecord());
    }

    @PostMapping
    public Tip createStatisticsRecord(@RequestBody StatisticsRecord entity) {
        return SuccessTip.create(statisticsRecordService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getStatisticsRecord(@PathVariable Long id) {
        return SuccessTip.create(statisticsRecordService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    public Tip updateStatisticsRecord(@PathVariable Long id, @RequestBody StatisticsRecord entity) {
        entity.setId(id);
        return SuccessTip.create(statisticsRecordService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticsRecord(@PathVariable Long id) {
        return SuccessTip.create(statisticsRecordService.deleteMaster(id));
    }

    @GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryStatisticsRecords(Page<StatisticsRecord> page,
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
        StatisticsRecord statisticsrecord = new StatisticsRecord();
            statisticsrecord .setId(id);
            statisticsrecord .setField(field);
            statisticsrecord .setLegend(legend);
                statisticsrecord .setLegendKey(legendKey);
                statisticsrecord .setLegendValue(legendValue);
            statisticsrecord .setIndex(index);
                statisticsrecord .setRecordTime(recordTime);
                statisticsrecord .setMonthName(monthName);

        page.setRecords(queryStatisticsRecordService.findStatisticsRecordPage(page, statisticsrecord));

        return SuccessTip.create(page);
    }
}
