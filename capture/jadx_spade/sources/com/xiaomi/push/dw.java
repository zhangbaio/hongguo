package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.ResTranUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class dw extends du {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    protected Bitmap f339a;

    /* renamed from: a, reason: collision with other field name */
    private RemoteViews f340a;

    /* renamed from: a, reason: collision with other field name */
    protected CharSequence f341a;

    /* renamed from: a, reason: collision with other field name */
    private String f342a;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<Notification.Action> f343a;

    /* renamed from: a, reason: collision with other field name */
    protected Map<String, String> f344a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f345a;
    private int b;

    /* renamed from: b, reason: collision with other field name */
    protected CharSequence f346b;

    /* renamed from: b, reason: collision with other field name */
    private boolean f347b;

    static {
        Covode.recordClassIndex(655472);
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

    /* renamed from: a, reason: collision with other method in class */
    protected abstract String mo371a();

    protected void a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    protected abstract boolean mo365a();

    protected abstract String b();

    /* renamed from: a, reason: collision with other method in class */
    public final RemoteViews m370a() {
        return this.f340a;
    }

    @Override // com.xiaomi.push.du
    /* renamed from: a */
    protected void mo364a() {
        super.mo364a();
        Bundle bundle = new Bundle();
        if (m369d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f347b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f343a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f343a.size()];
            this.f343a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m368c() || !com.xiaomi.push.service.ag.m693a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f341a);
            bundle.putCharSequence("mipush.customContent", this.f346b);
        }
        addExtras(bundle);
    }

    protected void a(int i) {
        Bitmap a = a();
        if (a != null) {
            android_widget_RemoteViews_setImageViewBitmap__com_bytedance_mute_MuteKnotProxy_setImageViewBitmap_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dw", "a", "", "dw"), i, a);
            return;
        }
        int b = g.b(a(), this.f342a);
        if (b != 0) {
            android_widget_RemoteViews_setImageViewResource__com_bytedance_mute_MuteKnotProxy_setImageViewResource_knot(no0.a.b(m370a(), this, "com/xiaomi/push/dw", "a", "", "dw"), i, b);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    protected final boolean m372a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    private Bitmap a() {
        return com.xiaomi.push.service.x.a(g.m455a(a(), this.f342a));
    }

    private void d() {
        super.setContentTitle(this.f341a);
        super.setContentText(this.f346b);
    }

    private boolean e() {
        if (m369d() && f()) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    protected final boolean m374b() {
        return this.f345a;
    }

    private String c() {
        boolean e = e();
        this.f347b = e;
        if (e) {
            return b();
        }
        return mo371a();
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m369d() {
        if (!TextUtils.isEmpty(b()) && !TextUtils.isEmpty(this.f342a)) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    protected final void m373b() {
        super.setContentTitle(this.f341a);
        super.setContentText(this.f346b);
        Bitmap bitmap = this.f339a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m368c() {
        Map<String, String> map = this.f344a;
        if (map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"))) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    private void m367c() {
        int a = a(a().getResources(), c(), "layout", a().getPackageName());
        if (a != 0) {
            this.f340a = android_widget_RemoteViews__com_bytedance_mute_MuteKnotProxy_newRemoteViews1_new_knot(no0.a.b((Object) null, this, "com/xiaomi/push/dw", "c", "", "dw"), a().getPackageName(), a);
            this.f345a = mo365a();
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("create RemoteViews failed, no such layout resource was found");
    }

    private boolean f() {
        List<StatusBarNotification> m691b = com.xiaomi.push.service.af.a(a(), this.f342a).m691b();
        if (m691b != null && !m691b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : m691b) {
                if (statusBarNotification.getId() == this.a) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public dw setContentText(CharSequence charSequence) {
        this.f346b = charSequence;
        return this;
    }

    @Override // com.xiaomi.push.du
    public du a(Map<String, String> map) {
        this.f344a = map;
        return this;
    }

    protected int a(float f) {
        return (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dw addAction(Notification.Action action) {
        if (action != null) {
            this.f343a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dw setLargeIcon(Bitmap bitmap) {
        this.f339a = bitmap;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dw setContentTitle(CharSequence charSequence) {
        this.f341a = charSequence;
        return this;
    }

    public dw(Context context, String str) {
        this(context, 0, str);
    }

    protected Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public dw(Context context, int i, String str) {
        super(context);
        this.f343a = new ArrayList<>();
        this.b = 0;
        this.f342a = str;
        this.a = i;
        m367c();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dw addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }
}
