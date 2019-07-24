package com.sample.book.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.search.domain.SeletiveKeyword;
import com.sample.book.search.repository.SeletiveRepository;

public class SelectiveRepositoryTest extends AbstractBookSearchApplicationTests {
	@Autowired
	private SeletiveRepository seletiveRepository;

	@Test
	public void saveKeyword() {
		SeletiveKeyword seletive = new SeletiveKeyword();
		seletive.setKeyword("강철");
		seletive.setCount(1);

		SeletiveKeyword result = seletiveRepository.save(seletive);

		assertNotNull(result);
	}
	
	@Test
	public void isExistsByKeyword() {
		boolean result = seletiveRepository.existsByKeyword("강철");
		assertFalse(result);
	}

	@Test
	public void getKeyword() {
		SeletiveKeyword result = seletiveRepository.findByKeyword("강철").get();
		assertNotNull(result);
	}

	@Test
	public void increaseKeywordCount() {
		assertNotNull(seletiveRepository.increaseKeywordCount("강철"));
	}
}