package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.bv;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class br extends bv.d {
    protected String a;

    static {
        Covode.recordClassIndex(655387);
    }

    public static br a(String str) {
        return new br(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }

    public br(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.a = str3;
    }
}
