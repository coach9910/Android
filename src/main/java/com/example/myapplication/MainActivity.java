package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText accountEdit = null;
    private EditText pwdEdit = null;
    private Button btn_Cancel = null;
    private Button btn_Login = null;
    private TextView StatusView = null;
    private CheckBox cb = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定id
        accountEdit = (EditText)findViewById(R.id.accountEdit);
        pwdEdit = (EditText)findViewById(R.id.PwdEdit);
        btn_Cancel = (Button)findViewById(R.id.cancel);
        btn_Login = (Button)findViewById(R.id.login);
        StatusView = (TextView)findViewById(R.id.statusView);
        cb = (CheckBox)findViewById(R.id.cb);
        //监听
        btn_Login.setOnClickListener(this);
        btn_Cancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.cancel:
                StatusView.setText("Bye Bye！");
                break;
            case R.id.login:
                if(cb.isChecked()) {
                    if(!TextUtils.isEmpty(accountEdit.getText())) {
                        StatusView.setText("Account:" + accountEdit.getText() + "登陆成功！");
                        SystemClock.sleep(500);
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("name",accountEdit.getText().toString());
                        //创建好之后就可以通过它启动新的Activity
                        startActivityForResult(intent,1000);
                    }else{
                        StatusView.setText("账号不能为空！");
                    }
                }else{
                    StatusView.setText("请勾选同意用户条例！");
                }
                break;
        }
    }
}
