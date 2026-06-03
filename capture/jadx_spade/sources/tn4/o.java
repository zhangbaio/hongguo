package tn4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import rn4.q;
import uh1.a;
import xn4.h0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o extends q {
    public static final int j;
    private Function1<? super Boolean, Unit> g;
    private boolean h;
    private boolean i;

    static {
        Covode.recordClassIndex(608916);
        j = 8;
    }

    private final vn4.a j() {
        un4.a aVar = this.a;
        if (aVar instanceof vn4.a) {
            return (vn4.a) aVar;
        }
        return null;
    }

    public void i() {
        wn4.k kVar = this.e;
        if (kVar != null) {
            kVar.dismiss("choose_channel");
        }
        this.e = null;
    }

    private final void l() {
        un4.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        this.h = true;
        this.i = false;
        uh1.e eVar = this.b;
        if (eVar != null) {
            eVar.b(aVar, new Function1() { // from class: tn4.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit m;
                    m = o.m(o.this, obj);
                    return m;
                }
            });
        }
    }

    public void c() {
        yn4.b bVar;
        vn4.a j2 = j();
        if (j2 == null) {
            return;
        }
        ArrayList arrayList = null;
        j2.k = null;
        h0 h0Var = h0.a;
        List<bh1.a> list = this.c;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        this.e = new wn4.k(h0Var.a("分享至", j2, list, new Function1() { // from class: tn4.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n;
                n = o.n(o.this, (bh1.a) obj);
                return n;
            }
        }), j2);
        un4.a aVar = this.a;
        if (aVar != null && (bVar = aVar.h) != null) {
            List<bh1.a> list2 = this.c;
            if (list2 != null) {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((bh1.a) it2.next()).a);
                }
            }
            bVar.f = arrayList;
        }
        wn4.k kVar = this.e;
        if (kVar != null) {
            kVar.show();
        }
    }

    private final void k(bh1.a aVar) {
        boolean z;
        yn4.b bVar;
        String str;
        vn4.a j2 = j();
        boolean z2 = true;
        if (j2 != null && j2.l()) {
            z = true;
        } else {
            z = false;
        }
        if (!z || k.a.c(aVar.a)) {
            z2 = false;
        }
        un4.a aVar2 = this.a;
        if (aVar2 != null && (bVar = aVar2.h) != null) {
            if (z2) {
                str = "qrcode";
            } else {
                str = "search";
            }
            bVar.g = str;
        }
        Function3<? super bh1.a, Object, ? super String, Unit> function3 = this.d;
        if (function3 != null) {
            function3.invoke(aVar, j(), null);
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final o oVar, final bh1.a channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (oVar.i) {
            oVar.l();
        }
        if (oVar.h) {
            h0.a.i("加载中");
            oVar.g = new Function1() { // from class: tn4.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o;
                    o = o.o(o.this, channel, ((Boolean) obj).booleanValue());
                    return o;
                }
            };
        } else {
            oVar.k(channel);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit m(tn4.o r4, java.lang.Object r5) {
        /*
            boolean r0 = r5 instanceof com.bytedance.kmp.reading.model.jb0
            r1 = 0
            if (r0 == 0) goto L8
            com.bytedance.kmp.reading.model.jb0 r5 = (com.bytedance.kmp.reading.model.jb0) r5
            goto L9
        L8:
            r5 = r1
        L9:
            r0 = 1
            r2 = 0
            if (r5 == 0) goto L1e
            java.lang.String r3 = r5.d
            if (r3 == 0) goto L1e
            int r3 = r3.length()
            if (r3 != 0) goto L19
            r3 = 1
            goto L1a
        L19:
            r3 = 0
        L1a:
            if (r3 != r0) goto L1e
            r3 = 1
            goto L1f
        L1e:
            r3 = 0
        L1f:
            if (r3 == 0) goto L2d
            vn4.a r3 = r4.j()
            if (r3 == 0) goto L2a
            java.lang.String r3 = r3.t
            goto L2b
        L2a:
            r3 = r1
        L2b:
            r5.d = r3
        L2d:
            vn4.a r3 = r4.j()
            if (r3 == 0) goto L35
            r3.m = r5
        L35:
            if (r5 == 0) goto L41
            kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r5 = r4.g
            if (r5 == 0) goto L4c
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r5.invoke(r0)
            goto L4c
        L41:
            r4.i = r0
            kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r5 = r4.g
            if (r5 == 0) goto L4c
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r5.invoke(r0)
        L4c:
            r4.g = r1
            r4.h = r2
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tn4.o.m(tn4.o, java.lang.Object):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(o oVar, bh1.a aVar, boolean z) {
        h0.a.g();
        oVar.k(aVar);
        return Unit.INSTANCE;
    }

    @Override // rn4.q
    public void a(bh1.b params, uh1.e datasource, List<bh1.a> channels, a.b listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(datasource, "datasource");
        Intrinsics.checkNotNullParameter(channels, "channels");
        Intrinsics.checkNotNullParameter(listener, "listener");
        super.a(params, datasource, channels, listener);
        l();
    }
}
