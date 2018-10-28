package com.wibi.movielover;

public class ServerApi {

    public static final String BASE_URL_API = "https://api.themoviedb.org/";

    public static MovieApi getAPIService(){
        return ClientApi.getClient(BASE_URL_API).create(MovieApi.class);
    }

}
