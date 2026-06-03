package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h extends ComicVideoRelateBookEntranceConfigV679ABValue {
    public static final a c;
    public static final int d;
    private static final h e;
    private static final Lazy<h> f;

    public static final class a {
        static {
            Covode.recordClassIndex(598327);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            return a().showInBottom;
        }

        public final boolean c() {
            return a().showInHeader;
        }

        public final h a() {
            Object value = h.f.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (h) value;
        }
    }

    public h() {
        super(false, false, 0, 0, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h e() {
        return (h) SsConfigMgr.getABValue("comic_video_relate_book_entrance_config_v679", e);
    }

    static {
        Lazy<h> lazy;
        Covode.recordClassIndex(598326);
        c = new a(null);
        d = 8;
        SsConfigMgr.prepareAB("comic_video_relate_book_entrance_config_v679", h.class, IComicVideoRelateBookEntranceConfigV679.class);
        e = new h();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                h e2;
                e2 = h.e();
                return e2;
            }
        });
        f = lazy;
    }
}
