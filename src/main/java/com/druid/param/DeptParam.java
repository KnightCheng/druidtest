package com.druid.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.management.loading.PrivateClassLoader;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class DeptParam {

    private Integer id;

    @NotBlank(message = "部门名称不能为空")
    @Length(max=15,min=2,message = "部门名称需要在之间")
    private String name;

    private Integer parentId=0;

    @NotNull(message = "顺序不能为空")
    private Integer seq;

    @Length(max = 150,message = "备注的长度须在150")
    private String remark;
}
