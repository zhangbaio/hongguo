package uo4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.App;
import com.dragon.read.base.ssconfig.template.SpringFestivalClient;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.report.PageRecorderUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final i a;
    private static final SharedPreferences b;
    public static final int c;

    private i() {
    }

    static {
        Covode.recordClassIndex(609136);
        a = new i();
        b = KvCacheMgr.getPrivate(App.context(), "spring_task_toast_record");
        c = 8;
    }

    private final String b() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final boolean e(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return !Intrinsics.areEqual(b(), date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, g gVar, View view) {
        NsCommonDepend.IMPL.appNavigator().openUrl(context, SpringFestivalClient.a.a().mainPageUrl, PageRecorderUtils.getParentPage(context));
        gVar.b("click");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x003b, code lost:
    
        r3 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r12, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(final android.content.Context r19, java.lang.String r20, boolean r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uo4.i.c(android.content.Context, java.lang.String, boolean, java.lang.String):void");
    }
}
