package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaaSPostUserInfo implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private SaasUserBaseInfo baseInfo;
    private Map<String, String> expandExtra;
    private boolean hasLiveRoom;
    private String label;
    private Integer relationType;
    private SaasUserTag userTag;
    private String userId = "";
    private String userAvatar = "";
    private String avatarDecorationUrl = "";
    private String avatarDecorationId = "";
    private String userName = "";

    public static final class a {
        static {
            Covode.recordClassIndex(599129);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599128);
        Companion = new a(null);
    }

    public final String getAvatarDecorationId() {
        return this.avatarDecorationId;
    }

    public final String getAvatarDecorationUrl() {
        return this.avatarDecorationUrl;
    }

    public final SaasUserBaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public final Map<String, String> getExpandExtra() {
        return this.expandExtra;
    }

    public final boolean getHasLiveRoom() {
        return this.hasLiveRoom;
    }

    public final String getLabel() {
        return this.label;
    }

    public final Integer getRelationType() {
        return this.relationType;
    }

    public final String getUserAvatar() {
        return this.userAvatar;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final SaasUserTag getUserTag() {
        return this.userTag;
    }

    public final void setBaseInfo(SaasUserBaseInfo saasUserBaseInfo) {
        this.baseInfo = saasUserBaseInfo;
    }

    public final void setExpandExtra(Map<String, String> map) {
        this.expandExtra = map;
    }

    public final void setHasLiveRoom(boolean z) {
        this.hasLiveRoom = z;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final void setRelationType(Integer num) {
        this.relationType = num;
    }

    public final void setUserTag(SaasUserTag saasUserTag) {
        this.userTag = saasUserTag;
    }

    public final void setAvatarDecorationId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarDecorationId = str;
    }

    public final void setAvatarDecorationUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarDecorationUrl = str;
    }

    public final void setUserAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userAvatar = str;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userName = str;
    }
}
