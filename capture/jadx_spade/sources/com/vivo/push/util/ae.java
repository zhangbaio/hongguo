package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ae implements e {
    private static String a;
    private static String b;
    private SharedPreferences c;

    static {
        Covode.recordClassIndex(655181);
        a = "SpCache";
        b = "com.vivo.push.cache";
    }

    public final void a() {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.clear();
            c.a(edit);
        }
        t.d(a, "system cache is cleared");
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (this.c == null) {
            this.c = context.getSharedPreferences(b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        String string = this.c.getString(str, str2);
        t.d(a, "getString " + str + " is " + string);
        return string;
    }
}
