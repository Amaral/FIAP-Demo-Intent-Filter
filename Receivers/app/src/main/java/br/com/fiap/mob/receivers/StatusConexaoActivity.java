package br.com.fiap.mob.receivers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class StatusConexaoActivity extends ActionBarActivity {

    private ImageView ivEstadoConexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_conexao);
        ivEstadoConexao = (ImageView) findViewById(R.id.ivEstadoConexao);
        verificarEstadoWifi();
    }


    private void verificarEstadoWifi() {

        if (isWifiConectado()) {
            ivEstadoConexao.setImageResource(R.mipmap.ic_wifi_on);
        } else {
            ivEstadoConexao.setImageResource(R.mipmap.ic_wifi_off);
        }
    }

    private boolean isWifiConectado() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mWifi.isConnected();
    }

}
