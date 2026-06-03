package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gj;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e implements AbstractPushManager {
    private static volatile e a;

    /* renamed from: a, reason: collision with other field name */
    private Context f51a;

    /* renamed from: a, reason: collision with other field name */
    private PushConfiguration f52a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f54a = false;

    /* renamed from: a, reason: collision with other field name */
    private Map<d, AbstractPushManager> f53a = new HashMap();

    static {
        Covode.recordClassIndex(655302);
    }

    /* renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : assemble push register");
        if (this.f53a.size() <= 0) {
            a();
        }
        if (this.f53a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f53a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            f.m99a(this.f51a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f53a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f53a.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.e.a():void");
    }

    private e(Context context) {
        this.f51a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    public AbstractPushManager a(d dVar) {
        return this.f53a.get(dVar);
    }

    public boolean b(d dVar) {
        int i = AnonymousClass2.a[dVar.ordinal()];
        boolean z = false;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return false;
                    }
                } else {
                    PushConfiguration pushConfiguration = this.f52a;
                    if (pushConfiguration != null) {
                        z = pushConfiguration.getOpenCOSPush();
                    }
                }
                PushConfiguration pushConfiguration2 = this.f52a;
                if (pushConfiguration2 != null) {
                    return pushConfiguration2.getOpenFTOSPush();
                }
                return z;
            }
            PushConfiguration pushConfiguration3 = this.f52a;
            if (pushConfiguration3 == null) {
                return false;
            }
            return pushConfiguration3.getOpenFCMPush();
        }
        PushConfiguration pushConfiguration4 = this.f52a;
        if (pushConfiguration4 == null) {
            return false;
        }
        return pushConfiguration4.getOpenHmsPush();
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f52a = pushConfiguration;
        this.f54a = ah.a(this.f51a).a(gj.AggregatePushSwitch.a(), true);
        if (this.f52a.getOpenHmsPush() || this.f52a.getOpenFCMPush() || this.f52a.getOpenCOSPush() || this.f52a.getOpenFTOSPush()) {
            ah.a(this.f51a).a(new ah.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.ah.a
                protected void onCallback() {
                    boolean a2 = ah.a(e.this.f51a).a(gj.AggregatePushSwitch.a(), true);
                    if (e.this.f54a == a2) {
                        return;
                    }
                    e.this.f54a = a2;
                    f.b(e.this.f51a);
                }
            });
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m96a(d dVar) {
        this.f53a.remove(dVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m97a(d dVar) {
        return this.f53a.containsKey(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f53a.containsKey(dVar)) {
                this.f53a.remove(dVar);
            }
            this.f53a.put(dVar, abstractPushManager);
        }
    }
}
