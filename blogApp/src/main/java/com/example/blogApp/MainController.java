package com.example.blogApp;

import com.example.blogApp.domain.Message;
import com.example.blogApp.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String home(Map<String,Object> model) {
        Iterable<Message>messages = messageRepo.findAll();
        model.put("messages", "messages");

        return "home";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String,Object> model){
        Message message = new Message(text,tag);
        messageRepo.save(message);

        Iterable<Message>messages = messageRepo.findAll();
        model.put("messages", "messages");

        return "main";
    }

}
