package com.example.mariacarolina.animalsfriends;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mariacarolina.animalsfriends.adapter.MistreatmentListLines;
import com.example.mariacarolina.animalsfriends.modelo.MistreatmentModel;

import java.util.List;

public class MistreatmenList extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private MistreatmentModel adoptionModelo;
    private MistreatmentListLines adoptionListLines;
    private List<MistreatmentModel> adoptions;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mistreatmen_list);

        listView = (ListView) findViewById(R.id.listViewMistreatmen);
        preencherLista();
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        preencherLista();
    }

    public void callScreenRegisterMistreatmen(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterMistreatmen.class);
        startActivity(intent);
    }

    public void preencherLista() {
        List<MistreatmentModel> modelo = MistreatmentModel.listAll(MistreatmentModel.class);
        adoptionListLines = new MistreatmentListLines(modelo, this);
        listView.setAdapter(adoptionListLines);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Recuperando o id do produto
        Long idItem = adoptionListLines.getItemId(position);
        // é necessário passar esse id para a activity do formulario para editar
        Bundle bd = new Bundle();
        bd.putLong("idAMist", idItem);

        //Chamar a activity do formulário
        Intent itt = new Intent(this, RegisterMistreatmen.class);
        itt.putExtras(bd);
        startActivity(itt);
    }

    @Override
    protected void onResume() {
        super.onResume();
        preencherLista();
    }


}
