package com.panding.main.perfecthttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/26.
 */

public class PerfectHttp {
    //public static String BASE_URL = "http://sf.swzcn.com/SwzInterface/gps/";
    //public static String BASE_URL = "http://10.0.3.58/SwzInterface/gps/";
    public static String BASE_URL = "http://wxsrv.swzcn.com/SwzInterface/gps/";

    //public static String BASE_URL = "http://10.10.2.151:8080/SwzInterface/gps/";

    //设置60read秒超时 10秒连接超时
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    private static Retrofit retrofit = builder.build();

    public static void changeApiBaseUrl(String newApiBaseUrl) {
        BASE_URL = newApiBaseUrl;
        builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        retrofit = builder.build();
    }


    public static <S> S createService(Class<S> serviceClass){
        /*httpClient.connectTimeout(15, TimeUnit.SECONDS);
        builder.client(httpClient.build());
        retrofit = builder.build();*/
        //httpClient.connectTimeout(5, TimeUnit.SECONDS);
        return retrofit.create(serviceClass);
    }

}
