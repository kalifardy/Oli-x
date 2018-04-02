package com.example.root.aplikasi_oli_x_nelayan.loginregister;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.aplikasi_oli_x_nelayan.apihelper.ApiService;
import com.example.root.aplikasi_oli_x_nelayan.apihelper.UtilsApi;
import com.example.root.aplikasi_oli_x_nelayan.R;
import com.example.root.aplikasi_oli_x_nelayan.activity.HomeActivity;
import com.example.root.aplikasi_oli_x_nelayan.fragment.ProfilFragment;
import com.example.root.aplikasi_oli_x_nelayan.fragment.login.HomeLoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnMasuk;
    private Button btnRegister;

    Context mContext;
    ApiService mApiservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mApiservice = UtilsApi.getApiService();

        setTitle("Login");
        initView();

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((edtUsername.getText().toString().length() == 0)) {
                    edtUsername.setError("Nama belum di masukan!");
                } else if (edtPassword.getText().toString().length() == 0) {
                    edtPassword.setError("Password belum di masukan!");
                }else {

                    requestLogin();
                }

            }
        });




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    private void requestLogin() {
        mApiservice.loginRequest(edtUsername.getText().toString(),edtPassword.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {

                        JSONObject jsonResult = new JSONObject(response.body().string());
                        if (jsonResult.getString("success").equals("true")){
                            Toast.makeText(mContext, "Login Berhasil", Toast.LENGTH_SHORT).show();

//
                            String nama = jsonResult.getJSONObject("user").getString("nama");
                            String id_nelayan = jsonResult.getJSONObject("user").getString("id_nelayan");
                            String password = jsonResult.getJSONObject("user").getString("password");
                            String email = jsonResult.getJSONObject("user").getString("email");
                            String tanggal_lahir = jsonResult.getJSONObject("user").getString("tanggal_lahir");
                            String tempat_lahir = jsonResult.getJSONObject("user").getString("tempat_lahir");
                            String jk = jsonResult.getJSONObject("user").getString("jk");
                            String no_hp = jsonResult.getJSONObject("user").getString("no_hp");

                            Intent i = new Intent(mContext,ProfilFragment.class);

                            i.putExtra("result_nama",nama);
                            i.putExtra("result_idnelayan",id_nelayan);
                            i.putExtra("result_password",password);
                            i.putExtra("result_email",email);
                            i.putExtra("result_tanggal_lahir",tanggal_lahir);
                            i.putExtra("result_tempat_lahir",tempat_lahir);
                            i.putExtra("result_jk",jk);
                            i.putExtra("result_no_hp",no_hp);

                            startActivity(i);
                        }else{
                            String error_msg = jsonResult.getString("message");
                            Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("debug","onFailure: ERROR >"+t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(mContext, HomeLoginActivity.class);
        startActivity(i);
        finish();
    }

    private void initView() {
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnMasuk = (Button) findViewById(R.id.btn_masuk);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }
}
