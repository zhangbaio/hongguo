package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = r8.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum VideoPlayFinishStrategy {
    GuideNextEpisode(0),
    ShowFinishMask(1);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611179);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VideoPlayFinishStrategy> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) VideoPlayFinishStrategy.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(611178);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.VideoPlayFinishStrategy$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return r8.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    VideoPlayFinishStrategy(int i) {
        this.value = i;
    }
}
