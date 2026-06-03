package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesInnerFeedIntroLineABValue {
    public static final a a;
    private static final Lazy<SeriesInnerFeedIntroLineABValue> b;

    @SerializedName("line_count")
    public final int lineCount;

    public SeriesInnerFeedIntroLineABValue() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598484);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b() {
            return a().lineCount;
        }

        private final SeriesInnerFeedIntroLineABValue a() {
            return (SeriesInnerFeedIntroLineABValue) SeriesInnerFeedIntroLineABValue.b.getValue();
        }
    }

    static {
        Lazy<SeriesInnerFeedIntroLineABValue> lazy;
        Covode.recordClassIndex(598483);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.n1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesInnerFeedIntroLineABValue c;
                c = SeriesInnerFeedIntroLineABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesInnerFeedIntroLineABValue c() {
        return (SeriesInnerFeedIntroLineABValue) qq3.a.a("inner_feed_data_opt_intro_line_v661", new SeriesInnerFeedIntroLineABValue(0, 1, null), true);
    }

    public SeriesInnerFeedIntroLineABValue(int i) {
        this.lineCount = i;
    }

    public /* synthetic */ SeriesInnerFeedIntroLineABValue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i);
    }
}
