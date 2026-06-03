package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PugcFullScreenOptV685 {
    public static final a a;
    private static final Lazy<PugcFullScreenOptV685> b;

    @SerializedName("enable")
    public final boolean enable;

    public PugcFullScreenOptV685() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598444);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b().enable;
        }

        public final PugcFullScreenOptV685 b() {
            return (PugcFullScreenOptV685) PugcFullScreenOptV685.b.getValue();
        }
    }

    static {
        Lazy<PugcFullScreenOptV685> lazy;
        Covode.recordClassIndex(598443);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.a1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PugcFullScreenOptV685 c;
                c = PugcFullScreenOptV685.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PugcFullScreenOptV685 c() {
        return (PugcFullScreenOptV685) qq3.a.c("pugc_full_screen_opt_v685", new PugcFullScreenOptV685(false, 1, null), false, 4, null);
    }

    public PugcFullScreenOptV685(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ PugcFullScreenOptV685(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
