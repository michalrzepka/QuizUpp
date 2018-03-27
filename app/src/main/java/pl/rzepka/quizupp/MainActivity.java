package pl.rzepka.quizupp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "pl.rzepka.quizupp.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view){
        Intent intent = new Intent (this, Welcome.class);
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString().trim();
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}
