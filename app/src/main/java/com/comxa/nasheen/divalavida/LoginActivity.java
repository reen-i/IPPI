package com.comxa.nasheen.divalavida;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

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

    EditText etuserName, etPassword;
    Button btnLogin;
    SharedPreferences sharedpreferences;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String username = "userName";
    public static final String password = "Password";

//    private EditText mPasswordView, muserName;
//    private View mProgressView;
//    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        etuserName = (EditText) findViewById(R.id.txtuserName);
        etPassword = (EditText) findViewById(R.id.txtPassword);


        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String a = sharedpreferences.getString(username, "");
        Log.d("H", "aizat2" + a);
        if (!a.equals("")){
            Log.d("H", "aizat" + a + "parlo");
            Intent openMain = new Intent(this, MainActivity.class);
            openMain.putExtra("Username", a);

            startActivity(openMain);
            finish();
        }
        }
//        btnLogin.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String UserName = muserName.getText().toString();
//                String pwd = mPasswordView.getText().toString();
//                if(UserName.equalsIgnoreCase("Nashreen") && pwd.equals("ahmad123")) {
//                    Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(MainIntent);
//                    Toast.makeText(LoginActivity.this, "Signed in successful", Toast.LENGTH_LONG).show();
//                }else {
//                    Toast.makeText(LoginActivity.this, "Invalid User Name or Password", Toast.LENGTH_LONG).show();
//                }
//                }
//        });

//        mLoginFormView = findViewById(R.id.login_form);
//        mProgressView = findViewById(R.id.login_progress);



    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("btnLogin", "Login");
        postData.put("mobile", "android");
        postData.put("txtUsername", etuserName.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString() );

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://10.0.2.2/client/login.php");

    }

    @Override
    public void processFinish(String result) {

         if (result.equals("Y")){
             Toast.makeText(this, "You have logged in", Toast.LENGTH_LONG).show();

             String un = etuserName.getText().toString();
             String pw = etPassword.getText().toString();

             SharedPreferences.Editor editor = sharedpreferences.edit();

             editor.putString(username, un);
             editor.putString(password, pw);
             editor.commit();

             Intent openMain = new Intent(this, MainActivity.class);
             openMain.putExtra("Username", etuserName.getText().toString());

             startActivity(openMain);
             finish();

         } else {
             Toast.makeText(this, "Invalid ID/Password", Toast.LENGTH_LONG).show();

             etuserName.setText("");
             etPassword.setText("");
         }
    }
}







