package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.ResourceOpt;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.ResTranUtils;
import com.vivo.push.h.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NotifyAdapterUtil {
    private static NotificationManager sNotificationManager;
    private static int sNotifyId;

    public static Notification.Builder android_app_Notification$Builder_setSmallIcon__com_bytedance_mute_MuteKnotProxy_setSmallIcon_knot(no0.a aVar, int i) {
        MuteLog.i("Mute.Knot", "Notification$Builder.setSmallIcon, icon[%s]", Integer.toHexString(i));
        return ((Notification.Builder) aVar.b).setSmallIcon(ResTranUtils.transResourceId(i, "drawable"));
    }

    public static RemoteViews android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot(no0.a aVar, String str, int i) {
        MuteLog.i("Mute.Knot", "RemoteViews.new1, %s layout[0x%s]", str, Integer.toHexString(i));
        return new RemoteViews(str, ResTranUtils.transResourceId(i, "layout"));
    }

    public static void android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a aVar, int i, Bitmap bitmap) {
        MuteLog.i("Mute.Knot", "RemoteViews.setImageViewBitmap, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setImageViewBitmap(ResTranUtils.transResourceId(i, "id"), bitmap);
    }

    public static void android_widget_RemoteViews_setImageViewResource__com_bytedance_mute_MuteKnotProxy_setImageViewResource_knot(no0.a aVar, int i, int i2) {
        MuteLog.i("Mute.Knot", "RemoteViews.setImageViewResource, viewId[0x%s] srcId[0x%s]", Integer.toHexString(i), Integer.toHexString(i2));
        ((RemoteViews) aVar.b).setImageViewResource(ResTranUtils.transResourceId(i, "id"), ResTranUtils.transResourceId(i2, "drawable"));
    }

    public static void android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a aVar, int i, int i2) {
        MuteLog.i("Mute.Knot", "RemoteViews.setTextColor2, viewId[0x%s] color[0x%s]", Integer.toHexString(i), Integer.toHexString(i2));
        ((RemoteViews) aVar.b).setTextColor(ResTranUtils.transResourceId(i, "id"), i2);
    }

    public static void android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a aVar, int i, CharSequence charSequence) {
        MuteLog.i("Mute.Knot", "RemoteViews.setTextViewText, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setTextViewText(ResTranUtils.transResourceId(i, "id"), charSequence);
    }

    public static void android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a aVar, int i, int i2) {
        MuteLog.i("Mute.Knot", "RemoteViews.setViewVisibility, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setViewVisibility(ResTranUtils.transResourceId(i, "id"), i2);
    }

    static {
        Covode.recordClassIndex(655173);
        sNotifyId = 20000000;
    }

    private static boolean isPullService() {
        if (m.a) {
            if (Build.VERSION.SDK_INT < 31) {
                return true;
            }
            return false;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return true;
        }
        return false;
    }

    public static void setNotifyId(int i) {
        sNotifyId = i;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    private static synchronized void initAdapter(Context context) {
        NotificationManager notificationManager;
        boolean z;
        String str;
        synchronized (NotifyAdapterUtil.class) {
            if (sNotificationManager == null) {
                sNotificationManager = (NotificationManager) context.getSystemService("notification");
            }
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("default");
                if (notificationChannel != null) {
                    CharSequence name = notificationChannel.getName();
                    if ("推送通知".equals(name) || "PUSH".equals(name)) {
                        sNotificationManager.deleteNotificationChannel("default");
                    }
                }
                NotificationChannel notificationChannel2 = sNotificationManager.getNotificationChannel("vivo_push_channel");
                StringBuilder sb = new StringBuilder("initAdapter PRIMARY_CHANNEL yi exist ？= ");
                if (notificationChannel2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append(" 是否支持创建推送通知渠道= ");
                sb.append(com.vivo.push.restructure.a.a().g().e());
                t.c("NotifyManager", sb.toString());
                if (!com.vivo.push.restructure.a.a().g().e() || notificationChannel2 == null) {
                    if (isZh(context)) {
                        str = "推送通知";
                    } else {
                        str = "PUSH";
                    }
                    NotificationChannel notificationChannel3 = new NotificationChannel("vivo_push_channel", str, 4);
                    notificationChannel3.setLightColor(-16711936);
                    notificationChannel3.enableVibration(true);
                    notificationChannel3.setLockscreenVisibility(1);
                    sNotificationManager.createNotificationChannel(notificationChannel3);
                }
            }
        }
    }

    private static boolean cancelNotify(Context context, int i) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(i);
            return true;
        }
        return false;
    }

    public static boolean repealNotifyById(Context context, long j) {
        int j2 = com.vivo.push.m.a().j();
        if (j2 == 0) {
            long b = ad.c().b("com.vivo.push.notify_key", -1L);
            if (b == j) {
                t.d("NotifyManager", "undo showed message ".concat(String.valueOf(j)));
                t.a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
                return cancelNotify(context, sNotifyId);
            }
            t.d("NotifyManager", "current showing message id " + b + " not match " + j);
            t.a(context, "与已展示的通知" + b + "与待回收的通知" + j + "不匹配");
            return false;
        }
        if (j2 == 1) {
            return cancelNotify(context, (int) j);
        }
        t.a("NotifyManager", "unknow cancle notify style ".concat(String.valueOf(j2)));
        return false;
    }

    @Proxy("notify")
    @TargetClass("android.app.NotificationManager")
    public static void INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_base_lancet_NotifyPushAop_notify(NotificationManager notificationManager, int i, Notification notification) {
        ko2.r.a.a((String) null, (String) null, i, notification);
        notificationManager.notify(i, notification);
    }

    @Proxy("getIdentifier")
    @TargetClass("android.content.res.Resources")
    @Skip({"com.bytedance.frameworks.plugin.core.res.MiraResourcesWrapper"})
    public static int INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(Resources resources, String name, String str, String str2) {
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

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        Notification build;
        int i;
        int i2;
        Bitmap bitmap;
        Bitmap bitmap2;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i3 = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong("pushId", j);
        if (com.vivo.push.restructure.a.a().e().m().isOpenMultiUser()) {
            bundle.putInt("sysUserId", v.a());
        }
        bundle.putInt("extra_vpush_type", 1);
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder builder = new Notification.Builder(context, "vivo_push_channel");
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builder.setExtras(bundle);
            build = builder.build();
        } else {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setExtras(bundle);
            build = builder2.build();
        }
        Notification notification = build;
        notification.priority = 2;
        notification.flags = 16;
        notification.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i3;
        }
        notification.icon = defaultSmallIconId;
        RemoteViews android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot = android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot(no0.a.b((Object) null, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_title", "id", packageName), title);
        android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            i = i3;
            i2 = 0;
            android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_when", "id", packageName), 0);
        } else {
            i = i3;
            i2 = 0;
            android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), suitIconId, i2);
        if (list != null && !list.isEmpty() && (bitmap2 = list.get(i2)) != null) {
            android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), suitIconId, bitmap2);
        } else {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i;
            }
            android_widget_RemoteViews_setImageViewResource__com_bytedance_mute_MuteKnotProxy_setImageViewResource_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), suitIconId, defaultNotifyIcon);
        }
        if (list != null && list.size() > 1) {
            bitmap = list.get(1);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
                android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_content", "id", packageName), 8);
                android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_cover", "id", packageName), 8);
                android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_pure_cover", "id", packageName), i2);
                android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_pure_cover", "id", packageName), bitmap);
            } else {
                android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_cover", "id", packageName), i2);
                android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_cover", "id", packageName), bitmap);
            }
        } else {
            android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationByCustom", "", "NotifyAdapterUtil"), INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_resource_ResourceAop_getIdentifier(resources, "notify_cover", "id", packageName), 8);
        }
        notification.contentView = android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot;
        if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            notification.bigContentView = android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(i2);
        t.d("NotifyManager", "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        notification.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification.defaults |= 2;
                        notification.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification.defaults = 2;
                notification.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification.defaults = 1;
        }
        i iVar = new i();
        Intent a = iVar.a(context, packageName, j, insideNotificationItem, notifyArriveCallbackByUser);
        if (a != null) {
            if (isPullService()) {
                notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), b.a(context, packageName, j, a, insideNotificationItem), 201326592);
            } else {
                new com.vivo.push.b.p(packageName, j, insideNotificationItem).b(a);
                notification.contentIntent = iVar.a(context, a);
            }
            if (sNotificationManager != null) {
                int j2 = com.vivo.push.m.a().j();
                try {
                    if (j2 == 0) {
                        INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_base_lancet_NotifyPushAop_notify(sNotificationManager, sNotifyId, notification);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    if (j2 == 1) {
                        INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_base_lancet_NotifyPushAop_notify(sNotificationManager, (int) j, notification);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    t.a("NotifyManager", "unknow notify style ".concat(String.valueOf(j2)));
                    return;
                } catch (Exception e) {
                    t.a("NotifyManager", e);
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        t.a("NotifyManager", "make notify intent error  ");
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        t.d("NotifyManager", "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j, i, notifyArriveCallbackByUser, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j, notifyArriveCallbackByUser, aVar);
        }
    }

    private static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        Bitmap bitmap;
        Notification.Builder builder;
        long j2;
        Bitmap decodeResource;
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        String content = insideNotificationItem.getContent();
        int i2 = context.getApplicationInfo().icon;
        boolean isShowTime = insideNotificationItem.isShowTime();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        Bitmap bitmap2 = null;
        if (list != null && !list.isEmpty()) {
            bitmap = list.get(0);
            if (bitmap != null && defaultNotifyIcon > 0 && (decodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) != null) {
                int width = decodeResource.getWidth();
                int height = decodeResource.getHeight();
                decodeResource.recycle();
                bitmap = d.a(bitmap, width, height);
            }
        } else {
            bitmap = null;
        }
        Bundle bundle = new Bundle();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            Notification.Builder builder2 = new Notification.Builder(context, "vivo_push_channel");
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            if (bitmap != null) {
                builder2.setLargeIcon(bitmap);
            }
            builder = builder2;
        } else {
            Notification.Builder builder3 = new Notification.Builder(context);
            if (bitmap != null) {
                builder3.setLargeIcon(bitmap);
            } else if (i3 <= 22) {
                builder3.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i2));
            }
            builder = builder3;
        }
        if (com.vivo.push.restructure.a.a().e().m().isOpenMultiUser()) {
            bundle.putInt("sysUserId", v.a());
        }
        bundle.putInt("extra_vpush_type", 1);
        bundle.putLong("pushId", j);
        builder.setExtras(bundle);
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId > 0) {
            i2 = defaultSmallIconId;
        }
        android_app_Notification$Builder_setSmallIcon__com_bytedance_mute_MuteKnotProxy_setSmallIcon_knot(no0.a.b(builder, (Object) null, "com/vivo/push/util/NotifyAdapterUtil", "pushNotificationBySystem", "", "NotifyAdapterUtil"), i2);
        if (insideNotificationItem.getCompatibleType() != 1) {
            builder.setContentTitle(title);
        }
        builder.setPriority(2);
        builder.setContentText(content);
        if (isShowTime) {
            j2 = System.currentTimeMillis();
        } else {
            j2 = 0;
        }
        builder.setWhen(j2);
        builder.setShowWhen(isShowTime);
        builder.setTicker(title);
        int ringerMode = audioManager.getRingerMode();
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        builder.setDefaults(3);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else if (ringerMode == 1) {
                        builder.setDefaults(2);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    }
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(2);
                builder.setVibrate(new long[]{0, 100, 200, 300});
            }
        } else if (ringerMode == 2) {
            builder.setDefaults(1);
        }
        if (list != null && list.size() > 1) {
            bitmap2 = list.get(1);
        }
        if (i != 1) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(title);
            bigTextStyle.bigText(content);
            builder.setStyle(bigTextStyle);
        }
        if (bitmap2 != null) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(title);
            bigPictureStyle.setSummaryText(content);
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        builder.setAutoCancel(true);
        i iVar = new i();
        Intent a = iVar.a(context, packageName, j, insideNotificationItem, notifyArriveCallbackByUser);
        if (a != null) {
            if (isPullService()) {
                builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), b.a(context, packageName, j, a, insideNotificationItem), 201326592));
            } else {
                new com.vivo.push.b.p(packageName, j, insideNotificationItem).b(a);
                builder.setContentIntent(iVar.a(context, a));
            }
            Notification build = builder.build();
            int j3 = com.vivo.push.m.a().j();
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                try {
                    if (j3 == 0) {
                        INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_base_lancet_NotifyPushAop_notify(notificationManager, sNotifyId, build);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    if (j3 == 1) {
                        INVOKEVIRTUAL_com_vivo_push_util_NotifyAdapterUtil_com_dragon_read_base_lancet_NotifyPushAop_notify(notificationManager, (int) j, build);
                        if (aVar != null) {
                            aVar.a();
                            return;
                        }
                        return;
                    }
                    t.a("NotifyManager", "unknow notify style ".concat(String.valueOf(j3)));
                    return;
                } catch (Exception e) {
                    t.a("NotifyManager", e);
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        t.a("NotifyManager", "make notify intent error  ");
    }
}
