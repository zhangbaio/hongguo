package com.dragon.read.nonstandard.ad.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoEnablePatchAds {
    public static final a a;
    private static final VideoEnablePatchAds b;

    @SerializedName("enable")
    public final boolean enable;

    public VideoEnablePatchAds() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(612498);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoEnablePatchAds a() {
            Object aBValue = SsConfigMgr.getABValue("video_enable_patch_ads_v647", VideoEnablePatchAds.b);
            Intrinsics.checkNotNullExpressionValue(aBValue, "getABValue(...)");
            return (VideoEnablePatchAds) aBValue;
        }
    }

    static {
        Covode.recordClassIndex(612497);
        DefaultConstructorMarker defaultConstructorMarker = null;
        a = new a(defaultConstructorMarker);
        SsConfigMgr.prepareAB("video_enable_patch_ads_v647", VideoEnablePatchAds.class, IVideoEnablePatchAds.class);
        b = new VideoEnablePatchAds(false, 1, defaultConstructorMarker);
    }

    public VideoEnablePatchAds(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoEnablePatchAds(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
