package com.jfeat.am.modular.statistic.service;

import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.modular.statistic.wrapper.TypeDefinitionWrapper;

import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
public interface TypeDefinitionService {

    public List<TypeDefinition> getTypeDefinitions();

    public boolean updateTypeDefinition(long id,TypeDefinitionWrapper typeDefinitionWrapper);
}
