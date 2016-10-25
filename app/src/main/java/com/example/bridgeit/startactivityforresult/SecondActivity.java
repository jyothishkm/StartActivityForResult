package com.example.bridgeit.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by bridgeit on 25/10/16.
 */

public class SecondActivity extends Activity {
    private EditText mMessage;
    private Button mSendMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mMessage = (EditText)findViewById(R.id.edit_msg);
        mSendMsg = (Button)findViewById(R.id.button_submit);

        mSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            //send data to the main Activity
            public void onClick(View v) {
                String message = mMessage.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("message",message);
                setResult(5,intent);
                finish();
            }
        });

    }
}
