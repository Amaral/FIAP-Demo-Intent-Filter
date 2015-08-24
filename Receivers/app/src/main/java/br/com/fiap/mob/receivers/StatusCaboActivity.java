package br.com.fiap.mob.receivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class StatusCaboActivity extends ActionBarActivity {


    private ImageView ivEstadoCabo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_cabo);
        ivEstadoCabo = (ImageView) findViewById(R.id.ivEstadoCabo);
        verificarEstadoCabo();
    }


    private void verificarEstadoCabo() {

        if (isCaboUsbConecatado()) {
            ivEstadoCabo.setImageResource(R.mipmap.ic_usb_on);
        } else {
            ivEstadoCabo.setImageResource(R.mipmap.ic_usb_off);
        }
    }

    private boolean isCaboUsbConecatado() {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        return usbCharge;
    }


}
