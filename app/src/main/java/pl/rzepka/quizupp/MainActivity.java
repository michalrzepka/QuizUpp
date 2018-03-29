package pl.rzepka.quizupp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String name;

    public static final String EXTRA_NAME = "pl.rzepka.quizupp.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent (this, QuizQuestions.class);
        EditText editText = (EditText) findViewById(R.id.name);
        name = editText.getText().toString().trim();
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}
