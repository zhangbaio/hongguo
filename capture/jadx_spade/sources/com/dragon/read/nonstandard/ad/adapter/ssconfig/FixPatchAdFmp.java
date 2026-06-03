package com.dragon.read.nonstandard.ad.adapter.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FixPatchAdFmp {
    public static final a a;
    private static final FixPatchAdFmp b;

    @SerializedName("enable")
    public final boolean enable;

    public FixPatchAdFmp() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(612481);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FixPatchAdFmp a() {
            Object aBValue = SsConfigMgr.getABValue("fix_patch_ad_fmp_v701", FixPatchAdFmp.b);
            Intrinsics.checkNotNullExpressionValue(aBValue, "getABValue(...)");
            return (FixPatchAdFmp) aBValue;
        }
    }

    static {
        Covode.recordClassIndex(612480);
        DefaultConstructorMarker defaultConstructorMarker = null;
        a = new a(defaultConstructorMarker);
        SsConfigMgr.prepareAB("fix_patch_ad_fmp_v701", FixPatchAdFmp.class, IFixPatchAdFmp.class);
        b = new FixPatchAdFmp(false, 1, defaultConstructorMarker);
    }

    public FixPatchAdFmp(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ FixPatchAdFmp(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
