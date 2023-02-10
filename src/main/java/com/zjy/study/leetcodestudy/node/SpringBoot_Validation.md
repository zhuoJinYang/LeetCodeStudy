参数校验依赖
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

空值检查：
@NotBlank   用于字符串,字符串不能为null也不能为空字符串
@NotEmpty   字符串同上,对于集合(Map,List,Set)不能为空,必须有元素
@NotNull    不能为null
@Null       必须为null

数值检查
@DecimalMax(value)  被注释的元素必须为数字,其值必须小于等于指定的值
@DecimalMin(value)  被注释的元素必须为数字,其值必须大于等于指定的值
@Digits(integer,fraction)   被注释的元素必须为数字,其值的整数部分精度为integer,小数部分精度为fraction
@Positive       被注释的元素必须为正数
@PositiveOrZero 	被注释的元素必须为正数或 0
@Max(value)     被注释的元素必须小于等于指定的值
@Min(value)     被注释的元素必须大于等于指定的值
@Negative       被注释的元素必须为负数
@NegativeOrZero     被注释的元素必须为负数或 0

Boolean检查
@AssertFalse	被注释的元素必须值为 false
@AssertTrue	    被注释的元素必须值为 true

长度检查
@Size(min,max)	被注释的元素长度必须在 min 和 max 之间，可以是 String、Collection、Map、数组

日期检查
@Future	    被注释的元素必须是一个将来的日期
@FutureOrPresent	被注释的元素必须是现在或者将来的日期
@Past	    被注释的元素必须是一个过去的日期
@PastOrPresent	被注释的元素必须是现在或者过去的日期

其他检查
@Email	被注释的元素必须是电子邮箱地址
@Pattern(regexp)	被注释的元素必须符合正则表达式