package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FpsOptV695 {
    public static final a a;
    private static final Lazy<FpsOptV695> b;

    @SerializedName("enable")
    public final boolean enable;

    public FpsOptV695() {
        this(false, 1, null);
    }

    public static final FpsOptV695 d() {
        return a.a();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598357);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FpsOptV695 a() {
            return (FpsOptV695) FpsOptV695.b.getValue();
        }
    }

    static {
        Lazy<FpsOptV695> lazy;
        Covode.recordClassIndex(598356);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FpsOptV695 c;
                c = FpsOptV695.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FpsOptV695 c() {
        return (FpsOptV695) qq3.a.c("series_fps_opt_v695", new FpsOptV695(false, 1, null), false, 4, null);
    }

    public FpsOptV695(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ FpsOptV695(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
