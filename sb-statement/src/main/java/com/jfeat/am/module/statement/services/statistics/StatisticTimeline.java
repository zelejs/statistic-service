package com.jfeat.am.module.statement.services.statistics;

import com.jfeat.am.module.statement.services.statistics.route.StatisticRouteData;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 涉及时间轴多维查询，适用所有统计类型
 */
public class StatisticTimeline implements Statistics {
    private String name;
    private List<? extends Statistics> statistics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<? extends Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<? extends Statistics> statistics) {
        this.statistics = statistics;
    }

    @Override
    public StatisticRouteData toRouteData() {
        StatisticRouteData routeData = new StatisticRouteData();
        routeData.setRecordTime(new Date());

        if(statistics!=null) {

            for(Statistics ref : statistics) {

                if(ref instanceof Statistic){
                    Statistic statistic = (Statistic) ref;
                    StatisticRouteData timeline = statistic.toRouteData();
                    routeData.append(timeline);
                }

                if(ref instanceof StatisticRate){
                    StatisticRate statistic = (StatisticRate) ref;
                    StatisticRouteData timeline =  statistic.toRouteData();
                    routeData.append(timeline);
                }

                if(ref instanceof StatisticTuple){
                    StatisticTuple statistic = (StatisticTuple) ref;
                    StatisticRouteData timeline =  statistic.toRouteData();
                    routeData.append(timeline);
                }

                if(ref instanceof StatisticCluster){
                    StatisticCluster statistic = (StatisticCluster) ref;
                    StatisticRouteData timeline =  statistic.toRouteData();
                    routeData.append(timeline);
                }
            }
        }


        return routeData;
    }
}
