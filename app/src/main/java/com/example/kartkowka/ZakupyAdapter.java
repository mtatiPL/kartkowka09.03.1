package com.example.kartkowka;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ZakupyAdapter extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder> {
    private LayoutInflater inflater;
    private final LinkedList<Zakupy> produkty;

    public ZakupyAdapter(Context context, LinkedList<Zakupy> produkty){
        inflater=LayoutInflater.from(context);
        this.produkty=produkty;

    }

    @NonNull
    @Override
    public ZakupyAdapter.ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemWidok=inflater.inflate(R.layout.item_product,parent,false);
        return new ProduktViewHolder(itemWidok,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ZakupyAdapter.ProduktViewHolder holder, @SuppressLint("RecyclerView") int pos) {
        holder.itemProductView.setText(produkty.get(pos).getNazwa());
        holder.itemProductView.setOnClickListener(new View.OnClickListener() {
            int czyZaz=0;
            @Override
            public void onClick(View view) {
                if (czyZaz==0){
                    holder.itemProductView.setPaintFlags(holder.itemProductView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    czyZaz=1;
                }
                else {
                    holder.itemProductView.setPaintFlags(holder.itemProductView.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                    czyZaz=0;
                }
                produkty.get(pos).setZaz(1);


            }

        });

    }

    @Override
    public int getItemCount() {
        return produkty.size();
    }


    public class ProduktViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final ZakupyAdapter zakupyAdapter;
        public final TextView itemProductView;

        public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            itemProductView=itemView.findViewById(R.id.textView);
            this.zakupyAdapter = adapter;
            itemView.setOnClickListener(this);


        }



        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();

            String prod = produkty.get(pos).getNazwa();
            Toast.makeText(inflater.getContext(), prod, Toast.LENGTH_SHORT).show();
        }
    }
    public void Dodaj(Zakupy produkt){
        produkty.addLast(produkt);
        notifyDataSetChanged();

    }
    public void usunZaz(){
        produkty.removeIf(x->x.Zaz==1);
        notifyDataSetChanged();
    }
}
