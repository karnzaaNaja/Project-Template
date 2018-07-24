package com.example.msi_gl62.simpelapp.edr.setuniversity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://www.grandats.com/app_data/edrbasecenter/files/";

    @GET("edr_customer.json")
    Call<List<Hero>> getHeroes();
}
