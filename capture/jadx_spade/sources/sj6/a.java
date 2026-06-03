package sj6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a {
    String getMainScene();

    String getScene();

    String getSubScene();

    /* renamed from: sj6.a$a, reason: collision with other inner class name */
    public static final class C0262a {
        static {
            Covode.recordClassIndex(654049);
        }

        public static String a(a aVar) {
            return aVar.getMainScene() + "." + aVar.getSubScene();
        }
    }
}
