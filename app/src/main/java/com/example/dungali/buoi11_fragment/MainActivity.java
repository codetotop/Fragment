package com.example.dungali.buoi11_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FrameLayout layoutContain;
    public Fragment_Login fragment_login = new Fragment_Login();
    public Fragment_Register fragment_register = new Fragment_Register();

    public Fragment_Login getFragment_login() {
        return fragment_login;
    }

    public Fragment_Register getFragment_register() {
        return fragment_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutContain = (FrameLayout) findViewById(R.id.layoutContain);

        addFragment();
    }

    private void addFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.layoutContain,fragment_login);
        transaction.add(R.id.layoutContain,fragment_register);
        transaction.replace(R.id.layoutContain,fragment_login);
        transaction.commit();
        //showFragment(fragment_login);
        //replaceFragment(fragment_login);
    }

    public void showFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.hide(fragment_login);
        transaction.hide(fragment_register);
        transaction.show(fragment);
        transaction.commit();
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.replace(R.id.layoutContain,fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showText(String user,String pass){
        fragment_login.setText(user,pass);
    }



}
