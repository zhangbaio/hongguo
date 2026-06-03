package is4;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.util.ListUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.local.CacheWrapper;
import com.dragon.read.reader.util.JSONUtils;
import com.dragon.read.rpc.model.MessageType;
import com.dragon.read.rpc.model.SyncMsgBody;
import com.dragon.read.util.NumberUtils;
import com.ss.android.ugc.bytex.taskmonitor.proxy.MaybeDelegate;
import io.reactivex.Maybe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class n {
    private static final n b;
    private final SharedPreferences a = CacheWrapper.h(App.context(), "msg_config");

    public static n c() {
        return b;
    }

    static {
        Covode.recordClassIndex(612352);
        b = new n();
    }

    private n() {
    }

    public void n() {
        e.g().q();
        LogWrapper.info("SyncMsgBodyDispatcher", "拉取消息", new Object[0]);
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.TOAST_CASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.SNAPSHOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.YOUNG_TOAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.AD_SNAPSHOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SyncMsgBody g() {
        ArrayList arrayList = new ArrayList();
        List<SyncMsgBody> i = e.g().i(MessageType.TOAST_OPERATION);
        List<SyncMsgBody> i2 = e.g().i(MessageType.TOAST_GOLD);
        List<SyncMsgBody> i3 = e.g().i(MessageType.TOAST_CASH);
        if (!ListUtils.isEmpty(i)) {
            arrayList.add(i.get(i.size() - 1));
        }
        if (!ListUtils.isEmpty(i2)) {
            arrayList.add(i2.get(i2.size() - 1));
        }
        if (!ListUtils.isEmpty(i3)) {
            arrayList.add(i3.get(i3.size() - 1));
        }
        if (!ListUtils.isEmpty(arrayList)) {
            e.g().p(arrayList);
            return (SyncMsgBody) arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SyncMsgBody i(String str) throws Exception {
        return (SyncMsgBody) JSONUtils.fromJson(str, SyncMsgBody.class);
    }

    private boolean b(MessageType messageType) {
        if ((messageType == MessageType.AD_SNAPSHOT && i.a.g()) || messageType == MessageType.TOAST_CASH || messageType == MessageType.SNAPSHOT || messageType == MessageType.YOUNG_TOAST) {
            return true;
        }
        return false;
    }

    public boolean h(long j) {
        return this.a.getBoolean(j + "", false);
    }

    public void j(long j) {
        this.a.edit().putBoolean(j + "", true).apply();
    }

    public void k(MessageType messageType) {
        if (messageType == null) {
            return;
        }
        e.g().n(messageType);
        m(d(messageType), "");
    }

    public String d(MessageType messageType) {
        int i = a.a[messageType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return "";
                    }
                    return "key_ad_snapshot_msg_body";
                }
                return "key_teen_mode_msg_body";
            }
            return "key_snapshot_msg_body";
        }
        return "key_cash_msg_body";
    }

    public SyncMsgBody e(MessageType messageType) {
        if (messageType == null) {
            return null;
        }
        List<SyncMsgBody> i = e.g().i(messageType);
        if (ListUtils.isEmpty(i)) {
            return null;
        }
        SyncMsgBody syncMsgBody = i.get(i.size() - 1);
        if (syncMsgBody == null && b(messageType)) {
            return o(messageType);
        }
        return syncMsgBody;
    }

    public Maybe<SyncMsgBody> f(MessageType messageType) {
        SyncMsgBody syncMsgBody;
        List<SyncMsgBody> i = e.g().i(messageType);
        if (ListUtils.isEmpty(i)) {
            syncMsgBody = null;
        } else {
            syncMsgBody = i.get(i.size() - 1);
        }
        if (syncMsgBody == null && b(messageType)) {
            final String string = this.a.getString(d(messageType), "");
            return MaybeDelegate.fromCallable(new Callable() { // from class: is4.m
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    SyncMsgBody i2;
                    i2 = n.i(string);
                    return i2;
                }
            });
        }
        if (syncMsgBody == null) {
            return Maybe.empty();
        }
        return Maybe.just(syncMsgBody);
    }

    public SyncMsgBody o(MessageType messageType) {
        String d = d(messageType);
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        try {
            SyncMsgBody syncMsgBody = (SyncMsgBody) JSONUtils.fromJson(this.a.getString(d, ""), SyncMsgBody.class);
            if (syncMsgBody != null) {
                MessageType messageType2 = syncMsgBody.msgType;
                if (messageType2 == MessageType.YOUNG_TOAST) {
                    return syncMsgBody;
                }
                if (messageType2 == MessageType.AD_SNAPSHOT) {
                    JSONObject parseJSONObject = JSONUtils.parseJSONObject(syncMsgBody.extra);
                    if (parseJSONObject != null) {
                        long parse = NumberUtils.parse(parseJSONObject.optString("end_time"), 0L) * 1000;
                        if (parse > 0 && System.currentTimeMillis() > parse) {
                            return null;
                        }
                    }
                    return syncMsgBody;
                }
                if (NumberUtils.parse((String) syncMsgBody.content.get("expire_time"), 0L) * 1000 < System.currentTimeMillis()) {
                    k(messageType);
                    return null;
                }
            }
            return syncMsgBody;
        } catch (Exception unused) {
            LogWrapper.e("消息 syncMsgBody 解析失败", new Object[0]);
            return null;
        }
    }

    private void m(String str, String str2) {
        this.a.edit().putString(str, str2).apply();
    }

    public void l(List<SyncMsgBody> list, MessageType messageType) {
        SyncMsgBody syncMsgBody;
        Map map;
        if (!ListUtils.isEmpty(list) && (map = (syncMsgBody = list.get(list.size() - 1)).content) != null && !map.isEmpty() && b(messageType)) {
            String d = d(messageType);
            if (!TextUtils.isEmpty(d)) {
                m(d, JSONUtils.toJson(syncMsgBody));
            }
        }
    }
}
