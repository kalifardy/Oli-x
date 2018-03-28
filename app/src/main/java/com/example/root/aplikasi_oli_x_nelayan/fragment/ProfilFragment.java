package com.example.root.aplikasi_oli_x_nelayan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.root.aplikasi_oli_x_nelayan.activity.EditActivity;
import com.example.root.aplikasi_oli_x_nelayan.R;
import com.example.root.aplikasi_oli_x_nelayan.fragment.login.HomeLoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {


    private FrameLayout layoutFragment;
    private Button btnUpdate;
    private Button btnKeluar;

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
                Intent intent = new Intent(getActivity(), HomeLoginActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }

}
