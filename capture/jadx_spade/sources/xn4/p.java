package xn4;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.compose.ui.graphics.e1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.share3.business.activity.ActivityShareBusinessMgr;
import com.dragon.read.component.biz.api.NsShareDepend;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.util.ColorUtils;
import com.dragon.read.util.PictureUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p implements zn4.b {
    public static final p a;

    static {
        Covode.recordClassIndex(608956);
        a = new p();
    }

    private p() {
    }

    @Override // zn4.b
    public un4.h g1(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(App.context().getResources(), i);
        if (decodeResource == null) {
            return null;
        }
        return new un4.h(androidx.compose.ui.graphics.j.c(decodeResource), null, 2, null);
    }

    private final String d6(Bitmap bitmap) {
        String str = "share_image_" + System.currentTimeMillis() + ".jpeg";
        String g = zq1.f.g();
        if (!zq1.f.j(bitmap, g, str)) {
            return null;
        }
        return g + '/' + str;
    }

    private final boolean u2(int i) {
        if ((Color.red(i) * 0.299d) + (Color.green(i) * 0.587d) + (Color.blue(i) * 0.114d) < 128.0d) {
            return true;
        }
        return false;
    }

    @Override // zn4.b
    public String J4(un4.h hVar) {
        Bitmap bitmap;
        Bitmap bitmap2;
        byte[] bArr;
        e1 e1Var;
        if (hVar == null || (e1Var = hVar.a) == null || (bitmap2 = androidx.compose.ui.graphics.j.b(e1Var)) == null) {
            if (hVar != null && (bArr = hVar.b) != null) {
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                return null;
            }
            bitmap2 = bitmap;
        }
        return d6(bitmap2);
    }

    @Override // zn4.b
    public un4.h K7(String base64) {
        Object m773constructorimpl;
        un4.h hVar;
        Intrinsics.checkNotNullParameter(base64, "base64");
        Object obj = null;
        try {
            Result.Companion companion = Result.Companion;
            Bitmap n = ActivityShareBusinessMgr.a.n(base64);
            if (n != null) {
                hVar = new un4.h(androidx.compose.ui.graphics.j.c(n), null, 2, null);
            } else {
                hVar = null;
            }
            m773constructorimpl = Result.m773constructorimpl(hVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m779isFailureimpl(m773constructorimpl)) {
            obj = m773constructorimpl;
        }
        return (un4.h) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R4(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l3(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O3(un4.c cVar, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "load image failed";
        }
        cVar.onFailure(message);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H2(un4.c cVar, Bitmap bitmap) {
        Intrinsics.checkNotNull(bitmap);
        cVar.a(new un4.h(androidx.compose.ui.graphics.j.c(bitmap), null, 2, null));
        return Unit.INSTANCE;
    }

    private final Bitmap I1(String str, vn4.d dVar) {
        Bitmap createQrCode;
        int i = dVar.c;
        Application context = App.context();
        Intrinsics.checkNotNullExpressionValue(context, "context(...)");
        int a2 = com.awesome.fqhybrid.util.t.a(i, context);
        if (a2 <= 0 || (createQrCode = NsShareDepend.IMPL.createQrCode(str, a2)) == null) {
            return null;
        }
        return y5(createQrCode, ColorUtils.parseRGBAColor(dVar.e, "#FFFFFF"), ColorUtils.parseRGBAColor(dVar.f, "#FFFFFF00"));
    }

    private final Bitmap j2(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), f, f, paint);
        return createBitmap;
    }

    @Override // zn4.b
    public un4.h createQrCode(String url, int i) {
        Intrinsics.checkNotNullParameter(url, "url");
        Bitmap createQrCode = NsShareDepend.IMPL.createQrCode(url, (int) UIUtils.dip2Px(App.context(), i));
        if (createQrCode == null) {
            return null;
        }
        return new un4.h(androidx.compose.ui.graphics.j.c(createQrCode), null, 2, null);
    }

    @Override // zn4.b
    public void x4(String url, final un4.c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Observable observable = PictureUtils.getBitmap(url).toObservable();
        final Function1 function1 = new Function1() { // from class: xn4.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H2;
                H2 = p.H2(un4.c.this, (Bitmap) obj);
                return H2;
            }
        };
        Consumer consumer = new Consumer() { // from class: xn4.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                p.l3(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: xn4.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit O3;
                O3 = p.O3(un4.c.this, (Throwable) obj);
                return O3;
            }
        };
        observable.subscribe(consumer, new Consumer() { // from class: xn4.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                p.R4(Function1.this, obj);
            }
        });
    }

    private final Bitmap y5(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        for (int i3 = 0; i3 < width; i3++) {
            int height = bitmap.getHeight();
            for (int i4 = 0; i4 < height; i4++) {
                if (u2(bitmap.getPixel(i3, i4))) {
                    bitmap.setPixel(i3, i4, i);
                } else {
                    bitmap.setPixel(i3, i4, i2);
                }
            }
        }
        return bitmap;
    }

    @Override // zn4.b
    public un4.h k9(String posterBase64, String qrCodeContent, vn4.d qrStyle) {
        Bitmap b5;
        Intrinsics.checkNotNullParameter(posterBase64, "posterBase64");
        Intrinsics.checkNotNullParameter(qrCodeContent, "qrCodeContent");
        Intrinsics.checkNotNullParameter(qrStyle, "qrStyle");
        Bitmap n = ActivityShareBusinessMgr.a.n(posterBase64);
        if (n == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            Bitmap I1 = I1(qrCodeContent, qrStyle);
            if (I1 != null && (b5 = b5(n, I1, qrStyle)) != null) {
                n = b5;
            }
            return new un4.h(androidx.compose.ui.graphics.j.c(n), null, 2, null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m773constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    private final Bitmap b5(Bitmap bitmap, Bitmap bitmap2, vn4.d dVar) {
        int i;
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtLeast3;
        int coerceAtLeast4;
        int coerceAtMost;
        int coerceAtMost2;
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap copy = bitmap.copy(config, true);
        Canvas canvas = new Canvas(copy);
        Integer num = dVar.d;
        if (num != null) {
            int intValue = num.intValue();
            Application context = App.context();
            Intrinsics.checkNotNullExpressionValue(context, "context(...)");
            i = com.awesome.fqhybrid.util.t.a(intValue, context);
        } else {
            i = 0;
        }
        int i2 = dVar.g;
        Application context2 = App.context();
        Intrinsics.checkNotNullExpressionValue(context2, "context(...)");
        float a2 = com.awesome.fqhybrid.util.t.a(i2, context2);
        if (a2 > 0.0f) {
            bitmap2 = j2(bitmap2, a2);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((copy.getWidth() - bitmap2.getWidth()) - d1.b(dVar.a), 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast((copy.getHeight() - bitmap2.getHeight()) - d1.b(dVar.b), 0);
        if (i > 0) {
            Paint paint = new Paint(1);
            paint.setColor(ColorUtils.parseRGBAColor(dVar.f, "#FFFFFF"));
            coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast - i, 0);
            coerceAtLeast4 = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast2 - i, 0);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(bitmap2.getWidth() + coerceAtLeast + i, copy.getWidth());
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(bitmap2.getHeight() + coerceAtLeast2 + i, copy.getHeight());
            canvas.drawRoundRect(new RectF(coerceAtLeast3, coerceAtLeast4, coerceAtMost, coerceAtMost2), a2, a2, paint);
        }
        canvas.drawBitmap(bitmap2, coerceAtLeast, coerceAtLeast2, (Paint) null);
        Intrinsics.checkNotNull(copy);
        return copy;
    }
}
