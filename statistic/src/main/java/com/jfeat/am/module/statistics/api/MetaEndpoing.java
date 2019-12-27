package com.jfeat.am.module.statistics.api;

import com.jfeat.am.module.statistics.services.crud.StatisticsMetaService;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("统计 [Statistics]")
@RestController
@RequestMapping("/api/adm/stat/meta")
public class MetaEndpoing {

    @Autowired
    StatisticsMetaService statisticsMetaService;

    @ApiOperation("获取所有组")
    @GetMapping("/{field}")
    public Tip getConfigGroupList(@PathVariable String field) {
        return SuccessTip.create(statisticsMetaService.getByField(field));
    }

}
