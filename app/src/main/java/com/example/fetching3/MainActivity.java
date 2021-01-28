package com.example.fetching3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView nametxt, agetxt, phonetxt;
    Button retrieveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt = (TextView) findViewById(R.id.nametxt);
        agetxt = (TextView) findViewById(R.id.agetxt);
        phonetxt = (TextView) findViewById(R.id.phonetxt);
        retrieveBtn = (Button) findViewById(R.id.retrieveBtn);

        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchData();
            }
        });
    }


    private void fetchData() {

        ///
//        Constraints constraints = new Constraints.Builder()
//                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .build();
//
//        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker.class,
//                15, TimeUnit.MINUTES)
//                .setConstraints(constraints)
//                .build();
//        androidx.work.WorkManager.getInstance().enqueueUniquePeriodicWork("tags",
//                ExistingPeriodicWorkPolicy.KEEP,periodicWorkRequest);

        ///

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<Details_Pojo>> call = api.getstatus();
        call.enqueue(new Callback<List<Details_Pojo>>() {
            @Override
            public void onResponse(Call<List<Details_Pojo>> call, Response<List<Details_Pojo>> response) {
                List<Details_Pojo> adslist = response.body();

                String name = adslist.get(0).getName();
                String age = adslist.get(0).getAge();
                String phone = adslist.get(0).getPhone();

                nametxt.setText(name);
                agetxt.setText(age);
                phonetxt.setText(phone);
            }
            @Override
            public void onFailure(Call<List<Details_Pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}