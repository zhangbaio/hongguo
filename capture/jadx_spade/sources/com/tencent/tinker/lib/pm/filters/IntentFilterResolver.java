package com.tencent.tinker.lib.pm.filters;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
abstract class IntentFilterResolver<F extends IntentFilter, R> {
    private static final Comparator mResolvePrioritySorter;
    private final HashSet<F> mFilters = new HashSet<>();
    private final HashMap<String, F[]> mSchemeToFilter = new HashMap<>();
    private final HashMap<String, F[]> mTypeToFilter = new HashMap<>();
    private final HashMap<String, F[]> mBaseTypeToFilter = new HashMap<>();
    private final HashMap<String, F[]> mWildTypeToFilter = new HashMap<>();
    private final HashMap<String, F[]> mActionToFilter = new HashMap<>();
    private final HashMap<String, F[]> mTypedActionToFilter = new HashMap<>();

    protected boolean allowFilterResult(F f, List<R> list) {
        return true;
    }

    protected abstract boolean isPackageForFilter(String str, F f);

    protected abstract F[] newArray(int i);

    /* JADX WARN: Multi-variable type inference failed */
    protected R newResult(F f, int i, int i2) {
        return f;
    }

    private class IteratorWrapper implements Iterator<F> {
        private F mCur;
        private final Iterator<F> mI;

        static {
            Covode.recordClassIndex(653783);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mI.hasNext();
        }

        @Override // java.util.Iterator
        public F next() {
            F next = this.mI.next();
            this.mCur = next;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            F f = this.mCur;
            if (f != null) {
                IntentFilterResolver.this.removeFilterInternal(f);
            }
            this.mI.remove();
        }

        IteratorWrapper(Iterator<F> it2) {
            this.mI = it2;
        }
    }

