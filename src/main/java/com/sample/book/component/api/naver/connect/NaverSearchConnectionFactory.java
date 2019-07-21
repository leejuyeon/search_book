package com.sample.book.component.api.naver.connect;

import org.springframework.lang.Nullable;

import com.sample.book.component.api.httpconnect.ConnectionData;
import com.sample.book.component.api.httpconnect.ConnectionFactory;
import com.sample.book.component.api.httpconnect.ServiceProvider;
import com.sample.book.component.api.httpconnect.client.RestTemplateOperations;
import com.sample.book.component.api.naver.client.NaverSearchApi;

public class NaverSearchConnectionFactory extends ConnectionFactory<NaverSearchApi> {

	public NaverSearchConnectionFactory(String providerId, RestTemplateOperations restTemplateOperations, String auth, String secret) {
		super(providerId, new NaverSearchServiceProvider(restTemplateOperations, auth, secret));
	}

	@Override
	protected NaverSearchApi getApi(ServiceProvider<NaverSearchApi> serviceProvider, @Nullable ConnectionData connection) {
		return serviceProvider.getApi(connection);
	}

}