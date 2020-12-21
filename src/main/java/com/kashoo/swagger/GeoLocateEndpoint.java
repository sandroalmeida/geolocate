package com.kashoo.swagger;

import com.beerboy.spark.typify.route.GsonRoute;
import com.beerboy.ss.SparkSwagger;
import com.beerboy.ss.rest.Endpoint;
import com.kashoo.service.IPGeoLocationConnector;
import com.kashoo.model.LocationProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import static com.beerboy.ss.descriptor.EndpointDescriptor.endpointPath;
import static com.beerboy.ss.descriptor.MethodDescriptor.path;
import static com.beerboy.ss.rest.RestResponse.ok;

public class GeoLocateEndpoint implements Endpoint {

    private static final String NAME_SPACE = "/geolocate-doc";
    private static final Logger logger = LoggerFactory.getLogger(IPGeoLocationConnector.class);

    @Override
    public void bind(final SparkSwagger restApi) {

        restApi.endpoint(endpointPath(NAME_SPACE)
                .withDescription("GeoLocate REST API documentation "), (q, a) -> logger.info("Received request for GeoLocate Rest API"))

                .get(path("/geolocate")
                        .withDescription("Gets location for the IP informed")
                        .withQueryParam().withName("apiKey").withDescription("ipgeolocation key").and()
                        .withQueryParam().withName("ip").withDescription("ipgeolocation key").and()
                        .withResponseType(LocationProperty.class), new GsonRoute() {
                    @Override
                    public Object handleAndTransform(Request request, Response response) {


                        String ip;
                        String continent_code;
                        String continent_name;
                        String country_code2;
                        String country_code3;
                        String country_name;
                        String country_capital;
                        String state_prov;
                        String district;
                        String city;
                        String zipcode;
                        String latitude;
                        String longitude;

                        LocationProperty locationProperty = new LocationProperty("127.0.0.1",
                                "NA",
                                "North America",
                                "CA",
                                "CAN",
                                "Canada",
                                "Ottawa",
                                "British Columbia",
                                "Douglas",
                                "Langley",
                                "V3J",
                                "11111",
                                "22222");

                        return ok(response, locationProperty);
                    }
                });


    }
}
