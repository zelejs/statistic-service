package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.common.crud.CRUDFilter;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticChart;


/**
 * Created by Code Generator on 2017-11-24
 */
public class StatisticChartFilter implements CRUDFilter<StatisticChart> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(StatisticChart entity, boolean insertOrUpdate) {

        //if insertOrUpdate is true,means for insert, do this
        if (insertOrUpdate){

            //then insertOrUpdate is false,means for update,do this
        }else {

        }

    }

    @Override
    public String[] ignore(boolean retrieveOrUpdate) {
        //if retrieveOrUpdate is true,means for retrieve ,do this
        if (retrieveOrUpdate){
            return ignoreFields;
            //then retrieveOrUpdate  if false ,means for update,do this
        }else {
            return updateIgnoreFields;
        }
    }
}
