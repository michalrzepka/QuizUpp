package pl.rzepka.quizupp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizQuestions extends AppCompatActivity {

    int score;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.EXTRA_NAME);

        TextView textView = findViewById(R.id.welcome);
        String welcomeMessage = "Welcome, " + name + ".\nCheck your knowledge about Europe!";
        textView.setText(welcomeMessage);
    }

    public int countPoints(){

        score = 0;

        CheckBox question_1_answer_A = (CheckBox) findViewById(R.id.question_1_answer_A);
        CheckBox question_1_answer_B = (CheckBox) findViewById(R.id.question_1_answer_B);
        CheckBox question_1_answer_C = (CheckBox) findViewById(R.id.question_1_answer_C);
        CheckBox question_1_answer_D = (CheckBox) findViewById(R.id.question_1_answer_D);

        boolean question_1_wrong_answers = question_1_answer_B.isChecked();

        if (question_1_answer_A.isChecked() && !(question_1_wrong_answers)){ score+=1; } // adding 1 point per correct answer only if wrong answers are not checked
        if (question_1_answer_C.isChecked() && !(question_1_wrong_answers)){ score+=1; }
        if (question_1_answer_D.isChecked() && !(question_1_wrong_answers)){ score+=1; }

        RadioGroup question_2 = (RadioGroup) findViewById(R.id.question_2_answers);
        if (question_2.getCheckedRadioButtonId() == R.id.question_2_answer_C) { score+=3; }

        CheckBox question_3_answer_A = (CheckBox) findViewById(R.id.question_3_answer_A);
        CheckBox question_3_answer_B = (CheckBox) findViewById(R.id.question_3_answer_B);
        CheckBox question_3_answer_C = (CheckBox) findViewById(R.id.question_3_answer_C);
        CheckBox question_3_answer_D = (CheckBox) findViewById(R.id.question_3_answer_D);

        boolean question_3_wrong_answers = question_3_answer_B.isChecked() || question_3_answer_D.isChecked();

        if (question_3_answer_A.isChecked() && !(question_3_wrong_answers)){ score+=1; }
        if (question_3_answer_C.isChecked() && !(question_3_wrong_answers)){ score+=1; }

        RadioGroup question_4 = (RadioGroup) findViewById(R.id.question_4_answers);
        if (question_4.getCheckedRadioButtonId() == R.id.question_4_answer_C) { score+=3; }

        EditText question_5 = (EditText) findViewById(R.id.question_5_answer);
        int question_5_answer = Integer.parseInt(question_5.getText().toString());
        if (question_5_answer == 12) { score+=4; }

        return score;
    }

    public void submitQuiz(View view) {
        countPoints();
        Context context = getApplicationContext();
        String scoreMessage = "You scored " + score + "/15 points!";
        Toast toast = Toast.makeText(context,scoreMessage,Toast.LENGTH_LONG);
        toast.show();
    }
}
