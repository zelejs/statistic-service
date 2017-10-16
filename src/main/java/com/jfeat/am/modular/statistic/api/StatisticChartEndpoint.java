package com.jfeat.am.modular.statistic.api;

import com.google.common.collect.Lists;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.exception.BizExceptionEnum;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.common.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.common.persistence.model.StatisticField;
import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.core.support.StrKit;
import com.jfeat.am.modular.statistic.constant.StatisticPermission;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import com.jfeat.am.modular.statistic.service.StatisticRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Silent-Y on 2017/10/16.
 */
@RestController
@RequestMapping("/api/adm/statistic/chart")
public class StatisticChartEndpoint {

    @Resource
    StatisticRecordService statisticRecordService;
    @Resource
    StatisticFieldService statisticFieldService;
    @Resource
    TypeDefinitionMapper typeDefinitionMapper;

    /*饼状图数据结构
    "titile":"饼状图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "data":[
    {value:335, name:'直接访问'},
    {value:310, name:'邮件营销'},
    {value:274, name:'联盟广告'},
    {value:235, name:'视频广告'},
    {value:400, name:'搜索引擎'}
    ]*/

    @GetMapping("/pie/{typeId}")
    public Tip getPieData(@RequestParam(name = "typeId", required = false) Long typeId,
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

        String type = typeDefinitionMapper.selectById(typeId).getName();

//        获取fields
        List<StatisticField> statisticFields = statisticFieldService.getStatisticFieldByTypeId(typeId);
        List<String> fields = statisticFields.stream().map(StatisticField::getName).collect(Collectors.toList());
        List<Map<String, String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(typeId, fields, startTime, endTime);
        List<String> recordTime = Lists.newArrayList();
        for (Map<String,String> statisticRecord:statisticRecords){
            for(String key : statisticRecord.keySet()){
                statisticRecord.remove("recordTime");
                recordTime.add(statisticRecord.get("recordTime"));
            }
        }
        Map<String,Object> data = new HashMap<>();
        data.put("recordTime",recordTime);
        data.put("type",type);
        data.put("statisticRecords",statisticRecords);

        return SuccessTip.create(data);
    }

    /*折线图数据结构
    "titile":"折线图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];*/

    @GetMapping("/line/{typeId}")
    public Tip getLineData(@RequestParam(name = "typeId", required = false) Long typeId,
                           @RequestParam(name = "identifier", required = false) String identifier,
                           @RequestParam(required = false) String startTime,
                           @RequestParam(required = false) String endTime){
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
        List<Map<String, String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(typeId, fields, startTime, endTime);
        List fieldName = Lists.newArrayList();
        for (String field:fields){
            for (Map<String,String> statisticRecord:statisticRecords){
                fieldName.add(statisticRecord.get(field));
            }
        }


        return SuccessTip.create();
    }

    /*柱状图数据结构
    "titile":"柱状图数据结构",
    "timestamp":"数据生成时间",
    "type":"数据图描述类型",
    "dataAxis":['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    "data":[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];*/

    @GetMapping("/bar/{typeId}")
    public Tip getBarData(){
        return SuccessTip.create();
    }

    @GetMapping("/records/{typeId}")
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
        List<Map<String, String>> statisticRecords = statisticRecordService.getStatisticRecordByTypeIdAndStartTimeAndEndTime(typeId, fields, startTime, endTime);
        return SuccessTip.create(statisticRecords);
    }
}
