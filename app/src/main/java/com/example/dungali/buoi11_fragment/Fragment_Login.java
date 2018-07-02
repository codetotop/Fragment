package com.example.dungali.buoi11_fragment;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Dung Ali on 6/20/2017.
 */

public class Fragment_Login extends Fragment implements View.OnClickListener {
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnOk;
    private TextView tvRegister;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        edtUserName = getActivity().findViewById(R.id.edtUserName_L);
        edtPassword = getActivity().findViewById(R.id.edtPassword_L);
        btnOk = getActivity().findViewById(R.id.btnOk_L);
        tvRegister = getActivity().findViewById(R.id.tvRegister_L);

        btnOk.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOk_L:
                break;
            case R.id.tvRegister_L:
                handleClickRegister();
                break;
            default:
                break;
        }
    }

    private void handleClickRegister() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(mainActivity.getFragment_register());
        //mainActivity.showFragment(mainActivity.getFragment_register());
    }

    public void setText(String userName, String password) {
        edtUserName.setText(userName);
        edtPassword.setText(password);
    }
}
