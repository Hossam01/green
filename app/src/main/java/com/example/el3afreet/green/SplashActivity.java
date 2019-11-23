package com.example.el3afreet.green;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.example.el3afreet.green.NewFragment.BrightnessFragment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class SplashActivity extends AppCompatActivity  {

    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private final String DEVICE_ADDRESS="98:D3:21:FC:83:AE";
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");//Serial Port Service ID
    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    boolean deviceConnected=false;
    Thread thread;
    byte buffer[];
    int bufferPosition;
    boolean stopThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //beginListenForData();
        if (BTinit()) {
           if (BTconnect())
           { beginListenForData(); }
        }
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),"Device doesnt Support Bluetooth",Toast.LENGTH_SHORT).show();
        }

    }

    public boolean BTinit()
    {
        boolean found=false;
        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),"Device doesnt Support Bluetooth",Toast.LENGTH_SHORT).show();
        }
        if(!bluetoothAdapter.isEnabled())
        {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter, 0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if(bondedDevices.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please Pair the Device first",Toast.LENGTH_SHORT).show();
        }
        else
        {
            for (BluetoothDevice iterator : bondedDevices)
            {
                if(iterator.getAddress().equals(DEVICE_ADDRESS))
                {
                    device=iterator;
                    found=true;
                    break;
                }
            }
        }
        return found;
    }
    public boolean BTconnect()
    {
        boolean connected=true;
        try {
            socket = device.createRfcommSocketToServiceRecord(PORT_UUID);
            socket.connect();
        } catch (IOException e) {
            e.printStackTrace();
            connected=false;
        }
        if(connected)
        {
            try {
                outputStream=socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream=socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return connected;
    }
    void beginListenForData()
    {


       final Handler handler = new Handler();
        stopThread = false;
        buffer = new byte[1024];
        final Thread thread  = new Thread(new Runnable()
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !stopThread)
                {
                    try
                    {
                        int byteCount = inputStream.available();
                        if(byteCount > 0)
                        {
                            byte[] rawBytes = new byte[byteCount];
                            inputStream.read(rawBytes);
                            final String string=new String(rawBytes,"UTF-8");
                            handler.post(new Runnable() {
                                public void run()
                                {
                                   // Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
                                    String[] words = string.split("\\s+");
                                    Utili utili=new Utili(getApplicationContext());
                                    for (int i = 0; i < words.length; i++) {

                                        words[i] = words[i].replaceAll("[^\\w]", "");
                                        if (i==4) {
                                            utili.setBrightness(words[4]);
                                        }
                                        else if (i==9)
                                        {
                                            Date c = Calendar.getInstance().getTime();
                                            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                                            String formattedDate = df.format(c);
                                            utili.setTemperature(words[9]);
                                            DateBaseHistory dateBaseHistory=new DateBaseHistory(getApplicationContext());
                                            dateBaseHistory.insert(utili.getTemperature().toString(),formattedDate.toString());
                                        }
                                        else if (i==12)
                                        {
                                            utili.setWaterLevel(words[12]);
                                           String[] cm= utili.getWaterLevel().split("\\s");
                                            for (int j = 0; j < cm.length; j++)
                                            {
                                                cm[i] = cm[i].replaceAll("[^\\w]", "");
                                                utili.setPlantHigh(cm[1]);
                                            }

                                        }
                                        else if (i==16)
                                        {
                                            utili.setAmbientLight(words[16]);
                                        }
                                        else if (i==14)
                                        {
                                            utili.setPhLevel(words[14]);
                                        }
                                        Log.i("data for app",words[i]);
                                    }
                                }
                            });

                        }
                    }
                    catch (IOException ex)
                    {
                        stopThread = true;
                    }
                }
            }
        });

        thread.start();







    }

}
