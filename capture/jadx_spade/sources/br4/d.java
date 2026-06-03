package br4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int c;
    public final List<f> a;
    public final String b;

    static {
        Covode.recordClassIndex(611447);
        c = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends f> resultList, String str) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        this.a = resultList;
        this.b = str;
    }
}
