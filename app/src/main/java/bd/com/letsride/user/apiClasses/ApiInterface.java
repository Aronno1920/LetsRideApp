package bd.com.letsride.user.apiClasses;

import java.util.List;

import bd.com.letsride.user.apiResponseModels.DepositConfigResponse;
import bd.com.letsride.user.apiResponseModels.SendOTPResponse;
import bd.com.letsride.user.apiRequestModels.VerifyOTPRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import bd.com.letsride.user.apiRequestModels.SendOTPRequest;

public interface ApiInterface {

    @POST("Auth/SendOTP")
    Call<SendOTPResponse> requestVerificatinCode(@Body SendOTPRequest model);

    @POST("Auth/VerifyOTP")
    Call<SendOTPResponse> requestVerificatinSuccess(@Body VerifyOTPRequest model);

    @GET("Wallet/GetDepositConfig")
    Call<DepositConfigResponse> GetDepositConfig();


//    @GET("user/GetAllProduct")
//    Call<List<ProductModel>> GetAllProductList();
//
//    @GET("user/GetAllTerminology")
//    Call<List<TerminologyModel>> GetAllTerminology();
//
//    @GET("user/GetAllActionDetails")
//    Call<List<ActionDetailsModel>> GetAllActionDetailsList();
}