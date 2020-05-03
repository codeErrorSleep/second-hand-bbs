package com.example.demo5.controller;


import com.example.demo5.domain.AdminUser;
import com.example.demo5.domain.Announce;
import com.example.demo5.domain.Product;
import com.example.demo5.service.AnnounceService;
import com.example.demo5.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
* @Description:    管理员功能类
* @Author:         qiuShao
* @CreateDate:     20-5-3 下午8:50
*/
@Controller
@EnableAutoConfiguration
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;

//    管理员管理公告面板
    @RequestMapping("admin/announce-manage")
    public String adminAnnounceManage(Model model, HttpSession session,@PageableDefault(size = 8,
            sort = {"createTime"},
            direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("announceList",announceService.listAnnounce(pageable));
        return "admin/announce-manage";
    }

//    普通户用获取公告
    @RequestMapping("announce-manage")
    public String announceManage(Model model, HttpSession session,@PageableDefault(size = 8,
            sort = {"createTime"},
            direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("announceList",announceService.listAnnounce(pageable));
        return "announce-manage";
    }








    @RequestMapping("admin/announce-input")
    public String AnnounceInput(Model model, HttpSession session) {
        model.addAttribute("announce",new Announce());
        return "admin/announce-input";
    }

    //   上传公告信息
    @RequestMapping(value = "admin/uploadAnnounce", method = RequestMethod.POST)
    public String AnnounceInput(Announce announce, Model model, HttpSession session,@PageableDefault(size = 8,
            sort = {"createTime"},
            direction = Sort.Direction.DESC) Pageable pageable) throws IllegalStateException, IOException {

        announce.setAdminUser((AdminUser) session.getAttribute("adminuser"));
//        保存上传信息
        Announce p;
        p=announceService.saveAnnounce(announce);
        return "redirect:/admin/announce-manage";
    }


}
