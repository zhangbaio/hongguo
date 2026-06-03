package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f {
    private String a;
    private String b;

    static {
        Covode.recordClassIndex(653558);
    }

    private static class a {
        private static f a;

        static {
            Covode.recordClassIndex(653559);
            a = new f();
        }
    }

    public String b() {
        return this.b;
    }

    public static f a() {
        return a.a;
    }

    private f() {
        this.a = "";
        this.b = "";
    }

    public String c(Context context) {
        return this.b;
    }

    public String b(Context context) {
        return this.a;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 0);
        String str = this.b;
        if (str == null || str.trim().isEmpty()) {
            this.b = sharedPreferences.getString("build_model", "");
        }
        String str2 = this.a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.a = sharedPreferences.getString("build_device", "");
        }
    }

    public void a(Context context, String str) {
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.b;
            if (str2 != null && str2.equals(str)) {
                return;
            }
            this.b = str;
            if (context != null) {
                context.getSharedPreferences("device_info_file", 0).edit().putString("build_model", this.b).apply();
                return;
            }
            return;
        }
        this.b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 0).edit().remove("build_model").apply();
        }
    }
}
