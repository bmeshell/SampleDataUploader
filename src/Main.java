import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FhirInstanceUploader fhirInstanceUploader = new FhirInstanceUploader();
        fhirInstanceUploader.uploadAllJsonInFolder();

        /*
        try {
            URL url = new URL("https://gw.interop.community/bmeshelltest/open/Practitioner/PFEIG-Practitioner-JohnSmith");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response);
            } else {
                System.out.println("GET request did not work.");
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

         */
    }
}