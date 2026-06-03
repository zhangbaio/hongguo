package com.dragon.read.nonstandard.ad.api;

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
    private static final SparseIntArray a;

    private static class b {
        static final HashMap<String, Integer> a;

        static {
            Covode.recordClassIndex(612488);
            a = new HashMap<>(0);
        }
    }

    static {
        Covode.recordClassIndex(612486);
        a = new SparseIntArray(0);
    }

    private static class a {
        static final SparseArray<String> a;

        static {
            Covode.recordClassIndex(612487);
            SparseArray<String> sparseArray = new SparseArray<>(1);
            a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(21);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.dragon.fluency.monitor.recyclerview.DataBinderMapperImpl());
        arrayList.add(new com.dragon.mediafinder.DataBinderMapperImpl());
        arrayList.add(new com.dragon.mediavideofinder.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.framework.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.localcache.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.mmkv.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.network.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.resource.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.skin.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.ui.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.utils.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.base.video.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.component.base.ui.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.component.base.utils.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.kmp.core.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.kmp.kmp_compat.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.kmp.performance.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.local.db.DataBinderMapperImpl());
        arrayList.add(new com.dragon.read.rpc.DataBinderMapperImpl());
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
        if (a.get(i) > 0 && view.getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
