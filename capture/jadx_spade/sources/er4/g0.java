package er4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 {
    static {
        Covode.recordClassIndex(611481);
    }

    public static final int c(SharedPreferences sharedPreferences, String key) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        int i = sharedPreferences.getInt(key, 0) + 1;
        sharedPreferences.edit().putInt(key, i).apply();
        return i;
    }

    public static final void a(SharedPreferences sharedPreferences, String key, boolean z) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        sharedPreferences.edit().putBoolean(key, z).apply();
    }

    public static final void b(SharedPreferences sharedPreferences, String key, int i) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        sharedPreferences.edit().putInt(key, i).apply();
    }

    public static final void d(SharedPreferences sharedPreferences, String key, long j) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        sharedPreferences.edit().putLong(key, j).apply();
    }

    public static final void e(SharedPreferences sharedPreferences, String key, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        sharedPreferences.edit().putString(key, str).apply();
    }
}
