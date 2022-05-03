package com.rubenarriazu.paranoid.api;

import com.rubenarriazu.paranoid.api.requests.*;
import com.rubenarriazu.paranoid.api.responses.*;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Endpoints {

    @POST("account/registration/")
    Call<ResponseBody> registration(@Body RegistrationRequest registrationRequest);

    @POST("account/login/")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("account/account/")
    Call<List<AccountResponse>> getAccounts(@Header("Authorization") String token);

    @GET("account/account/{user_pk}/")
    Call<AccountResponse> getAccount(@Header("Authorization") String token,
                                     @Path("user_pk") int userPK);

    @GET("account/user/")
    Call<UserResponse> getUser(@Header("Authorization") String token);

    @GET("account/user/{user_pk}/")
    Call<UserResponse> getUser(@Header("Authorization") String token,
                               @Path("user_pk") int userPK);

    @POST("account/search/")
    Call<List<UserResponse>> searchUser(@Header("Authorization") String token,
                                        @Body SearchUserRequest searchUserRequest);

    @POST("account/petition/send/")
    Call<PetitionResponse> sendPetition(@Header("Authorization") String token,
                                        @Body SendPetitionRequest sendPetitionRequest);

    @POST("account/petition/accept/")
    Call<PetitionResponse> acceptPetition(@Header("Authorization") String token,
                                          @Body AcceptPetitionRequest acceptPetitionRequest);

    @DELETE("account/petition/{petition_pk}/")
    Call<PetitionResponse> discardPetition(@Header("Authorization") String token,
                                           @Path("petition_pk") int petitionPK);

    @GET("account/petition/{petition_pk}/")
    Call<PetitionResponse> getPetition(@Header("Authorization") String token,
                                       @Path("petition_pk") int petitionPK);

    @GET("account/petition/")
    Call<List<PetitionResponse>> getPetitions(@Header("Authorization") String token);

}