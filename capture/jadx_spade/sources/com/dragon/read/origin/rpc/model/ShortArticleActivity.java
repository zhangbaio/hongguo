package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleActivity implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID)
    public int activityID;
    public String deadline;
    public String description;

    @SerializedName("detail_url")
    public String detailURL;

    @SerializedName("group_category")
    public List<String> groupCategory;

    @SerializedName("icon_uri")
    public String iconURI;

    @SerializedName("start_time")
    public String startTime;
    public short status;
    public String title;

    static {
        Covode.recordClassIndex(613425);
        fieldTypeClassRef = FieldType.class;
    }
}
