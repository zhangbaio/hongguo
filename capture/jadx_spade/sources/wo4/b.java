package wo4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.a8;
import com.bytedance.kmp.reading.model.om0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tb4.l;
import ym4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements l {
    static {
        Covode.recordClassIndex(609143);
    }

    public void notifyUserRelationChange(String userId, int i) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        xo4.a.a.a(userId, i);
    }

    public void P1(om0 videoData, k kVar, Context context) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        xo4.a.a.g(videoData, kVar, context);
    }

    public void f4(om0 videoData, k kVar, Context context) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        xo4.a.a.d(videoData, kVar, context);
    }

    public void v4(om0 videoData, k kVar, Context context) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        xo4.a.a.f(videoData, kVar, context);
    }

    public void T3(String seriesId, k kVar, Context context, List<om0> curDataList) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(curDataList, "curDataList");
        xo4.a.a.c(seriesId, kVar, context, curDataList);
    }

    public void Z5(String postId, String userId, Context context, k kVar) {
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        xo4.a.a.b(postId, userId, context, kVar);
    }

    public void N1(String seriesId, String str, int i, k kVar, Context context) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        xo4.a.a.e(seriesId, str, i, kVar, context);
    }

    public void T5(om0 videoData, k kVar, a8 a8Var, Context context, String str) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        xo4.a.a.h(videoData, kVar, a8Var, context, str);
    }
}
