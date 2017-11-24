package com.jfeat.am.module.statistics.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;

import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;

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
@RequestMapping("/api/adm/statistics/group")
public class StatisticsGroupEndpoint extends BaseController {

    //TODO, 运维API, 对统计分类属于运维层面

    @Resource
    StatisticsGroupService statisticsGroupService;

    @PostMapping
    public Tip createStatisticsGroup(@RequestBody StatisticsGroup entity) {
        return SuccessTip.create(1);
    }

    @GetMapping("/{id}")
    public Tip getStatisticsGroup(@PathVariable Long id) {
        return SuccessTip.create(1);
    }

    @PutMapping("/{id}")
    public Tip updateStatisticsGroup(@PathVariable Long id, @RequestBody StatisticsGroup entity) {
        entity.setId(id);
        return SuccessTip.create(1);
    }

    @DeleteMapping("/{id}")
    public Tip deleteStatisticsGroup(@PathVariable Long id) {
        return SuccessTip.create(1);
    }
}
