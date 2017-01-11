package net.mrdoc.revloapi.utils;

import net.mrdoc.revloapi.Core;
import net.mrdoc.revloapi.RevloAPI;
import net.mrdoc.revloapi.exception.RevloException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class RevloUtils {

    public static JSONObject generateRequestJSON(String urlbase, String parameter, String key) throws RevloException{
        // create HTTP Client
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Create new getRequest with below mentioned URL
        HttpGet getRequest = new HttpGet(urlbase + parameter);

        System.out.println(urlbase+parameter);

        //Set all headers
        getRequest.addHeader("x-api-key",key);

        getRequest.addHeader("Accept", "application/json");

        getRequest.addHeader("Host","api.revlo.co:443");

        getRequest.addHeader("Connection","close");

        // Execute your request and catch response
        HttpResponse response = null;
        try {
            response = httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check for HTTP response code: 200 = success
        if(response.getStatusLine() == null) {
            throw new RevloException("Failed: The status is a null");
        }
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RevloException("Failed: HTTP error code " + response.getStatusLine().getStatusCode() + "\nMore Info: " + response.getStatusLine().getReasonPhrase());
        }

        // Get-Capture Complete body response
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String posOuytput;
            String output = "";
            while ((posOuytput = br.readLine()) != null) {
                output = posOuytput;
            }

            if(output.isEmpty()) {
                return null;
            }

            return new JSONObject(output);
        } catch (IOException e) {
            throw new RevloException(e.getCause());
        }
    }
}
