package com.sample.book.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.book.search.domain.MyKeywordId;
import com.sample.book.search.domain.MySeletiveKeyword;
import com.sample.book.search.domain.SeletiveKeyword;
import com.sample.book.search.repository.MySeletiveRepository;
import com.sample.book.search.repository.SeletiveRepository;

@Service
public class KeywordService {
	@Autowired
	private MySeletiveRepository mySeletiveRepository;
	@Autowired
	private SeletiveRepository seletiveRepository;

	public List<MySeletiveKeyword> getMySeletiveKeyword(String userId, int size) {
		Optional<Page<MySeletiveKeyword>> keywords = mySeletiveRepository.findByMyKeywordIdUserId(userId,
				PageRequest.of(0, size, Sort.by(Sort.Direction.DESC, "searchTime")));

		if (keywords.isPresent())
			return keywords.get().getContent();
		else
			return new ArrayList<MySeletiveKeyword>();
	}

	public MySeletiveKeyword saveMyKeyword(String userId, String keyword) {
		MySeletiveKeyword my = new MySeletiveKeyword(new MyKeywordId(keyword, userId));
		return mySeletiveRepository.save(my);
	}

	public List<SeletiveKeyword> getPopluarayKeyword() {
		return seletiveRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "count"))).getContent();
	};

	public SeletiveKeyword getKeyword(String keyword) {
		Optional<SeletiveKeyword> data = seletiveRepository.findByKeyword(keyword);
		return data.orElse(new SeletiveKeyword());
	};

	public SeletiveKeyword saveSearchKeyword(String keyword, int count) {
		SeletiveKeyword seletive = new SeletiveKeyword(keyword, count);
		return seletiveRepository.save(seletive);
	}

	public boolean saveKeyword(String keyword) {
		// 키워드 저장
		if (seletiveRepository.existsByKeyword(keyword)) {
			seletiveRepository.increaseKeywordCount(keyword);
		} else {
			this.saveSearchKeyword(keyword, 1);
		}
		return true;
	}
}
