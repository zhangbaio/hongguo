package com.tencent.tinker.lib.hook;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ContentProviderProxy extends AbsObjectProxy implements OnHookInstall {
    private static Map<Object, Pair<String, String>> sProviderAuthMap;
    private Pair<String, String> mAuthPair;
    private Object mContentProviderHolder;

    private static class CrudProviderMethod extends AbsMethodDelegate {
        static {
            Covode.recordClassIndex(653757);
        }

        private CrudProviderMethod() {
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            String str = ">> " + method.getName() + ", ";
            Pair pair = (Pair) ContentProviderProxy.sProviderAuthMap.get(obj);
            if (pair != null) {
                String str2 = (String) pair.first;
                String str3 = (String) pair.second;
                if ("call".equals(method.getName())) {
                    stubCallMethod(objArr, str2, str3, method);
                } else {
                    stubCommonMethod(objArr, str3, method);
                }
            } else {
                MuteLog.w("Mute.CPProxy", str + "authPair null", new Object[0]);
            }
            return super.beforeInvoke(obj, method, objArr);
        }

        private void stubCommonMethod(Object[] objArr, String str, Method method) {
            Uri uri;
            if (objArr != null && objArr.length > 0 && !TextUtils.isEmpty(str)) {
                String str2 = "<< " + method.getName() + ", ";
                int parameterTypeIndex = MethodUtils.getParameterTypeIndex(method, Uri.class);
                if (parameterTypeIndex >= 0) {
                    uri = (Uri) objArr[parameterTypeIndex];
                } else {
                    uri = null;
                }
                if (uri != null) {
                    objArr[parameterTypeIndex] = new Uri.Builder().scheme(uri.getScheme()).authority(str).path(uri.getPath()).query(uri.getQuery()).fragment(uri.getFragment()).appendQueryParameter("tinker_target_authority", uri.getAuthority()).build();
                    MuteLog.w("Mute.CPProxy", str2 + "build uri = " + objArr[parameterTypeIndex], new Object[0]);
                    return;
                }
                MuteLog.w("Mute.CPProxy", str2 + "uriIndex or targetUri invalid, uriIndex = " + parameterTypeIndex + ", targetUri = " + uri, new Object[0]);
            }
        }

        private void stubCallMethod(Object[] objArr, String str, String str2, Method method) {
            Bundle bundle;
            int parameterTypeIndex = MethodUtils.getParameterTypeIndex(method, Bundle.class);
            if (parameterTypeIndex != -1) {
                Object obj = objArr[parameterTypeIndex];
                if (obj != null) {
                    bundle = (Bundle) obj;
                } else {
                    bundle = new Bundle();
                    objArr[parameterTypeIndex] = bundle;
                }
                bundle.putString("tinker_stub_authority", str2);
                bundle.putString("tinker_target_authority", str);
            }
            if (OSUtil.isAndroidRHigher() && objArr.length > 3) {
                objArr[2] = str2;
            } else if (OSUtil.isAndroidQHigher() && objArr.length > 2) {
                objArr[1] = str2;
            }
            MuteLog.w("Mute.CPProxy", "<< " + method.getName() + ", " + String.format("tinker_target_authority[%s] >>> tinker_stub_authority[%s]", str, str2), new Object[0]);
        }
    }

    @Override // com.tencent.tinker.lib.hook.OnHookInstall
    public void onHookInstall() {
        try {
            Object readField = FieldUtils.readField(this.mContentProviderHolder, "provider");
            if (readField != null) {
                Pair<String, String> pair = this.mAuthPair;
                if (pair != null) {
                    sProviderAuthMap.put(readField, pair);
                }
                setTarget(readField);
                FieldUtils.writeField(this.mContentProviderHolder, "provider", ProxyHelper.createProxy(readField, this));
                MuteLog.w("Mute.CPProxy", "onHookInstall hook success!!", new Object[0]);
            }
        } catch (Exception e) {
            MuteLog.e("Mute.CPProxy", "onHookInstall hook failed!! %s", e);
        }
    }

    static {
        Covode.recordClassIndex(653756);
        CrudProviderMethod crudProviderMethod = new CrudProviderMethod();
        AbsObjectProxy.sDelegateMethods.put("call", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("getType", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("query", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("insert", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("bulkInsert", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("delete", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("update", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("openFile", crudProviderMethod);
        AbsObjectProxy.sDelegateMethods.put("openAssetFile", crudProviderMethod);
        sProviderAuthMap = new ConcurrentHashMap();
    }

    public ContentProviderProxy(Object obj, Pair<String, String> pair) {
        this.mContentProviderHolder = obj;
        this.mAuthPair = pair;
    }

    @Override // com.tencent.tinker.lib.hook.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(obj, method, objArr);
    }
}
