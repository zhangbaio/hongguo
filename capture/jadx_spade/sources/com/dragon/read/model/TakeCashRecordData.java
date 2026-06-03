package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TakeCashRecordData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ali_nick_name")
    public String aliNickName;

    @SerializedName("c_time")
    public long cTime;

    @SerializedName("excitation_content")
    public ExcitationContent excitationContent;

    @SerializedName("gold_type")
    public int goldType;

    @SerializedName("invite_url")
    public String inviteUrl;

    @SerializedName("limit_read_detail")
    public LimitReadDetail limitReadDetail;

    @SerializedName("m_time")
    public long mTime;

    @SerializedName("take_cash_amount")
    public int takeCashAmount;

    @SerializedName("take_cash_status")
    public int takeCashStatus;

    @SerializedName("take_cash_type")
    public int takeCashType;

    @SerializedName("task_button_content")
    public String taskButtonContent;

    @SerializedName("we_chat_name")
    public String weChatName;

    static {
        Covode.recordClassIndex(612265);
        fieldTypeClassRef = FieldType.class;
    }
}
