package com.example.bhupendra.pushnotification;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;



public class MyFirbaseMessagindService extends FirebaseMessagingService {


   private  static final String TAG = "MYFirebaseMessagingService";


    @SuppressLint("LongLogTag")
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From" +remoteMessage.getFrom());

        if(remoteMessage.getData().size()>0){

            Log.d(TAG,"Message Data" +remoteMessage.getData());
        }
        if(remoteMessage.getNotification() !=null){
            Log.d(TAG,"Message Body" +remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String body) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri notification =RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifiBuilder =new NotificationCompat.Builder(this)

            .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(body)
                .setAutoCancel(true)
                .setSound(notification)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notifiBuilder.build());



        }

}
