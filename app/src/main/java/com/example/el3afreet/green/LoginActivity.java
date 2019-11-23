package com.example.el3afreet.green;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

  private EditText inputEmail, inputPassword;
  private FirebaseAuth auth;
  private Button btnLogin;
  private TextView signup;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    auth = FirebaseAuth.getInstance();

    if (auth.getCurrentUser() != null) {
      startActivity(new Intent(LoginActivity.this, Dashboard.class));
      finish();
    }
    setContentView(R.layout.activity_login);

    inputEmail = findViewById(R.id.logemail);
    inputPassword = findViewById(R.id.logpassword);
    btnLogin =  findViewById(R.id.login);
    signup = findViewById(R.id.signupback);

    auth = FirebaseAuth.getInstance();

    signup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
      }
    });
    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String email = inputEmail.getText().toString();
        final String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
          Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
          return;
        }

        if (TextUtils.isEmpty(password)) {
          Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
          return;
        }
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (!task.isSuccessful()) {
                      // there was an error
                      if (password.length() < 6) {
                        inputPassword.setError("enter 6 digit");
                      } else {
                        Toast.makeText(LoginActivity.this, "something wrong...", Toast.LENGTH_LONG).show();
                      }
                    } else {
                      Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                      startActivity(intent);
                      finish();
                    }
                  }
                });
      }
    });

  }
}

