package fr3;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements tq3.a {
    static {
        Covode.recordClassIndex(598717);
    }

    @Override // tq3.a
    public List<String> R(SharedPreferences kvPrefers) {
        Intrinsics.checkNotNullParameter(kvPrefers, "kvPrefers");
        return null;
    }

    @Override // tq3.a
    public SharedPreferences getPrivate(Context context, String cacheId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(cacheId, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    @Override // tq3.a
    public SharedPreferences t4(Context context, String cacheId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(cacheId, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }
}
