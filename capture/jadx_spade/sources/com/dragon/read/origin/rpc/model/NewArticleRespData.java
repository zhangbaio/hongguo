package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NewArticleRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("column_data")
    public ColumnData columnData;

    @SerializedName("creation_status")
    public CreationStatus creationStatus;

    @SerializedName("hot_timer")
    public List<Integer> hotTimer;

    @SerializedName("is_initial_default_book")
    public boolean isInitialDefaultBook;

    @SerializedName("is_reuse")
    public int isReuse;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("latest_publish_item_info")
    public ItemInfo latestPublishItemInfo;

    @SerializedName("latest_version")
    public int latestVersion;

    @SerializedName("permission_switch")
    public short permissionSwitch;

    @SerializedName("pre_audit_info")
    @RpcField(FieldType.BODY)
    public PreAuditInfo preAuditInfo;

    @SerializedName("user_auth")
    public UserAuthStatus userAuth;

    @SerializedName("volume_data")
    public List<VolumeData> volumeData;

    @SerializedName("volume_id")
    public String volumeID;

    static {
        Covode.recordClassIndex(613249);
        fieldTypeClassRef = FieldType.class;
    }
}
