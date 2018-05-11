package com.jfeat.am.module.statement.services.test;

import com.jfeat.am.AmApplication;
import com.jfeat.am.module.statement.services.statistics.*;
import com.jfeat.am.module.statement.services.statistics.route.StatisticRouteData;
import com.jfeat.am.module.statement.services.statistics.service.GeneralStatisticService;
import com.jfeat.am.module.statement.services.statistics.service.impl.GeneralStatisticServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ActiveProfiles(profiles = "dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Transactional
public class TestGeneralStaticService {

    @Autowired
    private GeneralStatisticService generalStatisticService;

    @Test
    public void testQueryStatistic() throws Exception {
        Statistics subject = generalStatisticService.queryStatistic("stat", "select distinct count(stat) from cl_client_record");
        StatisticRouteData statisticRouteData = subject.toRouteData();
        System.out.println("for debug");
    }

    @Test
    public void testQueryStatisticRate() throws SQLException {
        StatisticRate statisticRate = generalStatisticService.queryStatisticRate("stat", "select distinct count(stat) from cl_client_record");
        StatisticRouteData statisticRouteData = statisticRate.toRouteData();
        System.out.println("for debug");
    }

    @Test
    public void testQueryStatisticTimeline() throws SQLException {
        Timeline timeline = new Timeline();
        timeline.setName("stat");
        timeline.setTimestampField("stat");
        System.out.println(timeline.buildTimelineSql(Timeline.Timelines.D.toString()));
        StatisticTimeline statisticTimeline = generalStatisticService.queryStatisticTimeline("stat", "select stat from cl_client_record", timeline);
        StatisticRouteData statisticRouteData = statisticTimeline.toRouteData();
        System.out.println("for debug");
    }

    @Test
    public void testQueryStatisticTuple() throws SQLException {
        List<String> tuple = new ArrayList<>();
        tuple.add("stat");
        StatisticTuple statisticTuple = generalStatisticService.queryStatisticTuple("stat", "select distinct count(stat) as rate from cl_client_record", tuple);
        StatisticRouteData statisticRouteData = statisticTuple.toRouteData();
        System.out.println("for debug");
    }

}
