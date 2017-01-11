package net.mrdoc.revloapi;

import net.mrdoc.revloapi.classes.Reward;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class API {

    final private static String REVLO_URL = "https://api.revlo.co/1/";

    public static void test() {
        try {

            // create HTTP Client
            HttpClient httpClient = HttpClientBuilder.create().build();

            // Create new getRequest with below mentioned URL
            HttpGet getRequest = new HttpGet(REVLO_URL+"rewards");

            // Add additional header to getRequest which accepts application/xml data
            getRequest.addHeader("accept", "application/xml");

            //Add api key
            getRequest.addHeader("x-api-key", Core.getAPIKEY());

            // Execute your request and catch response
            HttpResponse response = httpClient.execute(getRequest);

            // Check for HTTP response code: 200 = success
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            // Get-Capture Complete application/xml body response
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));



            String output;
            System.out.println("============Output:============");

            String test = "";

            // Simply iterate through XML response and show on console.
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                test = output;
            }

            System.out.println("TEST DOC\n");

            JSONObject jsonObj = new JSONObject(test);

            JSONArray jsonArray = jsonObj.getJSONArray("rewards");

            System.out.println("TAMAÑO: " + jsonArray.length());

            JSONObject jsonObject2 = jsonArray.getJSONObject(0);

            System.out.println("TAMAÑO2: " + jsonObject2.length());

            Gson gson = new Gson();

            System.out.println(jsonObject2.toString());

            Reward rTest = gson.fromJson(jsonObject2.toString(),Reward.class);

            System.out.println("TEST: " + rTest.getDESCRIPTION());

        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
