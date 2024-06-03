package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 상품과 관련되 api 만 모아두기 위해 파일 생성
@Controller
public class ItemController {

    @GetMapping("list")
    String list(Model model){
        // model.addAttribute("전달할데이터이름","데이터");
        model.addAttribute("name","홍재성");

        return "list.html";
    }

}
