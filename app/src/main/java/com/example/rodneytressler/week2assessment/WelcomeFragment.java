package com.example.rodneytressler.week2assessment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.rodneytressler.week2assessment.MainActivity.ACCOUNT_INFO;

/**
 * Created by Cody  Gividen on 12/14/17.
 */

public class WelcomeFragment extends Fragment{

    @BindView(R.id.welcome_text)
    protected TextView welcomeText;
    @BindView(R.id.instruction_text)
    protected TextView instructionsText;
    private Account account;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    public static WelcomeFragment newInstance() {

        Bundle args = new Bundle();

        WelcomeFragment fragment = new WelcomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onStart() {
        super.onStart();
        account = getArguments().getParcelable(ACCOUNT_INFO);
        displayInfoName();
        displayInfoEmail();
    }
    private void displayInfoName(){
        welcomeText.setText(getString(R.string.name_resource_fragment, account.getName()));
    }
    @SuppressLint("StringFormatMatches")
    private void displayInfoEmail(){
        instructionsText.setText(getString(R.string.email_resource_fragment, account.getEmail()));
    }
}
