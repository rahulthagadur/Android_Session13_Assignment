package com.example.thagadur.android_session13_assignment;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppWidgetProvider {

    //overriding onUpdate for widget providing
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int i =0;i<appWidgetIds.length;i++){
            int currentId = appWidgetIds[i];

            String url ="http://www.acadgild.com";
            //setting the intent for the browser
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
            RemoteViews view = new RemoteViews(context.getPackageName(),R.layout.activity_main);
            //onclick of button opening the pendingIntent object
            view.setOnClickPendingIntent(R.id.button,pendingIntent);
            appWidgetManager.updateAppWidget(currentId,view);
            Toast.makeText(context, "Widget has been added", Toast.LENGTH_SHORT).show();
        }
    }
}
