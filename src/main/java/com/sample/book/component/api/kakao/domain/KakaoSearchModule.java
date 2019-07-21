package com.sample.book.component.api.kakao.domain;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sample.book.component.api.kakao.domain.mixin.KaKaoSearchBookDataMixin;
import com.sample.book.component.api.kakao.domain.mixin.KaKaoSearchBookMixin;
import com.sample.book.component.api.kakao.domain.mixin.KaKaoSearchMetaMixin;

@SuppressWarnings("serial")
public class KakaoSearchModule extends SimpleModule {

	public KakaoSearchModule() {
		super("KakaoSearchModule");
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(KaKaoSearchBook.class, KaKaoSearchBookMixin.class);
		context.setMixInAnnotations(KaKaoSearchMeta.class, KaKaoSearchMetaMixin.class);
		context.setMixInAnnotations(KaKaoSearchBookData.class, KaKaoSearchBookDataMixin.class);
	}

}