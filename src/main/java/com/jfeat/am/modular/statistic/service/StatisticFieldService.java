package com.jfeat.am.modular.statistic.service;

import com.jfeat.am.common.persistence.model.StatisticField;

import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
public interface StatisticFieldService {

    public List<StatisticField> getStatisticFieldByTypeId(long typeId);

}
