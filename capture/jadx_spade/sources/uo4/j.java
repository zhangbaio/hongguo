package uo4;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.ssconfig.template.CNYLynxLoadingBackgroundColorsConfig;
import com.dragon.read.pages.bookmall.place.PlaceUtilsKt;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final j a;

    static {
        Covode.recordClassIndex(609137);
        a = new j();
    }

    private j() {
    }

    public final void a(View view) {
        int[] intArray;
        float[] floatArray;
        float[] fArr;
        String[] strArr;
        int[] intArray2;
        if (view == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        boolean b = CNYLynxLoadingBackgroundColorsConfig.a.b();
        String[] stringArray = App.context().getResources().getStringArray(2130968587);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        ArrayList arrayList = new ArrayList(stringArray.length);
        for (String str : stringArray) {
            Intrinsics.checkNotNull(str);
            arrayList.add(Integer.valueOf(Color.parseColor(str)));
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        if (b && (strArr = CNYLynxLoadingBackgroundColorsConfig.a.a().colors) != null) {
            ArrayList arrayList2 = new ArrayList(strArr.length);
            for (String str2 : strArr) {
                arrayList2.add(Integer.valueOf(Color.parseColor(str2)));
            }
            intArray2 = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
            if (intArray2 != null) {
                intArray = intArray2;
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            String[] stringArray2 = App.context().getResources().getStringArray(2130968588);
            Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
            ArrayList arrayList3 = new ArrayList(stringArray2.length);
            for (String str3 : stringArray2) {
                Intrinsics.checkNotNull(str3);
                arrayList3.add(Float.valueOf(Float.parseFloat(str3)));
            }
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList3);
            if (b && (fArr = CNYLynxLoadingBackgroundColorsConfig.a.a().locations) != null) {
                floatArray = fArr;
            }
            gradientDrawable.setColors(intArray, floatArray);
        } else {
            gradientDrawable.setColors(intArray);
        }
        view.setBackground(gradientDrawable);
        PlaceUtilsKt.updateMargin(view, 0, 0, 0, 0);
    }
}
