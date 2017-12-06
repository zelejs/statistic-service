package com.jfeat.am.module.statistics.services.service;

import com.jfeat.am.common.crud.CRUDServiceOnly;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecordAttr;

import java.util.List;


/**
 * <p>
 *  service interface
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
public interface StatisticsRecordAttrService extends CRUDServiceOnly<StatisticsRecordAttr> {

    List<StatisticsRecordAttr> getStatisticsRecordAttrByFieldId(Long fieldId);
}
