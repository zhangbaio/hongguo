package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = m7.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcActionReasonType {
    Server(1),
    Client(2),
    User(3),
    Remark(4);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610976);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UgcActionReasonType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) UgcActionReasonType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610975);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.UgcActionReasonType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return m7.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    UgcActionReasonType(int i) {
        this.value = i;
    }
}
