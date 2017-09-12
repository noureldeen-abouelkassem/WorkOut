package com.example.noureldeen.responsiveandnotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static boolean IS_A_TABLET ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if ((findViewById(R.id.fragment_container)) != null) {
            IS_A_TABLET = true;
        } else {
            IS_A_TABLET = false;
        }
    }
}
