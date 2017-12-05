package com.jfeat.am.modular.statistic.api;

import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BizExceptionEnum;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.core.support.StrKit;
import com.jfeat.am.modular.statistic.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.modular.statistic.persistence.model.StatisticField;
import com.jfeat.am.modular.statistic.constant.StatisticPermission;
import com.jfeat.am.modular.statistic.persistence.model.TypeDefinition;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import com.jfeat.am.modular.statistic.wrapper.StatisticFieldWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/adm")
public class StatisticFieldRecordEndpoint extends BaseController{

    @Resource
    StatisticFieldService statisticFieldService;

    @GetMapping("/statistic/fields/{typeId}")
    @Permission(StatisticPermission.STATISTIC_VIEW)
    public Tip getStatisticFieldByTypeId(@PathVariable long typeId){
        List<StatisticField> statisticFields = statisticFieldService.getStatisticFieldByTypeId(typeId);
        return SuccessTip.create(statisticFields);
    }

    @PutMapping("/statistic/fields/{typeId}")
    @Permission(StatisticPermission.STATISTIC_UPDATE)
    public Tip updateStatisticFieldByTypeId(@PathVariable long typeId,@RequestBody List<StatisticFieldWrapper> statisticFieldWrappers){
        boolean result = statisticFieldService.updateStatisticFieldByTypeId(typeId,statisticFieldWrappers);
        return SuccessTip.create(result);
    }


    /**
     * Deprecated
     */
    @Resource
    StatisticRecordService statisticRecordService;
    @Resource
    TypeDefinitionMapper typeDefinitionMapper;

    @GetMapping("/statistic_records")
    @Permission(StatisticPermission.STATISTIC_VIEW)
    public Tip getStatisticRecords(@RequestParam(name = "typeId", required = false) Long typeId,
                                   @RequestParam(name = "identifier", required = false) String identifier,
                                   @RequestParam(required = false) String startTime,
                                   @RequestParam(required = false) String endTime) {
        if (typeId == null && StrKit.isBlank(identifier)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_INVALIDATE);
        }
        if (typeId == null) {
            TypeDefinition query = new TypeDefinition();
            query.setIdentifier(identifier);
            TypeDefinition typeDefinition = typeDefinitionMapper.selectOne(query);
            if (typeDefinition == null) {
                throw new BusinessException(BizExceptionEnum.INVALID_TUPLE_ID);
            }
            typeId = typeDefinition.getId();
        }

//        获取fields
        List<StatisticField> statisticFields = statisticFieldService.getStatisticFieldByTypeId(typeId);
        List<String> fields = statisticFields.stream().map(StatisticField::getName).collect(Collectors.toList());
        List<Map<String, Object>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(typeId, fields, startTime, endTime);
        return SuccessTip.create(statisticRecords);
    }
}
