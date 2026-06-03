package xj4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.n10;
import com.dragon.read.kmp.api.PrefSelectionMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(607715);
            int[] iArr = new int[PrefSelectionMode.values().length];
            try {
                iArr[PrefSelectionMode.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrefSelectionMode.MULTIPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(607714);
    }

    public static final n10 b(n10 n10Var, boolean z) {
        Intrinsics.checkNotNullParameter(n10Var, "<this>");
        return new n10(n10Var.a, n10Var.b, Boolean.valueOf(z), n10Var.d);
    }

    public static final List<n10> a(List<n10> list, int i, PrefSelectionMode mode) {
        boolean z;
        ArrayList arrayList;
        n10 b;
        boolean z2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (!list.isEmpty()) {
            if (i >= 0 && i < list.size()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i2 = a.a[mode.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        int i3 = 0;
                        for (Object obj : list) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            n10 n10Var = (n10) obj;
                            if (i3 == i) {
                                Boolean bool = n10Var.c;
                                if (bool != null) {
                                    z2 = bool.booleanValue();
                                } else {
                                    z2 = false;
                                }
                                n10Var = b(n10Var, !z2);
                            }
                            arrayList.add(n10Var);
                            i3 = i4;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    int i5 = 0;
                    for (Object obj2 : list) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        n10 n10Var2 = (n10) obj2;
                        if (i5 == i) {
                            b = b(n10Var2, true);
                        } else {
                            b = b(n10Var2, false);
                        }
                        arrayList.add(b);
                        i5 = i6;
                    }
                }
                return arrayList;
            }
        }
        return list;
    }
}
