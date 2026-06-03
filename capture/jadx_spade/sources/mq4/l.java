package mq4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.i7;
import com.dragon.read.util.kotlin.ConvertKt;
import com.dragon.read.util.kotlin.StringKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l extends lq4.c<Pair<? extends Integer, ? extends Integer>> {
    private static final a h;
    public static final int i;
    private final Lazy g;

    private static final class a {
        static {
            Covode.recordClassIndex(611298);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611297);
        h = new a(null);
        i = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(long j, long j2) {
        return (int) (j2 - j);
    }

    @Override // lq4.c
    public String e() {
        return "X天内最多消费Y次";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TreeSet m() {
        return new TreeSet(new Comparator() { // from class: mq4.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int n;
                n = l.n(((Long) obj).longValue(), ((Long) obj2).longValue());
                return n;
            }
        });
    }

    private final TreeSet<Long> o() {
        return (TreeSet) this.g.getValue();
    }

    private final void p() {
        SharedPreferences.Editor edit = d().edit();
        edit.putString("period_consumed_record", CollectionsKt___CollectionsKt.joinToString$default(o(), ",", null, null, 0, null, null, 62, null));
        edit.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        if (((Number) ((Pair) this.a).getFirst()).intValue() <= 0) {
            return;
        }
        long a2 = i7.a() - ((Number) ((Pair) this.a).getFirst()).longValue();
        Iterator<Long> it2 = o().iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Long next = it2.next();
            Intrinsics.checkNotNull(next);
            if (i7.c(next.longValue()) <= a2) {
                it2.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public String toString() {
        JSONObject put = new JSONObject().put("x", ((Number) ((Pair) this.a).getFirst()).intValue()).put("y", ((Number) ((Pair) this.a).getSecond()).intValue());
        TreeSet<Long> o = o();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(o, 10));
        for (Long l : o) {
            StringBuilder sb = new StringBuilder();
            sb.append(l);
            sb.append('|');
            Intrinsics.checkNotNull(l);
            sb.append(i7.c(l.longValue()));
            arrayList.add(sb.toString());
        }
        String jSONObject = put.put("record", new JSONArray((Collection) arrayList)).put("_current_", i7.a()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public void h(String str) {
        if (this.d || ((Number) ((Pair) this.a).getSecond()).intValue() < 0) {
            return;
        }
        o().add(Long.valueOf(System.currentTimeMillis()));
        q();
        p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public Boolean f(String str) {
        if (this.d || ((Number) ((Pair) this.a).getSecond()).intValue() < 0) {
            return null;
        }
        q();
        int intValue = ((Number) ((Pair) this.a).getSecond()).intValue();
        if (o().size() >= intValue) {
            LogWrapper.warn("LFC.Rule.PeriodMaxConsumeTimes", "intercepted: " + o().size() + '/' + intValue, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(o().size());
            sb.append(" >= ");
            sb.append(intValue);
            this.b = sb.toString();
            return Boolean.TRUE;
        }
        this.b = null;
        LogWrapper.debug("LFC.Rule.PeriodMaxConsumeTimes", "accepted: " + o().size() + '/' + intValue, new Object[0]);
        return null;
    }

    @Override // lq4.c
    public void g(boolean z) {
        String str;
        List split$default;
        boolean z2;
        o().clear();
        TreeSet<Long> o = o();
        String string = d().getString("period_consumed_record", "");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{','}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            String str2 = (String) obj;
            if (StringKt.isNotNullOrEmpty(str2) && ConvertKt.toLongSafely(str2) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(ConvertKt.toLongSafely((String) it2.next())));
        }
        o.addAll(arrayList2);
        q();
        p();
    }

    public l(int i2, int i3) {
        super(new Pair(Integer.valueOf(i2), Integer.valueOf(i3)));
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: mq4.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TreeSet m;
                m = l.m();
                return m;
            }
        });
        this.g = lazy;
    }
}
