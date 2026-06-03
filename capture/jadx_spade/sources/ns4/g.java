package ns4;

import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class g {
    static final LogHelper a;

    static {
        Covode.recordClassIndex(612416);
        a = new LogHelper("CoverExtendViewHelper");
    }

    static void a(View view, com.dragon.read.multigenre.factory.a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("setDataIfSameType(");
        sb.append(view);
        sb.append(", ");
        sb.append(aVar);
        sb.append(",");
        try {
            if (!(view instanceof ls4.a)) {
                sb.append("View不是V2类型, return, ");
                a.d(sb.toString(), new Object[0]);
            } else if (!(aVar instanceof com.dragon.read.multigenre.factory.b)) {
                sb.append("工厂不是V2类型, return, ");
                a.d(sb.toString(), new Object[0]);
            } else {
                ((ls4.a) view).setData(((com.dragon.read.multigenre.factory.b) aVar).b());
                a.d(sb.toString(), new Object[0]);
            }
        } catch (Throwable th) {
            try {
                sb.append("捕获异常, t=");
                sb.append(th);
                sb.append(".");
                a.d(sb.toString(), new Object[0]);
            } catch (Throwable th2) {
                a.d(sb.toString(), new Object[0]);
                throw th2;
            }
        }
    }
}
