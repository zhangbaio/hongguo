package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesResolutionV713 {
    public static final a a;
    private static final Lazy<SeriesResolutionV713> b;

    @SerializedName("enable")
    public final boolean enable;

    public SeriesResolutionV713() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598498);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesResolutionV713 a() {
            return (SeriesResolutionV713) SeriesResolutionV713.b.getValue();
        }
    }

    static {
        Lazy<SeriesResolutionV713> lazy;
        Covode.recordClassIndex(598497);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.t1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesResolutionV713 c;
                c = SeriesResolutionV713.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesResolutionV713 c() {
        return (SeriesResolutionV713) ISeriesAbValueApi.Companion.c().getABValue2("short_video_resolution_v713", new SeriesResolutionV713(false, 1, null), true);
    }

    public SeriesResolutionV713(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ SeriesResolutionV713(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
