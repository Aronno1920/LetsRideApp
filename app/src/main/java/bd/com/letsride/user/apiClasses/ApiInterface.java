package bd.com.letsride.user.apiClasses;

import bd.com.letsride.user.models.requestModels.SaveUserRequest;
import bd.com.letsride.user.models.requestModels.SendOTPRequest;
import bd.com.letsride.user.models.requestModels.VerifyOTPRequest;
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
    Call<SendOTPResponse> requestVerificationCode(@Body SendOTPRequest model);

    @POST("Auth/VerifyOTP")
    Call<VerifyOTPResponse> verifyOTPSuccess(@Body VerifyOTPRequest model);

    @POST("Auth/SaveUser")
    Call<SaveUserPesponse> requestUserProfileSave(@Body SaveUserRequest model);


    @GET("Auth/GetUserByName")
    Call<UserProfileResponse> requestUserProfile(
            @Header("Authorization") String token,
            @Query("ownerType") String ownerType,
            @Query("userName") String userName
    );


    @GET("Wallet/GetDepositConfig")
    Call<DepositConfigResponse> requestAllDepositConfig();


}