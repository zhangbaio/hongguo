package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerRetryOpt {
    public static final a a;
    private static final Lazy<PlayerRetryOpt> b;

    @SerializedName("enable")
    public final boolean enable;

    public PlayerRetryOpt() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598420);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerRetryOpt a() {
            return (PlayerRetryOpt) PlayerRetryOpt.b.getValue();
        }
    }

    static {
        Lazy<PlayerRetryOpt> lazy;
        Covode.recordClassIndex(598419);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerRetryOpt c;
                c = PlayerRetryOpt.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerRetryOpt c() {
        return (PlayerRetryOpt) ISeriesAbValueApi.Companion.c().getABValue2("player_retry_opt", new PlayerRetryOpt(false, 1, null), true);
    }

    public PlayerRetryOpt(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ PlayerRetryOpt(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
