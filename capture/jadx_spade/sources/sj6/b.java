package sj6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface b extends sj6.a {
    String getDetailScene();

    @Override // sj6.a
    String getScene();

    String getSceneMatchKey();

    public static final class a {
        static {
            Covode.recordClassIndex(654051);
        }

        public static String a(b bVar) {
            return null;
        }

        public static String c(b bVar) {
            return null;
        }

        public static String b(b bVar) {
            boolean z;
            String detailScene = bVar.getDetailScene();
            if (detailScene != null && detailScene.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return c.e(bVar);
            }
            return c.e(bVar) + "." + bVar.getDetailScene();
        }
    }
}
