package com.ss.ttvideoengine.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import l3.a;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class IntertrustDrmHelper {
    private TTVNetClient mNetworkSession;
    private Class<?> mDrmClass = null;
    private Object mInstance = null;
    private Object mIntertrustCallback = null;
    private Object mDrmNetworkCallback = null;
    private IntertrustDrmHelperListener mListener = null;
    private Handler mHandler = null;

    public interface IntertrustDrmHelperListener {
        void onError(Error error);

        void onTokenProcessed(Error error);
    }

    static {
        Covode.recordClassIndex(652538);
    }

    private static Object com_ss_ttvideoengine_model_IntertrustDrmHelper_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _notifySuccess() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public IntertrustDrmHelper() {
        this.mNetworkSession = null;
        this.mNetworkSession = new TTHTTPNetwork();
    }

    public void release() {
        TTVideoEngineLog.d("IntertrustDrmHelper", "release enter");
        if (this.mInstance == null) {
            return;
        }
        try {
            if (this.mDrmClass == null) {
                this.mDrmClass = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
            }
            com_ss_ttvideoengine_model_IntertrustDrmHelper_java_lang_reflect_Method_invoke(this.mDrmClass.getDeclaredMethod("release", new Class[0]), this.mInstance, new Object[0]);
            this.mInstance = null;
        } catch (ClassNotFoundException e) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
        } catch (IllegalAccessException e2) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e2.getLocalizedMessage());
        } catch (NoSuchMethodException e3) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e3.getLocalizedMessage());
        } catch (InvocationTargetException e4) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e4.getLocalizedMessage());
        }
    }

    public int start() {
        TTVideoEngineLog.d("IntertrustDrmHelper", "start enter");
        if (this.mInstance == null) {
            return -1;
        }
        try {
            if (this.mDrmClass == null) {
                this.mDrmClass = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
            }
            return ((Integer) com_ss_ttvideoengine_model_IntertrustDrmHelper_java_lang_reflect_Method_invoke(this.mDrmClass.getDeclaredMethod("start", new Class[0]), this.mInstance, new Object[0])).intValue();
        } catch (ClassNotFoundException e) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
            return -1;
        } catch (IllegalAccessException e2) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e2.getLocalizedMessage());
            return -1;
        } catch (NoSuchMethodException e3) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e3.getLocalizedMessage());
            return -1;
        } catch (InvocationTargetException e4) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e4.getLocalizedMessage());
            return -1;
        }
    }

    public int stop() {
        TTVideoEngineLog.d("IntertrustDrmHelper", "stop enter");
        if (this.mInstance == null) {
            return -1;
        }
        try {
            if (this.mDrmClass == null) {
                this.mDrmClass = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
            }
            return ((Integer) com_ss_ttvideoengine_model_IntertrustDrmHelper_java_lang_reflect_Method_invoke(this.mDrmClass.getDeclaredMethod("stop", new Class[0]), this.mInstance, new Object[0])).intValue();
        } catch (ClassNotFoundException e) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
            return -1;
        } catch (IllegalAccessException e2) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e2.getLocalizedMessage());
            return -1;
        } catch (NoSuchMethodException e3) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e3.getLocalizedMessage());
            return -1;
        } catch (InvocationTargetException e4) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e4.getLocalizedMessage());
            return -1;
        }
    }

    public void setListener(IntertrustDrmHelperListener intertrustDrmHelperListener) {
        this.mListener = intertrustDrmHelperListener;
    }

    private class MyIntertrustListener implements InvocationHandler {
        static {
            Covode.recordClassIndex(652541);
        }

        private MyIntertrustListener() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            int i;
            String str;
            TTVideoEngineLog.d("IntertrustDrmHelper", "intertrust listener invoke");
            String name = method.getName();
            if (name.equals("onTokenProcessed")) {
                IntertrustDrmHelper.this._notifySuccess();
                return null;
            }
            if (name.equals("onError")) {
                Object obj2 = objArr[0];
                int i2 = -1;
                if (obj2 != null) {
                    i = ((Integer) obj2).intValue();
                } else {
                    i = -1;
                }
                Object obj3 = objArr[1];
                if (obj3 != null) {
                    i2 = ((Integer) obj3).intValue();
                }
                Object obj4 = objArr[2];
                if (obj4 != null) {
                    str = obj4.toString();
                } else {
                    str = "";
                }
                if (i == -600000) {
                    i = -9935;
                } else if (i == -600001) {
                    i = -9934;
                }
                IntertrustDrmHelper.this._notifyError(new Error("kTTVideoErrorDomainIntertrustDRM", i, i2, str));
                return null;
            }
            TTVideoEngineLog.w("IntertrustDrmHelper", "invalid method name:" + name);
            return null;
        }
    }

    private class MyNetworkListener implements InvocationHandler {
        static {
            Covode.recordClassIndex(652542);
        }

        private MyNetworkListener() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String str;
            Map<String, String> map;
            JSONObject jSONObject;
            TTVideoEngineLog.d("IntertrustDrmHelper", "network listener invoke");
            String name = method.getName();
            if (name.equals("startTask")) {
                Object obj2 = objArr[0];
                if (obj2 != null) {
                    str = obj2.toString();
                } else {
                    str = "";
                }
                String str2 = str;
                Object obj3 = objArr[1];
                if (obj3 != null) {
                    map = (Map) obj3;
                } else {
                    map = null;
                }
                Object obj4 = objArr[2];
                if (obj4 != null) {
                    jSONObject = (JSONObject) obj4;
                } else {
                    jSONObject = null;
                }
                IntertrustDrmHelper.this.mNetworkSession.startTask(str2, map, jSONObject, 0, IntertrustDrmHelper.this.new myNetClientListener());
            } else if (name.equals("cancel")) {
                IntertrustDrmHelper.this.mNetworkSession.cancel();
            } else {
                TTVideoEngineLog.w("IntertrustDrmHelper", "invalid method name:" + name);
            }
            return null;
        }
    }

    class myNetClientListener implements TTVNetClient.RawCompletionListener {
        static {
            Covode.recordClassIndex(652543);
        }

        myNetClientListener() {
        }

        @Override // com.ss.ttvideoengine.net.TTVNetClient.RawCompletionListener
        public void onCompletion(String str, Error error) {
            if (error != null) {
                String str2 = error.description;
                TTVideoEngineLog.e("IntertrustDrmHelper", "get token return error code: " + error.code + ", internal:" + error.internalCode + ", description:" + error.description);
                if (!str2.contains("Canceled")) {
                    IntertrustDrmHelper.this._notifyError(error);
                    return;
                }
                return;
            }
            if (IntertrustDrmHelper.this.mInstance == null) {
                return;
            }
            try {
                if (IntertrustDrmHelper.this.mDrmClass == null) {
                    IntertrustDrmHelper.this.mDrmClass = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
                }
                IntertrustDrmHelper.this.mDrmClass.getDeclaredMethod("processTokenComplete", String.class).invoke(IntertrustDrmHelper.this.mInstance, str);
            } catch (ClassNotFoundException e) {
                TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
            } catch (IllegalAccessException e2) {
                TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e2.getLocalizedMessage());
            } catch (NoSuchMethodException e3) {
                TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e3.getLocalizedMessage());
            } catch (InvocationTargetException e4) {
                TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e4.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _notifyError(Error error) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, error));
    }

    private class MyHandler extends HandlerDelegate {
        private WeakReference<IntertrustDrmHelper> mHelper;

        static {
            Covode.recordClassIndex(652540);
        }

        public void handleMessage(Message message) {
            IntertrustDrmHelperListener intertrustDrmHelperListener;
            IntertrustDrmHelper intertrustDrmHelper = this.mHelper.get();
            if (intertrustDrmHelper == null || (intertrustDrmHelperListener = intertrustDrmHelper.mListener) == null) {
                return;
            }
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    intertrustDrmHelperListener.onError((Error) message.obj);
                    return;
                }
                return;
            }
            intertrustDrmHelperListener.onTokenProcessed(null);
        }

        public MyHandler(IntertrustDrmHelper intertrustDrmHelper, Looper looper) {
            super(looper);
            this.mHelper = new WeakReference<>(intertrustDrmHelper);
        }
    }

    public void setTokenUrlTemplate(String str) {
        TTVideoEngineLog.d("IntertrustDrmHelper", "setTokenUrlTemplate enter");
        if (this.mInstance == null) {
            return;
        }
        try {
            if (this.mDrmClass == null) {
                this.mDrmClass = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
            }
            this.mDrmClass.getDeclaredMethod("setTokenUrlTemplate", String.class).invoke(this.mInstance, str);
        } catch (ClassNotFoundException e) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
        } catch (IllegalAccessException e2) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e2.getLocalizedMessage());
        } catch (NoSuchMethodException e3) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e3.getLocalizedMessage());
        } catch (InvocationTargetException e4) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e4.getLocalizedMessage());
        }
    }

    public String makeUrl(String str, int i) {
        TTVideoEngineLog.d("IntertrustDrmHelper", "makeUrl enter");
        if (this.mInstance == null) {
            return null;
        }
        try {
            if (this.mDrmClass == null) {
                this.mDrmClass = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
            }
            return (String) this.mDrmClass.getDeclaredMethod("makeUrl", String.class, Integer.TYPE).invoke(this.mInstance, str, Integer.valueOf(i));
        } catch (ClassNotFoundException e) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
            return null;
        } catch (IllegalAccessException e2) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e2.getLocalizedMessage());
            return null;
        } catch (NoSuchMethodException e3) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e3.getLocalizedMessage());
            return null;
        } catch (InvocationTargetException e4) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e4.getLocalizedMessage());
            return null;
        }
    }

    public int init(Context context, int i) {
        Object invoke;
        TTVideoEngineLog.d("IntertrustDrmHelper", "init enter");
        try {
            Class<?> q = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
            this.mDrmClass = q;
            this.mInstance = q.newInstance();
            Class<?> q2 = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy$IntertrustDrmProxyListener");
            this.mIntertrustCallback = Proxy.newProxyInstance(IntertrustDrmHelper.class.getClassLoader(), new Class[]{q2}, new MyIntertrustListener());
            this.mDrmClass.getDeclaredMethod("setListener", q2).invoke(this.mInstance, this.mIntertrustCallback);
            Class<?> q3 = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy$IntertrustDrmProxyNetworkClient");
            this.mDrmNetworkCallback = Proxy.newProxyInstance(IntertrustDrmHelper.class.getClassLoader(), new Class[]{q3}, new MyNetworkListener());
            this.mDrmClass.getDeclaredMethod("setNetworkClient", q3).invoke(this.mInstance, this.mDrmNetworkCallback);
            if (i == 0) {
                invoke = this.mDrmClass.getDeclaredMethod("init", Context.class).invoke(this.mInstance, context);
            } else {
                invoke = this.mDrmClass.getDeclaredMethod("init", Context.class, Integer.TYPE).invoke(this.mInstance, context, Integer.valueOf(i));
            }
            this.mHandler = new MyHandler(this, TTHelper.getLooper());
            return ((Integer) invoke).intValue();
        } catch (ClassNotFoundException e) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
            return -1002;
        } catch (IllegalAccessException e2) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "illegal access exception:" + e2.getLocalizedMessage());
            return -1;
        } catch (InstantiationException e3) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "instance failed+" + e3.getLocalizedMessage());
            return -1;
        } catch (NoSuchMethodException e4) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e4.getLocalizedMessage());
            return -1;
        } catch (InvocationTargetException e5) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "invoke failed:" + e5.getLocalizedMessage());
            return -1;
        }
    }

    public int processToken(int i, String str, String str2) {
        TTVideoEngineLog.d("IntertrustDrmHelper", "processToken enter");
        if (this.mInstance == null) {
            return -1;
        }
        try {
            if (this.mDrmClass == null) {
                this.mDrmClass = a.q("com.ss.ttm.drm.intertrust.IntertrustDrmProxy");
            }
            return ((Integer) this.mDrmClass.getDeclaredMethod("processToken", Integer.TYPE, String.class, String.class).invoke(this.mInstance, Integer.valueOf(i), str, str2)).intValue();
        } catch (ClassNotFoundException e) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "class not found:" + e.getLocalizedMessage());
            return -1;
        } catch (IllegalAccessException e2) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e2.getLocalizedMessage());
            return -1;
        } catch (NoSuchMethodException e3) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method not found:" + e3.getLocalizedMessage());
            return -1;
        } catch (InvocationTargetException e4) {
            TTVideoEngineLog.e("IntertrustDrmHelper", "method invoke failied:" + e4.getLocalizedMessage());
            return -1;
        }
    }
}
