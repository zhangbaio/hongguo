package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ShortVideoRelateBookMigrateToExpandDataV717;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortVideoRelateBookMigrateToExpandDataV717 {
    public static final a a;
    private static final Lazy<ShortVideoRelateBookMigrateToExpandDataV717> b;

    @SerializedName("enable")
    public final boolean enable;

    public ShortVideoRelateBookMigrateToExpandDataV717() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598267);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortVideoRelateBookMigrateToExpandDataV717 a() {
            return (ShortVideoRelateBookMigrateToExpandDataV717) ShortVideoRelateBookMigrateToExpandDataV717.b.getValue();
        }
    }

    static {
        Lazy<ShortVideoRelateBookMigrateToExpandDataV717> lazy;
        Covode.recordClassIndex(598266);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoRelateBookMigrateToExpandDataV717 c;
                c = ShortVideoRelateBookMigrateToExpandDataV717.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoRelateBookMigrateToExpandDataV717 c() {
        return (ShortVideoRelateBookMigrateToExpandDataV717) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "short_video_relate_book_migrate_to_expand_data_v717", new ShortVideoRelateBookMigrateToExpandDataV717(false, 1, null), false, 4, null);
    }

    public ShortVideoRelateBookMigrateToExpandDataV717(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ ShortVideoRelateBookMigrateToExpandDataV717(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
