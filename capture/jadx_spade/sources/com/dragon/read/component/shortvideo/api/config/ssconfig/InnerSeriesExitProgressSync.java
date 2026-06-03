package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class InnerSeriesExitProgressSync {
    public static final a a;
    private static boolean b;
    private static final Lazy<InnerSeriesExitProgressSync> c;

    @SerializedName("enable")
    public final boolean enable;

    public InnerSeriesExitProgressSync() {
        this(false, 1, null);
    }

    public static final boolean e() {
        return a.b();
    }

    public static final void g() {
        a.c();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598379);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void c() {
            InnerSeriesExitProgressSync.b = true;
        }

        private final InnerSeriesExitProgressSync a() {
            return (InnerSeriesExitProgressSync) InnerSeriesExitProgressSync.c.getValue();
        }

        public final boolean b() {
            if (!a().enable && !InnerSeriesExitProgressSync.b) {
                return false;
            }
            return true;
        }
    }

    static {
        Lazy<InnerSeriesExitProgressSync> lazy;
        Covode.recordClassIndex(598378);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InnerSeriesExitProgressSync f;
                f = InnerSeriesExitProgressSync.f();
                return f;
            }
        });
        c = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InnerSeriesExitProgressSync f() {
        return (InnerSeriesExitProgressSync) qq3.a.c("inner_series_exit_progress_sync", new InnerSeriesExitProgressSync(false, 1, null), false, 4, null);
    }

    public InnerSeriesExitProgressSync(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ InnerSeriesExitProgressSync(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
