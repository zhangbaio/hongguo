package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.FeedPlayerOptConfigV711;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FeedPlayerOptConfigV711 {
    public static final a a;
    private static final Lazy<FeedPlayerOptConfigV711> b;

    @SerializedName("destroy")
    public final boolean destroy;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("fixTab")
    public final boolean fixTab;

    @SerializedName("report")
    public final boolean report;

    public FeedPlayerOptConfigV711() {
        this(false, false, false, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598225);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedPlayerOptConfigV711 a() {
            return (FeedPlayerOptConfigV711) FeedPlayerOptConfigV711.b.getValue();
        }
    }

    static {
        Lazy<FeedPlayerOptConfigV711> lazy;
        Covode.recordClassIndex(598224);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FeedPlayerOptConfigV711 c;
                c = FeedPlayerOptConfigV711.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedPlayerOptConfigV711 c() {
        return (FeedPlayerOptConfigV711) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "video_feed_player_opt_v711", new FeedPlayerOptConfigV711(false, false, false, false, 15, null), false, 4, null);
    }

    public FeedPlayerOptConfigV711(boolean z, boolean z2, boolean z3, boolean z4) {
        this.enable = z;
        this.report = z2;
        this.destroy = z3;
        this.fixTab = z4;
    }

    public /* synthetic */ FeedPlayerOptConfigV711(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? true : z4);
    }
}
