package br.com.hermivaldo.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText time1;
    private EditText time2;
    public static final String PARAMENTO_TIMES = "TIMES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time1 = (EditText) findViewById(R.id.etTime1);
        time2 = (EditText) findViewById(R.id.etTime2);
    }

    public void comecarJogo(View view){

        String nomeTime1 =  time1.getText().toString();
        String nomeTime2 = time2.getText().toString();

        if (nomeTime1.isEmpty()){
            Toast.makeText(this," NOME DO TIME DA CASA NÃO INFORMADO " + nomeTime2, Toast.LENGTH_LONG).show();
            return;
        }

        if (nomeTime2.isEmpty()){
            Toast.makeText(this," NOME DO TIME VISITANTE NÃO INFORMADO " + nomeTime2, Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, GameActivity.class);
        ArrayList<String> list = new ArrayList<String>();
        list.add(nomeTime1);
        list.add(nomeTime2);

        intent.putStringArrayListExtra(PARAMENTO_TIMES, list);
        startActivity(intent);
    }
}
