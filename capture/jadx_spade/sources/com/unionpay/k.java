package com.unionpay;

import com.bytedance.covode.number.Covode;
import java.util.Comparator;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class k implements Comparator {
    String a;

    static {
        Covode.recordClassIndex(654870);
    }

    k(String str) {
        this.a = str;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        long optLong = ((JSONObject) obj).optLong(this.a);
        long optLong2 = ((JSONObject) obj2).optLong(this.a);
        if (optLong < optLong2) {
            return -1;
        }
        return optLong > optLong2 ? 1 : 0;
    }
}
