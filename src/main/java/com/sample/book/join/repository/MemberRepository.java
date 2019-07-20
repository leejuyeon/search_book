package com.sample.book.join.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.book.join.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
