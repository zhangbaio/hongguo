package lq4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class c<T> {
    public static final a e;
    public static final int f;
    public T a;
    public String b;
    protected SharedPreferences c;
    public boolean d;

    public static final class a {
        static {
            Covode.recordClassIndex(611288);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611287);
        e = new a(null);
        f = 8;
    }

    public String e() {
        return "未命名规则";
    }

    public Boolean f(String str) {
        return null;
    }

    public void g(boolean z) {
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public String toString() {
        return "unknown";
    }

    protected final SharedPreferences d() {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sp");
        return null;
    }

    public c(T t) {
        this.a = t;
    }

    protected final void j(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.c = sharedPreferences;
    }

    public final void c(SharedPreferences sp, boolean z) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        j(sp);
        g(z);
    }
}
