package com.example.plasmate.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import com.example.plasmate.R;
import com.example.plasmate.controller.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if(remoteMessage.getData().size() > 0){
            Log.d("abc", remoteMessage.getData().get("mykey1"));
        }

        getFirebaseMessage(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    public void getFirebaseMessage(String title, String msg){
        Log.d("abc", title);
        Log.d("abc", msg);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "plasmatechannel")
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentTitle(title)
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(101 , builder.build());

    }
}
