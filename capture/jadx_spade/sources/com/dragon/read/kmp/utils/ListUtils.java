package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ListUtils {
    public static final int $stable = 0;
    public static final ListUtils INSTANCE;

    static {
        Covode.recordClassIndex(609546);
        INSTANCE = new ListUtils();
    }

    private ListUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getSQLStrings$lambda$0(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return "'$it'";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getSQLStrings$lambda$1(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return "'$it'";
    }

    public final String getQueryList(List<String> list) {
        return getListString(list, ",");
    }

    public final <T> T getLast(List<? extends T> list) {
        Object lastOrNull;
        if (list != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
            return (T) lastOrNull;
        }
        return null;
    }

    public final String getQueryList(String... items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return getListString(ArraysKt___ArraysKt.toList(items), ",");
    }

    public final int getSize(Collection<?> collection) {
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public final boolean isEmpty(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public final <T> List<T> asList(T... elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new ArrayList();
        }
        return ArraysKt___ArraysKt.toMutableList(elements);
    }

    public final /* synthetic */ List asListArray(Object[] objArr) {
        boolean z;
        if (objArr != null) {
            if (objArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return ArraysKt___ArraysKt.toMutableList(objArr);
            }
        }
        return new ArrayList();
    }

    public final String getQueryList(Collection<String> collection) {
        List<String> list;
        if (collection != null) {
            list = CollectionsKt___CollectionsKt.toList(collection);
        } else {
            list = null;
        }
        return getListString(list, ",");
    }

    public final <T> T removeLast(List<T> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public final String getSQLStrings(String... items) {
        boolean z;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "";
        }
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(items, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.dragon.read.kmp.utils.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence sQLStrings$lambda$1;
                sQLStrings$lambda$1 = ListUtils.getSQLStrings$lambda$1((String) obj);
                return sQLStrings$lambda$1;
            }
        }, 30, (Object) null);
        return joinToString$default;
    }

    public final /* synthetic */ String getSQLStringsArray(String[] strArr) {
        boolean z;
        String joinToString$default;
        if (strArr != null) {
            if (strArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(strArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.dragon.read.kmp.utils.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        CharSequence sQLStrings$lambda$0;
                        sQLStrings$lambda$0 = ListUtils.getSQLStrings$lambda$0((String) obj);
                        return sQLStrings$lambda$0;
                    }
                }, 30, (Object) null);
                return joinToString$default;
            }
            return "";
        }
        return "";
    }

    public final <T> boolean contains(List<? extends T> list, T t) {
        if (list != null && !list.isEmpty()) {
            return list.contains(t);
        }
        return false;
    }

    public final <T> T getItem(T[] tArr, int i) {
        if (tArr == null) {
            return null;
        }
        boolean z = false;
        if (i >= 0 && i < tArr.length) {
            z = true;
        }
        if (!z) {
            return null;
        }
        return tArr[i];
    }

    public final <T> int indexOf(List<? extends T> list, T t) {
        int indexOf;
        if (list != null) {
            indexOf = CollectionsKt___CollectionsKt.indexOf((List) ((List<? extends Object>) list), (Object) t);
            return indexOf;
        }
        return -1;
    }

    public final <T> T getItem(List<? extends T> list, int i) {
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public final <T> List<List<T>> divideListRounding(List<? extends T> list, int i) {
        if (isEmpty(list)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(list);
        int size = list.size();
        if (size <= i) {
            return CollectionsKt__CollectionsJVMKt.listOf(list);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = size / i;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * i;
            i3++;
            arrayList.add(CollectionsKt___CollectionsKt.toMutableList((Collection) list.subList(i4, i3 * i)));
        }
        return arrayList;
    }

    public final String getListString(List<String> list, String divider) {
        boolean z;
        Intrinsics.checkNotNullParameter(divider, "divider");
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "";
        }
        return CollectionsKt___CollectionsKt.joinToString$default(list, divider, null, null, 0, null, null, 62, null);
    }

    public final <T> List<List<T>> simpleDivide(List<? extends T> list, int i) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + i;
                if (i3 >= size) {
                    i3 = size;
                }
                arrayList.add(list.subList(i2, i3));
                i2 = i3;
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public final <T> List<List<T>> simpleDivideFromEnd(List<? extends T> list, int i) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            if (size <= i) {
                arrayList.add(list);
                return arrayList;
            }
            while (size > 0) {
                int i2 = size - i;
                if (i2 < 0) {
                    i2 = 0;
                }
                arrayList.add(list.subList(i2, size));
                size = i2;
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public final <T> List<List<T>> divideList(List<? extends T> list, int i) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return new ArrayList();
        }
        if (list.size() <= i) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(list);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 % i == 0) {
                arrayList2.add(new ArrayList());
            }
            ((List) CollectionsKt___CollectionsKt.last((List) arrayList2)).add(list.get(i2));
        }
        return arrayList2;
    }

    public final <T> List<T> safeSubList(List<? extends T> list, int i, int i2) {
        int coerceAtLeast;
        int coerceAtMost;
        if (list != null && !list.isEmpty()) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, list.size());
            if (coerceAtLeast > coerceAtMost) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return list.subList(coerceAtLeast, coerceAtMost);
        }
        return null;
    }

    public static /* synthetic */ String getListString$default(ListUtils listUtils, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = ",";
        }
        return listUtils.getListString(list, str);
    }
}
