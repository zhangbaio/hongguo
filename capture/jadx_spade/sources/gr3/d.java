package gr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.feed.LandingCacheType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(598739);
    }

    public static final boolean a(LandingCacheType landingCacheType) {
        Intrinsics.checkNotNullParameter(landingCacheType, "<this>");
        if (landingCacheType == LandingCacheType.AD) {
            return true;
        }
        return false;
    }

    public static final boolean b(LandingCacheType landingCacheType) {
        Intrinsics.checkNotNullParameter(landingCacheType, "<this>");
        if (landingCacheType != LandingCacheType.None) {
            return true;
        }
        return false;
    }

    public static final boolean c(LandingCacheType landingCacheType) {
        Intrinsics.checkNotNullParameter(landingCacheType, "<this>");
        if (landingCacheType != LandingCacheType.Video && landingCacheType != LandingCacheType.AD) {
            return false;
        }
        return true;
    }
}
