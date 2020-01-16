package com.example.alpha2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    Button btnRegister;
    EditText etMail;
    EditText etPhone;

    String stMail,stPhone;
    private FirebaseAuth mAuth;
    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRegister= (Button) findViewById(R.id.btnRegister);
        etMail=(EditText) findViewById(R.id.etMail);
        etPhone=(EditText) findViewById(R.id.etPhone);

        mAuth = FirebaseAuth.getInstance();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String s= item.getTitle().toString();
        t=new Intent(this, MainActivity.class);
        if (s.equals("Authentication")){
            t=new Intent(this, MainActivity.class);
            startActivity(t);}

        if (s.equals("Real Time Database")){
            t=new Intent(this, Main2Activity.class);
            startActivity(t);
        }
        if (s.equals("Gallery")){
            t=new Intent(this, Main3Activity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }


    public void createAccount(){
        mAuth.createUserWithEmailAndPassword(stMail, stPhone)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        }

                    }
                });
    }


    public void register(View view) {
        stMail=etMail.getText().toString();
        stPhone=etPhone.getText().toString();
        createAccount();

    }
}
