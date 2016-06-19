package com.example.mariacarolina.animalsfriends.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariacarolina.animalsfriends.R;
import com.example.mariacarolina.animalsfriends.modelo.AdoptionModelo;

import java.util.List;

/**
 * Created by MariaCarolina on 12/06/2016.
 */
public class AdoptionListLines extends BaseAdapter {
    List<AdoptionModelo> lista;
    Activity activity;

    public AdoptionListLines(List<AdoptionModelo> lista, Activity activity) {
        this.lista = lista;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = LayoutInflater.from(activity).inflate(R.layout.line_adoption, parent, false);
        AdoptionModelo listaAdoption = lista.get(position);

        TextView name = (TextView) view.findViewById(R.id.lineName);
        name.setText(listaAdoption.getNameAnimal());

        TextView desc = (TextView) view.findViewById(R.id.lineDescription);
        desc.setText(listaAdoption.getDescriptionAnimal());
        return view;
    }
}
