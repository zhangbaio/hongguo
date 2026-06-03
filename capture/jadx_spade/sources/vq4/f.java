package vq4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.dragon.read.lib.community.depend.model.SaaSEmoticonData;
import io.reactivex.Single;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface f {
    Fragment a(String str, c cVar, boolean z);

    wq4.c b(Context context, c cVar);

    Single<SaaSEmoticonData> l(String str);

    void m(String str);

    Single<Integer> n(List<String> list);
}
