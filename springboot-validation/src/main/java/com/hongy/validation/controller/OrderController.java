package com.hongy.validation.controller;

import com.hongy.validation.dto.OrderDTO;
import com.hongy.validation.groups.IGroup1;
import com.hongy.validation.groups.IGroupSequence;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @Author lihongy
 * @Created by on 2019/06/11 17:09.
 * @Description:
 */
@Validated
@RestController
@RequestMapping("/order")
public class OrderController {

    // 指定@Validated({IGroup1.class})，将只会校验groups = IGroup1.class与不指定groups参数的属性
    @PostMapping("/add")
    @ResponseBody
    private String addOrder(@RequestBody @Validated({IGroup1.class}) OrderDTO orderDTO) {

        return "下单成功";
    }

    // 按照校验组序列@IGroupSequence依次校验
    @PostMapping("/update")
    @ResponseBody
    private String updateOrder(@RequestBody @Validated({IGroupSequence.class}) OrderDTO orderDTO) {

        return "订单修改成功";
    }

    // TODO 单个参数校验，不生效，具体原因还不知...20190612
    @GetMapping("/delete")
    @ResponseBody
    private String delOrder(@NotBlank(message = "订单号不能为空") @RequestParam(required = false) String orderId) {

        return "订单删除成功";
    }
}