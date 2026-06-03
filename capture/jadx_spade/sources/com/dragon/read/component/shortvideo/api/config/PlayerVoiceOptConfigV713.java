package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.PlayerVoiceOptConfigV713;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerVoiceOptConfigV713 {
    public static final a a;
    private static final Lazy<PlayerVoiceOptConfigV713> b;

    @SerializedName("autoFix")
    public final boolean autoFix;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("report")
    public final boolean report;

    @SerializedName("stack")
    public final boolean stack;

    public PlayerVoiceOptConfigV713() {
        this(false, false, false, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598247);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerVoiceOptConfigV713 a() {
            return (PlayerVoiceOptConfigV713) PlayerVoiceOptConfigV713.b.getValue();
        }
    }

    static {
        Lazy<PlayerVoiceOptConfigV713> lazy;
        Covode.recordClassIndex(598246);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerVoiceOptConfigV713 c;
                c = PlayerVoiceOptConfigV713.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerVoiceOptConfigV713 c() {
        return (PlayerVoiceOptConfigV713) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "player_voice_opt_v713", new PlayerVoiceOptConfigV713(false, false, false, false, 15, null), false, 4, null);
    }

    public PlayerVoiceOptConfigV713(boolean z, boolean z2, boolean z3, boolean z4) {
        this.enable = z;
        this.report = z2;
        this.autoFix = z3;
        this.stack = z4;
    }

    public /* synthetic */ PlayerVoiceOptConfigV713(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }
}
