package com.example.noureldeen.responsiveandnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public static String ItemID = "id";
    TextView itemDescription;
    Button showNotification;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
            builder.setContentTitle("First Notification");
            builder.setContentText("say hello to my first notification");
            builder.setSmallIcon(R.drawable.ic_stat_name);
            Intent intent = new Intent(DetailsActivity.this, DetailsActivity.class);
            TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getApplicationContext());
            taskStackBuilder.addNextIntentWithParentStack(intent);
            builder.setContentIntent(taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT));
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        itemDescription = (TextView) findViewById(R.id.textView_itemDescription);
        itemDescription.setText(MyList.myList[intent.getIntExtra(ItemID, 0)].getDescription());
        showNotification = (Button) findViewById(R.id.button_showNotification);
        showNotification.setOnClickListener(onClickListener);
    }
}
