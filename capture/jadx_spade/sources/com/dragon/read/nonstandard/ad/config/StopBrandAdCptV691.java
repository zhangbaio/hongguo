package com.dragon.read.nonstandard.ad.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StopBrandAdCptV691 {
    public static final a a;
    private static final StopBrandAdCptV691 b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("interval")
    public final int interval;

    @SerializedName("max_lynxview_cache_count")
    public final int maxLynxviewCacheCount;

    @SerializedName("show_time_daily")
    public final int showTimeDaily;

    public StopBrandAdCptV691() {
        this(false, 0, 0, 0, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(612495);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StopBrandAdCptV691 a() {
            Object aBValue = SsConfigMgr.getABValue("stop_brand_ad_cpt_v691", StopBrandAdCptV691.b);
            Intrinsics.checkNotNullExpressionValue(aBValue, "getABValue(...)");
            return (StopBrandAdCptV691) aBValue;
        }
    }

    static {
        Covode.recordClassIndex(612494);
        a = new a(null);
        SsConfigMgr.prepareAB("stop_brand_ad_cpt_v691", StopBrandAdCptV691.class, IStopBrandAdCptV691.class);
        b = new StopBrandAdCptV691(false, 0, 0, 0, 15, null);
    }

    public StopBrandAdCptV691(boolean z, int i, int i2, int i3) {
        this.enable = z;
        this.showTimeDaily = i;
        this.interval = i2;
        this.maxLynxviewCacheCount = i3;
    }

    public /* synthetic */ StopBrandAdCptV691(boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 10 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
