package mq4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.i7;
import com.dragon.read.util.kotlin.ConvertKt;
import com.dragon.read.util.kotlin.StringKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i extends lq4.c<Triple<? extends Integer, ? extends Integer, ? extends Integer>> {
    public static final int i;
    private boolean g;
    private final Lazy h;

    static {
        Covode.recordClassIndex(611296);
        i = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(long j, long j2) {
        return (int) (j2 - j);
    }

    @Override // lq4.c
    public String e() {
        return "X天累计生效Y次没消费冷却Z天";
    }

    private final TreeSet<Long> m() {
        return (TreeSet) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TreeSet n() {
        return new TreeSet(new Comparator() { // from class: mq4.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o;
                o = i.o(((Long) obj).longValue(), ((Long) obj2).longValue());
                return o;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public String toString() {
        JSONObject put = new JSONObject().put("x", ((Number) ((Triple) this.a).getFirst()).intValue()).put("y", ((Number) ((Triple) this.a).getSecond()).intValue()).put("z", ((Number) ((Triple) this.a).getThird()).intValue()).put("continuous", this.g);
        TreeSet<Long> m = m();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(m, 10));
        for (Long l : m) {
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

    @Override // lq4.c
    public void h(String str) {
        m().clear();
        SharedPreferences.Editor edit = d().edit();
        edit.remove("period_unconsumed_record");
        edit.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public void i(String str) {
        boolean z;
        if (this.g) {
            TreeSet<Long> m = m();
            boolean z2 = true;
            if (!(m instanceof Collection) || !m.isEmpty()) {
                Iterator<T> it2 = m.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Long l = (Long) it2.next();
                    Intrinsics.checkNotNull(l);
                    if (i7.c(l.longValue()) + 1 == i7.a()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                m().clear();
            }
        }
        if (m().size() >= ((Number) ((Triple) this.a).getSecond()).intValue()) {
            m().clear();
        }
        m().add(Long.valueOf(System.currentTimeMillis()));
        SharedPreferences.Editor edit = d().edit();
        edit.putString("period_unconsumed_record", CollectionsKt___CollectionsKt.joinToString$default(m(), ",", null, null, 0, null, null, 62, null));
        edit.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public Boolean f(String str) {
        int i2;
        long intValue;
        long j;
        if (this.d) {
            return null;
        }
        long a = i7.a();
        if (!m().isEmpty()) {
            Long l = (Long) Collections.max(m());
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            a = Math.abs(a - i7.c(j));
        }
        if (((Number) ((Triple) this.a).getSecond()).intValue() >= 0) {
            i2 = ((Number) ((Triple) this.a).getSecond()).intValue();
        } else {
            i2 = Integer.MAX_VALUE;
        }
        if (((Number) ((Triple) this.a).getThird()).intValue() < 0) {
            intValue = Long.MAX_VALUE;
        } else {
            intValue = ((Number) ((Triple) this.a).getThird()).intValue();
        }
        if (m().size() >= i2 && a <= intValue) {
            LogWrapper.warn("LFC.Rule.PeriodCooldown", "intercepted: " + m().size() + '/' + ((Number) ((Triple) this.a).getSecond()).intValue() + ", " + a + '/' + intValue, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(m().size());
            sb.append(" >= ");
            sb.append(i2);
            sb.append(" && ");
            sb.append(a);
            sb.append(" <= ");
            sb.append(intValue);
            this.b = sb.toString();
            return Boolean.TRUE;
        }
        this.b = null;
        LogWrapper.debug("LFC.Rule.PeriodCooldown", "accepted: " + m().size() + '/' + ((Number) ((Triple) this.a).getSecond()).intValue() + ", " + a + '/' + intValue, new Object[0]);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public void g(boolean z) {
        String str;
        List split$default;
        long j;
        int i2;
        boolean z2;
        boolean z3;
        m().clear();
        String string = d().getString("period_unconsumed_record", "");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{','}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = split$default.iterator();
        while (true) {
            j = 0;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            String str2 = (String) next;
            if (StringKt.isNotNullOrEmpty(str2) && ConvertKt.toLongSafely(str2) > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            arrayList2.add(Long.valueOf(ConvertKt.toLongSafely((String) it4.next())));
        }
        if (((Number) ((Triple) this.a).getSecond()).intValue() >= 0) {
            i2 = ((Number) ((Triple) this.a).getSecond()).intValue();
        } else {
            i2 = Integer.MAX_VALUE;
        }
        if ((!arrayList2.isEmpty()) && arrayList2.size() >= i2) {
            long longValue = ((Number) arrayList2.get(0)).longValue();
            if (((Number) ((Triple) this.a).getFirst()).intValue() > 0) {
                j = i7.c(longValue) - ((Number) ((Triple) this.a).getFirst()).longValue();
            }
            TreeSet<Long> m = m();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (i7.c(((Number) obj).longValue()) > j) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList3.add(obj);
                }
            }
            m.addAll(arrayList3);
            return;
        }
        m().addAll(arrayList2);
    }

    public i(int i2, int i3, int i4, boolean z) {
        super(new Triple(Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        Lazy lazy;
        this.g = z;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: mq4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TreeSet n;
                n = i.n();
                return n;
            }
        });
        this.h = lazy;
    }

    public /* synthetic */ i(int i2, int i3, int i4, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4, (i5 & 8) != 0 ? false : z);
    }
}
