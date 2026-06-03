package gk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ActorPickType;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(607791);
        a = new c();
    }

    private c() {
    }

    public final String a(Integer num) {
        int value = ActorPickType.Comment.getValue();
        if (num != null && num.intValue() == value) {
            return "评论";
        }
        int value2 = ActorPickType.Digg.getValue();
        if (num != null && num.intValue() == value2) {
            return "点赞";
        }
        int value3 = ActorPickType.Collect.getValue();
        if (num != null && num.intValue() == value3) {
            return "收藏";
        }
        return "";
    }

    public final String b(Integer num) {
        if (num != null && num.intValue() > 0) {
            long intValue = num.intValue() * 1000;
            long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds() - intValue;
            if (epochMilliseconds > 0 && epochMilliseconds < 259200000) {
                return com.dragon.read.kmp.utils.o.a.j(intValue);
            }
        }
        return null;
    }
}
