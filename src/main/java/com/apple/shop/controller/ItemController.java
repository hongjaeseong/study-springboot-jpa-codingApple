package com.apple.shop.controller;

import com.apple.shop.entity.Item;
import com.apple.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        model.addAttribute("items", result);

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
        Item item = new Item(); // Item 엔티티에서 object 하나 생성
        item.setTitle(title);
        item.setPrice(price);
        System.out.println(item);
        itemRepository.save(item);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) // @PathVariable: 유저가 URL 파라미터에 입력한 값 가져오기
    {
        // 유저가 URL 파라미터에 입력한 값(id) 출력해보기
        System.out.println(id);
        // id 를 사용해 해당하는 id 값의 Item 데이터 검색 및 result 에 저장
        Optional<Item> result = itemRepository.findById(id);
        // result 데이터가 있다면 출력해보기 (optional 자료형이라서 get() 붙여야 함)
        if (result.isPresent()) // optional 자료에서 뭔가를 출력할 때는 자료의 값을 체크하는 것이 좋은 관습
        {
            model.addAttribute("item", result.get()); // result 가 optional 자료형이라서 '.get()' 으로 데이터 가져옴
            return "detail.html";
        }
        else
        {
            return "redirect:/list";
        }
    }

}
