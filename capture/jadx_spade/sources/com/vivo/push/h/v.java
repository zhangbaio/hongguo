package com.vivo.push.h;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class v implements Runnable {
    final /* synthetic */ InsideNotificationItem a;
    final /* synthetic */ com.vivo.push.b.q b;
    final /* synthetic */ boolean c;
    final /* synthetic */ u d;

    static {
        Covode.recordClassIndex(655076);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c;
        Context context7;
        Context context8;
        Context context9;
        if (this.a.isNoShowOnForeground()) {
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "msg " + this.a.getMsgId() + " no show on foreground");
            ((ab) this.d).b.onForegroundMessageArrived(com.vivo.push.util.u.a(this.a));
            return;
        }
        if (this.a.isAppInstallCompleteMsg()) {
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "msg " + this.a.getMsgId() + " notify app install");
            ((ab) this.d).b.onAppInstallCompleteShowMsg(this.a.getThirdPackageName());
            return;
        }
        u uVar = this.d;
        PushMessageCallback pushMessageCallback = ((ab) uVar).b;
        context = ((com.vivo.push.s) uVar).a;
        NotifyArriveCallbackByUser onNotificationMessageArrived = pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.u.a(this.a));
        int a = this.d.a(onNotificationMessageArrived);
        if (a > 0) {
            com.vivo.push.util.f.a(a, this.d.a(this.b.h()));
            return;
        }
        int b = this.d.b();
        if (b > 0) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context8 = ((com.vivo.push.s) this.d).a;
            sb.append(context8.getPackageName());
            sb.append(" notify channel switch is ");
            sb.append(b);
            com.vivo.push.util.t.b("OnNotificationArrivedTask", sb.toString());
            context9 = ((com.vivo.push.s) this.d).a;
            com.vivo.push.util.t.b(context9, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b)));
            com.vivo.push.util.f.a(b, this.d.a(this.b.h()));
            return;
        }
        if (this.c && this.a.isOperateMsg() && !com.vivo.push.util.ai.a().a(this.a.getWindowPeriod())) {
            com.vivo.push.util.f.a(1017L, this.d.a(this.b.h()));
            context7 = ((com.vivo.push.s) this.d).a;
            com.vivo.push.util.t.b(context7, "内部运营消息不在窗口期内，不做展示");
            return;
        }
        context2 = ((com.vivo.push.s) this.d).a;
        InsideNotificationItem insideNotificationItem = this.a;
        long h = this.b.h();
        u uVar2 = this.d;
        PushMessageCallback pushMessageCallback2 = ((ab) uVar2).b;
        context3 = ((com.vivo.push.s) uVar2).a;
        com.vivo.push.util.o oVar = new com.vivo.push.util.o(context2, insideNotificationItem, h, pushMessageCallback2.isAllowNet(context3), new w(this), onNotificationMessageArrived);
        boolean isShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
        String purePicUrl = this.a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.t.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (!isShowBigPicOnMobileNet) {
                context5 = ((com.vivo.push.s) this.d).a;
                com.vivo.push.util.t.a(context5, "mobile net unshow");
                context6 = ((com.vivo.push.s) this.d).a;
                NetworkInfo a2 = com.vivo.push.util.x.a(context6);
                if (a2 == null || a2.getState() != NetworkInfo.State.CONNECTED) {
                    c = 0;
                } else {
                    int type = a2.getType();
                    if (type == 1) {
                        c = 2;
                    } else if (type == 0) {
                        c = 1;
                    } else {
                        c = 3;
                    }
                }
                if (c == 1) {
                    this.a.clearCoverUrl();
                    this.a.clearPurePicUrl();
                    purePicUrl = null;
                }
            } else {
                context4 = ((com.vivo.push.s) this.d).a;
                com.vivo.push.util.t.a(context4, "mobile net show");
            }
        }
        oVar.execute1(new String[]{this.a.getIconUrl(), purePicUrl});
    }

    v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar, boolean z) {
        this.d = uVar;
        this.a = insideNotificationItem;
        this.b = qVar;
        this.c = z;
    }
}
