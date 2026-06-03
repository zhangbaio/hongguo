package com.tencent.tinker.lib;

import com.bytedance.covode.number.Covode;
import com.bytedance.hotupgrade.api.ILogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteLogProxy implements InvocationHandler {
    private final ILogger mTinkerLogImp;

    static {
        Covode.recordClassIndex(653706);
    }

    public MuteLogProxy(ILogger iLogger) {
        this.mTinkerLogImp = iLogger;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            String name = method.getName();
            if ("v".equals(name)) {
                this.mTinkerLogImp.v((String) objArr[0], (String) objArr[1], (Object[]) objArr[2]);
            } else if ("d".equals(name)) {
                this.mTinkerLogImp.d((String) objArr[0], (String) objArr[1], (Object[]) objArr[2]);
            } else if ("i".equals(name)) {
                this.mTinkerLogImp.i((String) objArr[0], (String) objArr[1], (Object[]) objArr[2]);
            } else if ("w".equals(name)) {
                this.mTinkerLogImp.w((String) objArr[0], (String) objArr[1], (Object[]) objArr[2]);
            } else if ("e".equals(name)) {
                this.mTinkerLogImp.e((String) objArr[0], (String) objArr[1], (Object[]) objArr[2]);
            } else {
                this.mTinkerLogImp.printErrStackTrace((String) objArr[0], (Throwable) objArr[1], (String) objArr[2], (Object[]) objArr[3]);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
