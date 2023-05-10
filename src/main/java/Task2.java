import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        int userId = 1;
        int postId = getLastPostId(userId);



String url = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";

        String jsonResponse = readJsonFromUrl(url);
        JsonArray commentsArray = parseJsonArray(jsonResponse);

        String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
        writeJsonArrayToFile(commentsArray, fileName);
        }

private static int getLastPostId(int userId) throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";
        String jsonResponse = readJsonFromUrl(url);
        JsonArray postsArray = parseJsonArray(jsonResponse);

        int lastPostId = 0;
        for (JsonElement element : postsArray) {
        int postId = element.getAsJsonObject().get("id").getAsInt();
        if (postId > lastPostId) {
        lastPostId = postId;
        }
        }

        return lastPostId;
        }

private static String readJsonFromUrl(String url) throws IOException {
        InputStream inputStream = new URL(url).openStream();
        try (Scanner scanner = new Scanner(inputStream)) {
        return scanner.useDelimiter("\\A").next();
        }
        }

private static JsonArray parseJsonArray(String json) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        if (element.isJsonArray()) {
        return element.getAsJsonArray();
        }
        return new JsonArray();
        }

private static void writeJsonArrayToFile(JsonArray jsonArray, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
        Gson gson = new Gson();
        gson.toJson(jsonArray, fileWriter);
        }}}
