package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ComicVideoRelateBookEntranceConfigV679ABValue {
    public static final a a;
    private static final Lazy<ComicVideoRelateBookEntranceConfigV679ABValue> b;

    @SerializedName("end")
    public final int end;

    @SerializedName("show_in_bottom")
    public final boolean showInBottom;

    @SerializedName("show_in_header")
    public final boolean showInHeader;

    @SerializedName("start")
    public final int start;

    public ComicVideoRelateBookEntranceConfigV679ABValue() {
        this(false, false, 0, 0, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598329);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean c() {
            return a().showInHeader;
        }

        public final ComicVideoRelateBookEntranceConfigV679ABValue a() {
            return (ComicVideoRelateBookEntranceConfigV679ABValue) ComicVideoRelateBookEntranceConfigV679ABValue.b.getValue();
        }

        public final boolean b(int i, int i2) {
            int i3;
            int i4;
            if (a().start == 0 || a().end == 0) {
                return false;
            }
            if (a().start < 0) {
                i3 = a().start + i2 + 1;
            } else {
                i3 = a().start;
            }
            if (a().end < 0) {
                i4 = i2 + a().end + 1;
            } else {
                i4 = a().end;
            }
            if (i3 > i4 || i3 > i || i > i4) {
                return false;
            }
            return true;
        }
    }

    static {
        Lazy<ComicVideoRelateBookEntranceConfigV679ABValue> lazy;
        Covode.recordClassIndex(598328);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComicVideoRelateBookEntranceConfigV679ABValue c;
                c = ComicVideoRelateBookEntranceConfigV679ABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ComicVideoRelateBookEntranceConfigV679ABValue c() {
        return (ComicVideoRelateBookEntranceConfigV679ABValue) qq3.a.b("comic_video_relate_book_entrance_config_v679", new ComicVideoRelateBookEntranceConfigV679ABValue(false, false, 0, 0, 15, null), true);
    }

    public ComicVideoRelateBookEntranceConfigV679ABValue(boolean z, boolean z2, int i, int i2) {
        this.showInBottom = z;
        this.showInHeader = z2;
        this.start = i;
        this.end = i2;
    }

    public /* synthetic */ ComicVideoRelateBookEntranceConfigV679ABValue(boolean z, boolean z2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }
}
