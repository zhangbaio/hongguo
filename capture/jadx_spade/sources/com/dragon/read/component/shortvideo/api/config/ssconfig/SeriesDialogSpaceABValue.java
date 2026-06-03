package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesDialogSpaceABValue {
    public static final a a;
    private static final Lazy<SeriesDialogSpaceABValue> b;

    @SerializedName("style")
    public final int style;

    public SeriesDialogSpaceABValue() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598474);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SeriesDialogSpaceABValue b() {
            return (SeriesDialogSpaceABValue) SeriesDialogSpaceABValue.b.getValue();
        }

        public final boolean a() {
            if (b().style != 2 && b().style != 3) {
                return false;
            }
            return true;
        }

        public final boolean c() {
            if (b().style == 1 || b().style == 3) {
                return true;
            }
            return false;
        }
    }

    static {
        Lazy<SeriesDialogSpaceABValue> lazy;
        Covode.recordClassIndex(598473);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.k1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesDialogSpaceABValue c;
                c = SeriesDialogSpaceABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesDialogSpaceABValue c() {
        return (SeriesDialogSpaceABValue) qq3.a.a("episode_structure_and_size_ab_style_v631", new SeriesDialogSpaceABValue(0, 1, null), true);
    }

    public SeriesDialogSpaceABValue(int i) {
        this.style = i;
    }

    public /* synthetic */ SeriesDialogSpaceABValue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
