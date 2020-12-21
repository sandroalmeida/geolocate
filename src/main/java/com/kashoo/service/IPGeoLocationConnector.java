package com.kashoo.service;

import com.kashoo.util.ConfigPropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class IPGeoLocationConnector {

    private static final Logger logger = LoggerFactory.getLogger(IPGeoLocationConnector.class);

    public static String getLocation(String IP){
        String url = "https://api.ipgeolocation.io/ipgeo";
        String charset = java.nio.charset.StandardCharsets.UTF_8.name();

        try {
            String query = String.format("apiKey=%s&ip=%s",
                    URLEncoder.encode(ConfigPropertiesReader.getProperty("apiKey"), charset),
                    URLEncoder.encode(IP, charset));

            String finalURL = url + "?" + query;
            URLConnection connection = new URL(finalURL).openConnection();
            logger.info("IPGeoLocation accessed succeffully. URL: " + finalURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String contentReturn;
            StringBuilder sb = new StringBuilder();
            while ((contentReturn = in.readLine()) != null)
                sb.append(contentReturn);
            in.close();

            return sb.toString();

        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
