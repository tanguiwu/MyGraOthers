package com.example.mygraothers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mygraothers.utils.DebugLog;

public class LoginActivity extends AppCompatActivity {

    private EditText edit_inputname;
    private EditText edit_inputpwd;
    private CheckBox check_reme;
    private Button btn_login, bt_resign;

    //本地输入框的账号密码，isStatus 当前是否勾选，isPassCorrect输入的密码是否是对的
    private String editPass, editName;
    private boolean isStatus, isPassCorrect;

    //SharedPreferences 存储的账号密码 ，状态
    private String strname, strpwd;

    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isPassCorrect = false;

        initView();

        btn_loginonClick();


    }

    @Override
    protected void onResume() {
        super.onResume();
        isPassCorrect = false;
        displayinfo();
    }

    private void initView() {
        edit_inputname = findViewById(R.id.editText_inputname);
        edit_inputpwd = findViewById(R.id.editText_inputpwd);
        check_reme = findViewById(R.id.checkBox_reme);
        btn_login = findViewById(R.id.button_login);
        bt_resign = findViewById(R.id.bt_resign);

        // 获取记住密码的单选框，状态
        check_reme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isStatus = isChecked;
            }
        });

    }

    //登录
    private void btn_loginonClick() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editName = edit_inputname.getText().toString();
                editPass = edit_inputpwd.getText().toString();
                isStatus = check_reme.isChecked();

                getLocalPass();

                if (editPass.equals(strpwd) && editName.equals(strname)) {
                    Log.d("tgw当前值", "onClick: strpwd" + strpwd + "---strname:" + strname);
                    isPassCorrect = true;
                }
                Log.d("tgw当前值是否正确", "onClick: " + isPassCorrect);
                if (isPassCorrect) {
                    SharedPreferences.Editor editor = getSharedPreferences("myinfo", 0).edit();
                    editor.putBoolean("st", isStatus);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "密码或账号错误--如果没有注册请先注册", Toast.LENGTH_LONG).show();
                }


            }
        });

        //注册
        bt_resign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugLog.showIOSAlert(LoginActivity.this, "警告", "新注册的账号会覆盖先前的账号，是否注册", "取消", "确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        },
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                editName = edit_inputname.getText().toString();
                                editPass = edit_inputpwd.getText().toString();
                                isStatus = check_reme.isChecked();

                                SharedPreferences.Editor editor = getSharedPreferences("myinfo", 0).edit();
                                editor.putString("name", editName);
                                editor.putString("pwd", editPass);
                                editor.putBoolean("st", isStatus);
                                editor.commit();
                                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();

                            }
                        });

            }
        });
    }

    private void displayinfo() {

        getLocalPass();

        if (status == true) {
            edit_inputname.setText(strname);
            edit_inputpwd.setText(strpwd);
            check_reme.setChecked(true);

        } else {
            edit_inputname.setText("");
            edit_inputpwd.setText("");
            check_reme.setChecked(false);
        }

    }

    /**
     * 获取本地的密码
     */
    private void getLocalPass() {
        strname = getSharedPreferences("myinfo", 0).getString("name", "");
        strpwd = getSharedPreferences("myinfo", 0).getString("pwd", "");
        status = getSharedPreferences("myinfo", 0).getBoolean("st", false);
        Log.d("tgw当前值", "onClick:选中" + status );

    }


}
