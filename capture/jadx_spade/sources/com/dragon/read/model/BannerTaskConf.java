package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BannerTaskConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int action;

    @SerializedName("android_task_url")
    public String androidTaskUrl;

    @SerializedName("bubble_content")
    public String bubbleContent;
    public String icon;

    @SerializedName("ios_task_url")
    public String iosTaskUrl;
    public String name;

    static {
        Covode.recordClassIndex(612018);
        fieldTypeClassRef = FieldType.class;
    }
}
