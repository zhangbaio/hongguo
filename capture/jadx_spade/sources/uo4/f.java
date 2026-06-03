package uo4;

import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.SpringFestivalClient;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;

    static {
        Covode.recordClassIndex(609133);
        a = new f();
    }

    private f() {
    }

    private final boolean a(String str) {
        boolean z;
        boolean contains$default;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        String decode = Uri.decode(str);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) decode, (CharSequence) SpringFestivalClient.a.a().festivalLynxSchemaContainsKey, false, 2, (Object) null);
        return contains$default;
    }

    private final void c(String str, Map<String, ? extends Serializable> map) {
        new g().d(str).f("novel_activity_cards26").e("chunjie_2026").a(map).c();
    }

    public final void f(String str, String activityEntrance, Map<String, ? extends Serializable> map) {
        Intrinsics.checkNotNullParameter(activityEntrance, "activityEntrance");
        if (a(str)) {
            c(activityEntrance, map);
        }
    }

    private final void b(String str, String str2, Map<String, ? extends Serializable> map) {
        new g().d(str).f("novel_activity_cards26").e("chunjie_2026").a(map).b(str2);
    }

    public final void d(String str, String activityEntrance, String enterMethod, Map<String, ? extends Serializable> map) {
        Intrinsics.checkNotNullParameter(activityEntrance, "activityEntrance");
        Intrinsics.checkNotNullParameter(enterMethod, "enterMethod");
        if (a(str)) {
            b(activityEntrance, enterMethod, map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(f fVar, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        fVar.f(str, str2, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(f fVar, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        fVar.d(str, str2, str3, map);
    }
}
