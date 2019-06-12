package com.hongy.validation.dto;

import com.hongy.validation.annotation.Price;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @Author lihongy
 * @Created by on 2019/06/11 17:00.
 * @Description:
 */
@Data
public class ProductDTO {
    @NotBlank(message = "productName不能为空")
    private String productName;

    @NotNull(message = "price不能为空")
    // @Size(min = 8000, max = 10000, message = "错误的价格") 不能直接用@Size，@Size不支持BigDecimal类型。对于这种需求，可以自定义注解来实现
    // @Price // 可以使用自定义注解
    @Min(500) @Max(1000) // 或直接使用@@Min和@Max(1000)
    private BigDecimal price;
}