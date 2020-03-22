package com.example.bishal_quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private Button submitButton;
    private int score;
    private RadioGroup firstRadioGroup;
    private TextView editText;
    private CheckBox checkwater;
    private CheckBox checksand;
    private CheckBox checkice;
    private CheckBox checkcoffee;
    private RadioGroup secondRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        checkwater = findViewById(R.id.chk_water);
        checksand = findViewById(R.id.chk_sand);
        checkice = findViewById(R.id.chk_ice);
        checkcoffee = findViewById(R.id.chk_coffee);
        firstRadioGroup=findViewById(R.id.first_Radio_Group);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = 0;
                if (firstRadioGroup.getCheckedRadioButtonId() == R.id.radio_brinjal)
                {
                    score += 1;
                }
                if (secondRadioGroup.getCheckedRadioButtonId() == R.id.radio_tax) {
                    score += 1;
                }

                String userAnswer = editText.getText().toString();
                if (userAnswer.equalsIgnoreCase("solid") && userAnswer.equalsIgnoreCase("Solid")) {
                    score += 1;
                }

                if (checkwater.isChecked() && !checksand.isChecked() && !checkice.isChecked() && checkcoffee.isChecked()) {
                    score += 1;
                }

                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("SCORE", score + "/4");
                startActivity(intent);
            }
        });
    }
}
