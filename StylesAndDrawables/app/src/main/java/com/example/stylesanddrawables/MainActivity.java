package com.example.stylesanddrawables;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.LevelListDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageButton Add;
ImageButton Decrease;
ImageButton OFF;
ImageView WIFI;
Integer i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WIFI = findViewById(R.id.Wifi);
        Add = findViewById(R.id.ADD);
        Decrease = findViewById(R.id.Decrease);
        LevelListDrawable D = (LevelListDrawable) WIFI.getBackground();
        i =0;
        WIFI.setImageResource(R.drawable.nosignal);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<3) {
                    i++;
                    WIFI.setImageLevel(i);
                    WIFI.setImageResource(R.drawable.image_change);
                }
            }
        });
        OFF = findViewById(R.id.OFF);
        OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WIFI.setImageResource(R.drawable.nosignal);
                i=0;
            }
        });

        Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i>0) {
                    i--;
                    WIFI.setImageLevel(i);
                    WIFI.setImageResource(R.drawable.image_change);

                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key",i);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
         super.onRestoreInstanceState(savedInstanceState);
         i = savedInstanceState.getInt("key");
    }
}
