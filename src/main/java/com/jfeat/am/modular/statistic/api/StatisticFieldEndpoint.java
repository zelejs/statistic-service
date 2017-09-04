package com.jfeat.am.modular.statistic.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.persistence.model.StatisticField;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/adm/statistic_fields")
public class StatisticFieldEndpoint extends BaseController{

    @Resource
    StatisticFieldService statisticFieldService;

    @GetMapping("/{typeId}")
    public Tip getStatisticFieldByTypeId(@PathVariable long typeId){
        List<StatisticField> statisticFields = statisticFieldService.getStatisticFieldByTypeId(typeId);
        return SuccessTip.create(statisticFields);
    }
}
