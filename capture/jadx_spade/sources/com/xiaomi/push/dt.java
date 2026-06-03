package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.ResTranUtils;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dt extends dw {
    private int a;
    private Bitmap b;
    private Bitmap c;

    static {
        Covode.recordClassIndex(655469);
    }

    public static void android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a aVar, int i, Bitmap bitmap) {
        MuteLog.i("Mute.Knot", "RemoteViews.setImageViewBitmap, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setImageViewBitmap(ResTranUtils.transResourceId(i, "id"), bitmap);
    }

    public static void android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a aVar, int i, int i2) {
        MuteLog.i("Mute.Knot", "RemoteViews.setTextColor2, viewId[0x%s] color[0x%s]", Integer.toHexString(i), Integer.toHexString(i2));
        ((RemoteViews) aVar.b).setTextColor(ResTranUtils.transResourceId(i, "id"), i2);
    }

    public static void android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a aVar, int i, CharSequence charSequence) {
        MuteLog.i("Mute.Knot", "RemoteViews.setTextViewText, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setTextViewText(ResTranUtils.transResourceId(i, "id"), charSequence);
    }

    @Override // com.xiaomi.push.dw, android.app.Notification.Builder
    /* renamed from: a */
    public dw setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    protected String mo371a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.dw
    protected String b() {
        return null;
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a, reason: collision with other method in class */
    protected boolean mo365a() {
        if (!j.m630a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a = a(a().getResources(), "bg", "id", a().getPackageName());
        int a2 = a(resources, "icon", "id", packageName);
        int a3 = a(resources, "title", "id", packageName);
        if (a == 0 || a2 == 0 || a3 == 0 || j.a(a()) < 9) {
            return false;
        }
        return true;
    }

    @Override // com.xiaomi.push.dw, com.xiaomi.push.du
    /* renamed from: a, reason: collision with other method in class */
    public void mo364a() {
        int i;
        if (m374b() && this.b != null) {
            super.mo364a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a = a(resources, "bg", "id", packageName);
            if (j.a(a()) >= 10) {
                RemoteViews m370a = m370a();
                android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a, this, "com/xiaomi/push/dt", "a", "", "dt"), a, a(this.b, 30.0f));
            } else {
                RemoteViews m370a2 = m370a();
                android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a2, this, "com/xiaomi/push/dt", "a", "", "dt"), a, this.b);
            }
            int a2 = a(resources, "icon", "id", packageName);
            if (this.c != null) {
                RemoteViews m370a3 = m370a();
                android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a3, this, "com/xiaomi/push/dt", "a", "", "dt"), a2, this.c);
            } else {
                a(a2);
            }
            int a3 = a(resources, "title", "id", packageName);
            RemoteViews m370a4 = m370a();
            android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(m370a4, this, "com/xiaomi/push/dt", "a", "", "dt"), a3, ((dw) this).f341a);
            Map<String, String> map = ((dw) this).f344a;
            if (map != null && this.a == 16777216) {
                mo366a(map.get("notification_image_text_color"));
            }
            RemoteViews m370a5 = m370a();
            int i2 = this.a;
            if (i2 != 16777216 && m372a(i2)) {
                i = -16777216;
            } else {
                i = -1;
            }
            android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a.b(m370a5, this, "com/xiaomi/push/dt", "a", "", "dt"), a3, i);
            setCustomContentView(m370a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        m373b();
    }

    public dt b(Bitmap bitmap) {
        if (m374b() && bitmap != null) {
            this.c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.du
    /* renamed from: a */
    public dt mo366a(String str) {
        if (m374b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m54a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    public dt setLargeIcon(Bitmap bitmap) {
        if (m374b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    public dt(Context context, String str) {
        super(context, str);
        this.a = 16777216;
    }
}
