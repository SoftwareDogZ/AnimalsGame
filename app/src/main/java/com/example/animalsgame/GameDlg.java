package com.example.animalsgame;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import android.app.AlertDialog;

public class GameDlg extends AppCompatActivity {

    //private MediaPlayer mp = new MediaPlayer();

    String[] animal_images = new String[]{"bird", "cat", "fish", "honey", "house", "pig", "sun"};

    int[] image_ids = new int[]{R.mipmap.birdartboard1xxxhdpi, R.mipmap.catartboard1xxxhdpi, R.mipmap.fishartboard1xxxhdpi,
    R.mipmap.honeyartboard1xxxhdpi, R.mipmap.houseartboard1xxxhdpi, R.mipmap.pigartboard1xxxhdpi, R.mipmap.sunartboard1xxxhdpi};

    int[] image_ok_ids = new int[]{R.mipmap.bird_okartboard1xxxhdpi, R.mipmap.cat_okartboard1xxxhdpi, R.mipmap.fish_okartboard1xxxhdpi,
    R.mipmap.honey_okartboard1xxxhdpi, R.mipmap.house_okartboard1xxxhdpi, R.mipmap.pig_okartboard1xxxhdpi, R.mipmap.sun_okartboard1xxxhdpi};

    int[] image_no_ids = new int[]{R.mipmap.bird_noartboard1xxxhdpi, R.mipmap.cat_noartboard1xxxhdpi, R.mipmap.fish_noartboard1xxxhdpi,
            R.mipmap.honey_noartboard1xxxhdpi, R.mipmap.house_noartboard1xxxhdpi, R.mipmap.pig_noartboard1xxxhdpi, R.mipmap.sun_noartboard1xxxhdpi};

    int[] image_indexes = new int[4];

    int correct_choice = 0;
    int user_choice = 0;

    int user_scores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamedlg);

        //final MediaPlayer mp = MediaPlayer.create(this, R.raw.supermario);
        //mp.start();

        ResetImages();

        ((ImageView) findViewById(R.id.image_one)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_choice = image_indexes[0];
                DetermineChoice(user_choice, R.id.image_one);
            }
        });

        ((ImageView) findViewById(R.id.image_two)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_choice = image_indexes[1];
                DetermineChoice(user_choice, R.id.image_two);
            }
        });

        ((ImageView) findViewById(R.id.image_three)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_choice = image_indexes[2];
                DetermineChoice(user_choice, R.id.image_three);
            }
        });

        ((ImageView) findViewById(R.id.image_four)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_choice = image_indexes[3];
                DetermineChoice(user_choice, R.id.image_four);
            }
        });

        ((Button) findViewById(R.id.next_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetImages();
            }
        });

        ((TextView) findViewById(R.id.userscores_textview)).setText(String.valueOf(user_scores));
    }


    //Reset the four images displayed
    public void ResetImages(){
        int[] temp = new int[]{0, 1, 2, 3, 4, 5, 6};

        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < 4;){
            int index = random.nextInt(7);
            if(temp[index] != -1){
                image_indexes[i] = temp[index];
                temp[index] = -1;
                i++;
            }
        }

        ((ImageView) findViewById(R.id.image_one)).setImageResource(image_ids[image_indexes[0]]);
        ((ImageView) findViewById(R.id.image_two)).setImageResource(image_ids[image_indexes[1]]);
        ((ImageView) findViewById(R.id.image_three)).setImageResource(image_ids[image_indexes[2]]);
        ((ImageView) findViewById(R.id.image_four)).setImageResource(image_ids[image_indexes[3]]);

        correct_choice = image_indexes[random.nextInt(4)];
        ((TextView) findViewById(R.id.animal_btn)).setText(animal_images[correct_choice]);

        ((Button) findViewById(R.id.next_btn)).setEnabled(false);

    }

    //Determine if the user's choice is correct
    public void DetermineChoice(int uc, int ucv){
        //user's choice is correct
        if(uc == correct_choice){
            ((ImageView) findViewById(ucv)).setImageResource(image_ok_ids[uc]);

            user_scores++;
            ((TextView) findViewById(R.id.userscores_textview)).setText(String.valueOf(user_scores));

            ((Button) findViewById(R.id.next_btn)).setEnabled(true);

        }
        else {

            ((ImageView) findViewById(ucv)).setImageResource(image_no_ids[uc]);

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Failed");
            dlg.setMessage("You have got " + String.valueOf(user_scores) + "scores! Try again!");
            dlg.setPositiveButton("Try again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    user_scores = 0;
                    ((TextView) findViewById(R.id.userscores_textview)).setText(String.valueOf(user_scores));
                    ResetImages();
                }
            });

            dlg.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dlg.show();
        }
    }
}
