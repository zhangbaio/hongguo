package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GroupCategoryData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("category_id")
    public long categoryID;

    @SerializedName("cover_url")
    public String coverUrl;
    public String description;
    public short gender;

    @SerializedName("group_id")
    public short groupID;

    @SerializedName("group_name")
    public String groupName;
    public String name;

    static {
        Covode.recordClassIndex(613179);
        fieldTypeClassRef = FieldType.class;
    }
}
