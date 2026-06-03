package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.SeriesFpsV679;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesFpsV679 {
    public static final a a;
    private static final Lazy<SeriesFpsV679> b;

    @SerializedName("enable_prebind")
    public final boolean enablePrebind;

    public SeriesFpsV679() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598262);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesFpsV679 a() {
            return (SeriesFpsV679) SeriesFpsV679.b.getValue();
        }
    }

    static {
        Lazy<SeriesFpsV679> lazy;
        Covode.recordClassIndex(598261);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesFpsV679 c;
                c = SeriesFpsV679.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesFpsV679 c() {
        return (SeriesFpsV679) qq3.a.c("series_fps_opt_v679", new SeriesFpsV679(false, 1, null), false, 4, null);
    }

    public SeriesFpsV679(boolean z) {
        this.enablePrebind = z;
    }

    public /* synthetic */ SeriesFpsV679(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
