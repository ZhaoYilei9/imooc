package com.imooc.controller;

import com.imooc.pojo.Bgm;
import com.imooc.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bgm")
public class BgmController {

    @Autowired
    private BgmService bgmService;
    @RequestMapping("list")
    public ResponseEntity getAll(){
        List<Bgm> bgms = bgmService.getAll();
        if (bgms == null || bgms.size() <1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(bgms);

    }
}
