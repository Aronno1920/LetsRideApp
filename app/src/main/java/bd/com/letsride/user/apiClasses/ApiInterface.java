package bd.com.letsride.user.apiClasses;

import bd.com.letsride.user.apiModels.ResponseOfRequest;
import bd.com.letsride.user.apiModels.VerificationRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import bd.com.letsride.user.apiModels.SendOTPRequest;

public interface ApiInterface {

    @POST("Auth/SendOTP")
    Call<ResponseOfRequest> requestVerificatinCode(@Body SendOTPRequest model);

    @POST("Auth/VerifyOTP")
    Call<ResponseOfRequest> requestVerificatinSuccess(@Body VerificationRequest model);


//    @GET("user/GetAllProduct")
//    Call<List<ProductModel>> GetAllProductList();
//
//    @GET("user/GetAllTerminology")
//    Call<List<TerminologyModel>> GetAllTerminology();
//
//    @GET("user/GetAllActionDetails")
//    Call<List<ActionDetailsModel>> GetAllActionDetailsList();
}