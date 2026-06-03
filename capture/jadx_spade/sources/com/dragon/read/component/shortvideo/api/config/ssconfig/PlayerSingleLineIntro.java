package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerSingleLineIntro {
    public static final a a;
    private static final Lazy<PlayerSingleLineIntro> b;

    @SerializedName("enable")
    public final boolean enable;

    public PlayerSingleLineIntro() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598424);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerSingleLineIntro a() {
            return (PlayerSingleLineIntro) PlayerSingleLineIntro.b.getValue();
        }
    }

    static {
        Lazy<PlayerSingleLineIntro> lazy;
        Covode.recordClassIndex(598423);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerSingleLineIntro c;
                c = PlayerSingleLineIntro.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerSingleLineIntro c() {
        return (PlayerSingleLineIntro) qq3.a.c("short_series_intro_max_lines_config_v663", new PlayerSingleLineIntro(false, 1, null), false, 4, null);
    }

    public PlayerSingleLineIntro(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ PlayerSingleLineIntro(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
