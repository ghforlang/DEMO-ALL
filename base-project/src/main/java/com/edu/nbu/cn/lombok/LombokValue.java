package com.edu.nbu.cn.lombok;


import lombok.Value;

// @Value = final @ToString +
// @EqualsAndHashCode +
// @AllArgsConstructor +
// @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE) +
// @Getter
@Value(staticConstructor = "valueOf")
public class LombokValue {
    private String name;
    private Integer age;
}
