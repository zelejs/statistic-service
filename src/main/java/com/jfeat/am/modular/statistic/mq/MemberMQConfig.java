package com.jfeat.am.modular.statistic.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Silent-Y on 2017/8/31.
 */
@Configuration
public class MemberMQConfig {

    @Bean
    public Queue memberAnalysisNotifyQueue() {
        return new Queue(Const.MEMBER_ANALYSIS_NOTIFY_QUEUE);
    }
}