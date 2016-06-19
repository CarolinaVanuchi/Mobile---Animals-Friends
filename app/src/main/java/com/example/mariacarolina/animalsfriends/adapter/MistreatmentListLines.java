package com.example.mariacarolina.animalsfriends.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariacarolina.animalsfriends.R;
import com.example.mariacarolina.animalsfriends.modelo.MistreatmentModel;

import java.util.List;

/**
 * Created by MariaCarolina on 14/06/2016.
 */
public class MistreatmentListLines extends BaseAdapter {
    List<MistreatmentModel> lista;
    Activity activity;

    public MistreatmentListLines(List<MistreatmentModel> lista, Activity activity) {
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
        View view = LayoutInflater.from(activity).inflate(R.layout.line_mistretmen, parent, false);
        MistreatmentModel listaAdoption = lista.get(position);

        TextView desc = (TextView) view.findViewById(R.id.lineDescriptionAnimal);
        desc.setText(listaAdoption.getDescription());

        TextView city = (TextView) view.findViewById(R.id.lineCity);
        city.setText(listaAdoption.getCity());
        return view;
    }
}
