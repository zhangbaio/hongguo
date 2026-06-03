package gk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.l1;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface w extends v {
    String b();

    float d();

    List<com.dragon.read.rpc.kmp.community.model.k> f();

    boolean g();

    String getCoverUrl();

    String getTitleText();

    String getType();

    String getUserName();

    String h();

    int i();

    boolean j();

    int k();

    String m();

    boolean o();

    List<l1> q();

    int r();

    boolean s();

    jd4.b u();

    public static final class a {
        static {
            Covode.recordClassIndex(607812);
        }

        public static boolean a(w wVar) {
            return true;
        }

        public static String b(w wVar) {
            return "";
        }

        public static int d(w wVar) {
            return 0;
        }

        public static int e(w wVar) {
            return 0;
        }

        public static float f(w wVar) {
            return 0.7131474f;
        }

        public static List<l1> g(w wVar) {
            return null;
        }

        public static boolean i(w wVar) {
            return false;
        }

        public static boolean j(w wVar) {
            return false;
        }

        public static boolean k(w wVar) {
            return true;
        }

        public static List<com.dragon.read.rpc.kmp.community.model.k> c(w wVar) {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        public static String h(w wVar) {
            return wVar.getType();
        }
    }
}
