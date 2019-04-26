package com.wipro.wiproregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        message = "from SECOND Activity!";
        Button backToFirstActivityButton = findViewById(R.id.button_second_activity);

        backToFirstActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("TAG_ACTIVITY_LIFE_CYCLE","ON CREATE " + message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG_ACTIVITY_LIFE_CYCLE","ON START " + message);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG_ACTIVITY_LIFE_CYCLE","ON RESTART " + message);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG_ACTIVITY_LIFE_CYCLE", "ON PAUSE " + message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG_ACTIVITY_LIFE_CYCLE", "ON RESUME " + message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG_ACTIVITY_LIFE_CYCLE", "ON STOP " + message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG_ACTIVITY_LIFE_CYCLE", "ON DESTROY " + message);
    }
}
