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

import java.util.Random;

public class ThreeSquare extends AppCompatActivity {
    TextView timeText;
    TextView scoreText;
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
    ImageView[] imageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_square);

        desciribing();

        hideImages();

        startGame();

    }

    private void desciribing(){
        score = 0;

        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);

        image1 = findViewById(R.id.imageView1);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView3);
        image4 = findViewById(R.id.imageView4);
        image5 = findViewById(R.id.imageView5);
        image6 = findViewById(R.id.imageView6);
        image7 = findViewById(R.id.imageView7);
        image8 = findViewById(R.id.imageView8);
        image9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[]{image1 , image2 , image3 , image4 , image5,
                                     image6 , image7 , image8 , image9 };

    }

    public void scoreImages(View view){
        score = score +1;
        scoreText.setText("Score = "+score);
    }

    private void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);
    }

    private void startGame(){
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                timeText.setText("Time : "+l/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time OFF");
                handler.removeCallbacks(runnable);

                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(ThreeSquare.this);
                alert.setTitle("Restart Game");
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
                        Intent intent = new Intent(ThreeSquare.this,MainActivity.class);
                        finish();
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }.start();
    }
}