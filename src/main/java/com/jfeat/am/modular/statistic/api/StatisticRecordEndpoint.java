package com.jfeat.am.modular.statistic.api;

import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BizExceptionEnum;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.common.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.common.persistence.model.StatisticField;
import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.core.support.StrKit;
import com.jfeat.am.modular.statistic.constant.StatisticPermission;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Silent-Y on 2017/9/2.
 */

/**
 * 移动到 StatisticChartEndpoint
 * 这里可以删除
 */

@Deprecated
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
