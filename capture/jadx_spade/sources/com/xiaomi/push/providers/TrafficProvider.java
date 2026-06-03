package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.launch.n;
import com.ss.android.common.util.ToolUtils;
import com.xiaomi.push.fy;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TrafficProvider extends ContentProvider {
    private static final UriMatcher a;

    /* renamed from: a, reason: collision with other field name */
    public static final Uri f847a;

    /* renamed from: a, reason: collision with other field name */
    private SQLiteOpenHelper f848a;

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return com_xiaomi_push_providers_TrafficProvider_com_dragon_read_aop_ContentProviderAop_onCreate(this);
    }

    public boolean TrafficProvider__onCreate$___twin___() {
        this.f848a = new a(getContext());
        return true;
    }

    static {
        Covode.recordClassIndex(655625);
        f847a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");
        UriMatcher uriMatcher = new UriMatcher(-1);
        a = uriMatcher;
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert("onCreate")
    public static boolean com_xiaomi_push_providers_TrafficProvider_com_dragon_read_aop_ContentProviderAop_onCreate(TrafficProvider trafficProvider) {
        if (ToolUtils.isMainProcess(App.context())) {
            n.c M = n.M("ContentProvider_onCreate_" + trafficProvider.getClass().getSimpleName());
            boolean TrafficProvider__onCreate$___twin___ = trafficProvider.TrafficProvider__onCreate$___twin___();
            M.a();
            return TrafficProvider__onCreate$___twin___;
        }
        return trafficProvider.TrafficProvider__onCreate$___twin___();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (a.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (a.match(uri) == 2 && contentValues != null && contentValues.containsKey("imsi")) {
            fy.m452a(contentValues.getAsString("imsi"));
            return 0;
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f849a) {
            if (a.match(uri) == 1) {
                query = this.f848a.getReadableDatabase().query("traffic", strArr, str, strArr2, null, null, str2);
            } else {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
        }
        return query;
    }
}
