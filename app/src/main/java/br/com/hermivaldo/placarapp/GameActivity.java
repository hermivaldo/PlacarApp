package br.com.hermivaldo.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private TextView time1;
    private TextView time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        time1 = (TextView) findViewById(R.id.timeCasa);
        time2 = (TextView) findViewById(R.id.timeVisitante);

        Intent intent = getIntent();
        ArrayList<String> times = intent.getStringArrayListExtra(MainActivity.PARAMENTO_TIMES);
        if (times != null) {
            time1.setText(times.get(0));
            time2.setText(times.get(1));
        }

    }
}
