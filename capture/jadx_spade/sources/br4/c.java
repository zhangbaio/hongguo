package br4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int d;
    public final List<f> a;
    public final String b;
    public final String c;

    static {
        Covode.recordClassIndex(611446);
        d = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends f> resultList, String str, String str2) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        this.a = resultList;
        this.b = str;
        this.c = str2;
    }
}
