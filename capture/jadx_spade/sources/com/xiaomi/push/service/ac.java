package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ac {
    private static final boolean a;

    private static void a(af afVar, NotificationChannel notificationChannel, String str) {
        int i;
        char c;
        int i2;
        Context m686a = afVar.m686a();
        String id = notificationChannel.getId();
        String a2 = af.a(id, afVar.m687a());
        boolean z = a;
        if (z) {
            a("appChannelId:" + id + " oldChannelId:" + a2);
        }
        if (com.xiaomi.push.j.m631a(m686a) && !TextUtils.equals(id, a2)) {
            NotificationManager notificationManager = (NotificationManager) m686a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
            NotificationChannel m685a = afVar.m685a(id);
            if (z) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + m685a);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a3 = a(id, notificationChannel2);
                if (z) {
                    a("copyXmsf copyXmsfChannel:" + a3);
                }
                if (m685a != null) {
                    i2 = a(m685a);
                    afVar.a(a3, i2 == 0);
                    c = 3;
                } else {
                    i2 = a(notificationChannel2);
                    a(m686a, afVar, a3, i2, notificationChannel2.getId());
                    c = 4;
                }
                b(m686a, id);
                notificationManager.deleteNotificationChannel(a2);
            } else if (m685a != null) {
                if (m675a(m686a, id) || !a(notificationChannel, m685a)) {
                    i2 = 0;
                    c = 0;
                } else {
                    if (z) {
                        a("appHack updateNotificationChannel:" + notificationChannel);
                    }
                    i2 = a(m685a);
                    afVar.a(notificationChannel, i2 == 0);
                    c = 2;
                }
            } else {
                if (z) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                afVar.a(notificationChannel);
                i2 = 0;
                c = 1;
            }
            i = i2;
        } else {
            NotificationChannel m685a2 = afVar.m685a(id);
            if (z) {
                a("elseLogic getNotificationChannel:" + m685a2);
            }
            if (m685a2 == null) {
                afVar.a(notificationChannel);
            }
            i = 0;
            c = 0;
        }
        f.a(afVar.m686a(), afVar.m687a(), id, notificationChannel.getImportance(), str, c == 1 || c == 4 || c == 3, i);
    }

    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z2 = true;
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z2 = z;
        }
        if (a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z2);
        }
        return z2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m675a(Context context, String str) {
        if (a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    static {
        Covode.recordClassIndex(655659);
        a = Log.isLoggable("NCHelper", 3);
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    private static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m55a("NCHelper", str);
    }

    private static int a(NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((Integer) com.xiaomi.push.av.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (a) {
                a("isUserLockedChannel:" + i + " " + notificationChannel);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m55a("NCHelper", "is user locked error" + e);
        }
        return i;
    }

    static void a(gr grVar) {
        Map<String, String> map;
        if (grVar != null && (map = grVar.f564a) != null && map.containsKey("REMOVE_CHANNEL_MARK")) {
            grVar.f560a = 0;
            grVar.f564a.remove("channel_id");
            grVar.f564a.remove("channel_importance");
            grVar.f564a.remove("channel_name");
            grVar.f564a.remove("channel_description");
            grVar.f564a.remove("channel_perm");
            com.xiaomi.channel.commonutils.logger.b.m54a("delete channel info by:" + grVar.f564a.get("REMOVE_CHANNEL_MARK"));
            grVar.f564a.remove("REMOVE_CHANNEL_MARK");
        }
    }

    public static void a(Context context, String str) {
        if (com.xiaomi.push.j.m631a(context) && !TextUtils.isEmpty(str)) {
            c(context, str);
            f.a(context, str);
        }
    }

    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    private static void b(Context context, String str) {
        if (a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            af a2 = af.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (a2.m690a(str2)) {
                    arrayList.add(str2);
                    if (a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }

    private static void a(Context context, List<String> list) {
        if (a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (!list.isEmpty()) {
            SharedPreferences.Editor edit = a(context).edit();
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                edit.remove(it2.next());
            }
            edit.apply();
        }
    }

    static void a(Context context, af afVar, NotificationChannel notificationChannel, int i, String str) {
        int i2;
        if (i > 0) {
            if (com.xiaomi.push.g.a(context) >= 2) {
                i2 = f.a(context.getPackageName(), str);
            } else {
                i2 = 0;
            }
            NotificationChannel a2 = a(notificationChannel.getId(), notificationChannel);
            if ((i & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    a2.setSound(null, null);
                } else {
                    a2.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    a2.enableVibration(false);
                } else {
                    a2.enableVibration(true);
                }
            }
            if ((i & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    a2.enableLights(false);
                } else {
                    a2.enableLights(true);
                }
            }
            if ((i & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                a2.setImportance(importance);
            }
            if ((i & 2) != 0) {
                a2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            afVar.a(a2);
            afVar.a(notificationChannel, true);
            f.a(afVar.m687a(), notificationChannel.getId(), i2, 0);
            return;
        }
        afVar.a(notificationChannel);
    }

    public static String a(af afVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        boolean z;
        String m688a = afVar.m688a(str);
        boolean z2 = a;
        if (z2) {
            a("createChannel: appChannelId:" + m688a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(m688a, charSequence, i2);
        notificationChannel.setDescription(str2);
        boolean z3 = false;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        notificationChannel.enableVibration(z);
        if ((i & 4) != 0) {
            z3 = true;
        }
        notificationChannel.enableLights(z3);
        if ((i & 1) != 0) {
            if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + afVar.m687a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
        } else {
            notificationChannel.setSound(null, null);
        }
        if (z2) {
            a("create channel:" + notificationChannel);
        }
        a(afVar, notificationChannel, str4);
        return m688a;
    }
}
