package hs4;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(612336);
    }

    public static final a a(String bizTag, int i, int i2, String str, String str2, int i3, int i4, Map<String, Object> extra) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(bizTag, "bizTag");
        Intrinsics.checkNotNullParameter(extra, "extra");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : extra.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Serializable) {
                serializable = (Serializable) value;
            } else {
                serializable = null;
            }
            if (serializable != null) {
                linkedHashMap.put(entry.getKey(), serializable);
            }
        }
        return new a(bizTag, i, i2, str, str2, i3, i4, null, linkedHashMap);
    }

    public static /* synthetic */ a b(String str, int i, int i2, String str2, String str3, int i3, int i4, Map map, int i5, Object obj) {
        int i6;
        String str4;
        int i7;
        if ((i5 & 2) != 0) {
            i = -1;
        }
        int i8 = 0;
        if ((i5 & 4) != 0) {
            i6 = 0;
        } else {
            i6 = i2;
        }
        String str5 = null;
        if ((i5 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i5 & 16) == 0) {
            str5 = str3;
        }
        if ((i5 & 32) == 0) {
            i8 = i3;
        }
        if ((i5 & 64) != 0) {
            i7 = 1;
        } else {
            i7 = i4;
        }
        if ((i5 & 128) != 0) {
            map = new LinkedHashMap();
        }
        return a(str, i, i6, str4, str5, i8, i7, map);
    }
}
