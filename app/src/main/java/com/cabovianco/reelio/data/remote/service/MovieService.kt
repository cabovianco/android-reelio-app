package com.cabovianco.reelio.data.remote.service

import com.cabovianco.reelio.data.remote.dto.request.CreateListRequestDto
import com.cabovianco.reelio.data.remote.dto.request.CreateSessionRequestDto
import com.cabovianco.reelio.data.remote.dto.request.MovieRequestDto
import com.cabovianco.reelio.data.remote.dto.response.CreateListResponseDto
import com.cabovianco.reelio.data.remote.dto.response.CreateRequestTokenResponseDto
import com.cabovianco.reelio.data.remote.dto.response.CreateSessionResponseDto
import com.cabovianco.reelio.data.remote.dto.response.DiscoverResponseDto
import com.cabovianco.reelio.data.remote.dto.response.ListDetailsResponseDto
import com.cabovianco.reelio.data.remote.dto.response.MovieResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("discover/movie")
    suspend fun movieDiscover(@Query("page") page: Int = 1): DiscoverResponseDto<MovieResponseDto>

    @GET("/search/movie")
    suspend fun searchMovieByQuery(
        @Query("query") query: String,
        @Query("page") page: Int = 1
    ): DiscoverResponseDto<MovieResponseDto>

    @GET("authentication/token/new")
    suspend fun createRequestToken(): CreateRequestTokenResponseDto

    @POST("authentication/session/new")
    suspend fun createSession(@Body body: CreateSessionRequestDto): CreateSessionResponseDto

    @POST("list")
    suspend fun createList(
        @Query("session_id") sessionId: String,
        @Body body: CreateListRequestDto
    ): CreateListResponseDto

    @POST("list/{listId}/add_item")
    suspend fun addMovieToList(
        @Path("listId") listId: Int,
        @Query("session_id") sessionId: String,
        @Body body: MovieRequestDto
    )

    @POST("list/{listId}/remove_item")
    suspend fun removeMovieFromList(
        @Path("listId") listId: Int,
        @Query("session_id") sessionId: String,
        @Body body: MovieRequestDto
    )

    @GET("list/{listId}")
    suspend fun getListDetails(
        @Path("listId") listId: Int,
        @Query("page") page: Int = 1
    ): ListDetailsResponseDto
}
