package com.imooc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@RestController
@MapperScan("com.imooc.mapper")
public class ImoocVideoMiniApi {
    public static void main(String[] args) {
        SpringApplication.run(ImoocVideoMiniApi.class,args);
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
