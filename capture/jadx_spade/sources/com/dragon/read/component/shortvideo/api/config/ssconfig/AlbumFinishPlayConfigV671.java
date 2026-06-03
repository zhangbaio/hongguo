package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AlbumFinishPlayConfigV671 {
    public static final a a;
    private static final Lazy<AlbumFinishPlayConfigV671> b;

    @SerializedName("enable")
    public final boolean enable;

    public AlbumFinishPlayConfigV671() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598312);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AlbumFinishPlayConfigV671 a() {
            return (AlbumFinishPlayConfigV671) AlbumFinishPlayConfigV671.b.getValue();
        }

        public final boolean b() {
            if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).n4() && a().enable) {
                return true;
            }
            return false;
        }
    }

    static {
        Lazy<AlbumFinishPlayConfigV671> lazy;
        Covode.recordClassIndex(598311);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AlbumFinishPlayConfigV671 c;
                c = AlbumFinishPlayConfigV671.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlbumFinishPlayConfigV671 c() {
        return (AlbumFinishPlayConfigV671) qq3.a.c("album_finish_play_config", new AlbumFinishPlayConfigV671(false, 1, null), false, 4, null);
    }

    public AlbumFinishPlayConfigV671(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ AlbumFinishPlayConfigV671(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
