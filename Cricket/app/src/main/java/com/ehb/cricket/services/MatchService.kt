package com.ehb.cricket.services

import com.ehb.cricket.classes.Matches
import retrofit2.Call
import retrofit2.http.GET

interface MatchService {
    @GET("/v1/currentMatches?apikey=3b88eab0-c4f9-4b55-b32b-e5b79df72e71&offset=0")
    fun getMatches(): Call <List<Matches>>
}