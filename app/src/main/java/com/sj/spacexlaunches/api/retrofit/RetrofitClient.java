package com.sj.spacexlaunches.api.retrofit;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitAPIInterface apiInterface;
    private static final String BASE_URL = "https://api.spacexdata.com/v3/";

    public static RetrofitAPIInterface getClient() {
        if (apiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(RetrofitAPIInterface.class);
        }
        return apiInterface;
    }
    private static OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(30, TimeUnit.SECONDS);
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();


                //for auth tokens
                //String authToken = App.getInstance().getSessionManager().getX_AUTH_TOKEN();
                //if (!StringUtils.isEmpty(authToken)) {
                //    builder.addHeader("X-AUTH-TOKEN", authToken);
                //}
                request = builder.build();
                return chain.proceed(request);
            }
        });
        return httpClient.build();
    }
}
