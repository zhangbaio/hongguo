package zk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.a5;
import com.bytedance.kmp.reading.model.am;
import com.bytedance.kmp.reading.model.bm;
import com.bytedance.kmp.reading.model.cm;
import com.bytedance.kmp.reading.rpc.BookApiService;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import dl4.b;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import zn0.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements dl4.b {
    public static final int d;
    private int a;
    private boolean b;
    private Boolean c;

    static {
        Covode.recordClassIndex(608031);
        d = 8;
    }

    @Override // dl4.b
    public Boolean d() {
        return this.c;
    }

    @Override // dl4.b
    public boolean k() {
        return this.b;
    }

    @Override // dl4.b
    public void onDestroy() {
        b.a.e(this);
    }

    @Override // dl4.b
    public void reset() {
        b.a.f(this);
    }

    @Override // dl4.b
    public boolean f() {
        return b.a.d(this);
    }

    public int m() {
        return b.a.b(this);
    }

    @Override // dl4.b
    public void c(String str) {
        b.a.g(this, str);
    }

    @Override // dl4.b
    public void g(int i) {
        b.a.c(this, i);
    }

    private final Single<List<Object>> i(final String str) {
        Observable l = BookApiService.l(BookApiService.a, new bm(str, Integer.valueOf(this.a), Integer.valueOf(m())), (g) null, 2, (Object) null);
        final Function1 function1 = new Function1() { // from class: zk4.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List j;
                j = d.j(d.this, str, (cm) obj);
                return j;
            }
        };
        Single<List<Object>> singleOrError = l.map(new Function() { // from class: zk4.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List l2;
                l2 = d.l(Function1.this, obj);
                return l2;
            }
        }).singleOrError();
        Intrinsics.checkNotNullExpressionValue(singleOrError, "singleOrError(...)");
        return singleOrError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) function1.invoke(p0);
    }

    @Override // dl4.b
    public Single<List<Object>> a(String targetUserId, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        return i(targetUserId);
    }

    @Override // dl4.b
    public Single<List<Object>> b(String targetUserId, String justSawView, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(justSawView, "justSawView");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        return i(targetUserId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(d dVar, String str, cm it2) {
        int i;
        List arrayList;
        Boolean bool;
        Integer num;
        Intrinsics.checkNotNullParameter(it2, "it");
        boolean z = false;
        bc4.b.a.a(new bc4.a(it2.a, it2.c, it2.b), false, 0);
        am amVar = it2.c;
        if (amVar == null) {
            return new ArrayList();
        }
        if (amVar != null && (num = amVar.d) != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        dVar.a = i;
        am amVar2 = it2.c;
        if (amVar2 != null && (bool = amVar2.c) != null) {
            z = bool.booleanValue();
        }
        dVar.b = z;
        if (dVar.c == null) {
            dVar.c = Boolean.valueOf(!z);
        }
        am amVar3 = it2.c;
        if (amVar3 == null || (arrayList = amVar3.a) == null) {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            TypeIntrinsics.asMutableList(arrayList2).add(new a(str, (a5) it4.next()));
        }
        return arrayList2;
    }
}
