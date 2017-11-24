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
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsFieldService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.crud.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;

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
@RequestMapping("/api/statistics/statistics-field")
public class StatisticsFieldEndpoint extends BaseController {

    @Resource
    StatisticsFieldService statisticsFieldService;

    @Resource
    QueryStatisticsFieldService queryStatisticsFieldService;

    /// For debug purpose
    @GetMapping("/empty")
    public Tip getEmptyStatisticsField() {
        return SuccessTip.create(new StatisticsField());
    }

    @PostMapping
    public Tip createStatisticsField(@RequestBody StatisticsField entity) {
        return SuccessTip.create(statisticsFieldService.createMaster(entity));
    }

    @GetMapping("/{id}")
    public Tip getStatisticsField(@PathVariable Long id) {
        return SuccessTip.create(statisticsFieldService.retrieveMaster(id));
    }

    @PutMapping("/{id}")
    public Tip updateStatisticsField(@PathVariable Long id, @RequestBody StatisticsField entity) {
        entity.setId(id);
        return SuccessTip.create(statisticsFieldService.updateMaster(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticsField(@PathVariable Long id) {
        return SuccessTip.create(statisticsFieldService.deleteMaster(id));
    }

    @GetMapping
    //此方法可能需要自行添加需要的参数,按需要使用
    public Tip queryStatisticsFields(Page<StatisticsField> page,
                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "id", required = false) Long id,
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "field", required = false) String field,
                                            @RequestParam(name = "index", required = false) Integer index,
                                            @RequestParam(name = "invisible", required = false) Integer invisible,
                                                @RequestParam(name = "groupId", required = false) Long groupId,
                                        @RequestParam(name = "chart", required = false) String chart) {
            page.setCurrent(pageNum);
        page.setSize(pageSize);
        StatisticsField statisticsfield = new StatisticsField();
            statisticsfield .setId(id);
            statisticsfield .setName(name);
            statisticsfield .setField(field);
            statisticsfield .setIndex(index);
            statisticsfield .setInvisible(invisible);
                statisticsfield .setGroupId(groupId);
            statisticsfield .setChart(chart);

        page.setRecords(queryStatisticsFieldService.findStatisticsFieldPage(page, statisticsfield));

        return SuccessTip.create(page);
    }
}
