package com.jfeat.am.module.statistics.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.common.crud.error.CRUDCode;
import com.jfeat.am.common.crud.error.CRUDException;
import com.jfeat.am.common.crud.impl.CRUDServiceGroupImpl;
import com.jfeat.am.module.statistics.services.service.persistence.dao.StatisticsGroupMapper;
import com.jfeat.am.module.statistics.services.service.persistence.model.StatisticsGroup;
import com.jfeat.am.module.statistics.services.service.StatisticsGroupService;
import org.springframework.stereotype.Service;

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
public class StatisticsGroupServiceImpl  extends CRUDServiceGroupImpl<StatisticsGroup> implements StatisticsGroupService {

    @Resource
    private StatisticsGroupMapper statisticsGroupMapper;

    @Override
    protected BaseMapper<StatisticsGroup> getGroupMapper() {
        return statisticsGroupMapper;
    }

    @Override
    public StatisticsGroup getGroupByName(String name) {
        List<StatisticsGroup> list = statisticsGroupMapper.selectList(
                new EntityWrapper<StatisticsGroup>()
                .eq("name", name));
        if(list==null || list.size()==0){
            return null;
        }
        if(list.size()>1){
            throw CRUDException.newException(CRUDCode.CRUD_SLAVE_KEY_NOT_PROVIDED);
        }
        return list.get(0);
    }
}


