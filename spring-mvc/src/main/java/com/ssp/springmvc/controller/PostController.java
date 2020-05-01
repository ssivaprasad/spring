package com.ssp.springmvc.controller;

import com.ssp.springmvc.dto.Post;
import com.ssp.springmvc.dto.Todo;
import com.ssp.springmvc.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
@SessionAttributes("userId")
public class PostController {

    @Autowired
    private PostService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("list-posts")
    public String displayPostsPage(ModelMap model) {
        model.addAttribute("posts", service.retrievePosts((String) model.get("userId")));
        return "list-posts";
    }

    @GetMapping("/add-post")
    public String displayPostPage(ModelMap model) {
        model.addAttribute("post", new Post());
        return "post";
    }

    @GetMapping("/update-post")
    public String showUpdateTodoPage(@RequestParam Integer id, ModelMap model) {
        model.put("post", service.retrievePost(id));
        return "post";
    }

    @GetMapping("/delete-post")
    public String deleteTodo(@RequestParam int id) {
        service.deletePost(id);
        return "redirect:/list-posts";
    }

    @PostMapping("/add-post")
    public String addPost(ModelMap model, @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "post";
        }
        service.addPost((String) model.get("userId"), post.getTitle(), post.getContent(), new Date());
        return "redirect:/list-posts";
    }

    @PostMapping("/update-post")
    public String updateTodo(ModelMap model, @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "post";
        }

        post.setPostedBy((String) model.get("userId"));
        service.updatePost(post);
        return "redirect:/list-posts";
    }

}
