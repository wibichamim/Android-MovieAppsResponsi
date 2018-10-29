package com.wibi.movielover;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("/3/movie/now_playing")
    Call<ResponseM> getNowPlayingMovie(@Query("api_key") String api_key,
                                       @Query("language") String language);

//    @GET("3/discover/movie")
//    Call<ResponseM> getAllMovies(@Query("api_key") String api_key,
//                                      @Query("language") String language,
//                                      @Query("sort_by") String sort_by,
//                                      @Query("include_adult") String include_adult);
//    @GET("/3/search/movie")
//    Call<ResponseM> getSearchMovie(@Query("api_key") String api_key,
//                                        @Query("language") String language,
//                                        @Query("query") String query,
//                                        @Query("page") String page,
//                                        @Query("include_adult") String include_adult);
//
//    @GET("/3/movie/upcoming")
//    Call<ResponseM> getUpComingMovie(@Query("api_key") String api_key,
//                                          @Query("language") String language);
//
//    @GET("/3/movie/popular")
//    Call<ResponseM> getPopularMovies(@Query("api_key") String api_key,
//                                          @Query("language") String language);
//
//    @GET("/3/movie/top_rated")
//    Call<ResponseM> getTopRatedMovies(@Query("api_key") String api_key,
//                                           @Query("language") String language);

}

