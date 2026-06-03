package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = f5.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SSTimorDataType {
    unknown(0),
    promote(1),
    nuverse(2),
    micro(3);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610680);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SSTimorDataType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) SSTimorDataType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610679);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.SSTimorDataType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return f5.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    SSTimorDataType(int i) {
        this.value = i;
    }
}
