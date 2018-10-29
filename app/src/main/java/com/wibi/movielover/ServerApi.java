package com.wibi.movielover;

public class ServerApi {

    public static final String URL_API = "https://api.themoviedb.org/";

    public static MovieApi getAPIService(){
        return ClientApi.getClient(URL_API).create(MovieApi.class);
    }

}
