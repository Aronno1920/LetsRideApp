package bd.com.letsride.user.apiClasses;

import bd.com.letsride.user.responses.VerificationRequestResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("Auth/VerifyOTP")
    Call<VerificationRequestResponse> requestVerificatinCode(
            @Query("source") String source,
            @Query("tacFor") String tacFor,
            @Query("countryCode") String countryCode,
            @Query("mobileNumber") String mobileNumber
    );

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