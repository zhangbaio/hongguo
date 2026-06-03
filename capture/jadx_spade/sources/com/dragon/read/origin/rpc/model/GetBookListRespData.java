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
public class GetBookListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("author_risk")
    public short authorRisk;

    @SerializedName("book_list")
    public List<BookList> bookList;

    @SerializedName("default_book_id")
    public long defaultBookID;

    @SerializedName("experience_info")
    public String experienceInfo;

    @SerializedName("experience_level")
    public short experienceLevel;

    @SerializedName("has_creating")
    public short hasCreating;

    @SerializedName("has_signed_and_finished_book")
    @RpcField(FieldType.BODY)
    public short hasSignedAndFinishedBook;

    @SerializedName("is_cp")
    public short isCP;

    @SerializedName("is_new_sign")
    public short isNewSign;

    @SerializedName("permission_switch")
    public short permissionSwitch;

    @SerializedName("total_count")
    public int totalCount;

    static {
        Covode.recordClassIndex(613065);
        fieldTypeClassRef = FieldType.class;
    }
}
