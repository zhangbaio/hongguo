package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasCommonStat implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("unread_comment_count")
    public long unreadCommentCount;

    @SerializedName("unread_digg_count")
    public long unreadDiggCount;

    @SerializedName("unread_savior_count")
    public long unreadSaviorCount;

    @SerializedName("unread_show_pv_count")
    public long unreadShowPvCount;

    static {
        Covode.recordClassIndex(613381);
        fieldTypeClassRef = FieldType.class;
    }
}
