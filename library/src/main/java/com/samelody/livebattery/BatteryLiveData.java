package com.samelody.livebattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.lifecycle.LiveData;

import static android.content.Intent.ACTION_BATTERY_CHANGED;
import static android.os.BatteryManager.EXTRA_HEALTH;
import static android.os.BatteryManager.EXTRA_LEVEL;
import static android.os.BatteryManager.EXTRA_PLUGGED;
import static android.os.BatteryManager.EXTRA_SCALE;
import static android.os.BatteryManager.EXTRA_STATUS;
import static android.os.BatteryManager.EXTRA_TEMPERATURE;
import static android.os.BatteryManager.EXTRA_VOLTAGE;

/**
 * A live data for monitoring Android battery.
 *
 * @author Belin Wu
 */
public class BatteryLiveData extends LiveData<BatteryInfo> {

    public static final int UNKNOWN = -1;

    /**
     * The battery broadcast receiver.
     */
    private BroadcastReceiver batteryReceiver;

    /**
     * The application context.
     */
    private Context context;

    public BatteryLiveData(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.context = context.getApplicationContext();
    }

    @Override
    protected void onActive() {
        super.onActive();
        registerBatteryReceiver();
    }

    private void registerBatteryReceiver() {
        if (batteryReceiver == null) {
            batteryReceiver = new BatteryReceiver();
        }
        IntentFilter intentFilter = new IntentFilter(ACTION_BATTERY_CHANGED);
        context.registerReceiver(batteryReceiver, intentFilter);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        context.unregisterReceiver(batteryReceiver);
    }

    /**
     * The battery broadcast receiver.
     */
    private class BatteryReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                setBatteryInfo(intent);
            }
        }
    }

    private void setBatteryInfo(Intent intent) {
        int status = intent.getIntExtra(EXTRA_STATUS, UNKNOWN);
        int plugged = intent.getIntExtra(EXTRA_PLUGGED, UNKNOWN);
        int health = intent.getIntExtra(EXTRA_HEALTH, UNKNOWN);
        int level = intent.getIntExtra(EXTRA_LEVEL, UNKNOWN);
        int temperature = intent.getIntExtra(EXTRA_TEMPERATURE, UNKNOWN);
        int scale = intent.getIntExtra(EXTRA_SCALE, UNKNOWN);
        int voltage = intent.getIntExtra(EXTRA_VOLTAGE, UNKNOWN);

        BatteryInfo info = new BatteryInfo();
        info.setStatus(status);
        info.setHealth(health);
        info.setLevel(level);
        info.setPlugged(plugged);
        info.setTemperature(temperature);
        info.setScale(scale);
        info.setVoltage(voltage);

        setValue(info);
    }
}
