import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task1 {
    private static final String API_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) {
        Task1 apiService = new Task1();
        apiService.createUser();
        apiService.updateUser();
        apiService.deleteUser();
        apiService.getAllUsers();
        apiService.getUserById(1);
        apiService.getUserByUsername("Bret");
    }


    public void createUser() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = "{\"name\": \"John Doe\",\"username\": \"johndoe\",\"email\": \"johndoe@example.com\",\"address\": {\"street\": \"Main Street\",\"suite\": \"\",\"city\": \"New York\",\"zipcode\": \"10001-1000\",\"geo\": {\"lat\": \"40.714\",\"lng\": \"-74.006\"}},\"phone\": \"+1-202-555-0125\",\"website\": \"http://johndoe.com\",\"company\": {\"name\": \"John Doe LLC\",\"catchPhrase\": \"\",\"bs\": \"\"}}";

            byte[] input = jsonInputString.getBytes("utf-8");
            connection.getOutputStream().write(input, 0, input.length);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateUser() {
        try {
            URL url = new URL(API_URL + "/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = "{\"id\": 1,\"name\": \"John Doe\",\"username\": \"johndoe\",\"email\": \"johndoe@example.com\",\"address\": {\"street\": \"Main Street\",\"suite\": \"\",\"city\": \"New York\",\"zipcode\": \"10001-1000\",\"geo\": {\"lat\": \"40.714\",\"lng\": \"-74.006\"}},\"phone\": \"+1-202-555-0125\",\"website\": \"http://johndoe.com\",\"company\": {\"name\": \"John Doe LLC\",\"catchPhrase\": \"\",\"bs\": \"\"}}";

            byte[] input = jsonInputString.getBytes("utf-8");
            connection.getOutputStream().write(input, 0, input.length);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser() {
        try {
            URL url = new URL(API_URL + "/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            int responseCode = connection.getResponseCode();

            if (responseCode / 100 == 2) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Failed to delete user.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAllUsers() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUserById(int id) {
        try {
            URL url = new URL(API_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUserByUsername(String username) {
        try {
            URL url = new URL(API_URL + "?username=" + username);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



