#统计

### 统计SQL写法参考
```sql
SELECT field,record_name,record_time,
  max(case when field_name='field1' then value else 0 end) AS '点赞数',
  max(case when field_name='field2' then value else 0 end) AS '阅读数',
  max(case when field_name='field3' then value else 0 end) AS '文章名称'
FROM st_statistic_record group by field, record_name, record_time;
```
