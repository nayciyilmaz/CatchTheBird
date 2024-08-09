package com.nayciyilmaz.catchthebirdjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Time;
import java.util.Random;

public class FiveSquare extends AppCompatActivity {
    TextView timeTextt;
    TextView scoreTextt;
    int score;
    Handler handler;
    Runnable runnable;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ImageView image10;
    ImageView image11;
    ImageView image12;
    ImageView image13;
    ImageView image14;
    ImageView image15;
    ImageView image16;
    ImageView image17;
    ImageView image18;
    ImageView image19;
    ImageView image20;
    ImageView image21;
    ImageView image22;
    ImageView image23;
    ImageView image24;
    ImageView image25;
    ImageView[] imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_square);

        desciribing();

        hideImages();

        startGame();

    }

    private void desciribing(){
        score = 0;

        timeTextt = findViewById(R.id.timeTextt);
        scoreTextt = findViewById(R.id.scoreTextt);

        image1 = findViewById(R.id.imageView1);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView3);
        image4 = findViewById(R.id.imageView4);
        image5 = findViewById(R.id.imageView5);
        image6 = findViewById(R.id.imageView6);
        image7 = findViewById(R.id.imageView7);
        image8 = findViewById(R.id.imageView8);
        image9 = findViewById(R.id.imageView9);
        image10 = findViewById(R.id.imageView10);
        image11 = findViewById(R.id.imageView11);
        image12 = findViewById(R.id.imageView12);
        image13 = findViewById(R.id.imageView13);
        image14 = findViewById(R.id.imageView14);
        image15 = findViewById(R.id.imageView15);
        image16 = findViewById(R.id.imageView16);
        image17 = findViewById(R.id.imageView17);
        image18 = findViewById(R.id.imageView18);
        image19 = findViewById(R.id.imageView19);
        image20 = findViewById(R.id.imageView20);
        image21 = findViewById(R.id.imageView21);
        image22 = findViewById(R.id.imageView22);
        image23 = findViewById(R.id.imageView23);
        image24 = findViewById(R.id.imageView24);
        image25 = findViewById(R.id.imageView25);

        imageViews = new ImageView[]{image1 , image2 , image3 , image4 , image5 , image6 , image7 , image8
                                       , image9 , image10 , image11 , image12 , image13 , image14 , image15 ,
                                       image16 , image17 , image18 , image19 , image20 , image21 , image22,
                                       image23 , image24 , image25};
    }

    private void startGame(){
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                timeTextt.setText("Time : "+l/1000);
            }

            @Override
            public void onFinish() {
                timeTextt.setText("Time Off");
                handler.removeCallbacks(runnable);

                for(ImageView image : imageViews){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(FiveSquare.this);
                alert.setTitle("Restart game");
                alert.setMessage("Are you sure to restart game ?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(FiveSquare.this,MainActivity.class);
                        finish();
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }.start();
    }

    public void chooseImage(View view){
        score = score+1;
        scoreTextt.setText("Score : "+score);
    }

    private void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageViews){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(25);
                imageViews[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,300);
            }
        };
        handler.post(runnable);
    }
}