package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.ResTranUtils;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dv extends dw {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private PendingIntent f336a;
    private int b;

    /* renamed from: b, reason: collision with other field name */
    private Bitmap f337b;
    private int c;

    /* renamed from: c, reason: collision with other field name */
    private CharSequence f338c;

    static {
        Covode.recordClassIndex(655471);
    }

    public static void android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a aVar, int i, Bitmap bitmap) {
        MuteLog.i("Mute.Knot", "RemoteViews.setImageViewBitmap, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setImageViewBitmap(ResTranUtils.transResourceId(i, "id"), bitmap);
    }

    public static void android_widget_RemoteViews_setOnClickPendingIntent__com_bytedance_mute_MuteKnotProxy_setOnClickPendingIntent_knot(no0.a aVar, int i, PendingIntent pendingIntent) {
        MuteLog.i("Mute.Knot", "RemoteViews.setOnClickPendingIntent, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setOnClickPendingIntent(ResTranUtils.transResourceId(i, "id"), pendingIntent);
    }

    public static void android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a aVar, int i, int i2) {
        MuteLog.i("Mute.Knot", "RemoteViews.setTextColor2, viewId[0x%s] color[0x%s]", Integer.toHexString(i), Integer.toHexString(i2));
        ((RemoteViews) aVar.b).setTextColor(ResTranUtils.transResourceId(i, "id"), i2);
    }

    public static void android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a aVar, int i, CharSequence charSequence) {
        MuteLog.i("Mute.Knot", "RemoteViews.setTextViewText, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setTextViewText(ResTranUtils.transResourceId(i, "id"), charSequence);
    }

    public static void android_widget_RemoteViews_setViewPadding__com_bytedance_mute_MuteKnotProxy_setViewPadding_knot(no0.a aVar, int i, int i2, int i3, int i4, int i5) {
        MuteLog.i("Mute.Knot", "RemoteViews.setViewPadding, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setViewPadding(ResTranUtils.transResourceId(i, "id"), i2, i3, i4, i5);
    }

    public static void android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a aVar, int i, int i2) {
        MuteLog.i("Mute.Knot", "RemoteViews.setViewVisibility, viewId[0x%s]", Integer.toHexString(i));
        ((RemoteViews) aVar.b).setViewVisibility(ResTranUtils.transResourceId(i, "id"), i2);
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    protected String mo371a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dw
    protected String b() {
        return "notification_colorful_copy";
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    protected boolean mo365a() {
        if (!j.m630a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a = a(resources, "icon", "id", packageName);
        int a2 = a(resources, "title", "id", packageName);
        int a3 = a(resources, "content", "id", packageName);
        if (a == 0 || a2 == 0 || a3 == 0) {
            return false;
        }
        return true;
    }

    @Override // com.xiaomi.push.dw, com.xiaomi.push.du
    /* renamed from: a */
    public void mo364a() {
        int i;
        boolean z;
        int i2;
        if (m374b()) {
            super.mo364a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a = a(resources, "icon", "id", packageName);
            if (((dw) this).f339a == null) {
                a(a);
            } else {
                android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a, ((dw) this).f339a);
            }
            int a2 = a(resources, "title", "id", packageName);
            int a3 = a(resources, "content", "id", packageName);
            android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a2, ((dw) this).f341a);
            android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a3, ((dw) this).f346b);
            if (!TextUtils.isEmpty(this.f338c)) {
                int a4 = a(resources, "buttonContainer", "id", packageName);
                int a5 = a(resources, "button", "id", packageName);
                int a6 = a(resources, "buttonBg", "id", packageName);
                android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a4, 0);
                android_widget_RemoteViews_setTextViewText__com_bytedance_mute_MuteKnotProxy_setTextViewText_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a5, this.f338c);
                android_widget_RemoteViews_setOnClickPendingIntent__com_bytedance_mute_MuteKnotProxy_setOnClickPendingIntent_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a4, this.f336a);
                if (this.b != 16777216) {
                    int a7 = a(70.0f);
                    int a8 = a(29.0f);
                    android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a6, com.xiaomi.push.service.x.a(a(this.b, a7, a8, a8 / 2.0f)));
                    RemoteViews m370a = m370a();
                    if (m372a(this.b)) {
                        i2 = -1;
                    } else {
                        i2 = -16777216;
                    }
                    android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a.b(m370a, this, "com/xiaomi/push/dv", "a", "", "dv"), a5, i2);
                }
            }
            int a9 = a(resources, "bg", "id", packageName);
            int a10 = a(resources, "container", "id", packageName);
            if (this.a != 16777216) {
                if (j.a(a()) >= 10) {
                    android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a9, com.xiaomi.push.service.x.a(a(this.a, 984, 192, 30.0f)));
                } else {
                    android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a9, com.xiaomi.push.service.x.a(a(this.a, 984, 192, 0.0f)));
                }
                a(m370a(), a10, a2, a3, m372a(this.a));
            } else if (this.f337b != null) {
                if (j.a(a()) >= 10) {
                    android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a9, a(this.f337b, 30.0f));
                } else {
                    android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a9, this.f337b);
                }
                Map<String, String> map = ((dw) this).f344a;
                if (map != null) {
                    i = 16777216;
                    if (this.c == 16777216) {
                        c(map.get("notification_image_text_color"));
                    }
                } else {
                    i = 16777216;
                }
                int i3 = this.c;
                if (i3 != i && m372a(i3)) {
                    z = false;
                } else {
                    z = true;
                }
                a(m370a(), a10, a2, a3, z);
            } else if (Build.VERSION.SDK_INT >= 24) {
                android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a, 8);
                android_widget_RemoteViews_setViewVisibility__com_bytedance_mute_MuteKnotProxy_setViewVisibility_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dv", "a", "", "dv"), a9, 8);
                try {
                    av.a((Object) this, "setStyle", q.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m370a());
            return;
        }
        m373b();
    }

    @Override // com.xiaomi.push.du
    /* renamed from: a */
    public dv mo366a(String str) {
        if (m374b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m54a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    public dv b(String str) {
        if (m374b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m54a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    public dv c(String str) {
        if (m374b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m54a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    public dv setLargeIcon(Bitmap bitmap) {
        if (m374b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f337b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    public dv a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m374b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f338c = charSequence;
            this.f336a = pendingIntent;
        }
        return this;
    }

    public dv(Context context, int i, String str) {
        super(context, i, str);
        this.a = 16777216;
        this.b = 16777216;
        this.c = 16777216;
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a = a(6.0f);
        android_widget_RemoteViews_setViewPadding__com_bytedance_mute_MuteKnotProxy_setViewPadding_knot(no0.a.b(remoteViews, this, "com/xiaomi/push/dv", "a", "", "dv"), i, a, 0, a, 0);
        if (z) {
            android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a.b(remoteViews, this, "com/xiaomi/push/dv", "a", "", "dv"), i2, -1);
            android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a.b(remoteViews, this, "com/xiaomi/push/dv", "a", "", "dv"), i3, -1);
        } else {
            android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a.b(remoteViews, this, "com/xiaomi/push/dv", "a", "", "dv"), i2, -16777216);
            android_widget_RemoteViews_setTextColor__com_bytedance_mute_MuteKnotProxy_setTextColor_knot(no0.a.b(remoteViews, this, "com/xiaomi/push/dv", "a", "", "dv"), i3, -16777216);
        }
    }
}
