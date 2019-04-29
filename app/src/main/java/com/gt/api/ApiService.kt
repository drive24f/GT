package com.gt.api

import com.gt.ui.login.model.LoginResponse
import com.gt.ui.message.model.ConversationResponse
import com.gt.ui.room.model.RoomResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST(value = "auth/login")
    fun fetchLogin(
        @Field(value = "username") username: String,
        @Field(value = "password") password: String
    ): Observable<LoginResponse>

    @GET(value = "api/list_conversation?page=1")
    fun fetcConversation(): Observable<ConversationResponse>

    @GET(value = "api/list_user?page=2")
    fun fetcRoom(): Observable<RoomResponse>

    @GET(value = "api/get_history_message?page=1&to_user_id=1")
    fun fetcHistoryMessage(): Observable<LoginResponse>

}