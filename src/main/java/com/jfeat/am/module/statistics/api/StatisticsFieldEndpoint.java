package com.jfeat.am.module.statistics.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsFieldService;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;

import org.springframework.web.bind.annotation.RestController;
import com.jfeat.am.common.controller.BaseController;

import javax.annotation.Resource;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@RestController
@RequestMapping("/api/statistics/fields")
public class StatisticsFieldEndpoint extends BaseController {

    //TODO, 获取指定数据域的报表数据，或获取指定分组的数据域列表

    @Resource
    StatisticsFieldService statisticsFieldService;

    @Resource
    QueryStatisticsFieldService queryStatisticsFieldService;

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

}
