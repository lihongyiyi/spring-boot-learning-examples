package com.hongy.validation.dto;

import com.hongy.validation.annotation.Status;
import com.hongy.validation.groups.IGroup1;
import com.hongy.validation.groups.IGroup2;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author lihongy
 * @Created by on 2019/06/11 16:50.
 * @Description:
 */
@Data
public class OrderDTO {

    @NotBlank(message = "订单号不能为空",groups = IGroup2.class)
    @Length(min=10, max=10, groups = IGroup2.class) // 如果不指定message，就会默认使用org.hibernate.validator源码中的ValidationMessages_xxx.properties, 中文就会使用ValidationMessages_zh_CN.properties，但是使用这个，提示信息看不出是那个参数校验不通过
    private String orderId;

    @NotBlank(message = "客户名称不能为空", groups = IGroup1.class)
    private String customerName;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式有误")
    private String email;

    @NotBlank(message = "地址不能为空")
    private String address;

    @NotBlank(message = "状态不能为空")
    @Status // 使用自定义注解
    private String status;

    @NotNull(message = "产品信息不能为空")
    @Valid // 嵌套验证，需要使用@Valid。且通过@NotNull才进一步验证ProductDTO的参数
    private List<ProductDTO> productList;
}