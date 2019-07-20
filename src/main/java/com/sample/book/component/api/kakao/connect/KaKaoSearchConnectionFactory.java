package com.sample.book.component.api.kakao.connect;

import org.springframework.lang.Nullable;

import com.sample.book.component.api.httpconnect.ConnectionData;
import com.sample.book.component.api.httpconnect.ConnectionFactory;
import com.sample.book.component.api.httpconnect.ServiceProvider;
import com.sample.book.component.api.httpconnect.client.RestTemplateOperations;
import com.sample.book.component.api.kakao.client.KaKaoSearchApi;

public class KaKaoSearchConnectionFactory extends ConnectionFactory<KaKaoSearchApi> {

	public KaKaoSearchConnectionFactory(String providerId, RestTemplateOperations restTemplateOperations, String auth) {
		super(providerId, new KaKaoSearchServiceProvider(restTemplateOperations, auth));
	}

	@Override
	protected KaKaoSearchApi getApi(ServiceProvider<KaKaoSearchApi> serviceProvider, @Nullable ConnectionData connection) {
		return serviceProvider.getApi(connection);
	}

}