package com.tencent.open.b;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g {
    static {
        Covode.recordClassIndex(653519);
    }

    public static void a(String str) {
    }

    public static void a(String str, List<Serializable> list) {
    }

    static void a() {
        Context a = com.tencent.open.utils.g.a();
        if (a == null) {
            return;
        }
        a.deleteDatabase("sdk_report.db");
    }

    public static List<Serializable> b(String str) {
        return Collections.synchronizedList(new ArrayList());
    }
}
