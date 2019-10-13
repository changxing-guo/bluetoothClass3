package com.example.bluetoothclass3;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DeviceAdapter extends BaseAdapter {

    private List<BluetoothDevice> mDate;
    private Context mContext;

    public DeviceAdapter(List<BluetoothDevice>  data, Context context) {
        mDate = data;
        mContext = context.getApplicationContext();
    }

    @Override
    public int getCount() {
        return mDate.size();
    }

    @Override
    public Object getItem(int position) {
        return mDate.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null) {
            itemView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_2, parent, false);
        }
        TextView line1 = (TextView) itemView.findViewById(android.R.id.text1);
        TextView line2 = (TextView) itemView.findViewById(android.R.id.text2);
        //获取对应的蓝牙设备
        BluetoothDevice device = (BluetoothDevice) getItem(position);
        //显示名称
        line1.setText(device.getName());
        //显示地址
        line2.setText(device.getAddress());
        return itemView;
    }

    public void refresh(List<BluetoothDevice> data) {
        mDate = data;
        //一种观察者模式
        notifyDataSetChanged();
    }
}
