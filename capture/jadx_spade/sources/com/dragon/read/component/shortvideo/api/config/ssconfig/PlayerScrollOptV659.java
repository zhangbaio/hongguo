package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerScrollOptV659 {
    public static final a a;
    private static final Lazy<PlayerScrollOptV659> b;

    @SerializedName("insert_opt")
    public final boolean insertOpt;

    @SerializedName("scroll_opt")
    public final boolean scrollOpt;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PlayerScrollOptV659() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.PlayerScrollOptV659.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598422);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerScrollOptV659 a() {
            return (PlayerScrollOptV659) PlayerScrollOptV659.b.getValue();
        }
    }

    static {
        Lazy<PlayerScrollOptV659> lazy;
        Covode.recordClassIndex(598421);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerScrollOptV659 c;
                c = PlayerScrollOptV659.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerScrollOptV659 c() {
        boolean z = false;
        return (PlayerScrollOptV659) qq3.a.c("player_scroll_opt_v659", new PlayerScrollOptV659(z, z, 3, null), false, 4, null);
    }

    public PlayerScrollOptV659(boolean z, boolean z2) {
        this.scrollOpt = z;
        this.insertOpt = z2;
    }

    public /* synthetic */ PlayerScrollOptV659(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
