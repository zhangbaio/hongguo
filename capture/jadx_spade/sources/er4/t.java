package er4;

import com.bytedance.covode.number.Covode;
import com.tencent.mmkv.MMKV;
import java.util.concurrent.FutureTask;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t extends e0 {
    public static final int f;
    public FutureTask<Pair<MMKV, Long>> e;

    static {
        Covode.recordClassIndex(611472);
        f = 8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(FutureTask<Pair<MMKV, Long>> mFuture, MMKV mmkv, long j, boolean z) {
        super(mmkv, j, z);
        Intrinsics.checkNotNullParameter(mFuture, "mFuture");
        this.e = mFuture;
        d0.b.k().execute(this.e);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ t(java.util.concurrent.FutureTask r7, com.tencent.mmkv.MMKV r8, long r9, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L6
            r9 = 0
        L6:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto Le
            r11 = 0
            r5 = 0
            goto Lf
        Le:
            r5 = r11
        Lf:
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: er4.t.<init>(java.util.concurrent.FutureTask, com.tencent.mmkv.MMKV, long, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
