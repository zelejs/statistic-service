package com.jfeat.am.module.statistic.mq;

import com.jfeat.am.core.support.StrKit;
import com.jfeat.am.core.util.JsonKit;
import com.jfeat.am.module.statistics.services.service.StatisticRecordService;
import com.jfeat.am.module.statistics.services.service.model.StatisticNotifyData;
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
@RabbitListener(queues = Config.STATISTIC_DATA_NOTIFY)
public class StatisticNotifyReceiver {

    @Resource
    private StatisticRecordService statisticRecordService;

    private static final Logger logger = LoggerFactory.getLogger(StatisticNotifyReceiver.class);

    @RabbitHandler
    public void process(@Payload String message) {
        logger.info("Receiver : " + message);

        if (StrKit.isBlank(message)) {
            return;
        }
        StatisticNotifyData memberAnalysisNotifyData = JsonKit.parseObject(message, StatisticNotifyData.class);
        statisticRecordService.insertStatisticRecord(memberAnalysisNotifyData);
    }

}
