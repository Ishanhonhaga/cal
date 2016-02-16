package com.nextstep.mcal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * This class Handles all the notification recieved by the App
 *
 * Created by Ishan on 20/01/16.
 */
public class NotificationHandler extends AppCompatActivity{
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificationhandler);
        mTextView = (TextView) findViewById(R.id.notificationhandler_textview);

        String msg = getIntent().getExtras().getString("msg");

        mTextView.setText(msg);


    }
}
