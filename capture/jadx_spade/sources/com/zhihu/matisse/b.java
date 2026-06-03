package com.zhihu.matisse;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.ui.MatisseActivity;
import fm6.c;
import fm6.d;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private final a a;
    private final com.zhihu.matisse.internal.entity.a b;

    static {
        Covode.recordClassIndex(656114);
    }

    public b b(boolean z) {
        this.b.t = z;
        return this;
    }

    public b c(boolean z) {
        this.b.f = z;
        return this;
    }

    public b f(fm6.b bVar) {
        this.b.r = bVar;
        return this;
    }

    public b g(c cVar) {
        this.b.p = cVar;
        return this;
    }

    public b h(d dVar) {
        this.b.q = dVar;
        return this;
    }

    public b i(boolean z) {
        this.b.c = z;
        return this;
    }

    public b j(int i) {
        if (i >= 1) {
            this.b.l = i;
            return this;
        }
        throw new IllegalArgumentException("spanCount cannot be less than 1");
    }

    public b a(zl6.a aVar) {
        com.zhihu.matisse.internal.entity.a aVar2 = this.b;
        if (aVar2.j == null) {
            aVar2.j = new ArrayList();
        }
        if (aVar != null) {
            this.b.j.add(aVar);
            return this;
        }
        throw new IllegalArgumentException("filter cannot be null");
    }

    public void d(int i) {
        Activity activity = this.a.getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) MatisseActivity.class);
        Fragment c = this.a.c();
        if (c != null) {
            c.startActivityForResult(intent, i);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public b e(int i) {
        if (i >= 1) {
            com.zhihu.matisse.internal.entity.a aVar = this.b;
            if (aVar.h <= 0 && aVar.i <= 0) {
                aVar.g = i;
                return this;
            }
            throw new IllegalStateException("already set maxImageSelectable and maxVideoSelectable");
        }
        throw new IllegalArgumentException("maxSelectable must be greater than or equal to one");
    }

    b(a aVar, Set<MimeType> set, boolean z) {
        this.a = aVar;
        com.zhihu.matisse.internal.entity.a a = com.zhihu.matisse.internal.entity.a.a();
        this.b = a;
        a.a = set;
        a.b = z;
        a.e = -1;
    }
}
