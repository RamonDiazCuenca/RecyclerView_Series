package com.rdc.recyclerviewseries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    int [] caratulas;
    private LayoutInflater layoutInflater;
    ImageView caratula;



    MyRecyclerViewAdapter(Context context, int[] caratulas){

        layoutInflater = LayoutInflater.from(context);
        this.caratulas = caratulas;
    }


    @Override /*Creamos la vista sin personalizar, RecyclerView llama a este método siempre que
        necesita crear una ViewHolder nueva. El método crea el ViewHolder y su View asociada.*/
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.caratula_serie, parent, false);
        return new ViewHolder(view);
    }

    @Override /* Personalizamos el ViewHolder, RecyclerView llama a este método para asociar
        una ViewHolder con los datos. El método recupera los datos correspondientes y los usa para
        completar el diseño del contenedor de vistas.*/
    public void onBindViewHolder(ViewHolder holder, int position) {

       caratula.setImageResource(caratulas[position]);

    }

    @Override /*Indicamos el numero de elementos de la lista, RecyclerView llama a este método a fin
         de obtener el tamaño del conjunto de datos y lo usa para determinar
         cuándo no hay más elementos que se puedan mostrar.*/
    public int getItemCount() {

        return caratulas.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

            caratula = itemView.findViewById(R.id.imgvserie);

            itemView.setOnClickListener(view -> {

                Snackbar.make(view,"Serie turca",Snackbar.LENGTH_SHORT).show();

            });
        }
    }
}
