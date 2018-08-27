package com.druid.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TestVo {

    @NotBlank(message="msg error")
    private String msg;

    @NotNull(message = "id is null")
    private Integer id;
}
