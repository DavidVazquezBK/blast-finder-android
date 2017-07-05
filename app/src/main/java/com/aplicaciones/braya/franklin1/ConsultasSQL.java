package com.aplicaciones.braya.franklin1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Brayan on 05/07/2017.
 */
public class ConsultasSQL extends Activity {

    private TextView nombreMaterial;
    private TextView ultimaUbicacio;
    private TextView notas;
    private TextView producto;
    private TextView categoria;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Bundle bundle;
    private String baseDatos = "blastfinder";


    public void OnCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.fragment_inmobiliario);



        nombreMaterial = (TextView)findViewById(R.id.editText);
        ultimaUbicacio = (TextView)findViewById(R.id.editText2);
        notas = (TextView)findViewById(R.id.autoCompleteTextView);
        producto = (TextView)findViewById(R.id.editText4);
        categoria = (TextView)findViewById(R.id.editText5);

        bundle = getIntent().getExtras();

        
    }

}
