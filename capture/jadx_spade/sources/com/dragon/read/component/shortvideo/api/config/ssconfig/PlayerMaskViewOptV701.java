package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerMaskViewOptV701 {
    public static final a a;
    private static final Lazy<PlayerMaskViewOptV701> b;

    @SerializedName("style")
    public final Integer style;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerMaskViewOptV701() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598416);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerMaskViewOptV701 a() {
            return (PlayerMaskViewOptV701) PlayerMaskViewOptV701.b.getValue();
        }
    }

    public final boolean c() {
        int i;
        Integer num = this.style;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        if (i <= 0) {
            return false;
        }
        return true;
    }

    static {
        Lazy<PlayerMaskViewOptV701> lazy;
        Covode.recordClassIndex(598415);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerMaskViewOptV701 d;
                d = PlayerMaskViewOptV701.d();
                return d;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final PlayerMaskViewOptV701 d() {
        return (PlayerMaskViewOptV701) qq3.a.c("player_mask_view_v701", new PlayerMaskViewOptV701(null, 1, 0 == true ? 1 : 0), false, 4, null);
    }

    public PlayerMaskViewOptV701(Integer num) {
        this.style = num;
    }

    public /* synthetic */ PlayerMaskViewOptV701(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }
}
