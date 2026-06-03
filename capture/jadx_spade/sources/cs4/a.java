package cs4;

import android.content.Context;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.minigame.bdpbase.util.MiniGameOutProcessPreload;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(611978);
        a = new a();
    }

    private a() {
    }

    private final boolean a(String str) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "ad_params", false, 2, (Object) null);
        return contains$default;
    }

    public final void c(String schema) {
        Context context;
        Intrinsics.checkNotNullParameter(schema, "schema");
        AppCommonContext appCommonContext = (AppCommonContext) ServiceManager.getService(AppCommonContext.class);
        if (appCommonContext != null && (context = appCommonContext.getContext()) != null && a(schema)) {
            b(context, schema);
        }
    }

    public final void d(List<String> schemaList) {
        String str;
        Intrinsics.checkNotNullParameter(schemaList, "schemaList");
        for (String str2 : schemaList) {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                str = parse.getHost();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "microgame")) {
                a.c(str2);
            }
        }
    }

    private final void b(Context context, String str) {
        try {
            Result.Companion companion = Result.Companion;
            MiniGameOutProcessPreload.getInstance().tryPreload(context, str);
            Result.m773constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m773constructorimpl(ResultKt.createFailure(th));
        }
    }
}
