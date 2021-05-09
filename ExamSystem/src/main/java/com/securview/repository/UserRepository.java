package com.securview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securview.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
