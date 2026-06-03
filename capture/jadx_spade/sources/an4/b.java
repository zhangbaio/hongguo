package an4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import readersaas.com.dragon.read.saas.rpc.model.DirectoryItemData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int g;
    public final DirectoryItemData a;
    public String b;
    public String c;
    public String d;
    public Boolean e;
    public Boolean f;

    static {
        Covode.recordClassIndex(608715);
        g = 8;
    }

    public b(DirectoryItemData impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
        this.b = impl.itemId;
        this.c = impl.title;
        this.d = impl.volumeName;
        this.e = Boolean.valueOf(impl.needUnlock);
        this.f = Boolean.valueOf(impl.adForFree);
    }
}
