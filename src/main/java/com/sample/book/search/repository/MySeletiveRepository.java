package com.sample.book.search.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.book.search.domain.MySeletiveKeyword;

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public interface MySeletiveRepository extends JpaRepository<MySeletiveKeyword, Integer> {
	Page<MySeletiveKeyword> findByMyKeywordIdUserId(String userId, Pageable pageable);
}
