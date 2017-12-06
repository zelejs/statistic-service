package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BizExceptionEnum;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.core.util.JsonKit;
import com.jfeat.am.module.statistics.api.bean.StatisticsGroupParentBean;
import com.jfeat.am.module.statistics.services.domain.service.QueryStatisticsFieldService;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldFilter;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.service.StatisticsRecordAttrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    @Resource
    StatisticsFieldService statisticsFieldService;
    @Resource
    StatisticsGroupService statisticsGroupService;
    @Resource
    StatisticsRecordAttrService statisticsRecordAttrService;
    @Resource
    QueryStatisticsFieldService queryStatisticsFieldService;

    ///TODO， 考虑如何转换为图形数据，增加 API

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticField(@PathVariable String field) {
        StatisticsField statisticsField = statisticsFieldService.getFieldOfField(field);
        if(statisticsField!=null){
            return SuccessTip.create(statisticsFieldService.retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null));
        }
        throw new BusinessException(BizExceptionEnum.REQUEST_INVALIDATE);
    }

    @ApiOperation("获取指定分组标识的数据域组")
    @GetMapping("/groups/{identifier}/data")
    public Tip getStatisticFieldByGroup(@PathVariable String identifier) {
        StatisticsGroup group = statisticsGroupService.getGroupByIdentifier(identifier);
        if(group==null){
            throw new BusinessException(BizExceptionEnum.REQUEST_INVALIDATE);
        }
        StatisticsGroupParentBean parentGroupBean = new StatisticsGroupParentBean();
        StatisticsGroup parentGroup = statisticsGroupService.getParentGroup(group.getId());
        parentGroupBean.setFields(
                statisticsFieldService.getFieldGroupByGroup(group.getId())
        );

        return SuccessTip.create(parentGroupBean);
    }

    /*@ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticFieldData(@PathVariable String field,
                                     @RequestParam(required = false) String startTime,
                                     @RequestParam(required = false) String endTime) {
        StatisticsField statisticsField = statisticsFieldService.getFieldOfField(field);
        if(statisticsField!=null){
            List<StatisticsRecordAttr> statisticsRecordAttrs = statisticsRecordAttrService.getStatisticsRecordAttrByFieldId(statisticsField.getId());
//            List<String> fields = statisticsRecordAttrs.stream().map(StatisticsRecordAttr::getLegend).collect(Collectors.toList());
            List<Map<String,Object>> result = queryStatisticsFieldService.getStatisticsRecordByFieldIdAndStartTimeAndEndTime(field, statisticsRecordAttrs, startTime, endTime);
            System.out.print(JsonKit.toJson(result));
            return SuccessTip.create(result);
        }
        throw new BusinessException(BizExceptionEnum.REQUEST_INVALIDATE);
    }*/
}
