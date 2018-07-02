package com.example.dungali.buoi11_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dung Ali on 6/20/2017.
 */

public class Fragment_Register extends Fragment implements View.OnClickListener {
    private EditText edtUserName_R;
    private EditText edtPassword_R;
    private TextView tvRegister;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        edtUserName_R = getActivity().findViewById(R.id.edtUserName_R);
        edtPassword_R = getActivity().findViewById(R.id.edtPassword_R);
        tvRegister = getActivity().findViewById(R.id.tvRegister_R);

        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        String userName = edtUserName_R.getText().toString().trim();
        String passWord = edtPassword_R.getText().toString().trim();

        if(userName.isEmpty()||passWord.isEmpty()){
            Toast.makeText(getActivity(),"Data invalid",Toast.LENGTH_LONG).show();
            return;
        }

        MainActivity mainActivity = (MainActivity) getActivity();
        Fragment_Login fragment_login = mainActivity.getFragment_login();
        mainActivity.replaceFragment(fragment_login);
        //mainActivity.showFragment(fragment_login);
        fragment_login.setText(userName,passWord);
    }
}
