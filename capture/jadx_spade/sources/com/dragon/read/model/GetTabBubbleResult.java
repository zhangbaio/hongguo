package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetTabBubbleResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_conf")
    public String abConf;

    @SerializedName("bubble_list")
    public List<TabBubble> bubbleList;

    @SerializedName("tab_icon")
    public TabIcon tabIcon;

    @SerializedName("total_freq_conf")
    public BubbleFreqConf totalFreqConf;

    static {
        Covode.recordClassIndex(612113);
        fieldTypeClassRef = FieldType.class;
    }
}
