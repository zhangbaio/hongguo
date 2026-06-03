package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = s1.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum EcomSelectCategory {
    GeneralSort(1),
    PriceSort(2),
    SaleSort(3),
    LiveOrCommondityFilter(4),
    ProductTagFilter(5),
    PriceFilter(6),
    FreightOriginPoint(7),
    BrandIDFilter(8),
    GuidePurchaseProp(9),
    QueryTag(10),
    BillionSubsidy(11);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610094);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EcomSelectCategory> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) EcomSelectCategory.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610093);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.EcomSelectCategory$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return s1.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    EcomSelectCategory(int i) {
        this.value = i;
    }
}
