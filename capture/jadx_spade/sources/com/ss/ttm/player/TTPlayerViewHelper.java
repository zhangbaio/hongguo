package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class TTPlayerViewHelper {
    private static boolean sDeviceEnableSurfaceView;
    private static boolean sFetchedDeviceEnableSurfaceView;

    public static class Size {
        private int height;
        private int width;

        static {
            Covode.recordClassIndex(652196);
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public String toString() {
            return "size{w=" + this.width + ", h=" + this.height + '}';
        }

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    static {
        Covode.recordClassIndex(652195);
        sFetchedDeviceEnableSurfaceView = false;
        sDeviceEnableSurfaceView = false;
    }

    private TTPlayerViewHelper() {
        throw new UnsupportedOperationException("Don't instantiate");
    }

    private static boolean isMediaTekChipset() {
        String str = Build.HARDWARE;
        if (str == null) {
            return false;
        }
        return str.matches("mt[0-9]*");
    }

    private static boolean isDeviceOppoRealmeBrand() {
        String lowerCase = Build.BRAND.toLowerCase();
        if (!lowerCase.equals("oppo") && !lowerCase.equals("realme") && !lowerCase.equals("oneplus")) {
            return false;
        }
        return true;
    }

    private static boolean isOppoPropertyEnableSurfaceView() {
        try {
            Method declaredMethod = l3.a.q("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, "ro.oplus.display.reset_two_pq_layer", -1);
            if (invoke instanceof Integer) {
                if (((Integer) invoke).intValue() != 1) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            com.ss.vcbkit.a.b("TTPlayerView", "ttmn isSurfaceViewEnableByOppoProperty failed: " + e);
        }
        return false;
    }

    public static Rect getSurfaceRenderPosition(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof SurfaceView) {
            try {
                Method declaredMethod = SurfaceView.class.getDeclaredMethod("getSurfaceRenderPosition", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(view, new Object[0]);
                if (invoke instanceof Rect) {
                    return (Rect) invoke;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static boolean isEnableSurfaceView(Context context) {
        boolean z;
        if (!sFetchedDeviceEnableSurfaceView) {
            if (isDeviceOppoRealmeBrand() && isMediaTekChipset() && !isOppoPropertyEnableSurfaceView() && isOSIESwitchOffForOppoRealme(context)) {
                z = false;
            } else {
                z = true;
            }
            sDeviceEnableSurfaceView = z;
            sFetchedDeviceEnableSurfaceView = true;
        }
        return sDeviceEnableSurfaceView;
    }

    private static boolean isOSIESwitchOffForOppoRealme(Context context) {
        if (context == null) {
            return false;
        }
        try {
            int i = Settings.Secure.getInt(context.getContentResolver(), "osie_iris5_switch", -1);
            int i2 = Settings.Secure.getInt(context.getContentResolver(), "customize_multimedia_osie", -1);
            int i3 = Settings.Secure.getInt(context.getContentResolver(), "osie_video_display_switch", -1);
            if (i == 1 || i2 == 1 || i3 == 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.ss.vcbkit.a.b("TTPlayerView", "ttmn failed to read OSIE settings: " + e);
            return false;
        }
    }

    public static String objectToString(Object obj) {
        int lastIndexOf;
        if (obj == null) {
            return "Null";
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.isEmpty() && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) >= 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        return simpleName + "@" + Integer.toHexString(System.identityHashCode(obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x002a, code lost:
    
        if (r3 > r9) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003d, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0038, code lost:
    
        r2 = r9;
        r4 = r10;
        r5 = r4;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x002f, code lost:
    
        if (r3 > r10) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004b, code lost:
    
        r2 = r9;
        r4 = r3;
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0046, code lost:
    
        r2 = r9;
        r5 = r10;
        r4 = r3;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0036, code lost:
    
        if (r3 > r9) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0044, code lost:
    
        if (r3 > r10) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.core.util.Pair<com.ss.ttm.player.TTPlayerViewHelper.Size, java.lang.Boolean> calculatePlayerViewSize(int r7, float r8, int r9, int r10, float r11, float r12) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTPlayerViewHelper.calculatePlayerViewSize(int, float, int, int, float, float):androidx.core.util.Pair");
    }
}
