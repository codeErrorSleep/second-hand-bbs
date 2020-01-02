package com.example.demo5.dao;

import com.example.demo5.domain.AdminUser;
import com.example.demo5.domain.Announce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceRepository extends JpaRepository<Announce,Long> {


}
