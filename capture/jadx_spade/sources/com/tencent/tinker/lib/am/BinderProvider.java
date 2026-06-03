package com.tencent.tinker.lib.am;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class BinderProvider extends ContentProvider {
    static {
        Covode.recordClassIndex(653716);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    protected abstract IBinder onBind();

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static IBinder queryBinder(Context context, Uri uri) {
        Bundle call = context.getContentResolver().call(uri, "query_binder", (String) null, (Bundle) null);
        if (call != null) {
            call.setClassLoader(BinderProvider.class.getClassLoader());
            BinderParcel binderParcel = (BinderParcel) call.getParcelable("Mute.BP");
            if (binderParcel != null) {
                return binderParcel.getBinder();
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        IBinder onBind;
        if ("query_binder".equals(str) && (onBind = onBind()) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("Mute.BP", new BinderParcel(onBind));
            return bundle2;
        }
        return null;
    }
}
