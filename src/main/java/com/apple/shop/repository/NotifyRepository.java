package com.apple.shop.repository;

import com.apple.shop.entity.Notify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotifyRepository extends JpaRepository<Notify, Integer> {
}
