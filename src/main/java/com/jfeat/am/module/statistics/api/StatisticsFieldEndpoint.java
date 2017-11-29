package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BizExceptionEnum;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.api.bean.StatisticsGroupParentBean;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    StatisticsFieldService statisticsFieldService;
    @Resource
    StatisticsGroupService statisticsGroupService;

    ///TODO， 考虑如何转换为图形数据，增加 API

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticField(@PathVariable String field) {
        StatisticsField statisticsField = statisticsFieldService.getFieldOfField(field);
        if(statisticsField!=null){
            return SuccessTip.create(statisticsFieldService.retrieveMaster(statisticsField.getId(), null, null, null));
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
}
