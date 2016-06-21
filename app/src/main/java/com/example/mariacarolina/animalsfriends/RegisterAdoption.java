package com.example.mariacarolina.animalsfriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mariacarolina.animalsfriends.modelo.AdoptionModelo;
import com.example.mariacarolina.animalsfriends.service.WebService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterAdoption extends AppCompatActivity {

    private AdoptionModelo model = new AdoptionModelo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_adoption);

        // Spinner states = (Spinner)
        //      findViewById(R.id.id_spinner_estados);
        // Cria um ArraAdapter usando um array de string e um layout padrão de spinner
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.states,
                        android.R.layout.simple_spinner_item);
        //alterar a fonte de dados(adapter) do Spinner
        // states.setAdapter(adapter);

        //String texto;
        //texto = states.getSelectedItem().toString();

        // É preciso pegar o id di produto que foi passado pela activity da lista
        if(getIntent().hasExtra("idAdoption")){
            Bundle bundle = getIntent().getExtras();
            Long id = bundle.getLong("idAdoption");
            model = (AdoptionModelo) AdoptionModelo.findById(AdoptionModelo.class, id);

           setDadosAdocao();
        }
    }

    private void setDadosAdocao(){
        EditText age = (EditText) findViewById(R.id.idEdAge);
        EditText namePerson = (EditText) findViewById(R.id.idEdNamePerson);
        EditText cpfPerson = (EditText) findViewById(R.id.idEdCPF);
        EditText emailPerson = (EditText) findViewById(R.id.idEdMail);
        EditText telephonePerson = (EditText) findViewById(R.id.idEdTelephone);
        EditText celphonePerson = (EditText) findViewById(R.id.idEdCelphone);
        EditText nameAnimal = (EditText) findViewById(R.id.idEdNameAnimal);
        EditText descriptionAnimal = (EditText) findViewById(R.id.idEdDescription);
        EditText speciesAnimal = (EditText) findViewById(R.id.idEdSpecie);
        EditText weightAnimal = (EditText) findViewById(R.id.idEdWeight);
        EditText sizetAnimal = (EditText) findViewById(R.id.idEdSize);
        EditText genderAnimal = (EditText) findViewById(R.id.idEdGender);
        EditText breedAnimal = (EditText) findViewById(R.id.idEdBreed);
        EditText castratedAnimal = (EditText) findViewById(R.id.idEdCas);
        EditText cityName = (EditText) findViewById(R.id.idEdCity);
        EditText stateName = (EditText) findViewById(R.id.idEdState);
        EditText linkVideo = (EditText) findViewById(R.id.idEdLinkVideo);
        EditText dateRegister = (EditText) findViewById(R.id.idDateRegister);


        age.setText(model.getAgeAnimal());
        namePerson.setText(model.getNamePerson());
        cpfPerson.setText(model.getCpfPerson());
        emailPerson.setText(model.getEmailPerson());
        telephonePerson.setText(model.getTelephonePerson());
        celphonePerson.setText(model.getCelphonePerson());
        nameAnimal.setText(model.getNameAnimal());
        descriptionAnimal.setText(model.getDescriptionAnimal());
        speciesAnimal.setText(model.getSpeciesAnimal());
        weightAnimal.setText(model.getWeightAnimal());
        sizetAnimal.setText(model.getSizetAnimal());
        genderAnimal.setText(model.getGenderAnimal());
        breedAnimal.setText(model.getBreedAnimal());
        castratedAnimal.setText(model.getCastratedAnimal());
        cityName.setText(model.getCityName());
        stateName.setText(model.getStateName());
        linkVideo.setText(model.getLinkVideo());
        dateRegister.setText(model.getRegistrationDate());

        Button button = (Button) findViewById(R.id.button_delete);
        button.setEnabled(true);
    }

    public void save(View view) {
        try {

            EditText age = (EditText) findViewById(R.id.idEdAge);
            EditText namePerson = (EditText) findViewById(R.id.idEdNamePerson);
            EditText cpfPerson = (EditText) findViewById(R.id.idEdCPF);
            EditText emailPerson = (EditText) findViewById(R.id.idEdMail);
            EditText telephonePerson = (EditText) findViewById(R.id.idEdTelephone);
            EditText celphonePerson = (EditText) findViewById(R.id.idEdCelphone);
            EditText nameAnimal = (EditText) findViewById(R.id.idEdNameAnimal);
            EditText descriptionAnimal = (EditText) findViewById(R.id.idEdDescription);
            EditText speciesAnimal = (EditText) findViewById(R.id.idEdSpecie);
            EditText weightAnimal = (EditText) findViewById(R.id.idEdWeight);
            EditText sizetAnimal = (EditText) findViewById(R.id.idEdSize);
            EditText genderAnimal = (EditText) findViewById(R.id.idEdGender);
            EditText breedAnimal = (EditText) findViewById(R.id.idEdBreed);
            EditText castratedAnimal = (EditText) findViewById(R.id.idEdCas);
            EditText cityName = (EditText) findViewById(R.id.idEdCity);
            EditText stateName = (EditText) findViewById(R.id.idEdState);
            EditText linkVideo = (EditText) findViewById(R.id.idEdLinkVideo);
            EditText dateRegister = (EditText) findViewById(R.id.idDateRegister);

            if(namePerson.getText().toString().isEmpty()){
                namePerson.requestFocus();
            }if(emailPerson.getText().toString().isEmpty()){
                emailPerson.requestFocus();
            }if(celphonePerson.getText().toString().isEmpty()){
                celphonePerson.requestFocus();
            }if(telephonePerson.getText().toString().isEmpty()){
                telephonePerson.requestFocus();
            }if(descriptionAnimal.getText().toString().isEmpty()){
                descriptionAnimal.requestFocus();
            }else {
                model.setAgeAnimal(age.getText().toString());
                model.setAgeAnimal(age.getText().toString());
                model.setNamePerson(namePerson.getText().toString());
                model.setCpfPerson(cpfPerson.getText().toString());
                model.setEmailPerson(emailPerson.getText().toString());
                model.setTelephonePerson(telephonePerson.getText().toString());
                model.setCelphonePerson(celphonePerson.getText().toString());
                model.setNameAnimal(nameAnimal.getText().toString());
                model.setDescriptionAnimal(descriptionAnimal.getText().toString());
                model.setSpeciesAnimal(speciesAnimal.getText().toString());
                model.setWeightAnimal(weightAnimal.getText().toString());
                model.setSizetAnimal(sizetAnimal.getText().toString());
                model.setGenderAnimal(genderAnimal.getText().toString());
                model.setBreedAnimal(breedAnimal.getText().toString());
                model.setCastratedAnimal(castratedAnimal.getText().toString());
                model.setCityName(cityName.getText().toString());
                model.setLinkVideo(linkVideo.getText().toString());
                model.setRegistrationDate(dateRegister.getText().toString());
                model.setStateName(stateName.getText().toString());

                if (model.getId() == null) {
                    WebService.passarDadosWebService(model.getNamePerson(), model.getCpfPerson(), model.getEmailPerson(),
                            model.getTelephonePerson(), model.getCelphonePerson(), model.getNameAnimal(), model.getDescriptionAnimal(),
                            model.getSpeciesAnimal(), model.getWeightAnimal(), model.getSizetAnimal(), model.getGenderAnimal(),
                            model.getAgeAnimal(), model.getBreedAnimal(), model.getCastratedAnimal(),
                            model.getRegistrationDate(), model.getLinkVideo(), model.getCityName(), model.getStateName());
                }
                Toast.makeText(RegisterAdoption.this, "Operação realizada com sucesso ", Toast.LENGTH_LONG).show();
                finish();
            }
            model.save();
            model = new AdoptionModelo();
        } catch (Exception e) {
            Toast.makeText(RegisterAdoption.this, "Erro " + e, Toast.LENGTH_LONG).show();
        }
    }

    public void delete(View view){
        model.delete();
        finish();
    }

}
