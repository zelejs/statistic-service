package com.jfeat.am.module.statistics.api;

import com.jfeat.am.module.statistics.services.crud.StatisticsMetaService;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api("统计 [Statistics] meta")
@RestController
@RequestMapping("/api/adm/stat/meta")
public class MetaEndpoing {

    @Autowired
    StatisticsMetaService statisticsMetaService;

    @ApiOperation("获取所有组")
    @GetMapping("/{field}")
    public Tip getConfigGroupList(@PathVariable String field,
                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long current,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long size,
                                  HttpServletRequest request
                                  ) {
        return SuccessTip.create(statisticsMetaService.getByField(field,current,size,request));
    }

}