    static {
        Covode.recordClassIndex(653782);
        mResolvePrioritySorter = new Comparator() { // from class: com.tencent.tinker.lib.pm.filters.IntentFilterResolver.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                int priority = ((IntentFilter) obj).getPriority();
                int priority2 = ((IntentFilter) obj2).getPriority();
                if (priority > priority2) {
                    return -1;
                }
                if (priority < priority2) {
                    return 1;
                }
                return 0;
            }
        };
    }

    IntentFilterResolver() {
    }

    protected void sortResults(List<R> list) {
        Collections.sort(list, mResolvePrioritySorter);
    }

    protected void addFilter(F f) {
        this.mFilters.add(f);
        addFilterInternal(f);
    }

    protected void removeFilter(F f) {
        removeFilterInternal(f);
        this.mFilters.remove(f);
    }

    private static HashSet<String> getFastIntentCategories(Intent intent) {
        Set<String> categories = intent.getCategories();
        if (categories == null) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(categories);
        return hashSet;
    }

    private void addFilterInternal(F f) {
        int registerFilter = registerFilter(f, f.schemesIterator(), this.mSchemeToFilter);
        int registerMimeTypes = registerMimeTypes(f, f.typesIterator());
        if (registerFilter == 0 && registerMimeTypes == 0) {
            registerFilter(f, f.actionsIterator(), this.mActionToFilter);
        }
        if (registerMimeTypes != 0) {
            registerFilter(f, f.actionsIterator(), this.mTypedActionToFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFilterInternal(F f) {
        int unregisterFilter = unregisterFilter(f, f.schemesIterator(), this.mSchemeToFilter);
        int unregisterMimeTypes = unregisterMimeTypes(f, f.typesIterator());
        if (unregisterFilter == 0 && unregisterMimeTypes == 0) {
            unregisterFilter(f, f.actionsIterator(), this.mActionToFilter);
        }
        if (unregisterMimeTypes != 0) {
            unregisterFilter(f, f.actionsIterator(), this.mTypedActionToFilter);
        }
    }

    private int registerMimeTypes(F f, Iterator<String> it2) {
        String str;
        if (it2 == null) {
            return 0;
        }
        int i = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            i++;
            int indexOf = next.indexOf(47);
            if (indexOf > 0) {
                str = next.substring(0, indexOf).intern();
            } else {
                str = next;
                next = next + "/*";
            }
            addFilter(this.mTypeToFilter, next, f);
            if (indexOf > 0) {
                addFilter(this.mBaseTypeToFilter, str, f);
            } else {
                addFilter(this.mWildTypeToFilter, str, f);
            }
        }
        return i;
    }

    private int unregisterMimeTypes(F f, Iterator<String> it2) {
        String str;
        if (it2 == null) {
            return 0;
        }
        int i = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            i++;
            int indexOf = next.indexOf(47);
            if (indexOf > 0) {
                str = next.substring(0, indexOf).intern();
            } else {
                str = next;
                next = next + "/*";
            }
            removeAllObjects(this.mTypeToFilter, next, f);
            if (indexOf > 0) {
                removeAllObjects(this.mBaseTypeToFilter, str, f);
            } else {
                removeAllObjects(this.mWildTypeToFilter, str, f);
            }
        }
        return i;
    }

    private int registerFilter(F f, Iterator<String> it2, HashMap<String, F[]> hashMap) {
        int i = 0;
        if (it2 == null) {
            return 0;
        }
        while (it2.hasNext()) {
            i++;
            addFilter(hashMap, it2.next(), f);
        }
        return i;
    }

    private int unregisterFilter(F f, Iterator<String> it2, HashMap<String, F[]> hashMap) {
        int i = 0;
        if (it2 == null) {
            return 0;
        }
        while (it2.hasNext()) {
            i++;
            removeAllObjects(hashMap, it2.next(), f);
        }
        return i;
    }

    private void addFilter(HashMap<String, F[]> hashMap, String str, F f) {
        F[] fArr = hashMap.get(str);
        if (fArr == null) {
            F[] newArray = newArray(2);
            hashMap.put(str, newArray);
            newArray[0] = f;
            return;
        }
        int length = fArr.length;
        int i = length;
        while (i > 0 && fArr[i - 1] == null) {
            i--;
        }
        if (i < length) {
            fArr[i] = f;
            return;
        }
        F[] newArray2 = newArray((length * 3) / 2);
        System.arraycopy(fArr, 0, newArray2, 0, length);
        newArray2[length] = f;
        hashMap.put(str, newArray2);
    }

    private void removeAllObjects(HashMap<String, F[]> hashMap, String str, Object obj) {
        F[] fArr = hashMap.get(str);
        if (fArr != null) {
            int length = fArr.length - 1;
            while (length >= 0 && fArr[length] == null) {
                length--;
            }
            int i = length;
            while (length >= 0) {
                if (fArr[length] == obj) {
                    int i2 = i - length;
                    if (i2 > 0) {
                        System.arraycopy(fArr, length + 1, fArr, length, i2);
                    }
                    fArr[i] = null;
                    i--;
                }
                length--;
            }
            if (i < 0) {
                hashMap.remove(str);
            } else if (i < fArr.length / 2) {
                F[] newArray = newArray(i + 2);
                System.arraycopy(fArr, 0, newArray, 0, i + 1);
                hashMap.put(str, newArray);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.util.List<R> queryIntent(android.content.Intent r18, java.lang.String r19, boolean r20, int r21) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.pm.filters.IntentFilterResolver.queryIntent(android.content.Intent, java.lang.String, boolean, int):java.util.List");
    }

    protected List<R> queryIntentFromList(Intent intent, String str, boolean z, ArrayList<F[]> arrayList, int i) {
        ArrayList arrayList2 = new ArrayList();
        HashSet<String> fastIntentCategories = getFastIntentCategories(intent);
        String scheme = intent.getScheme();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            buildResolveList(intent, fastIntentCategories, z, str, scheme, arrayList.get(i2), arrayList2, i);
        }
        sortResults(arrayList2);
        return arrayList2;
    }

    private void buildResolveList(Intent intent, HashSet<String> hashSet, boolean z, String str, String str2, F[] fArr, List<R> list, int i) {
        int i2;
        int match;
        String action = intent.getAction();
        Uri data = intent.getData();
        String str3 = intent.getPackage();
        if (fArr != null) {
            i2 = fArr.length;
        } else {
            i2 = 0;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            F f = fArr[i3];
            if (f != null) {
                if ((str3 == null || isPackageForFilter(str3, f)) && allowFilterResult(f, list) && (match = f.match(action, str, str2, data, hashSet, "IntentFilterResolver")) >= 0 && (!z || f.hasCategory("android.intent.category.DEFAULT"))) {
                    R newResult = newResult(f, match, i);
                    if (newResult != null) {
                        list.add(newResult);
                    }
                }
            } else {
                return;
            }
        }
    }
}
