package com.example.bluetoothclass3;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class BlueToothController {

    private BluetoothAdapter mAdapter;

    public BlueToothController() {
        mAdapter = BluetoothAdapter.getDefaultAdapter();
    }


    /**
     * 打开蓝牙
     * @param activity
     * @param requestCode
     */
    public void turnOnBlueTooth(Activity activity, int requestCode) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 打开蓝牙可见性
     * @param context
     */
    public void enableVisibly(Context context) {
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        context.startActivity(discoverableIntent);
    }

    /**
     * 查找设备
     */
    public void findDevice() {
        assert (mAdapter != null);
        mAdapter.startDiscovery();
    }

    /**
     * 获取绑定设备
     * @return
     */
    public List<BluetoothDevice> getBondedDeviceList() {
        return new ArrayList<>(mAdapter.getBondedDevices());
    }
}
