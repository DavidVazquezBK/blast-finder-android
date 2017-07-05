package com.aplicaciones.braya.franklin1;

import android.app.Activity;
import android.icu.text.DateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener, QR.OnFragmentInteractionListener, Inmobiliario.OnFragmentInteractionListener, AcercaDe.OnFragmentInteractionListener, AcercaDe2.OnFragmentInteractionListener, HistorialDeInmobiliario.OnFragmentInteractionListener, ZXingScannerView.ResultHandler{
private ZXingScannerView escanerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
public void escanerQR(View view){
    escanerView= new ZXingScannerView(this);
    setContentView(escanerView);

    escanerView.setResultHandler(this);
    escanerView.startCamera();
}
@Override
protected void onPause(){
    super.onPause();
    escanerView.stopCamera();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
 Fragment fragment =null;
        Boolean FragmentoSleccionado=false;


        if (id == R.id.nav_camera) {
            // Handle the camera action
            fragment = new Inmobiliario();
            FragmentoSleccionado=true;
        } else if (id == R.id.nav_gallery) {
            fragment = new QR();
           FragmentoSleccionado=true;
        } else if (id == R.id.nav_slideshow) {
            fragment = new HistorialDeInmobiliario();
            FragmentoSleccionado=true;
        } else if (id == R.id.nav_share) {
            fragment = new AcercaDe();
            FragmentoSleccionado=true;
        } else if (id == R.id.nav_send) {
            fragment = new AcercaDe2();
            FragmentoSleccionado=true;
        }

        if(FragmentoSleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void handleResult(Result result) {
      onPause();
        //wea para mostrar el resultado
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Resultado del escaner");
        builder.setMessage(result.getText());
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        escanerView.resumeCameraPreview(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
