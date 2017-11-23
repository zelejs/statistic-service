package com.jfeat.am.modular.statistic.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jfeat.am.modular.statistic.persistence.dao.TypeDefinitionMapper;
import com.jfeat.am.modular.statistic.persistence.model.TypeDefinition;
import com.jfeat.am.modular.statistic.service.TypeDefinitionService;
import com.jfeat.am.modular.statistic.wrapper.TypeDefinitionWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@Service
public class TypeDefinitionServiceImpl extends ServiceImpl<TypeDefinitionMapper,TypeDefinition>implements TypeDefinitionService {

    public List<TypeDefinition> getTypeDefinitions(){
        return selectList(new EntityWrapper<TypeDefinition>());
    }

    public boolean updateTypeDefinition(long id,TypeDefinitionWrapper typeDefinitionWrapper){
        TypeDefinition typeDefinition = selectById(id);
        typeDefinition.setName(typeDefinitionWrapper.getName());
        return updateById(typeDefinition);
    }

}
