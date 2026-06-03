package com.tencent.tinker.lib.hook;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteMaxLoader;
import com.tencent.tinker.lib.MutePkgMgr;
import com.tencent.tinker.lib.MuteReplacer;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.hidden.q.DoubleReflector;
import com.tencent.tinker.lib.pm.PatchPackageManager;
import com.tencent.tinker.lib.utils.ATUtils;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PackageManagerProxy extends AbsObjectProxy implements OnHookInstall {
    public static Object pmProxy;
    private static PackageInfo sMutePackageInfo;
    private static Map<String, PackageInfo> sMutePackageInfoMap;

    private static Object com_tencent_tinker_lib_hook_PackageManagerProxy_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    private static class GetApplicationInfo extends AbsMethodDelegate {
        static {
            Covode.recordClassIndex(653765);
        }

        private GetApplicationInfo() {
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
            if (objArr != null && objArr.length > 1) {
                Object obj3 = objArr[0];
                if (obj3 instanceof String) {
                    Object obj4 = objArr[1];
                    if ((obj4 instanceof Number) && (obj2 instanceof ApplicationInfo)) {
                        String str = (String) obj3;
                        int intValue = ((Number) obj4).intValue();
                        if (str != null && (33554432 & intValue) == 0 && TextUtils.equals(str, Muter.getAppContext().getPackageName())) {
                            MuteLog.i("Mute.PMP", "getApplicationInfo pkg[%s] flags[%d]", str, Integer.valueOf(intValue));
                            ApplicationInfo applicationInfo = (ApplicationInfo) obj2;
                            try {
                                MuteReplacer.modifyAppInfo(applicationInfo);
                            } catch (Throwable th) {
                                MuteLog.e("Mute.PMP", "getApplicationInfo pkg[%s] flags[%d] err %d", str, Integer.valueOf(intValue), th);
                            }
                            if ((intValue & 128) != 0) {
                                if (MutePkgMgr.getMetaInfo(Muter.getAppContext().getPackageName()) != null) {
                                    Bundle bundle = new Bundle();
                                    applicationInfo.metaData = bundle;
                                    bundle.putAll(MutePkgMgr.getMetaInfo(Muter.getAppContext().getPackageName()));
                                    MuteLog.w("Mute.PMP", "getApplicationInfo modify metaData1 %s", applicationInfo.metaData);
                                } else {
                                    if (PackageManagerProxy.sMutePackageInfo == null) {
                                        PackageInfo unused = PackageManagerProxy.sMutePackageInfo = Muter.getAppContext().getPackageManager().getPackageArchiveInfo(applicationInfo.sourceDir, 128);
                                    }
                                    if (PackageManagerProxy.sMutePackageInfo != null && PackageManagerProxy.sMutePackageInfo.applicationInfo != null) {
                                        Bundle bundle2 = PackageManagerProxy.sMutePackageInfo.applicationInfo.metaData;
                                        applicationInfo.metaData = bundle2;
                                        MuteLog.w("Mute.PMP", "getApplicationInfo modify metaData2 %s", bundle2);
                                    }
                                }
                            }
                        }
                        return super.afterInvoke(obj, method, objArr, obj2);
                    }
                }
            }
            return super.afterInvoke(obj, method, objArr, obj2);
        }
    }

    private static class ResolveContentProvider extends AbsMethodDelegate {
        static {
            Covode.recordClassIndex(653769);
        }

        private ResolveContentProvider() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object afterInvoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8, java.lang.Object r9) {
            /*
                r5 = this;
                if (r9 != 0) goto L7b
                if (r8 == 0) goto L7b
                int r0 = r8.length
                r1 = 0
                if (r0 <= 0) goto L11
                r0 = r8[r1]
                boolean r2 = r0 instanceof java.lang.String
                if (r2 == 0) goto L11
                java.lang.String r0 = (java.lang.String) r0
                goto L12
            L11:
                r0 = 0
            L12:
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                int r3 = r8.length
                r4 = 1
                if (r3 <= r4) goto L2a
                r3 = r8[r4]
                boolean r4 = r3 instanceof java.lang.Number
                if (r4 == 0) goto L2a
                java.lang.Number r3 = (java.lang.Number) r3
                int r2 = r3.intValue()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            L2a:
                if (r0 == 0) goto L7b
                int r3 = r2.intValue()
                r4 = 33554432(0x2000000, float:9.403955E-38)
                r3 = r3 & r4
                if (r3 != 0) goto L7b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r8 = ">> "
                r6.append(r8)
                java.lang.String r7 = r7.getName()
                r6.append(r7)
                java.lang.String r7 = ", "
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r6)
                java.lang.String r6 = "name = "
                r7.append(r6)
                r7.append(r0)
                java.lang.String r6 = ", flags = "
                r7.append(r6)
                r7.append(r2)
                java.lang.String r6 = r7.toString()
                java.lang.Object[] r7 = new java.lang.Object[r1]
                java.lang.String r8 = "Mute.PMP"
                com.tencent.tinker.lib.MuteLog.d(r8, r6, r7)
                int r6 = r2.intValue()
                android.content.pm.ProviderInfo r6 = com.tencent.tinker.lib.pm.PatchPackageManager.resolveContentProvider(r0, r6)
                return r6
            L7b:
                java.lang.Object r6 = super.afterInvoke(r6, r7, r8, r9)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.PackageManagerProxy.ResolveContentProvider.afterInvoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object):java.lang.Object");
        }
    }

    private static class GetPackageInfo extends AbsMethodDelegate {
        private Object mInitialApplicationFor15;

        static {
            Covode.recordClassIndex(653767);
        }

        private GetPackageInfo() {
            this.mInitialApplicationFor15 = null;
        }

        private boolean usePackInfoCache() {
            if (Build.VERSION.SDK_INT < 35 || this.mInitialApplicationFor15 != null) {
                return true;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mInitialApplication");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                this.mInitialApplicationFor15 = obj;
                if (obj != null) {
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                this.mInitialApplicationFor15 = new Object();
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0076  */
        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object beforeInvoke(java.lang.Object r11, java.lang.reflect.Method r12, java.lang.Object[] r13) {
            /*
                Method dump skipped, instructions count: 337
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.PackageManagerProxy.GetPackageInfo.beforeInvoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }

    private static boolean clearApplicationInfoCacheOnAndroid12() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        try {
            Field field = DoubleReflector.getField(PackageManager.class, "sApplicationInfoCache");
            field.setAccessible(true);
            Object obj = field.get(PackageManager.class);
            Method method = DoubleReflector.getMethod(obj.getClass().getSuperclass(), "clear", new Class[0]);
            method.setAccessible(true);
            com_tencent_tinker_lib_hook_PackageManagerProxy_java_lang_reflect_Method_invoke(method, obj, new Object[0]);
            return true;
        } catch (Throwable th) {
            MuteLog.e("Mute.PMP", "clearApplicationInfoCacheOnAndroid12 failed. %s", th);
            return false;
        }
    }

    private boolean clearPackageInfoCacheOnAndroid12() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        try {
            Field field = DoubleReflector.getField(PackageManager.class, "sPackageInfoCache");
            field.setAccessible(true);
            Object obj = field.get(PackageManager.class);
            Method method = DoubleReflector.getMethod(obj.getClass().getSuperclass(), "clear", new Class[0]);
            method.setAccessible(true);
            com_tencent_tinker_lib_hook_PackageManagerProxy_java_lang_reflect_Method_invoke(method, obj, new Object[0]);
            return true;
        } catch (Throwable th) {
            MuteLog.e("Mute.PMP", "clearPackageInfoCacheOnAndroid12 failed. %s", th);
            return false;
        }
    }

    private void closeHuaWei9Cache() {
        try {
            Method declaredMethod = Class.forName("android.common.HwFrameworkFactory").getDeclaredMethod("getHwApiCacheManagerEx", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = invoke.getClass().getDeclaredField("bCanCache");
            Field declaredField2 = invoke.getClass().getDeclaredField("sPackageInfoCache");
            Field declaredField3 = invoke.getClass().getDeclaredField("sPackageUidCache");
            Field declaredField4 = invoke.getClass().getDeclaredField("sVolumeCache");
            Field declaredField5 = invoke.getClass().getDeclaredField("USE_CACHE");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField3.setAccessible(true);
            declaredField4.setAccessible(true);
            declaredField5.setAccessible(true);
            Boolean bool = Boolean.FALSE;
            declaredField.set(invoke, bool);
            declaredField2.set(invoke, new HashMap());
            declaredField3.set(invoke, new HashMap());
            declaredField4.set(invoke, new HashMap());
            declaredField5.set(invoke, bool);
        } catch (Throwable unused) {
        }
    }

    static {
        Covode.recordClassIndex(653764);
        sMutePackageInfoMap = new ConcurrentHashMap();
        AbsObjectProxy.sDelegateMethods.put("getPackageInfo", new GetPackageInfo());
        AbsObjectProxy.sDelegateMethods.put("getApplicationInfo", new GetApplicationInfo());
        int i = 1;
        AbsObjectProxy.sDelegateMethods.put("getActivityInfo", new GetComponentInfo(i));
        int i2 = 2;
        AbsObjectProxy.sDelegateMethods.put("getServiceInfo", new GetComponentInfo(i2));
        AbsObjectProxy.sDelegateMethods.put("getReceiverInfo", new GetComponentInfo(3));
        AbsObjectProxy.sDelegateMethods.put("getProviderInfo", new GetComponentInfo(4));
        AbsObjectProxy.sDelegateMethods.put("queryIntentActivities", new QueryIntentComponents(i));
        AbsObjectProxy.sDelegateMethods.put("queryIntentServices", new QueryIntentComponents(i2));
        AbsObjectProxy.sDelegateMethods.put("resolveIntent", new ResolveIntent(i));
        AbsObjectProxy.sDelegateMethods.put("resolveService", new ResolveIntent(i2));
        AbsObjectProxy.sDelegateMethods.put("resolveContentProvider", new ResolveContentProvider());
    }

    @Override // com.tencent.tinker.lib.hook.OnHookInstall
    public void onHookInstall() {
        try {
            Object currentActivityThread = ATUtils.currentActivityThread();
            Object readField = FieldUtils.readField(currentActivityThread, "sPackageManager");
            if (readField != null && currentActivityThread != null) {
                setTarget(readField);
                Object createProxy = ProxyHelper.createProxy(readField, this);
                pmProxy = createProxy;
                FieldUtils.writeField(currentActivityThread, "sPackageManager", createProxy);
                FieldUtils.writeField(Muter.getAppContext().getPackageManager(), "mPM", pmProxy);
                if (clearApplicationInfoCacheOnAndroid12() && clearPackageInfoCacheOnAndroid12()) {
                    MuteLog.i("Mute.PMP", "clear ApplicationInfoCache and PackageInfoCache OnAndroid12Plus success.", new Object[0]);
                } else {
                    MuteLog.e("Mute.PMP", "clear ApplicationInfoCache and PackageInfoCache OnAndroid12Plus failed.", new Object[0]);
                }
                closeHuaWei9Cache();
                MuteLog.w("Mute.PMP", "onHookInstall hook success!!", new Object[0]);
                return;
            }
            MuteLog.w("Mute.PMP", "onHookInstall hook failed, sPackageManager:" + readField + " activityThread:" + currentActivityThread + " target:" + pmProxy, new Object[0]);
        } catch (Exception e) {
            MuteLog.e("Mute.PMP", "onHookInstall hook failed!! %s", e);
        }
    }

    private static class GetComponentInfo extends AbsMethodDelegate {
        private int mFlag;

        static {
            Covode.recordClassIndex(653766);
        }

        private GetComponentInfo(int i) {
            this.mFlag = i;
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            if (objArr != null && objArr.length > 1 && (objArr[0] instanceof ComponentName) && (objArr[1] instanceof Number)) {
                return null;
            }
            return super.beforeInvoke(obj, method, objArr);
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
            if (objArr != null && objArr.length > 1 && (objArr[0] instanceof ComponentName)) {
                Object obj3 = objArr[1];
                if (obj3 instanceof Number) {
                    int intValue = ((Number) obj3).intValue();
                    int i = 33554432 & intValue;
                    if (i == 0) {
                        ComponentName componentName = (ComponentName) objArr[0];
                        String name = method.getName();
                        String packageName = Muter.getAppContext().getPackageName();
                        MuteLog.i("Mute.PMP", "%s pkg[%s] flags[%d] cn[%s]", name, packageName, Integer.valueOf(intValue), componentName);
                        if (obj2 == null) {
                            if (!TextUtils.equals(packageName, componentName.getPackageName())) {
                                return super.afterInvoke(obj, method, objArr, obj2);
                            }
                            int i2 = this.mFlag;
                            if (i2 == 1) {
                                return PatchPackageManager.getActivityInfo(componentName, intValue);
                            }
                            if (i2 == 2) {
                                return PatchPackageManager.getServiceInfo(componentName, intValue);
                            }
                            if (i2 == 3) {
                                return PatchPackageManager.getReceiverInfo(componentName, intValue);
                            }
                            if (i2 == 4) {
                                return PatchPackageManager.getProviderInfo(componentName, intValue);
                            }
                        } else if ((obj2 instanceof ComponentInfo) && componentName != null && i == 0) {
                            ComponentInfo componentInfo = (ComponentInfo) obj2;
                            if (TextUtils.equals(componentName.getPackageName(), packageName) && (intValue & 128) != 0) {
                                if (MutePkgMgr.getMetaInfo(componentName.getClassName()) != null) {
                                    Bundle bundle = new Bundle();
                                    componentInfo.metaData = bundle;
                                    bundle.putAll(MutePkgMgr.getMetaInfo(componentName.getClassName()));
                                    MuteLog.w("Mute.PMP", "%s pkg[%s] flags[%d] cn[%s] modify metaData1", name, packageName, Integer.valueOf(intValue), componentName);
                                } else {
                                    if (PackageManagerProxy.sMutePackageInfo == null) {
                                        PackageInfo unused = PackageManagerProxy.sMutePackageInfo = Muter.getAppContext().getPackageManager().getPackageArchiveInfo(MuteMaxLoader.mPatchSource.getAbsolutePath(), 128);
                                    }
                                    if (PackageManagerProxy.sMutePackageInfo != null) {
                                        componentInfo.metaData = PackageManagerProxy.getMetaInfo(PackageManagerProxy.sMutePackageInfo, componentInfo);
                                        MuteLog.w("Mute.PMP", "%s pkg[%s] flags[%d] cn[%s] modify metaData2", name, packageName, Integer.valueOf(intValue), componentName);
                                    }
                                }
                            }
                        }
                    }
                    return super.afterInvoke(obj, method, objArr, obj2);
                }
            }
            return super.beforeInvoke(obj, method, objArr);
        }
    }

    private static class QueryIntentComponents extends AbsMethodDelegate {
        private int mFlag;

        static {
            Covode.recordClassIndex(653768);
        }

        private QueryIntentComponents(int i) {
            this.mFlag = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
        /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object] */
        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object afterInvoke(java.lang.Object r7, java.lang.reflect.Method r8, java.lang.Object[] r9, java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 232
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.PackageManagerProxy.QueryIntentComponents.afterInvoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object):java.lang.Object");
        }
    }

    private static class ResolveIntent extends AbsMethodDelegate {
        private int mFlag;

        static {
            Covode.recordClassIndex(653770);
        }

        private ResolveIntent(int i) {
            this.mFlag = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object afterInvoke(java.lang.Object r7, java.lang.reflect.Method r8, java.lang.Object[] r9, java.lang.Object r10) {
            /*
                r6 = this;
                if (r10 != 0) goto L8b
                if (r9 == 0) goto L8b
                int r0 = r9.length
                r1 = 0
                if (r0 <= 0) goto L11
                r0 = r9[r1]
                boolean r2 = r0 instanceof android.content.Intent
                if (r2 == 0) goto L11
                android.content.Intent r0 = (android.content.Intent) r0
                goto L12
            L11:
                r0 = 0
            L12:
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                int r3 = r9.length
                r4 = 2
                if (r3 <= r4) goto L2a
                r3 = r9[r4]
                boolean r5 = r3 instanceof java.lang.Number
                if (r5 == 0) goto L2a
                java.lang.Number r3 = (java.lang.Number) r3
                int r2 = r3.intValue()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            L2a:
                if (r0 == 0) goto L8b
                int r3 = r2.intValue()
                r5 = 33554432(0x2000000, float:9.403955E-38)
                r3 = r3 & r5
                if (r3 != 0) goto L8b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = ">> "
                r3.append(r5)
                java.lang.String r5 = r8.getName()
                r3.append(r5)
                java.lang.String r5 = ", "
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r3)
                java.lang.String r3 = "intent = "
                r5.append(r3)
                r5.append(r0)
                java.lang.String r3 = ", flags = "
                r5.append(r3)
                r5.append(r2)
                java.lang.String r3 = r5.toString()
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.String r5 = "Mute.PMP"
                com.tencent.tinker.lib.MuteLog.d(r5, r3, r1)
                int r1 = r6.mFlag
                r3 = 1
                if (r1 != r3) goto L80
                int r7 = r2.intValue()
                android.content.pm.ResolveInfo r7 = com.tencent.tinker.lib.pm.PatchPackageManager.resolveIntent(r0, r7)
                return r7
            L80:
                if (r1 != r4) goto L8b
                int r7 = r2.intValue()
                android.content.pm.ResolveInfo r7 = com.tencent.tinker.lib.pm.PatchPackageManager.resolveService(r0, r7)
                return r7
            L8b:
                java.lang.Object r7 = super.afterInvoke(r7, r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.PackageManagerProxy.ResolveIntent.afterInvoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmptyResult(Object obj) {
        Method accessibleMethod;
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        try {
            Class<?> cls = Class.forName("android.content.pm.ParceledListSlice");
            if (obj.getClass() == cls && (accessibleMethod = MethodUtils.getAccessibleMethod(cls, "getList", new Class[0])) != null) {
                List list = (List) com_tencent_tinker_lib_hook_PackageManagerProxy_java_lang_reflect_Method_invoke(accessibleMethod, obj, new Object[0]);
                if (list == null) {
                    return true;
                }
                if (list.isEmpty()) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle getMetaInfo(PackageInfo packageInfo, ComponentInfo componentInfo) {
        ProviderInfo[] providerInfoArr;
        ServiceInfo[] serviceInfoArr;
        ActivityInfo[] activityInfoArr;
        int i = 0;
        if ((componentInfo instanceof ActivityInfo) && (activityInfoArr = packageInfo.activities) != null) {
            int length = activityInfoArr.length;
            while (i < length) {
                ActivityInfo activityInfo = activityInfoArr[i];
                if (TextUtils.equals(activityInfo.name, componentInfo.name)) {
                    return activityInfo.metaData;
                }
                i++;
            }
            return null;
        }
        if ((componentInfo instanceof ServiceInfo) && (serviceInfoArr = packageInfo.services) != null) {
            int length2 = serviceInfoArr.length;
            while (i < length2) {
                ServiceInfo serviceInfo = serviceInfoArr[i];
                if (TextUtils.equals(serviceInfo.name, componentInfo.name)) {
                    return serviceInfo.metaData;
                }
                i++;
            }
            return null;
        }
        if ((componentInfo instanceof ProviderInfo) && (providerInfoArr = packageInfo.providers) != null) {
            int length3 = providerInfoArr.length;
            while (i < length3) {
                ProviderInfo providerInfo = providerInfoArr[i];
                if (TextUtils.equals(providerInfo.name, componentInfo.name)) {
                    return providerInfo.metaData;
                }
                i++;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.tinker.lib.hook.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(obj, method, objArr);
    }
}
