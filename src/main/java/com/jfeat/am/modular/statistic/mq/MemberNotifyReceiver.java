package com.jfeat.am.modular.statistic.mq;

import com.alibaba.fastjson.JSON;
import com.jfeat.am.common.persistence.model.StatisticRecord;
import com.jfeat.am.core.support.StrKit;
import com.jfeat.am.modular.statistic.service.StatcsticRecordService;
import com.jfeat.am.modular.statistic.service.impl.StaticsticRecordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Silent-Y on 2017/8/31.
 */
@Component
@RabbitListener(queues = Const.MEMBER_ANALYSIS_NOTIFY_QUEUE)
public class MemberNotifyReceiver {

    @Resource
    StatcsticRecordService staticsticRecordService;

    private static final Logger logger = LoggerFactory.getLogger(MemberNotifyReceiver.class);

    @RabbitHandler
    public void processMemberAnalysis(@Payload String message){
        logger.info("Receiver : " + message);

        if (StrKit.isBlank(message)){
            return;
        }
        MemberAnalysisNotifyData memberAnalysisNotifyData = JSON.parseObject(message, MemberAnalysisNotifyData.class);
        staticsticRecordService.insertStaticsticRecord(memberAnalysisNotifyData);


    }

/*    @RabbitHandler
    public void processMemberRelationAnalysis(@Payload String message){
        logger.info("Receiver : " + message);

        if (StrKit.isBlank(message)){
            return;
        }
        MemberAnalysisNotifyData data = JSON.parseObject(message, MemberAnalysisNotifyData.class);

    }*/
}
