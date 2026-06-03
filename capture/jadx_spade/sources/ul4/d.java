package ul4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UgcActionType;
import com.bytedance.kmp.ugc.model.th;
import com.bytedance.kmp.ugc.model.uh;
import com.bytedance.kmp.ugc.model.vh;
import com.bytedance.kmp.ugc.rpc.UgcApiService;
import com.dragon.read.kmp.base.n;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.rpc.kmp.community.model.UgcActionObjectType;
import dl4.b;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
        Covode.recordClassIndex(608199);
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
        StringBuilder sb = new StringBuilder();
        sb.append(UgcActionObjectType.Item.getValue());
        sb.append(',');
        sb.append(UgcActionObjectType.MaterialVideo.getValue());
        sb.append(',');
        sb.append(UgcActionObjectType.Book.getValue());
        Observable L = UgcApiService.L(UgcApiService.a, new uh(sb.toString(), Integer.valueOf(UgcActionType.Like.getValue()), Integer.valueOf(this.a), Integer.valueOf(m()), (Integer) null, str, (Integer) null, 80, (DefaultConstructorMarker) null), (g) null, 2, (Object) null);
        final Function1 function1 = new Function1() { // from class: ul4.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List j;
                j = d.j(d.this, str, (vh) obj);
                return j;
            }
        };
        Single<List<Object>> singleOrError = L.map(new Function() { // from class: ul4.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List l;
                l = d.l(Function1.this, obj);
                return l;
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
    public Single<List<Object>> b(String targetUserId, String justSawVid, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(justSawVid, "justSawVid");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        return i(targetUserId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(d dVar, String str, vh it2) {
        int i;
        List list;
        Boolean bool;
        Integer num;
        Intrinsics.checkNotNullParameter(it2, "it");
        boolean z = false;
        bc4.b.a.a(new bc4.a(it2.a, it2.c, it2.b), false, 0);
        th thVar = it2.c;
        if (thVar != null && (num = thVar.e) != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        dVar.a = i;
        th thVar2 = it2.c;
        if (thVar2 != null && (bool = thVar2.f) != null) {
            z = bool.booleanValue();
        }
        dVar.b = z;
        if (dVar.c == null) {
            dVar.c = Boolean.valueOf(!z);
        }
        th thVar3 = it2.c;
        if (thVar3 != null && (list = thVar3.a) != null) {
            List e = n.e(list);
            ArrayList arrayList = new ArrayList();
            Iterator it4 = e.iterator();
            while (it4.hasNext()) {
                TypeIntrinsics.asMutableList(arrayList).add(new a(str, (cc4.a) it4.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
