package com.dragon.read.kmp.service;

import android.app.Activity;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.basescale.AppScaleManager;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b1 {
    public static final b1 a;
    private static pu5.d b;
    private static AppScaleManager.a c;
    public static final int d;

    static {
        Covode.recordClassIndex(608891);
        a = new b1();
        d = 8;
    }

    private b1() {
    }

    public final int o() {
        return ScreenUtils.getScreenHeightDp();
    }

    public final int q() {
        return ScreenUtils.getScreenWidthDp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        Function0 function0;
        pu5.d dVar = b;
        if (dVar != null && (function0 = dVar.c) != null) {
            function0.invoke();
        }
    }

    public final float f() {
        return AppScaleManager.inst().getScaleTimes();
    }

    public final float g() {
        return com.dragon.read.base.basescale.a.a.b() / 100.0f;
    }

    public final float j() {
        return AppScaleManager.inst().getLatestScaleTimes();
    }

    public final void C() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            a0Var.U8();
        }
    }

    public final void d() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            a0Var.w1();
        }
    }

    public final int i() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.q7();
        }
        return 0;
    }

    public final float l() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.getNavigationBarHeight();
        }
        return 44.0f;
    }

    public final float m() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.O8();
        }
        return 0.0f;
    }

    public final int n() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.getScreenHeight();
        }
        return 0;
    }

    public final int p() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.getScreenWidth();
        }
        return 0;
    }

    public final float s() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.getStatusBarHeight();
        }
        return 44.0f;
    }

    public final boolean u() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.v();
        }
        return false;
    }

    public final boolean v() {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.h();
        }
        return false;
    }

    public final boolean w() {
        if (AppScaleManager.inst().getScaleSize() == AppScaleManager.inst().getSuperLargeFontScaleSize()) {
            return true;
        }
        return false;
    }

    public final Theme h() {
        String resSuffix;
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var == null || (resSuffix = a0Var.getTheme()) == null) {
            resSuffix = Theme.LIGHT.getResSuffix();
        }
        Theme r = r(resSuffix);
        if (r == null) {
            return Theme.LIGHT;
        }
        return r;
    }

    public final void B(Function0<Unit> function0) {
        pu5.d dVar;
        if (function0 != null && (dVar = b) != null) {
            dVar.f(function0);
        }
    }

    public final boolean t(Context context) {
        Activity currentVisibleActivity = ActivityRecordHelper.getCurrentVisibleActivity();
        if (currentVisibleActivity != null) {
            return ScreenUtils.isLandscape(currentVisibleActivity);
        }
        return false;
    }

    public final void D(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            a0Var.showToast(msg);
        }
    }

    public final float E(float f) {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.w0(f);
        }
        return 0.0f;
    }

    public final int e(float f) {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.a(f);
        }
        return 0;
    }

    public final int k(String colorDominate) {
        Intrinsics.checkNotNullParameter(colorDominate, "colorDominate");
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.getLightThemeColor(colorDominate);
        }
        return 16773871;
    }

    public final void x(int i) {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            a0Var.k2(i);
        }
    }

    public final float y(float f) {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.d(f);
        }
        return 0.0f;
    }

    public final int z(float f) {
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            return a0Var.K0(f);
        }
        return 0;
    }

    private final Theme r(String str) {
        Object obj;
        Iterator<E> it2 = Theme.getEntries().iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((Theme) obj).getResSuffix(), str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (Theme) obj;
    }

    public final void b(Function0<Unit> function0) {
        if (function0 == null) {
            return;
        }
        if (b == null) {
            b = new pu5.d((Function1) null, 1, (DefaultConstructorMarker) null);
        }
        if (c == null) {
            c = new AppScaleManager.a() { // from class: com.dragon.read.kmp.service.a1
                public final void a() {
                    b1.c();
                }
            };
        }
        pu5.d dVar = b;
        if (dVar != null) {
            dVar.d(function0);
        }
    }

    public final void A(j1 listener, i1 readerThemeChangeListener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(readerThemeChangeListener, "readerThemeChangeListener");
        a0 a0Var = (a0) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a0.class));
        if (a0Var != null) {
            a0Var.E1(listener, readerThemeChangeListener);
        }
    }
}
