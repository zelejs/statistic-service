package com.jfeat.am.module.statistic.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Silent-Y on 2017/8/31.
 */
@Configuration
public class StatisticMQConfig {
    @Bean
    public Queue statisticDataNotifyQueue() {
        return new Queue(Config.STATISTIC_DATA_NOTIFY);
    }
}