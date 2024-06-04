package com.apple.shop.controller;

import com.apple.shop.entity.Notify;
import com.apple.shop.repository.NotifyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class NotifyController {

    @Autowired
    NotifyRepository notifyRepository;

    @GetMapping("notify")
    String notify(Model model){
        List<Notify> result = notifyRepository.findAll();
        System.out.println(result);
        model.addAttribute("notifies",result);

        return "notify.html";
    }
}
