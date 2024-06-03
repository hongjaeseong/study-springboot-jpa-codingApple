package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

import static java.time.LocalTime.now;

@Controller
public class BasicController {

    @GetMapping("/") // 메인페이지에 접속하면
    String Main(){
        return "index.html"; // index.html 페이지로 이동
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "아주 멋진 사이트입니다!";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지입니다";
    }

    @GetMapping("/date")
    @ResponseBody
    String date(){
        return LocalDateTime.now().toString();
    }

}
