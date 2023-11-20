package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://v2.jokeapi.dev/joke/Any");
//        Joke joke = getJoke(url);
//        System.out.println(joke.toString());

    }

    //Saves a json string to a file
    public static void saveJokeString(File file) {
        String json = "{\n" +
                "    \"error\": false,\n" +
                "    \"category\": \"Programming\",\n" +
                "    \"type\": \"single\",\n" +
                "    \"joke\": \"Two SQL tables sit at the bar. A query approaches and asks \\\"Can I join you?\\\"\",\n" +
                "    \"flags\": {\n" +
                "        \"nsfw\": false,\n" +
                "        \"religious\": false,\n" +
                "        \"political\": false,\n" +
                "        \"racist\": false,\n" +
                "        \"sexist\": false,\n" +
                "        \"explicit\": false\n" +
                "    },\n" +
                "    \"id\": 221,\n" +
                "    \"safe\": true,\n" +
                "    \"lang\": \"en\"\n" +
                "}";
        Path address;
        if (file.isDirectory())
            address = Paths.get(file.getPath(), "json.json");
        else
            address = file.toPath();

        try {
            Files.writeString(address, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Saves the Joke object to a json file
    public static void saveJoke(File file, Joke joke) {
        Gson gson = new GsonBuilder().
                setPrettyPrinting().
                serializeNulls().
                registerTypeAdapter(Joke.class, new JokeTypeAdapter()).
                create();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(joke, bw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //This method gets a json from a URL and returns it in a Joke object
    public static Joke getJokeURL(URL url) {
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

    /*
    This method gets a json from a json file and writes it to an object
    joke with typeAdapter
     */
    public static Joke getJokeFiles(File file) {
        Gson gson = new GsonBuilder().
                setPrettyPrinting().
                serializeNulls().
                registerTypeAdapter(Joke.class, new JokeTypeAdapter()).
                create();

        try {
            String json = Files.readString(file.toPath());
            return gson.fromJson(json, Joke.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}