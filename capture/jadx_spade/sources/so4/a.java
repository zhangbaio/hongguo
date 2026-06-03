package so4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.UgcCommentGroupType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609115);
        a = new a();
    }

    private a() {
    }

    private final String a(long j) {
        if (j >= 3600) {
            return (j / 3600) + "小时";
        }
        if (j >= 1800) {
            return (j / 60) + "分钟";
        }
        return "不足30分钟";
    }

    public final String b(long j, short s) {
        String str;
        String a2 = a(j);
        if (s == ((short) UgcCommentGroupType.Additional.getValue())) {
            str = "追评";
        } else {
            str = "点评";
        }
        return "阅读" + a2 + (char) 21518 + str;
    }
}
