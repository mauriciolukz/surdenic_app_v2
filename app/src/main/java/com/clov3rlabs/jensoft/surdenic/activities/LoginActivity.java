package com.clov3rlabs.jensoft.surdenic.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;



import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;


import android.view.inputmethod.EditorInfo;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.clov3rlabs.jensoft.surdenic.R;
import com.clov3rlabs.jensoft.surdenic.models.Usuario;
import com.clov3rlabs.jensoft.surdenic.repo.UsuarioRepo;
import com.clov3rlabs.jensoft.surdenic.rest.ApiClient;
import com.clov3rlabs.jensoft.surdenic.rest.ApiInterface;
import com.clov3rlabs.jensoft.surdenic.utils.NoConnectivityException;

import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.clov3rlabs.jensoft.surdenic.utils.Utility.md5;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references.
    @BindView(R.id.user) EditText user;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.sign_in_button) Button sign_in_button;
    @BindView(R.id.login_progress) ProgressBar login_progress;

    private Usuario usuario = new Usuario();
    private UsuarioRepo usuarioRepo = new UsuarioRepo(this);

    private boolean cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        // Set up the login form.

//        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
//                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
//                    loginUser();
//                    return true;
//                }
//                return false;
//            }
//        });

    }

    @OnClick(R.id.sign_in_button)
    void loginUser(){

        attemptLogin();

        if (!cancel){
            login_progress.setVisibility(View.VISIBLE);
            if (usuarioRepo.autenticar(this.user.getText().toString(), this.password.getText().toString())){ // Autenticamos con DB

                usuario = usuarioRepo.getByUserName(user.getText().toString());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("id_vendedor", usuario.getId_vendedor());
                startActivity(intent);
                finish();

            }else{ // Autenticamos con API
                ApiInterface apiService = ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);

                Call<Usuario> userCall = apiService.Login(this.user.getText().toString(), md5(this.password.getText().toString()) );

                userCall.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                        if (response.body() != null){
                            usuario = response.body();

                            usuario.setUser_name(user.getText().toString());
                            usuario.setPassword(password.getText().toString());

                            usuarioRepo.deleteAll();
                            // set curretnte time
                            Date currentTime = Calendar.getInstance().getTime();
                            usuario.setFecha_login(currentTime);
                            // Save user session

                            usuarioRepo.create(usuario);

                            login_progress.setVisibility(View.GONE);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("id_vendedor", usuario.getId_vendedor());
                            startActivity(intent);
                            finish();

                        }else{
                            if (response.errorBody() != null) {
                                try{
                                    Toast toast = Toast.makeText(getApplicationContext(), R.string.login_failed, Toast.LENGTH_SHORT);
                                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                    if( v != null) v.setGravity(Gravity.CENTER);
                                    toast.show();

                                    Log.i("Login: ", response.errorBody().string());

                                }catch (IOException ex){
                                    login_progress.setVisibility(View.GONE);
                                    Log.i("Login: ", ex.getMessage());
                                }

                            }
                            login_progress.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        login_progress.setVisibility(View.GONE);

                        if(t instanceof NoConnectivityException) {
                            t.printStackTrace();
                            Toast toast = Toast.makeText(getApplicationContext(), R.string.connection_failed, Toast.LENGTH_SHORT);
                            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                            if( v != null) v.setGravity(Gravity.CENTER);
                            toast.show();
                        }
                        Log.i("Login: ", t.getMessage());

                    }
                });

            }

        }

    }





    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        this.user.setError(null);
        this.password.setError(null);

        // Store values at the time of the login attempt.
        String user = this.user.getText().toString();
        String password = this.password.getText().toString();

        cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            this.password.setError(getString(R.string.error_field_required));
            focusView = this.password;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(user)) {
            this.user.setError(getString(R.string.error_field_required));
            focusView = this.user;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
    }

}

