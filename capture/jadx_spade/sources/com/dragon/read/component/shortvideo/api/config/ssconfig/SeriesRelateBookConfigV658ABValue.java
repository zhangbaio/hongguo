package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesRelateBookConfigV658ABValue {
    public static final a a;
    private static final Lazy<SeriesRelateBookConfigV658ABValue> b;

    @SerializedName("relate_book_in_detail_page")
    public final boolean relateBookInDetailPage;

    @SerializedName("relate_book_in_episodes_dialog")
    public final boolean relateBookInEpisodesDialog;

    @SerializedName("relate_book_in_play_page")
    public final boolean relateBookInPlayPage;

    public SeriesRelateBookConfigV658ABValue() {
        this(false, false, false, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598491);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b().relateBookInPlayPage;
        }

        private final SeriesRelateBookConfigV658ABValue b() {
            return (SeriesRelateBookConfigV658ABValue) SeriesRelateBookConfigV658ABValue.b.getValue();
        }
    }

    static {
        Lazy<SeriesRelateBookConfigV658ABValue> lazy;
        Covode.recordClassIndex(598490);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.q1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesRelateBookConfigV658ABValue c;
                c = SeriesRelateBookConfigV658ABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesRelateBookConfigV658ABValue c() {
        return (SeriesRelateBookConfigV658ABValue) qq3.a.a("series_relate_book_config_v659", new SeriesRelateBookConfigV658ABValue(false, false, false, 7, null), true);
    }

    public SeriesRelateBookConfigV658ABValue(boolean z, boolean z2, boolean z3) {
        this.relateBookInEpisodesDialog = z;
        this.relateBookInDetailPage = z2;
        this.relateBookInPlayPage = z3;
    }

    public /* synthetic */ SeriesRelateBookConfigV658ABValue(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }
}
