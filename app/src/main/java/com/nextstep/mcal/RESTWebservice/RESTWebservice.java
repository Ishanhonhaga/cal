package com.nextstep.mcal.RESTWebservice;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ContentHandler;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ishan on 20/01/16.
 */
public class RESTWebservice {

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * Mehod to register Device and user on the server Side
     * @param Device_ID
     * @param Red_Id
     * @param mCotext
     * @return
     * @throws IOException
     */
    public String GCMRegisterServerSide(String Device_ID, String Red_Id, Context mCotext) throws IOException {
        String responseCode;

        URL url = new URL("https://crankoutapp-production.herokuapp.com/gcm/v1/device/register");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == 200) {
                InputStream s = conn.getInputStream();
                responseCode = convertStreamToString(s);
                JSONTokener tokener = new JSONTokener(responseCode);
                try {
                    JSONObject jsonObject = new JSONObject(tokener);
                    return jsonObject.optString("success");
                }catch (Exception e){

                }

            } else {
                Toast.makeText(mCotext, "Connection Failed", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {

        }

        return "-1";

    }
}
