package lq4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.SingleAppContext;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.lfc.LFCBiz;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.util.i7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final C0239b f;
    public static final int g;
    private static final Map<LFCBiz, b> h;
    public final LFCBiz a;
    public final ArrayList<c<?>> b;
    public final String c;
    private final SharedPreferences d;
    private long e;

    public /* synthetic */ b(LFCBiz lFCBiz, ArrayList arrayList, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(lFCBiz, arrayList, str);
    }

    /* renamed from: lq4.b$b, reason: collision with other inner class name */
    public static final class C0239b {
        static {
            Covode.recordClassIndex(611286);
        }

        private C0239b() {
        }

        public /* synthetic */ C0239b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<LFCBiz, b> b() {
            return b.h;
        }

        public final boolean a() {
            return SingleAppContext.inst(App.context()).isLocalTestChannel();
        }
    }

    static {
        Covode.recordClassIndex(611284);
        f = new C0239b(null);
        g = 8;
        h = new LinkedHashMap();
    }

    public static final class a {
        public static final int d;
        private final LFCBiz a;
        private final String b;
        private final ArrayList<c<?>> c;

        static {
            Covode.recordClassIndex(611285);
            d = 8;
        }

        public final a c(c<?> rule) {
            Intrinsics.checkNotNullParameter(rule, "rule");
            this.c.add(rule);
            return this;
        }

        public final b a(int i) {
            b bVar;
            if ((i & 2) == 0) {
                C0239b c0239b = b.f;
                if (c0239b.a() && (bVar = c0239b.b().get(this.a)) != null) {
                    return bVar;
                }
            }
            return new b(this.a, this.c, this.b, null).c(i);
        }

        public a(LFCBiz biz, String suffix) {
            Intrinsics.checkNotNullParameter(biz, "biz");
            Intrinsics.checkNotNullParameter(suffix, "suffix");
            this.a = biz;
            this.b = suffix;
            this.c = new ArrayList<>();
        }

        public /* synthetic */ a(LFCBiz lFCBiz, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(lFCBiz, (i & 2) != 0 ? "" : str);
        }

        public static /* synthetic */ b b(a aVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return aVar.a(i);
        }
    }

    public final boolean g(String str) {
        return e(str).getFirst().booleanValue();
    }

    public final void i(String str) {
        Iterator<T> it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).h(str);
        }
    }

    public final void k(String str) {
        Iterator<T> it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).i(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b c(int i) {
        boolean z;
        this.e = System.currentTimeMillis();
        long j = this.d.getLong("record_day", 0L);
        long a2 = i7.a();
        if (a2 != j) {
            z = true;
        } else {
            z = false;
        }
        Iterator<T> it2 = this.b.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            SharedPreferences sp = this.d;
            Intrinsics.checkNotNullExpressionValue(sp, "sp");
            cVar.c(sp, z);
        }
        int i2 = i & 1;
        if (i2 == 0 && f.a()) {
            h.put(this.a, this);
        }
        if (i2 == 0 && z) {
            SharedPreferences sp2 = this.d;
            Intrinsics.checkNotNullExpressionValue(sp2, "sp");
            SharedPreferences.Editor edit = sp2.edit();
            edit.putLong("record_day", a2);
            edit.apply();
        }
        return this;
    }

    public final Pair<Boolean, c<?>> e(String str) {
        if (!i7.v(this.e)) {
            d(this, 0, 1, null);
        }
        LogWrapper.debug("LFC.Helper", " ------ " + this.a.getDesc() + " start intercept... ------", new Object[0]);
        Iterator<c<?>> it2 = this.b.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            c<?> next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            c<?> cVar = next;
            Boolean f2 = cVar.f(str);
            if (f2 != null) {
                Pair<Boolean, c<?>> pair = new Pair<>(f2, cVar);
                if (f2.booleanValue()) {
                    LogWrapper.warn("LFC.Helper", " ====== " + this.a.getDesc() + " intercepted by " + cVar.e() + " ======", new Object[0]);
                } else {
                    LogWrapper.debug("LFC.Helper", " ====== " + this.a.getDesc() + " accepted by " + cVar.e() + " ======", new Object[0]);
                }
                return pair;
            }
        }
        LogWrapper.info("LFC.Helper", " ====== " + this.a.getDesc() + " passed all lfc rules(" + this.b.size() + ") ======", new Object[0]);
        return new Pair<>(Boolean.FALSE, null);
    }

    private b(LFCBiz lFCBiz, ArrayList<c<?>> arrayList, String str) {
        this.a = lFCBiz;
        this.b = arrayList;
        this.c = str;
        this.d = KvCacheMgr.getPrivate(App.context(), "lfc_" + lFCBiz.getCacheId() + str);
    }

    static /* synthetic */ b d(b bVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return bVar.c(i);
    }

    public static /* synthetic */ Pair f(b bVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return bVar.e(str);
    }

    public static /* synthetic */ boolean h(b bVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return bVar.g(str);
    }

    public static /* synthetic */ void j(b bVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        bVar.i(str);
    }

    public static /* synthetic */ void l(b bVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        bVar.k(str);
    }
}
