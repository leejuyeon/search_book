package com.sample.book.search.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.book.search.domain.SeletiveKeyword;

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public interface SeletiveRepository extends JpaRepository<SeletiveKeyword, Integer> {
	boolean existsByKeyword(String keyword);

	Optional<SeletiveKeyword> findByKeyword(String keyword);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE SeletiveKeyword s SET s.count = s.count + 1 WHERE s.keyword = :keyword")
	int increaseKeywordCount(String keyword);
}
