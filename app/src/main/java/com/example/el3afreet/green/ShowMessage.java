package com.example.el3afreet.green;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

public class ShowMessage {

    Context context;
    NotificationManager manager;
    int id=1;
    public ShowMessage(Context context){
        this.context=context;
    }


    public void message(String message,String title)
    {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_foreground);
        manager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,builder.build());
    }
}
