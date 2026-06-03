package com.dragon.read.local;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SharedPreferencesWrapper {
    public SharedPreferences a;
    private SimpleDateFormat b;

    static {
        Covode.recordClassIndex(611482);
    }

    public static abstract class AbsTimePreferenceModel {

        @SerializedName("expired_days")
        public int expiredDays;

        @SerializedName("save_mills")
        public long saveMills;

        static {
            Covode.recordClassIndex(611483);
        }

        public AbsTimePreferenceModel() {
        }

        public AbsTimePreferenceModel(long j, int i) {
            this.saveMills = j;
            this.expiredDays = i;
        }
    }

    public SharedPreferencesWrapper(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getInstance();
        this.b = simpleDateFormat;
        simpleDateFormat.applyPattern("yyyy-MM-dd");
    }

    public boolean d(AbsTimePreferenceModel absTimePreferenceModel) {
        if (absTimePreferenceModel == null) {
            return true;
        }
        try {
            SimpleDateFormat simpleDateFormat = this.b;
            long time = simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))).getTime();
            SimpleDateFormat simpleDateFormat2 = this.b;
            if ((time - simpleDateFormat2.parse(simpleDateFormat2.format(new Date(absTimePreferenceModel.saveMills))).getTime()) / 86400000 >= absTimePreferenceModel.expiredDays) {
                return true;
            }
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }

    public AbsTimePreferenceModel a(String str, Type type) {
        return b(str, true, type);
    }

    public void e(String str, AbsTimePreferenceModel absTimePreferenceModel) {
        this.a.edit().putString(str, JSONUtils.toJson(absTimePreferenceModel)).apply();
    }

    public AbsTimePreferenceModel b(String str, boolean z, Type type) {
        return c(str, z, type, "");
    }

    public AbsTimePreferenceModel c(String str, boolean z, Type type, String str2) {
        AbsTimePreferenceModel absTimePreferenceModel = (AbsTimePreferenceModel) JSONUtils.fromJson(this.a.getString(str, str2), type);
        if (!z) {
            return absTimePreferenceModel;
        }
        if (absTimePreferenceModel == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = this.b;
            long time = simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))).getTime();
            SimpleDateFormat simpleDateFormat2 = this.b;
            if ((time - simpleDateFormat2.parse(simpleDateFormat2.format(new Date(absTimePreferenceModel.saveMills))).getTime()) / 86400000 >= absTimePreferenceModel.expiredDays) {
                return null;
            }
            return absTimePreferenceModel;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
