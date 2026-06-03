package com.dragon.read.kmp.mine.model;

import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.service.b0;
import com.dragon.read.kmp.service.c0;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends ViewModel {
    public static final a g;
    public static final int h;
    private final MutableStateFlow<List<Boolean>> a;
    public final StateFlow<List<Boolean>> b;
    public List<String> c;
    private List<String> d;
    private Disposable e;
    private List<an4.d> f;

    public static final class a {
        static {
            Covode.recordClassIndex(607699);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607698);
        g = new a(null);
        h = 8;
    }

    private final HashMap<String, Boolean> G0() {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        int i = 0;
        for (Object obj : this.a.getValue()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            hashMap.put(this.d.get(i), Boolean.valueOf(((Boolean) obj).booleanValue()));
            i = i2;
        }
        return hashMap;
    }

    public f() {
        List<an4.d> list;
        MutableStateFlow<List<Boolean>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt__CollectionsKt.emptyList());
        this.a = MutableStateFlow;
        this.b = FlowKt.asStateFlow(MutableStateFlow);
        this.c = CollectionsKt__CollectionsKt.emptyList();
        this.d = CollectionsKt__CollectionsKt.emptyList();
        List<an4.d> O7 = c0.a.O7();
        if (O7 != null) {
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) O7);
        } else {
            list = null;
        }
        this.f = list;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(Boolean.valueOf(((an4.d) it2.next()).c));
            }
            MutableStateFlow.setValue(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it4 = list.iterator();
            while (it4.hasNext()) {
                String str = ((an4.d) it4.next()).b;
                if (str != null) {
                    arrayList2.add(str);
                }
            }
            this.c = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                String str2 = ((an4.d) it5.next()).a;
                if (str2 != null) {
                    arrayList3.add(str2);
                }
            }
            this.d = arrayList3;
        }
    }

    public final void K0(b0 cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        c0.a.l2(G0(), cb);
    }

    public static final class b implements b0 {
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        @Override // com.dragon.read.kmp.service.b0
        public void callback(int i) {
            if (i == -1) {
                f.this.J0(this.b, !this.c);
                com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "InnerPushSettingViewModel", "set " + this.b + " to " + this.c + " failed", (Throwable) null, 4, (Object) null);
                StringBuilder sb = new StringBuilder();
                sb.append((String) f.this.c.get(this.b));
                sb.append("设置失败");
                ig4.g.b(sb.toString(), (ToastDuration) null, 2, (Object) null);
                return;
            }
            com.dragon.read.kmp.j.a.d("InnerPushSettingViewModel", "set " + this.b + " to " + this.c);
            f.this.I0(this.b, this.c);
            List<an4.d> list = f.this.f;
            if (list != null) {
                c0.a.U5(list);
            }
        }

        b(int i, boolean z) {
            this.b = i;
            this.c = z;
        }
    }

    public final void H0(int i, boolean z) {
        Disposable disposable = this.e;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        J0(i, z);
        K0(new b(i, z));
    }

    public final void I0(int i, boolean z) {
        List<an4.d> list = this.f;
        if (list != null) {
            list.set(i, new an4.d(this.d.get(i), this.c.get(i), z));
        }
    }

    public final void J0(int i, boolean z) {
        MutableStateFlow<List<Boolean>> mutableStateFlow = this.a;
        List<Boolean> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) mutableStateFlow.getValue());
        mutableList.set(i, Boolean.valueOf(z));
        mutableStateFlow.setValue(mutableList);
    }
}
