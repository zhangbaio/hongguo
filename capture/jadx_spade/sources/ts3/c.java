package ts3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final a a;

    static {
        Covode.recordClassIndex(599074);
        a = new a(null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(599075);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(List<? extends SecondaryInfo> list) {
            String json;
            if (list == null) {
                json = "";
            } else {
                try {
                    json = JSONUtils.toJson(list);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
            Intrinsics.checkNotNull(json);
            return json;
        }

        public final <T> String b(List<? extends T> list) {
            String json;
            if (list == null) {
                json = "";
            } else {
                try {
                    json = JSONUtils.toJson(list);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
            Intrinsics.checkNotNull(json);
            return json;
        }
    }
}
