package com.dragon.read.kmp.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import com.dragon.read.ui.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a extends FrameLayout implements e {
    public static final int a;

    static {
        Covode.recordClassIndex(609446);
        a = 8;
    }

    public void H8(float f) {
    }

    public abstract /* synthetic */ String getViewId();

    public boolean b() {
        return e.a.a(this);
    }

    public boolean onBackPressed() {
        d(true);
        return true;
    }

    protected final void e() {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this);
    }

    protected final NsReaderActivity getReaderActivity() {
        NsReaderActivity context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.dragon.read.component.biz.interfaces.NsReaderActivity");
        return context;
    }

    private final void a() {
        qr5.a m2;
        if (b() && (m2 = getReaderActivity().m2()) != null) {
            m2.a(this);
        }
    }

    public void Z4() {
        ViewGroup viewGroup;
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            g(viewGroup);
        }
    }

    public void d(boolean z) {
        f(z);
    }

    public void nf(boolean z) {
        d(z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void g(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        h(parent, null);
    }

    private final void c(ViewGroup viewGroup) {
        if (getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            viewGroup.addView(this, -1, layoutParams);
        }
    }

    private final void f(boolean z) {
        qr5.a m2;
        if (b() && (m2 = getReaderActivity().m2()) != null) {
            m2.k(z, this);
        }
    }

    public void h(ViewGroup parent, sm4.a aVar) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c(parent);
        a();
    }
}
