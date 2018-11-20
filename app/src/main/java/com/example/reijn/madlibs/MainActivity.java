package com.example.reijn.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simple(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        intent.putExtra("storyId", R.raw.madlib0_simple);
        startActivity(intent);
    }
    public void tarzan(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        intent.putExtra("storyId", R.raw.madlib1_tarzan);
        startActivity(intent);
    }
    public void university(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        intent.putExtra("storyId", R.raw.madlib2_university);
        startActivity(intent);
    }
    public void clothes(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        intent.putExtra("storyId", R.raw.madlib3_clothes);
        startActivity(intent);
    }
    public void dance(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        intent.putExtra("storyId", R.raw.madlib4_dance);
        startActivity(intent);
    }
}
