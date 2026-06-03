package ck4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.di0;
import com.bytedance.kmp.reading.model.x7;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends gn4.c {
    public static final int q;
    public final di0 n;
    public final boolean o;
    public final boolean p;

    static {
        Covode.recordClassIndex(607766);
        q = 8;
    }

    public String a(int i) {
        return String.valueOf(f());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(di0 ugcPostData, x7 cellViewData, boolean z, boolean z2) {
        super(cellViewData);
        Intrinsics.checkNotNullParameter(ugcPostData, "ugcPostData");
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        this.n = ugcPostData;
        this.o = z;
        this.p = z2;
    }
}
