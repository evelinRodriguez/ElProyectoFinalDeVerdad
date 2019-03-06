package com.example.familia.ejemplofragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class secondFragment extends Fragment {
    DataBaseHelper peopleDB;
    private EditText etSalon,etSede,etEdificio;
    private Button button1;
    private Button button;

    public secondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_second, container, false);
      // SI LE METO ESTA DEJA DE FUNCIONAR   peopleDB=new DataBaseHelper(this);
        button=view.findViewById(R.id.b3);
        button1=view.findViewById(R.id.buttonADD);
        etSalon=view.findViewById(R.id.etNewSalon);
        etSede=view.findViewById(R.id.etNewSede);
        etEdificio=view.findViewById(R.id.etNewEdificio);
        AddData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new HomeFragment(),null).commit();

            }



    });
        return view;




    }

    private void AddData() {
        button1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            String salon= etSalon.getText().toString();
            String sede= etSede.getText().toString();
            String edificio= etEdificio.getText().toString();

            boolean insertData=peopleDB.addData(salon,sede,edificio);

            if (insertData==true){

                Toast.makeText(getActivity(),"SUCCESFULLY",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(getActivity(),"ERROR",Toast.LENGTH_LONG).show();
            }
        }
    });


    }


}
