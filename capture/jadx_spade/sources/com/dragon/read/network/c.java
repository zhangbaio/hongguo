package com.dragon.read.network;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.depend.g;
import com.dragon.read.base.util.ListUtils;
import com.dragon.read.base.util.LogHelper;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Field;
import java.util.Collection;
import m25.q0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c {
    private static final LogHelper a;

    static {
        Covode.recordClassIndex(612447);
        a = new LogHelper("ReaderNetReqUtil");
    }

    public static void a(Object obj) throws Exception {
        c(obj, true);
    }

    public static void e(Disposable disposable) {
        if (f(disposable)) {
            disposable.dispose();
        }
    }

    public static boolean f(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            return true;
        }
        return false;
    }

    private static int g(Object obj) {
        int i;
        if (obj == null) {
            return -2001;
        }
        try {
            Object obj2 = obj.getClass().getField("code").get(obj);
            if (obj2 == null) {
                return -2003;
            }
            try {
                if (obj2 instanceof Integer) {
                    i = ((Integer) obj2).intValue();
                } else {
                    Integer parseBizResponseCode = q0.b.parseBizResponseCode(obj2);
                    if (parseBizResponseCode != null) {
                        i = parseBizResponseCode.intValue();
                    } else {
                        i = -2004;
                    }
                }
                return i;
            } catch (Throwable th) {
                g.b.b(th);
                return -2000;
            }
        } catch (Throwable unused) {
            return -2002;
        }
    }

    public static void b(Object obj, int i) throws Exception {
        d(obj, true, i);
    }

    public static void c(Object obj, boolean z) throws Exception {
        d(obj, z, 1);
    }

    public static void d(Object obj, boolean z, int i) throws Exception {
        Object obj2;
        String str;
        int i2;
        if (obj != null) {
            if (obj instanceof DataResult) {
                DataResult dataResult = (DataResult) obj;
                i2 = dataResult.code;
                str = dataResult.msg;
                obj2 = dataResult.data;
            } else {
                Field field = obj.getClass().getField("message");
                int g = g(obj);
                String str2 = (String) field.get(obj);
                try {
                    obj2 = obj.getClass().getField("data").get(obj);
                } catch (Exception unused) {
                    obj2 = null;
                }
                str = str2;
                i2 = g;
            }
            if (i2 == 0) {
                if (i == 1 && obj2 == null) {
                    throw new ErrorCodeException(i2, "data is null");
                }
                if (z && (obj2 instanceof Collection) && ListUtils.isEmpty((Collection) obj2)) {
                    throw new ErrorCodeException(i2, "data list is empty");
                }
                return;
            }
            throw new ErrorCodeException(i2, str);
        }
        throw new NullPointerException("response is null");
    }
}
