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

public class ListAdapterUbicGuard extends RecyclerView.Adapter<ListAdapterUbicGuard.ViewHolder>{
    private List<ListElementUbicGuard> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterUbicGuard(List<ListElementUbicGuard> itemList,Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {return mData.size();}

    @Override
    public ListAdapterUbicGuard.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.cardubicacionguard,null);
        return new ListAdapterUbicGuard.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterUbicGuard.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public  void setItems(List<ListElementUbicGuard> items){mData=items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;

        ViewHolder(View itemView){
            super(itemView);
            titulo = itemView.findViewById(R.id.locationtitle);
        }

        void bindData(final ListElementUbicGuard item){
            titulo.setText(item.getTitulo());
        }
    }

}
