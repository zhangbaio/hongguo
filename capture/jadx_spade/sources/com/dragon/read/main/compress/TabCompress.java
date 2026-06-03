package com.dragon.read.main.compress;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class TabCompress {
    public static final a a;
    private static final TabCompress b;

    @SerializedName("enable")
    public final boolean enable;

    public TabCompress() {
        this(false, 1, null);
    }

    public static final TabCompress b() {
        return a.a();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611954);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TabCompress a() {
            Object aBValue = SsConfigMgr.getABValue("tab_compress_673", TabCompress.b);
            Intrinsics.checkNotNullExpressionValue(aBValue, "getABValue(...)");
            return (TabCompress) aBValue;
        }
    }

    static {
        Covode.recordClassIndex(611953);
        DefaultConstructorMarker defaultConstructorMarker = null;
        a = new a(defaultConstructorMarker);
        SsConfigMgr.prepareAB("tab_compress_673", TabCompress.class, ITabCompress.class);
        b = new TabCompress(false, 1, defaultConstructorMarker);
    }

    public TabCompress(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ TabCompress(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
