package com.southwind.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "id不能为空")
    private Long id;
    @NotEmpty(message = "名字不能为空")
    @Length(min = 2, message = "名字长度不能小于2位")
    private String name;
    @Min(value = 60, message = "成绩必须大于60分")
    private double score;
}
