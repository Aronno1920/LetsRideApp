package bd.com.letsride.user.apiClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbOrionPMD";


    //region Table Name
    private static final String TABLE_PRODUCT = "tblProducts";
    private static final String TABLE_TERMINOLOGY = "tblTerminology";
    private static final String TABLE_ACTIONPLAN = "tblActionPlan";
    private static final String TABLE_ACTIONDETAILS = "tblActionDetails";
    //endregion

    //region Product Table Columns names
    private static final String KEY_PRODUCT_ID = "id";
    private static final String KEY_PRODUCT_NAME = "name";
    private static final String KEY_PRODUCT_BRAND = "brand";
    private static final String KEY_PRODUCT_VERSION = "version";
    //endregion

    //region Terminology Table Columns names
    private static final String KEY_TERMINOLOGY_ID = "id";
    private static final String KEY_TERMINOLOGY_PLANID = "termid";
    private static final String KEY_TERMINOLOGY_NAME = "terminology";
    private static final String KEY_TERMINOLOGY_DESCRIPTION = "description";
    private static final String KEY_TERMINOLOGY_VERSION = "version";
    //endregion

    //region ActionPlan Table Columns names
    private int planID;
    private static final String KEY_PLAN_ID = "id";
    private static final String KEY_PLAN_NAME = "actionplanname";
    private static final String KEY_PLAN_FROMDATE = "fromdate";
    private static final String KEY_PLAN_TODATE = "todate";
    //endregion

    //region ActionPlanDetails Table Columns names
    private static final String KEY_DETAILS_ID = "id";
    private static final String KEY_DETAILS_PLAN_ID = "planid";
    private static final String KEY_DETAILS_NAME = "productname";
    private static final String KEY_DETAILS_PRODUCTLOGO = "productlogo";
    private static final String KEY_DETAILS_DESCRIPTION = "description";
    private static final String KEY_DETAILS_IMAGE_DESCRIPTION = "imagedescription";
    private static final String KEY_DETAILS_IMAGE1 = "image1";
    private static final String KEY_DETAILS_IMAGE2 = "image2";
    private static final String KEY_DETAILS_IMAGE3 = "image3";
    private static final String KEY_DETAILS_IMAGE4 = "image4";
    //endregion

