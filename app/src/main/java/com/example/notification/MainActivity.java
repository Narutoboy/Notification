package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn= (Button) findViewById(R.id.button);
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "done",Toast.LENGTH_SHORT).show();
                NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder nb1=new Notification.Builder(MainActivity.this);
                nb1.setTicker("i am ticker text");
                nb1.setContentTitle("title");

                Intent i1=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent =PendingIntent.getActivity(MainActivity.this,1,i1,PendingIntent.FLAG_CANCEL_CURRENT);
                nb1.setContentIntent(pendingIntent);
                Notification n1=nb1.build();
              //  n1.flags=n1.flags;
                nm.notify(1,n1);
            }
        });
    }
}
