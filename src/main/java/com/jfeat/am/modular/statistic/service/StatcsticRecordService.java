package com.jfeat.am.modular.statistic.service;

import com.jfeat.am.modular.statistic.mq.MemberAnalysisNotifyData;

/**
 * Created by Silent-Y on 2017/8/31.
 */
public interface StatcsticRecordService {

    public boolean insertStaticsticRecord(MemberAnalysisNotifyData memberAnalysisNotifyData);
}
