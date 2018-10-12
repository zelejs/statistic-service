package com.jfeat.am.module.statistics.services.crud.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jfeat.am.common.crud.CRUD;
import com.jfeat.am.common.crud.CRUDFilter;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import com.jfeat.am.module.statistics.services.crud.StatisticsFieldService;
import com.jfeat.am.module.statistics.services.crud.StatisticsMetaService;
import com.jfeat.am.module.statistics.services.crud.model.StatisticsFieldModel;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsMetaMapper;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsRecordMapper;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsField;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsMeta;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-11-25
 */
@Service
public class StatisticsFieldServiceImpl implements StatisticsFieldService {

    @Resource
    StatisticsFieldMapper statisticsFieldMapper;
    @Resource
    StatisticsMetaMapper statisticsMetaMapper;
    @Resource
    StatisticsRecordMapper statisticsRecordMapper;

    @Resource
    DataSource dataSource;


    /**
     * 通过域名获取域数据
     */
    @Override
    public StatisticsField getStatisticFieldByName(String field) {
        StatisticsField queryItem = new StatisticsField();
        queryItem.setField(field);
        return statisticsFieldMapper.selectOne(queryItem);
    }

    @Override
    public StatisticsField getStatisticsFieldModel(String field, String identifier) {
        StatisticsField statisticsField = getStatisticFieldByName(field);
        if (statisticsField == null) {
            throw new BusinessException(BusinessCode.BadRequest);
        }

        StatisticsFieldModel model = CRUD.castObject(statisticsField, StatisticsFieldModel.class);


        /// query meta
        StatisticsMeta meta = new StatisticsMeta();
        meta.setField(field);
        meta = statisticsMetaMapper.selectOne(meta);

        if(meta!=null) {

            model.setMeta(meta);

            /// 如果需要实时查询，跳过获取统计项
            if (statisticsField.getAttrRuntime() > 0) {

                String sql = meta.getQuerySql();

                if (sql.length() > 0) {
                    //TODO, execute sql
                    //dataSource.

                    StatisticsRecord record = new StatisticsRecord();
                    //TODO,

                    model.addItem(record);
                }

                return statisticsField;
            }
        }


        // query items
        //
        Wrapper<StatisticsRecord> wrapper = new EntityWrapper<StatisticsRecord>().eq("field", field);
        if(identifier != null && !"".equals(identifier)) {
            wrapper.eq("identifier", identifier);
        }
        wrapper.orderBy("seq,record_tuple");
        List<StatisticsRecord> items = statisticsRecordMapper.selectList(wrapper);
        model.setItems(items);


        return model;
    }

    @Override
    public Integer createMaster(StatisticsField statisticsField) {
        return statisticsFieldMapper.insert(statisticsField);
    }

    @Override
    public Integer createMaster(StatisticsField statisticsField, CRUDFilter<StatisticsField> crudFilter) {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public Integer updateMaster(StatisticsField statisticsField) {
        return statisticsFieldMapper.updateAllColumnById(statisticsField);
    }

    @Override
    public Integer updateMaster(StatisticsField statisticsField, CRUDFilter<StatisticsField> crudFilter) {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public Integer updateMaster(StatisticsField statisticsField, boolean all) {
        if(all) {
            return statisticsFieldMapper.updateAllColumnById(statisticsField);
        }else{
            return statisticsFieldMapper.updateById(statisticsField);
        }
    }

    @Override
    public StatisticsField retrieveMaster(long id) {
        return statisticsFieldMapper.selectById(id);
    }

    @Override
    public Integer deleteMaster(long l) {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public List<StatisticsField> retrieveMasterList() {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public StatisticsField createdAndReturnMaster(StatisticsField statisticsField) {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public List<StatisticsField> selectMasterList() {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public List<StatisticsField> selectMasterList(Map<String, Object> map) {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public List<StatisticsField> selectMasterList(String s, Object o) {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public Integer bulkDeleteMasterList(List<Long> list) {
        throw new RuntimeException("fatal: Not support");
    }

    @Override
    public Integer bulkAppendMasterList(List<StatisticsField> list) {
        throw new RuntimeException("fatal: Not support");
    }
}
