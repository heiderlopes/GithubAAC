package br.com.heiderlopes.githubaac.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface UserWebService {

    @GET("/users/{user}")
    fun getUser(@Path("user") userId: String)

}