package com.example.root.aplikasi_oli_x_nelayan.loginregister;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.root.aplikasi_oli_x_nelayan.ApiHelper.ApiService;
import com.example.root.aplikasi_oli_x_nelayan.ApiHelper.UtilsApi;
import com.example.root.aplikasi_oli_x_nelayan.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

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
    //    ProgressDialog loading;
    Context mContext;
    ApiService mApiservice;
    private RadioGroup rgsex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = this;
        mApiservice = UtilsApi.getApiService();
        setTitle("Register");


        initView();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rgsex.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if ((edtNama.getText().toString().length() == 0)) {
                    edtNama.setError("Nama belum di masukan!");
                } else if (edtUserId.getText().toString().length() == 0) {
                    edtUserId.setError("Id nelayan belum di masukan!");
                } else if (edtPassword.getText().toString().length() == 0) {
                    edtPassword.setError("Password belum di masukan!");
                } else if (edtEmail.getText().toString().length() == 0) {
                    edtEmail.setError("email belum di masukan!");
                } else if (edtTl.getText().toString().length() == 0) {
                    edtTl.setError("tanggal lahir belum di masukan!");
                } else if (edtTempat.getText().toString().length() == 0) {
                    edtTempat.setError("tempat lahir belum di masukan!");
                } else if (radioButton.getText().toString().length() == 0) {
                    edtTempat.setError("tempat lahir belum di masukan!");
                } else if (edtNoHp.getText().toString().length() == 0) {
                    edtNoHp.setError("Id nelayan belum di masukan!");
                } else {
                    requestRegister();

                }
            }
        });
    }

    private void requestRegister() {
        int selectedId = rgsex.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        mApiservice.registerRequest(
                edtNama.getText().toString(),
                edtUserId.getText().toString(),
                edtPassword.getText().toString(),
                edtEmail.getText().toString(),
                edtTl.getText().toString(),
                edtTempat.getText().toString(),
                radioButton.getText().toString(),
                edtNoHp.getText().toString()
        ).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
//                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu", true, false);
                    Log.i("debug", "onResponse: Berhasil");
                    try {
                        JSONObject jsonRESULT = new JSONObject(response.body().string());
                        if (jsonRESULT.getString("success").equals("true")) {
                            Intent i = new Intent(mContext, MainActivity.class);
                            startActivity(i);
                            Toast.makeText(mContext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
//                        loading.dismiss();

                        } else {
                            String error_message = jsonRESULT.getString("message");
                            Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.i("debug", "onResponse:Gagal");
//                    loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR >" + t.getMessage());
//                loading.dismiss();
                Toast.makeText(mContext, "KONEKSI BERMASLAH", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void initView() {
        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtUserId = (EditText) findViewById(R.id.edt_user_id);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtTl = (EditText) findViewById(R.id.edt_tl);
        edtTempat = (EditText) findViewById(R.id.edt_tempat);
        edtNoHp = (EditText) findViewById(R.id.edt_no_hp);
        btnRegister = (Button) findViewById(R.id.btn_register);
        rgsex = (RadioGroup) findViewById(R.id.rgsex);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(mContext, MainActivity.class);
        startActivity(i);
    }
}
