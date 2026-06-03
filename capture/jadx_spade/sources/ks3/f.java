package ks3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.AutoPlayStyle;
import com.dragon.read.rpc.model.PlayStrategyType;
import com.dragon.read.rpc.model.StartPlayStrategy;
import com.dragon.read.rpc.model.VideoContentType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f implements s64.a {
    public static final int j;
    public String a;
    public final String b;
    public final VideoContentType c;
    public int d;
    public final int e;
    public final PlayStrategyType f;
    public final int g;
    public final AutoPlayStyle h;
    public final StartPlayStrategy i;

    static {
        Covode.recordClassIndex(598950);
        j = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public f(String vid, String seriesId, VideoContentType contentType, int i, int i2, PlayStrategyType playStrategyType, int i3, AutoPlayStyle autoPlayStyle, StartPlayStrategy startPlayStrategy) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(playStrategyType, "playStrategyType");
        Intrinsics.checkNotNullParameter(autoPlayStyle, "autoPlayStyle");
        Intrinsics.checkNotNullParameter(startPlayStrategy, "startPlayStrategy");
        this.a = vid;
        this.b = seriesId;
        this.c = contentType;
        this.d = i;
        this.e = i2;
        this.f = playStrategyType;
        this.g = i3;
        this.h = autoPlayStyle;
        this.i = startPlayStrategy;
    }
}
