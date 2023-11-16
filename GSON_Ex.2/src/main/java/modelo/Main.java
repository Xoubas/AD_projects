package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://v2.jokeapi.dev/joke/Any");
        Joke joke = getJoke(url);
        System.out.println(joke.toString());
    }

    public static void saveJoke(File file) {
        Gson gson = new GsonBuilder().
                setPrettyPrinting().
                serializeNulls().
                registerTypeAdapter(Joke.class, new JokeTypeAdapter()).
                create();

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("json.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//            gson.toJson(bos, )
    }

    public static Joke getJoke(URL url) {
        Gson gson = new GsonBuilder().
                setPrettyPrinting().
                serializeNulls().
                registerTypeAdapter(Joke.class, new JokeTypeAdapter()).
                create();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));) {
            return gson.fromJson(br, Joke.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}