package com.jfeat.am.modular.statistic.api;

import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.modular.statistic.persistence.model.TypeDefinition;
import com.jfeat.am.modular.statistic.constant.StatisticPermission;
import com.jfeat.am.modular.statistic.service.TypeDefinitionService;
import com.jfeat.am.modular.statistic.wrapper.TypeDefinitionWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Silent-Y on 2017/9/2.
 */
@RestController
@RequestMapping("/api/adm/statistic_types")
public class TypeDefinitionEndpoint extends BaseController{

    @Resource
    TypeDefinitionService typeDefinitionService;

    @GetMapping
    @Permission(StatisticPermission.STATISTIC_VIEW)
    public Tip getTypeDefinitions(){
        List<TypeDefinition> typeDefinitions = typeDefinitionService.getTypeDefinitions();
        return SuccessTip.create(typeDefinitions);
    }

    @PutMapping("/{id}")
    @Permission(StatisticPermission.STATISTIC_UPDATE)
    public Tip updateTypeDefinition(@PathVariable long id,@RequestBody TypeDefinitionWrapper typeDefinitionWrapper){
        boolean result = typeDefinitionService.updateTypeDefinition(id,typeDefinitionWrapper);
        return SuccessTip.create(result);
    }
}
