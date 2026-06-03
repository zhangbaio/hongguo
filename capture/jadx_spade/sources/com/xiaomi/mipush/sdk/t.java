package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.ba;
import com.xiaomi.push.bm;
import com.xiaomi.push.cr;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.ec;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.gq;
import com.xiaomi.push.gr;
import com.xiaomi.push.gs;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.gz;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.hf;
import com.xiaomi.push.hh;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class t {
    private static t a;

    /* renamed from: a, reason: collision with other field name */
    private static Object f65a;

    /* renamed from: a, reason: collision with other field name */
    private static Queue<String> f66a;

    /* renamed from: a, reason: collision with other field name */
    private Context f67a;

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m54a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                ds.a(this.f67a).a(this.f67a.getPackageName(), intent, "12");
                return null;
            }
            ha haVar = new ha();
            try {
                ho.a(haVar, byteArrayExtra);
                b m79a = b.m79a(this.f67a);
                gr m533a = haVar.m533a();
                ge a2 = haVar.a();
                ge geVar = ge.SendMessage;
                if (a2 == geVar && m533a != null && !m79a.m90e() && !booleanExtra) {
                    m533a.a("mrt", stringExtra);
                    m533a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m111a(haVar)) {
                        b(haVar);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m533a.a("__hybrid_message_ts", String.valueOf(m533a.m497a()));
                        m533a.a("__hybrid_device_status", String.valueOf((int) ho.a(this.f67a, haVar)));
                    }
                }
                if (haVar.a() == geVar && !haVar.m541b()) {
                    if (x.m761a(haVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = haVar.b();
                        objArr[1] = m533a != null ? m533a.m499a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m54a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        ds.a(this.f67a).a(this.f67a.getPackageName(), intent, String.format("13: %1$s", haVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = haVar.b();
                        objArr2[1] = m533a != null ? m533a.m499a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m54a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        ds.a(this.f67a).a(this.f67a.getPackageName(), intent, String.format("14: %1$s", haVar.b()));
                    }
                    j.a(this.f67a, haVar, booleanExtra);
                    return null;
                }
                if (haVar.a() == geVar && haVar.m541b() && x.m761a(haVar) && (!booleanExtra || m533a == null || m533a.m500a() == null || !m533a.m500a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = haVar.b();
                    objArr3[1] = m533a != null ? m533a.m499a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m54a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    ds.a(this.f67a).a(this.f67a.getPackageName(), intent, String.format("25: %1$s", haVar.b()));
                    j.b(this.f67a, haVar, booleanExtra);
                    return null;
                }
                if (!m79a.m88c() && haVar.f649a != ge.Registration) {
                    if (x.m761a(haVar)) {
                        return a(haVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    j.e(this.f67a, haVar, booleanExtra);
                    boolean m89d = m79a.m89d();
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m89d);
                    ds.a(this.f67a).a(this.f67a.getPackageName(), intent, "15");
                    if (m89d) {
                        a();
                    }
                } else if (m79a.m88c() && m79a.m91f()) {
                    if (haVar.f649a == ge.UnRegistration) {
                        if (haVar.m541b()) {
                            m79a.m81a();
                            MiPushClient.clearExtras(this.f67a);
                            PushMessageHandler.a();
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        }
                    } else {
                        j.e(this.f67a, haVar, booleanExtra);
                        MiPushClient.unregisterPush(this.f67a);
                    }
                } else {
                    return a(haVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                }
            } catch (ht e) {
                ds.a(this.f67a).a(this.f67a.getPackageName(), intent, "16");
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                ds.a(this.f67a).a(this.f67a.getPackageName(), intent, "17");
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                ha haVar2 = new ha();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        ho.a(haVar2, byteArrayExtra2);
                    }
                } catch (ht unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(haVar2.a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                    return null;
                }
                ha haVar3 = new ha();
                try {
                    ho.a(haVar3, byteArrayExtra3);
                    b m79a2 = b.m79a(this.f67a);
                    if (x.m761a(haVar3)) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                    } else if (!m79a2.m88c()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                    } else if (m79a2.m88c() && m79a2.m91f()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: app info is invalidated");
                    } else {
                        return a(haVar3, byteArrayExtra3);
                    }
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e3);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PushMessageHandler.a a(ha haVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        gr grVar;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            hp a2 = r.a(this.f67a, haVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + haVar.f649a);
                ds.a(this.f67a).b(this.f67a.getPackageName(), dr.m361a(i), str, "18");
                j.c(this.f67a, haVar, z);
                return null;
            }
            ge a3 = haVar.a();
            com.xiaomi.channel.commonutils.logger.b.m56a("processing a message, action=", a3, ", hasNotified=", Boolean.valueOf(z));
            switch (AnonymousClass1.a[a3.ordinal()]) {
                case 1:
                    if (!haVar.m541b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (b.m79a(this.f67a).m90e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("receive a message in pause state. drop it");
                        ds.a(this.f67a).a(this.f67a.getPackageName(), dr.m361a(i), str, "12");
                        return null;
                    }
                    hh hhVar = (hh) a2;
                    gq a4 = hhVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        ds.a(this.f67a).b(this.f67a.getPackageName(), dr.m361a(i), str, "22");
                        j.d(this.f67a, haVar, z);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z) {
                        if (x.m761a(haVar)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f67a, a4.m491a(), haVar.m533a(), haVar.f656b, a4.b());
                        } else {
                            if (haVar.m533a() != null) {
                                grVar = new gr(haVar.m533a());
                            } else {
                                grVar = new gr();
                            }
                            if (grVar.m500a() == null) {
                                grVar.a(new HashMap());
                            }
                            grVar.m500a().put("notification_click_button", String.valueOf(intExtra));
                            MiPushClient.reportMessageClicked(this.f67a, a4.m491a(), grVar, a4.b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(hhVar.d()) && MiPushClient.aliasSetTime(this.f67a, hhVar.d()) < 0) {
                            MiPushClient.addAlias(this.f67a, hhVar.d());
                        } else if (!TextUtils.isEmpty(hhVar.c()) && MiPushClient.topicSubscribedTime(this.f67a, hhVar.c()) < 0) {
                            MiPushClient.addTopic(this.f67a, hhVar.c());
                        }
                    }
                    gr grVar2 = haVar.f650a;
                    String str2 = (grVar2 == null || grVar2.m500a() == null) ? null : haVar.f650a.f564a.get("jobkey");
                    String str3 = str2;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = a4.m491a();
                    }
                    if (!z && m110a(this.f67a, str2)) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("drop a duplicate message, key=" + str2);
                        ds.a(this.f67a).c(this.f67a.getPackageName(), dr.m361a(i), str, "2:" + str2);
                    } else {
                        MiPushMessage generateMessage = PushMessageHelper.generateMessage(hhVar, haVar.m533a(), z);
                        if (generateMessage.getPassThrough() == 0 && !z && x.m762a(generateMessage.getExtra())) {
                            x.m757a(this.f67a, haVar, bArr);
                            return null;
                        }
                        String a5 = x.a(generateMessage.getExtra(), intExtra);
                        com.xiaomi.channel.commonutils.logger.b.m56a("receive a message, msgid=", a4.m491a(), ", jobkey=", str2, ", btn=", Integer.valueOf(intExtra), ", typeId=", a5, ", hasNotified=", Boolean.valueOf(z));
                        if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a5)) {
                            Map<String, String> extra = generateMessage.getExtra();
                            if (intExtra != 0 && haVar.m533a() != null) {
                                u.a(this.f67a).a(haVar.m533a().c(), intExtra);
                            }
                            if (x.m761a(haVar)) {
                                Intent a6 = a(this.f67a, haVar.f656b, extra, intExtra);
                                a6.putExtra("eventMessageType", i);
                                a6.putExtra("messageId", str);
                                a6.putExtra("jobkey", str3);
                                String c = a4.c();
                                if (!TextUtils.isEmpty(c)) {
                                    a6.putExtra("payload", c);
                                }
                                this.f67a.startActivity(a6);
                                j.a(this.f67a, haVar);
                                ds.a(this.f67a).a(this.f67a.getPackageName(), dr.m361a(i), str, 3006, a5);
                                com.xiaomi.channel.commonutils.logger.b.m55a("PushMessageProcessor", "start business activity succ");
                            } else {
                                Context context = this.f67a;
                                Intent a7 = a(context, context.getPackageName(), extra, intExtra);
                                if (a7 != null) {
                                    if (!a5.equals(an.c)) {
                                        a7.putExtra("key_message", generateMessage);
                                        a7.putExtra("eventMessageType", i);
                                        a7.putExtra("messageId", str);
                                        a7.putExtra("jobkey", str3);
                                    }
                                    this.f67a.startActivity(a7);
                                    j.a(this.f67a, haVar);
                                    com.xiaomi.channel.commonutils.logger.b.m55a("PushMessageProcessor", "start activity succ");
                                    ds.a(this.f67a).a(this.f67a.getPackageName(), dr.m361a(i), str, 1006, a5);
                                    if (a5.equals(an.c)) {
                                        ds.a(this.f67a).a(this.f67a.getPackageName(), dr.m361a(i), str, "13");
                                    }
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.d("PushMessageProcessor", "missing target intent for message: " + a4.m491a() + ", typeId=" + a5);
                                }
                            }
                            com.xiaomi.channel.commonutils.logger.b.m55a("PushMessageProcessor", "pre-def msg process done.");
                            return null;
                        }
                        miPushMessage = generateMessage;
                    }
                    if (haVar.m533a() == null && !z) {
                        a(hhVar, haVar);
                    }
                    return miPushMessage;
                case 2:
                    hf hfVar = (hf) a2;
                    String str4 = b.m79a(this.f67a).f43a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, hfVar.m563a())) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("bad Registration result:");
                        ds.a(this.f67a).b(this.f67a.getPackageName(), dr.m361a(i), str, "21");
                        return null;
                    }
                    long m120a = u.a(this.f67a).m120a();
                    if (m120a > 0 && SystemClock.elapsedRealtime() - m120a > 900000) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("The received registration result has expired.");
                        ds.a(this.f67a).b(this.f67a.getPackageName(), dr.m361a(i), str, "26");
                        return null;
                    }
                    b.m79a(this.f67a).f43a = null;
                    if (hfVar.f712a == 0) {
                        b.m79a(this.f67a).b(hfVar.f724e, hfVar.f725f, hfVar.f731l);
                        FCMPushHelper.persistIfXmsfSupDecrypt(this.f67a);
                        ds.a(this.f67a).a(this.f67a.getPackageName(), dr.m361a(i), str, 6006, "1");
                    } else {
                        ds.a(this.f67a).a(this.f67a.getPackageName(), dr.m361a(i), str, 6006, "2");
                    }
                    if (!TextUtils.isEmpty(hfVar.f724e)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(hfVar.f724e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f356a, arrayList3, hfVar.f712a, hfVar.f723d, null, hfVar.m564a());
                    u.a(this.f67a).m129d();
                    return generateCommandMessage;
                case 3:
                    if (!haVar.m541b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((hl) a2).f790a == 0) {
                        b.m79a(this.f67a).m81a();
                        MiPushClient.clearExtras(this.f67a);
                    }
                    PushMessageHandler.a();
                    return miPushMessage;
                case 4:
                    hj hjVar = (hj) a2;
                    if (hjVar.f765a == 0) {
                        MiPushClient.addTopic(this.f67a, hjVar.b());
                    }
                    if (!TextUtils.isEmpty(hjVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(hjVar.b());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("resp-cmd:");
                    ec ecVar = ec.COMMAND_SUBSCRIBE_TOPIC;
                    sb.append(ecVar);
                    sb.append(", ");
                    sb.append(hjVar.a());
                    com.xiaomi.channel.commonutils.logger.b.e(sb.toString());
                    return PushMessageHelper.generateCommandMessage(ecVar.f356a, arrayList2, hjVar.f765a, hjVar.f771d, hjVar.c(), null);
                case 5:
                    hn hnVar = (hn) a2;
                    if (hnVar.f810a == 0) {
                        MiPushClient.removeTopic(this.f67a, hnVar.b());
                    }
                    if (!TextUtils.isEmpty(hnVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(hnVar.b());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("resp-cmd:");
                    ec ecVar2 = ec.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb2.append(ecVar2);
                    sb2.append(", ");
                    sb2.append(hnVar.a());
                    com.xiaomi.channel.commonutils.logger.b.e(sb2.toString());
                    return PushMessageHelper.generateCommandMessage(ecVar2.f356a, arrayList, hnVar.f810a, hnVar.f816d, hnVar.c(), null);
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    cr.a(this.f67a.getPackageName(), this.f67a, a2, ge.Command, bArr.length);
                    gz gzVar = (gz) a2;
                    String b = gzVar.b();
                    List<String> m527a = gzVar.m527a();
                    if (gzVar.f637a == 0) {
                        if (TextUtils.equals(b, ec.COMMAND_SET_ACCEPT_TIME.f356a) && m527a != null && m527a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f67a, m527a.get(0), m527a.get(1));
                            if ("00:00".equals(m527a.get(0)) && "00:00".equals(m527a.get(1))) {
                                b.m79a(this.f67a).a(true);
                            } else {
                                b.m79a(this.f67a).a(false);
                            }
                            m527a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m527a);
                        } else if (TextUtils.equals(b, ec.COMMAND_SET_ALIAS.f356a) && m527a != null && m527a.size() > 0) {
                            MiPushClient.addAlias(this.f67a, m527a.get(0));
                        } else if (TextUtils.equals(b, ec.COMMAND_UNSET_ALIAS.f356a) && m527a != null && m527a.size() > 0) {
                            MiPushClient.removeAlias(this.f67a, m527a.get(0));
                        } else if (TextUtils.equals(b, ec.COMMAND_SET_ACCOUNT.f356a) && m527a != null && m527a.size() > 0) {
                            MiPushClient.addAccount(this.f67a, m527a.get(0));
                        } else if (TextUtils.equals(b, ec.COMMAND_UNSET_ACCOUNT.f356a) && m527a != null && m527a.size() > 0) {
                            MiPushClient.removeAccount(this.f67a, m527a.get(0));
                        } else if (TextUtils.equals(b, ec.COMMAND_CHK_VDEVID.f356a)) {
                            return null;
                        }
                    }
                    List<String> list = m527a;
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + ", " + gzVar.a());
                    return PushMessageHelper.generateCommandMessage(b, list, gzVar.f637a, gzVar.f645d, gzVar.c(), null);
                case 7:
                    cr.a(this.f67a.getPackageName(), this.f67a, a2, ge.Notification, bArr.length);
                    if (a2 instanceof gv) {
                        gv gvVar = (gv) a2;
                        String a8 = gvVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + gvVar.b() + ", code:" + gvVar.f607a + ", " + a8);
                        if (go.DisablePushMessage.f529a.equalsIgnoreCase(gvVar.f614d)) {
                            if (gvVar.f607a == 0) {
                                synchronized (p.class) {
                                    if (p.a(this.f67a).m109a(a8)) {
                                        p.a(this.f67a).c(a8);
                                        p a9 = p.a(this.f67a);
                                        v vVar = v.DISABLE_PUSH;
                                        if ("syncing".equals(a9.a(vVar))) {
                                            p.a(this.f67a).a(vVar, "synced");
                                            MiPushClient.clearNotification(this.f67a);
                                            MiPushClient.clearLocalNotificationType(this.f67a);
                                            PushMessageHandler.a();
                                            u.a(this.f67a).m126b();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(p.a(this.f67a).a(v.DISABLE_PUSH))) {
                                synchronized (p.class) {
                                    if (p.a(this.f67a).m109a(a8)) {
                                        if (p.a(this.f67a).a(a8) < 10) {
                                            p.a(this.f67a).b(a8);
                                            u.a(this.f67a).a(true, a8);
                                        } else {
                                            p.a(this.f67a).c(a8);
                                        }
                                    }
                                }
                            } else {
                                p.a(this.f67a).c(a8);
                            }
                        } else if (go.EnablePushMessage.f529a.equalsIgnoreCase(gvVar.f614d)) {
                            if (gvVar.f607a == 0) {
                                synchronized (p.class) {
                                    if (p.a(this.f67a).m109a(a8)) {
                                        p.a(this.f67a).c(a8);
                                        p a10 = p.a(this.f67a);
                                        v vVar2 = v.ENABLE_PUSH;
                                        if ("syncing".equals(a10.a(vVar2))) {
                                            p.a(this.f67a).a(vVar2, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(p.a(this.f67a).a(v.ENABLE_PUSH))) {
                                synchronized (p.class) {
                                    if (p.a(this.f67a).m109a(a8)) {
                                        if (p.a(this.f67a).a(a8) < 10) {
                                            p.a(this.f67a).b(a8);
                                            u.a(this.f67a).a(false, a8);
                                        } else {
                                            p.a(this.f67a).c(a8);
                                        }
                                    }
                                }
                            } else {
                                p.a(this.f67a).c(a8);
                            }
                        } else if (go.ThirdPartyRegUpdate.f529a.equalsIgnoreCase(gvVar.f614d)) {
                            b(gvVar);
                        } else if (go.UploadTinyData.f529a.equalsIgnoreCase(gvVar.f614d)) {
                            a(gvVar);
                        }
                    } else if (a2 instanceof hd) {
                        hd hdVar = (hd) a2;
                        if ("registration id expired".equalsIgnoreCase(hdVar.f673d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f67a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f67a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f67a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f67a);
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hdVar.f673d + ", " + hdVar.m548a());
                            MiPushClient.reInitialize(this.f67a, gs.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f67a, str5);
                                MiPushClient.setAlias(this.f67a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f67a, str6);
                                MiPushClient.subscribe(this.f67a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f67a, str7);
                                MiPushClient.setUserAccount(this.f67a, str7, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f67a);
                                MiPushClient.addAcceptTime(this.f67a, split[0], split[1]);
                            }
                        } else if (go.ClientInfoUpdateOk.f529a.equalsIgnoreCase(hdVar.f673d)) {
                            if (hdVar.m549a() != null && hdVar.m549a().containsKey("app_version")) {
                                b.m79a(this.f67a).m82a(hdVar.m549a().get("app_version"));
                            }
                        } else {
                            try {
                                if (go.NormalClientConfigUpdate.f529a.equalsIgnoreCase(hdVar.f673d)) {
                                    hc hcVar = new hc();
                                    ho.a(hcVar, hdVar.m554a());
                                    ai.a(ah.a(this.f67a), hcVar);
                                } else if (go.CustomClientConfigUpdate.f529a.equalsIgnoreCase(hdVar.f673d)) {
                                    hb hbVar = new hb();
                                    ho.a(hbVar, hdVar.m554a());
                                    ai.a(ah.a(this.f67a), hbVar);
                                } else if (go.SyncInfoResult.f529a.equalsIgnoreCase(hdVar.f673d)) {
                                    w.a(this.f67a, hdVar);
                                } else if (go.ForceSync.f529a.equalsIgnoreCase(hdVar.f673d)) {
                                    com.xiaomi.channel.commonutils.logger.b.m54a("receive force sync notification");
                                    w.a(this.f67a, false);
                                } else if (go.CancelPushMessage.f529a.equals(hdVar.f673d)) {
                                    com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hdVar.f673d + ", " + hdVar.m548a());
                                    if (hdVar.m549a() != null) {
                                        int i2 = -2;
                                        if (hdVar.m549a().containsKey(an.Q)) {
                                            String str8 = hdVar.m549a().get(an.Q);
                                            if (!TextUtils.isEmpty(str8)) {
                                                try {
                                                    i2 = Integer.parseInt(str8);
                                                } catch (NumberFormatException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i2 >= -1) {
                                            MiPushClient.clearNotification(this.f67a, i2);
                                        } else {
                                            MiPushClient.clearNotification(this.f67a, hdVar.m549a().containsKey(an.O) ? hdVar.m549a().get(an.O) : "", hdVar.m549a().containsKey(an.P) ? hdVar.m549a().get(an.P) : "");
                                        }
                                    }
                                    a(hdVar);
                                } else if (go.HybridRegisterResult.f529a.equals(hdVar.f673d)) {
                                    try {
                                        hf hfVar2 = new hf();
                                        ho.a(hfVar2, hdVar.m554a());
                                        MiPushClient4Hybrid.onReceiveRegisterResult(this.f67a, hfVar2);
                                    } catch (ht e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    }
                                } else if (go.HybridUnregisterResult.f529a.equals(hdVar.f673d)) {
                                    try {
                                        hl hlVar = new hl();
                                        ho.a(hlVar, hdVar.m554a());
                                        MiPushClient4Hybrid.onReceiveUnregisterResult(this.f67a, hlVar);
                                    } catch (ht e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    }
                                } else if (!go.PushLogUpload.f529a.equals(hdVar.f673d)) {
                                    if (go.DetectAppAlive.f529a.equals(hdVar.f673d)) {
                                        com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                        b(hdVar);
                                    } else if (com.xiaomi.push.service.g.a(hdVar)) {
                                        com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                    }
                                }
                            } catch (ht unused) {
                            }
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (l e4) {
            com.xiaomi.channel.commonutils.logger.b.a(e4);
            a(haVar);
            ds.a(this.f67a).b(this.f67a.getPackageName(), dr.m361a(i), str, "19");
            j.c(this.f67a, haVar, z);
            return null;
        } catch (ht e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            ds.a(this.f67a).b(this.f67a.getPackageName(), dr.m361a(i), str, "20");
            j.c(this.f67a, haVar, z);
            return null;
        }
    }

    private void a(String str, long j, d dVar) {
        v m105a = g.m105a(dVar);
        if (m105a == null) {
            return;
        }
        if (j == 0) {
            synchronized (p.class) {
                if (p.a(this.f67a).m109a(str)) {
                    p.a(this.f67a).c(str);
                    if ("syncing".equals(p.a(this.f67a).a(m105a))) {
                        p.a(this.f67a).a(m105a, "synced");
                    }
                }
            }
            return;
        }
        if ("syncing".equals(p.a(this.f67a).a(m105a))) {
            synchronized (p.class) {
                if (p.a(this.f67a).m109a(str)) {
                    if (p.a(this.f67a).a(str) < 10) {
                        p.a(this.f67a).b(str);
                        u.a(this.f67a).a(str, m105a, dVar, "retry");
                    } else {
                        p.a(this.f67a).c(str);
                    }
                }
            }
            return;
        }
        p.a(this.f67a).c(str);
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }

    private void a(hh hhVar, ha haVar) {
        gr m533a = haVar.m533a();
        if (m533a != null) {
            m533a = au.a(m533a.m498a());
        }
        gu guVar = new gu();
        guVar.b(hhVar.b());
        guVar.a(hhVar.m572a());
        guVar.a(hhVar.a().a());
        if (!TextUtils.isEmpty(hhVar.c())) {
            guVar.c(hhVar.c());
        }
        if (!TextUtils.isEmpty(hhVar.d())) {
            guVar.d(hhVar.d());
        }
        guVar.a(ho.a(this.f67a, haVar));
        u.a(this.f67a).a((u) guVar, ge.AckMessage, m533a);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m110a(Context context, String str) {
        synchronized (f65a) {
            b.m79a(context);
            SharedPreferences a2 = b.a(context);
            if (f66a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f66a = new LinkedList();
                for (String str2 : split) {
                    f66a.add(str2);
                }
            }
            if (f66a.contains(str)) {
                return true;
            }
            f66a.add(str);
            if (f66a.size() > 25) {
                f66a.poll();
            }
            String a3 = ba.a(f66a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.o.a(edit);
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m111a(ha haVar) {
        Map<String, String> m500a = haVar.m533a() == null ? null : haVar.m533a().m500a();
        if (m500a == null) {
            return false;
        }
        String str = m500a.get("push_server_action");
        return TextUtils.equals(str, "hybrid_message") || TextUtils.equals(str, "platform_message");
    }

    static {
        Covode.recordClassIndex(655320);
        a = null;
        f65a = new Object();
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f67a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong("last_reinitialize", 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f67a, gs.PackageUnregistered);
            sharedPreferences.edit().putLong("last_reinitialize", currentTimeMillis).commit();
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.t$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ge.values().length];
            a = iArr;
            try {
                iArr[ge.SendMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ge.Registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ge.UnRegistration.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ge.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ge.UnSubscription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ge.Command.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ge.Notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private t(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f67a = applicationContext;
        if (applicationContext == null) {
            this.f67a = context;
        }
    }

    public static t a(Context context) {
        if (a == null) {
            a = new t(context);
        }
        return a;
    }

    private void b(ha haVar) {
        gr m533a = haVar.m533a();
        if (m533a != null) {
            m533a = au.a(m533a.m498a());
        }
        gu guVar = new gu();
        guVar.b(haVar.m534a());
        guVar.a(m533a.m499a());
        guVar.a(m533a.m497a());
        if (!TextUtils.isEmpty(m533a.m504b())) {
            guVar.c(m533a.m504b());
        }
        guVar.a(ho.a(this.f67a, haVar));
        u.a(this.f67a).a((u) guVar, ge.AckMessage, false, m533a);
    }

    private void b(hd hdVar) {
        Map<String, String> m549a = hdVar.m549a();
        if (m549a == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("detect failed because null");
            return;
        }
        String str = (String) ag.a(m549a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("detect failed because empty");
            return;
        }
        Map<String, String> m457a = com.xiaomi.push.g.m457a(this.f67a, str);
        if (m457a != null) {
            String str2 = m457a.get("alive");
            String str3 = m457a.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                hd hdVar2 = new hd();
                hdVar2.a(hdVar.m548a());
                hdVar2.b(hdVar.b());
                hdVar2.d(hdVar.d());
                hdVar2.c(go.DetectAppAliveResult.f529a);
                HashMap hashMap = new HashMap();
                hdVar2.f668a = hashMap;
                hashMap.put("alive", str2);
                if (Boolean.parseBoolean((String) ag.a(m549a, "reportNotAliveApp", "false")) && !TextUtils.isEmpty(str3)) {
                    hdVar2.f668a.put("notAlive", str3);
                }
                u.a(this.f67a).a((u) hdVar2, ge.Notification, false, (gr) null);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("detect failed because get status illegal");
    }

    private void a(gv gvVar) {
        boolean z;
        String a2 = gvVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
        Map<String, String> m514a = gvVar.m514a();
        if (m514a != null) {
            String str = m514a.get("real_source");
            if (!TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bm a3 = bm.a(this.f67a);
                if (gvVar.f607a == 0) {
                    z = true;
                } else {
                    z = false;
                }
                a3.a(a2, str, Boolean.valueOf(z));
            }
        }
    }

    private void b(gv gvVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + gvVar.toString());
        String a2 = gvVar.a();
        Map<String, String> m514a = gvVar.m514a();
        if (m514a != null) {
            String str = m514a.get("RegInfo");
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("brand:" + q.FCM.name())) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    Context context = this.f67a;
                    d dVar = d.ASSEMBLE_PUSH_FCM;
                    f.b(context, dVar, str);
                    a(a2, gvVar.f607a, dVar);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("brand:");
                q qVar = q.HUAWEI;
                sb.append(qVar.name());
                if (!str.contains(sb.toString())) {
                    if (!str.contains("channel:" + qVar.name())) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("brand:");
                        q qVar2 = q.OPPO;
                        sb2.append(qVar2.name());
                        if (!str.contains(sb2.toString())) {
                            if (!str.contains("channel:" + qVar2.name())) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("brand:");
                                q qVar3 = q.VIVO;
                                sb3.append(qVar3.name());
                                if (!str.contains(sb3.toString())) {
                                    if (!str.contains("channel:" + qVar3.name())) {
                                        return;
                                    }
                                }
                                com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                Context context2 = this.f67a;
                                d dVar2 = d.ASSEMBLE_PUSH_FTOS;
                                f.b(context2, dVar2, str);
                                a(a2, gvVar.f607a, dVar2);
                                return;
                            }
                        }
                        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive COS token sync ack");
                        Context context3 = this.f67a;
                        d dVar3 = d.ASSEMBLE_PUSH_COS;
                        f.b(context3, dVar3, str);
                        a(a2, gvVar.f607a, dVar3);
                        return;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive hw token sync ack");
                Context context4 = this.f67a;
                d dVar4 = d.ASSEMBLE_PUSH_HUAWEI;
                f.b(context4, dVar4, str);
                a(a2, gvVar.f607a, dVar4);
            }
        }
    }

    private void a(ha haVar) {
        com.xiaomi.channel.commonutils.logger.b.m54a("receive a message but decrypt failed. report now.");
        hd hdVar = new hd(haVar.m533a().f562a, false);
        hdVar.c(go.DecryptMessageFail.f529a);
        hdVar.b(haVar.m534a());
        hdVar.d(haVar.f656b);
        HashMap hashMap = new HashMap();
        hdVar.f668a = hashMap;
        hashMap.put("regid", MiPushClient.getRegId(this.f67a));
        u.a(this.f67a).a((u) hdVar, ge.Notification, false, (gr) null);
    }

    private void a(hd hdVar) {
        gv gvVar = new gv();
        gvVar.c(go.CancelPushMessageACK.f529a);
        gvVar.a(hdVar.m548a());
        gvVar.a(hdVar.a());
        gvVar.b(hdVar.b());
        gvVar.e(hdVar.d());
        gvVar.a(0L);
        gvVar.d("success clear push message.");
        u.a(this.f67a).a(gvVar, ge.Notification, false, true, null, false, this.f67a.getPackageName(), b.m79a(this.f67a).m80a(), false);
    }

    public static void a(Context context, String str) {
        synchronized (f65a) {
            f66a.remove(str);
            b.m79a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = ba.a(f66a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.o.a(edit);
        }
    }

    private PushMessageHandler.a a(ha haVar, byte[] bArr) {
        String str = null;
        try {
            hp a2 = r.a(this.f67a, haVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + haVar.f649a);
                return null;
            }
            ge a3 = haVar.a();
            com.xiaomi.channel.commonutils.logger.b.m54a("message arrived: processing an arrived message, action=" + a3);
            if (AnonymousClass1.a[a3.ordinal()] != 1) {
                return null;
            }
            if (!haVar.m541b()) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            hh hhVar = (hh) a2;
            gq a4 = hhVar.a();
            if (a4 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            gr grVar = haVar.f650a;
            if (grVar != null && grVar.m500a() != null) {
                str = haVar.f650a.f564a.get("jobkey");
            }
            MiPushMessage generateMessage = PushMessageHelper.generateMessage(hhVar, haVar.m533a(), false);
            generateMessage.setArrivedMessage(true);
            com.xiaomi.channel.commonutils.logger.b.m54a("message arrived: receive a message, msgid=" + a4.m491a() + ", jobkey=" + str);
            return generateMessage;
        } catch (l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (ht e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return x.b(context, str, map, i);
    }
}
