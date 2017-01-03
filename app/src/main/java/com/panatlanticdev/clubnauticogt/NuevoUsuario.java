package com.panatlanticdev.clubnauticogt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class NuevoUsuario extends AppCompatActivity  {

    private EditText correoTextField;
    private EditText contraseñaTextField;
    private EditText nombrePapaTextField;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
        //Init vars
        correoTextField = (EditText)findViewById(R.id.emailSignUpTextField);
        contraseñaTextField = (EditText)findViewById(R.id.passwordSignUpTextField);
        nombrePapaTextField = (EditText)findViewById(R.id.nombrePadreSignUpTextField);
        signUpButton = (Button)findViewById(R.id.entrarSignUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                user.setUsername(correoTextField.getText().toString());
                user.setPassword(contraseñaTextField.getText().toString());
                user.put("nombreCompleto", nombrePapaTextField.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            Toast.makeText(NuevoUsuario.this, "Usuario Creado Exitosamente", Toast.LENGTH_LONG).show();
                            Intent goToMainScreen = new Intent(NuevoUsuario.this, HomeScreen.class);
                            startActivity(goToMainScreen);
                            finish();
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Toast.makeText(NuevoUsuario.this, "Usuario NO ha sido Creado", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }


}


