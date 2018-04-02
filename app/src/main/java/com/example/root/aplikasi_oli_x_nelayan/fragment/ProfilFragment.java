package com.example.root.aplikasi_oli_x_nelayan.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.aplikasi_oli_x_nelayan.R;
import com.example.root.aplikasi_oli_x_nelayan.activity.EditActivity;
import com.example.root.aplikasi_oli_x_nelayan.fragment.login.HomeLoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {


    private FrameLayout layoutFragment;
    private Button btnUpdate;
    private Button btnKeluar;
    private TextView txtNama;
    private TextView txtUserId;
    private TextView txtEmail;
    private TextView txtTempatLahir;
    private TextView txtTanggalLahir;
    private TextView txtJk;
    private TextView txtNoHp;

    String result_nama;
//    String result_idnelayan;
//    String result_email;
//    String result_tempatlahir;
//    String result_tanggal_lahir;
//    String result_jk;
//    String result_no_hp;


    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnUpdate = (Button) view.findViewById(R.id.btn_update);
        btnKeluar = (Button) view.findViewById(R.id.btn_keluar);

        txtNama = (TextView) view.findViewById(R.id.txtNama);
        txtUserId = (TextView) view.findViewById(R.id.txtUserId);
        txtEmail = (TextView) view.findViewById(R.id.txtEmail);
        txtTempatLahir = (TextView) view.findViewById(R.id.txtTempatLahir);
        txtTanggalLahir = (TextView) view.findViewById(R.id.txtTanggalLahir);
        txtJk = (TextView) view.findViewById(R.id.txtJk);
        txtNoHp = (TextView) view.findViewById(R.id.txtNoHp);

        Bundle extras= new Bundle();
        if (extras !=null)
            result_nama=extras.getString("result_nama");
            txtNama.setText(result_nama);
//
//        Class<? extends FragmentManager> extras = getFragmentManager().getClass();
//        result_nama=extras.getString("result_nama")
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setMessage("Apa anda ingin keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(getActivity(), HomeLoginActivity.class);
                                startActivity(i);
                                Toast.makeText(getActivity(), "Anda berhasil keluar", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }


        });


    }


}
