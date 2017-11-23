package com.jfeat.am.modular.statistic.service;

import com.jfeat.am.modular.statistic.persistence.model.StatisticField;
import com.jfeat.am.modular.statistic.wrapper.StatisticFieldWrapper;

import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
public interface StatisticFieldService {

    public List<StatisticField> getStatisticFieldByTypeId(long typeId);

    public boolean updateStatisticFieldByTypeId(long typeId,List<StatisticFieldWrapper> statisticFieldWrappers);
}
