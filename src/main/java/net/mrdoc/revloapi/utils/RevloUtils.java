package net.mrdoc.revloapi.utils;

import net.mrdoc.revloapi.Core;
import net.mrdoc.revloapi.RevloAPI;
import net.mrdoc.revloapi.exception.RevloException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class RevloUtils {

    public static JSONObject GETRequestJSON(boolean debug,String urlbase, String parameter, String key) throws RevloException {
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

        System.out.println("\nSending 'GET' request to URL : " + urlbase + parameter);
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

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

    public static JSONObject POSTRequestJSON(boolean debug, String urlbase, String parameter, JSONObject postParameters, String key) throws RevloException {
        // create HTTP Client
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Create new getRequest with below mentioned URL
        HttpPost getRequest = new HttpPost(urlbase + parameter);

        System.out.println(urlbase+parameter);

        try {
            getRequest.setEntity(new StringEntity(postParameters.toString()));
        } catch (UnsupportedEncodingException e) {
            throw new RevloException(e.getCause());
        }

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
            throw new RevloException(e.getCause());
        }


        System.out.println("\nSending 'POST' request to URL : " + urlbase + parameter);
        System.out.println("Post parameters : " + getRequest.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());


        // Check for HTTP response code: 200 = success
        if(response.getStatusLine() == null) {
            throw new RevloException("Failed: The status is a null");
        }
        if (response.getStatusLine().getStatusCode() != 200) {
            //throw new RevloException("Failed: HTTP error code " + response.getStatusLine().getStatusCode() + "\nMore Info: " + response.getStatusLine().getReasonPhrase());
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

            System.out.println("prejson: " + output);

            System.out.println("json: " + new JSONObject(output).toString());

            return new JSONObject(output);
        } catch (IOException e) {
            throw new RevloException(e.getCause());
        }
    }
}
