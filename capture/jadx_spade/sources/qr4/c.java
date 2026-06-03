package qr4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.local.KvCacheMgr;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static final SharedPreferences b;
    public static final int c;

    private c() {
    }

    static {
        Covode.recordClassIndex(611923);
        a = new c();
        b = KvCacheMgr.getPrivate(AppUtils.context(), "preference_db_migration");
        c = 8;
    }

    public final boolean b(String prefix, String str) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return b.getBoolean(a(prefix, str), false);
    }

    public final void c(String prefix, String str) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        SharedPreferences preferences = b;
        Intrinsics.checkNotNullExpressionValue(preferences, "preferences");
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean(a.a(prefix, str), true);
        edit.apply();
    }

    private final String a(String str, String str2) {
        boolean z;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return str + '_' + str2;
        }
        throw new IllegalArgumentException("DBMigrationMarker composeKey error, userId and bookId is empty");
    }
}
