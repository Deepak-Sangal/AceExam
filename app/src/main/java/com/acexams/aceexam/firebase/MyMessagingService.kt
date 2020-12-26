package com.acexams.aceexam.firebase

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.DashBoardActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyMessagingService: FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        super.onMessageReceived(remoteMessage)
        showData(remoteMessage.notification?.title.toString(),
            remoteMessage.notification?.body.toString()
        )


    }

   public fun showNotification(title:String,msg:String){
       var bulider=NotificationCompat.Builder(this,"MyNotification")
           .setContentTitle(title)
           .setSmallIcon(R.drawable.notification)
           .setAutoCancel(true)
           .setContentText(msg)

       var manager=NotificationManagerCompat.from(this)
       manager.notify(999,bulider.build())

   }


    fun showData(title:String,msg:String){
        var intent=Intent(this,DashBoardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        var pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)
        var notificationBuilder=NotificationCompat.Builder(this)
        notificationBuilder.setContentTitle(title)
        notificationBuilder.setContentText(msg)
        notificationBuilder.setSmallIcon(R.drawable.notification)
        notificationBuilder.setAutoCancel(true)
        notificationBuilder.setContentIntent(pendingIntent)
        var manager:NotificationManager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0,notificationBuilder.build())
    }

  /*  override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("token",token)


    }*/
}