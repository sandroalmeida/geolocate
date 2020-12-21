package com.kashoo.controller;

import com.beerboy.ss.SparkSwagger;
import com.google.gson.Gson;
import com.kashoo.model.LocationProperty;
import com.kashoo.service.IPGeoLocationConnector;
import com.kashoo.swagger.GeoLocateEndpoint;
import org.apache.commons.validator.routines.InetAddressValidator;
import spark.Service;

import java.io.IOException;
import java.util.Arrays;

import static spark.Spark.*;
public class GeoLocate
{
    public static void main( String[] args ) throws IOException {

        Service spark = Service.ignite()
                .ipAddress("localhost")
                .port(55555);

        SparkSwagger.of(spark, SparkSwagger.CONF_FILE_NAME)
                .endpoints(() -> Arrays.asList(new GeoLocateEndpoint()))
                .generateDoc();

        get("/geolocate/:ip", (req,res)->{

            InetAddressValidator validator = new InetAddressValidator();
            String IPAddress = req.params(":ip");
            boolean isValid = validator.isValid(IPAddress);

            if(isValid) {
                String contentReturn = IPGeoLocationConnector.getLocation(IPAddress);
                res.type("application/json");
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS,new Gson().fromJson(contentReturn, LocationProperty.class)));

            } else
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "IP not valid."));
        });
    }
}
