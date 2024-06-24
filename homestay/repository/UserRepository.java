package com.csc3402.security.homestay.repository;

import com.csc3402.security.homestay.model.User;
import org.hibernate.annotations.CompositeTypeRegistrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
