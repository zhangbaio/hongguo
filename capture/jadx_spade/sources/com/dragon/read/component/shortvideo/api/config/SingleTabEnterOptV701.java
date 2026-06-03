package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.SingleTabEnterOptV701;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SingleTabEnterOptV701 {
    public static final a a;
    private static final Lazy<SingleTabEnterOptV701> b;

    @SerializedName("enable_alpha_animation")
    public final boolean enableAlphaAnimation;

    @SerializedName("enable_create_next_player_when_hit_prepare")
    public final boolean enableCreateNextPlayerWhenHitPrepare;

    @SerializedName("enable_share_player")
    public final boolean enableSharePlayer;

    @SerializedName("enable_share_player_back_from_inner")
    public final boolean enableSharePlayerBackFromInner;

    public SingleTabEnterOptV701() {
        this(false, false, false, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598271);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SingleTabEnterOptV701 a() {
            return (SingleTabEnterOptV701) SingleTabEnterOptV701.b.getValue();
        }
    }

    static {
        Lazy<SingleTabEnterOptV701> lazy;
        Covode.recordClassIndex(598270);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleTabEnterOptV701 c;
                c = SingleTabEnterOptV701.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleTabEnterOptV701 c() {
        return (SingleTabEnterOptV701) qq3.a.c("single_tab_enter_opt_v701", new SingleTabEnterOptV701(false, false, false, false, 15, null), false, 4, null);
    }

    public SingleTabEnterOptV701(boolean z, boolean z2, boolean z3, boolean z4) {
        this.enableSharePlayer = z;
        this.enableAlphaAnimation = z2;
        this.enableSharePlayerBackFromInner = z3;
        this.enableCreateNextPlayerWhenHitPrepare = z4;
    }

    public /* synthetic */ SingleTabEnterOptV701(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }
}
