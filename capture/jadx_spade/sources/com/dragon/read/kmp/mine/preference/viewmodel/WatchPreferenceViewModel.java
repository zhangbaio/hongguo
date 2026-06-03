package com.dragon.read.kmp.mine.preference.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.PreferenceStatus;
import com.bytedance.kmp.reading.model.UserPreferenceScene;
import com.bytedance.kmp.reading.model.al0;
import com.bytedance.kmp.reading.model.bl0;
import com.bytedance.kmp.reading.model.dl;
import com.bytedance.kmp.reading.model.i00;
import com.bytedance.kmp.reading.model.j00;
import com.bytedance.kmp.reading.rpc.UserApiService;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.f;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.n;
import ig4.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.i;
import wj4.c;
import zj4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class WatchPreferenceViewModel extends ViewModel {
    public static final a h;
    public static final int i;
    public final c a;
    public final wj4.a b;
    public CoroutineScope c;
    private final SnapshotStateList<i00> d;
    private final MutableState<dl> e;
    private final SnapshotStateList<i00> f;
    private final MutableState<dl> g;

    public static final class a {
        static {
            Covode.recordClassIndex(607722);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607721);
        h = new a(null);
        i = 8;
    }

    public final void S0() {
    }

    private final boolean L0() {
        if (N0() >= 30) {
            g.b("最多选择30个分类", (ToastDuration) null, 2, (Object) null);
            return true;
        }
        return false;
    }

    public final int N0() {
        int i2;
        int size = this.d.size();
        if (this.e.getValue() != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        return size + i2;
    }

    public final void M0() {
        j.a.d("WatchPreferenceVideoModel", "clear selected data");
        b.j(b.a, this.a.a, null, "clear", "clear", 2, null);
        this.d.clear();
        this.e.setValue((Object) null);
    }

    public final boolean P0() {
        Set set;
        Set set2;
        set = CollectionsKt___CollectionsKt.toSet(this.d);
        set2 = CollectionsKt___CollectionsKt.toSet(this.f);
        if (Intrinsics.areEqual(set, set2) && Intrinsics.areEqual(this.e.getValue(), this.g.getValue())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Q0(Continuation<? super xn0.b> continuation) {
        return f.a("kmp_watch_preference_data_cache_data", continuation);
    }

    public final <T> boolean O0(T t) {
        if (t instanceof i00) {
            return this.d.contains(t);
        }
        if (t instanceof dl) {
            return Intrinsics.areEqual(this.e.getValue(), t);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object T0(Continuation<? super bl0> continuation) {
        Integer num;
        List list = this.d.toList();
        UserPreferenceScene userPreferenceScene = this.a.a;
        if (userPreferenceScene != null) {
            num = Boxing.boxInt(userPreferenceScene.getValue());
        } else {
            num = null;
        }
        return UserApiService.B(UserApiService.a, new al0("category_v2", list, (List) null, num, 4, (DefaultConstructorMarker) null), (zn0.g) null, continuation, 2, (Object) null);
    }

    public final void V0(boolean z) {
        if (!z) {
            b.j(b.a, this.a.a, null, "save", "save", 2, null);
        }
        if (!P0()) {
            return;
        }
        b.g(b.a, this.a.a, null, (dl) this.e.getValue(), this.d.toList(), 2, null);
        i.e(this.c, Dispatchers.getIO(), null, new WatchPreferenceViewModel$savePreferenceData$1(this, z, null), 2, null);
    }

    public final void R0(CoroutineScope scope) {
        boolean z;
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.c = scope;
        i.e(scope, Dispatchers.getIO(), null, new WatchPreferenceViewModel$onCreate$1(this, null), 2, null);
        if (this.a.e != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<j00> it2 = this.a.e.iterator();
            while (it2.hasNext()) {
                List list = it2.next().d;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        Integer num = ((i00) obj).e;
                        int value = PreferenceStatus.like.getValue();
                        if (num != null && num.intValue() == value) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList.addAll(arrayList2);
                }
            }
            this.d.clear();
            this.d.addAll(arrayList);
            this.f.clear();
            this.f.addAll(this.d);
        }
        b.e(b.a, this.a.a, null, 2, null);
    }

    public final <T> void X0(T t) {
        if (t instanceof i00) {
            b bVar = b.a;
            UserPreferenceScene userPreferenceScene = this.a.a;
            i00 i00Var = (i00) t;
            String str = i00Var.b;
            if (str == null) {
                str = "";
            }
            b.j(bVar, userPreferenceScene, null, "choose_category", str, 2, null);
            if (this.d.contains(t)) {
                this.d.remove(t);
                j.a.d("WatchPreferenceVideoModel", "unselected content data: " + i00Var.b);
                return;
            }
            if (!L0()) {
                this.d.add(t);
                j.a.d("WatchPreferenceVideoModel", "selected content data: " + i00Var.b);
                return;
            }
            return;
        }
        if (t instanceof dl) {
            b bVar2 = b.a;
            UserPreferenceScene userPreferenceScene2 = this.a.a;
            dl dlVar = (dl) t;
            String str2 = dlVar.a;
            if (str2 == null) {
                str2 = "";
            }
            b.j(bVar2, userPreferenceScene2, null, "gender", str2, 2, null);
            if (Intrinsics.areEqual(this.e.getValue(), t)) {
                this.e.setValue((Object) null);
                j.a.d("WatchPreferenceVideoModel", "reselected gender data: " + dlVar.a);
                return;
            }
            if (this.e.getValue() != null || !L0()) {
                this.e.setValue(t);
                j.a.d("WatchPreferenceVideoModel", "selected gender data: " + dlVar.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x012a A[PHI: r1
  0x012a: PHI (r1v15 java.lang.Object) = (r1v12 java.lang.Object), (r1v1 java.lang.Object) binds: [B:22:0x0127, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0129 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object U0(kotlin.coroutines.Continuation<? super com.bytedance.kmp.reading.model.xa0> r37) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel.U0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public WatchPreferenceViewModel(c watchPreferencePageParams, wj4.a iDepend) {
        Intrinsics.checkNotNullParameter(watchPreferencePageParams, "watchPreferencePageParams");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = watchPreferencePageParams;
        this.b = iDepend;
        this.c = n.a;
        this.d = SnapshotStateKt.mutableStateListOf();
        this.e = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.f = SnapshotStateKt.mutableStateListOf();
        this.g = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public static /* synthetic */ void W0(WatchPreferenceViewModel watchPreferenceViewModel, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        watchPreferenceViewModel.V0(z);
    }
}
