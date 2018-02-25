package com.jfeat.am.module.statistics.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.common.crud.error.CRUDCode;
import com.jfeat.am.common.crud.error.CRUDException;
import com.jfeat.am.common.crud.impl.CRUDServiceOverModelOneImpl;
import com.jfeat.am.core.support.BeanKit;
import com.jfeat.am.module.statistics.services.service.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import com.jfeat.am.module.statistics.services.service.StatisticsFieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@Service
public class StatisticsFieldServiceImpl
        extends CRUDServiceOverModelOneImpl<StatisticsField,StatisticsFieldModel,StatisticsRecord>
        implements StatisticsFieldService {

    @Resource
    private StatisticsFieldMapper statisticsFieldMapper;
    @Resource
    private StatisticsRecordMapper statisticsRecordMapper;

    static final String SLAVE_MASTER_ID = "field_id";


    @Override
    protected BaseMapper<StatisticsField> getMasterMapper() {
        return statisticsFieldMapper;
    }

    @Override
    public List<StatisticsField> getFieldListByChart(String chart) {
        return statisticsFieldMapper.selectList(new EntityWrapper<StatisticsField>()
                .eq("chart", chart));
    }

    @Override
    public StatisticsField getFieldByFieldName(String field) {
        List<StatisticsField> list = statisticsFieldMapper.selectList(new EntityWrapper<StatisticsField>()
                .eq("field", field));
        if(list==null || list.size()==0){
            return null;
        }
        if(list.size()>1){
            throw new CRUDException(CRUDCode.CRUD_SLAVE_KEY_NOT_PROVIDED);
        }
        return list.get(0);
    }

    @Override
    public List<StatisticsField> getFieldListByByGroupId(Long groupId) {
        return statisticsFieldMapper.selectList(new EntityWrapper<StatisticsField>()
                .eq("group_id", groupId));
    }

    @Override
    protected BaseMapper<StatisticsRecord> getSlaveMapper() {
        return statisticsRecordMapper;
    }

    @Override
    protected Class<StatisticsRecord> getSlaveClassName() {
        return StatisticsRecord.class;
    }

    @Override
    protected String getSlaveMasterField() {
        return SLAVE_MASTER_ID;
    }

    @Override
    protected Class<StatisticsField> masterClassName() {
        return StatisticsField.class;
    }

    @Override
    protected Class<StatisticsFieldModel> modelClassName() {
        return StatisticsFieldModel.class;
    }
}


