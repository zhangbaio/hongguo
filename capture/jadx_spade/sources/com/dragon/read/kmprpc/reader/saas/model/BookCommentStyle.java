package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = v.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookCommentStyle {
    Highlight(1),
    Fade(2),
    OutShowComment(3),
    OutShowCommentWithDetail(4),
    Weak(5),
    ShowBookCover(6),
    ShowCommentText(7);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609799);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BookCommentStyle> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) BookCommentStyle.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609798);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.BookCommentStyle$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return v.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    BookCommentStyle(int i) {
        this.value = i;
    }
}
