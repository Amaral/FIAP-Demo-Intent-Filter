package br.com.fiap.mob.receivers;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void mostrarStatusCabo(View view){
        Intent i = new Intent(this, StatusCaboActivity.class);
        startActivity(i);

    }

    public void mostrarStatusConexao(View view){
        Intent i  = new Intent(this, StatusConexaoActivity.class);
        startActivity(i);
    }


}

