package com.example.bhupendra.pushnotification;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;




public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private  static  final String TAG = "MyFirebaceInstanceIDService";

    @SuppressLint("LongLogTag")
    @Override
    public  void onTokenRefresh(){

        String refereshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG,"New Token"+refereshedToken);

    }


}
