package xk6;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static final String a;
    private static volatile long b;
    private static volatile String c;

    static {
        Covode.recordClassIndex(655865);
        a = a;
        b = -1L;
    }

    public static final String f() {
        File d = d();
        if (d != null) {
            return d.getAbsolutePath();
        }
        return null;
    }

    public static final boolean g() {
        return Intrinsics.areEqual("mounted", h());
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.File d() {
        /*
            boolean r0 = g()
            if (r0 == 0) goto Lf
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Lb
            goto L10
        Lb:
            r0 = move-exception
            r0.printStackTrace()
        Lf:
            r0 = 0
        L10:
            if (r0 != 0) goto L19
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r0 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            java.lang.String r1 = "/sdcard/"
            r0.<init>(r1)
        L19:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xk6.b.d():java.io.File");
    }

    public static final String h() {
        if (!TextUtils.isEmpty(c) && System.currentTimeMillis() - b < 5000) {
            return c;
        }
        try {
            b = System.currentTimeMillis();
            c = Environment.getExternalStorageState();
            return c;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(new PolarisFileWrapper(str));
    }

    public static final void b(File file) {
        if (file != null && !file.exists()) {
            try {
                file.mkdirs();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static final String e(Context context) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        sb.append("/Android/data/");
        if (context != null) {
            str = context.getPackageName();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append("/cache/");
        String sb2 = sb.toString();
        c(sb2);
        return sb2;
    }

    public static final boolean a(Pair<String, String> pair) {
        String component1 = pair.component1();
        String component2 = pair.component2();
        if (!TextUtils.isEmpty(component1) && !TextUtils.isEmpty(component2)) {
            try {
                Result.Companion companion = Result.Companion;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                Calendar nowCalendar = Calendar.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(nowCalendar, "nowCalendar");
                Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
                if (parse == null) {
                    return false;
                }
                nowCalendar.setTime(parse);
                Calendar beginCalendar = Calendar.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(beginCalendar, "beginCalendar");
                Date parse2 = simpleDateFormat.parse(component1);
                if (parse2 == null) {
                    return false;
                }
                beginCalendar.setTime(parse2);
                Calendar endCalendar = Calendar.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(endCalendar, "endCalendar");
                Date parse3 = simpleDateFormat.parse(component2);
                if (parse3 == null) {
                    return false;
                }
                endCalendar.setTime(parse3);
                if (!nowCalendar.after(beginCalendar)) {
                    return false;
                }
                if (!nowCalendar.before(endCalendar)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m776exceptionOrNullimpl(Result.m773constructorimpl(ResultKt.createFailure(th)));
            }
        }
        return false;
    }
}
