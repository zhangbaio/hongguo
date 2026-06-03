package vq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.lib.community.depend.model.SaaSEmoticonData;
import io.reactivex.Single;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface e {
    Single<SaaSEmoticonData> a(int i, String str);

    Single<SaaSEmoticonData> p(String str, String str2, int i, int i2);

    public static final class a {
        static {
            Covode.recordClassIndex(611337);
        }

        public static /* synthetic */ Single a(e eVar, String str, String str2, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    i = 0;
                }
                if ((i3 & 8) != 0) {
                    i2 = 99;
                }
                return eVar.p(str, str2, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGifPanelData");
        }
    }
}
