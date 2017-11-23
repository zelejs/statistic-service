package com.jfeat.am.modular.statistic.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jfeat.am.modular.statistic.persistence.dao.StatisticFieldMapper;
import com.jfeat.am.modular.statistic.persistence.model.StatisticField;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.modular.statistic.service.StatisticFieldService;
import com.jfeat.am.modular.statistic.wrapper.StatisticFieldWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@Service
public class StatisticFieldServiceImpl extends ServiceImpl<StatisticFieldMapper,StatisticField>implements StatisticFieldService{

    public List<StatisticField> getStatisticFieldByTypeId(@PathVariable long typeId){
        return selectList(new EntityWrapper<StatisticField>().eq("type_id",typeId).orderBy("sort_order",false));
    }

    @Transactional
    public boolean updateStatisticFieldByTypeId(long typeId,List<StatisticFieldWrapper> statisticFieldWrappers){
        delete(new EntityWrapper<StatisticField>().eq("type_id",typeId));
        for (StatisticFieldWrapper statisticFieldWrapper:statisticFieldWrappers){
            StatisticField statisticField = new StatisticField();
            BeanKit.copyProperties(statisticFieldWrapper,statisticField);
            statisticField.setTypeId(typeId);
            insert(statisticField);
        }
      return true;
    }
}
