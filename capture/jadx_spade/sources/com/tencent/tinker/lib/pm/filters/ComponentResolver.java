package com.tencent.tinker.lib.pm.filters;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageParser;
import android.content.pm.PackageParser.Component;
import android.content.pm.PackageParser.IntentInfo;
import android.content.pm.ResolveInfo;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.Muter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ComponentResolver<CP extends PackageParser.Component<II>, II extends PackageParser.IntentInfo> extends IntentFilterResolver<II, ResolveInfo> {
    private static Comparator sComparator;
    public final HashMap<ComponentName, CP> mAllComponents = new HashMap<>();
    public final HashMap<ComponentName, CP> mCoupledComponents = new HashMap<>();
    private int mFlags;

    protected abstract ComponentInfo generateComponentInfo(ResolveInfo resolveInfo, II ii);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public abstract II[] newArray(int i);

    protected abstract ComponentName newComponentName(CP cp);

    static {
        Covode.recordClassIndex(653781);
        sComparator = new Comparator<ResolveInfo>() { // from class: com.tencent.tinker.lib.pm.filters.ComponentResolver.1
            @Override // java.util.Comparator
            public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
                int i = resolveInfo.priority;
                int i2 = resolveInfo2.priority;
                if (i != i2) {
                    if (i > i2) {
                        return -1;
                    }
                    return 1;
                }
                int i3 = resolveInfo.preferredOrder;
                int i4 = resolveInfo2.preferredOrder;
                if (i3 != i4) {
                    if (i3 > i4) {
                        return -1;
                    }
                    return 1;
                }
                boolean z = resolveInfo.isDefault;
                if (z != resolveInfo2.isDefault) {
                    if (z) {
                        return -1;
                    }
                    return 1;
                }
                int i5 = resolveInfo.match;
                int i6 = resolveInfo2.match;
                if (i5 != i6) {
                    if (i5 > i6) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
        };
    }

    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    protected void sortResults(List<ResolveInfo> list) {
        Collections.sort(list, sComparator);
    }

    public final CP getComponent(ComponentName componentName) {
        return this.mAllComponents.get(componentName);
    }

    public final CP getCoupledComponent(ComponentName componentName) {
        return this.mCoupledComponents.get(componentName);
    }

    public final void removeComponent(CP cp) {
        ComponentName newComponentName = newComponentName(cp);
        this.mAllComponents.remove(newComponentName);
        this.mCoupledComponents.remove(new ComponentName(Muter.getAppContext().getPackageName(), newComponentName.getClassName()));
        if (((PackageParser.Component) cp).intents != null) {
            int size = ((PackageParser.Component) cp).intents.size();
            for (int i = 0; i < size; i++) {
                removeFilter((IntentFilter) ((PackageParser.Component) cp).intents.get(i));
            }
        }
    }

    public final void addComponent(CP cp, String str) {
        ComponentName newComponentName = newComponentName(cp);
        this.mAllComponents.put(newComponentName, cp);
        this.mCoupledComponents.put(new ComponentName(Muter.getAppContext().getPackageName(), newComponentName.getClassName()), cp);
        if (((PackageParser.Component) cp).intents != null) {
            int size = ((PackageParser.Component) cp).intents.size();
            for (int i = 0; i < size; i++) {
                PackageParser.IntentInfo intentInfo = (PackageParser.IntentInfo) ((PackageParser.Component) cp).intents.get(i);
                if (intentInfo.getPriority() > 0 && "activity".equals(str)) {
                    intentInfo.setPriority(0);
                }
                addFilter(intentInfo);
            }
        }
    }

    public final List<ResolveInfo> queryIntent(Intent intent, String str, int i) {
        boolean z;
        this.mFlags = i;
        if ((i & 65536) != 0) {
            z = true;
        } else {
            z = false;
        }
        return super.queryIntent(intent, str, z, 0);
    }

    public final List<ResolveInfo> queryIntent(Intent intent, String str, boolean z) {
        int i;
        if (z) {
            i = 65536;
        } else {
            i = 0;
        }
        this.mFlags = i;
        return super.queryIntent(intent, str, z, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.lib.pm.filters.IntentFilterResolver
    public ResolveInfo newResult(II ii, int i, int i2) {
        ResolveInfo resolveInfo = new ResolveInfo();
        ComponentInfo generateComponentInfo = generateComponentInfo(resolveInfo, ii);
        if (generateComponentInfo == null) {
            return null;
        }
        resolveInfo.resolvePackageName = generateComponentInfo.packageName;
        resolveInfo.icon = generateComponentInfo.icon;
        resolveInfo.labelRes = generateComponentInfo.labelRes;
        boolean z = false;
        resolveInfo.preferredOrder = 0;
        resolveInfo.specificIndex = 1;
        int i3 = this.mFlags;
        if ((i3 & 64) != 0) {
            resolveInfo.filter = ii;
        }
        if ((i3 & 65536) != 0) {
            z = ii.hasCategory("android.intent.category.DEFAULT");
        }
        resolveInfo.isDefault = z;
        resolveInfo.priority = ii.getPriority();
        resolveInfo.match = i;
        return resolveInfo;
    }

    public final List<ResolveInfo> queryIntentForPackage(Intent intent, String str, List<CP> list, int i) {
        boolean z;
        if (list == null) {
            return null;
        }
        this.mFlags = i;
        if ((i & 65536) != 0) {
            z = true;
        } else {
            z = false;
        }
        int size = list.size();
        ArrayList<F[]> arrayList = new ArrayList<>(size);
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList arrayList2 = ((PackageParser.Component) list.get(i2)).intents;
            if (arrayList2 != null && arrayList2.size() > 0) {
                II[] newArray = newArray(arrayList2.size());
                arrayList2.toArray(newArray);
                arrayList.add(newArray);
            }
        }
        return super.queryIntentFromList(intent, str, z, arrayList, 0);
    }
}
