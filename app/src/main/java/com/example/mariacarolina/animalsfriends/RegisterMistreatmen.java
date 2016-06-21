package com.example.mariacarolina.animalsfriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mariacarolina.animalsfriends.modelo.MistreatmentModel;
import com.example.mariacarolina.animalsfriends.service.WebService;

public class RegisterMistreatmen extends AppCompatActivity {

    private MistreatmentModel model = new MistreatmentModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mistreatmen);

        //É preciso pegar o id do objeto que foi passado pela activity da lista

        if(getIntent().hasExtra("idAMist")){
            Bundle bundle = getIntent().getExtras();
            Long id = bundle.getLong("idAMist");
            model = (MistreatmentModel) MistreatmentModel.findById(MistreatmentModel.class, id);

            // Metodo para setar os dados do produto nos campos
            setarDados();
        }
    }

    public void  setarDados(){
        EditText namePerson = (EditText) findViewById(R.id.idEditNamePerson);
        EditText specie = (EditText) findViewById(R.id.idEditSpecies);
        EditText description = (EditText) findViewById(R.id.idEditDescription);
        EditText celphone = (EditText) findViewById(R.id.idEditCelphone);
        EditText state = (EditText) findViewById(R.id.idEditState);
        EditText city = (EditText) findViewById(R.id.idEditCity);
        EditText neighborhood = (EditText) findViewById(R.id.idEditNeighborhood);
        EditText street = (EditText) findViewById(R.id.idEditStreet);
        EditText longitude = (EditText) findViewById(R.id.idEditLongitude);
        EditText latitude = (EditText) findViewById(R.id.idEditLatitude);


        namePerson.setText(model.getNamePerson());
        specie.setText(model.getSpecie());
        description.setText(model.getDescription());
        celphone.setText(model.getCelphone());
        state.setText(model.getState());
        city.setText(model.getCity());
        neighborhood.setText(model.getNeighborhood());
        street.setText(model.getStreet());
        longitude.setText(model.getLongitude());
        latitude.setText(model.getLatitude());

        Button button = (Button) findViewById(R.id.button_delete);
        button.setEnabled(true);

    }

    public void save(View view)
    {
        try {

            EditText namePerson = (EditText) findViewById(R.id.idEditNamePerson);
            EditText specie = (EditText) findViewById(R.id.idEditSpecies);
            EditText description = (EditText) findViewById(R.id.idEditDescription);
            EditText celphone = (EditText) findViewById(R.id.idEditCelphone);
            EditText state = (EditText) findViewById(R.id.idEditState);
            EditText city = (EditText) findViewById(R.id.idEditCity);
            EditText neighborhood = (EditText) findViewById(R.id.idEditNeighborhood);
            EditText street = (EditText) findViewById(R.id.idEditStreet);
            EditText longitude = (EditText) findViewById(R.id.idEditLongitude);
            EditText latitude = (EditText) findViewById(R.id.idEditLatitude);

            if(TextUtils.isEmpty(latitude.getText().toString())){
                latitude.requestFocus();
            } if(TextUtils.isEmpty(longitude.getText().toString())){
                longitude.requestFocus();
            }else {
                model.setNamePerson(namePerson.getText().toString());
                model.setSpecie(specie.getText().toString());
                model.setDescription(description.getText().toString());
                model.setCelphone(celphone.getText().toString());
                model.setState(state.getText().toString());
                model.setCity(city.getText().toString());
                model.setNeighborhood(neighborhood.getText().toString());
                model.setStreet(street.getText().toString());
                model.setLongitude(longitude.getText().toString());
                model.setLatitude(latitude.getText().toString());

                if (model.getId() == null) {
                    WebService.passarDadosWebServiceMausTratos(model);
                }
                Toast.makeText(RegisterMistreatmen.this, "Operação realizada com sucessp ", Toast.LENGTH_LONG).show();
                finish();
            }
            model.save();
            model = new MistreatmentModel();
        }catch (Exception e){
            Toast.makeText(RegisterMistreatmen.this, "Erro "+e,Toast.LENGTH_LONG).show();
        }
    }

    public void delete(View view){
        model.delete();
        finish();
    }
}
