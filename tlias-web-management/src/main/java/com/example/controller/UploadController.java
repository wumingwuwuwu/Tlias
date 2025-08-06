package com.example.controller;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    /**
     * 上传文件 - 参数名file
     */
    @PostMapping("/upload")
    public Result upload(String username, Integer age , MultipartFile file) throws Exception {
        log.info("上传文件：{}, {}, {}", username, age, file);
        if(!file.isEmpty()){
            file.transferTo(new File("D:\\images\\" + file.getOriginalFilename()));
        }
        return Result.success();
    }

}