package com.dragon.read.kmp.story.impl.feeds.uicontext;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.ssconfig.template.KmpLineSpaceMode;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.c0;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.service.i1;
import com.dragon.read.kmp.service.j1;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import ec4.j0;
import ec4.k;
import ec4.k0;
import ec4.p;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.i;
import pm4.q;
import sk5.n;
import sk5.p;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryReadingSettingManager implements j1, i1 {
    public static final KmpStoryReadingSettingManager a;
    private static final xn0.b b;
    private static int c;
    private static final List<Integer> d;
    private static k e;
    private static final List<k> f;
    private static int g;
    private static boolean h;
    private static final List<a> i;
    private static final Set<b> j;
    public static final int k;

    private KmpStoryReadingSettingManager() {
    }

    @Override // com.dragon.read.kmp.service.i1
    public void a(String theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
    }

    public final List<a> d() {
        return i;
    }

    public final int e() {
        return c;
    }

    public final List<Integer> f() {
        return d;
    }

    public final List<k> g() {
        return f;
    }

    public final k h() {
        return e;
    }

    public final int i() {
        if (h) {
            return 5;
        }
        return g;
    }

    public final String j() {
        switch (i()) {
            case 1:
            default:
                return "white";
            case 2:
                return "yellow";
            case 3:
                return "green";
            case 4:
                return "blue";
            case 5:
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case 7:
                return "black";
        }
    }

    static {
        List<a> listOf;
        int i2;
        Object obj;
        int intValue;
        boolean z;
        boolean z2;
        Covode.recordClassIndex(609353);
        KmpStoryReadingSettingManager kmpStoryReadingSettingManager = new KmpStoryReadingSettingManager();
        a = kmpStoryReadingSettingManager;
        xn0.b a2 = xn0.c.a("ShortStory-Reading-Setting");
        b = a2;
        b1 b1Var = b1.a;
        h = d1.d(b1Var.h());
        Object obj2 = null;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new a(1, null, 2, null), new a(2, null, 2, null), new a(3, null, 2, null), new a(4, null, 2, null), new a(5, n.d(p.a))});
        i = listOf;
        j = new LinkedHashSet();
        b1Var.A(kmpStoryReadingSettingManager, kmpStoryReadingSettingManager);
        int sa = c0.a.sa();
        j0 a3 = j0.Companion.a();
        switch (sa) {
            case 11:
                i2 = a3.a;
                break;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                i2 = a3.b;
                break;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                i2 = a3.c;
                break;
            case 14:
                i2 = a3.d;
                break;
            case 15:
                i2 = a3.e;
                break;
            case 16:
                i2 = a3.f;
                break;
            default:
                i2 = a3.g;
                break;
        }
        int i3 = a2.getInt("font_size", i2);
        List<Integer> list = ec4.p.Companion.a().e;
        d = list;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (((Number) obj).intValue() == i3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                }
            } else {
                obj = null;
            }
        }
        Integer num = (Integer) obj;
        if (num != null) {
            intValue = num.intValue();
        } else {
            intValue = ((Number) CollectionsKt___CollectionsKt.first((List) d)).intValue();
        }
        c = intValue;
        xn0.b bVar = b;
        p.b bVar2 = ec4.p.Companion;
        int i4 = bVar.getInt("line_space_mode", bVar2.a().a);
        List<k> list2 = bVar2.a().f;
        f = list2;
        Iterator<T> it4 = list2.iterator();
        while (true) {
            if (it4.hasNext()) {
                Object next = it4.next();
                if (((k) next).b == i4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    obj2 = next;
                }
            }
        }
        k kVar = (k) obj2;
        if (kVar == null) {
            kVar = new k("适中", KmpLineSpaceMode.MODE_STANDARD.getValue(), "标准");
        }
        e = kVar;
        g = b.getInt("last_light_theme", k0.Companion.a().a);
        k = 8;
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        j.add(bVar);
    }

    public final void k(b bVar) {
        TypeIntrinsics.asMutableCollection(j).remove(bVar);
    }

    public final void m(int i2) {
        c = i2;
        b.c("font_size", i2);
    }

    private final void p(int i2) {
        Iterator<T> it2 = j.iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).g(i2);
        }
    }

    public final void l(Map<String, String> map) {
        i.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KmpStoryReadingSettingManager$sendBroadcastWithTextLayoutChange$1(map, null), 3, null);
    }

    @Override // com.dragon.read.kmp.service.j1
    public void n(String themeStr) {
        int i2;
        Intrinsics.checkNotNullParameter(themeStr, "themeStr");
        if (Intrinsics.areEqual(themeStr, Theme.DARK.getResSuffix())) {
            h = true;
            i2 = 5;
        } else {
            h = false;
            i2 = g;
        }
        p(i2);
    }

    public final void o(k config) {
        Intrinsics.checkNotNullParameter(config, "config");
        e = config;
        b.c("line_space_mode", config.b);
    }

    public final void c(int i2) {
        if (i2 == i()) {
            return;
        }
        boolean z = h;
        q qVar = q.a;
        if (qVar.a(i2)) {
            h = true;
        } else {
            g = i2;
            b.c("last_light_theme", i2);
            h = false;
        }
        if (!z && !qVar.a(i2)) {
            p(i2);
        } else {
            b1.a.d();
        }
    }
}
