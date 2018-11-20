package com.example.reijn.madlibs;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class InputActivity extends AppCompatActivity {

    Story story;
    int id;
    TextView words;
    TextView hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("storyId");
        InputStream Stream = getApplicationContext().getResources().openRawResource(id);
        story = new Story(Stream);
        words = (TextView) findViewById(R.id.textView2);
        words.setText(story.getPlaceholderRemainingCount() +" words remaining");
        hint = (TextView) findViewById(R.id.textView5);
        hint.setText(story.getNextPlaceholder());
    }
    protected void onSaveInstanceState(Bundle outState) {
        // save the stuff for memory management
        super.onSaveInstanceState(outState);
        outState.putSerializable("story",story);
        outState.putString("words", words.getText().toString());
        outState.putString("hint", hint.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {

        // Set the text for the saved text in the previous function
        super.onRestoreInstanceState(inState);
        story = (Story) inState.getSerializable("story");
        words.setText(inState.getString("words"));
        hint.setText(inState.getString("hint"));

    }
    public void Clicked(View view) {
        TextInputLayout inputLayout = findViewById(R.id.textinput);
        if (inputLayout.getEditText().getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a anything", Toast.LENGTH_SHORT).show();
            return;

        }else {
            story.fillInPlaceholder(inputLayout.getEditText().getText().toString());
            hint.setText(story.getNextPlaceholder());
            inputLayout.getEditText().getText().clear();
            words.setText(story.getPlaceholderRemainingCount() + " words remaining");
        }

        if(story.isFilledIn() == true){
            Intent intent = new Intent(InputActivity.this, DisplayActivity.class);
            intent.putExtra("story", story.toString());
            intent.putExtra("storyId", R.raw.madlib1_tarzan);
            startActivity(intent);
        }




    }

    public void Views() {

    }

}
