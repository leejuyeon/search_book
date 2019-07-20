package com.sample.book.component.api.httpconnect;

import org.springframework.lang.Nullable;

@FunctionalInterface
public interface ServiceProvider<A> {

	A getApi(@Nullable ConnectionData connection);

	default A getApi() {
		return getApi(null);
	}

}