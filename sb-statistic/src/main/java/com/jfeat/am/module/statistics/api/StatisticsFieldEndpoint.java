package com.jfeat.am.module.statistics.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.exception.BizExceptionEnum;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.api.bean.StatisticsGroupParentBean;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.notify.StatisticsNotifyService;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import com.jfeat.am.module.statistics.services.service.filter.StatisticsFieldFilter;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    StatisticsNotifyService statisticsNotifyService;

    ///TODO， 考虑如何转换为图形数据，增加 API

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/{field}")
    public Tip getStatisticField(@PathVariable String field) {
        StatisticsField statisticsField = statisticsFieldService.getFieldByFieldName(field);
        if (statisticsField != null) {
            return SuccessTip.create(statisticsFieldService.retrieveMaster(statisticsField.getId(), new StatisticsFieldFilter(), null, null));
        }
        throw new BusinessException(BizExceptionEnum.REQUEST_INVALIDATE);
    }

    @ApiOperation("获取指定分组标识的数据域组")
    @GetMapping("/groups/{identifier}/data")
    public Tip getStatisticFieldByGroup(@PathVariable String identifier) {
        StatisticsGroup group = statisticsGroupService.getGroupByIdentifier(identifier);
        if (group == null) {
            throw new BusinessException(BizExceptionEnum.REQUEST_INVALIDATE);
        }
        StatisticsGroupParentBean parentGroupBean = new StatisticsGroupParentBean();
        StatisticsGroup parentGroup = statisticsGroupService.getParentGroup(group.getId());
        parentGroupBean.setFields(
                statisticsFieldService.getFieldListByByGroupId(group.getId())
        );

        return SuccessTip.create(parentGroupBean);
    }

    @ApiOperation("获取指定数据域数据")
    @GetMapping("/plan/{field}/{echart}")
    public Tip getStatisticFieldData(@PathVariable String field,
                                     @PathVariable String echart,
                                     @RequestParam(required = false) String startTime,
                                     @RequestParam(required = false) String endTime) {
        /*折线图数据结构
    "titile":"折线图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];*/

        /*StatisticsField statisticsField = statisticsFieldService.getFieldByFieldName(field);
        if(statisticsField!=null){
            List<StatisticsRecordAttr> statisticsRecordAttrs = statisticsRecordAttrService.getStatisticsRecordAttrByFieldId(statisticsField.getId());
            List<String> fields = statisticsRecordAttrs.stream().map(StatisticsRecordAttr::getField).collect(Collectors.toList());
            List<Map<String,Object>> maps = queryStatisticsFieldService.getStatisticsRecordByFieldIdAndStartTimeAndEndTime(field, fields, startTime, endTime);
            Map<String,Object> result = Maps.newHashMap();
            List<String> dataAxis = Lists.newArrayList();
            List<String> data = Lists.newArrayList();
            String legend = "";
            for (Map map:maps){
                if (map != null){
                    legend = map.get("legend").toString();
                }
                dataAxis.add(map.get("recordTime").toString());
                data.add(map.get(field).toString());
            }
            result.put("title",legend);
            result.put("timestamp", DateTimeKit.formatDateTime(new Date()));
            result.put("type","line");
            result.put("dataAxis",dataAxis);
            result.put("data",data);
            System.out.print(JsonKit.toJson(result));
            return SuccessTip.create(result);
        }
        throw new BusinessException(1017,"查不到该数据域！");
    }*/
        return SuccessTip.create(statisticsNotifyService.getEchartData(field, echart, startTime, endTime));
    }
}