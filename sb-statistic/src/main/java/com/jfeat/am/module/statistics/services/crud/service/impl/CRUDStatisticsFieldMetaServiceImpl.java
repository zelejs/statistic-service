package com.jfeat.am.module.statistics.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.FIELD;
import com.jfeat.am.module.statistics.services.persistence.model.StatisticsFieldMeta;
import com.jfeat.am.module.statistics.services.persistence.dao.StatisticsFieldMetaMapper;


import com.jfeat.am.module.statistics.services.crud.service.CRUDStatisticsFieldMetaService;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import org.springframework.stereotype.Service;
import com.jfeat.am.common.exception.BusinessCode;
import com.jfeat.am.common.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2018-07-20
 */

@Service
public class CRUDStatisticsFieldMetaServiceImpl  extends CRUDServiceOnlyImpl<StatisticsFieldMeta> implements CRUDStatisticsFieldMetaService {





        @Resource
        private StatisticsFieldMetaMapper statisticsFieldMetaMapper;

        @Override
        protected BaseMapper<StatisticsFieldMeta> getMasterMapper() {
                return statisticsFieldMetaMapper;
        }




}


