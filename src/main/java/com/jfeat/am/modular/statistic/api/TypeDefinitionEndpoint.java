package com.jfeat.am.modular.statistic.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.common.persistence.model.TypeDefinition;
import com.jfeat.am.modular.statistic.service.TypeDefinitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/adm/type_definitions")
public class TypeDefinitionEndpoint extends BaseController{

    @Resource
    TypeDefinitionService typeDefinitionService;

    @GetMapping
    public Tip getTypeDefinitions(){
        List<TypeDefinition> typeDefinitions = typeDefinitionService.getTypeDefinitions();
        return SuccessTip.create(typeDefinitions);
    }
}
