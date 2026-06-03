package com.ss.videoarch.liveplayer.utils;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e {
    private static Class<?> VideoLiveManagerClass;
    private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

    static {
        Covode.recordClassIndex(653101);
    }

    private static Object com_ss_videoarch_liveplayer_utils_Modularization_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    protected VideoLiveManager videoLiveManager() {
        return this.mVideoLiveManagerRef.get();
    }

    public e(VideoLiveManager videoLiveManager) {
        this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        if (VideoLiveManagerClass == null) {
            try {
                VideoLiveManagerClass = l3.a.q("com.ss.videoarch.liveplayer.VideoLiveManager");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected Object performVideoLiveManagerMethod(String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] clsArr;
        if (objArr != null && objArr.length > 0) {
            clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        } else {
            clsArr = null;
        }
        return performVideoLiveManagerMethod(str, clsArr, objArr);
    }

    protected Object performVideoLiveManagerMethod(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        VideoLiveManager videoLiveManager = videoLiveManager();
        if (VideoLiveManagerClass != null && videoLiveManager != null) {
            boolean z = false;
            if ((clsArr == null && objArr == null) || (clsArr != null && objArr != null && clsArr.length == objArr.length)) {
                int i = 0;
                while (true) {
                    if (i < objArr.length) {
                        Class<?> cls = clsArr[i];
                        Object obj = objArr[i];
                        if (obj != null && !cls.isInstance(obj)) {
                            break;
                        }
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                Method declaredMethod = VideoLiveManagerClass.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return com_ss_videoarch_liveplayer_utils_Modularization_java_lang_reflect_Method_invoke(declaredMethod, videoLiveManager, objArr);
            }
            throw new IllegalArgumentException();
        }
        throw new InvocationTargetException(new Throwable("VideoLiveManager class or instance invalid, class: " + VideoLiveManagerClass + ", instance: " + videoLiveManager));
    }
}
