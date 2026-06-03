package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TabBubble implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public boolean completed;

    @SerializedName("daily_limit")
    public int dailyLimit;

    @SerializedName("display_style")
    public int displayStyle;
    public int freeze;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("is_anchor")
    public boolean isAnchor;

    @SerializedName("lifetime_limit")
    public int lifetimeLimit;

    @SerializedName("need_replace_desc")
    public boolean needReplaceDesc;

    @SerializedName("no_clicks")
    public int noClicks;
    public int priority;

    @SerializedName("show_at_second_startup")
    public boolean showAtSecondStartup;
    public String strategy;

    @SerializedName("task_key")
    public String taskKey;
    public String text;

    @SerializedName("text_list")
    public List<String> textList;

    static {
        Covode.recordClassIndex(612260);
        fieldTypeClassRef = FieldType.class;
    }
}
