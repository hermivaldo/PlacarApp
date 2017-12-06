package br.com.hermivaldo.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void marcarGol(View view){

        Integer idBtnClicado = view.getId();
        TextView txtPla;
        int valorVP;
        switch (idBtnClicado){
            case (R.id.btGolTime1):
                findViewById(R.id.timeCasaPlacar);
                txtPla = (TextView) findViewById(R.id.timeCasaPlacar);
                valorVP = Integer.parseInt(txtPla.getText().toString());
                valorVP++;

                txtPla.setText(String.valueOf(valorVP));
                //Toast.makeText(this, "BTn1", Toast.LENGTH_SHORT).show();
            break;
            case (R.id.btGolTime2):
                txtPla = (TextView) findViewById(R.id.timeVisitantePlacar);
                valorVP = Integer.parseInt(txtPla.getText().toString());
                valorVP++;
                txtPla.setText(String.valueOf(valorVP));
                //Toast.makeText(this, "BTn2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
