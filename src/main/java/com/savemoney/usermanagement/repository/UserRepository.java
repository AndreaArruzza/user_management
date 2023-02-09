package com.savemoney.usermanagement.repository;

import com.savemoney.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByIsValidIsTrueAndIdOrEmail(Long userId, String email);

    Optional<User> findByIdAndIsValidIsTrue(Long userId);

    List<User> findAllByIsValidIsTrue();
}