//    //region ProductModel Related CRUD Methods
//    public void AddProduct(ProductModel product) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_PRODUCT_ID, product.getProductID());
//        values.put(KEY_PRODUCT_NAME, product.getProductName());
//
//        if (product.getBrand() == null) {
//            values.put(KEY_PRODUCT_BRAND, "");
//        } else {
//            values.put(KEY_PRODUCT_BRAND, product.getBrand().toString());
//        }
//
//        if (product.getVersion() == null) {
//            values.put(KEY_PRODUCT_VERSION, "");
//        } else {
//            values.put(KEY_PRODUCT_VERSION, product.getVersion().toString());
//        }
//
//        db.insert(TABLE_PRODUCT, null, values);
//        db.close();
//    }
//
//    public ProductModel getProduct(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_PRODUCT, new String[]{KEY_PRODUCT_ID, KEY_PRODUCT_NAME, KEY_PRODUCT_BRAND, KEY_PRODUCT_VERSION}, KEY_PRODUCT_ID + "=?",
//                new String[]{String.valueOf(id)}, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        ProductModel product = new ProductModel();
//        product.setProductID(cursor.getInt(0));
//        product.setProductName(cursor.getString(1));
//        product.setBrand(cursor.getString(2));
//        product.setVersion(cursor.getInt(3));
//        cursor.close();
//
//        return product;
//    }
//
//    public List<ProductModel> getAllProucts() {
//        List<ProductModel> productList = new ArrayList<ProductModel>();
//        String selectQuery = "SELECT * FROM " + TABLE_PRODUCT;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                ProductModel product = new ProductModel();
//                product.setProductID(cursor.getInt(0));
//                product.setProductName(cursor.getString(1));
//                product.setBrand(cursor.getString(2));
//                product.setVersion(cursor.getInt(3));
//
//                productList.add(product);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return productList;
//    }
//
//    public List<ProductModel> getBrandSpecification() {
//        List<ProductModel> productList = new ArrayList<ProductModel>();
//        String selectQuery = "SELECT * FROM " + TABLE_PRODUCT + " WHERE " + KEY_PRODUCT_BRAND + " IS NOT NULL";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                String brandInfo = cursor.getString(2);
//                if (brandInfo.length() > 1) {
//                    ProductModel product = new ProductModel();
//                    product.setProductID(cursor.getInt(0));
//                    product.setProductName(cursor.getString(1));
//                    product.setBrand(cursor.getString(2));
//                    product.setVersion(cursor.getInt(3));
//
//                    productList.add(product);
//                }
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return productList;
//    }
//
//    public int GetProductsCount() {
//        Integer totalProduct = 0;
//        String countQuery = "SELECT  * FROM " + TABLE_PRODUCT;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        totalProduct = cursor.getCount();
//        cursor.close();
//
//        return totalProduct;
//    }
//
//    public void DeleteProduct() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("delete from " + TABLE_PRODUCT);
//        db.close();
//    }
//    //endregion
//
//    //region TerminologModel Related CRUD Methods
//    public void AddTerminology(TerminologyModel terminology) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_TERMINOLOGY_ID, terminology.getTermID());
//        values.put(KEY_TERMINOLOGY_PLANID, terminology.getPromoID());
//        values.put(KEY_TERMINOLOGY_NAME, terminology.getTermName());
//        values.put(KEY_TERMINOLOGY_DESCRIPTION, terminology.getTermDescription());
//        values.put(KEY_TERMINOLOGY_VERSION, terminology.getTermVersion().toString());
//
//        db.insert(TABLE_TERMINOLOGY, null, values);
//        db.close();
//    }
//
//    public List<TerminologyModel> getAllTerminology() {
//        List<TerminologyModel> productList = new ArrayList<TerminologyModel>();
//        String selectQuery = "SELECT * FROM " + TABLE_TERMINOLOGY;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                TerminologyModel product = new TerminologyModel();
//                product.setTermID(cursor.getInt(0));
//                product.setPromoID(cursor.getInt(1));
//                product.setTermName(cursor.getString(2));
//                product.setTermDescription(cursor.getString(3));
//                product.setTermVersion(cursor.getString(4));
//
//                productList.add(product);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return productList;
//    }
//
//    public List<TerminologyModel> getAllTerminologyNew(int planID) {
//        List<TerminologyModel> productList = new ArrayList<TerminologyModel>();
//        String selectQuery = "SELECT * FROM " + TABLE_TERMINOLOGY + " WHERE " + KEY_TERMINOLOGY_PLANID + " ='" + planID + "'";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                TerminologyModel product = new TerminologyModel();
//                product.setTermID(cursor.getInt(0));
//                product.setPromoID(cursor.getInt(1));
//                product.setTermName(cursor.getString(2));
//                product.setTermDescription(cursor.getString(3));
//                product.setTermVersion(cursor.getString(4));
//
//                productList.add(product);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return productList;
//    }
//
//    public int GetTerminologyCount() {
//        Integer totalProduct = 0;
//        String countQuery = "SELECT  * FROM " + TABLE_TERMINOLOGY;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        totalProduct = cursor.getCount();
//        cursor.close();
//
//        return totalProduct;
//    }
//
//    public void DeleteTerminology() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("delete from " + TABLE_TERMINOLOGY);
//        db.close();
//    }
//    //endregion
//
//    //region ActionPlan Related CRUD Methods
//    public void AddActionPlan(ActionPlanModel planModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_PLAN_ID, planModel.getPromoID());
//        values.put(KEY_PLAN_NAME, planModel.getPromoName());
//        values.put(KEY_PLAN_FROMDATE, planModel.getFromDate());
//        values.put(KEY_PLAN_TODATE, planModel.getToDate());
//
//        db.insert(TABLE_ACTIONPLAN, null, values);
//        db.close();
//    }
//
//    public List<ActionPlanModel> getAllActionPlan() {
//        List<ActionPlanModel> planList = new ArrayList<ActionPlanModel>();
//        String selectQuery = "SELECT * FROM " + TABLE_ACTIONPLAN;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                ActionPlanModel plan = new ActionPlanModel();
//                plan.setPromoID(cursor.getInt(0));
//                plan.setPromoName(cursor.getString(2));
//                plan.setFromDate(cursor.getString(3));
//                plan.setToDate(cursor.getString(4));
//
//                planList.add(plan);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return planList;
//    }
//
//    public List<String> getAllActionPlanName() {
//        List<String> planList = new ArrayList<String>();
//        String selectQuery = "SELECT " + KEY_PLAN_NAME + " FROM " + TABLE_ACTIONPLAN + " ORDER BY " + KEY_PLAN_ID + " DESC";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                planList.add(cursor.getString(0));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return planList;
//    }
//
//    public int getActionPlanIDByName(String sPlanName) {
//        String selectQuery = "SELECT " + KEY_PLAN_ID + " FROM " + TABLE_ACTIONPLAN + " WHERE " + KEY_PLAN_NAME + " LIKE '%" + sPlanName + "%'";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.getCount() >= 0) {
//            cursor.moveToFirst();
//            planID = cursor.getInt(0);
//        }
//        cursor.close();
//        return planID;
//    }
//
//    public int GetActionPlanCount() {
//        Integer totalProduct = 0;
//        String countQuery = "SELECT  * FROM " + TABLE_ACTIONPLAN;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        totalProduct = cursor.getCount();
//        cursor.close();
//
//        return totalProduct;
//    }
//
//    public void DeleteActionPlan() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("delete from " + TABLE_ACTIONPLAN);
//        db.close();
//    }
//    //endregion
//
//    //region ActionDetails Related CRUD Methods
//    public void AddActionDetails(ActionDetailsModel planModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_DETAILS_ID, planModel.getActionID());
//        values.put(KEY_DETAILS_PLAN_ID, planModel.getPromoID());
//        values.put(KEY_DETAILS_NAME, planModel.getProductName());
//        values.put(KEY_DETAILS_PRODUCTLOGO, planModel.getProductLogo());
//        if (planModel.getDescription() != null) {
//            values.put(KEY_DETAILS_DESCRIPTION, planModel.getDescription().toString());
//        }
//        values.put(KEY_DETAILS_IMAGE_DESCRIPTION, planModel.getImageDescription());
//        values.put(KEY_DETAILS_IMAGE1, planModel.getImagePath1());
//        values.put(KEY_DETAILS_IMAGE2, planModel.getImagePath2());
//        if (planModel.getImagePath3() != null) {
//            values.put(KEY_DETAILS_IMAGE3, planModel.getImagePath3().toString());
//        }
//        if (planModel.getImagePath4() != null) {
//            values.put(KEY_DETAILS_IMAGE4, planModel.getImagePath4().toString());
//        }
//
//        db.insert(TABLE_ACTIONDETAILS, null, values);
//        db.close();
//    }
//
//    public List<ActionDetailsModel> getAllActionDetails(int planId) {
//        List<ActionDetailsModel> planList = new ArrayList<ActionDetailsModel>();
//        String selectQuery = "SELECT * FROM " + TABLE_ACTIONDETAILS + " WHERE " + KEY_DETAILS_PLAN_ID + " ='" + planId + "'";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                ActionDetailsModel plan = new ActionDetailsModel();
//                plan.setActionID(cursor.getInt(0));
//                plan.setPromoID(cursor.getInt(1));
//                plan.setProductName(cursor.getString(2));
//                plan.setProductLogo(cursor.getString(3));
//                plan.setDescription(cursor.getString(4));
//                plan.setImageDescription(cursor.getString(5));
//                plan.setImagePath1(cursor.getString(6));
//                plan.setImagePath2(cursor.getString(7));
//                plan.setImagePath3(cursor.getString(8));
//                plan.setImagePath4(cursor.getString(9));
//                planList.add(plan);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return planList;
//    }
//
//    public ActionDetailsModel GetActionDetailsByID(String actionID) {
//        ActionDetailsModel plan = new ActionDetailsModel();
//        String selectQuery = "SELECT * FROM " + TABLE_ACTIONDETAILS + " WHERE " + KEY_DETAILS_ID + "=" + actionID;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                plan.setActionID(cursor.getInt(0));
//                plan.setPromoID(cursor.getInt(1));
//                plan.setProductName(cursor.getString(2));
//                plan.setProductLogo(cursor.getString(3));
//                plan.setDescription(cursor.getString(4));
//                plan.setImageDescription(cursor.getString(5));
//                plan.setImagePath1(cursor.getString(6));
//                plan.setImagePath2(cursor.getString(7));
//                plan.setImagePath3(cursor.getString(8));
//                plan.setImagePath4(cursor.getString(9));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return plan;
//    }
//
//    public int GetActionDetailsCount() {
//        Integer totalProduct = 0;
//        String countQuery = "SELECT  * FROM " + TABLE_ACTIONDETAILS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        totalProduct = cursor.getCount();
//        cursor.close();
//
//        return totalProduct;
//    }
//
//    public void DeleteActionDetails() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("delete from " + TABLE_ACTIONDETAILS);
//        db.close();
//    }
//    //endregion

    //region Database Creation and Upgradation
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("SQLLite", DATABASE_NAME + " Database crated with version " + DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
                + KEY_PRODUCT_ID + " INTEGER," + KEY_PRODUCT_NAME + " TEXT,"
                + KEY_PRODUCT_BRAND + " TEXT," + KEY_PRODUCT_VERSION + " INTEGER)";
        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.e("SQLLite", "ProductTable" + CREATE_CONTACTS_TABLE);

        String CREATE_TERMINOLOGY_TABLE = "CREATE TABLE " + TABLE_TERMINOLOGY + "("
                + KEY_TERMINOLOGY_ID + " INTEGER," + KEY_TERMINOLOGY_PLANID + " INTEGER," + KEY_TERMINOLOGY_NAME + " TEXT,"
                + KEY_TERMINOLOGY_DESCRIPTION + " TEXT," + KEY_TERMINOLOGY_VERSION + " INTEGER)";
        db.execSQL(CREATE_TERMINOLOGY_TABLE);
        Log.e("SQLLite", "TerminologyTable" + CREATE_TERMINOLOGY_TABLE);

        String CREATE_ACTIONPLAN_TABLE = "CREATE TABLE " + TABLE_ACTIONPLAN + "("
                + KEY_PLAN_ID + " INTEGER," + KEY_PLAN_NAME + " TEXT,"
                + KEY_PLAN_FROMDATE + " TEXT," + KEY_PLAN_TODATE + " TEXT)";
        db.execSQL(CREATE_ACTIONPLAN_TABLE);
        Log.e("SQLLite", "ActionPlanTable" + CREATE_ACTIONPLAN_TABLE);

        String CREATE_ACTIONDETAILS_TABLE = "CREATE TABLE " + TABLE_ACTIONDETAILS + "("
                + KEY_DETAILS_ID + " INTEGER," + KEY_DETAILS_PLAN_ID + " INTEGER," + KEY_DETAILS_NAME + " TEXT," + KEY_DETAILS_PRODUCTLOGO + " TEXT," + KEY_DETAILS_DESCRIPTION + " TEXT,"
                + KEY_DETAILS_IMAGE_DESCRIPTION + " TEXT," + KEY_DETAILS_IMAGE1 + " TEXT," + KEY_DETAILS_IMAGE2 + " TEXT," + KEY_DETAILS_IMAGE3 + " TEXT," + KEY_DETAILS_IMAGE4 + " TEXT)";
        db.execSQL(CREATE_ACTIONDETAILS_TABLE);
        Log.e("SQLLite", "ActionPlanTable" + CREATE_ACTIONDETAILS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TERMINOLOGY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIONPLAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIONDETAILS);

        onCreate(db);
    }

    //endregion
}