package com.baizhi.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {
    //将上传的文件保存到本体路径
    public static void createFile(MultipartFile file1,String path){
        //获取文件名
        String name = file1.getOriginalFilename();
        System.out.println(name);
        //重新生成文件名
        String newFileName = UUID.randomUUID()+name;
        try {
            //制定本地文件储存的路径
            File file = new File(path);
            String canonicalPath = file.getCanonicalPath();
            //开始上传,将图片保存到制定的文件夹
            file1.transferTo(new File(canonicalPath+"/"+newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件上传路径获取失败");
        }

    }
}
