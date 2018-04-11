package com.example.rodneytressler.week2assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.input_name)
    protected EditText name;
    @BindView(R.id.input_email)
    protected EditText email;

    private WelcomeFragment welcomeFragment;
    public static final String ACCOUNT_INFO = "account_info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void toastRegistrationFailure() {
        Toast.makeText(this, "Please enter all fields first!", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.button_register)
    protected void getAccountInfo() {
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        if (userName.isEmpty() || userEmail.isEmpty()) {
            toastRegistrationFailure();
        } else {
            Account account = new Account(userName, userEmail);
            welcomeFragment = welcomeFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, welcomeFragment).commit();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ACCOUNT_INFO, account);
            welcomeFragment.setArguments(bundle);
        }
    }
}
