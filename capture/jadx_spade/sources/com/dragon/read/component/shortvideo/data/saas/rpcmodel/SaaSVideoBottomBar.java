package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaaSVideoBottomBar implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private String clickContent;
    private Map<String, String> extra;
    private List<String> textList;
    private String type = "";
    private String groupId = "";
    private String schema = "";
    private String iconUrl = "";

    public static final class a {
        static {
            Covode.recordClassIndex(599087);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599086);
        Companion = new a(null);
    }

    public final String getClickContent() {
        return this.clickContent;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final List<String> getTextList() {
        return this.textList;
    }

    public final String getType() {
        return this.type;
    }

    public final void setClickContent(String str) {
        this.clickContent = str;
    }

    public final void setExtra(Map<String, String> map) {
        this.extra = map;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setSchema(String str) {
        this.schema = str;
    }

    public final void setTextList(List<String> list) {
        this.textList = list;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
