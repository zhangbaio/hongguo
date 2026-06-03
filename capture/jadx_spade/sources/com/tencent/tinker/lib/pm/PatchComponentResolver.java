package com.tencent.tinker.lib.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageParser;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.ComponentDiff;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.am.PatchActivityManager;
import com.tencent.tinker.lib.pm.filters.ActivityResolver;
import com.tencent.tinker.lib.pm.filters.ComponentResolver;
import com.tencent.tinker.lib.pm.filters.ProviderResolver;
import com.tencent.tinker.lib.pm.filters.ProviderResolverCompat;
import com.tencent.tinker.lib.pm.filters.ServiceResolver;
import com.tencent.tinker.lib.utils.OSUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class PatchComponentResolver {
    private static PatchComponentResolver INSTANCE;
    private PackageParser.Package mPackage;
    private ComponentResolver mProviderResolver;
    private Map<String, String> incrementActivityProcessMap = new HashMap();
    private Map<String, String> incrementReceiverProcessMap = new HashMap();
    private Map<String, String> incrementServiceProcessMap = new HashMap();
    private Map<String, String> incrementProviderProcessMap = new HashMap();
    private List<String> deleteActivityNameList = new ArrayList();
    private List<String> deleteReceiverNameList = new ArrayList();
    private List<String> deleteServiceNameList = new ArrayList();
    private List<String> deleteProviderNameList = new ArrayList();
    private List<String> modifyActivityNameList = new ArrayList();
    private List<String> modifyReceiverNameList = new ArrayList();
    private List<String> modifyServiceNameList = new ArrayList();
    private List<String> modifyProviderNameList = new ArrayList();
    private HashMap<String, PackageParser.Activity> activityParserMap = new HashMap<>();
    private Set<String> incrementProcessSet = new HashSet();
    private ActivityResolver mActivityResolver = new ActivityResolver();
    private ServiceResolver mServiceResolver = new ServiceResolver();
    private ActivityResolver mReceiverResolver = new ActivityResolver();

    public static PatchComponentResolver getInstance() {
        return INSTANCE;
    }

    public List<String> getDeleteProviderNameList() {
        return this.deleteProviderNameList;
    }

    public Set<String> getIncProcessSet() {
        return this.incrementProcessSet;
    }

    static {
        Covode.recordClassIndex(653777);
        INSTANCE = new PatchComponentResolver();
    }

    private PatchComponentResolver() {
        if (OSUtil.isAndroidKHigher()) {
            this.mProviderResolver = new ProviderResolver();
        } else {
            this.mProviderResolver = new ProviderResolverCompat();
        }
    }

    private void removePackage() {
        PackageParser.Package r0 = this.mPackage;
        if (r0 != null) {
            ArrayList<PackageParser.Activity> arrayList = r0.activities;
            if (arrayList != null && arrayList.size() > 0) {
                for (PackageParser.Activity activity : arrayList) {
                    if (activity != null && this.incrementActivityProcessMap.containsKey(activity.info.name)) {
                        this.mActivityResolver.removeComponent(activity);
                    }
                }
            }
            ArrayList<PackageParser.Activity> arrayList2 = r0.receivers;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (PackageParser.Activity activity2 : arrayList2) {
                    if (activity2 != null && this.incrementReceiverProcessMap.containsKey(activity2.info.name)) {
                        this.mReceiverResolver.removeComponent(activity2);
                    }
                }
            }
            ArrayList<PackageParser.Service> arrayList3 = r0.services;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (PackageParser.Service service : arrayList3) {
                    if (service != null && this.incrementServiceProcessMap.containsKey(service.info.name)) {
                        this.mServiceResolver.removeComponent(service);
                    }
                }
            }
            ArrayList<PackageParser.Provider> arrayList4 = r0.providers;
            if (arrayList4 != null && arrayList4.size() > 0) {
                for (PackageParser.Provider provider : arrayList4) {
                    if (provider != null && this.incrementProviderProcessMap.containsKey(provider.info.name)) {
                        this.mProviderResolver.removeComponent(provider);
                    }
                }
            }
            this.incrementActivityProcessMap.clear();
            this.incrementServiceProcessMap.clear();
            this.incrementReceiverProcessMap.clear();
            this.incrementProviderProcessMap.clear();
            this.deleteActivityNameList.clear();
            this.deleteServiceNameList.clear();
            this.deleteReceiverNameList.clear();
            this.deleteProviderNameList.clear();
            this.modifyActivityNameList.clear();
            this.modifyServiceNameList.clear();
            this.modifyReceiverNameList.clear();
            this.modifyProviderNameList.clear();
            this.activityParserMap.clear();
            this.mPackage = null;
        }
    }

    public boolean isActivityModify(String str) {
        return this.modifyActivityNameList.contains(str);
    }

    private void categoryComponent(PackageParser.Package r5) {
        ArrayList<PackageParser.Activity> arrayList = r5.activities;
        if (arrayList != null && arrayList.size() > 0) {
            for (PackageParser.Activity activity : arrayList) {
                if (activity != null && this.incrementActivityProcessMap.containsKey(activity.info.name)) {
                    this.mActivityResolver.addComponent(activity, "activity");
                }
                if (activity != null) {
                    this.activityParserMap.put(activity.info.name, activity);
                }
            }
        }
        ArrayList<PackageParser.Activity> arrayList2 = r5.receivers;
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (PackageParser.Activity activity2 : arrayList2) {
                if (activity2 != null && this.incrementReceiverProcessMap.containsKey(activity2.info.name)) {
                    this.mReceiverResolver.addComponent(activity2, "receiver");
                }
            }
        }
        ArrayList<PackageParser.Service> arrayList3 = r5.services;
        if (arrayList3 != null && arrayList3.size() > 0) {
            for (PackageParser.Service service : arrayList3) {
                if (service != null && this.incrementServiceProcessMap.containsKey(service.info.name)) {
                    this.mServiceResolver.addComponent(service, "service");
                }
            }
        }
        ArrayList<PackageParser.Provider> arrayList4 = r5.providers;
        if (arrayList4 != null && arrayList4.size() > 0) {
            for (PackageParser.Provider provider : arrayList4) {
                if (provider != null && this.incrementProviderProcessMap.containsKey(provider.info.name)) {
                    this.mProviderResolver.addComponent(provider, "provider");
                }
            }
        }
        this.mPackage = r5;
    }

    private void parseIncComponentMapV2(ComponentDiff componentDiff) {
        if (componentDiff.activityAddCnt != 0) {
            for (int i = 0; i < componentDiff.activityAddCnt; i++) {
                this.incrementActivityProcessMap.put(componentDiff.activityAdd[i], componentDiff.activityAddProc[i]);
            }
        }
        if (componentDiff.providerAddCnt != 0) {
            for (int i2 = 0; i2 < componentDiff.providerAddCnt; i2++) {
                this.incrementProviderProcessMap.put(componentDiff.providerAdd[i2], componentDiff.providerAddProc[i2]);
            }
        }
        if (componentDiff.receiverAddCnt != 0) {
            for (int i3 = 0; i3 < componentDiff.receiverAddCnt; i3++) {
                this.incrementReceiverProcessMap.put(componentDiff.receiverAdd[i3], componentDiff.receiverAddProc[i3]);
            }
        }
        if (componentDiff.serviceAddCnt != 0) {
            for (int i4 = 0; i4 < componentDiff.serviceAddCnt; i4++) {
                this.incrementServiceProcessMap.put(componentDiff.serviceAdd[i4], componentDiff.serviceAddProc[i4]);
            }
        }
        if (componentDiff.activityChangeCnt != 0) {
            this.modifyActivityNameList.addAll(Arrays.asList(componentDiff.activityChange));
        }
        if (componentDiff.activityRemoveCnt != 0) {
            this.deleteActivityNameList.addAll(Arrays.asList(componentDiff.activityRemove));
        }
        if (componentDiff.serviceRemoveCnt != 0) {
            this.deleteServiceNameList.addAll(Arrays.asList(componentDiff.serviceRemove));
        }
        if (componentDiff.receiverRemoveCnt != 0) {
            this.deleteReceiverNameList.addAll(Arrays.asList(componentDiff.receiverRemove));
        }
        if (componentDiff.providerRemoveCnt != 0) {
            this.deleteProviderNameList.addAll(Arrays.asList(componentDiff.providerRemove));
        }
    }

    public ActivityInfo getActivityInfo(ComponentName componentName, int i) {
        PackageParser.Activity component = this.mActivityResolver.getComponent(componentName);
        if (component == null) {
            component = this.mActivityResolver.getCoupledComponent(componentName);
        }
        if (component != null) {
            return ComponentInfoGenerator.generateActivityInfo(component, i);
        }
        return null;
    }

    public ProviderInfo getProviderInfo(ComponentName componentName, int i) {
        PackageParser.Provider component = this.mProviderResolver.getComponent(componentName);
        if (component == null) {
            component = (PackageParser.Provider) this.mProviderResolver.getCoupledComponent(componentName);
        }
        if (component != null) {
            return ComponentInfoGenerator.generateProviderInfo(component, i);
        }
        return null;
    }

    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) {
        PackageParser.Activity component = this.mReceiverResolver.getComponent(componentName);
        if (component == null) {
            component = this.mReceiverResolver.getCoupledComponent(componentName);
        }
        if (component != null) {
            return ComponentInfoGenerator.generateActivityInfo(component, i);
        }
        return null;
    }

    public ServiceInfo getServiceInfo(ComponentName componentName, int i) {
        PackageParser.Service component = this.mServiceResolver.getComponent(componentName);
        if (component == null) {
            component = this.mServiceResolver.getCoupledComponent(componentName);
        }
        if (component != null) {
            return ComponentInfoGenerator.generateServiceInfo(component, i);
        }
        return null;
    }

    public ActivityInfo getActivityInfo(String str, int i) {
        PackageParser.Activity activity = this.activityParserMap.get(str);
        if (activity != null) {
            return ComponentInfoGenerator.generateActivityInfo(activity, i);
        }
        return null;
    }

    public ProviderInfo resolveContentProvider(String str, int i) {
        ArrayList arrayList = this.mPackage.providers;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ProviderInfo generateProviderInfo = ComponentInfoGenerator.generateProviderInfo((PackageParser.Provider) it2.next(), i);
                if (generateProviderInfo != null && this.incrementProviderProcessMap.containsKey(generateProviderInfo.name) && TextUtils.equals(str, generateProviderInfo.authority)) {
                    return generateProviderInfo;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        if (android.text.TextUtils.equals(r1, r3.processName) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<android.content.pm.ProviderInfo> getProviders(java.lang.String r7, int r8) {
        /*
            r6 = this;
            android.content.pm.PackageParser$Package r0 = r6.mPackage
            if (r0 == 0) goto L59
            java.util.ArrayList r0 = r0.providers
            if (r0 == 0) goto L59
            int r1 = r0.size()
            if (r1 <= 0) goto L59
            java.lang.String r1 = com.tencent.tinker.lib.am.PatchActivityManager.getTargetProcessName(r7)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r0.next()
            android.content.pm.PackageParser$Provider r3 = (android.content.pm.PackageParser.Provider) r3
            android.content.pm.ProviderInfo r3 = com.tencent.tinker.lib.pm.ComponentInfoGenerator.generateProviderInfo(r3, r8)
            if (r3 == 0) goto L47
            boolean r4 = android.text.TextUtils.isEmpty(r7)
            r5 = 1
            if (r4 == 0) goto L35
            goto L48
        L35:
            java.lang.String r4 = r3.processName
            boolean r4 = android.text.TextUtils.equals(r7, r4)
            if (r4 == 0) goto L3e
            goto L48
        L3e:
            java.lang.String r4 = r3.processName
            boolean r4 = android.text.TextUtils.equals(r1, r4)
            if (r4 == 0) goto L47
            goto L48
        L47:
            r5 = 0
        L48:
            if (r5 == 0) goto L1b
            java.util.Map<java.lang.String, java.lang.String> r4 = r6.incrementProviderProcessMap
            java.lang.String r5 = r3.name
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L1b
            r2.add(r3)
            goto L1b
        L58:
            return r2
        L59:
            java.util.List r7 = java.util.Collections.EMPTY_LIST
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.pm.PatchComponentResolver.getProviders(java.lang.String, int):java.util.List");
    }

    public boolean resolvePatchPackage(PackageParser.Package r7, ComponentDiff componentDiff) {
        if (r7 != null && componentDiff != null) {
            if (TextUtils.isEmpty(Muter.getAppContext().getPackageName())) {
                MuteLog.e("Mute.PatchCpResolver", "resolve host component patch failed, invalid pkgName", new Object[0]);
                return false;
            }
            if (this.mPackage != null) {
                return true;
            }
            try {
                long nanoTime = System.nanoTime();
                removePackage();
                parseIncComponentMapV2(componentDiff);
                categoryComponent(r7);
                MuteLog.i("Mute.PatchCpResolver", "resolve host component patch success, cost:" + (System.nanoTime() - nanoTime), new Object[0]);
                return true;
            } catch (Exception e) {
                removePackage();
                MuteLog.e("Mute.PatchCpResolver", "resolve host component patch failed, %s", e);
                return false;
            }
        }
        MuteLog.e("Mute.PatchCpResolver", "resolve host component patch failed, invalid pkg", new Object[0]);
        return false;
    }

    public List<ReceiverInfo> getReceivers(String str, int i) {
        ArrayList<PackageParser.Activity> arrayList;
        boolean z;
        PackageParser.Package r11 = this.mPackage;
        if (r11 != null && (arrayList = r11.receivers) != null && arrayList.size() > 0) {
            String targetProcessName = PatchActivityManager.getTargetProcessName(str);
            ArrayList arrayList2 = new ArrayList();
            for (PackageParser.Activity activity : arrayList) {
                String str2 = activity.info.processName;
                boolean z2 = false;
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, str2) || TextUtils.equals(targetProcessName, str2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && this.incrementReceiverProcessMap.containsKey(activity.info.name)) {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = activity.intents.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(new IntentFilter((IntentFilter) it2.next()));
                    }
                    if (activity.info != null && activity.info.exported) {
                        z2 = true;
                    }
                    arrayList2.add(new ReceiverInfo(activity.className, arrayList3, z2));
                }
            }
            return arrayList2;
        }
        return Collections.EMPTY_LIST;
    }

    public ResolveInfo resolveIntent(Intent intent, String str, int i) {
        List<ResolveInfo> queryIntentActivities = queryIntentActivities(intent, str, i);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            return queryIntentActivities.get(0);
        }
        return null;
    }

    public ResolveInfo resolveService(Intent intent, String str, int i) {
        List<ResolveInfo> queryIntentServices = queryIntentServices(intent, str, i);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            return queryIntentServices.get(0);
        }
        return null;
    }

    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, String str, int i) {
        PackageParser.Package r0;
        ComponentName component = intent.getComponent();
        if (component == null && OSUtil.isAndroidI_MR1Higher() && intent.getSelector() != null) {
            intent = intent.getSelector();
            component = intent.getComponent();
        }
        if (component != null) {
            ArrayList arrayList = new ArrayList(1);
            ActivityInfo receiverInfo = getReceiverInfo(component, i);
            if (receiverInfo != null) {
                ResolveInfo resolveInfo = new ResolveInfo();
                resolveInfo.activityInfo = receiverInfo;
                arrayList.add(resolveInfo);
            }
            return arrayList;
        }
        if (!TextUtils.isEmpty(intent.getPackage()) && (r0 = this.mPackage) != null) {
            return this.mReceiverResolver.queryIntentForPackage(intent, str, r0.receivers, i);
        }
        return this.mReceiverResolver.queryIntent(intent, str, i);
    }

    public List<ResolveInfo> queryIntentActivities(Intent intent, String str, int i) {
        ComponentName component = intent.getComponent();
        if (component == null && OSUtil.isAndroidI_MR1Higher() && intent.getSelector() != null) {
            intent = intent.getSelector();
            component = intent.getComponent();
        }
        if (component != null) {
            ArrayList arrayList = new ArrayList(1);
            ActivityInfo activityInfo = getActivityInfo(component, i);
            if (activityInfo != null) {
                ResolveInfo resolveInfo = new ResolveInfo();
                resolveInfo.activityInfo = activityInfo;
                arrayList.add(resolveInfo);
            }
            return arrayList;
        }
        PackageParser.Package r0 = this.mPackage;
        if (r0 != null) {
            return this.mActivityResolver.queryIntentForPackage(intent, str, r0.activities, i);
        }
        return this.mActivityResolver.queryIntent(intent, str, i);
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, String str, int i) {
        PackageParser.Package r0;
        ComponentName component = intent.getComponent();
        if (component == null && OSUtil.isAndroidI_MR1Higher() && intent.getSelector() != null) {
            intent = intent.getSelector();
            component = intent.getComponent();
        }
        if (component != null) {
            ArrayList arrayList = new ArrayList(1);
            ServiceInfo serviceInfo = getServiceInfo(component, i);
            if (serviceInfo != null) {
                ResolveInfo resolveInfo = new ResolveInfo();
                resolveInfo.serviceInfo = serviceInfo;
                arrayList.add(resolveInfo);
            }
            return arrayList;
        }
        if (!TextUtils.isEmpty(intent.getPackage()) && (r0 = this.mPackage) != null) {
            return this.mServiceResolver.queryIntentForPackage(intent, str, r0.services, i);
        }
        return this.mServiceResolver.queryIntent(intent, str, i);
    }
}
