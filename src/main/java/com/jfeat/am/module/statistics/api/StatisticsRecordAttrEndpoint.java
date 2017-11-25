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
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsRecordAttrService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@RestController
@RequestMapping("/api/statistics/statistics-record-attr")
public class StatisticsRecordAttrEndpoint extends BaseController {

    @Resource
    StatisticsRecordAttrService statisticsRecordAttrService;

    @Resource
    QueryStatisticsRecordAttrService queryStatisticsRecordAttrService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyStatisticsRecordAttr() {
        return SuccessTip.create(new StatisticsRecordAttr());
    }

    @PostMapping
    public Tip createStatisticsRecordAttr(@RequestBody StatisticsRecordAttr entity) {
        return SuccessTip.create(statisticsRecordAttrService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getStatisticsRecordAttr(@PathVariable Long id) {
        return SuccessTip.create(statisticsRecordAttrService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    public Tip updateStatisticsRecordAttr(@PathVariable Long id, @RequestBody StatisticsRecordAttr entity) {
        entity.setId(id);
        return SuccessTip.create(statisticsRecordAttrService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticsRecordAttr(@PathVariable Long id) {
        return SuccessTip.create(statisticsRecordAttrService.deleteMaster(id));
    }

    @GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryStatisticsRecordAttrs(Page<StatisticsRecordAttr> page,
                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "id", required = false) Long id,
                                                @RequestParam(name = "recordId", required = false) Long recordId,
                                        @RequestParam(name = "legend", required = false) String legend,
                                            @RequestParam(name = "index", required = false) Integer index) {
            page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticsRecordAttr statisticsrecordattr = new StatisticsRecordAttr();
            statisticsrecordattr .setId(id);
                statisticsrecordattr .setRecordId(recordId);
            statisticsrecordattr .setLegend(legend);
            statisticsrecordattr .setIndex(index);

        page.setRecords(queryStatisticsRecordAttrService.findStatisticsRecordAttrPage(page, statisticsrecordattr));

        return SuccessTip.create(page);
    }
}
