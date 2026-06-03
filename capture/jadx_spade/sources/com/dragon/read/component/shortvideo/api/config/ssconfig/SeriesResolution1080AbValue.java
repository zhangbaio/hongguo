package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesResolution1080AbValue {
    public static final a a;
    private static final Lazy<SeriesResolution1080AbValue> b;

    @SerializedName("digg_strategy")
    public final boolean diggStrategy;

    @SerializedName("enable_server")
    public final boolean enableServer;

    @SerializedName("preload_size_1080")
    public final long preloadSize1080;

    public SeriesResolution1080AbValue() {
        this(false, false, 0L, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598494);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesResolution1080AbValue a() {
            return (SeriesResolution1080AbValue) SeriesResolution1080AbValue.b.getValue();
        }
    }

    static {
        Lazy<SeriesResolution1080AbValue> lazy;
        Covode.recordClassIndex(598493);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.r1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesResolution1080AbValue c;
                c = SeriesResolution1080AbValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesResolution1080AbValue c() {
        return (SeriesResolution1080AbValue) qq3.a.a("video_play_resolution_strategy_1080_v671", new SeriesResolution1080AbValue(false, false, 0L, 7, null), true);
    }

    public SeriesResolution1080AbValue(boolean z, boolean z2, long j) {
        this.enableServer = z;
        this.diggStrategy = z2;
        this.preloadSize1080 = j;
    }

    public /* synthetic */ SeriesResolution1080AbValue(boolean z, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS : j);
    }
}
