package org.watermelon.framework.utils.network;

import org.watermelon.framework.utils.network.services.NetworkService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.watermelon.framework.global.consts.Constants.API_PROTOCOL;
import static org.watermelon.framework.global.consts.Constants.API_SERVER;

public class HttpManager {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder getRetrofit(String url) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url);
    }

    public static <S> S createService(Class<S> serviceClass) {
        String url = API_PROTOCOL + API_SERVER;

        if (NetworkService.class.equals(serviceClass)) {
            url = API_PROTOCOL + API_SERVER;
        }

        Retrofit retrofit = getRetrofit(url).client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
