package yk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserRelationType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(608021);
    }

    public static final UserRelationType a(Integer num) {
        UserRelationType userRelationType = UserRelationType.None;
        int value = userRelationType.getValue();
        if (num != null && num.intValue() == value) {
            return UserRelationType.Follow;
        }
        int value2 = UserRelationType.Follow.getValue();
        if (num == null || num.intValue() != value2) {
            UserRelationType userRelationType2 = UserRelationType.Followed;
            int value3 = userRelationType2.getValue();
            if (num != null && num.intValue() == value3) {
                return UserRelationType.MutualFollow;
            }
            int value4 = UserRelationType.MutualFollow.getValue();
            if (num != null && num.intValue() == value4) {
                return userRelationType2;
            }
            return userRelationType;
        }
        return userRelationType;
    }
}
