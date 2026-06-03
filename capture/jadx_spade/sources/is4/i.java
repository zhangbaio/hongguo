package is4;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.AppLifecycleMonitor;
import com.dragon.read.base.Args;
import com.dragon.read.base.ssconfig.model.InsertScreenMsgOpt;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.MessageType;
import com.dragon.read.rpc.model.SyncData;
import com.dragon.read.rpc.model.SyncParam;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final i a;
    private static final Lazy b;
    private static final Lazy c;
    private static final Lazy d;
    private static int e;
    private static int f;
    public static final int g;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d() {
        return !InsertScreenMsgOpt.a.a().enable;
    }

    private final boolean e() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o() {
        return InsertScreenMsgOpt.a.a().optimize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p() {
        return InsertScreenMsgOpt.a.a().serialize;
    }

    public final boolean f() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Covode.recordClassIndex(612349);
        a = new i();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: is4.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean d2;
                d2 = i.d();
                return Boolean.valueOf(d2);
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: is4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean o;
                o = i.o();
                return Boolean.valueOf(o);
            }
        });
        c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: is4.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean p;
                p = i.p();
                return Boolean.valueOf(p);
            }
        });
        d = lazy3;
        e = -1;
        f = -1;
        g = 8;
    }

    public final void j(MessageType msgType) {
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        if (e()) {
            return;
        }
        q(null, -1);
        Args args = new Args();
        args.put("type", Integer.valueOf(msgType.getValue()));
        args.put("code", 0);
        args.put("tabName", NsCommonDepend.IMPL.getMainFragmentCurrentTab().name());
        Activity currentActivity = ActivityRecordManager.inst().getCurrentActivity();
        if (currentActivity != null) {
            args.put("activity", Reflection.getOrCreateKotlinClass(currentActivity.getClass()).getSimpleName());
        }
        ReportManager.onReport("insert_screen_message_show", args);
    }

    public final void m(int i) {
        if (e()) {
            return;
        }
        Args args = new Args();
        args.put("errCode", 0);
        args.put("respCode", 0);
        args.put("inbackground", Integer.valueOf(!AppLifecycleMonitor.getInstance().isForeground() ? 1 : 0));
        args.put("msgCount", Integer.valueOf(i));
        ReportManager.onReport("insert_screen_message_sync", args);
    }

    public final void q(MessageType messageType, int i) {
        int i2;
        if (messageType != null) {
            i2 = messageType.getValue();
        } else {
            i2 = -1;
        }
        e = i2;
        f = i;
    }

    public final void l(MessageType msgType, int i) {
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        if (e()) {
            return;
        }
        Args args = new Args();
        args.put("type", Integer.valueOf(msgType.getValue()));
        args.put("msgCount", Integer.valueOf(i));
        ReportManager.onReport("insert_screen_message_send", args);
    }

    public final void k(Integer num, int i) {
        int i2;
        if (e()) {
            return;
        }
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = e;
        }
        if (i < 0) {
            i = f;
        }
        if (i == 4 && NsAdApi.IMPL.isTopViewSplashing()) {
            i = 3;
        }
        if (i2 < 0 && i < 0) {
            return;
        }
        Args args = new Args();
        args.put("type", Integer.valueOf(i2));
        args.put("code", Integer.valueOf(i));
        ReportManager.onReport("insert_screen_message_show", args);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r6 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(com.dragon.read.rpc.model.MsgApiERR r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            boolean r0 = r4.e()
            if (r0 == 0) goto L7
            return
        L7:
            com.dragon.read.base.Args r0 = new com.dragon.read.base.Args
            r0.<init>()
            r1 = -1
            java.lang.String r2 = "errCode"
            if (r6 == 0) goto L2f
            boolean r3 = r6 instanceof com.dragon.read.base.http.exception.ErrorCodeException
            if (r3 == 0) goto L24
            com.dragon.read.base.http.exception.ErrorCodeException r6 = (com.dragon.read.base.http.exception.ErrorCodeException) r6
            int r6 = r6.getCode()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.dragon.read.base.Args r6 = r0.put(r2, r6)
            goto L2d
        L24:
            r6 = -2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.dragon.read.base.Args r6 = r0.put(r2, r6)
        L2d:
            if (r6 != 0) goto L36
        L2f:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r0.put(r2, r6)
        L36:
            r6 = 1
            java.lang.String r2 = "respCode"
            if (r5 == 0) goto L54
            int r3 = r5.getValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r2, r3)
            com.dragon.read.rpc.model.MsgApiERR r2 = com.dragon.read.rpc.model.MsgApiERR.SUCCESS
            if (r5 != r2) goto L5b
            java.lang.String r5 = "emptyData"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            r0.put(r5, r2)
            goto L5b
        L54:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r0.put(r2, r5)
        L5b:
            com.dragon.read.app.lifecycle.IAppLifecycleMonitor r5 = com.dragon.read.app.AppLifecycleMonitor.getInstance()
            boolean r5 = r5.isForeground()
            r5 = r5 ^ r6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "inbackground"
            r0.put(r6, r5)
            java.lang.String r5 = "msgCount"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r0.put(r5, r6)
            java.lang.String r5 = "insert_screen_message_sync"
            com.dragon.read.report.ReportManager.onReport(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: is4.i.n(com.dragon.read.rpc.model.MsgApiERR, java.lang.Throwable):void");
    }

    public final void h(SyncParam req, SyncData syncData, List<? extends SyncData> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(syncData, "syncData");
        Intrinsics.checkNotNullParameter(list, "list");
        if (e()) {
            return;
        }
        int indexOf = list.indexOf(syncData) + 1;
        int size = list.size();
        while (true) {
            if (indexOf < size) {
                if (list.get(indexOf).minSeq < syncData.maxSeq) {
                    z = true;
                    break;
                }
                indexOf++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return;
        }
        Args args = new Args();
        args.put("scene", 1);
        args.put("minSeq", Long.valueOf(req.minSeq));
        args.put("curMinSeq", Long.valueOf(syncData.minSeq));
        args.put("curMaxSeq", Long.valueOf(syncData.maxSeq));
        args.put("curIdx", Integer.valueOf(list.indexOf(syncData)));
        args.put("loseCnt", Integer.valueOf((list.size() - list.indexOf(syncData)) - 1));
        ReportManager.onReport("insert_screen_message_lose", args);
    }

    public final void i(SyncParam req, SyncData syncData, List<? extends SyncData> list, long j) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(list, "list");
        if (!e() && syncData != null && j <= syncData.minSeq) {
            Args args = new Args();
            args.put("scene", 2);
            args.put("minSeq", Long.valueOf(req.minSeq));
            args.put("curMinSeq", Long.valueOf(syncData.minSeq));
            args.put("curMaxSeq", Long.valueOf(syncData.maxSeq));
            args.put("curIdx", Integer.valueOf(list.indexOf(syncData)));
            ReportManager.onReport("insert_screen_message_lose", args);
        }
    }
}
