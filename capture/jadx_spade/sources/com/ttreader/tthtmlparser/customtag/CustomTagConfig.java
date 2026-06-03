package com.ttreader.tthtmlparser.customtag;

import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CustomTagConfig {
    private final List<ICustomTagBehavior> behaviorList;
    private final Map<String, String> mappingConfig;

    static {
        Covode.recordClassIndex(654755);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomTagConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomTagConfig copy$default(CustomTagConfig customTagConfig, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = customTagConfig.behaviorList;
        }
        if ((i & 2) != 0) {
            map = customTagConfig.mappingConfig;
        }
        return customTagConfig.copy(list, map);
    }

    public final List<ICustomTagBehavior> component1() {
        return this.behaviorList;
    }

    public final Map<String, String> component2() {
        return this.mappingConfig;
    }

    public final CustomTagConfig copy(List<? extends ICustomTagBehavior> list, Map<String, String> map) {
        return new CustomTagConfig(list, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomTagConfig)) {
            return false;
        }
        CustomTagConfig customTagConfig = (CustomTagConfig) obj;
        return Intrinsics.areEqual(this.behaviorList, customTagConfig.behaviorList) && Intrinsics.areEqual(this.mappingConfig, customTagConfig.mappingConfig);
    }

    public int hashCode() {
        List<ICustomTagBehavior> list = this.behaviorList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Map<String, String> map = this.mappingConfig;
        return hashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "CustomTagConfig(behaviorList=" + this.behaviorList + ", mappingConfig=" + this.mappingConfig + ')';
    }

    public final List<ICustomTagBehavior> getBehaviorList() {
        return this.behaviorList;
    }

    public final Map<String, String> getMappingConfig() {
        return this.mappingConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomTagConfig(List<? extends ICustomTagBehavior> list, Map<String, String> map) {
        this.behaviorList = list;
        this.mappingConfig = map;
    }

    public /* synthetic */ CustomTagConfig(List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : map);
    }
}
