package bd.com.letsride.user.apiClasses;

import bd.com.letsride.user.apiModels.ResponseStatus;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import bd.com.letsride.user.apiModels.SendOTPRequest;
import bd.com.letsride.user.apiModels.VerificationResponse;

public interface ApiInterface {

    @POST("Auth/SendOTP")
    Call<ResponseStatus> requestVerificatinCode(@Body SendOTPRequest model);

//          -----------------
//          "source": "string",
//          "tacFor": "string",
//          "countryCode": "string",
//          "mobileNumber": "string",
//          "prefix": "string",
//          "tac": "string"


//    @GET("user/GetAllActionPlan")
//    Call<List<ActionPlanModel>> GetAllActionPlanList();
//
//    @GET("user/GetAllProduct")
//    Call<List<ProductModel>> GetAllProductList();
//
//    @GET("user/GetAllTerminology")
//    Call<List<TerminologyModel>> GetAllTerminology();
//
//    @GET("user/GetAllActionDetails")
//    Call<List<ActionDetailsModel>> GetAllActionDetailsList();
}