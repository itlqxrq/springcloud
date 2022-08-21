package com.singularity.springcloud.controller;

import com.singularity.springcloud.domain.CommonResult;
import com.singularity.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:22
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;


    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Integer productId,
                                 @RequestParam("count") Integer count){
        storageService.update(productId,count);
        return new CommonResult(200,"库存扣减成功");
    }
}
