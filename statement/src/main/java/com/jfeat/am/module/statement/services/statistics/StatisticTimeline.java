package com.jfeat.am.module.statement.services.statistics;

import com.jfeat.am.module.statement.services.statistics.route.StatisticRouteData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/5/8.
 * 涉及时间轴多维查询，适用所有统计类型
 */
public class StatisticTimeline implements Statistics {
    private String name;
    private List<Statistics> statistics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public StatisticTimeline addStatistic(Statistics statistic){
        if(this.statistics == null){
            this.statistics = new ArrayList<>();
        }
        this.statistics.add(statistic);
        return this;
    }

    @Override
    public StatisticRouteData toRouteData() {
        StatisticRouteData routeData = new StatisticRouteData();
        routeData.setName(name);
        routeData.setRecordTime(new Date());

        if(statistics!=null) {

            for(Statistics ref : statistics) {

                if(ref instanceof Statistic){
                    Statistic statistic = (Statistic) ref;
                    StatisticRouteData data = statistic.toRouteData();
                    routeData.append(data);
                }

                else if(ref instanceof StatisticRate){
                    StatisticRate statistic = (StatisticRate) ref;
                    StatisticRouteData data =  statistic.toRouteData();
                    routeData.append(data);
                }

                else if(ref instanceof StatisticTuple){
                    StatisticTuple statistic = (StatisticTuple) ref;
                    StatisticRouteData data =  statistic.toRouteData();
                    routeData.append(data);
                }

                else if(ref instanceof StatisticCluster){
                    StatisticCluster statistic = (StatisticCluster) ref;
                    StatisticRouteData data =  statistic.toRouteData();
                    routeData.append(data);
                }
            }
        }

        return routeData;
    }
}
