package com.example.noureldeen.responsiveandnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public static String ItemID = "id";
    TextView itemDescription;
    Button showNotification ;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int mNotificationId = 1;
            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(R.mipmap.notification_icon)
                            .setContentTitle("My notification")
                            .setContentText("Hello World!");
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            mNotificationManager.notify(mNotificationId, mBuilder.build());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        itemDescription = (TextView) findViewById(R.id.textView_itemDescription);
        itemDescription.setText(MyList.myList[intent.getIntExtra(ItemID,0)].getDescription());
        showNotification = (Button) findViewById(R.id.button_showNotification);
        showNotification.setOnClickListener(onClickListener);
    }
}
