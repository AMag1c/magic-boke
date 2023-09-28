package com.magic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/Files")
public class FileUploadController {

    @RequestMapping("/photoUpload")
    public void photoUpload(@RequestParam MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();

            if (filename != null && !filename.equals("")){

                // 截取出文件名
                filename = filename.substring(filename.lastIndexOf("."));

                //获取时间
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

                filename = "magic_"+date + filename;

                String filepath = "F:\\Program code\\IDEA\\boke\\src\\main\\webapp\\image\\";
                System.out.println(filepath);

                file.transferTo(new File(filepath,filename));
            }
        }
    }
}
