package com.scb.soonhui.webservice.controller;

import com.scb.soonhui.persistence.entity.BlogEntity;
import com.scb.soonhui.persistence.entity.UserEntity;
import com.scb.soonhui.service.services.BlogServices;
import com.scb.soonhui.service.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 1/5/17
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BlogController {

    @Autowired
    private BlogServices blogServices;

    @Autowired
    private UserServices userServices;

    // 查看所有博文
    @RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap) {
        List<BlogEntity> blogList = blogServices.findAllBlogs();
        modelMap.addAttribute("blogList", blogList);
        return "admin/blogs";
    }

    // 添加博文
    @RequestMapping(value = "/admin/blogs/add", method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap) {
        List<UserEntity> userList = userServices.findAllUsers();
        // 向jsp注入用户列表
        modelMap.addAttribute("userList", userList);
        return "admin/addBlog";
    }

    // 添加博文，POST请求，重定向为查看博客页面
    @RequestMapping(value = "/admin/blogs/addP", method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog") BlogEntity blogEntity) {
        // 打印博客标题
        System.out.println(blogEntity.getTitle());
        // 打印博客作者
        System.out.println(blogEntity.getUserByUserId().getNickname());
        // 存库
        blogServices.addBlog(blogEntity);
        // 重定向地址
        return "redirect:/admin/blogs";
    }

    // 查看博文详情，默认使用GET方法时，method可以缺省
    @RequestMapping("/admin/blogs/show/{id}")
    public String showBlog(@PathVariable("id") int id, ModelMap modelMap) {
        BlogEntity blog = blogServices.findBlogById(id);
        modelMap.addAttribute("blog", blog);
        return "admin/blogDetail";
    }

    // 修改博文内容，页面
    @RequestMapping("/admin/blogs/update/{id}")
    public String updateBlog(@PathVariable("id") int id, ModelMap modelMap) {
        // 是不是和上面那个方法很像
        BlogEntity blog = blogServices.findBlogById(id);
        List<UserEntity> userList = userServices.findAllUsers();
        modelMap.addAttribute("blog", blog);
        modelMap.addAttribute("userList", userList);
        return "admin/updateBlog";
    }

    // 修改博客内容，POST请求
    @RequestMapping(value = "/admin/blogs/updateP", method = RequestMethod.POST)
    public String updateBlogP(@ModelAttribute("blogP") BlogEntity blogEntity) {
        // 更新博客信息
        blogServices.updateBlog(blogEntity);
        return "redirect:/admin/blogs";
    }

    // 删除博客文章
    @RequestMapping("/admin/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        blogServices.deleteBlog(id);
        return "redirect:/admin/blogs";
    }
}