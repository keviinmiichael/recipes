package com.example.kevin.recetas;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecetasFragment extends Fragment  implements RecyclerAdapter.CallBack{



    private List<Receta> recetaList;
    private LinearLayoutManager layoutManagerRecetas;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private CallBack callBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        crearLista();
        View v = inflater.inflate(R.layout.fragment_recetas, container, false);
        recyclerView = v.findViewById(R.id.recyclerRecetasContainer);
        recyclerAdapter = new RecyclerAdapter(recetaList, this);
        layoutManagerRecetas = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManagerRecetas);
        recyclerView.setHasFixedSize(true);
        return v;
    }





    public void crearLista(){
        this.recetaList = new ArrayList<>();
        recetaList.add(new Receta("Roll De Tofu", R.drawable.roll, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
        recetaList.add(new Receta("Medallon De Lentejas", R.drawable.medallon, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
        recetaList.add(new Receta("Roll De Tofu", R.drawable.roll, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
        recetaList.add(new Receta("Medallon De Lentejas", R.drawable.medallon, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
        recetaList.add(new Receta("Roll De Tofu", R.drawable.roll, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
        recetaList.add(new Receta("Medallon De Lentejas", R.drawable.medallon, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
        recetaList.add(new Receta("Roll De Tofu", R.drawable.roll, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
        recetaList.add(new Receta("Medallon De Lentejas", R.drawable.medallon, "Descripcion de la receta aksdlsadksds dlksndlsa aslnds dalndlsand  ndas ad sadnsa lasndsandl"));
    }

    @Override
    public void recibirReceta(Receta receta) {
        callBack.recibirRecetaDeFragment(receta);
    }


    public interface CallBack{
        public void recibirRecetaDeFragment(Receta receta);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack = (CallBack) context;
    }
}
