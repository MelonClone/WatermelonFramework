package org.watermelon.framework.utils.network;

import org.watermelon.framework.utils.network.httpconnection.HttpSender;
import org.watermelon.framework.utils.network.httpconnection.HttpConnectionException;
import org.watermelon.framework.utils.network.services.HttpConnectionService;
import org.watermelon.framework.utils.network.services.NetworkService;
import org.watermelon.framework.utils.network.services.RetrofitService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.watermelon.framework.global.consts.Constants.API_PROTOCOL;
import static org.watermelon.framework.global.consts.Constants.API_SERVER;

public class HttpManager {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static String BASE_URL = API_PROTOCOL + API_SERVER;

    public static <S> S createService(Class<S> serviceClass) {
        String url = BASE_URL;

        if (NetworkService.class.equals(serviceClass)) {
            url = BASE_URL;
        }

        if (serviceClass.isInstance(RetrofitService.class)) {
            return createRetrofitService(url, serviceClass);
        } else if (HttpConnectionService.class.equals(serviceClass)) {
            return createHttpService(url, serviceClass);
        } else {
            // default Retrofit
            return createRetrofitService(url, serviceClass);
        }
    }

    private static Retrofit.Builder getRetrofit(String url) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url);
    }

    private static <S> S createRetrofitService(String url, Class<S> serviceClass) {
        Retrofit retrofit = getRetrofit(url).client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    private static <S> S createHttpService(String url, Class<S> serviceClass) {
        try {
            // HttpConnectionService class generate
            S service = serviceClass.newInstance();

            // Create HttpSender
            HttpSender sender = new HttpSender(url);

            // Insert HttpSender into HttpConnectionService
            ((HttpConnectionService) service).setHttpSender(sender);
            return service;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        throw new HttpConnectionException();
    }
}
