package ds4;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static final ArrayList<a> b;
    public static final int c;

    private c() {
    }

    static {
        Covode.recordClassIndex(611981);
        a = new c();
        ArrayList<a> arrayList = new ArrayList<>();
        b = arrayList;
        arrayList.add(new b());
        arrayList.add(new d());
        c = 8;
    }

    public final void a(Activity activity, String schema, String str, Function2<? super Boolean, ? super String, Unit> function2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Uri parse = Uri.parse(schema);
        Iterator<a> it2 = b.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            a next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Intrinsics.checkNotNull(parse);
            if (next.a(activity, schema, parse, str, function2, jSONObject)) {
                return;
            }
        }
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, "unknown error");
        }
    }
}
