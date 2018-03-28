package com.example.root.aplikasi_oli_x_nelayan.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.root.aplikasi_oli_x_nelayan.R;
import com.example.root.aplikasi_oli_x_nelayan.fragment.HomeFragment;
import com.example.root.aplikasi_oli_x_nelayan.fragment.ProfilFragment;
import com.example.root.aplikasi_oli_x_nelayan.fragment.TransaksiFragment;
import com.example.root.aplikasi_oli_x_nelayan.fragment.login.ProfilLoginFragment;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.layout_fragment, new HomeFragment()).commit();

                    return true;
                case R.id.navigation_transaksi:
                    getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.layout_fragment, new TransaksiFragment()).commit();
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_profil:
//                    mTextMessage.setText(R.string.title_notifications);
                    getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.layout_fragment, new ProfilFragment()).commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.layout_fragment, new HomeFragment()).commit();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
