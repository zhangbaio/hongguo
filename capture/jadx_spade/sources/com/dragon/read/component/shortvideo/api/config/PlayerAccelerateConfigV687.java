package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.PlayerAccelerateConfigV687;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerAccelerateConfigV687 {
    public static final a a;
    private static final Lazy<PlayerAccelerateConfigV687> b;

    @SerializedName("feed_tab_cache_opt")
    public final boolean feedTabCacheOpt;

    @SerializedName("first_data_provider_prepare")
    public final boolean firstDataProviderPrepare;

    @SerializedName("schema_entrance_opt")
    public final boolean schemaEntranceOpt;

    public PlayerAccelerateConfigV687() {
        this(false, false, false, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598240);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerAccelerateConfigV687 a() {
            return (PlayerAccelerateConfigV687) PlayerAccelerateConfigV687.b.getValue();
        }
    }

    static {
        Lazy<PlayerAccelerateConfigV687> lazy;
        Covode.recordClassIndex(598239);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerAccelerateConfigV687 c;
                c = PlayerAccelerateConfigV687.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerAccelerateConfigV687 c() {
        return (PlayerAccelerateConfigV687) qq3.a.c("player_accelerate_config_v687", new PlayerAccelerateConfigV687(false, false, false, 7, null), false, 4, null);
    }

    public PlayerAccelerateConfigV687(boolean z, boolean z2, boolean z3) {
        this.firstDataProviderPrepare = z;
        this.schemaEntranceOpt = z2;
        this.feedTabCacheOpt = z3;
    }

    public /* synthetic */ PlayerAccelerateConfigV687(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? true : z3);
    }
}
