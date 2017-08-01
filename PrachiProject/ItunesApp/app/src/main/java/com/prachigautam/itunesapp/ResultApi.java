package com.prachigautam.itunesapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by amar on 01-08-2017.
 */

public interface ResultApi  {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/search")
    Call<MusicPojo> searchMusic(@Query("term") String term);
}
