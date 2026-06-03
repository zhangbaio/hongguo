package com.dragon.read.kmp.reader.font.manager;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.font.x0;
import com.dragon.read.kmp.reader.utils.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends com.dragon.read.kmp.reader.font.a {
    public static final a c;
    public static final int d;
    private static final Lazy<d> e;
    private final di6.e<String, di6.c<x0>> a = new di6.e<>();
    private final com.dragon.read.kmp.i b = new com.dragon.read.kmp.i(p.o("Font-FontDeleteDispatcher"));

    /* JADX INFO: Access modifiers changed from: private */
    public static final d e() {
        return new d();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608444);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return (d) d.e.getValue();
        }
    }

    static {
        Lazy<d> lazy;
        Covode.recordClassIndex(608443);
        c = new a(null);
        d = 8;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.dragon.read.kmp.reader.font.manager.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                d e2;
                e2 = d.e();
                return e2;
            }
        });
        e = lazy;
    }

    private d() {
    }

    public final void f(String str) {
        if (str != null) {
        }
    }

    @Override // com.dragon.read.kmp.reader.font.a, com.dragon.read.kmp.reader.font.x0
    public void onStart(String str) {
        String str2;
        String str3;
        super.onStart(str);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.dragon.read.kmp.i iVar = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDeleteDispatcher.onStart: ");
        com.dragon.read.kmp.reader.font.h m = FontDataManager.a.m(str2);
        List list = null;
        if (m != null) {
            str3 = m.a;
        } else {
            str3 = null;
        }
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        iVar.d(sb.toString());
        di6.c cVar = (di6.c) this.a.get(str2);
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((x0) it2.next()).onStart(str);
            }
        }
    }

    public final void d(String str, x0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (str != null) {
            di6.c cVar = (di6.c) this.a.get(str);
            if (cVar == null) {
                cVar = new di6.c();
                this.a.put(str, cVar);
            }
            cVar.add(listener);
        }
    }

    @Override // com.dragon.read.kmp.reader.font.a, com.dragon.read.kmp.reader.font.x0
    public void onFailed(String str, String e2) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(e2, "e");
        super.onFailed(str, e2);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.dragon.read.kmp.i iVar = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDeleteDispatcher.onFailed: ");
        com.dragon.read.kmp.reader.font.h m = FontDataManager.a.m(str2);
        List list = null;
        if (m != null) {
            str3 = m.a;
        } else {
            str3 = null;
        }
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(e2);
        iVar.d(sb.toString());
        di6.c cVar = (di6.c) this.a.get(str2);
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((x0) it2.next()).onFailed(str, e2);
            }
        }
        f(str2);
    }

    @Override // com.dragon.read.kmp.reader.font.a, com.dragon.read.kmp.reader.font.x0
    public void a(String str, double d2, String message) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(message, "message");
        super.a(str, d2, message);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.dragon.read.kmp.i iVar = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDeleteDispatcher.onSuccessed: ");
        com.dragon.read.kmp.reader.font.h m = FontDataManager.a.m(str2);
        List list = null;
        if (m != null) {
            str3 = m.a;
        } else {
            str3 = null;
        }
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        iVar.d(sb.toString());
        di6.c cVar = (di6.c) this.a.get(str2);
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((x0) it2.next()).a(str, d2, message);
            }
        }
        f(str2);
    }
}
