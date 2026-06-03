package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortVideoCommentCountReqOptABValue {
    public static final a a;
    private static final Lazy<ShortVideoCommentCountReqOptABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public static final class a {
        static {
            Covode.recordClassIndex(598513);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShortVideoCommentCountReqOptABValue() {
        this(false, 1, null);
    }

    static {
        Lazy<ShortVideoCommentCountReqOptABValue> lazy;
        Covode.recordClassIndex(598512);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.x1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoCommentCountReqOptABValue b2;
                b2 = ShortVideoCommentCountReqOptABValue.b();
                return b2;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoCommentCountReqOptABValue b() {
        return (ShortVideoCommentCountReqOptABValue) qq3.a.a("short_video_comment_count_req_opt_v655", new ShortVideoCommentCountReqOptABValue(false, 1, null), true);
    }

    public ShortVideoCommentCountReqOptABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ ShortVideoCommentCountReqOptABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
