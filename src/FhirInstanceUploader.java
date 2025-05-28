import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FhirInstanceUploader {

    public void uploadAllJsonInFolder() {

        final String FhirServerBaseUrl = "https://gw.interop.community/bmeshelltest/open/";
        HttpClient client = HttpClient.newHttpClient();

        File folder = new File("src/upload");
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            String fileContent = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                            JsonObject jsonObject = JsonParser.parseString(fileContent).getAsJsonObject();

                            String myResourceType = jsonObject.get("resourceType").toString();
                            String myId = jsonObject.get("id").toString();
                            String myUri = FhirServerBaseUrl + myResourceType.substring(1, myResourceType.length() - 1) + "/" + myId.substring(1, myId.length() - 1);

                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(new URI(myUri))
                                    .headers("Content-Type", "application/json")
                                    .PUT(HttpRequest.BodyPublishers.ofString(fileContent))
                                    .build();

                            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                        }
                        catch (IOException e) {
                            System.out.println("Error reading file: " + file.getName());
                            e.printStackTrace();
                        }
                        catch (URISyntaxException e) {
                            System.out.println("URI syntax exception: " + file.getName());
                            e.printStackTrace();
                        }
                        catch (InterruptedException e) {
                            System.out.println("Interrupted exception: " + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("The folder is empty or an error occurred.");
            }
        } else {
            System.out.println("The specified path is not a valid folder.");
        }
    }

}
