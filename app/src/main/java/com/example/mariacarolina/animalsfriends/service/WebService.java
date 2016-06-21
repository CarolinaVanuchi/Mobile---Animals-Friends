package com.example.mariacarolina.animalsfriends.service;

import android.os.StrictMode;
import android.util.Log;

import com.example.mariacarolina.animalsfriends.modelo.MistreatmentModel;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MariaCarolina on 14/06/2016.
 */
public class WebService {

    public static void passarDadosWebService(
            String namePerson,
            String cpfPerson,
            String emailPerson,
            String telephonePerson,
            String celphonePerson,
            String nameAnimal,
            String descriptionAnimal,
            String speciesAnimal,
            String weightAnimal,
            String sizetAnimal,
            String genderAnimal,
            String ageAnimal,
            String breedAnimal,
            String castratedAnimal,
            String registrationDate,
            String linkVideo,
            String cityName,
            String stateName

    ) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String myurl = "http://172.17.255.109:8080/ServicoWeb/resource/webService/save";
        String POST_PARAMS = "namePerson=" + namePerson + "&cpfPerson=" + cpfPerson + "&emailPerson=" + emailPerson +
                "&telephonePerson=" + telephonePerson + "&celphonePerson=" + celphonePerson +"&nameAnimal="+nameAnimal+
                "&descriptionAnimal="+descriptionAnimal+"&speciesAnimal"+speciesAnimal+"&weightAnimal="+weightAnimal+
                "&sizetAnimal="+sizetAnimal+"&genderAnimal="+genderAnimal+"&ageAnimal="+ageAnimal+"&breedAnimal="+breedAnimal+
                "&castratedAnimal="+castratedAnimal+"&registrationDate="+registrationDate+"&linkVideo="+linkVideo+
                "&cityName="+cityName+"&stateName="+stateName;
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            OutputStream os = conn.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            conn.connect();
            int response = conn.getResponseCode();
            Log.i("MainActivity", "The response is: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void passarDadosWebServiceMausTratos(MistreatmentModel model) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String myurl = "http://172.17.255.109:8080/ServicoWeb/resource/webService/mistreatmentSave";
        String POST_PARAMS = "namePerson=" + model.getNamePerson()+
                "&specie="+model.getSpecie()+"&description="+model.getDescription()+
                "&celphone = "+model.getCelphone()+"&state="+model.getState()+"&city="+model.getCity()+
                "&neighborhood="+model.getNeighborhood()+"&street="+model.getStreet()+
                "&longitude="+model.getLongitude()+"&latitude="+model.getLatitude();
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            OutputStream os = conn.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            conn.connect();
            int response = conn.getResponseCode();
            Log.i("MainActivity", "The response is: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
