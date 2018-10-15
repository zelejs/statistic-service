package com.jfeat.am.module.statistics.services.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2018/9/25.
 */
public class StatisticGroupData implements StatisticDataBase{
    private static final String DEFAULT_LAYOUT = "Grid";

    /**
     * 布局
     */
    private String layout = DEFAULT_LAYOUT;
    /**
     * 分组名称
     */
    private String group;
    /**
     * 组标题
     */
    private String title;
    /**
     * 子分组所占父分组跨度
     */
    private int span = 1;
    /**
     * 子分组排序
     */
    private int index = 0;


    private List<StatisticDataBase> items;

    public List<StatisticDataBase> getItems() {
        return items;
    }

    public void setItems(List<StatisticDataBase> items) {
        this.items = items;
    }

    /**
     * add item, can be field or group
     * @param item
     */
    public void addItem(StatisticDataBase item){
        if(this.items==null){
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        if(layout!=null && layout.length()>0) {
            this.layout = layout;
        }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getSpan() {
        return span;
    }

    public void setSpan(int span) {
        if(span>0) {
            this.span = span;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
