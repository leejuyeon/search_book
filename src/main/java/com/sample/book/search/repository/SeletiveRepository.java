package com.sample.book.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.book.search.domain.SeletiveKeyword;

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public interface SeletiveRepository extends JpaRepository<SeletiveKeyword, Integer> {
	boolean existsByKeyword(String keyword);
	SeletiveKeyword findByKeyword(String keyword);
}
