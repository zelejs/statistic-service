package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.crud.CRUD;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.crud.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.crud.StatisticsGroupByService;
import com.jfeat.am.module.statistics.services.crud.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsGroupModel;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
@RequestMapping("/api/stat/groups")
public class StatisticsGroupEndpoint extends BaseController {

    @Resource
    StatisticsGroupService statisticsGroupService;
    @Resource
    StatisticsGroupByService statisticsGroupByService;

    @Resource
    StatisticsFieldService statisticsFieldService;

    @ApiOperation("获取指定分组的统计数据")
    @GetMapping("/{group}")
    public Tip getStatisticFieldByGroup(@PathVariable String group) {
        StatisticsGroup statisticsGroup = statisticsGroupService.getGroupByName(group);
        if (statisticsGroup == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        StatisticsGroupModel groupModel = CRUD.castObject(statisticsGroup, StatisticsGroupModel.class);

        List<StatisticsField> fields = statisticsGroupByService.getGroupItems(statisticsGroup.getId());

        //每个域的数据
        List<StatisticsField> modelFields = new ArrayList<>();

        for(StatisticsField field : fields) {
            String fieldName = field.getField();
            StatisticsFieldModel statisticsField = (StatisticsFieldModel) statisticsFieldService.getStatisticsFieldModel(fieldName);

            modelFields.add(statisticsField);
        }

        groupModel.setFields(modelFields);

        return SuccessTip.create(groupModel);
    }


}