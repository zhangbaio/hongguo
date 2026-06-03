package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ContentUriUtils {
    private static final Object a;

    private ContentUriUtils() {
    }

    private static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    static {
        Covode.recordClassIndex(654177);
        a = new Object();
    }

    public static Uri c(File file) {
        synchronized (a) {
        }
        return null;
    }

    public static boolean contentUriExists(String str) {
        boolean z;
        AssetFileDescriptor b = b(str);
        if (b != null) {
            z = true;
        } else {
            z = false;
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException unused) {
            }
        }
        return z;
    }

    public static boolean delete(String str) {
        if (c.f().getContentResolver().delete(Uri.parse(str), null, null) > 0) {
            return true;
        }
        return false;
    }

    private static boolean e(Cursor cursor) {
        int columnIndex;
        if (Build.VERSION.SDK_INT < 24 || (columnIndex = cursor.getColumnIndex("flags")) <= -1 || (cursor.getLong(columnIndex) & 512) == 0) {
            return false;
        }
        return true;
    }

    public static int openContentUriForRead(String str) {
        AssetFileDescriptor b = b(str);
        if (b != null) {
            return b.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }

    public static String getContentUriFromFilePath(String str) {
        try {
            Uri c = c(new PolarisFileWrapper(str));
            if (c != null) {
                return c.toString();
            }
            return null;
        } catch (IllegalArgumentException e) {
            h.b("ContentUriUtils", "Cannot retrieve content uri from file: %s", str, e);
            return null;
        }
    }

    public static String getMimeType(String str) {
        ContentResolver contentResolver = c.f().getContentResolver();
        Uri parse = Uri.parse(str);
        if (f(parse)) {
            String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
            if (streamTypes != null && streamTypes.length > 0) {
                return streamTypes[0];
            }
            return null;
        }
        return contentResolver.getType(parse);
    }

    public static String maybeGetDisplayName(String str) {
        try {
            String d = d(Uri.parse(str), c.f(), "_display_name");
            if (TextUtils.isEmpty(d)) {
                return null;
            }
            return d;
        } catch (Exception e) {
            h.m("ContentUriUtils", "Cannot open content uri: %s", str, e);
            return null;
        }
    }

    private static AssetFileDescriptor b(String str) {
        ContentResolver contentResolver = c.f().getContentResolver();
        Uri parse = Uri.parse(str);
        try {
            if (f(parse)) {
                String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
                if (streamTypes != null && streamTypes.length > 0) {
                    AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(parse, streamTypes[0], null);
                    if (openTypedAssetFileDescriptor != null && openTypedAssetFileDescriptor.getStartOffset() != 0) {
                        try {
                            openTypedAssetFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                        throw new SecurityException("Cannot open files with non-zero offset type.");
                    }
                    return openTypedAssetFileDescriptor;
                }
            } else {
                ParcelFileDescriptor openFileDescriptor = ContentResolverWrapper.openFileDescriptor(contentResolver, parse, "r");
                if (openFileDescriptor != null) {
                    return new AssetFileDescriptor(openFileDescriptor, 0L, -1L);
                }
            }
        } catch (Exception e) {
            h.m("ContentUriUtils", "Cannot open content uri: %s", str, e);
        }
        return null;
    }

    private static boolean f(Uri uri) {
        if (uri == null || !DocumentsContract.isDocumentUri(c.f(), uri)) {
            return false;
        }
        try {
            Cursor a2 = a(c.f().getContentResolver(), uri, null, null, null, null);
            if (a2 != null) {
                try {
                    if (a2.getCount() >= 1) {
                        a2.moveToFirst();
                        boolean e = e(a2);
                        a2.close();
                        return e;
                    }
                } finally {
                }
            }
            if (a2 != null) {
                a2.close();
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public static String d(Uri uri, Context context, String str) {
        String[] streamTypes;
        String extensionFromMimeType;
        if (uri == null) {
            return "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor a2 = a(contentResolver, uri, null, null, null, null);
            if (a2 != null) {
                try {
                    if (a2.getCount() >= 1) {
                        a2.moveToFirst();
                        int columnIndex = a2.getColumnIndex(str);
                        if (columnIndex == -1) {
                            a2.close();
                            return "";
                        }
                        String string = a2.getString(columnIndex);
                        if (e(a2) && (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) != null && streamTypes.length > 0 && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) != null) {
                            string = string + "." + extensionFromMimeType;
                        }
                        a2.close();
                        return string;
                    }
                } finally {
                }
            }
            if (a2 != null) {
                a2.close();
            }
        } catch (NullPointerException unused) {
        }
        return "";
    }
}
