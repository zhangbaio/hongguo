package yq4;

import com.dragon.read.lib.community.depend.model.SaaSEmoticonData;
import io.reactivex.Single;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface n {
    Single<SaaSEmoticonData> a(int i, String str);

    l b();

    Single<SaaSEmoticonData> l(String str);

    void m(String str);

    Single<Integer> n(List<String> list);

    Single<SaaSEmoticonData> p(String str, String str2, int i, int i2);
}
