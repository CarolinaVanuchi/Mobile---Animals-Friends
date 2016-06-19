package com.example.mariacarolina.animalsfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mariacarolina.animalsfriends.adapter.AdoptionListLines;
import com.example.mariacarolina.animalsfriends.modelo.AdoptionModelo;

import java.util.List;

public class AdoptionList  extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AdoptionModelo adoptionModelo;
    private AdoptionListLines adoptionListLines;
    private List<AdoptionModelo> adoptions;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption_list);
        listView = (ListView) findViewById(R.id.listViewAdoption);
        preencherLista();

        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        preencherLista();
    }

    public void callScreenRegisterAdoption(View view)
    {
        Intent intent = new Intent(getApplicationContext(), RegisterAdoption.class);
        startActivity(intent);
    }

    public void preencherLista()
    {
        List<AdoptionModelo> modelo = AdoptionModelo.listAll(AdoptionModelo.class);
        adoptionListLines = new AdoptionListLines(modelo, this);
        listView.setAdapter(adoptionListLines);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Long idItem= adoptionListLines.getItemId(position);
        Bundle bd=new Bundle();

        bd.putLong("idAdoption",idItem);

        Intent itt=new Intent(this, RegisterAdoption.class);
        itt.putExtras(bd);
        startActivity(itt);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        preencherLista();
    }

}
