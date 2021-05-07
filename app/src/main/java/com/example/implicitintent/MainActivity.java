package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private Button bt1,bt2,bt3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1=findViewById(R.id.bt_Web);
        bt2=findViewById(R.id.bt_SMS);
        bt3=findViewById(R.id.bt_Phone);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent ;
        switch(v.getId()){
            case R.id.bt_Web :
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dantri.com.vn/"));
            startActivity(intent);
                break;

            case R.id.bt_SMS:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:" + "0355970126"));
                intent.putExtra("sms_body","Noi dung");
                startActivity(intent);
                break;

            case R.id.bt_Phone :
                intent = new Intent(Intent.ACTION_VIEW) ;
                intent.setData(Uri.parse("tel:0355970126"));
                startActivity(intent);
                break;
        }
    }
}