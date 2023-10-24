package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class AppPoeta {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().registerTypeAdapter(Poeta.class, new InstanceCreator<Poeta>() {
            @Override
            public Poeta createInstance(Type type) {
                return null;
            }
        }).create();

        Poeta poeta = gson.fromJson("{\"name\" : \"AnneSexton\"," +
                " \"age\" : 45}", Poeta.class);

        System.out.println(poeta);
    }
}
