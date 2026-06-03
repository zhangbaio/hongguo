package com.zhihu.matisse;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import java.lang.ref.WeakReference;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private final WeakReference<Activity> a;
    private final WeakReference<Fragment> b;

    static {
        Covode.recordClassIndex(656112);
    }

    Fragment c() {
        WeakReference<Fragment> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    Activity getActivity() {
        return this.a.get();
    }

    private a(Activity activity) {
        this(activity, null);
    }

    public static a b(Activity activity) {
        return new a(activity);
    }

    public b a(Set<MimeType> set, boolean z) {
        return new b(this, set, z);
    }

    private a(Activity activity, Fragment fragment) {
        this.a = new WeakReference<>(activity);
        this.b = new WeakReference<>(fragment);
    }
}
