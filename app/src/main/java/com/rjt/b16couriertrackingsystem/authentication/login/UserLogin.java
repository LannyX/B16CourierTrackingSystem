package com.rjt.b16couriertrackingsystem.authentication.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.rjt.b16couriertrackingsystem.R;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class UserLogin extends AppCompatActivity implements UserLoginContract.UserLoginView {

    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    private static final String TAG = UserLogin.class.getSimpleName();
    LoginButton loginButton;


    @BindView(R.id.editTextLoginEmail)
    EditText editTextLoginEmail;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.editTextLoginPassword)
    EditText editTextLoginPassword;
    @BindView(R.id.buttonLogin)
    Button buttonLogin;

    UserLoginContract.UserLoginPresenter userLoginPresenter;
    SharedPreferences sp;
    @BindView(R.id.buttonRegistration)
    Button buttonRegistration;
    @BindView(R.id.imageView2)
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
        userLoginPresenter = new UserLoginPresenter(this);
        sp = getSharedPreferences("userFile", MODE_PRIVATE);

        imageView2.setImageResource(R.drawable.user);

        callbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonRegistration.setVisibility(View.INVISIBLE);
                buttonLogin.setVisibility(View.INVISIBLE);
                UserRegistration fm = new UserRegistration();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UserLogin, fm, "");
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(UserLogin.this, "Sign up", Toast.LENGTH_SHORT).show();
            }
        });

        //onViewClicked();
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                AccessToken accessToken = loginResult.getAccessToken();
                Log.e(TAG, "onSuccess: access token " + accessToken.getToken());
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });


        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Log.e(TAG, "onSuccess: Mangager" + loginResult.getAccessToken().getToken());
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });


    }

    @OnClick(R.id.buttonLogin)
    public void onViewClicked() {
        buttonLogin.setVisibility(View.INVISIBLE);
        buttonRegistration.setVisibility(View.INVISIBLE);
        userLoginPresenter.requestData(editTextLoginEmail.getText().toString(),
                editTextLoginPassword.getText().toString(),
                sp);
    }

    @Override
    public void showMsg(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Login: " + msg);
        builder.show();
    }

    @Override
    public void callingMainActivity() {
        userLoginPresenter.moveToMainActivity(getApplicationContext());
    }

    //click button -> take user to fb login -> go back
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();


        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}
