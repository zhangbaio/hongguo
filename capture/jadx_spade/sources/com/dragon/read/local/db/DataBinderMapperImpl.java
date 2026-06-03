package com.dragon.read.local.db;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;

    private static class b {
        static final HashMap<String, Integer> a;

        static {
            Covode.recordClassIndex(611524);
            a = new HashMap<>(0);
        }
    }

    static {
        Covode.recordClassIndex(611522);
        INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);
    }

    private static class a {
        static final SparseArray<String> a;

        static {
            Covode.recordClassIndex(611523);
            SparseArray<String> sparseArray = new SparseArray<>(1);
            a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.utils.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.kmp.kmp_compat.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return a.a.get(i);
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i) > 0 && view.getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
