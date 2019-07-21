package com.sample.book.component.api.naver.domain;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sample.book.component.api.naver.domain.mixin.NaverSearchBookDataMixin;
import com.sample.book.component.api.naver.domain.mixin.NaverSearchBookMixin;

@SuppressWarnings("serial")
public class NaverSearchModule extends SimpleModule {

	public NaverSearchModule() {
		super("NaverSearchModule");
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(NaverSearchBook.class, NaverSearchBookMixin.class);
		context.setMixInAnnotations(NaverSearchBookData.class, NaverSearchBookDataMixin.class);
	}

}