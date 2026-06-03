package mq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lq4.a;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e extends lq4.c<Map<String, Integer>> implements lq4.a {
    public static final a i;
    public static final int j;
    private final boolean g;
    private nq4.a h;

    static {
        Covode.recordClassIndex(611293);
        i = new a(null);
        j = 8;
    }

    @Override // lq4.c
    public String e() {
        return "每天最多生效N次";
    }

    @Override // lq4.a
    public nq4.a a() {
        nq4.a aVar = this.h;
        if (aVar != null) {
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counter");
            } else {
                return aVar;
            }
        }
        return null;
    }

    @Override // lq4.c
    public String toString() {
        Map map;
        JSONObject jSONObject = new JSONObject();
        map = MapsKt__MapsKt.toMap((Map) this.a);
        JSONObject put = jSONObject.put("limit", new JSONObject(map));
        nq4.a aVar = this.h;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("counter");
            aVar = null;
        }
        String jSONObject2 = put.put("current", aVar.b()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    @Override // lq4.a
    public int b(String str) {
        return a.C0238a.a(this, str);
    }

    @Override // lq4.c
    public void i(String str) {
        nq4.a aVar = this.h;
        if (aVar != null) {
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counter");
                aVar = null;
            }
            aVar.e(str);
        }
    }

    @Override // lq4.c
    public void g(boolean z) {
        nq4.a aVar = new nq4.a(d(), this.g);
        aVar.d(z);
        this.h = aVar;
    }

    @Override // lq4.c
    public Boolean f(String str) {
        boolean z;
        int c;
        String str2;
        int i2;
        if (this.d) {
            return null;
        }
        boolean z2 = true;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            nq4.a aVar = this.h;
            if (aVar != null) {
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("counter");
                    aVar = null;
                }
                c = aVar.a();
            }
            c = 0;
        } else {
            nq4.a aVar2 = this.h;
            if (aVar2 != null) {
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("counter");
                    aVar2 = null;
                }
                c = aVar2.c(str);
            }
            c = 0;
        }
        Map map = (Map) this.a;
        if (str != null && str.length() != 0) {
            z2 = false;
        }
        if (z2) {
            str2 = "all";
        } else {
            str2 = str;
        }
        Integer num = (Integer) map.get(str2);
        if (num != null || (num = (Integer) ((Map) this.a).get("*")) != null || (num = (Integer) ((Map) this.a).get("all")) != null) {
            i2 = num.intValue();
        } else {
            i2 = Integer.MAX_VALUE;
        }
        if (c >= i2) {
            LogWrapper.warn("LFC.Rule.MaxTimesToday", "intercepted: " + c + '/' + this.a + " at [" + str + ']', new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            sb.append(" >= ");
            sb.append(i2);
            this.b = sb.toString();
            return Boolean.TRUE;
        }
        this.b = null;
        LogWrapper.debug("LFC.Rule.MaxTimesToday", "accepted: " + c + '/' + this.a + " at [" + str + ']', new Object[0]);
        return null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.util.Map<java.lang.String, java.lang.Integer> r2, boolean r3) {
        /*
            r1 = this;
            java.lang.String r0 = "limit"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.Map r2 = kotlin.collections.MapsKt.toMutableMap(r2)
            r1.<init>(r2)
            r1.g = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mq4.e.<init>(java.util.Map, boolean):void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611294);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(int i, boolean z) {
            Map mutableMapOf;
            Pair[] pairArr = new Pair[1];
            if (i < 0) {
                i = Integer.MAX_VALUE;
            }
            pairArr[0] = TuplesKt.to("all", Integer.valueOf(i));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return new e(mutableMapOf, z);
        }

        public final e c(int i, boolean z) {
            Map mutableMapOf;
            Pair[] pairArr = new Pair[1];
            if (i < 0) {
                i = Integer.MAX_VALUE;
            }
            pairArr[0] = TuplesKt.to("*", Integer.valueOf(i));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return new e(mutableMapOf, z);
        }

        public static /* synthetic */ e b(a aVar, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            return aVar.a(i, z);
        }

        public static /* synthetic */ e d(a aVar, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            return aVar.c(i, z);
        }
    }
}
