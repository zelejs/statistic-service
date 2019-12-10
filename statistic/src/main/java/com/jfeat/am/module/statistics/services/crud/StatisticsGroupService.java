package com.jfeat.am.module.statistics.services.crud;
            
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsGroup;
import com.jfeat.crud.plus.CRUDServiceGroup;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */

public interface StatisticsGroupService extends CRUDServiceGroup<StatisticsGroup> {
    StatisticsGroup getGroupByName(String name);
}
