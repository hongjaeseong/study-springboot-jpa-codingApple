package com.apple.shop.repository;

import com.apple.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> // <엔터티명, id 컬럼타입>
{
    // 인터페이스와 동일한 이름의 class 자동 생성: DB 입출력을 도와주는 다양한 메소드 존재
}
