package bd.com.letsride.user.apiClasses;

//import android.util.Log;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class ApiClient {
//
//    public static final String BASE_URL = "http://61.247.183.66:8007/";
//    public static String PROFILE_IMAGE_URL = "http://61.247.183.69:8026";
//
//    private static Retrofit retrofit = null;
//    private static OkHttpClient okHttpClient;
//
//    private ApiClient() {
//    }
//
//    private static Gson gson = new GsonBuilder()
//            .setLenient()
//            .create();
//
//    public static Retrofit getClient() {
//        if (okHttpClient == null) {
//            initOkHttpClient();
//        }
//
//        if (retrofit == null) {
//            synchronized (ApiClient.class) {
//                if (retrofit == null) {
//                    retrofit = new Retrofit.Builder()
//                            .baseUrl(BASE_URL)
//                            .addConverterFactory(GsonConverterFactory.create(gson))
//                            .client(okHttpClient)
//                            .build();
//                }
//            }
//        }
//        return retrofit;
//    }
//
//    private static void initOkHttpClient() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Log.e("NETWORKRESPONSE", message);
//            }
//        });
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
//    }
//}
