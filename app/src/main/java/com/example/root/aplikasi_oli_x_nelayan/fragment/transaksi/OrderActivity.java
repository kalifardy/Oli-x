package com.example.root.aplikasi_oli_x_nelayan.fragment.transaksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.root.aplikasi_oli_x_nelayan.R;

public class OrderActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText edtPassword;
    private Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OrderActivity.this,PembayaranActivity.class);
                startActivity(i);
            }
        });
    }

    private void initView() {
        spinner = (Spinner) findViewById(R.id.spinner);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnMasuk = (Button) findViewById(R.id.btn_masuk);
    }
}
