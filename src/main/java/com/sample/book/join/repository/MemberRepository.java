package com.sample.book.join.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.book.join.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findById(Long id);
	Member findByUemail(String uemail);
}
