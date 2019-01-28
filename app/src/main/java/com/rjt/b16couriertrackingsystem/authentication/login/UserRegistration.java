package com.rjt.b16couriertrackingsystem.authentication.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseList;
import com.rjt.b16couriertrackingsystem.api.status.network.StatusResponseService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegistration extends Fragment {

    private static String TAG = UserRegistration.class.getSimpleName();

    @BindView(R.id.editTextRegisEmail)
    EditText editTextRegisEmail;
    @BindView(R.id.editTextRegisPass)
    EditText editTextRegisPass;
    @BindView(R.id.editTextRegisPassTwo)
    EditText editTextRegisPassTwo;
    @BindView(R.id.buttonRegisConfirm)
    Button buttonRegisConfirm;
    Unbinder unbinder;
    ImageView imageView3;

    Button buttonBack;
    AlertDialog.Builder builder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_registration, container, false);
        imageView3 = view.findViewById(R.id.imageView3);
        imageView3.setImageResource(R.drawable.user);
        buttonBack = view.findViewById(R.id.buttonGoBack);
        buttonRegisConfirm = view.findViewById(R.id.buttonRegisConfirm);
        builder = new AlertDialog.Builder(getContext());

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Fragment fragment:getActivity().getSupportFragmentManager().getFragments()) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                }

                Intent i = new Intent(getActivity(), UserLogin.class);
                startActivity(i);
            }
        });


        buttonRegisConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextRegisEmail.getText().toString();
                String pass1 = editTextRegisPass.getText().toString();
                String pass2 = editTextRegisPassTwo.getText().toString();
                final StatusResponseService statusResponseService = RetrofitClientInstance.getRetrofitInstance()
                        .create(StatusResponseService.class);
                Call<ResponseBody> call = statusResponseService.registerUser(email, pass1);
                Log.e(TAG, "CALLING RESPONSE");
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String msg = response.toString();
                        builder.setMessage(msg);
                        builder.show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.getMessage();
                    }
                });

//                if(pass1 != pass2 || email.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
//                    builder.setMessage("Please fill fields and match password");
//                    builder.show();
//                }else{
//
//                }
            }
        });




        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
