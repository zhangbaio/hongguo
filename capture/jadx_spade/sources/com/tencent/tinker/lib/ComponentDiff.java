package com.tencent.tinker.lib;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageParser;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.tencent.tinker.lib.utils.FieldUtils;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ComponentDiff implements Serializable {
    public String[] activityAdd;
    public int activityAddCnt;
    public String[] activityAddProc;
    public String[] activityChange;
    public int activityChangeCnt;
    public int[] activityChangeLabels;
    public String[] activityChangeProc;
    public int[] activityChangeThemes;
    public String[] activityRemove;
    public int activityRemoveCnt;
    public String[] permissionAdd;
    public int permissionAddCnt;
    public String[] permissionRemove;
    public int permissionRemoveCnt;
    public String[] providerAdd;
    public int providerAddCnt;
    public String[] providerAddProc;
    public String[] providerRemove;
    public int providerRemoveCnt;
    public String[] receiverAdd;
    public int receiverAddCnt;
    public String[] receiverAddProc;
    public String[] receiverRemove;
    public int receiverRemoveCnt;
    public String[] serviceAdd;
    public int serviceAddCnt;
    public String[] serviceAddProc;
    public String[] serviceRemove;
    public int serviceRemoveCnt;

    static {
        Covode.recordClassIndex(653681);
    }

    public String toString() {
        return "ComponentDiff[\n activityAdd_" + this.activityAddCnt + " " + Arrays.toString(this.activityAdd) + "\n activityRemove_" + this.activityRemoveCnt + " " + Arrays.toString(this.activityRemove) + "\n activityChange_" + this.activityChangeCnt + " " + Arrays.toString(this.activityChange) + "\n serviceAdd_" + this.serviceAddCnt + " " + Arrays.toString(this.serviceAdd) + "\n serviceRemove_" + this.serviceRemoveCnt + " " + Arrays.toString(this.serviceRemove) + "\n receiverAdd_" + this.receiverAddCnt + " " + Arrays.toString(this.receiverAdd) + "\n receiverRemove_" + this.receiverRemoveCnt + " " + Arrays.toString(this.receiverRemove) + "\n providerAdd_" + this.providerAddCnt + " " + Arrays.toString(this.providerAdd) + "\n providerRemove_" + this.providerRemoveCnt + " " + Arrays.toString(this.providerRemove) + "\n permissionAdd_" + this.permissionAddCnt + " " + Arrays.toString(this.permissionAdd) + "\n permissionRemoved_" + this.permissionRemoveCnt + " " + Arrays.toString(this.permissionRemove) + "\n]";
    }

    public List<PackageParser.Activity> asActivityArr(ActivityInfo[] activityInfoArr) throws IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                PackageParser.Activity activity = new PackageParser.Activity();
                FieldUtils.writeField(activity, "info", activityInfo);
                arrayList.add(activity);
            }
        }
        return arrayList;
    }

    public List<PackageParser.Permission> asPermissionArr(PermissionInfo[] permissionInfoArr) throws IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        if (permissionInfoArr != null) {
            for (PermissionInfo permissionInfo : permissionInfoArr) {
                PackageParser.Permission permission = new PackageParser.Permission();
                FieldUtils.writeField(permission, "info", permissionInfo);
                arrayList.add(permission);
            }
        }
        return arrayList;
    }

    public List<PackageParser.Provider> asProviderArr(ProviderInfo[] providerInfoArr) throws IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                PackageParser.Provider provider = new PackageParser.Provider();
                FieldUtils.writeField(provider, "info", providerInfo);
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public List<PackageParser.Service> asServiceArr(ServiceInfo[] serviceInfoArr) throws IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                PackageParser.Service service = new PackageParser.Service();
                FieldUtils.writeField(service, "info", serviceInfo);
                arrayList.add(service);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0038: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:17039416), block:B:23:0x0038 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.tencent.tinker.lib.ComponentDiff loadLocal(java.io.File r7) {
        /*
            java.lang.String r0 = "Mute.Diff"
            r1 = 0
            r2 = 1
            r3 = 0
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper r5 = new com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.Object r7 = r4.readObject()     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L37
            com.tencent.tinker.lib.ComponentDiff r7 = (com.tencent.tinker.lib.ComponentDiff) r7     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L37
            java.lang.String r5 = "loadLocal object %s"
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L37
            r6[r1] = r7     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L37
            com.tencent.tinker.lib.MuteLog.i(r0, r5, r6)     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L37
            r4.close()     // Catch: java.io.IOException -> L21
        L21:
            return r7
        L22:
            r7 = move-exception
            goto L28
        L24:
            r7 = move-exception
            goto L39
        L26:
            r7 = move-exception
            r4 = r3
        L28:
            java.lang.String r5 = "loadLocal failed. %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L37
            r2[r1] = r7     // Catch: java.lang.Throwable -> L37
            com.tencent.tinker.lib.MuteLog.e(r0, r5, r2)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L36
            r4.close()     // Catch: java.io.IOException -> L36
        L36:
            return r3
        L37:
            r7 = move-exception
            r3 = r4
        L39:
            if (r3 == 0) goto L3e
            r3.close()     // Catch: java.io.IOException -> L3e
        L3e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.ComponentDiff.loadLocal(java.io.File):com.tencent.tinker.lib.ComponentDiff");
    }

    public boolean saveLocal(File file) {
        ObjectOutputStream objectOutputStream;
        if (this.activityAddCnt == 0 && this.activityRemoveCnt == 0 && this.activityChangeCnt == 0 && this.serviceAddCnt == 0 && this.serviceRemoveCnt == 0 && this.receiverAddCnt == 0 && this.receiverRemoveCnt == 0 && this.providerAddCnt == 0 && this.providerRemoveCnt == 0 && this.permissionAddCnt == 0 && this.permissionRemoveCnt == 0) {
            MuteLog.w("Mute.Diff", "saveLocal no diff skip", new Object[0]);
            return true;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                objectOutputStream = new ObjectOutputStream(new PolarisFileOutputStreamWrapper(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            objectOutputStream.writeObject(this);
            MuteLog.i("Mute.Diff", "saveLocal object --> component.diff, %s", this);
            try {
                objectOutputStream.close();
            } catch (IOException unused) {
            }
            return true;
        } catch (Exception e2) {
            e = e2;
            objectOutputStream2 = objectOutputStream;
            MuteLog.e("Mute.Diff", "saveLocal failed, %s", e);
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private PackageParser.Activity findActivityByName(List<PackageParser.Activity> list, String str) {
        for (PackageParser.Activity activity : list) {
            if (activity != null && activity.info != null && TextUtils.equals(activity.info.name, str)) {
                return activity;
            }
        }
        return null;
    }

    private PackageParser.Permission findPermissionByName(List<PackageParser.Permission> list, String str) {
        for (PackageParser.Permission permission : list) {
            if (permission != null && permission.info != null && TextUtils.equals(permission.info.name, str)) {
                return permission;
            }
        }
        return null;
    }

    private PackageParser.Provider findProviderByName(List<PackageParser.Provider> list, String str) {
        for (PackageParser.Provider provider : list) {
            if (provider != null && provider.info != null && TextUtils.equals(provider.info.name, str)) {
                return provider;
            }
        }
        return null;
    }

    private PackageParser.Service findServiceByName(List<PackageParser.Service> list, String str) {
        for (PackageParser.Service service : list) {
            if (service != null && service.info != null && TextUtils.equals(service.info.name, str)) {
                return service;
            }
        }
        return null;
    }

    public void diffPermission(List<PackageParser.Permission> list, List<PackageParser.Permission> list2) {
        ArrayList arrayList = new ArrayList();
        for (PackageParser.Permission permission : list2) {
            if (findPermissionByName(list, permission.info.name) == null) {
                arrayList.add(permission.info.name);
                MuteLog.d("Mute.Diff", "diffPermission add[%s]", permission.info.name);
            }
        }
        this.permissionAddCnt = arrayList.size();
        this.permissionAdd = (String[]) arrayList.toArray(new String[0]);
        ArrayList arrayList2 = new ArrayList();
        for (PackageParser.Permission permission2 : list) {
            if (findPermissionByName(list2, permission2.info.name) == null) {
                arrayList2.add(permission2.info.name);
                MuteLog.d("Mute.Diff", "diffPermission remove[%s]", permission2.info.name);
            }
        }
        this.permissionRemoveCnt = arrayList2.size();
        this.permissionRemove = (String[]) arrayList2.toArray(new String[0]);
        MuteLog.i("Mute.Diff", "diffPermission add[%d] remove[%d]", Integer.valueOf(this.permissionAddCnt), Integer.valueOf(this.permissionRemoveCnt));
    }

    public void diffProvider(List<PackageParser.Provider> list, List<PackageParser.Provider> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (PackageParser.Provider provider : list2) {
            if (findProviderByName(list, provider.info.name) == null) {
                arrayList.add(provider.info.name);
                arrayList2.add(provider.info.processName);
                MuteLog.d("Mute.Diff", "diffProvider add[%s]", provider.info.name);
            }
        }
        this.providerAddCnt = arrayList.size();
        this.providerAdd = (String[]) arrayList.toArray(new String[0]);
        this.providerAddProc = (String[]) arrayList2.toArray(new String[0]);
        ArrayList arrayList3 = new ArrayList();
        for (PackageParser.Provider provider2 : list) {
            if (findProviderByName(list2, provider2.info.name) == null) {
                arrayList3.add(provider2.info.name);
                MuteLog.d("Mute.Diff", "diffProvider remove[%s]", provider2.info.name);
            }
        }
        this.providerRemoveCnt = arrayList3.size();
        this.providerRemove = (String[]) arrayList3.toArray(new String[0]);
        MuteLog.i("Mute.Diff", "diffProvider add[%d] remove[%d]", Integer.valueOf(this.providerAddCnt), Integer.valueOf(this.providerRemoveCnt));
    }

    public void diffReceiver(List<PackageParser.Activity> list, List<PackageParser.Activity> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (PackageParser.Activity activity : list2) {
            if (findActivityByName(list, activity.info.name) == null) {
                arrayList.add(activity.info.name);
                arrayList2.add(activity.info.processName);
                MuteLog.d("Mute.Diff", "diffReceiver add[%s]", activity.info.name);
            }
        }
        this.receiverAddCnt = arrayList.size();
        this.receiverAdd = (String[]) arrayList.toArray(new String[0]);
        this.receiverAddProc = (String[]) arrayList2.toArray(new String[0]);
        ArrayList arrayList3 = new ArrayList();
        for (PackageParser.Activity activity2 : list) {
            if (findActivityByName(list2, activity2.info.name) == null) {
                arrayList3.add(activity2.info.name);
                MuteLog.d("Mute.Diff", "diffReceiver remove[%s]", activity2.info.name);
            }
        }
        this.receiverRemoveCnt = arrayList3.size();
        this.receiverRemove = (String[]) arrayList3.toArray(new String[0]);
        MuteLog.i("Mute.Diff", "diffReceiver add[%d] remove[%d]", Integer.valueOf(this.receiverAddCnt), Integer.valueOf(this.receiverRemoveCnt));
    }

    public void diffService(List<PackageParser.Service> list, List<PackageParser.Service> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (PackageParser.Service service : list2) {
            if (findServiceByName(list, service.info.name) == null) {
                arrayList.add(service.info.name);
                arrayList2.add(service.info.processName);
                MuteLog.d("Mute.Diff", "diffService add[%s]", service.info.name);
            }
        }
        this.serviceAddCnt = arrayList.size();
        this.serviceAdd = (String[]) arrayList.toArray(new String[0]);
        this.serviceAddProc = (String[]) arrayList2.toArray(new String[0]);
        ArrayList arrayList3 = new ArrayList();
        for (PackageParser.Service service2 : list) {
            if (findServiceByName(list2, service2.info.name) == null) {
                arrayList3.add(service2.info.name);
                MuteLog.d("Mute.Diff", "diffService remove[%s]", service2.info.name);
            }
        }
        this.serviceRemoveCnt = arrayList3.size();
        this.serviceRemove = (String[]) arrayList3.toArray(new String[0]);
        MuteLog.i("Mute.Diff", "diffService add[%d] remove[%d]", Integer.valueOf(this.serviceAddCnt), Integer.valueOf(this.serviceRemoveCnt));
    }

    public void diffActivity(List<PackageParser.Activity> list, List<PackageParser.Activity> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (PackageParser.Activity activity : list2) {
            PackageParser.Activity findActivityByName = findActivityByName(list, activity.info.name);
            if (findActivityByName == null) {
                if (activity.info.targetActivity == null) {
                    arrayList.add(activity.info.name);
                    arrayList2.add(activity.info.processName);
                    MuteLog.d("Mute.Diff", "diffActivity add[%s]", activity.info.name);
                }
            } else if (findActivityByName.info.theme != activity.info.theme || findActivityByName.info.labelRes != activity.info.labelRes) {
                arrayList3.add(findActivityByName.info.name);
                arrayList4.add(findActivityByName.info.processName);
                arrayList5.add(Integer.valueOf(findActivityByName.info.theme));
                arrayList6.add(Integer.valueOf(findActivityByName.info.labelRes));
                MuteLog.d("Mute.Diff", "diffActivity changed[%s]", findActivityByName.info.name);
            }
        }
        this.activityAddCnt = arrayList.size();
        this.activityAdd = (String[]) arrayList.toArray(new String[0]);
        this.activityAddProc = (String[]) arrayList2.toArray(new String[0]);
        this.activityChangeCnt = arrayList3.size();
        this.activityChange = (String[]) arrayList3.toArray(new String[0]);
        this.activityChangeProc = (String[]) arrayList4.toArray(new String[0]);
        int i = this.activityChangeCnt;
        this.activityChangeThemes = new int[i];
        this.activityChangeLabels = new int[i];
        for (int i2 = 0; i2 < this.activityChangeCnt; i2++) {
            this.activityChangeThemes[i2] = ((Integer) arrayList5.get(i2)).intValue();
            this.activityChangeLabels[i2] = ((Integer) arrayList6.get(i2)).intValue();
        }
        ArrayList arrayList7 = new ArrayList();
        for (PackageParser.Activity activity2 : list) {
            if (findActivityByName(list2, activity2.info.name) == null) {
                arrayList7.add(activity2.info.name);
                MuteLog.d("Mute.Diff", "diffActivity remove[%s]", activity2.info.name);
            }
        }
        this.activityRemoveCnt = arrayList7.size();
        this.activityRemove = (String[]) arrayList7.toArray(new String[0]);
        MuteLog.i("Mute.Diff", "diffActivity add[%d] remove[%d] change[%d]", Integer.valueOf(this.activityAddCnt), Integer.valueOf(this.activityRemoveCnt), Integer.valueOf(this.activityChangeCnt));
    }
}
