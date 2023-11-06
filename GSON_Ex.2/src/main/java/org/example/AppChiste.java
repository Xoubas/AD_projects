package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppChiste {
    Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().registerTypeAdapter().create();
}
