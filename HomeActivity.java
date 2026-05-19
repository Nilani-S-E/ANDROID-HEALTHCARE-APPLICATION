package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView exit= findViewById(R.id.cardExit);
        CardView findDoctor= findViewById(R.id.cardFindDoctor);
        CardView labTest= findViewById(R.id.cardLabTest);
        CardView orderDetails= findViewById(R.id.cardOrderDetails);
        CardView buyMedicine = findViewById(R.id.cardBuyMedicine);
        CardView health = findViewById(R.id.cardHealthDoctor);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username= sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome"+username,Toast.LENGTH_SHORT).show();


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });


        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));
            }
        });


        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LabTestActivity.class));
            }
        });


        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, OrderDetailsActivity.class));
            }
        });


        buyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,BuyMedicineActivity.class));
            }
        });


        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,HealthArticlesActivity.class));
            }
        });
    }
}