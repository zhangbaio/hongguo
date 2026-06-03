package em6;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import bytedance.util.BdFileUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.IncapableCause;
import com.zhihu.matisse.internal.entity.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private static final String a;

    private static int a(ExifInterface exifInterface, String str, int i) {
        Result preInvoke = new HeliosApiHook().preInvoke(100022, "android/media/ExifInterface", "getAttributeInt", exifInterface, new Object[]{str, Integer.valueOf(i)}, "int", new ExtraInfo(false, "(Ljava/lang/String;I)I"));
        return preInvoke.isIntercept() ? ((Integer) preInvoke.getReturnValue()).intValue() : exifInterface.getAttributeInt(str, i);
    }

    static {
        Covode.recordClassIndex(656161);
        a = c.class.getSimpleName();
    }

    private c() {
        throw new AssertionError("oops! the utility class is about to be instantiated...");
    }

    public static float d(long j) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("0.0");
        String format = decimalFormat.format((j / 1024.0f) / 1024.0f);
        Log.e(a, "getSizeInMB: " + format);
        return Float.valueOf(format.replaceAll(",", ".")).floatValue();
    }

    public static IncapableCause e(Context context, Item item) {
        if (!f(context, item)) {
            return new IncapableCause(context.getString(2131104504));
        }
        if (com.zhihu.matisse.internal.entity.a.b().j != null) {
            Iterator<zl6.a> it2 = com.zhihu.matisse.internal.entity.a.b().j.iterator();
            while (it2.hasNext()) {
                IncapableCause a2 = it2.next().a(context, item);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    private static boolean f(Context context, Item item) {
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Iterator<MimeType> it2 = com.zhihu.matisse.internal.entity.a.b().a.iterator();
        while (it2.hasNext()) {
            if (it2.next().checkType(context, contentResolver, item.getContentUri())) {
                return true;
            }
        }
        return false;
    }

    public static Point b(ContentResolver contentResolver, Uri uri) {
        BitmapFactory.Options options;
        InputStream openInputStream;
        InputStream inputStream = null;
        try {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                openInputStream = ContentResolverWrapper.openInputStream(contentResolver, uri);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (NullPointerException e2) {
            e = e2;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
            Point point = new Point(options.outWidth, options.outHeight);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return point;
        } catch (FileNotFoundException e4) {
            e = e4;
            inputStream = openInputStream;
            e.printStackTrace();
            Point point2 = new Point(0, 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return point2;
        } catch (NullPointerException e6) {
            e = e6;
            inputStream = openInputStream;
            e.printStackTrace();
            Point point3 = new Point(0, 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            return point3;
        } catch (Throwable th2) {
            th = th2;
            inputStream = openInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Point c(Uri uri, Activity activity) {
        ContentResolver contentResolver = activity.getContentResolver();
        Point b = b(contentResolver, uri);
        int i = b.x;
        int i2 = b.y;
        if (g(activity, contentResolver, uri)) {
            i = b.y;
            i2 = b.x;
        }
        if (i2 == 0) {
            return new Point(1600, 1600);
        }
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        float f = i;
        float f2 = r4.widthPixels / f;
        float f3 = i2;
        float f4 = r4.heightPixels / f3;
        if (f2 > f4) {
            return new Point((int) (f * f2), (int) (f3 * f4));
        }
        return new Point((int) (f * f2), (int) (f3 * f4));
    }

    private static boolean g(Context context, ContentResolver contentResolver, Uri uri) {
        ExifInterface a2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                InputStream openInputStream = ContentResolverWrapper.openInputStream(contentResolver, uri);
                if (openInputStream != null) {
                    a2 = new ExifInterface(openInputStream);
                } else {
                    a2 = null;
                }
            } else {
                a2 = a.a(BdFileUtils.convertUriToPath(context, uri));
            }
            if (a2 == null) {
                return false;
            }
            int a3 = a(a2, "Orientation", -1);
            if (a3 != 6 && a3 != 8) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            Log.e(a, "could not read exif info of the image: " + uri);
            return false;
        } catch (NullPointerException unused2) {
            Log.e(a, "Photo path is null.");
            return false;
        }
    }
}
