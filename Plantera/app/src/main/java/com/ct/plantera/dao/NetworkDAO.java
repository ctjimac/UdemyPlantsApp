package com.ct.plantera.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by charlest on 11/27/17.
 */

public class NetworkDAO {

    public String fetch(String uri) throws IOException {
        StringBuilder sb = new StringBuilder();

        URL url = new URL(uri);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try{
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            String inputLine;

            while((inputLine = bin.readLine()) != null){
                sb.append(inputLine);
            }
        }finally {
            urlConnection.disconnect();
        }

        return sb.toString();
    }

}
