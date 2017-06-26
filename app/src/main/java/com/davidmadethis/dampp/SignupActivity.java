package com.davidmadethis.dampp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.davidmadethis.dampp.http.Http;
import com.davidmadethis.dampp.model.Client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    @Bind(R.id.fullName)
    EditText fullnameEditText;
    @Bind(R.id.gender_radio)
    RadioGroup genderRadioGroup;
    @Bind(R.id.usernameField)
    EditText usernameEditText;
    @Bind(R.id.passwordField)
    EditText passwordField;
    @Bind(R.id.signupButton)
    Button signupButton;
    @Bind(R.id.cancelButton)
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signupButton.setOnClickListener(signupAction);


    }


    private View.OnClickListener signupAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Client client = null;
            if (isValid()) {
                 client = new Client()
                        .setFullName(fullnameEditText.getText().toString())
                        .setUsername(usernameEditText.getText().toString())
                        .setSex(((RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId())).getText().toString())
                        .setPassword(passwordField.getText().toString());

            }else {
                return;
            }

            final ACProgressFlower dialog = new ACProgressFlower.Builder(SignupActivity.this)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .fadeColor(Color.DKGRAY).build();
            dialog.show();
            String body = new Gson().toJson(client);

            Http http = new Http();


            http.register(body)
                    .enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                            if(response.isSuccessful()){
                                JsonObject data = response.body();
                                int code = data.get("code").getAsInt();
                                String message = data.get("message").getAsString();
                                if(code==100){
                                    startActivity(new Intent(getApplicationContext(), FirstTimeActivity.class));
                                }else{
                                    //TODO: Look for a good alert library
                                    Toast.makeText(getApplicationContext(),String.valueOf(code)+": "+message,Toast.LENGTH_LONG)
                                            .show();
                                }

                            }
                            dialog.hide();

                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {

                            dialog.hide();
                            Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

        }
    };

    private boolean isValid() {

        if(fullnameEditText.getText().toString().isEmpty()){
            fullnameEditText.setError("Enter your name");
            return false;
        }
        if (usernameEditText.getText().toString().isEmpty()){
            usernameEditText.setError("Enter your username");
            return false;
        }
        if (genderRadioGroup.getCheckedRadioButtonId()==-1){
            Toast.makeText(getApplicationContext(),"Choose your sex",Toast.LENGTH_LONG)
                    .show();
            return false;
        }
        if(passwordField.getText().toString().isEmpty()){
            passwordField.setError("Enter a password");
         return false;
        }

        return true;
    }

}


