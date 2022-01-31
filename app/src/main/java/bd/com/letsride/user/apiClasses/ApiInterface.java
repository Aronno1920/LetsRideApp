package bd.com.letsride.user.apiClasses;

import bd.com.letsride.user.models.requestModels.SendOTPRequest;
import bd.com.letsride.user.models.requestModels.VerifyOTPRequest;
import bd.com.letsride.user.models.responseModels.DepositConfigResponse;
import bd.com.letsride.user.models.responseModels.SendOTPResponse;
import bd.com.letsride.user.models.responseModels.UserInfoResponse;
import bd.com.letsride.user.models.responseModels.VerifyOTPResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("Auth/SendOTP")
    Call<SendOTPResponse> requestVerificatinCode(@Body SendOTPRequest model);

    @POST("Auth/VerifyOTP")
    Call<VerifyOTPResponse> requestVerificatinSuccess(@Body VerifyOTPRequest model);

    @GET("Wallet/GetDepositConfig")
    Call<DepositConfigResponse> GetDepositConfig();

    @POST("user/Login")
    Call<UserInfoResponse> GetUserInformation(
            @Query("ownerType") String ownerType,
            @Query("userName") String userName
    );
}