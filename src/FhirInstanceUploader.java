import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FhirInstanceUploader {

    public void uploadAllJsonInFolder() {
        final String FhirServerBaseUrl = "";
        File folder = new File("src/upload");
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            String fileContent = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                            JsonObject jsonObject = JsonParser.parseString(fileContent).getAsJsonObject();
                            System.out.println("hi");
                        } catch (IOException e) {
                            System.out.println("Error reading file: " + file.getName());
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
