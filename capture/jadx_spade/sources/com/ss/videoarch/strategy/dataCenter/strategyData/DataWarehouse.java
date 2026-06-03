package com.ss.videoarch.strategy.dataCenter.strategyData;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DataWarehouse {
    private static SharedPreferences sharedPreferences;
    private Context mContext = null;

    static {
        Covode.recordClassIndex(653124);
    }

    public native String nativeGetDataFromeDisk(String str);

    private static class a {
        private static final DataWarehouse a;

        static {
            Covode.recordClassIndex(653125);
            a = new DataWarehouse();
        }
    }

    public static DataWarehouse getInstance() {
        return a.a;
    }

    public static String getOfflineFeatures() {
        return a.a.nativeGetDataFromeDisk("CategoriesTable");
    }

    public static void init(Context context) {
        Log.d("DataWarehouse", "init");
        getInstance().mContext = context;
    }

    public String ReadFromDB(String str, String str2) {
        Context context = this.mContext;
        if (context == null) {
            Log.d("DataWarehouse", "mContext == null");
            return "";
        }
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(str, 0);
        }
        String string = sharedPreferences.getString(str2, "");
        Log.d("DataWarehouse", "ReadFromDB: table:" + str + ", key:" + str2 + ", value len:" + string.length());
        return string;
    }

    public void WriteToDB(String str, String str2, String str3) {
        Context context = this.mContext;
        if (context == null) {
            Log.d("DataWarehouse", "mContext == null");
            return;
        }
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(str, 0);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str2, str3);
        edit.apply();
        Log.d("DataWarehouse", "WriteToDB: table:" + str + ", key:" + str2 + ", value len:" + str3.length());
    }
}
