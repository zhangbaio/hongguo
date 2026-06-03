package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class EnableAlbumHistoryRecordV671AbValue {
    public static final a a;
    private static final Lazy<EnableAlbumHistoryRecordV671AbValue> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("enable_show_episode_dialog_intro")
    public final boolean enableShowEpisodeDialogIntro;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EnableAlbumHistoryRecordV671AbValue() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.EnableAlbumHistoryRecordV671AbValue.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598337);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnableAlbumHistoryRecordV671AbValue a() {
            return (EnableAlbumHistoryRecordV671AbValue) EnableAlbumHistoryRecordV671AbValue.b.getValue();
        }
    }

    static {
        Lazy<EnableAlbumHistoryRecordV671AbValue> lazy;
        Covode.recordClassIndex(598336);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EnableAlbumHistoryRecordV671AbValue c;
                c = EnableAlbumHistoryRecordV671AbValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnableAlbumHistoryRecordV671AbValue c() {
        boolean z = false;
        return (EnableAlbumHistoryRecordV671AbValue) qq3.a.b("short_series_album_history_recorder_v671", new EnableAlbumHistoryRecordV671AbValue(z, z, 3, null), true);
    }

    public EnableAlbumHistoryRecordV671AbValue(boolean z, boolean z2) {
        this.enable = z;
        this.enableShowEpisodeDialogIntro = z2;
    }

    public /* synthetic */ EnableAlbumHistoryRecordV671AbValue(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2);
    }
}
