package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = z1.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum Gender {
    FEMALE(0),
    MALE(1),
    NOSET(2);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610169);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Gender> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) Gender.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610168);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.Gender$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return z1.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    Gender(int i) {
        this.value = i;
    }
}
