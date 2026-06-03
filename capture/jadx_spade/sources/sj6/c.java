package sj6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import tj6.l;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    static {
        Covode.recordClassIndex(654052);
    }

    public static final b i(a aVar) {
        if (aVar instanceof b) {
            return (b) aVar;
        }
        return new l(aVar, (String) null);
    }

    public static final String e(a aVar) {
        return aVar.getMainScene() + "." + aVar.getSubScene();
    }

    public static final String d(b bVar) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.getScene());
        if (bVar.getSceneMatchKey() != null) {
            str = '(' + bVar.getSceneMatchKey() + ')';
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public static final l b(a aVar, String str) {
        if (aVar instanceof b) {
            return new l(aVar, str, ((b) aVar).getSceneMatchKey());
        }
        return new l(aVar, str, null);
    }

    public static final boolean h(String str, String str2) {
        if (!Intrinsics.areEqual(str, str2) && !Intrinsics.areEqual(str, "*") && !Intrinsics.areEqual(str2, "*")) {
            return false;
        }
        return true;
    }

    public static final b a(b bVar, b bVar2) {
        String c = c(bVar.getMainScene(), bVar2.getMainScene());
        String str = "";
        if (c == null) {
            c = "";
        }
        String c2 = c(bVar.getSubScene(), bVar2.getSubScene());
        if (c2 != null) {
            str = c2;
        }
        return new l(c, str, c(bVar.getDetailScene(), bVar2.getDetailScene()), c(bVar.getSceneMatchKey(), bVar2.getSceneMatchKey()));
    }

    private static final String c(String str, String str2) {
        if (Intrinsics.areEqual(str, "*") && Intrinsics.areEqual(str2, "*")) {
            return null;
        }
        if (!Intrinsics.areEqual(str, "*")) {
            if (!Intrinsics.areEqual(str2, "*")) {
                if ((str != null && str2 != null) || str != null) {
                    return str;
                }
            } else {
                return str;
            }
        }
        return str2;
    }

    public static final boolean f(b bVar, b bVar2, int i) {
        if (bVar2 == null) {
            return false;
        }
        boolean z = true;
        if (i >= 1 && !(z = h(bVar.getMainScene(), bVar2.getMainScene()))) {
            return false;
        }
        if (i >= 2 && !(z = h(bVar.getSubScene(), bVar2.getSubScene()))) {
            return false;
        }
        if (i >= 3 && !(z = h(bVar.getDetailScene(), bVar2.getDetailScene()))) {
            return false;
        }
        if (i >= 4 && !(z = h(bVar.getSceneMatchKey(), bVar2.getSceneMatchKey()))) {
            return false;
        }
        return z;
    }

    public static /* synthetic */ boolean g(b bVar, b bVar2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        return f(bVar, bVar2, i);
    }
}
