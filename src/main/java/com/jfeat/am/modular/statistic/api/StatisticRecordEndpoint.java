package com.jfeat.am.modular.statistic.api;

import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Silent-Y on 2017/9/2.
 */

/**
 * 移动到 StatisticChartEndpoint
 * 这里可以删除
 */

@Deprecated
@RestController
@RequestMapping("/api/adm/statistic/records")
public class StatisticRecordEndpoint extends BaseController {

    @Resource
    StatisticRecordService statisticRecordService;
    @Resource
    StatisticFieldService statisticFieldService;
    @Resource
    TypeDefinitionMapper typeDefinitionMapper;

}
