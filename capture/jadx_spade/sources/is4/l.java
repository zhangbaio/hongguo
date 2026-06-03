package is4;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.App;
import com.dragon.read.base.util.DateUtils;
import com.dragon.read.base.util.LogModule;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.rpc.model.MessageType;
import com.dragon.read.rpc.model.SyncMsgBody;
import com.ss.android.ugc.bytex.taskmonitor.proxy.SingleDelegate;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class l {
    private SyncMsgBody a;
    private volatile SyncMsgBody b;
    private boolean c;

    static {
        Covode.recordClassIndex(612350);
    }

    public static l f() {
        return b.a;
    }

    interface b {
        public static final l a;

        static {
            Covode.recordClassIndex(612351);
            a = new l();
        }
    }

    private l() {
        this.b = null;
        this.c = true;
    }

    public void m() {
        if (this.c) {
            this.c = false;
        } else {
            this.c = true;
        }
    }

    public Single<SyncMsgBody> e() {
        return SingleDelegate.create(new SingleOnSubscribe() { // from class: is4.k
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                l.this.h(singleEmitter);
            }
        }).subscribeOn(Schedulers.io());
    }

    public void j() {
        LogWrapper.info(LogModule.dialogQueue("ScreenAdDialog"), "ScreenAdDialog弹窗已经展示, 清除数据", new Object[0]);
        SyncMsgBody syncMsgBody = this.a;
        if (syncMsgBody != null) {
            n.c().k(syncMsgBody.msgType);
            is4.b.d().e(syncMsgBody);
            i.a.j(syncMsgBody.msgType);
        }
        this.a = null;
    }

    public void d() {
        String format = DateUtils.format(new Date(NsCommonDepend.IMPL.acctManager().currentTimeMillis()), "yyyy-MM-dd");
        this.b = null;
        KvCacheMgr.getPublic(App.context(), "screen_ad_dialog_data_namespace").edit().putString("homepage_delay_show_cache_key" + format, "").apply();
    }

    private void k() {
        ObjectInputStream objectInputStream;
        String format = DateUtils.format(new Date(NsCommonDepend.IMPL.acctManager().currentTimeMillis()), "yyyy-MM-dd");
        String string = KvCacheMgr.getPublic(App.context(), "screen_ad_dialog_data_namespace").getString("homepage_delay_show_cache_key" + format, "");
        if (string != null && !string.isEmpty()) {
            ObjectInputStream objectInputStream2 = null;
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(com.dragon.read.util.l.a(string, 0)));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                SyncMsgBody syncMsgBody = (SyncMsgBody) objectInputStream.readObject();
                if (syncMsgBody != null) {
                    LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "读取存储的SycMsgBody成功:%s", new Object[]{Long.valueOf(syncMsgBody.msgId)});
                    this.b = syncMsgBody;
                }
                try {
                    objectInputStream.close();
                    return;
                } catch (IOException e2) {
                    e = e2;
                    LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "in关闭异常:%s", new Object[]{e.toString()});
                    e.printStackTrace();
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                objectInputStream2 = objectInputStream;
                LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "读取SycMsgBody异常:%s", new Object[]{e.toString()});
                e.printStackTrace();
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                        return;
                    } catch (IOException e4) {
                        e = e4;
                        LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "in关闭异常:%s", new Object[]{e.toString()});
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e5) {
                        LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "in关闭异常:%s", new Object[]{e5.toString()});
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "存储的SycMsgBody字符串数据为空", new Object[0]);
    }

    public SyncMsgBody g() {
        LogWrapper.info("ScreenAdDialog", "start get latest addata", new Object[0]);
        this.a = null;
        String str = "get ad_snapshot is null";
        String str2 = "get snapshot is null";
        if (this.c) {
            LogWrapper.info("ScreenAdDialog", "snapshot first", new Object[0]);
            if (this.a == null) {
                SyncMsgBody e = n.c().e(MessageType.SNAPSHOT);
                this.a = e;
                if (e != null) {
                    str2 = "get snapshot not null,msgId:" + this.a.msgId;
                }
                LogWrapper.info("ScreenAdDialog", str2, new Object[0]);
            }
            if (this.a == null) {
                n c = n.c();
                MessageType messageType = MessageType.AD_SNAPSHOT;
                SyncMsgBody e2 = c.e(messageType);
                this.a = e2;
                if (e2 == null && i.a.g()) {
                    this.a = n.c().o(messageType);
                }
                if (this.a != null) {
                    str = "get ad_snapshot not null,msgId:" + this.a.msgId;
                }
                LogWrapper.info("ScreenAdDialog", str, new Object[0]);
            }
        } else {
            LogWrapper.info("ScreenAdDialog", "ad_snapshot first", new Object[0]);
            if (this.a == null) {
                n c2 = n.c();
                MessageType messageType2 = MessageType.AD_SNAPSHOT;
                SyncMsgBody e3 = c2.e(messageType2);
                this.a = e3;
                if (e3 == null && i.a.g()) {
                    this.a = n.c().o(messageType2);
                }
                if (this.a != null) {
                    str = "get ad_snapshot not null,msgId:" + this.a.msgId;
                }
                LogWrapper.info("ScreenAdDialog", str, new Object[0]);
            }
            if (this.a == null) {
                SyncMsgBody e4 = n.c().e(MessageType.SNAPSHOT);
                this.a = e4;
                if (e4 != null) {
                    str2 = "get snapshot not null,msgId:" + this.a.msgId;
                }
                LogWrapper.info("ScreenAdDialog", str2, new Object[0]);
            }
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(SingleEmitter singleEmitter) throws Exception {
        if (this.b != null) {
            singleEmitter.onSuccess(this.b);
        } else {
            k();
            singleEmitter.onSuccess(this.b);
        }
    }

    public boolean c(Object obj) {
        String str;
        boolean z;
        SyncMsgBody g = g();
        if (g != null) {
            Map map = g.content;
            if (map != null) {
                str = (String) map.get("location");
            } else {
                str = "";
            }
            int i = 2;
            LogWrapper.d("required screen ad position is %s, currentPage is %s.", new Object[]{str, obj.getClass().getSimpleName()});
            boolean b2 = is4.b.d().b(str, obj);
            boolean a2 = is4.b.d().a(g);
            if (b2 && a2) {
                z = true;
            } else {
                z = false;
            }
            LogWrapper.info("ScreenAdDialog", "canShowScreenAd: ret:%b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                if (!b2) {
                    i iVar = i.a;
                    MessageType messageType = g.msgType;
                    if (TextUtils.isEmpty(str)) {
                        i = 1;
                    }
                    iVar.q(messageType, i);
                } else {
                    i.a.q(g.msgType, 5);
                }
            }
            return z;
        }
        i.a.q(null, -1);
        LogWrapper.info("ScreenAdDialog", "latestAddata null canShowScreenAd: ret:false", new Object[0]);
        return false;
    }

    public void l(final SyncMsgBody syncMsgBody) {
        LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "收到最新的活动运营弹窗数据:%s", new Object[]{Long.valueOf(syncMsgBody.msgId)});
        if (this.b != null) {
            long j = this.b.msgId;
            long j2 = syncMsgBody.msgId;
            if (j == j2) {
                LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "与已经记录的活动运营弹窗数据相同，跳过存储:%s", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.b = syncMsgBody;
        LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "准备持久化SyncMsgBody:%s", new Object[]{Long.valueOf(syncMsgBody.msgId)});
        SingleDelegate.create(new SingleOnSubscribe() { // from class: is4.j
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                l.i(byteArrayOutputStream, syncMsgBody, singleEmitter);
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(ByteArrayOutputStream byteArrayOutputStream, SyncMsgBody syncMsgBody, SingleEmitter singleEmitter) throws Exception {
        try {
            try {
                String format = DateUtils.format(new Date(NsCommonDepend.IMPL.acctManager().currentTimeMillis()), "yyyy-MM-dd");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(syncMsgBody);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                KvCacheMgr.getPublic(App.context(), "screen_ad_dialog_data_namespace").edit().putString("homepage_delay_show_cache_key" + format, com.dragon.read.util.l.f(byteArray, 0)).apply();
                singleEmitter.onSuccess(Boolean.TRUE);
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "关闭bos异常:%s", new Object[]{e.toString()});
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "写入SycMsgBody异常:%s", new Object[]{e2.toString()});
                e2.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "关闭bos异常:%s", new Object[]{e3.toString()});
                    e3.printStackTrace();
                }
                singleEmitter.onSuccess(Boolean.FALSE);
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                LogWrapper.info("AD_DIALOG_POPUP | DIALOG_POP_UP", "关闭bos异常:%s", new Object[]{e4.toString()});
                e4.printStackTrace();
            }
            throw th;
        }
    }
}
