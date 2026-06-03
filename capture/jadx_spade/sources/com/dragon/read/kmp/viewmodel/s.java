package com.dragon.read.kmp.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import gk4.e0;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s implements ViewModelProvider.Factory {
    public static final a d;
    public static final int e;
    private static final Map<Integer, KClass<? extends o>> f;
    public final e0 a;
    public final xm4.a b;
    private final Map<Integer, Function1<xm4.a, o>> c;

    public /* synthetic */ ViewModel create(Class cls) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
    }

    static {
        Map<Integer, KClass<? extends o>> mapOf;
        Covode.recordClassIndex(609602);
        d = new a(null);
        e = 8;
        zg4.a aVar = zg4.a.a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(aVar.c()), Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class)), TuplesKt.to(Integer.valueOf(aVar.a()), Reflection.getOrCreateKotlinClass(RelationSeriesPagingViewModel.class)), TuplesKt.to(Integer.valueOf(aVar.b()), Reflection.getOrCreateKotlinClass(RelationSeriesPagingViewModel.class)));
        f = mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RelationSeriesSingleViewModel e(xm4.a iDepend) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        return new RelationSeriesSingleViewModel(iDepend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RelationSeriesPagingViewModel f(xm4.a iDepend) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        return new RelationSeriesPagingViewModel(iDepend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RelationSeriesPagingViewModel g(xm4.a iDepend) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        return new RelationSeriesPagingViewModel(iDepend);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609603);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KClass<? extends o> a(e0 dialogData) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            KClass<? extends o> kClass = (KClass) s.f.get(Integer.valueOf(dialogData.a));
            if (kClass == null) {
                return Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class);
            }
            return kClass;
        }
    }

    public s(e0 dialogData, xm4.a iDepend) {
        Map<Integer, Function1<xm4.a, o>> mapOf;
        Intrinsics.checkNotNullParameter(dialogData, "dialogData");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = dialogData;
        this.b = iDepend;
        zg4.a aVar = zg4.a.a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(aVar.c()), new Function1() { // from class: com.dragon.read.kmp.viewmodel.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RelationSeriesSingleViewModel e2;
                e2 = s.e((xm4.a) obj);
                return e2;
            }
        }), TuplesKt.to(Integer.valueOf(aVar.a()), new Function1() { // from class: com.dragon.read.kmp.viewmodel.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RelationSeriesPagingViewModel f2;
                f2 = s.f((xm4.a) obj);
                return f2;
            }
        }), TuplesKt.to(Integer.valueOf(aVar.b()), new Function1() { // from class: com.dragon.read.kmp.viewmodel.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RelationSeriesPagingViewModel g;
                g = s.g((xm4.a) obj);
                return g;
            }
        }));
        this.c = mapOf;
    }

    public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
        o invoke;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Function1<xm4.a, o> function1 = this.c.get(Integer.valueOf(this.a.a));
        if (function1 == null || (invoke = function1.invoke(this.b)) == null) {
            Function1<xm4.a, o> function12 = this.c.get(Integer.valueOf(zg4.a.a.c()));
            Intrinsics.checkNotNull(function12);
            invoke = function12.invoke(this.b);
        }
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type T of com.dragon.read.kmp.viewmodel.RelationSeriesViewModelFactory.create");
        return invoke;
    }
}
