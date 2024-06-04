package com.apple.shop.controller;

import com.apple.shop.entity.Item;
import com.apple.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 상품과 관련되 api 만 모아두기 위해 파일 생성
@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    public String list(Model model) {
        log.info("/GET /list");
        List<Item> result = itemRepository.findAll();
        System.out.println(result); // Item 클래스에 @ToString 설정해서 reuslt 안의 데이터를 확인할 수 있음

        // model.addAttribute("전달할데이터이름","데이터");
        model.addAttribute("items",result);

        return "list.html";
    }

    @GetMapping("/productCreate")
    public String productCreate() {
        log.info("/GET /productCreate");

        return "productCreate.html";
    }

    @PostMapping("/productCreate")
    public String addPost(@RequestParam String title, // productCreat.html 에서 input 값을 받을 때 @RequestParam or 그냥 매개변수도 ok
                          Integer price) {
        log.info("/POST /productCreate");
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);

        return "redirect:/list";
    }
    // 만약 페이지에 input 태그가 100개가 있다면 각각의 파라미터로 값을 받을 수 없다.
    // 파라미터에 Map 자료형을 사용해 한꺼번에 받을 수 있다.
//    @PostMapping("/productCreate")
//    public String addPost(@RequestParam Map formData) {
//
//        Map<String, Object> test = new HashMap<>();
//        test.put("name","kim");
//        test.put("age",20);
//        System.out.println(test.get("name"));
//
//        log.info("/POST /productCreate");
//        System.out.println(formData);
//
//        return "redirect:/list";
//    }

}
