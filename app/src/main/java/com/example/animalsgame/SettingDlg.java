package com.example.animalsgame;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class SettingDlg extends AppCompatActivity {

    int bg_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_dlg);

        ImageView image_one = (ImageView) findViewById(R.id.bg_one);
        ImageView image_two = (ImageView) findViewById(R.id.bg_two);
        ImageView image_three = (ImageView) findViewById(R.id.bg_three);

        image_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg_index = 1;
                ResetBackground(bg_index);
            }
        });

        image_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg_index = 2;
                ResetBackground(bg_index);
            }
        });

        image_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg_index = 3;
                ResetBackground(bg_index);
            }
        });
    }

    //Reset the background of the app
    public void ResetBackground(int index){
        switch (index){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:break;
        }
    }
}
