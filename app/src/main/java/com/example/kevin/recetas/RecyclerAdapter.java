package com.example.kevin.recetas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kevin on 11/11/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter{


    private List<Receta> recetaList;
    private CallBack callBack;


    public RecyclerAdapter(List<Receta> recetaList, CallBack callBack) {
        this.recetaList = recetaList;
        this.callBack = callBack;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cellda_receta, parent, false);
        RecetaViewHolder recetaViewHolder = new RecetaViewHolder(v);
        return recetaViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        final Receta receta = recetaList.get(i);
        RecetaViewHolder recetaViewHolder = (RecetaViewHolder) holder;
        recetaViewHolder.bindReceta(receta);
        recetaViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.recibirReceta(receta);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recetaList.size();
    }

    public interface CallBack{
        public void recibirReceta(Receta receta);

    };


    private class RecetaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public RecetaViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.img_receta);
            textView = v.findViewById(R.id.title_receta);
        }

        public void bindReceta(Receta receta){
            imageView.setImageResource(receta.getImg());
            textView.setText(receta.getTitle());
        }


    }
}
