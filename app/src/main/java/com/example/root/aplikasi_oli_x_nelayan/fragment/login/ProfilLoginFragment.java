package com.example.root.aplikasi_oli_x_nelayan.fragment.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.root.aplikasi_oli_x_nelayan.loginregister.MainActivity;
import com.example.root.aplikasi_oli_x_nelayan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilLoginFragment extends Fragment {


    private FrameLayout layoutFragment;
    private CardView crdLogin;

    public ProfilLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil_login, container, false);
//        layoutFragment = (FrameLayout) findViewById(R.id.layout_fragment);
//        crdLogin = (CardView) findViewById(R.id.crd_login);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        crdLogin = (CardView) view.findViewById(R.id.crd_login);

        crdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });


    }
}
