package com.tencent.tinker.lib.hook;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.am.PatchActivityManager;
import com.tencent.tinker.lib.pm.PatchPackageManager;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import com.tencent.tinker.lib.utils.ProcessUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ActivityManagerProxy extends AbsObjectProxy implements OnHookInstall {

    private static class BroadcastIntent extends AbsMethodDelegate {
        static {
            Covode.recordClassIndex(653747);
        }

        private BroadcastIntent() {
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            Intent extractIntent = ActivityManagerProxy.extractIntent(objArr);
            String str = "<< " + method.getName();
            MuteLog.i("Mute.ActMgrProxy", "%s %s", str, extractIntent);
            if (extractIntent != null && !extractIntent.getBooleanExtra("start_origin_no_patch", false)) {
                if (Muter.getAppContext().getPackageManager().queryBroadcastReceivers(extractIntent, 33619968).size() > 0) {
                    MuteLog.i("Mute.ActMgrProxy", "%s declare in host Manifest", str);
                    return super.beforeInvoke(obj, method, objArr);
                }
                List<ResolveInfo> queryBroadcastReceivers = PatchPackageManager.queryBroadcastReceivers(extractIntent, 0);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
                    ActivityInfo selectStubReceiver = PatchActivityManager.selectStubReceiver(activityInfo);
                    if (selectStubReceiver != null) {
                        Intent intent = new Intent();
                        intent.setClassName(selectStubReceiver.packageName, selectStubReceiver.name);
                        intent.putExtra("mute_target_intent", extractIntent);
                        intent.putExtra("mute_target_receiver_info", activityInfo);
                        intent.putExtra("mute_stub_receiver_info", selectStubReceiver);
                        ActivityManagerProxy.replaceIntentArgs(objArr, intent);
                        MuteLog.w("Mute.ActMgrProxy", "%s Target[%s] >>> Stub[%s]", str, activityInfo.name, selectStubReceiver.name);
                    } else {
                        MuteLog.w("Mute.ActMgrProxy", "%s no stub receivers to use", str);
                    }
                } else {
                    MuteLog.w("Mute.ActMgrProxy", "%s query patch empty, %s", str, extractIntent.getComponent());
                }
            }
            return super.beforeInvoke(obj, method, objArr);
        }
    }

    private static final class GetIntentSender extends AbsMethodDelegate {
        static {
            Covode.recordClassIndex(653749);
        }

        private GetIntentSender() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object beforeInvoke(java.lang.Object r9, java.lang.reflect.Method r10, java.lang.Object[] r11) {
            /*
                r8 = this;
                r0 = 0
                if (r11 == 0) goto L13
                int r1 = r11.length
                if (r1 <= 0) goto L13
                r1 = r11[r0]
                boolean r2 = r1 instanceof java.lang.Integer
                if (r2 == 0) goto L13
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                goto L14
            L13:
                r1 = 0
            L14:
                r2 = 2
                r3 = 2
            L16:
                r4 = 0
                if (r11 == 0) goto L2a
                int r5 = r11.length
                if (r3 >= r5) goto L2a
                r5 = r11[r3]
                if (r5 == 0) goto L27
                boolean r6 = r5 instanceof android.content.Intent[]
                if (r6 == 0) goto L27
                android.content.Intent[] r5 = (android.content.Intent[]) r5
                goto L2c
            L27:
                int r3 = r3 + 1
                goto L16
            L2a:
                r3 = -1
                r5 = r4
            L2c:
                if (r5 == 0) goto L33
                int r6 = r5.length
                if (r6 <= 0) goto L33
                r4 = r5[r0]
            L33:
                if (r4 == 0) goto L96
                if (r3 < 0) goto L96
                java.lang.String r5 = "mute_target_intent"
                r6 = 1
                if (r1 != r2) goto L68
                java.util.List r1 = com.tencent.tinker.lib.pm.PatchPackageManager.queryIntentActivities(r4, r0)
                if (r1 == 0) goto L96
                int r1 = r1.size()
                if (r1 <= 0) goto L96
                android.content.Intent r1 = new android.content.Intent
                r1.<init>(r4)
                android.content.Context r2 = com.tencent.tinker.lib.Muter.getAppContext()
                java.lang.String r2 = r2.getPackageName()
                java.lang.Class<com.tencent.tinker.lib.stub.RedirectActivity> r7 = com.tencent.tinker.lib.stub.RedirectActivity.class
                java.lang.String r7 = r7.getName()
                r1.setClassName(r2, r7)
                r1.putExtra(r5, r4)
                android.content.Intent[] r2 = new android.content.Intent[r6]
                r2[r0] = r1
                r11[r3] = r2
                goto L96
            L68:
                r2 = 4
                if (r1 != r2) goto L96
                java.util.List r1 = com.tencent.tinker.lib.pm.PatchPackageManager.queryIntentServices(r4, r0)
                if (r1 == 0) goto L96
                int r1 = r1.size()
                if (r1 <= 0) goto L96
                android.content.Intent r1 = new android.content.Intent
                r1.<init>(r4)
                android.content.Context r2 = com.tencent.tinker.lib.Muter.getAppContext()
                java.lang.String r2 = r2.getPackageName()
                java.lang.Class<com.tencent.tinker.lib.stub.RedirectService> r7 = com.tencent.tinker.lib.stub.RedirectService.class
                java.lang.String r7 = r7.getName()
                r1.setClassName(r2, r7)
                r1.putExtra(r5, r4)
                android.content.Intent[] r2 = new android.content.Intent[r6]
                r2[r0] = r1
                r11[r3] = r2
            L96:
                java.lang.Object r9 = super.beforeInvoke(r9, r10, r11)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.ActivityManagerProxy.GetIntentSender.beforeInvoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }

    private static class GetRunningAppProcessesDelegate extends AbsMethodDelegate {
        private static final boolean isMainProc;

        private GetRunningAppProcessesDelegate() {
        }

        static {
            Covode.recordClassIndex(653750);
            isMainProc = ProcessUtil.isMainProcess(Muter.getAppContext());
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
            if (isMainProc && (obj2 instanceof ArrayList)) {
                String str = ">> " + method.getName();
                Iterator it2 = ((ArrayList) obj2).iterator();
                while (it2.hasNext()) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) it2.next();
                    String targetProcessName = PatchActivityManager.getTargetProcessName(runningAppProcessInfo.processName);
                    if (!TextUtils.isEmpty(targetProcessName)) {
                        MuteLog.i("Mute.ActMgrProxy", "%s replace RunningAppProcessInfo.processName %s --> %s", str, runningAppProcessInfo.processName, targetProcessName);
                        runningAppProcessInfo.processName = targetProcessName;
                    } else {
                        MuteLog.i("Mute.ActMgrProxy", "%s RunningAppProcessInfo.processName %s --> null", str, runningAppProcessInfo.processName, targetProcessName);
                    }
                }
            }
            return super.afterInvoke(obj, method, objArr, obj2);
        }
    }

    private static class StartActivity extends AbsMethodDelegate {
        static {
            Covode.recordClassIndex(653751);
        }

        private static List com_tencent_tinker_lib_hook_ActivityManagerProxy$StartActivity_android_content_pm_PackageManager_queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
            Result preInvoke = new HeliosApiHook().preInvoke(101311, "android/content/pm/PackageManager", "queryIntentActivities", packageManager, new Object[]{intent, Integer.valueOf(i)}, "java.util.List", new ExtraInfo(false, "(Landroid/content/Intent;I)Ljava/util/List;"));
            return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : packageManager.queryIntentActivities(intent, i);
        }

        private StartActivity() {
        }

        private Pair<Intent, String> wrapIntent(Intent intent) {
            if (intent != null && !intent.getBooleanExtra("hasWrap", false)) {
                if (!com_tencent_tinker_lib_hook_ActivityManagerProxy$StartActivity_android_content_pm_PackageManager_queryIntentActivities(Muter.getAppContext().getPackageManager(), intent, 33619968).isEmpty()) {
                    MuteLog.i("Mute.ActMgrProxy", "wrapIntent declare in host Manifest", new Object[0]);
                    return null;
                }
                if (!intent.getBooleanExtra("start_origin_no_patch", false)) {
                    List<ResolveInfo> queryIntentActivities = PatchPackageManager.queryIntentActivities(intent, 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
                        ActivityInfo selectStubActivity = PatchActivityManager.selectStubActivity(activityInfo);
                        if (selectStubActivity != null) {
                            intent.putExtra("mute_target_activity_info", activityInfo);
                            intent.putExtra("mute_stub_activity_info", selectStubActivity);
                            Intent intent2 = new Intent();
                            intent2.setClassName(selectStubActivity.packageName, selectStubActivity.name);
                            intent2.setFlags(intent.getFlags());
                            intent2.putExtra("mute_target_intent", intent);
                            intent2.putExtra("mute_target_activity_info", activityInfo);
                            intent2.putExtra("mute_stub_activity_info", selectStubActivity);
                            intent2.putExtra("mute_stub_create_info", System.currentTimeMillis() + "#" + Process.myPid() + "#" + Muter.getAppContext().getApplicationInfo().processName);
                            MuteLog.w("Mute.ActMgrProxy", "wrapIntent Target[%s] >>> Stub[%s]", activityInfo.name, selectStubActivity.name);
                            return new Pair<>(intent2, selectStubActivity.packageName);
                        }
                        MuteLog.w("Mute.ActMgrProxy", "wrapIntent no stub activity to use", new Object[0]);
                    } else {
                        MuteLog.w("Mute.ActMgrProxy", "wrapIntent query patch empty, %s", intent.getComponent());
                    }
                }
                return null;
            }
            MuteLog.w("Mute.ActMgrProxy", "wrapIntent targetIntent is null or MuteInstrumentation has wrapped intent", new Object[0]);
            return null;
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            String str = "<< " + method.getName();
            char c = 0;
            Intent intent = null;
            Intent[] intentArr = null;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; objArr != null && i3 < objArr.length; i3++) {
                Object obj2 = objArr[i3];
                if (obj2 != null && (obj2 instanceof Intent)) {
                    i = i3;
                    intent = (Intent) obj2;
                } else if (obj2 != null && (obj2 instanceof Intent[])) {
                    i2 = i3;
                    intentArr = (Intent[]) obj2;
                }
            }
            MuteLog.i("Mute.ActMgrProxy", "%s %s, %s", str, intent, intentArr);
            if (intent != null) {
                Pair<Intent, String> wrapIntent = wrapIntent(intent);
                if (wrapIntent != null) {
                    objArr[i] = wrapIntent.first;
                    objArr[1] = wrapIntent.second;
                    MuteLog.w("Mute.ActMgrProxy", "%s replace args[%d]=%s, args[1]=%s", str, Integer.valueOf(i), wrapIntent.first, wrapIntent.second);
                }
            } else if (intentArr != null) {
                int i4 = 0;
                boolean z = false;
                while (i4 < intentArr.length) {
                    Pair<Intent, String> wrapIntent2 = wrapIntent(new Intent(intentArr[i4]));
                    if (wrapIntent2 != null) {
                        intentArr[i4] = (Intent) wrapIntent2.first;
                        if (!z) {
                            objArr[1] = wrapIntent2.second;
                            z = true;
                        }
                        Object[] objArr2 = new Object[4];
                        objArr2[c] = str;
                        objArr2[1] = Integer.valueOf(i4);
                        objArr2[2] = wrapIntent2.first;
                        objArr2[3] = wrapIntent2.second;
                        MuteLog.w("Mute.ActMgrProxy", "%s replace args[%d]=%s, args[1]=%s", objArr2);
                    }
                    i4++;
                    c = 0;
                }
                objArr[i2] = intentArr;
            }
            return super.beforeInvoke(obj, method, objArr);
        }
    }

    private static class StartForeground extends AbsMethodDelegate {
        static {
            Covode.recordClassIndex(653752);
        }

        private StartForeground() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        
            r2.set(r6, r9.getKey());
            com.tencent.tinker.lib.MuteLog.w("Mute.ActMgrProxy", "%s cn.mClass = %s", r0, r9.getKey());
         */
        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object beforeInvoke(java.lang.Object r12, java.lang.reflect.Method r13, java.lang.Object[] r14) {
            /*
                r11 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "<< "
                r0.append(r1)
                java.lang.String r1 = r13.getName()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2 = 0
            L17:
                r3 = 2
                java.lang.String r4 = "Mute.ActMgrProxy"
                r5 = 1
                if (r14 == 0) goto L30
                int r6 = r14.length     // Catch: java.lang.Exception -> L2e
                if (r2 >= r6) goto L30
                r6 = r14[r2]     // Catch: java.lang.Exception -> L2e
                if (r6 == 0) goto L2b
                boolean r7 = r6 instanceof android.content.ComponentName     // Catch: java.lang.Exception -> L2e
                if (r7 == 0) goto L2b
                android.content.ComponentName r6 = (android.content.ComponentName) r6     // Catch: java.lang.Exception -> L2e
                goto L31
            L2b:
                int r2 = r2 + 1
                goto L17
            L2e:
                r2 = move-exception
                goto L83
            L30:
                r6 = 0
            L31:
                java.lang.String r2 = "%s %s"
                java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L2e
                r7[r1] = r0     // Catch: java.lang.Exception -> L2e
                r7[r5] = r6     // Catch: java.lang.Exception -> L2e
                com.tencent.tinker.lib.MuteLog.i(r4, r2, r7)     // Catch: java.lang.Exception -> L2e
                java.lang.String r2 = "mClass"
                java.lang.reflect.Field r2 = com.tencent.tinker.lib.utils.ShareReflectUtil.findField(r6, r2)     // Catch: java.lang.Exception -> L2e
                java.lang.Object r7 = r2.get(r6)     // Catch: java.lang.Exception -> L2e
                java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L2e
                java.util.Map<java.lang.String, android.content.pm.ServiceInfo> r8 = com.tencent.tinker.lib.hook.MuteHandlerCallback.sServiceMap     // Catch: java.lang.Exception -> L2e
                java.util.Set r8 = r8.entrySet()     // Catch: java.lang.Exception -> L2e
                java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Exception -> L2e
            L52:
                boolean r9 = r8.hasNext()     // Catch: java.lang.Exception -> L2e
                if (r9 == 0) goto L8e
                java.lang.Object r9 = r8.next()     // Catch: java.lang.Exception -> L2e
                java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch: java.lang.Exception -> L2e
                java.lang.Object r10 = r9.getValue()     // Catch: java.lang.Exception -> L2e
                android.content.pm.ServiceInfo r10 = (android.content.pm.ServiceInfo) r10     // Catch: java.lang.Exception -> L2e
                java.lang.String r10 = r10.name     // Catch: java.lang.Exception -> L2e
                boolean r10 = r10.equals(r7)     // Catch: java.lang.Exception -> L2e
                if (r10 == 0) goto L52
                java.lang.Object r7 = r9.getKey()     // Catch: java.lang.Exception -> L2e
                r2.set(r6, r7)     // Catch: java.lang.Exception -> L2e
                java.lang.String r2 = "%s cn.mClass = %s"
                java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L2e
                r6[r1] = r0     // Catch: java.lang.Exception -> L2e
                java.lang.Object r7 = r9.getKey()     // Catch: java.lang.Exception -> L2e
                r6[r5] = r7     // Catch: java.lang.Exception -> L2e
                com.tencent.tinker.lib.MuteLog.w(r4, r2, r6)     // Catch: java.lang.Exception -> L2e
                goto L8e
            L83:
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r3[r1] = r0
                r3[r5] = r2
                java.lang.String r0 = "%s replace cn failed! %s"
                com.tencent.tinker.lib.MuteLog.e(r4, r0, r3)
            L8e:
                java.lang.Object r12 = super.beforeInvoke(r12, r13, r14)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hook.ActivityManagerProxy.StartForeground.beforeInvoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }

    private static class GetContentProviderDelegate extends AbsMethodDelegate {
        private static final List<String> mAuthList;
        private ThreadLocal<Pair<String, String>> mAuthsLocal;
        private ThreadLocal<Boolean> mUserDefaultLocal;

        private GetContentProviderDelegate() {
            this.mAuthsLocal = new ThreadLocal<>();
            this.mUserDefaultLocal = new ThreadLocal<>();
        }

        static {
            Covode.recordClassIndex(653748);
            mAuthList = Arrays.asList(String.format("%s.mute.pm.PPMP", Muter.getAppContext().getPackageName()), String.format("%s.mute.am.PAMP", Muter.getAppContext().getPackageName()));
        }

        private String getPPMPOrPAMPAuth(Object[] objArr) {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (mAuthList.contains(str)) {
                        return str;
                    }
                }
            }
            return null;
        }

        private int getAuthIndex(Object[] objArr) {
            if (objArr != null && objArr.length > 0) {
                if (OSUtil.isAndroidQHigher()) {
                    return 2;
                }
                for (int i = 0; i < objArr.length; i++) {
                    Object obj = objArr[i];
                    if (obj != null && (obj instanceof String) && ((String) obj).length() > 0) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            boolean z;
            String str = "<< " + method.getName() + ", ";
            this.mAuthsLocal.set(null);
            this.mUserDefaultLocal.set(Boolean.FALSE);
            int authIndex = getAuthIndex(objArr);
            if (authIndex >= 0 && authIndex < objArr.length) {
                String pPMPOrPAMPAuth = getPPMPOrPAMPAuth(objArr);
                if (pPMPOrPAMPAuth != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    pPMPOrPAMPAuth = (String) objArr[authIndex];
                }
                ProviderInfo resolveContentProvider = Muter.getAppContext().getPackageManager().resolveContentProvider(pPMPOrPAMPAuth, 33554432);
                if (z) {
                    return super.beforeInvoke(obj, method, objArr);
                }
                if (resolveContentProvider != null) {
                    return super.beforeInvoke(obj, method, objArr);
                }
                ProviderInfo resolveContentProvider2 = PatchPackageManager.resolveContentProvider(pPMPOrPAMPAuth, 0);
                if (resolveContentProvider2 != null) {
                    ProviderInfo selectStubProvider = PatchActivityManager.selectStubProvider(resolveContentProvider2);
                    if (selectStubProvider != null) {
                        objArr[authIndex] = selectStubProvider.authority;
                        this.mAuthsLocal.set(new Pair<>(pPMPOrPAMPAuth, selectStubProvider.authority));
                        MuteLog.w("Mute.ActMgrProxy", str + String.format("Target[%s] >>> Stub[%s]", pPMPOrPAMPAuth, selectStubProvider.authority), new Object[0]);
                    } else {
                        MuteLog.d("Mute.ActMgrProxy", str + "selectStubProvider null, auth = " + pPMPOrPAMPAuth, new Object[0]);
                    }
                } else {
                    MuteLog.d("Mute.ActMgrProxy", str + "resolveContentProvider null, auth = " + pPMPOrPAMPAuth, new Object[0]);
                }
                return super.beforeInvoke(obj, method, objArr);
            }
            MuteLog.w("Mute.ActMgrProxy", str + " authIndex invalid", new Object[0]);
            return super.beforeInvoke(obj, method, objArr);
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
            if (obj2 == null) {
                return super.afterInvoke(obj, method, objArr, obj2);
            }
            new ContentProviderProxy(obj2, this.mAuthsLocal.get()).onHookInstall();
            return super.afterInvoke(obj, method, objArr, obj2);
        }
    }

    @Override // com.tencent.tinker.lib.hook.OnHookInstall
    public void onHookInstall() {
        Object readStaticField;
        try {
            if (OSUtil.isAndroidNOHigher()) {
                readStaticField = FieldUtils.readStaticField(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton");
            } else {
                readStaticField = FieldUtils.readStaticField(Class.forName("android.app.ActivityManagerNative"), "gDefault");
            }
            if (Class.forName("android.util.Singleton").isInstance(readStaticField)) {
                Object readField = FieldUtils.readField(readStaticField, "mInstance");
                if (readField == null) {
                    readField = MethodUtils.invokeMethod(readStaticField, "get", new Object[0]);
                }
                if (readField != null) {
                    setTarget(readField);
                    FieldUtils.writeField(readStaticField, "mInstance", ProxyHelper.createProxy(readField, this));
                    MuteLog.w("Mute.ActMgrProxy", "onHookInstall hook success!!", new Object[0]);
                    return;
                }
                MuteLog.w("Mute.ActMgrProxy", "onHookInstall hook failed!!", new Object[0]);
            }
        } catch (Exception e) {
            MuteLog.e("Mute.ActMgrProxy", "onHookInstall hook failed!! %s", e);
        }
    }

    static {
        Covode.recordClassIndex(653746);
        StartActivity startActivity = new StartActivity();
        AbsObjectProxy.sDelegateMethods.put("startActivity", startActivity);
        AbsObjectProxy.sDelegateMethods.put("startActivityAsUser", startActivity);
        AbsObjectProxy.sDelegateMethods.put("startActivityAsCaller", startActivity);
        AbsObjectProxy.sDelegateMethods.put("startActivityAndWait", startActivity);
        AbsObjectProxy.sDelegateMethods.put("startActivityWithConfig", startActivity);
        AbsObjectProxy.sDelegateMethods.put("startActivities", startActivity);
        AbsObjectProxy.sDelegateMethods.put("finishActivity", new FinishActivity());
        AbsObjectProxy.sDelegateMethods.put("overridePendingTransition", new OverridePendingTransition("Mute.ActMgrProxy"));
        AbsObjectProxy.sDelegateMethods.put("getIntentSender", new GetIntentSender());
        boolean z = true;
        AbsObjectProxy.sDelegateMethods.put("startService", new StartStopService(z));
        boolean z2 = false;
        AbsObjectProxy.sDelegateMethods.put("stopService", new StartStopService(z2));
        AbsObjectProxy.sDelegateMethods.put("bindService", new StartStopService(z));
        AbsObjectProxy.sDelegateMethods.put("bindIsolatedService", new StartStopService(z));
        AbsObjectProxy.sDelegateMethods.put("bindServiceInstance", new StartStopService(z));
        AbsObjectProxy.sDelegateMethods.put("unbindService", new StartStopService(z2));
        AbsObjectProxy.sDelegateMethods.put("setServiceForeground", new StartForeground());
        BroadcastIntent broadcastIntent = new BroadcastIntent();
        AbsObjectProxy.sDelegateMethods.put("broadcastIntent", broadcastIntent);
        if (OSUtil.isAndroidRHigher()) {
            AbsObjectProxy.sDelegateMethods.put("broadcastIntentWithFeature", broadcastIntent);
        }
        AbsObjectProxy.sDelegateMethods.put("getContentProvider", new GetContentProviderDelegate());
        AbsObjectProxy.sDelegateMethods.put("getRunningAppProcesses", new GetRunningAppProcessesDelegate());
    }

    private static class StartStopService extends AbsMethodDelegate {
        private final boolean mIsStart;

        static {
            Covode.recordClassIndex(653753);
        }

        private StartStopService(boolean z) {
            this.mIsStart = z;
        }

        @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
        public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
            Intent extractIntent = ActivityManagerProxy.extractIntent(objArr);
            String str = "<< " + method.getName();
            MuteLog.i("Mute.ActMgrProxy", "%s %s", str, extractIntent);
            if (this.mIsStart && !Muter.getAppContext().getPackageManager().queryIntentServices(extractIntent, 33619968).isEmpty()) {
                MuteLog.i("Mute.ActMgrProxy", "%s declare in host Manifest", str);
                return super.beforeInvoke(obj, method, objArr);
            }
            if (extractIntent != null && !extractIntent.getBooleanExtra("start_origin_no_patch", false)) {
                List<ResolveInfo> queryIntentServices = PatchPackageManager.queryIntentServices(extractIntent, 0);
                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                    if (queryIntentServices.get(0).serviceInfo != null) {
                        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                        ServiceInfo selectStubService = PatchActivityManager.selectStubService(serviceInfo);
                        if (selectStubService != null) {
                            if (this.mIsStart) {
                                PatchActivityManager.serviceCreated(selectStubService, serviceInfo);
                            }
                            extractIntent.setClassName(selectStubService.packageName, selectStubService.name);
                            MuteLog.w("Mute.ActMgrProxy", "%s Target[%s] >>> Stub[%s]", str, serviceInfo.name, selectStubService.name);
                        } else {
                            MuteLog.w("Mute.ActMgrProxy", "%s no stub service to use", str);
                        }
                    }
                } else {
                    MuteLog.w("Mute.ActMgrProxy", "%s query patch empty, %s", str, extractIntent.getComponent());
                }
            }
            return super.beforeInvoke(obj, method, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent extractIntent(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj instanceof Intent) {
                    return (Intent) obj;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.tinker.lib.hook.AbsObjectProxy
    protected boolean isCatchInvokeThrowable(Method method) {
        if (method != null && "startActivity".equals(method.getName())) {
            return false;
        }
        return super.isCatchInvokeThrowable(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean replaceIntentArgs(Object[] objArr, Intent intent) {
        if (objArr != null && objArr.length > 0) {
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] instanceof Intent) {
                    objArr[i] = intent;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tinker.lib.hook.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(obj, method, objArr);
    }
}
