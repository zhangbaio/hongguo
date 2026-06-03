package kr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.i7;
import java.util.Date;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c {
    static {
        Covode.recordClassIndex(611540);
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return i7.b(date, "yyyy-MM-dd");
        } catch (Exception e) {
            LogWrapper.error("DateConverter", "dateToTimestamp error: %1s", new Object[]{e});
            return null;
        }
    }

    public static Date b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return i7.G(str, "yyyy-MM-dd");
        } catch (Exception e) {
            LogWrapper.error("DateConverter", "fromTimestamp error: %1s", new Object[]{e});
            return null;
        }
    }
}
