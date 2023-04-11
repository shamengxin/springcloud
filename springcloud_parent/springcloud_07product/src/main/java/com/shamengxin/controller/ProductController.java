package com.shamengxin.controller;

import com.shamengxin.ProductApplication;
import com.shamengxin.entity.Product;
import com.shamengxin.vos.CollectionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/productList")
    public Map<String,Object> findByCategoryIdAndPage(Integer page,Integer rows, Integer categoryId){
        log.info("当前页：{} 每页显示记录条数：{} 当前类别id：{} ",page,rows,categoryId);
        //根据类别id分页查询符合当前页集合数据 List<Product>
        //根据类别id查询当前类别下总条数
        Map<String,Object> map = new HashMap<>();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"短裙",46.32,new Date()));
        products.add(new Product(2,"超短裙",46.32,new Date()));
        products.add(new Product(3,"连衣裙",46.32,new Date()));
        int total=100;
        map.put("rows",products);
        map.put("total",total);
        return map;
    }

    @GetMapping("/products")
    public List<Product> findByCategoryId(@RequestParam("categoryId") Integer categoryId){
        log.info("类别id：{}",categoryId);
        //调用业务逻辑根据类别id查询商品列表
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"短裙",46.32,new Date()));
        products.add(new Product(2,"超短裙",46.32,new Date()));
        products.add(new Product(3,"连衣裙",46.32,new Date()));
        return products;
    }

    //定义一个接口接收id类型参数，返回一个基于id查询的对象
    @GetMapping("/product/{id}")
    public Product product(@PathVariable("id") Integer id){
        log.info("id:{}",id);
        return new Product(id,"超短连衣裙",43.23,new Date());
    }

    //定义一个接口接收集合类型参数
    @GetMapping("/test4")
    public String test4(CollectionVo collectionVo){
        collectionVo.getIds().forEach(id->log.info("id:{}",id));
        return "test4 ok,当前服务端口为："+port;
    }

    //定义个接口接收数组类型参数
    @GetMapping("/test3")
    public String test3(@RequestParam("ids") String[] ids){
        for (String id : ids) {
            log.info("id:{}",id);
        }
        return "test3 ok,当前服务端口为："+port;
    }

    //定义一个接收对象类型参数接口
    @PostMapping("/test2")
    public String test2(@RequestBody Product product){
        log.info("product:{}"+product);
        return "test2 ok,当前服务端口为："+port;
    }

    //定义一个了零散类型参数接口 路径传递参数
    @GetMapping("/test1/{id}/{name}")
    public String test1(@PathVariable("id") Integer id,@PathVariable("name") String name){
        log.info("id:{}  name:{}",id,name);
        return "test1 ok,当前服务端口为："+port;
    }

    //定义一个零散类型参数接口 queryString
    @GetMapping("/test")
    public String test(String name,Integer age){
        log.info("name:{}   age：{}",name,age);
        return "test ok,当前服务端口为："+port;
    }

    @GetMapping("/product")
    public String product() throws InterruptedException {
        log.info("进入商品服务。。。。。");
        // Thread.sleep(2000);
        return "product ok,当前提供服务端口："+port;
    }

    @GetMapping("/list")
    public String list(HttpServletRequest request,String color){
        String header = request.getHeader("User-Name");
        System.out.println("获取请求头信息"+header);
        System.out.println("获取对应的请求参数"+color);

        log.info("商品列表服务");
        return "list ok当前提供服务端口："+port;
    }

}
