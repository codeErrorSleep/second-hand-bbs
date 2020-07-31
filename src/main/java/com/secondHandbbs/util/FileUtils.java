package com.secondHandbbs.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
*   文件上传配置类
*@Author: qiuwenhao
*@date: 2020/7/29
*/
public class FileUtils {
    /**
     * 保存图片信息
     *@Author: qiuwenhao
     *@date: 2020/7/29
     */
    public static void saveFile(MultipartFile file,String path) throws IllegalStateException,
            IOException {
//        // 获取上传的文件名称，并结合存放路径，构建新的文件名称
        String filename = file.getOriginalFilename();

        File filepath = new File(path,filename);
        if(!filepath.getParentFile().exists()){
            filepath.getParentFile().mkdirs();
//            System.out.println(filepath.getParentFile());
        }
        // 将上传文件保存到目标文件目录
        file.transferTo(new File(path + File.separator + filename));





    }



}
