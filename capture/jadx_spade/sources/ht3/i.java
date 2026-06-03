package ht3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.pages.video.model.SeriesPostModel;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final int e;
    public final String a;
    public final SeriesPostModel b;
    public final boolean c;
    public final Map<String, Object> d;

    static {
        Covode.recordClassIndex(599222);
        e = 8;
    }

    public i(String fromScene, SeriesPostModel seriesPostModel, boolean z, Map<String, ? extends Object> extra) {
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        Intrinsics.checkNotNullParameter(seriesPostModel, "seriesPostModel");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.a = fromScene;
        this.b = seriesPostModel;
        this.c = z;
        this.d = extra;
        LogWrapper.info("PostLikeStatusChangeEvent", "construct event: fromScene:" + fromScene + ", title:" + seriesPostModel.getPostTitle() + ", isLike:" + z + ", profileUserId=" + extra.get("profile_user_id") + ", traceEnterFrom=" + extra.get("trace_enter_from"), new Object[0]);
    }

    public /* synthetic */ i(String str, SeriesPostModel seriesPostModel, boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, seriesPostModel, z, (i & 8) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }
}
