package com.example.familia.ejemplofragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    DataBaseHelper peopleDB;

    Button btnAddData;
    EditText etSalon,etSede,etEdificio;




    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        if(findViewById(R.id.fragment_container)!=null){

            if(savedInstanceState!=null){
                return;
            }
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            HomeFragment homeFragment=new HomeFragment();
            fragmentTransaction.add(R.id.fragment_container,homeFragment,null);
            fragmentTransaction.commit();
        }
        peopleDB=new DataBaseHelper(this);
        etSalon=(EditText) findViewById(R.id.etNewSalon);
        etSede=(EditText) findViewById(R.id.etNewSede);
        etEdificio=(EditText) findViewById(R.id.etNewEdificio);

        btnAddData=(Button)findViewById(R.id.bt9);


    }







}
