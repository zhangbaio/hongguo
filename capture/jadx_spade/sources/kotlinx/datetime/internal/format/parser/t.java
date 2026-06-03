package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t {
    static {
        Covode.recordClassIndex(659657);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(Object obj, Object obj2, a this_setWithoutReassigning) {
        Intrinsics.checkNotNullParameter(this_setWithoutReassigning, "$this_setWithoutReassigning");
        return "Attempting to assign conflicting values '" + obj + "' and '" + obj2 + "' to field '" + this_setWithoutReassigning.getName() + '\'';
    }

    public static final <Output> u<Output> b(int i, int i2, a<? super Output, Integer> setter, String name) {
        List listOf;
        List listOf2;
        List listOf3;
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new r[]{new x("+"), new k(CollectionsKt__CollectionsJVMKt.listOf(new d0(null, null, setter, name, false)))});
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new r[]{new x("-"), new k(CollectionsKt__CollectionsJVMKt.listOf(new d0(null, null, setter, name, true)))});
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new u[]{new u(CollectionsKt__CollectionsJVMKt.listOf(new k(CollectionsKt__CollectionsJVMKt.listOf(new y(i, setter, name, i2)))), CollectionsKt__CollectionsKt.emptyList()), new u(listOf, CollectionsKt__CollectionsKt.emptyList()), new u(listOf2, CollectionsKt__CollectionsKt.emptyList())});
        return new u<>(emptyList, listOf3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <Object, Type> Object e(final a<? super Object, Type> aVar, Object object, final Type type, int i, int i2) {
        final Type c = aVar.c(object, type);
        if (c == null) {
            return m.a.b(i2);
        }
        return m.a.a(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String f;
                f = t.f(c, type, aVar);
                return f;
            }
        });
    }

    private static final <Target> u<Target> i(boolean z, a<? super Target, Integer> aVar, String str, int i, int i2) {
        boolean z2;
        if (i2 >= (z ? 1 : 0) + 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
            if (z) {
                createListBuilder.add(new x("-"));
            }
            createListBuilder.add(new k(CollectionsKt__CollectionsJVMKt.listOf(new d0(Integer.valueOf(i - (z ? 1 : 0)), Integer.valueOf(i2 - (z ? 1 : 0)), aVar, str, z))));
            return new u<>(CollectionsKt__CollectionsJVMKt.build(createListBuilder), CollectionsKt__CollectionsKt.emptyList());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final <Output> u<Output> c(Integer num, Integer num2, Integer num3, a<? super Output, Integer> setter, String name, Integer num4) {
        List mutableListOf;
        List listOf;
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(g(num, num2, num3, setter, name, true));
        if (num4 != null) {
            mutableListOf.add(h(num, num4, num3, setter, name, false, 32, null));
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new r[]{new x("+"), new k(CollectionsKt__CollectionsJVMKt.listOf(new d0(Integer.valueOf(num4.intValue() + 1), num2, setter, name, false)))});
            mutableListOf.add(new u(listOf, CollectionsKt__CollectionsKt.emptyList()));
        } else {
            mutableListOf.add(h(num, num2, num3, setter, name, false, 32, null));
        }
        return new u<>(CollectionsKt__CollectionsKt.emptyList(), mutableListOf);
    }

    public static final <Target> u<Target> g(Integer num, Integer num2, Integer num3, a<? super Target, Integer> setter, String name, boolean z) {
        int i;
        int i2;
        int i3;
        List listOf;
        String repeat;
        List listOf2;
        List listOf3;
        List listOf4;
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        if (num != null) {
            i = num.intValue();
        } else {
            i = 1;
        }
        int i4 = i + (z ? 1 : 0);
        if (num2 != null) {
            i2 = num2.intValue();
            if (z) {
                i2++;
            }
        } else {
            i2 = Integer.MAX_VALUE;
        }
        if (num3 != null) {
            i3 = num3.intValue();
        } else {
            i3 = 0;
        }
        int min = Math.min(i2, i3);
        if (i4 >= min) {
            return i(z, setter, name, i4, i2);
        }
        u<Target> i5 = i(z, setter, name, i4, i4);
        while (i4 < min) {
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            i4++;
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new u[]{new u(CollectionsKt__CollectionsJVMKt.listOf(new x(" ")), CollectionsKt__CollectionsKt.emptyList()), i5});
            listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new u[]{i(z, setter, name, i4, i4), q.c(listOf3)});
            i5 = new u<>(emptyList, listOf4);
        }
        if (i3 > i2) {
            repeat = StringsKt__StringsJVMKt.repeat(" ", i3 - i2);
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new u[]{new u(CollectionsKt__CollectionsJVMKt.listOf(new x(repeat)), CollectionsKt__CollectionsKt.emptyList()), i5});
            return q.c(listOf2);
        }
        if (i3 != i2) {
            List emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new u[]{i(z, setter, name, i3 + 1, i2), i5});
            return new u<>(emptyList2, listOf);
        }
        return i5;
    }

    public static /* synthetic */ u h(Integer num, Integer num2, Integer num3, a aVar, String str, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 32) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return g(num, num2, num3, aVar, str, z2);
    }
}
