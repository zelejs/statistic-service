package com.jfeat.am.modular.statistic.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jfeat.am.common.persistence.dao.StatisticFieldMapper;
import com.jfeat.am.common.persistence.model.StatisticField;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/statistic_fields")
public class StatisticFieldServiceImpl extends ServiceImpl<StatisticFieldMapper,StatisticField>implements StatisticFieldService{

    public List<StatisticField> getStatisticFieldByTypeId(long typeId){
        return selectList(new EntityWrapper<StatisticField>().eq("type_id",typeId));
    }
}
