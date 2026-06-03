package ro4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609114);
        a = new a();
    }

    private a() {
    }

    public final String a(String str) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "";
        }
        wi4.a aVar = wi4.a.a;
        String e = aVar.e(str, "topicId");
        if (e != null && e.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return e;
        }
        String e2 = aVar.e(str, "topic_id");
        if (e2 == null || e2.length() == 0) {
            z3 = true;
        }
        if (z3) {
            return "";
        }
        return e2;
    }

    public final boolean b(String str) {
        boolean z;
        boolean z2;
        boolean z3;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        wi4.a aVar = wi4.a.a;
        String e = aVar.e(str, "topicId");
        if (e != null && e.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return true;
        }
        String e2 = aVar.e(str, "topic_id");
        if (e2 != null && e2.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            return false;
        }
        return true;
    }
}
