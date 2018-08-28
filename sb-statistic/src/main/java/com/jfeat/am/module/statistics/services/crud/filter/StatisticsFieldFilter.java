package com.jfeat.am.module.statistics.services.crud.filter;

import com.alibaba.fastjson.JSONObject;
import com.jfeat.am.common.crud.CRUDFilterResult;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;


/**
 * Created by Code Generator on 2017-11-25
 */
public class StatisticsFieldFilter implements CRUDFilterResult<StatisticsField> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public JSONObject result() {
        return new JSONObject();
    }

    @Override
    public void filter(StatisticsField statisticsField, boolean b) {
//if insertOrUpdate is true,means for insert, do this
        if (b){

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
