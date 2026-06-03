package is4;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.b0;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import com.dragon.read.msg.MsgLocation;
import com.dragon.read.rpc.model.MessageType;
import com.dragon.read.rpc.model.SyncMsgBody;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b {
    private LogHelper a = new LogHelper("MsgLocations");
    private final Map<Class<?>, String[]> b = new HashMap();

    static {
        Covode.recordClassIndex(612345);
    }

    public static b d() {
        return a.a;
    }

    private interface a {
        public static final b a;

        static {
            Covode.recordClassIndex(612346);
            a = new b();
        }
    }

    public b() {
        g(NsReaderServiceApi.IMPL.readerInitService().a(), "reader");
    }

    public void f(long j) {
        b0.C().S(j);
    }

    public boolean c(long j) {
        if (j > b0.C().h()) {
            return true;
        }
        return false;
    }

    public void e(SyncMsgBody syncMsgBody) {
        if (syncMsgBody.msgType == MessageType.AD_SNAPSHOT && i.a.f()) {
            b0.C().O(syncMsgBody.msgId);
        } else {
            f(syncMsgBody.msgId);
        }
    }

    public boolean a(SyncMsgBody syncMsgBody) {
        if (syncMsgBody.msgType == MessageType.AD_SNAPSHOT && i.a.f()) {
            if (syncMsgBody.msgId > b0.C().g()) {
                return true;
            }
            return false;
        }
        return c(syncMsgBody.msgId);
    }

    public void g(Class<?> cls, String... strArr) {
        if (Fragment.class.isAssignableFrom(cls) && android.app.Fragment.class.isAssignableFrom(cls) && Activity.class.isAssignableFrom(cls)) {
            this.a.e("[registerLocation] page must be fragment or activity", new Object[0]);
        } else {
            this.b.put(cls, strArr);
        }
    }

    public boolean b(String str, Object obj) {
        String[] strArr;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!(obj instanceof Fragment) && !(obj instanceof android.app.Fragment) && !(obj instanceof Activity)) {
            this.a.e("[checkLocation] page must be fragment or activity", new Object[0]);
            return false;
        }
        LogWrapper.d("required screen ad position is %s, currentPage is %s.", new Object[]{str, obj.getClass().getSimpleName()});
        MsgLocation msgLocation = (MsgLocation) obj.getClass().getAnnotation(MsgLocation.class);
        if (obj instanceof is4.a) {
            strArr = (String[]) ((is4.a) obj).Wa().toArray(new String[0]);
        } else if (msgLocation != null) {
            strArr = msgLocation.value();
        } else {
            strArr = this.b.get(obj.getClass());
        }
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
