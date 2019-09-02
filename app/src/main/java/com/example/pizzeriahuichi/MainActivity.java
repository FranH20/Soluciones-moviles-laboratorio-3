package com.example.pizzeriahuichi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
        implements Fragment_listaPizza.OnFragmentInteractionListener,
        Fragment_detallePizza.OnFragmentInteractionListener, IComunicacionFragments {

    Fragment_detallePizza detallepizza;
    Fragment_listaPizza listapizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.contenedorFragment ) != null){
            listapizza = new Fragment_listaPizza();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,listapizza).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarPizza(ClsPizza pizza) {

        detallepizza = (Fragment_detallePizza) this.getSupportFragmentManager().findFragmentById(R.id.fragDetalle);

        if(detallepizza != null && findViewById(R.id.contenedorFragment) == null){
            detallepizza.asignarInformacion(pizza);
        }else{
            detallepizza = new Fragment_detallePizza();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("objeto",pizza);
            detallepizza.setArguments(bundleEnvio);
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,detallepizza).addToBackStack(null).commit();
        }


    }
}
