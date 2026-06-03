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
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c extends lq4.c<Pair<? extends Integer, ? extends Integer>> {
    public static final int i;
    public boolean g;
    public final TreeSet<Long> h;

    static {
        Covode.recordClassIndex(611291);
        i = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(long j, long j2) {
        return (int) (j2 - j);
    }

    @Override // lq4.c
    public String e() {
        return "N天生效没消费冷却M天";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public String toString() {
        String jSONObject = new JSONObject().put("n", ((Number) ((Pair) this.a).getFirst()).intValue()).put("m", ((Number) ((Pair) this.a).getSecond()).intValue()).put("continuous", this.g).put("record", new JSONArray((Collection) this.h)).put("_current_", i7.a()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    @Override // lq4.c
    public void h(String str) {
        this.h.clear();
        SharedPreferences.Editor edit = d().edit();
        edit.remove("unconsumed_record");
        edit.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public void i(String str) {
        if (this.g && !this.h.contains(Long.valueOf(i7.a() - 1))) {
            this.h.clear();
        }
        if (this.h.size() >= ((Number) ((Pair) this.a).getFirst()).intValue()) {
            this.h.clear();
        }
        this.h.add(Long.valueOf(i7.a()));
        SharedPreferences.Editor edit = d().edit();
        edit.putString("unconsumed_record", CollectionsKt___CollectionsKt.joinToString$default(this.h, ",", null, null, 0, null, null, 62, null));
        edit.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public void g(boolean z) {
        String str;
        List split$default;
        boolean z2;
        this.h.clear();
        TreeSet<Long> treeSet = this.h;
        String string = d().getString("unconsumed_record", "");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{','}, false, ((Number) ((Pair) this.a).getFirst()).intValue(), 2, (Object) null);
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
        treeSet.addAll(arrayList2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public Boolean f(String str) {
        long j;
        if (this.d) {
            return null;
        }
        long a = i7.a();
        if (!this.h.isEmpty()) {
            Long l = (Long) Collections.max(this.h);
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            a = Math.abs(a - j);
        }
        if (this.h.size() >= ((Number) ((Pair) this.a).getFirst()).intValue() && a <= ((Number) ((Pair) this.a).getSecond()).intValue()) {
            LogWrapper.warn("LFC.Rule.CooldownDays", "intercepted: " + this.h.size() + '/' + ((Number) ((Pair) this.a).getFirst()).intValue() + ", " + a + '/' + ((Number) ((Pair) this.a).getSecond()).intValue(), new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(this.h.size());
            sb.append(" >= ");
            sb.append(((Number) ((Pair) this.a).getFirst()).intValue());
            sb.append(" && ");
            sb.append(a);
            sb.append(" <= ");
            sb.append(((Number) ((Pair) this.a).getSecond()).intValue());
            this.b = sb.toString();
            return Boolean.TRUE;
        }
        this.b = null;
        LogWrapper.debug("LFC.Rule.CooldownDays", "accepted: " + this.h.size() + '/' + ((Number) ((Pair) this.a).getFirst()).intValue() + ", " + a + '/' + ((Number) ((Pair) this.a).getSecond()).intValue(), new Object[0]);
        return null;
    }

    public c(int i2, int i3, boolean z) {
        super(new Pair(Integer.valueOf(i2), Integer.valueOf(i3)));
        this.g = z;
        this.h = new TreeSet<>(new Comparator() { // from class: mq4.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int l;
                l = c.l(((Long) obj).longValue(), ((Long) obj2).longValue());
                return l;
            }
        });
    }

    public /* synthetic */ c(int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, (i4 & 4) != 0 ? false : z);
    }
}
