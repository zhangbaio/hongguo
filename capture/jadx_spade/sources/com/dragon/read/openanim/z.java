package com.dragon.read.openanim;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.util.kotlin.UIKt;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.generic.RoundingParams;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z implements w {
    static {
        Covode.recordClassIndex(612647);
    }

    private final Pair<Integer, Integer> z0(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        decorView.getLocationOnScreen(iArr);
        decorView.getLocationInWindow(iArr2);
        return TuplesKt.to(Integer.valueOf(iArr[0] - iArr2[0]), Integer.valueOf(iArr[1] - iArr2[1]));
    }

    @Override // com.dragon.read.openanim.w
    public void W7(float f, float f2, float f3, float f4, float f5, String sceneKey, String str, String str2, byte[] bArr) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(sceneKey, "sceneKey");
        Activity currentVisibleActivity = ActivityRecordHelper.getCurrentVisibleActivity();
        if (currentVisibleActivity == null && (currentVisibleActivity = ActivityRecordHelper.getCurrentActivity()) == null) {
            return;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(f);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(f2);
        roundToInt3 = MathKt__MathJVMKt.roundToInt(f3);
        int max = Math.max(roundToInt + 1, roundToInt3);
        roundToInt4 = MathKt__MathJVMKt.roundToInt(f4);
        int max2 = Math.max(roundToInt2 + 1, roundToInt4);
        int max3 = Math.max(1, max - roundToInt);
        int max4 = Math.max(1, max2 - roundToInt2);
        Bitmap createBitmap = Bitmap.createBitmap(max3, max4, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(-roundToInt, -roundToInt2);
        currentVisibleActivity.getWindow().getDecorView().draw(canvas);
        RoundedBitmapDrawable roundedBitmapDrawable = new RoundedBitmapDrawable(currentVisibleActivity.getResources(), createBitmap);
        roundedBitmapDrawable.setBounds(0, 0, max3, max4);
        if (f5 > 0.0f) {
            roundedBitmapDrawable.setRadii(RoundingParams.fromCornersRadius(f5).getCornersRadii());
        }
        p pVar = new p(roundedBitmapDrawable);
        pVar.a.setBounds(0, 0, max3, max4);
        p pVar2 = new p(roundedBitmapDrawable);
        pVar2.a.setBounds(0, 0, max3, max4);
        f0 f0Var = new f0();
        f0Var.a = true;
        f0Var.l = true;
        f0Var.i = pVar;
        f0Var.j = pVar2;
        Pair<Integer, Integer> z0 = z0(currentVisibleActivity);
        Rect rect = new Rect(roundToInt + z0.getFirst().intValue(), roundToInt2 + z0.getSecond().intValue(), max + z0.getFirst().intValue(), max2 + z0.getSecond().intValue());
        BookOpenAnimTask bookOpenAnimTask = new BookOpenAnimTask(currentVisibleActivity, f0Var, rect, new Rect(rect), UIKt.getWindowBounds(currentVisibleActivity));
        bookOpenAnimTask.a(new q(currentVisibleActivity));
        m.k(bookOpenAnimTask);
    }
}
