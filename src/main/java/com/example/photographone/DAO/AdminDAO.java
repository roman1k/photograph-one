package com.example.photographone.DAO;

import com.example.photographone.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<Admin,Integer> {
}
