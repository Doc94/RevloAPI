package net.mrdoc.revloapi;

import net.mrdoc.revloapi.classes.Reward;
import net.mrdoc.revloapi.utils.RevloUtils;
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

            JSONObject jsonObj = RevloUtils.generateRequestJSON(REVLO_URL,"rewards",Core.getAPIKEY());

            System.out.println(jsonObj.toString());

            /*
            JSONObject jsonObj = new JSONObject(test);

            JSONArray jsonArray = jsonObj.getJSONArray("rewards");

            System.out.println("TAMAÑO: " + jsonArray.length());

            JSONObject jsonObject2 = jsonArray.getJSONObject(0);

            System.out.println("TAMAÑO2: " + jsonObject2.length());

            Gson gson = new Gson();

            System.out.println(jsonObject2.toString());

            Reward rTest = gson.fromJson(jsonObject2.toString(),Reward.class);

            System.out.println("TEST: " + rTest.getDESCRIPTION());
            */
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
