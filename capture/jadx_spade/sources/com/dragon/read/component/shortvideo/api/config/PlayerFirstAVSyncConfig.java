package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.PlayerFirstAVSyncConfig;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerFirstAVSyncConfig {
    public static final a a;
    private static final Lazy<PlayerFirstAVSyncConfig> b;

    @SerializedName("enable")
    public final boolean enable;

    public PlayerFirstAVSyncConfig() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598242);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerFirstAVSyncConfig a() {
            return (PlayerFirstAVSyncConfig) PlayerFirstAVSyncConfig.b.getValue();
        }
    }

    static {
        Lazy<PlayerFirstAVSyncConfig> lazy;
        Covode.recordClassIndex(598241);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerFirstAVSyncConfig c;
                c = PlayerFirstAVSyncConfig.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerFirstAVSyncConfig c() {
        return (PlayerFirstAVSyncConfig) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "player_first_av_sync_config", new PlayerFirstAVSyncConfig(false, 1, null), false, 4, null);
    }

    public PlayerFirstAVSyncConfig(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ PlayerFirstAVSyncConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
