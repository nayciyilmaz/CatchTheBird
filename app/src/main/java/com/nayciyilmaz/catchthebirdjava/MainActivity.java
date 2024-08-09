package com.nayciyilmaz.catchthebirdjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageClose);

    }
    public void threeSquare(View view){
        //for 9 square
        Intent intent1 = new Intent(MainActivity.this,ThreeSquare.class);
        startActivity(intent1);
    }

    public void fourSquare(View view){
        //for 16 square
        Intent intent2 = new Intent(MainActivity.this,FourSquare.class);
        startActivity(intent2);
    }

    public void fiveSquare(View view){
        //for 25 square
        Intent intent3 = new Intent(MainActivity.this,FiveSquare.class);
        startActivity(intent3);
    }

   public void applicationClose(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Close Game");
        alert.setMessage("Are you sure you want to close the game?");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);
            }
        });
        alert.show();
   }
}