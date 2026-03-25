package eci.arem.service;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;

@Service
public class ProxyService {

    private final String url1 = System.getenv("URL1");
    private final String port1 = System.getenv("PORT1");

    private final String url2 =  System.getenv("URL2");
    private final String port2 = System.getenv("PORT2");

    private ArrayList<String> routes = new ArrayList<String>();
    public String route(int n) throws Exception {
        routes.add(url1 + ":" + port1);
        routes.add(url2 + ":" + port2);
        String userAgent = "Mozilla/5.0";


        URL obj;
        Exception exception = null;

        for(String route: routes){
            try{
                System.out.println("trying with: " + route + "/lucas?n=" + n);
                obj = new URL(route + "/lucas?n=" + n);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                con.setRequestProperty("User-Agent", userAgent);

                //The following invocation perform the connection implicitly before getting the code
                int responseCode = con.getResponseCode();
                System.out.println("GET Response Code :: " + responseCode);

                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    return response.toString();
                } else {
                    return "GET request not worked";
                }
            } catch (Exception e){
                exception = e;
            }
        }

        throw new Exception(exception.getMessage());

    }

}