package com.dragon.read.local.db.entity;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 0;

    @SerializedName("module_name")
    public String moduleName;

    @SerializedName("page_name")
    public String pageName;

    @SerializedName("tab_name")
    public String tabName;

    static {
        Covode.recordClassIndex(611592);
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getTabName() {
        return this.tabName;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setPageName(String str) {
        this.pageName = str;
    }

    public void setTabName(String str) {
        this.tabName = str;
    }
}
