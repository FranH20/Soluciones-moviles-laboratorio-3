package com.example.pizzeriahuichi;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_listaPizza.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_listaPizza#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_listaPizza extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<ClsPizza> listDatos;
    RecyclerView recycler;

    Activity activity;
    IComunicacionFragments interfaceComunicacion;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment_listaPizza() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_listaPizza.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_listaPizza newInstance(String param1, String param2) {
        Fragment_listaPizza fragment = new Fragment_listaPizza();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        listDatos = new ArrayList<>();
        View vista = inflater.inflate(R.layout.fragment_fragment_lista_pizza, container, false);

        recycler = (RecyclerView) vista.findViewById(R.id.recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        llenardatos();

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicacion.enviarPizza(listDatos.get(recycler.getChildAdapterPosition(view)));

            }
        });



        return vista;
    }

    private void llenardatos() {
        listDatos.add(new ClsPizza(getString(R.string.titulo_pizzaAmericana),getString(R.string.parrafo_pizzaAmericana),getString(R.string.precio_pizzaAmericana),R.drawable.americana_web_1));
        listDatos.add(new ClsPizza(getString(R.string.titulo_pizzaMozarella),getString(R.string.parrafo_pizzaMozarella),getString(R.string.precio_pizzaMozarella),R.drawable.mozzarella_web_1));
        listDatos.add(new ClsPizza(getString(R.string.titulo_pizzaPepperoni),getString(R.string.parrafo_pizzaPepperoni),getString(R.string.precio_pizzaPepperoni),R.drawable.pepperoni_web_1));
        listDatos.add(new ClsPizza(getString(R.string.titulo_pizzaVegetariana),getString(R.string.parrafo_pizzaVegetariana),getString(R.string.precio_pizzaVegetariana),R.drawable.vegetariana_web_1));
        listDatos.add(new ClsPizza(getString(R.string.titulo_pizzaHawaiana),getString(R.string.parrafo_pizzaHawaiana),getString(R.string.precio_pizzaHawaiana),R.drawable.hawaiana_web_1));
        listDatos.add(new ClsPizza(getString(R.string.titulo_pizzaContinentalle),getString(R.string.parrafo_pizzaContinentalle),getString(R.string.precio_pizzaContinentalle),R.drawable.continentalle_web_1));
        listDatos.add(new ClsPizza(getString(R.string.titulo_pizzaEspanola),getString(R.string.parrafo_pizzaEspanola),getString(R.string.precio_pizzaEspanola),R.drawable.espanola_web_1));
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity ){
                this.activity = (Activity) context;
                interfaceComunicacion = (IComunicacionFragments) this.activity;
        }

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
