package com.sample.book.component.api.httpconnect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.lang.Nullable;

public class ListableOptions<T> {

	@Nullable
	private List<T> objects;

	public ListableOptions<T> add(T obj) {
		initObjects().add(obj);
		return this;
	}

	public ListableOptions<T> add(List<T> objs) {
		initObjects().addAll(objs);
		return this;
	}

	public List<T> build() {
		return objects == null ? Collections.emptyList() : objects;
	}

	private List<T> initObjects() {
		if (objects == null) {
			objects = new ArrayList<>();
		}
		return objects;
	}

}