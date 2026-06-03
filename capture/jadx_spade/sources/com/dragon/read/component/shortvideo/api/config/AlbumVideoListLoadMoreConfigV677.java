package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.AlbumVideoListLoadMoreConfigV677;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AlbumVideoListLoadMoreConfigV677 {
    public static final a a;
    private static final Lazy<AlbumVideoListLoadMoreConfigV677> b;

    @SerializedName("enable")
    public final boolean enable;

    public AlbumVideoListLoadMoreConfigV677() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598219);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AlbumVideoListLoadMoreConfigV677 a() {
            return (AlbumVideoListLoadMoreConfigV677) AlbumVideoListLoadMoreConfigV677.b.getValue();
        }
    }

    static {
        Lazy<AlbumVideoListLoadMoreConfigV677> lazy;
        Covode.recordClassIndex(598218);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AlbumVideoListLoadMoreConfigV677 c;
                c = AlbumVideoListLoadMoreConfigV677.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlbumVideoListLoadMoreConfigV677 c() {
        return (AlbumVideoListLoadMoreConfigV677) qq3.a.c("album_video_list_load_more_config_v677", new AlbumVideoListLoadMoreConfigV677(false, 1, null), false, 4, null);
    }

    public AlbumVideoListLoadMoreConfigV677(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ AlbumVideoListLoadMoreConfigV677(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
