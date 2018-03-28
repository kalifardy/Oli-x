package com.example.root.aplikasi_oli_x_nelayan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.root.aplikasi_oli_x_nelayan.R;

public class EditActivity extends AppCompatActivity {

    private EditText edtNama;
    private EditText edtUserId;
    private EditText edtPassword;
    private EditText edtEmail;
    private EditText edtTl;
    private EditText edtTempat;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private EditText edtNoHp;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("Edit");
        initView();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }

    private void initView() {
        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtUserId = (EditText) findViewById(R.id.edt_user_id);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtTl = (EditText) findViewById(R.id.edt_tl);
        edtTempat = (EditText) findViewById(R.id.edt_tempat);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        edtNoHp = (EditText) findViewById(R.id.edt_no_hp);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }
}
