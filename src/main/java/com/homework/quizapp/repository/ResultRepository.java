package com.homework.quizapp.repository;

import com.homework.quizapp.entity.Result;
import com.homework.quizapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByUser(User user);
    List<Result> findResultsByUser(User user);
}
