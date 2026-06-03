package kl6;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a {
    public String a;
    public HashMap<String, Object> b;

    static {
        Covode.recordClassIndex(655930);
    }

    public a(String str, HashMap<String, Object> hashMap) {
        this.a = str;
        this.b = hashMap;
    }

    public /* synthetic */ a(String str, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : hashMap);
    }
}
