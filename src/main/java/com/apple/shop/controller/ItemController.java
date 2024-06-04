package com.apple.shop.controller;

import com.apple.shop.entity.Item;
import com.apple.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// 상품과 관련되 api 만 모아두기 위해 파일 생성
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        System.out.println(result); // Item 클래스에 @ToString 설정해서 reuslt 안의 데이터를 확인할 수 있음

        // model.addAttribute("전달할데이터이름","데이터");
        model.addAttribute("items",result);

        return "list.html";
    }

}
