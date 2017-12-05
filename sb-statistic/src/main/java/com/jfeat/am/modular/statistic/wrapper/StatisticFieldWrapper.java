package com.jfeat.am.modular.statistic.wrapper;

/**
 * Created by Silent-Y on 2017/9/6.
 */
public class StatisticFieldWrapper {

    private String name;
    private String displayName;
    private Integer sortOrder;
    private Integer visible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }
}
