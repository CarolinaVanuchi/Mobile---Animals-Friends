package com.example.mariacarolina.animalsfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callScreenAdoptionList(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AdoptionList.class);
        startActivity(intent);
    }

    public void callScreenMistreatmentList(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MistreatmenList.class);
        startActivity(intent);
    }

}
