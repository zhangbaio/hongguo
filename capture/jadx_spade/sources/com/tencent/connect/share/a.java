package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(653274);
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = i / width;
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.graphics.Bitmap a(java.lang.String r6, int r7) {
        /*
            java.lang.String r0 = "openSDK_LOG.AsynScaleCompressImage"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r3 = 1
            r1.inJustDecodeBounds = r3
            android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L16
            goto L1c
        L16:
            r3 = move-exception
            java.lang.String r4 = "scaleBitmap exception1:"
            com.tencent.open.log.SLog.e(r0, r4, r3)
        L1c:
            int r3 = r1.outWidth
            int r4 = r1.outHeight
            boolean r5 = r1.mCancel
            if (r5 != 0) goto L69
            r5 = -1
            if (r3 == r5) goto L69
            if (r4 != r5) goto L2a
            goto L69
        L2a:
            if (r3 <= r4) goto L2d
            goto L2e
        L2d:
            r3 = r4
        L2e:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            r1.inPreferredConfig = r4
            if (r3 <= r7) goto L3c
            int r3 = r7 * r7
            int r3 = a(r1, r5, r3)
            r1.inSampleSize = r3
        L3c:
            r3 = 0
            r1.inJustDecodeBounds = r3
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L44 java.lang.Exception -> L4b
            goto L52
        L44:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap OutOfMemoryError:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
            goto L51
        L4b:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap exception2:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
        L51:
            r6 = r2
        L52:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "scaleBitmap return null"
            com.tencent.open.log.SLog.e(r0, r6)
            return r2
        L5a:
            int r0 = r1.outWidth
            int r1 = r1.outHeight
            if (r0 <= r1) goto L61
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 <= r7) goto L68
            android.graphics.Bitmap r6 = a(r6, r7)
        L68:
            return r6
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.a.a(java.lang.String, int):android.graphics.Bitmap");
    }

    public static final int a(BitmapFactory.Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b <= 8) {
            int i3 = 1;
            while (i3 < b) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((b + 7) / 8) * 8;
    }

    private static int b(BitmapFactory.Options options, int i, int i2) {
        int ceil;
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        if (i2 == -1) {
            ceil = 1;
        } else {
            ceil = (int) Math.ceil(Math.sqrt((d * d2) / i2));
        }
        if (i == -1) {
            min = 128;
        } else {
            double d3 = i;
            min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        if (i == -1) {
            return ceil;
        }
        return min;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, int i, int i2) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (options.mCancel || i4 == -1 || i5 == -1) {
            return false;
        }
        if (i4 > i5) {
            i3 = i4;
        } else {
            i3 = i5;
        }
        if (i4 >= i5) {
            i4 = i5;
        }
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i3 + "shortSide=" + i4);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i3 <= i2 && i4 <= i) {
            return false;
        }
        return true;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (!polarisFileWrapper.exists()) {
            polarisFileWrapper.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(stringBuffer2);
        if (polarisFileWrapper2.exists()) {
            polarisFileWrapper2.delete();
        }
        if (bitmap != null) {
            try {
                PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(polarisFileWrapper2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, polarisFileOutputStreamWrapper);
                polarisFileOutputStreamWrapper.flush();
                polarisFileOutputStreamWrapper.close();
                bitmap.recycle();
                return stringBuffer2;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static final void a(final Context context, final String str, final d dVar) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            dVar.a(1, (String) null);
        } else if (!m.a()) {
            dVar.a(2, (String) null);
        } else {
            final HandlerDelegate handlerDelegate = new HandlerDelegate(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                /* JADX WARN: Multi-variable type inference failed */
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != 101) {
                        if (i != 102) {
                            super/*android.os.Handler*/.handleMessage(message);
                            return;
                        } else {
                            dVar.a(message.arg1, (String) null);
                            return;
                        }
                    }
                    dVar.a(0, (ArrayList<String>) message.obj);
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String str3;
                    try {
                        Bitmap a = a.a(str, 840);
                        if (a != null) {
                            File a2 = g.a("Images");
                            String str4 = null;
                            if (a2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(a2.getAbsolutePath());
                                String str5 = File.separator;
                                sb.append(str5);
                                sb.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb.append(str5);
                                str3 = sb.toString();
                                str2 = null;
                            } else {
                                File d = g.d();
                                if (d == null) {
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    Message obtainMessage = handlerDelegate.obtainMessage();
                                    obtainMessage.arg1 = 102;
                                    handlerDelegate.sendMessage(obtainMessage);
                                    return;
                                }
                                String absolutePath = d.getAbsolutePath();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(absolutePath);
                                String str6 = File.separator;
                                sb2.append(str6);
                                sb2.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb2.append(str6);
                                String sb3 = sb2.toString();
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb3);
                                str2 = absolutePath;
                                str3 = sb3;
                            }
                            String str7 = "share2qq_temp" + m.g(str) + ".jpg";
                            String str8 = str;
                            if (!a.b(str8, 840, 840)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            } else {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                String a3 = a.a(a, str3, str7);
                                if (!TextUtils.isEmpty(a3)) {
                                    str8 = a3;
                                }
                            }
                            boolean m = m.m(str8);
                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + m);
                            ArrayList arrayList = new ArrayList(2);
                            if (m) {
                                str4 = str8;
                            } else if (TextUtils.isEmpty(str2)) {
                                String str9 = str3 + str7;
                                boolean a4 = m.a(context, str8, str9);
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str9 + ",isSuccess=" + a4);
                                if (a4) {
                                    str4 = str9;
                                }
                            }
                            arrayList.add(str8);
                            arrayList.add(str4);
                            if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + "]");
                                Message obtainMessage2 = handlerDelegate.obtainMessage(101);
                                obtainMessage2.obj = arrayList;
                                handlerDelegate.sendMessage(obtainMessage2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e);
                    }
                    SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    Message obtainMessage3 = handlerDelegate.obtainMessage(102);
                    obtainMessage3.arg1 = 3;
                    handlerDelegate.sendMessage(obtainMessage3);
                }
            }).start();
        }
    }
}
