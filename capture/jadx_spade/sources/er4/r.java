package er4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.DateCacheModel;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    static {
        Covode.recordClassIndex(611463);
    }

    public static final String a() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final <T extends Serializable> boolean b(DateCacheModel<T> dateCacheModel) {
        if (dateCacheModel != null && !Intrinsics.areEqual(a(), dateCacheModel.getDate())) {
            return true;
        }
        return false;
    }
}
