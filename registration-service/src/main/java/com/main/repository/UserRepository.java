package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.modal.UserInformation;

@Repository
public interface UserRepository extends JpaRepository<UserInformation, String> {

}
