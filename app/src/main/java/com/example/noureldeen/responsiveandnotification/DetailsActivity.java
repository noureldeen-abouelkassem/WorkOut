package com.example.noureldeen.responsiveandnotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public static String ItemID = "id";
    TextView itemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        itemDescription = (TextView) findViewById(R.id.textView_itemDescription);
        itemDescription.setText(MyList.myList[intent.getIntExtra(ItemID,0)].getDescription());
    }
}
