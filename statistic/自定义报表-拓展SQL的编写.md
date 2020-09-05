## 自定义报表-拓展SQL的编写.md

###类型定义
```
    public static final String DECIMAL="D";//金钱
    public static final String TIME="T";//时间
    public static final String PERCENT="P";//百分比
    public static final String COUNT="C";//数量
    public static final String STRING="S";//字符串
```

### 普通查询sql

1. 按照一般的sql写法来，但最终返回的字段名要改为中文。

### 自动报表新增标签的用法

#### @if标签使用：
1. 用法：在sql任意位置 以@if开始@end结束
```
@if[判断条件] 可用符号：&& || ( ) + - * / > < == !=  暂不支持<= >=
    此处填充sql 需要替换的变量用#{变量}
@end
```

2.根据定义的类型可以分为两种：
- 字符类型:S
- 区段类型：T,D,C,P 若定义为区段类型，则前端传数据的时候会组装成数组传递

**区段类型的使用示例**
```
 @if[时间$left!=null&& 时间$right!=null] 							
	and o.created_date > #{时间$left}
    and o.created_date < #{时间$right}
@end
```
**字符类型的使用示例**
```
@if[盟友!=null]
   and a.alliance_name like %#{盟友}%
@end
```


**额外说明**
P字段在后台进行处理 *10000/100