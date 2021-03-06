package com.jfeat.am.module.statistics.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.am.module.statistics.services.crud.StatisticsMetaService;
import com.jfeat.am.module.statistics.services.domain.dao.QueryStatisticsMetaDao;
import com.jfeat.am.module.statistics.services.domain.model.StatisticsMetaRecord;
import com.jfeat.am.module.statistics.services.gen.persistence.model.StatisticsMeta;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api("统计 [Statistics] meta")
@RestController
@RequestMapping("/api/adm/stat/meta")
public class MetaEndpoing {

    @Resource
    StatisticsMetaService statisticsMetaService;
    @Resource
    QueryStatisticsMetaDao queryStatisticsMetaDao;

    @ApiOperation("获取所有组")
    @GetMapping("/{field}")
    public Tip getConfigGroupList(@PathVariable String field,
                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Long current,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long size,
                                  HttpServletRequest request
                                  ) {
        return SuccessTip.create(statisticsMetaService.getByField(field,current,size,request));
    }



    @BusinessLog(name = "StatisticsMeta", value = "create StatisticsMeta")
    @PostMapping
    @ApiOperation(value = "新建 StatisticsMeta",response = StatisticsMeta.class)
    public Tip createStatisticsMeta(@RequestBody StatisticsMeta entity){

        Integer affected=0;
        try{
            affected= statisticsMetaService.createMaster(entity);

        }catch(DuplicateKeyException e){
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "StatisticsMeta", value = "查看 StatisticsMeta")
    @GetMapping("/getOne/{id}")
    @ApiOperation(value = "查看 StatisticsMeta",response = StatisticsMeta.class)
    public Tip getStatisticsMeta(@PathVariable Long id){
        return SuccessTip.create(statisticsMetaService.retrieveMaster(id));
    }

    @BusinessLog(name = "StatisticsMeta", value = "update StatisticsMeta")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 StatisticsMeta",response = StatisticsMeta.class)
    public Tip updateStatisticsMeta(@PathVariable Long id,@RequestBody StatisticsMeta entity){
        entity.setId(id);
        return SuccessTip.create(statisticsMetaService.updateMaster(entity));
    }

    @BusinessLog(name = "StatisticsMeta", value = "delete StatisticsMeta")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 StatisticsMeta")
    public Tip deleteStatisticsMeta(@PathVariable Long id){
        return SuccessTip.create(statisticsMetaService.deleteMaster(id));
    }

    @BusinessLog(name = "StatisticsMeta", value = "查询列表 StatisticsMeta")
    @ApiOperation(value = "StatisticsMeta 列表信息",response = StatisticsMetaRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name= "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "field", dataType = "String"),
            @ApiImplicitParam(name = "querySql", dataType = "String"),
            @ApiImplicitParam(name = "percent", dataType = "Integer"),
            @ApiImplicitParam(name = "icon", dataType = "String"),
            @ApiImplicitParam(name = "title", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "String"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "permission", dataType = "String") ,
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryStatisticsMetas(Page<StatisticsMetaRecord> page,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "querySql", required = false) String querySql,
            @RequestParam(name = "percent", required = false) Integer percent,
            @RequestParam(name = "icon", required = false) String icon,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "permission", required = false) String permission,
            @RequestParam(name = "orderBy", required = false) String orderBy,
            @RequestParam(name = "sort", required = false)  String sort) {
        if(orderBy!=null&&orderBy.length()>0){
            if(sort!=null&&sort.length()>0){
                String pattern = "(ASC|DESC|asc|desc)";
                if(!sort.matches(pattern)){
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            }else{
                sort = "ASC";
            }
            orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        StatisticsMetaRecord record = new StatisticsMetaRecord();
        record.setId(id);
        record.setField(field);
        record.setQuerySql(querySql);
        record.setPercent(percent);
        record.setIcon(icon);
        record.setTitle(title);
        record.setType(type);
        record.setPermission(permission);
        page.setRecords(queryStatisticsMetaDao.findStatisticsMetaPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }



}
