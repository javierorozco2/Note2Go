package com.edoz.note2go;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapterNotas extends RecyclerView.Adapter<ListAdapterNotas.ViewHolder>{
    private List<ListElementNotas> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterNotas(List<ListElementNotas> itemList,Context contex){
        this.mInflater = LayoutInflater.from(context);
        this.context = contex;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {return mData.size();}

    @Override
    public ListAdapterNotas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.cardnotas,null);
        return new ListAdapterNotas.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterNotas.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public  void setItems(List<ListElementNotas> items){mData=items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView colorNota;
        TextView titulo,descr;

        ViewHolder(View itemView){
            super(itemView);
            colorNota = itemView.findViewById(R.id.colorNota);
            titulo = itemView.findViewById(R.id.tituloNotaCard);
            descr = itemView.findViewById(R.id.contenidoNotaCard);
        }

        void bindData(final ListElementNotas item){
            colorNota.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            titulo.setText(item.getTitulo());
            descr.setText(item.getContenido());
        }
    }

}