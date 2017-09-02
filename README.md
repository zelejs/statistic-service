#统计

### 统计SQL写法参考
select  type_id,`group`,record_time,
max(case when field_name='field1' then value else 0 end) as '点赞数',
max(case when field_name='field2' then value else 0 end) as '阅读数',
max(case when field_name='field3' then value else 0 end) as '文章名称'
from st_statistic_record group by type_id,`group`,record_time;
