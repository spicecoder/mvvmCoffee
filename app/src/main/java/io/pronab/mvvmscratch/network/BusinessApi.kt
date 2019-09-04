package io.pronab.mvvmscratch.network

import io.pronab.mvvmscratch.model.Businesses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface BusinessApi {

/**
 * The interface which provides methods to get result of webservices
 */

    /**
     * Get the list of the businesses
     */

  @Headers("Content-Type:application/json; charset=UTF-8","Authorization:Bearer _oSp9APYxZlWNgpgFs1PZnPQnXlLyjyJBPgLYQlaYUtunDALUJNyB2cyEhalN3lgDF7yKIBwtweBZNpfaoJ73Azb357YC7QKLa3kQk7v8FkMiqZUPEomWB9-nS5pXXYx")
  @GET("v3/businesses/search?limit=10&Catergories='Coffee'&location='Brisbane'")
    fun getBusiness(): Call<Businesses>
}