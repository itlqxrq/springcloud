package com.singularity.springcloud.controller;

import com.singularity.springcloud.domian.CommonResult;
import com.singularity.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:54
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Integer userId,
                                 @RequestParam("money") BigDecimal money){

        accountService.update(userId,money);

        return new CommonResult(200,"账户操作成功");
    }
}
