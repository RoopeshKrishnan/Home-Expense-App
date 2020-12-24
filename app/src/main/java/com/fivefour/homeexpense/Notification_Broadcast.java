package com.fivefour.homeexpense;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notification_Broadcast  extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"Home Expense")


                .setSmallIcon(R.drawable.ic_home)
                .setContentTitle("New Month..!!!!")
                .setContentText("Add new data in to your Home Expense App")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

       // NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        NotificationManager notificationManager1 =(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent reintent = new Intent(context,Expense_Edit_calculation_Activity.class);
        reintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,reintent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationManager1.notify(100,builder.build());


    }
}
