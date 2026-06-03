package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = p6.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SubTitlePosition {
    VideoSeriesPostMainDramaCard(1),
    VideoSeriesPostAnchorList(2),
    VideoSeriesPostMainDramaCardVertical(3),
    VideoSeriesPostMainDramaCardNew(4);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610868);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SubTitlePosition> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) SubTitlePosition.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610867);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.SubTitlePosition$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return p6.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    SubTitlePosition(int i) {
        this.value = i;
    }
}
