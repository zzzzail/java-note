# hibernate validator 提供的数据校验注解

* `@NotNull` 值不能为空
* `@Null` 值必须为空
* `@Pattern(regex=)` 字符串必须匹配正则表达式
* `@Size(min=, max=)` 集合的元素数量必须在min和max之间
* `@CreditCardNumber(ignoreNonDigitCharacters=)` 字符串必须是信用卡号(按美国的标准校验的)
* `@Email` 字符串必须是email地址
* `@Length(min=, max=)` 检查字符串长度
* `@NotBlank` 字符串必须有字符
* `@NotEmpty` 字符串不能为null, 集合必须有元素
* `@Range(min=, max=)` 数字必须大于等于min, 小于max
* `@SafeHtml` 字符串是安全的html
* `@URL` 字符串是合法的url
* `@AssertFalse` 值必须是false
* `@AssertTure` 值必须是true
* `@DecimalMax(value=, inclusive=)` 值必须小于等于(inclusive=true) / 小于(inclusive=false) value 属性指定的值, 可以注解在字符串类型的属性上.
* `@DecimalMin(value=, inclusive=)` 值必须大于等于(inclusive=true) / 大于(inclusive=false) value 属性指定的值, 可以注解在字符串类型的属性上.
* `@Digits(integer=, fraction=)` 数字格式检查, integer指定整数部分的最大长度, fraction指定小数部分的最大长度.
* `@Future` 值必须是未来的日期
* `@Past` 值必须是过去的日期
* `@Max(value=)` 值必须小于等于value指定的值, 不能注解在字符串类型的属性上.
* `@Min(value=)` 值必须大于等于value指定的值, 不能注解在字符串的属性上.
