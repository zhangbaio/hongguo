package er4;

import com.bytedance.covode.number.Covode;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e0 {
    public static final int d;
    public MMKV a;
    public long b;
    public final boolean c;

    static {
        Covode.recordClassIndex(611479);
        d = 8;
    }

    public e0(MMKV mmkv, long j, boolean z) {
        this.a = mmkv;
        this.b = j;
        this.c = z;
    }

    public /* synthetic */ e0(MMKV mmkv, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mmkv, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z);
    }
}
