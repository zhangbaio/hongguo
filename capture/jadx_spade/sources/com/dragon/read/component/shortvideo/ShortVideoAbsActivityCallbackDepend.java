package com.dragon.read.component.shortvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.depend.e;
import com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend;
import hy2.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortVideoAbsActivityCallbackDepend implements IAbsActivityCallbackDepend {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(598102);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public boolean overridePendingTransitionIntercept() {
        return e.b.a();
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void dispatchTouchEvent(MotionEvent motionEvent) {
        a.a.m(motionEvent);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityCreateEnd(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a.a.onActivityCreateEnd(activity);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityCreateStart(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a.a.h(activity);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a.a.onActivityDestroy(activity);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a.a.onActivityPause(activity);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a.a.onActivityResume(activity);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityDown(int i, KeyEvent keyEvent) {
        a.a.p(i, keyEvent);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityKeyUp(int i, KeyEvent keyEvent) {
        a.a.q(i, keyEvent);
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public void onActivityResult(int i, int i2, Intent intent) {
        a.a.s(i, i2, intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r4 = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(r4);
     */
    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityRequestPermissionsResult(int r3, java.lang.String[] r4, int[] r5) {
        /*
            r2 = this;
            hy2.a r0 = hy2.a.a
            if (r4 == 0) goto L14
            java.util.List r4 = kotlin.collections.ArraysKt.filterNotNull(r4)
            if (r4 == 0) goto L14
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r4 = r4.toArray(r1)
            java.lang.String[] r4 = (java.lang.String[]) r4
            goto L15
        L14:
            r4 = 0
        L15:
            r0.r(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.ShortVideoAbsActivityCallbackDepend.onActivityRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    @Override // com.dragon.read.component.shortvideo.depend.IAbsActivityCallbackDepend
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        return a.a.o(name, context, attrs);
    }
}
