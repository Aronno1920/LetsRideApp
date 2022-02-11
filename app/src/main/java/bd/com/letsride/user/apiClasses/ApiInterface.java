package bd.com.letsride.user.apiClasses;

import bd.com.letsride.user.models.requestModels.SaveUserRequest;
import bd.com.letsride.user.models.requestModels.SendOTPRequest;
import bd.com.letsride.user.models.requestModels.VerifyOTPRequest;
import bd.com.letsride.user.models.responseModels.AvailableRouteResponse;
import bd.com.letsride.user.models.responseModels.BalanceResponse;
import bd.com.letsride.user.models.responseModels.DepositConfigResponse;
import bd.com.letsride.user.models.responseModels.SaveUserPesponse;
import bd.com.letsride.user.models.responseModels.SendOTPResponse;
import bd.com.letsride.user.models.responseModels.UserProfileResponse;
import bd.com.letsride.user.models.responseModels.VerifyOTPResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("Auth/SendOTP")
    Call<SendOTPResponse> requestSendOTPCode(@Body SendOTPRequest model);

    @POST("Auth/VerifyOTP")
    Call<VerifyOTPResponse> requestVerifyOTP(@Body VerifyOTPRequest model);



    @POST("Auth/SaveUser")
    Call<SaveUserPesponse> requestSaveUserProfile(@Body SaveUserRequest model);

    @GET("Auth/GetUserByName")
    Call<UserProfileResponse> requestGetUserByName(
            @Header("Authorization") String token,
            @Query("ownerType") String ownerType,
            @Query("userName") String userName
    );

    @GET("Wallet/GetBalance")
    Call<BalanceResponse> requestGetBalance(
            @Header("Authorization") String token,
            @Query("ownerType") String ownerType,
            @Query("userName") String userName
    );



    @GET("Route/GetAvailableRoutes")
    Call<AvailableRouteResponse> requestAllAvailableRoutes(
            @Header("Authorization") String token
    );



    @GET("Wallet/GetDepositConfig")
    Call<DepositConfigResponse> requestAllDepositConfig(
            @Header("Authorization") String token
    );
}