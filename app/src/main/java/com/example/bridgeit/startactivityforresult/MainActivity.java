package com.example.bridgeit.startactivityforresult;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView mSetText;
    private Button mGetData;
    private static int mRequest_code = 5;
   private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGetData = (Button)findViewById(R.id.button_get);
        mSetText = (TextView)findViewById(R.id.txt_display);

        mGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,mRequest_code);

            }
        });
    }

    @Override
    //dispaly the message received from intent
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String value = String.valueOf(resultCode);
        String dispaly = data.getStringExtra("message");
        Log.e(TAG,value);

        if (resultCode == mRequest_code){
            mSetText.setText(dispaly);

        } else {
            Toast.makeText(MainActivity.this,"Request code wrong",Toast.LENGTH_SHORT).show();
        }


    }

}
