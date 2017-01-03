package com.panatlanticdev.clubnauticogt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Toolbar toolbar;
    private Button actividadesButton;
    private Button avisosButton;
    private Button calendarioSeccion;
    private Button mensajesButton;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Intent goToAds = new Intent(HomeScreen.this, Ads.class);
        startActivity(goToAds);


        //toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
       // setSupportActionBar(toolbar);

        actividadesButton = (Button)findViewById(R.id.actividadesButton);
        avisosButton = (Button)findViewById(R.id.avisosButton);
        calendarioSeccion = (Button)findViewById(R.id.calendarioSeccionButton);
        mensajesButton = (Button)findViewById(R.id.mensajesButton);

        actividadesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToActividades = new Intent(HomeScreen.this, ListadoEventos.class);
                startActivity(goToActividades);
            }
        });

        avisosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAvisos = new Intent(HomeScreen.this, Avisos.class);
                startActivity(goToAvisos);
            }
        });
        calendarioSeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCalendarios = new Intent(HomeScreen.this, Fotos.class);
                startActivity(goToCalendarios);
            }
        });

        mensajesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToChat = new Intent(HomeScreen.this, Chat.class);
                startActivity(goToChat);
            }
        });
    }



}
