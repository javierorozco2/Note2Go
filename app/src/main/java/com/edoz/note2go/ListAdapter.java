package com.edoz.note2go;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemlist, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemlist;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card, null);

        return new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.binData(mData.get(position));
    }

    @Override
    public int getItemCount() { return mData.size();}

    public void setItems(List<ListElement> items){ mData = items; }


    //Aqui van los datos
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, cantidad, notas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.ubicaciontitulo);
            cantidad = itemView.findViewById(R.id.notasnumero);
            notas = itemView.findViewById(R.id.notastitulos);
        }

        void binData(final ListElement item){
            nombre.setText(item.getNombre());
            cantidad.setText(item.getCantidad());
            notas.setText(item.getListas());
        }

    }



}
