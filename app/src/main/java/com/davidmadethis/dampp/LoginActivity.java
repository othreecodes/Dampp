package com.davidmadethis.dampp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.davidmadethis.dampp.http.Http;
import com.davidmadethis.dampp.model.Client;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    static ViewPager pager;
    static String username;
    static String password;
    static EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pager = (ViewPager) findViewById(R.id.container);
        PagerAdapter pAdapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pAdapter);


    }

    public static void doLogin(String username, String password, final Context context) {


        Client client = new Client();
        client.setUsername(username).setPassword(password);
        String data = new Gson().toJson(client);
        Http http = new Http();

        http.login(data).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                Toast.makeText(context, response.message(), Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

    public class PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new LoginFragment();
                case 1:
                    return new FollowUpFragment();
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }


    }

    public static class LoginFragment extends Fragment {

        public LoginFragment() {

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_login, container, false);

            usernameEditText = (EditText) v.findViewById(R.id.username);
            usernameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                    boolean handled = false;
                    if (i == EditorInfo.IME_ACTION_NEXT) {

                        usernameEditText.clearFocus();
                        username = usernameEditText.getText().toString();
                        pager.setCurrentItem(2);
                        handled = true;
                    }

                    return handled;
                }
            });


            return v;
        }

    }

    public static class FollowUpFragment extends Fragment {

        String TAG = this.getClass().getName();

        public FollowUpFragment() {
        }

        int REQUEST_CODE_ENABLE = 333;
        EditText editText;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_followup, container, false);

            editText = (EditText) v.findViewById(R.id.password);
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                    boolean handled = false;
                    if (i == EditorInfo.IME_ACTION_GO) {


                        password = editText.getText().toString();
                        if (username.isEmpty()) {
                            editText.clearFocus();
                            usernameEditText.setError("Please enter a username");
                            pager.setCurrentItem(0);
                        } else if (password.isEmpty()) {
                            editText.setError("Please input your password");
                        } else {
                            doLogin(username, password, getContext());
                        }


                        handled = true;
                    }

                    return handled;
                }
            });


            return v;
        }

        @Override
        public void setUserVisibleHint(boolean isVisibleToUser) {
            super.setUserVisibleHint(isVisibleToUser);

        }


    }


}
