package com.fitucab.ds1617b.fitucab.UI.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.fitucab.ds1617b.fitucab.R;

import static android.R.id.list;
/**
 * Created by noe on 28/5/2017.
 */

public class M08AddChallenge extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    Button buttonFechaInicio,buttonFechaFin;

    TextView editTextButtonFechaInicio, editTextButtonFechaFin;
    private int diaI,mesI,anoI,diaF,mesF,anoF;

        	/**
     * método que se llama cuando se crea la actividad
     * @param savedInstanceState se usa para inicializar la creación de la interfaz de usuario.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m08_add_challenge);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        buttonFechaInicio = (Button)findViewById(R.id.buttonFechaInicio);
        buttonFechaFin = (Button)findViewById(R.id.buttonFechaFin);
        editTextButtonFechaInicio = (TextView)findViewById(R.id.editTextButtonFechaInicio);
        editTextButtonFechaFin = (TextView)findViewById(R.id.editTextButtonFechaFin);

        buttonFechaInicio.setOnClickListener(this);
        buttonFechaFin.setOnClickListener(this);




    }//cierre del void conCreate



    /**
     * menu lateral
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }//cierre del onNavigationItemSelected

    /**
     * metodo
     * @param v
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if(v==buttonFechaInicio){
            final Calendar c = Calendar.getInstance();
            diaI=c.get(Calendar.DAY_OF_MONTH);
            mesI=c.get(Calendar.MONTH);
            anoI=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    editTextButtonFechaInicio.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            ,diaI,mesI,anoI);
            datePickerDialog.show();
        }//cierre if buttonFechaInicio

        if(v==buttonFechaFin){
            final Calendar c = Calendar.getInstance();
            diaF=c.get(Calendar.DAY_OF_MONTH);
            mesF=c.get(Calendar.MONTH);
            anoF=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    editTextButtonFechaInicio.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,diaF,mesF,anoF);
            datePickerDialog.show();
        }//cierre if buttonFechaInicio


    }//cierre del void onClickView

}//cierre de la clase M08InformationChallenge

