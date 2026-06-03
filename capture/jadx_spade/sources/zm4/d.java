package zm4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ym4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(608709);
        a = new d();
    }

    private d() {
    }

    public final Map<String, Object> a() {
        Map<String, Object> emptyMap;
        Map<String, Object> C;
        a aVar = (a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        if (aVar == null || (C = aVar.C()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return C;
    }

    public final void b() {
        a aVar = (a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        if (aVar != null) {
            aVar.pop();
        }
    }

    public final void g(Map<String, ? extends Object> extInfo) {
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        a aVar = (a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        if (aVar != null) {
            aVar.k8(extInfo);
        }
    }

    public final void c(String path, Map<String, ? extends Object> map, k kVar) {
        Intrinsics.checkNotNullParameter(path, "path");
        a aVar = (a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        if (aVar != null) {
            aVar.N2(path, map, kVar);
        }
    }

    public final void e(String path, Map<String, ? extends Object> map, b bVar) {
        Intrinsics.checkNotNullParameter(path, "path");
        a aVar = (a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        if (aVar != null) {
            aVar.Q8(path, map, bVar);
        }
    }

    public final void f(String path, Map<String, ? extends Object> map, k kVar, Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(path, "path");
        a aVar = (a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        if (aVar != null) {
            aVar.x7(path, map, kVar, map2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(d dVar, String str, Map map, k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        if ((i & 4) != 0) {
            kVar = null;
        }
        dVar.c(str, map, kVar);
    }
}
