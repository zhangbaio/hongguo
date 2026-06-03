package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesEndAdaptToVideoFeedV685 {
    public static final a a;
    private static final Lazy<SeriesEndAdaptToVideoFeedV685> b;

    @SerializedName("count")
    public final int count;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("fix_crash")
    public final boolean fixCrash;

    @SerializedName("only_bring_back")
    public final boolean onlyBringBack;

    public SeriesEndAdaptToVideoFeedV685() {
        this(false, 0, false, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598477);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesEndAdaptToVideoFeedV685 a() {
            return (SeriesEndAdaptToVideoFeedV685) SeriesEndAdaptToVideoFeedV685.b.getValue();
        }
    }

    static {
        Lazy<SeriesEndAdaptToVideoFeedV685> lazy;
        Covode.recordClassIndex(598476);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.l1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesEndAdaptToVideoFeedV685 c;
                c = SeriesEndAdaptToVideoFeedV685.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesEndAdaptToVideoFeedV685 c() {
        return (SeriesEndAdaptToVideoFeedV685) qq3.a.c("series_end_adapt_to_video_feed_v685", new SeriesEndAdaptToVideoFeedV685(false, 0, false, false, 15, null), false, 4, null);
    }

    public SeriesEndAdaptToVideoFeedV685(boolean z, int i, boolean z2, boolean z3) {
        this.enable = z;
        this.count = i;
        this.onlyBringBack = z2;
        this.fixCrash = z3;
    }

    public /* synthetic */ SeriesEndAdaptToVideoFeedV685(boolean z, int i, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? true : z3);
    }
}
