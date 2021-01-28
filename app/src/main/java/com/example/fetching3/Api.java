package com.example.fetching3;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Api {


    //String BASE_URL = "http://10.0.2.2/~andrewchao/";
    //@GET("Apppi.php")
    String BASE_URL = "http://10.0.2.2/~andrewchao/phpMyAdmin-5.0.4/";
    @GET("Apii.php")
    Call<List<Details_Pojo>> getstatus();

}
