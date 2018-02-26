package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.crud.CRUD;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupByService;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.service.model.StatisticsGroupModel;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@Api("统计 [Statistics]")
@RestController
@RequestMapping("/api/statistics/groups")
public class StatisticsFieldGroupEndpoint extends BaseController {

    @Resource
    StatisticsGroupService statisticsGroupService;
    @Resource
    StatisticsGroupByService statisticsGroupByService;

    @ApiOperation("获取指定分组标识的数据域组")
    @GetMapping("/{identifier}/data")
    public Tip getStatisticFieldByGroup(@PathVariable String identifier) {
        StatisticsGroup group = statisticsGroupService.getGroupByIdentifier(identifier);
        if (group == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }
        //JSONObject groupData = statisticsGroupByService.groupBy("group_id");

        StatisticsGroupModel groupModel = CRUD.castObject(group, StatisticsGroupModel.class);
        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(group.getId());
        groupModel.setFields(fields);

        return SuccessTip.create(groupModel);
    }
}