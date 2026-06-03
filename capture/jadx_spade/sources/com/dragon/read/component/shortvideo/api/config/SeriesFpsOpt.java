package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.SeriesFpsOpt;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesFpsOpt {
    public static final a a;
    private static final Lazy<SeriesFpsOpt> b;

    @SerializedName("async_interval")
    public final int asyncInterval;

    @SerializedName("enable_async_preload")
    public final boolean enableAsyncPreload;

    @SerializedName("enable_fps_opt")
    public final boolean enableFpsOpt;

    @SerializedName("enable_preload_holder")
    public final boolean enablePreloadHolder;

    public SeriesFpsOpt() {
        this(false, 0, false, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598260);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesFpsOpt b() {
            return (SeriesFpsOpt) SeriesFpsOpt.b.getValue();
        }

        public final void a() {
            qq3.a.b("series_fps_opt_v677", new SeriesFpsOpt(false, 0, false, false, 15, null), true);
        }
    }

    static {
        Lazy<SeriesFpsOpt> lazy;
        Covode.recordClassIndex(598259);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesFpsOpt c;
                c = SeriesFpsOpt.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesFpsOpt c() {
        return (SeriesFpsOpt) qq3.a.b("series_fps_opt_v677", new SeriesFpsOpt(false, 0, false, false, 15, null), false);
    }

    public SeriesFpsOpt(boolean z, int i, boolean z2, boolean z3) {
        this.enableFpsOpt = z;
        this.asyncInterval = i;
        this.enableAsyncPreload = z2;
        this.enablePreloadHolder = z3;
    }

    public /* synthetic */ SeriesFpsOpt(boolean z, int i, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3);
    }
}
