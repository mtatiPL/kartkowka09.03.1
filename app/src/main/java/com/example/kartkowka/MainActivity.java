package com.example.kartkowka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<Zakupy> listaZakupow=new LinkedList<>();
    RecyclerView recyclerView;
    ZakupyAdapter adapter;
    EditText editText;
    Button dodaj;
    Button usun;
    private void przygotujListe(){
        listaZakupow.addLast(new Zakupy("chleb"));
        listaZakupow.addLast(new Zakupy("Banany"));
        listaZakupow.addLast(new Zakupy("jogurt"));
        listaZakupow.addLast(new Zakupy("bułki"));
        listaZakupow.addLast(new Zakupy("masło"));

        listaZakupow.addLast(new Zakupy("chleb"));
        listaZakupow.addLast(new Zakupy("Banany"));
        listaZakupow.addLast(new Zakupy("jogurt"));
        listaZakupow.addLast(new Zakupy("bułki"));
        listaZakupow.addLast(new Zakupy("masło"));
        listaZakupow.addLast(new Zakupy("chleb"));
        listaZakupow.addLast(new Zakupy("Banany"));
        listaZakupow.addLast(new Zakupy("jogurt"));
        listaZakupow.addLast(new Zakupy("bułki"));
        listaZakupow.addLast(new Zakupy("masło"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        adapter=new ZakupyAdapter(this,listaZakupow);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
przygotujListe();
dodaj=findViewById(R.id.button);
editText=findViewById(R.id.editTextTextPersonName);
dodaj.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Zakupy Produkt=new Zakupy(editText.getText().toString());
        adapter.Dodaj(Produkt);
        editText.setText("");
    }
});
usun=findViewById(R.id.button2);
usun.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
adapter.usunZaz();
    }
});

    }
}