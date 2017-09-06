package com.jfeat.am.modular.statistic.api;

import com.google.common.collect.Lists;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.common.persistence.model.StatisticField;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.core.support.DateTimeKit;
import com.jfeat.am.modular.statistic.constant.StatisticPermission;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/adm/statistic_records")
public class StatisticRecordEndpoint extends BaseController {

    @Resource
    StatisticRecordService statisticRecordService;
    @Resource
    StatisticFieldService statisticFieldService;
    @Resource
    TypeDefinitionMapper typeDefinitionMapper;

    @GetMapping
    @Permission(StatisticPermission.STATISTIC_VIEW)
    public Tip getStatisticRecords(@RequestParam(name = "typeId", required = false) Long typeId,
                                   @RequestParam(name = "identifier", required = false) String identifier,
                                   @RequestParam(required = false) String startTime,
                                   @RequestParam(required = false) String endTime) {
        if (typeId == null) {
            TypeDefinition typeDefinition = new TypeDefinition();
            typeDefinition.setIdentifier(identifier);
            typeId = typeDefinitionMapper.selectOne(typeDefinition).getId();
        }
//        获取fields
        List<StatisticField> statisticFields = statisticFieldService.getStatisticFieldByTypeId(typeId);
        List<String> fields = Lists.newArrayList();
        for (StatisticField statisticField : statisticFields) {
            String field = statisticField.getName();
            fields.add(field);
        }
        if (startTime == null) {
            startTime = DateTimeKit.lastMouth().toString();
        }
        if (endTime == null) {
            endTime = DateTimeKit.formatDateTime(new Date());
        }
        List<Map<String, String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(typeId, fields, startTime, endTime);
        return SuccessTip.create(statisticRecords);
    }
}
