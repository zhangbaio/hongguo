package com.tencent.tinker.lib.stub;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteMaxLoader;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseStubContentProvider extends ContentProvider {
    private ClassLoader mOriginClassLoader;

    public static final class CodeConst {
        static {
            Covode.recordClassIndex(653820);
        }
    }

    static {
        Covode.recordClassIndex(653819);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mOriginClassLoader = MuteMaxLoader.getOriginCL();
        MuteLog.d("Mute.BaseStubCP", "Mute.BaseStubCP onCreate", new Object[0]);
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        MuteLog.i("Mute.BaseStubCP", "getType, uri = %s", uri);
        String queryParameter = uri.getQueryParameter("tinker_target_authority");
        if (!TextUtils.equals(uri.getAuthority(), queryParameter)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(uri.getAuthority(), queryParameter);
                if (acquireContentProviderClient != null) {
                    Uri buildForwardUri = buildForwardUri(uri, queryParameter);
                    MuteLog.d("Mute.BaseStubCP", "getType client.getType(targetUri), %s", buildForwardUri);
                    return acquireContentProviderClient.getType(buildForwardUri);
                }
                return null;
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "getType acquireContentProviderClient.getType() failed. %s", e);
                return null;
            }
        }
        return null;
    }

    private synchronized ContentProviderClient acquireContentProviderClient(String str, String str2) {
        ProviderInfo resolveContentProvider = getContext().getPackageManager().resolveContentProvider(str, 0);
        ProviderInfo callResolveContentProvider = callResolveContentProvider(str2, 0);
        MuteLog.d("Mute.BaseStubCP", "acquireContentProviderClient, " + callResolveContentProvider + " <<>> " + resolveContentProvider, new Object[0]);
        if (callResolveContentProvider != null) {
            return getContext().getContentResolver().acquireContentProviderClient(str2);
        }
        return null;
    }

    private Uri buildForwardUri(Uri uri, String str) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(uri.getScheme());
        builder.authority(str);
        builder.path(uri.getPath());
        if (OSUtil.isAndroidHHigher()) {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str2 : queryParameterNames) {
                    if (!TextUtils.equals(str2, "tinker_target_authority")) {
                        builder.appendQueryParameter(str2, uri.getQueryParameter(str2));
                    }
                }
            }
        } else {
            builder.query(uri.getQuery());
        }
        builder.fragment(uri.getFragment());
        return builder.build();
    }

    private ProviderInfo callResolveContentProvider(String str, int i) {
        try {
            return (ProviderInfo) Class.forName("com.tencent.tinker.loader.hotplug.mira.pm", true, this.mOriginClassLoader).getDeclaredMethod("resolveContentProvider", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        MuteLog.i("Mute.BaseStubCP", "bulkInsert, uri = %s", uri);
        String queryParameter = uri.getQueryParameter("tinker_target_authority");
        if (!TextUtils.equals(uri.getAuthority(), queryParameter)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(uri.getAuthority(), queryParameter);
                if (acquireContentProviderClient != null) {
                    Uri buildForwardUri = buildForwardUri(uri, queryParameter);
                    MuteLog.d("Mute.BaseStubCP", "bulkInsert client.bulkInsert(targetUri), %s", buildForwardUri);
                    return acquireContentProviderClient.bulkInsert(buildForwardUri, contentValuesArr);
                }
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "bulkInsert acquireContentProviderClient.bulkInsert() failed. %s", e);
            }
        }
        return super.bulkInsert(uri, contentValuesArr);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        MuteLog.i("Mute.BaseStubCP", "insert, uri = %s", uri);
        String queryParameter = uri.getQueryParameter("tinker_target_authority");
        if (!TextUtils.equals(uri.getAuthority(), queryParameter)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(uri.getAuthority(), queryParameter);
                if (acquireContentProviderClient != null) {
                    Uri buildForwardUri = buildForwardUri(uri, queryParameter);
                    MuteLog.d("Mute.BaseStubCP", "insert client.insert(targetUri), %s", buildForwardUri);
                    return acquireContentProviderClient.insert(buildForwardUri, contentValues);
                }
                return null;
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "insert acquireContentProviderClient.insert() failed. %s", e);
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        MuteLog.i("Mute.BaseStubCP", "openFile, uri = %s", uri);
        String queryParameter = uri.getQueryParameter("tinker_target_authority");
        if (!TextUtils.equals(uri.getAuthority(), queryParameter)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(uri.getAuthority(), queryParameter);
                if (acquireContentProviderClient != null) {
                    MuteLog.d("Mute.BaseStubCP", "openFile client.openFile(uri), " + uri, new Object[0]);
                    return acquireContentProviderClient.openFile(uri, str);
                }
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "openFile acquireContentProviderClient.openFile() failed. %s", e);
            }
        }
        return super.openFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        MuteLog.i("Mute.BaseStubCP", "delete, uri = %s", uri);
        String queryParameter = uri.getQueryParameter("tinker_target_authority");
        if (!TextUtils.equals(uri.getAuthority(), queryParameter)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(uri.getAuthority(), queryParameter);
                if (acquireContentProviderClient != null) {
                    Uri buildForwardUri = buildForwardUri(uri, queryParameter);
                    MuteLog.d("Mute.BaseStubCP", "delete client.delete(targetUri), %s", buildForwardUri);
                    return acquireContentProviderClient.delete(buildForwardUri, str, strArr);
                }
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "delete acquireContentProviderClient.delete() failed. %s", e);
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        String str3;
        String str4 = null;
        if (bundle != null) {
            str3 = bundle.getString("tinker_stub_authority");
        } else {
            str3 = null;
        }
        if (bundle != null) {
            str4 = bundle.getString("tinker_target_authority");
        }
        MuteLog.i("Mute.BaseStubCP", "call target = " + str4 + ", stub = " + str3, new Object[0]);
        if (!TextUtils.equals(str3, str4)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(str3, str4);
                if (acquireContentProviderClient != null) {
                    MuteLog.d("Mute.BaseStubCP", "call client.call(method, arg, extras), " + str4, new Object[0]);
                    if (OSUtil.isAndroidJ_MR1Higher()) {
                        return acquireContentProviderClient.call(str, str2, bundle);
                    }
                    return call(acquireContentProviderClient, str, str2, bundle);
                }
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "call acquireContentProviderClient.call() failed. %s", e);
            }
        }
        return super.call(str, str2, bundle);
    }

    private Bundle call(ContentProviderClient contentProviderClient, String str, String str2, Bundle bundle) throws RemoteException {
        Object obj;
        ContentResolver contentResolver;
        Boolean bool = Boolean.FALSE;
        try {
            obj = FieldUtils.readField(contentProviderClient, "mContentProvider");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            obj = null;
        }
        try {
            contentResolver = (ContentResolver) FieldUtils.readField(contentProviderClient, "mContentResolver");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            contentResolver = null;
        }
        try {
            bool = (Boolean) FieldUtils.readField(contentProviderClient, "mStable");
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        try {
            MethodUtils.invokeMethod(obj, "call", new Object[]{str, str2, bundle}, new Class[]{String.class, String.class, Bundle.class});
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        } catch (Throwable th) {
            if (!bool.booleanValue()) {
                try {
                    MethodUtils.invokeMethod(contentResolver, "unstableProviderDied", obj);
                } catch (IllegalAccessException e7) {
                    e7.printStackTrace();
                } catch (NoSuchMethodException e8) {
                    e8.printStackTrace();
                } catch (InvocationTargetException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        MuteLog.i("Mute.BaseStubCP", "update, uri = %s", uri);
        String queryParameter = uri.getQueryParameter("tinker_target_authority");
        if (!TextUtils.equals(uri.getAuthority(), queryParameter)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(uri.getAuthority(), queryParameter);
                if (acquireContentProviderClient != null) {
                    Uri buildForwardUri = buildForwardUri(uri, queryParameter);
                    MuteLog.d("Mute.BaseStubCP", "update client.update(targetUri), %s", buildForwardUri);
                    return acquireContentProviderClient.update(buildForwardUri, contentValues, str, strArr);
                }
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "update acquireContentProviderClient.update() failed. %s", e);
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MuteLog.i("Mute.BaseStubCP", "query uri = %s", uri);
        String queryParameter = uri.getQueryParameter("tinker_target_authority");
        if (!TextUtils.equals(uri.getAuthority(), queryParameter)) {
            try {
                ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(uri.getAuthority(), queryParameter);
                if (acquireContentProviderClient != null) {
                    Uri buildForwardUri = buildForwardUri(uri, queryParameter);
                    MuteLog.d("Mute.BaseStubCP", "query client.query(targetUri), %s", buildForwardUri);
                    return acquireContentProviderClient.query(buildForwardUri, strArr, str, strArr2, str2);
                }
                return null;
            } catch (RemoteException e) {
                MuteLog.e("Mute.BaseStubCP", "query acquireContentProviderClient.query() failed. %s", e);
                return null;
            }
        }
        return null;
    }
}
