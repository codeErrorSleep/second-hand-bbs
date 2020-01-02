package com.example.demo5.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void saveFile(MultipartFile file,String path,String producttile) throws IllegalStateException,
            IOException {

        path=path+File.separator+producttile;

        // 获取上传的文件名称，并结合存放路径，构建新的文件名称
        String filename = file.getOriginalFilename();
        File filepath = new File(path, filename);

        // 判断路径是否存在，不存在则新创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
//        System.out.println("\n"+filepath);
        System.out.println("filename\n"+filename);
//        System.out.println("\n"+path);

        // 将上传文件保存到目标文件目录
        file.transferTo(new File(path + File.separator + filename));
    }



}
