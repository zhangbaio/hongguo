package com.xiaomi.push.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.ResourceOpt;
import com.dragon.read.app.PrivacyMgr;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.ResTranUtils;
import com.xiaomi.push.ad;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.g;
import com.xiaomi.push.ge;
import com.xiaomi.push.gr;
import com.xiaomi.push.ha;
import com.xiaomi.push.service.ae;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class x {
    public static long a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile ab f1022a;

    /* renamed from: a, reason: collision with other field name */
    private static final LinkedList<Pair<Integer, ha>> f1023a;

    /* renamed from: a, reason: collision with other field name */
    private static ExecutorService f1024a;

    public static class b {
        long a = 0;

        /* renamed from: a, reason: collision with other field name */
        Notification f1029a;

        static {
            Covode.recordClassIndex(655749);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with other field name */
        public String f1030a;
        public long a = 0;

        /* renamed from: a, reason: collision with other field name */
        public boolean f1031a = false;

        static {
            Covode.recordClassIndex(655750);
        }
    }

    public static RemoteViews android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot(no0.a aVar, String str, int i) {
        MuteLog.i("Mute.Knot", "RemoteViews.new1, %s layout[0x%s]", str, Integer.toHexString(i));
        return new RemoteViews(str, ResTranUtils.transResourceId(i, "layout"));
    }

    public static void android_widget_RemoteViews_setImageViewResource__com_bytedance_mute_MuteKnotProxy_setImageViewResource_knot(no0.a aVar, int i, int i2) {
        MuteLog.i("Mute.Knot", "RemoteViews.setImageViewResource, viewId[0x%s] srcId[0x%s]", Integer.toHexString(i), Integer.toHexString(i2));
        ((RemoteViews) aVar.b).setImageViewResource(ResTranUtils.transResourceId(i, "id"), ResTranUtils.transResourceId(i2, "drawable"));
    }

    public static void android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a aVar, int i, CharSequence charSequence) {
        MuteLog.i("Mute.Knot", "RemoteViews.setTextViewText, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setTextViewText(ResTranUtils.transResourceId(i, "id"), charSequence);
    }

    public static Notification.Builder com_xiaomi_push_du_setSmallIcon__com_bytedance_mute_MuteKnotProxy_setSmallIcon_knot(no0.a aVar, int i) {
        MuteLog.i("Mute.Knot", "Notification$Builder.setSmallIcon, icon[%s]", Integer.toHexString(i));
        return ((du) aVar.b).setSmallIcon(ResTranUtils.transResourceId(i, "drawable"));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m759a(Context context, String str) {
        return com.xiaomi.push.g.m461b(context, str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m760a(Context context, String str, boolean z) {
        return com.xiaomi.push.j.m630a() && !z && m759a(context, str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static c m757a(Context context, ha haVar, byte[] bArr) {
        int i;
        Map<String, String> map;
        int i2;
        c cVar = new c();
        g.b a2 = com.xiaomi.push.g.a(context, a(haVar), true);
        gr m533a = haVar.m533a();
        if (m533a != null) {
            i = m533a.c();
            map = m533a.m500a();
        } else {
            i = 0;
            map = null;
        }
        final int b2 = com.xiaomi.push.r.b(a(haVar), i);
        if (com.xiaomi.push.j.m631a(context) && a2 == g.b.NOT_ALLOWED) {
            if (m533a != null) {
                ds.a(context.getApplicationContext()).a(haVar.b(), b(haVar), m533a.m499a(), "10:" + a(haVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("Do not notify because user block " + a(haVar) + "‘s notification");
            return cVar;
        }
        if (com.xiaomi.push.j.m631a(context) && f1022a != null && f1022a.m674a(context, b2, a(haVar), map)) {
            if (m533a != null) {
                ds.a(context.getApplicationContext()).a(haVar.b(), b(haVar), m533a.m499a(), "14:" + a(haVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
        RemoteViews a3 = a(context, haVar, bArr);
        PendingIntent a4 = a(context, haVar, haVar.b(), bArr, b2);
        if (a4 == null) {
            if (m533a != null) {
                ds.a(context.getApplicationContext()).a(haVar.b(), b(haVar), m533a.m499a(), "11");
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("The click PendingIntent is null. ");
            return cVar;
        }
        b a5 = a(context, haVar, bArr, a3, a4, b2);
        cVar.a = a5.a;
        cVar.f1030a = a(haVar);
        Notification notification = a5.f1029a;
        if (com.xiaomi.push.j.m630a()) {
            if (!TextUtils.isEmpty(m533a.m499a())) {
                notification.extras.putString("message_id", m533a.m499a());
            }
            notification.extras.putString("local_paid", haVar.m534a());
            ag.a(map, notification.extras, "msg_busi_type");
            ag.a(map, notification.extras, "disable_notification_flags");
            String str = m533a.m505b() == null ? null : m533a.m505b().get("score_info");
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", a(m533a.f564a, "n_stats_expose"));
            if (c(haVar)) {
                i2 = 1000;
            } else {
                i2 = m761a(haVar) ? 3000 : -1;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i2));
            notification.extras.putString("target_package", a(haVar));
        }
        String str2 = m533a.m500a() != null ? m533a.m500a().get("message_count") : null;
        if (com.xiaomi.push.j.m630a() && str2 != null) {
            try {
                ag.a(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                ds.a(context.getApplicationContext()).b(haVar.b(), b(haVar), m533a.m499a(), "8");
                com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e);
            }
        }
        String a6 = a(haVar);
        ag.m692a(notification, a6);
        final af a7 = af.a(context, a6);
        if (com.xiaomi.push.j.m631a(context) && f1022a != null) {
            f1022a.a(haVar, m533a.m500a(), b2, notification);
        }
        if (com.xiaomi.push.j.m631a(context) && f1022a != null && f1022a.a(m533a.m500a(), b2, notification)) {
            com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
        } else {
            a7.a(b2, notification);
            cVar.f1031a = true;
            com.xiaomi.channel.commonutils.logger.b.m54a("notification: " + m533a.m499a() + " is notifyied");
        }
        if (com.xiaomi.push.j.m630a() && com.xiaomi.push.j.m631a(context)) {
            ad.a().a(context, b2, notification);
            bb.m717a(context, a6, b2, m533a.m499a(), notification);
        }
        if (m761a(haVar)) {
            ds.a(context.getApplicationContext()).a(haVar.b(), b(haVar), m533a.m499a(), 3002, null);
        }
        if (c(haVar)) {
            ds.a(context.getApplicationContext()).a(haVar.b(), b(haVar), m533a.m499a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String m499a = m533a.m499a();
            com.xiaomi.push.ad a8 = com.xiaomi.push.ad.a(context);
            int a9 = a(m533a.m500a());
            if (a9 > 0 && !TextUtils.isEmpty(m499a)) {
                final String str3 = "n_timeout_" + m499a;
                a8.m135a(str3);
                a8.b(new ad.a() { // from class: com.xiaomi.push.service.x.1
                    @Override // com.xiaomi.push.ad.a
                    /* renamed from: a */
                    public String mo187a() {
                        return str3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a7.a(b2);
                    }
                }, a9);
            }
        }
        Pair<Integer, ha> pair = new Pair<>(Integer.valueOf(b2), haVar);
        LinkedList<Pair<Integer, ha>> linkedList = f1023a;
        synchronized (linkedList) {
            linkedList.add(pair);
            if (linkedList.size() > 100) {
                linkedList.remove();
            }
        }
        return cVar;
    }

    private static void a(Context context, Intent intent, ha haVar, gr grVar, String str, int i) {
        if (haVar == null || grVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = a(grVar.m500a(), i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (an.a.equals(a2) || an.b.equals(a2) || an.c.equals(a2)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", haVar.f652a);
            if (!TextUtils.isEmpty(haVar.f656b)) {
                intent.putExtra("target_package", haVar.f656b);
            }
            intent.putExtra("job_key", a(grVar.m500a(), "jobkey"));
            intent.putExtra(i + "_target_component", a(context, haVar.f656b, grVar.m500a(), i));
        }
    }

    private static boolean a(Context context, ha haVar, String str) {
        if (haVar != null && haVar.m533a() != null && haVar.m533a().m500a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(haVar.m533a().m500a().get("use_clicked_activity")) && j.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("should clicked activity params are null.");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0072, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.push.gr r4) {
        /*
            java.lang.String r0 = r4.m507c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.m500a()
            if (r4 == 0) goto L73
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L51
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            r0 = r3
        L42:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
            goto L72
        L51:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L73
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L64
            r0 = r3
        L64:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
        L72:
            r1 = r3
        L73:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.gr):java.lang.String[]");
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03ab  */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.xiaomi.push.service.x.b a(android.content.Context r26, com.xiaomi.push.ha r27, byte[] r28, android.widget.RemoteViews r29, android.app.PendingIntent r30, int r31) {
        /*
            Method dump skipped, instructions count: 1129
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.ha, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.x$b");
    }

    /* renamed from: b, reason: collision with other method in class */
    private static boolean m766b(Map<String, String> map) {
        if (map == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
    }

    private static void a(du duVar, Context context, String str, ha haVar, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> m500a = haVar.m533a().m500a();
        if (TextUtils.equals("3", m500a.get("notification_style_type")) || TextUtils.equals("4", m500a.get("notification_style_type"))) {
            return;
        }
        if (m766b(m500a)) {
            for (int i2 = 1; i2 <= 3; i2++) {
                String str2 = m500a.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, haVar, bArr, i, i2)) != null) {
                    duVar.addAction(0, str2, a5);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(m500a.get("notification_style_button_left_name")) && (a4 = a(context, str, haVar, bArr, i, 1)) != null) {
            duVar.addAction(0, m500a.get("notification_style_button_left_name"), a4);
        }
        if (!TextUtils.isEmpty(m500a.get("notification_style_button_mid_name")) && (a3 = a(context, str, haVar, bArr, i, 2)) != null) {
            duVar.addAction(0, m500a.get("notification_style_button_mid_name"), a3);
        }
        if (TextUtils.isEmpty(m500a.get("notification_style_button_right_name")) || (a2 = a(context, str, haVar, bArr, i, 3)) == null) {
            return;
        }
        duVar.addAction(0, m500a.get("notification_style_button_right_name"), a2);
    }

    public static String a(Map<String, String> map, int i) {
        String format;
        if (i == 0) {
            format = "notify_effect";
        } else {
            format = m766b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Intent m756a(Context context, String str, Map<String, String> map, int i) {
        if (m766b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        }
        if (i == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        }
        if (i == 2) {
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        if (i == 3) {
            return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
        }
        if (i != 4) {
            return null;
        }
        return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.Intent a(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    private static du a(Context context, ha haVar, byte[] bArr, String str, int i) {
        PendingIntent a2;
        String a3 = a(haVar);
        Map<String, String> m500a = haVar.m533a().m500a();
        String str2 = m500a.get("notification_style_type");
        du a4 = (!com.xiaomi.push.j.m631a(context) || f1022a == null) ? null : f1022a.a(context, i, a3, m500a);
        if (a4 != null) {
            a4.a(m500a);
            return a4;
        }
        if ("2".equals(str2)) {
            du duVar = new du(context);
            Bitmap a5 = TextUtils.isEmpty(m500a.get("notification_bigPic_uri")) ? null : a(context, m500a.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                com.xiaomi.channel.commonutils.logger.b.m54a("can not get big picture.");
                return duVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(duVar);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            duVar.setStyle(bigPictureStyle);
            return duVar;
        }
        if ("1".equals(str2)) {
            du duVar2 = new du(context);
            duVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return duVar2;
        }
        if ("4".equals(str2) && com.xiaomi.push.j.m630a()) {
            dt dtVar = new dt(context, a3);
            if (!TextUtils.isEmpty(m500a.get("notification_banner_image_uri"))) {
                dtVar.setLargeIcon(a(context, m500a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m500a.get("notification_banner_icon_uri"))) {
                dtVar.b(a(context, m500a.get("notification_banner_icon_uri"), false));
            }
            dtVar.a(m500a);
            return dtVar;
        }
        if ("3".equals(str2) && com.xiaomi.push.j.m630a()) {
            dv dvVar = new dv(context, i, a3);
            if (!TextUtils.isEmpty(m500a.get("notification_colorful_button_text")) && (a2 = a(context, a3, haVar, bArr, i, 4)) != null) {
                dvVar.a(m500a.get("notification_colorful_button_text"), a2).mo366a(m500a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m500a.get("notification_colorful_bg_color"))) {
                dvVar.b(m500a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m500a.get("notification_colorful_bg_image_uri"))) {
                dvVar.setLargeIcon(a(context, m500a.get("notification_colorful_bg_image_uri"), false));
            }
            dvVar.a(m500a);
            return dvVar;
        }
        return new du(context);
    }

    private static RemoteViews a(Context context, ha haVar, byte[] bArr) {
        JSONObject jSONObject;
        gr m533a = haVar.m533a();
        String a2 = a(haVar);
        if (m533a == null || m533a.m500a() == null) {
            return null;
        }
        Map<String, String> m500a = m533a.m500a();
        String str = m500a.get("layout_name");
        String str2 = m500a.get("layout_value");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
            int INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier = INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier(resourcesForApplication, str, "layout", a2);
            if (INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier == 0) {
                return null;
            }
            RemoteViews android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot = android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot(no0.a.b((Object) null, (Object) null, "com/xiaomi/push/service/x", "a", "", "x"), a2, INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier);
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                if (jSONObject2.has("text")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("text");
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject3.getString(next);
                        int INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier2 = INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier(resourcesForApplication, next, "id", a2);
                        if (INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier2 > 0) {
                            jSONObject = jSONObject3;
                            android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/xiaomi/push/service/x", "a", "", "x"), INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier2, string);
                        } else {
                            jSONObject = jSONObject3;
                        }
                        jSONObject3 = jSONObject;
                    }
                }
                if (jSONObject2.has("image")) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("image");
                    Iterator<String> keys2 = jSONObject4.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String string2 = jSONObject4.getString(next2);
                        int INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier3 = INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier(resourcesForApplication, next2, "id", a2);
                        int INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier4 = INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier(resourcesForApplication, string2, "drawable", a2);
                        if (INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier3 > 0) {
                            android_widget_RemoteViews_setImageViewResource__com_bytedance_mute_MuteKnotProxy_setImageViewResource_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/xiaomi/push/service/x", "a", "", "x"), INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier3, INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier4);
                        }
                    }
                }
                if (jSONObject2.has("time")) {
                    JSONObject jSONObject5 = jSONObject2.getJSONObject("time");
                    Iterator<String> keys3 = jSONObject5.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        String string3 = jSONObject5.getString(next3);
                        if (string3.length() == 0) {
                            string3 = "yy-MM-dd hh:mm";
                        }
                        int INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier5 = INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier(resourcesForApplication, next3, "id", a2);
                        if (INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier5 > 0) {
                            android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/xiaomi/push/service/x", "a", "", "x"), INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                        }
                    }
                }
                return android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot;
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static String a(ha haVar) {
        gr m533a;
        if ("com.xiaomi.xmsf".equals(haVar.f656b) && (m533a = haVar.m533a()) != null && m533a.m500a() != null) {
            String str = m533a.m500a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return haVar.f656b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m758a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int hashCode;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        af a2 = af.a(context, str);
        List<StatusBarNotification> m691b = a2.m691b();
        if (com.xiaomi.push.r.a(m691b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i == -1) {
            hashCode = 0;
            z = true;
        } else {
            hashCode = ((str.hashCode() / 10) * 10) + i;
        }
        Iterator<StatusBarNotification> it2 = m691b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            StatusBarNotification next = it2.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    a2.a(id);
                } else if (hashCode == id) {
                    d.a(context, next, i2);
                    linkedList.add(next);
                    a2.a(id);
                    break;
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        af a2 = af.a(context, str);
        List<StatusBarNotification> m691b = a2.m691b();
        if (com.xiaomi.push.r.a(m691b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m691b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String a3 = ag.a(notification);
                String b2 = ag.b(notification);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2) && a(a3, str2) && a(b2, str3)) {
                    linkedList.add(statusBarNotification);
                    a2.a(id);
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        az.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m762a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static boolean a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        String m499a = grVar.m499a();
        return !TextUtils.isEmpty(m499a) && m499a.length() == 22 && "satuigmo".indexOf(m499a.charAt(0)) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m761a(ha haVar) {
        gr m533a = haVar.m533a();
        return a(m533a) && m533a.l();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m765b(ha haVar) {
        gr m533a = haVar.m533a();
        return a(m533a) && m533a.f566b == 1 && !m761a(haVar);
    }

    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = f1024a.submit(new a(str, context, z));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (ExecutionException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    submit.cancel(true);
                    return null;
                }
            } catch (InterruptedException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                submit.cancel(true);
                return null;
            } catch (TimeoutException e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    private static String a(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return com.xiaomi.push.g.m460b(context, str);
    }

    private static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.setFlags(intent.getFlags() & (-2) & (-3) & (-65) & (-129));
    }

    private static void a(Context context, String str, du duVar, Map<String, String> map) {
        int a2 = a(context, str, "mipush_small_notification");
        int a3 = a(context, str, "mipush_notification");
        if (com.xiaomi.push.j.m631a(context)) {
            if (a2 > 0 && a3 > 0) {
                com_xiaomi_push_du_setSmallIcon__com_bytedance_mute_MuteKnotProxy_setSmallIcon_knot(no0.a.b(duVar, (Object) null, "com/xiaomi/push/service/x", "a", "", "x"), a2);
                duVar.setLargeIcon(a(context, a3));
                return;
            } else {
                b(context, str, duVar, map);
                return;
            }
        }
        if (a2 > 0) {
            com_xiaomi_push_du_setSmallIcon__com_bytedance_mute_MuteKnotProxy_setSmallIcon_knot(no0.a.b(duVar, (Object) null, "com/xiaomi/push/service/x", "a", "", "x"), a2);
        } else {
            b(context, str, duVar, map);
        }
        if (a3 > 0) {
            duVar.setLargeIcon(a(context, a3));
        }
    }

    private static class a implements Callable<Bitmap> {
        private Context a;

        /* renamed from: a, reason: collision with other field name */
        private String f1027a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f1028a;

        static {
            Covode.recordClassIndex(655748);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            if (!TextUtils.isEmpty(this.f1027a)) {
                if (this.f1027a.startsWith("http")) {
                    ae.b a = ae.a(this.a, this.f1027a, this.f1028a);
                    if (a != null) {
                        return a.f912a;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m54a("Failed get online picture/icon resource");
                    return null;
                }
                Bitmap a2 = ae.a(this.a, this.f1027a);
                if (a2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("Failed get online picture/icon resource");
                    return a2;
                }
                return a2;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f1027a = str;
            this.f1028a = z;
        }
    }

    static {
        Covode.recordClassIndex(655747);
        a = 0L;
        f1023a = new LinkedList<>();
        f1024a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("ush/service/x"), "com.xiaomi.push.service.x");
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    public static boolean d(ha haVar) {
        if (haVar.a() == ge.Registration) {
            return true;
        }
        return false;
    }

    public static boolean e(ha haVar) {
        if (!m761a(haVar) && !c(haVar) && !m765b(haVar)) {
            return false;
        }
        return true;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
            return 0;
        }
    }

    private static int a(Map<String, String> map) {
        String str;
        if (map == null) {
            str = null;
        } else {
            str = map.get("timeout");
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
            return 3;
        }
    }

    public static boolean c(ha haVar) {
        gr m533a = haVar.m533a();
        if (a(m533a) && m533a.f566b == 0 && !m761a(haVar)) {
            return true;
        }
        return false;
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.av.a(a2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static String b(ha haVar) {
        if (m761a(haVar)) {
            return "E100002";
        }
        if (c(haVar)) {
            return "E100000";
        }
        if (m765b(haVar)) {
            return "E100001";
        }
        if (d(haVar)) {
            return "E100003";
        }
        return "";
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* renamed from: b, reason: collision with other method in class */
    static boolean m764b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b, reason: collision with other method in class */
    public static void m763b(Context context, String str) {
        if (com.xiaomi.push.j.m631a(context) && f1022a != null && !TextUtils.isEmpty(str)) {
            f1022a.a(str);
        }
    }

    static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    @Proxy("getLaunchIntentForPackage")
    @TargetClass("android.content.pm.PackageManager")
    public static Intent INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(PackageManager packageManager, String str) {
        if (PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.phoenix.read", "com.dragon.read.pages.splash.SplashActivity"));
        return intent;
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            if (a3 > 0) {
                a2 = a3;
            } else {
                a2 = context.getApplicationInfo().icon;
            }
        }
        if (a2 == 0) {
            return context.getApplicationInfo().logo;
        }
        return a2;
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier(context.getResources(), str2, "drawable", str);
        }
        return 0;
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    @Proxy("getActivity")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.app.PendingIntent")
    public static PendingIntent INVOKESTATIC_com_xiaomi_push_service_x_com_dragon_read_aop_target31_PendingIntentAop_getActivity(Context context, int i, Intent intent, int i2) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 31) {
            boolean z2 = true;
            if ((67108864 & i2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i2 & 33554432) == 0) {
                z2 = false;
            }
            if (!z2 && !z) {
                i2 |= 33554432;
            }
        }
        return PendingIntent.getActivity(context, i, intent, i2);
    }

    private static int a(Context context, String str, Map<String, String> map, int i) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i);
        if (b2 != null && (a2 = j.a(context, b2)) != null) {
            return a2.hashCode();
        }
        return 0;
    }

    @Proxy("getIdentifier")
    @TargetClass("android.content.res.Resources")
    @Skip({"com.bytedance.frameworks.plugin.core.res.MiraResourcesWrapper"})
    public static int INVOKEVIRTUAL_com_xiaomi_push_service_x_com_dragon_read_resource_ResourceAop_getIdentifier(Resources resources, String name, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!ResourceOpt.a.g()) {
            Integer valueOf = Integer.valueOf(resources.getIdentifier(name, str, str2));
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type kotlin.Int");
            return valueOf.intValue();
        }
        x55.b bVar = x55.b.a;
        Integer e = bVar.e(name, str, str2);
        if (e != null) {
            return e.intValue();
        }
        Integer valueOf2 = Integer.valueOf(resources.getIdentifier(name, str, str2));
        Intrinsics.checkNotNull(valueOf2, "null cannot be cast to non-null type kotlin.Int");
        bVar.b(valueOf2.intValue(), name, str, str2);
        return valueOf2.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(android.content.Context r7, java.lang.String r8, com.xiaomi.push.du r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            boolean r0 = com.xiaomi.push.j.m631a(r7)
            if (r0 != 0) goto L3a
            java.lang.String r0 = "fcm_icon_uri"
            java.lang.String r0 = a(r10, r0)
            java.lang.String r1 = "fcm_icon_color"
            java.lang.String r10 = a(r10, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L3a
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L3a
            int r0 = a(r7, r8, r0)
            if (r0 <= 0) goto L3a
            r2 = 0
            java.lang.String r3 = "com/xiaomi/push/service/x"
            java.lang.String r4 = "b"
            java.lang.String r5 = ""
            java.lang.String r6 = "x"
            r1 = r9
            no0.a r1 = no0.a.b(r1, r2, r3, r4, r5, r6)
            com_xiaomi_push_du_setSmallIcon__com_bytedance_mute_MuteKnotProxy_setSmallIcon_knot(r1, r0)
            r9.mo366a(r10)
            r10 = 1
            goto L3b
        L3a:
            r10 = 0
        L3b:
            if (r10 != 0) goto L64
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 < r0) goto L4f
            int r7 = com.xiaomi.push.service.ag.a(r7, r8)
            android.graphics.drawable.Icon r7 = android.graphics.drawable.Icon.createWithResource(r8, r7)
            r9.setSmallIcon(r7)
            goto L64
        L4f:
            int r7 = b(r7, r8)
            r1 = 0
            java.lang.String r2 = "com/xiaomi/push/service/x"
            java.lang.String r3 = "b"
            java.lang.String r4 = ""
            java.lang.String r5 = "x"
            r0 = r9
            no0.a r8 = no0.a.b(r0, r1, r2, r3, r4, r5)
            com_xiaomi_push_du_setSmallIcon__com_bytedance_mute_MuteKnotProxy_setSmallIcon_knot(r8, r7)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, com.xiaomi.push.du, java.util.Map):void");
    }

    private static PendingIntent a(Context context, ha haVar, String str, byte[] bArr, int i) {
        return a(context, haVar, str, bArr, i, 0, a(context, haVar, str));
    }

    private static PendingIntent a(Context context, String str, ha haVar, byte[] bArr, int i, int i2) {
        Map<String, String> m500a = haVar.m533a().m500a();
        if (m500a == null) {
            return null;
        }
        boolean a2 = a(context, haVar, str);
        if (a2) {
            return a(context, haVar, str, bArr, i, i2, a2);
        }
        Intent m756a = m756a(context, str, m500a, i2);
        if (m756a == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return INVOKESTATIC_com_xiaomi_push_service_x_com_dragon_read_aop_target31_PendingIntentAop_getActivity(context, 0, m756a, 167772160);
        }
        return INVOKESTATIC_com_xiaomi_push_service_x_com_dragon_read_aop_target31_PendingIntentAop_getActivity(context, 0, m756a, 134217728);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.app.PendingIntent a(android.content.Context r16, com.xiaomi.push.ha r17, java.lang.String r18, byte[] r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.ha, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }
}
