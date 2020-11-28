package com.example.assignmentfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAdmin extends AppCompatActivity {
    FirebaseAuth auth;
    EditText edEmail;
    EditText edPassword;
    Button enter;
    ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        edEmail =findViewById(R.id.edEmail);
        edPassword=findViewById(R.id.edPassword);
        enter=findViewById(R.id.buttonEnter);
        pg=findViewById(R.id.progressBar);
//---------------------------------------------
        auth=FirebaseAuth.getInstance();
// ------------------------------------------
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });

//---------------------------------------------
    }
    public void  userRegister() {
        String email = edEmail.getText().toString().trim();
        String password=edPassword.getText().toString().trim();
        if (email.isEmpty()) {
            edEmail.setError("ادخل الايميل");
            edEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edEmail.setError("يرجى ادخال الايميل بشكل صحيح");
            edEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            edPassword.setError("ادخل الباسورد");
            edPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            edPassword.setError("يرجى ادخل باسورد 6 احرف على الاقل");
            edPassword.requestFocus();
            return;
        }

        pg.setVisibility(View.VISIBLE);
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                pg.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(),AddBook.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "عدم توفر هذا المستخدم", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
