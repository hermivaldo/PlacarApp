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


    private TextView txtCasa;
    private TextView txtVisi;
    private int golCasa ;
    private int golVisitante ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        time1 = (TextView) findViewById(R.id.timeCasa);
        time2 = (TextView) findViewById(R.id.timeVisitante);
        txtCasa = (TextView) findViewById(R.id.timeCasaPlacar);
        txtVisi = (TextView) findViewById(R.id.timeVisitantePlacar);

        Intent intent = getIntent();
        ArrayList<String> times = intent.getStringArrayListExtra(MainActivity.PARAMENTO_TIMES);
        if (times != null) {
            time1.setText(times.get(0));
            time2.setText(times.get(1));
        }

        if (getIntent() != null){

            String tmCasa = getIntent().getStringExtra("GOLCASA");
            String tmVS  = getIntent().getStringExtra("GOLVISITANTE");

            txtCasa.setText(tmCasa);
            txtVisi.setText(tmVS);
        }

        if (savedInstanceState != null){

            golCasa = savedInstanceState.getInt("GOLCASA");
            golVisitante = savedInstanceState.getInt("GOLVISITANTE");

        }

        txtCasa.setText(String.valueOf(golCasa));
        txtVisi.setText(String.valueOf(golVisitante));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("GOLCASA", golCasa);
        outState.putInt("GOLVISITANTE", golVisitante);
    }

    public void marcarGol(View view){

        Integer idBtnClicado = view.getId();

        switch (idBtnClicado){
            case (R.id.btGolTime1):

                golCasa = Integer.parseInt(txtCasa.getText().toString());
                golCasa++;

                txtCasa.setText(String.valueOf(golCasa));
                //Toast.makeText(this, "BTn1", Toast.LENGTH_SHORT).show();
            break;
            case (R.id.btGolTime2):

                golVisitante = Integer.parseInt(txtVisi.getText().toString());
                golVisitante++;
                txtVisi.setText(String.valueOf(golVisitante));
                //Toast.makeText(this, "BTn2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
