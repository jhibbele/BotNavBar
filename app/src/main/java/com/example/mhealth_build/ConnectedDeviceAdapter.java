package com.example.mhealth_build;
// Array adapter hold information about each device connection as well as displaying it on the screen

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ConnectedDeviceAdapter extends RecyclerView.Adapter<ConnectedDeviceAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView deviceAddress, connectingText, xVal, yVal, zVal, sensorLoco;
        ProgressBar connectingProgress;

        public ViewHolder(View convertView) {
            super(convertView);
            deviceAddress = (TextView) convertView.findViewById(R.id.status_mac_address);
            connectingText = (TextView) convertView.findViewById(R.id.text_connecting);
            xVal = (TextView) convertView.findViewById(R.id.xVal);
            yVal = (TextView) convertView.findViewById(R.id.yVal);
            zVal = (TextView) convertView.findViewById(R.id.zVal);
            sensorLoco = (TextView) convertView.findViewById(R.id.sensorLoco);
            connectingProgress = (ProgressBar) convertView.findViewById(R.id.connecting_progress);
        }
    }

    //Store member variable for attached devices
    private List<DeviceState> mConnectedDevices; //list or arraylist?

    public ConnectedDeviceAdapter(ArrayList<DeviceState> connectedDevices) {
        mConnectedDevices = connectedDevices;

    }

    @Override
    public ConnectedDeviceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertView = inflater.inflate(R.layout.sensor_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ConnectedDeviceAdapter.ViewHolder viewHolder, int position) {

//
//        viewHolder = new ViewHolder(convertView);
//        viewHolder.deviceAddress = convertView.findViewById(R.id.status_mac_address);
//        viewHolder.sensorLoco = convertView.findViewById(R.id.sensorLoco);
//        viewHolder.xVal = convertView.findViewById(R.id.xVal);
//        viewHolder.yVal = convertView.findViewById(R.id.yVal);
//        viewHolder.zVal = convertView.findViewById(R.id.zVal);
//        viewHolder.connectingText = convertView.findViewById(R.id.text_connecting);
//        viewHolder.connectingProgress = convertView.findViewById(R.id.connecting_progress);
//

        DeviceState state = mConnectedDevices.get(position);

        // Set position name based on order of connection, will be automated in a future version using calibration process
        if (position <= 0) {
            viewHolder.sensorLoco.setText("Medial Chest");
        } else {
            viewHolder.sensorLoco.setText("Anterior Thigh");
        }

        // set the last two characters of the device address to text view
        viewHolder.deviceAddress.setText(state.btDevice.getAddress().substring(15, 17));

        // holds state of connection for progress bar, once connected shows x, y, z components of accel
        if (state.connecting) {
            viewHolder.connectingProgress.setVisibility(View.VISIBLE);
            viewHolder.connectingText.setVisibility(View.VISIBLE);
        } else {
            viewHolder.xVal.setVisibility(View.VISIBLE);
            viewHolder.yVal.setVisibility(View.VISIBLE);
            viewHolder.zVal.setVisibility(View.VISIBLE);
            if (state.xVal != null) {
                viewHolder.xVal.setText(state.xVal);
                viewHolder.yVal.setText(state.yVal);
                viewHolder.zVal.setText(state.zVal);
            }
            viewHolder.connectingProgress.setVisibility(View.GONE);
            viewHolder.connectingText.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {return mConnectedDevices.size();}

//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//
//
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_list, parent, false);
//
//            viewHolder = new ViewHolder(convertView);
//            viewHolder.deviceAddress = convertView.findViewById(R.id.status_mac_address);
//            viewHolder.sensorLoco = convertView.findViewById(R.id.sensorLoco);
//            viewHolder.xVal = convertView.findViewById(R.id.xVal);
//            viewHolder.yVal = convertView.findViewById(R.id.yVal);
//            viewHolder.zVal = convertView.findViewById(R.id.zVal);
//            viewHolder.connectingText = convertView.findViewById(R.id.text_connecting);
//            viewHolder.connectingProgress = convertView.findViewById(R.id.connecting_progress);
//
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//
//        }
//
//
//        DeviceState state = mConnectedDevices.get(position);
//
//        // Set position name based on order of connection, will be automated in a future version using calibration process
//        if (position <= 0) {
//            viewHolder.sensorLoco.setText("Medial Chest");
//        } else {
//            viewHolder.sensorLoco.setText("Anterior Thigh");
//        }
//
//        // set the last two characters of the device address to text view
//        viewHolder.deviceAddress.setText(state.btDevice.getAddress().substring(15, 17));
//
//        // holds state of connection for progress bar, once connected shows x, y, z components of accel
//        if (state.connecting) {
//            viewHolder.connectingProgress.setVisibility(View.VISIBLE);
//            viewHolder.connectingText.setVisibility(View.VISIBLE);
//        } else {
//            viewHolder.xVal.setVisibility(View.VISIBLE);
//            viewHolder.yVal.setVisibility(View.VISIBLE);
//            viewHolder.zVal.setVisibility(View.VISIBLE);
//            if (state.xVal != null) {
//                viewHolder.xVal.setText(state.xVal);
//                viewHolder.yVal.setText(state.yVal);
//                viewHolder.zVal.setText(state.zVal);
//            }
//            viewHolder.connectingProgress.setVisibility(View.GONE);
//            viewHolder.connectingText.setVisibility(View.GONE);
//        }
//        return convertView;
//    }
}
//

//


//
//
    // updates the elements that are not static (x,y,z components of accel)
//    public void update(DeviceState newState) {
//        int pos = getPosition(newState);
//        if (pos == -1) {
//            add(newState);
//        } else {
//            DeviceState current = getItem(pos);
//        }
//    }

//    public int getItemCount() {
//        return state.length;
//    }
//
//}                                                                                                                                                                                    