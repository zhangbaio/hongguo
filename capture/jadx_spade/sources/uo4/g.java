package uo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.report.ReportManager;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final a b;
    public static final int c;
    private final Args a = new Args();

    public static final class a {
        static {
            Covode.recordClassIndex(609135);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609134);
        b = new a(null);
        c = 8;
    }

    public final void c() {
        ReportManager.onReport("major_activity_entrance_show", this.a);
    }

    public final g a(Map<String, ? extends Serializable> map) {
        this.a.putAll(map);
        return this;
    }

    public final g d(String activityEntrance) {
        Intrinsics.checkNotNullParameter(activityEntrance, "activityEntrance");
        this.a.put("activity_entrance", activityEntrance);
        return this;
    }

    public final g e(String activityId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        this.a.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, activityId);
        return this;
    }

    public final g f(String activityName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.a.put("activity_name", activityName);
        return this;
    }

    public final g g(String tabName) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        this.a.put("tab_name", tabName);
        return this;
    }

    public final void b(String enterMethod) {
        Intrinsics.checkNotNullParameter(enterMethod, "enterMethod");
        ReportManager.onReport("major_activity_entrance_enter", new Args().putAll(this.a).put("enter_method", enterMethod));
    }
}
