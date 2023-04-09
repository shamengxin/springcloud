package com.shamengxin.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.shamengxin.entity.Product;
import com.shamengxin.feiginclient.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class CategoryController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/category")
    public String category(){
        log.info("category service.....");

        //1.RestTemplate 2.RestTemplate+Ribbon 3.OpenFeign
        // String result = productClient.test("小黑", 23);
        // String result = productClient.test1(23, "小明");
        // String result = productClient.test2(new Product(1, "超短裙", 23.12, new Date()));
        // String result = productClient.test3(new String[]{"21", "22", "23"});
        // String result = productClient.test4(new String[]{"21", "22", "23"});
        // Product product = productClient.product(21);
        // log.info("product:{}",product);
        // List<Product> products = productClient.findByCategoryId(1);
        // products.forEach(product -> {
        //     log.info("product:{}",product);
        // });
        /*String result = productClient.findByCategoryIdAndPage(1, 4, 1);
        System.out.println(result);

        //自定义json反序列化
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject.get("total"));
        Object rows = jsonObject.get("rows");
        System.out.println(rows);

        //二次json反序列化
        List<Product> products = JSONObject.parseArray(rows.toString(), Product.class);
        products.forEach(product -> {
            log.info("product:{}",product);
        });*/

        String result = productClient.product();
        return result;
    }

}
