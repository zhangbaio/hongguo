package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.shortvideo.api.config.SeriesViewRecycleOptV693;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesViewRecycleOptV693 {
    public static final a a;
    private static final Lazy<SeriesViewRecycleOptV693> b;

    @SerializedName("enable_fix")
    public final boolean enableFix;

    @SerializedName("enable_monitor")
    public final boolean enableMonitor;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SeriesViewRecycleOptV693() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.SeriesViewRecycleOptV693.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598264);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesViewRecycleOptV693 a() {
            return (SeriesViewRecycleOptV693) SeriesViewRecycleOptV693.b.getValue();
        }
    }

    static {
        Lazy<SeriesViewRecycleOptV693> lazy;
        Covode.recordClassIndex(598263);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesViewRecycleOptV693 c;
                c = SeriesViewRecycleOptV693.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesViewRecycleOptV693 c() {
        boolean z = false;
        SeriesViewRecycleOptV693 seriesViewRecycleOptV693 = (SeriesViewRecycleOptV693) qq3.a.c("view_recycle_opt_v693", new SeriesViewRecycleOptV693(z, z, 3, null), false, 4, null);
        LogWrapper.info("SeriesViewRecycleOptV693", "SeriesViewRecycleOptV693 enableMonitor: " + seriesViewRecycleOptV693.enableMonitor + ", enableFix: " + seriesViewRecycleOptV693.enableFix, new Object[0]);
        return seriesViewRecycleOptV693;
    }

    public SeriesViewRecycleOptV693(boolean z, boolean z2) {
        this.enableMonitor = z;
        this.enableFix = z2;
    }

    public /* synthetic */ SeriesViewRecycleOptV693(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
