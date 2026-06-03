package com.dragon.read.component.shortvideo.data.saas.model.videotag;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.TagInfoType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasVideoTagInfo implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 1;
    private List<String> bgColor;
    private SaasGradientOrientation bgColorOrientation;
    private boolean canUseBrandColor;
    private List<String> darkBgColor;
    private String darkIconUrl;
    private String darkTextColor;
    private String iconUrl;
    private TagInfoType infoType;
    private SaasVideoTagMode mode;
    private SaasVideoTagInfoType tagInfo;
    private String text;
    private String textColor;

    public static final class a {
        static {
            Covode.recordClassIndex(599081);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599080);
        Companion = new a(null);
    }

    public final String component1() {
        return this.text;
    }

    public final SaasGradientOrientation component10() {
        return this.bgColorOrientation;
    }

    public final SaasVideoTagInfoType component11() {
        return this.tagInfo;
    }

    public final TagInfoType component12() {
        return this.infoType;
    }

    public final List<String> component2() {
        return this.bgColor;
    }

    public final List<String> component3() {
        return this.darkBgColor;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final String component5() {
        return this.darkIconUrl;
    }

    public final boolean component6() {
        return this.canUseBrandColor;
    }

    public final String component7() {
        return this.textColor;
    }

    public final String component8() {
        return this.darkTextColor;
    }

    public final SaasVideoTagMode component9() {
        return this.mode;
    }

    public final SaasVideoTagInfo copy(String str, List<String> list, List<String> list2, String str2, String str3, boolean z, String str4, String str5, SaasVideoTagMode saasVideoTagMode, SaasGradientOrientation saasGradientOrientation, SaasVideoTagInfoType saasVideoTagInfoType, TagInfoType tagInfoType) {
        return new SaasVideoTagInfo(str, list, list2, str2, str3, z, str4, str5, saasVideoTagMode, saasGradientOrientation, saasVideoTagInfoType, tagInfoType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaasVideoTagInfo)) {
            return false;
        }
        SaasVideoTagInfo saasVideoTagInfo = (SaasVideoTagInfo) obj;
        return Intrinsics.areEqual(this.text, saasVideoTagInfo.text) && Intrinsics.areEqual(this.bgColor, saasVideoTagInfo.bgColor) && Intrinsics.areEqual(this.darkBgColor, saasVideoTagInfo.darkBgColor) && Intrinsics.areEqual(this.iconUrl, saasVideoTagInfo.iconUrl) && Intrinsics.areEqual(this.darkIconUrl, saasVideoTagInfo.darkIconUrl) && this.canUseBrandColor == saasVideoTagInfo.canUseBrandColor && Intrinsics.areEqual(this.textColor, saasVideoTagInfo.textColor) && Intrinsics.areEqual(this.darkTextColor, saasVideoTagInfo.darkTextColor) && this.mode == saasVideoTagInfo.mode && this.bgColorOrientation == saasVideoTagInfo.bgColorOrientation && this.tagInfo == saasVideoTagInfo.tagInfo && this.infoType == saasVideoTagInfo.infoType;
    }

    public int hashCode() {
        String str = this.text;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.bgColor;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.darkBgColor;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.iconUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.darkIconUrl;
        int hashCode5 = (((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + m.a(this.canUseBrandColor)) * 31;
        String str4 = this.textColor;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.darkTextColor;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        SaasVideoTagMode saasVideoTagMode = this.mode;
        int hashCode8 = (hashCode7 + (saasVideoTagMode == null ? 0 : saasVideoTagMode.hashCode())) * 31;
        SaasGradientOrientation saasGradientOrientation = this.bgColorOrientation;
        int hashCode9 = (hashCode8 + (saasGradientOrientation == null ? 0 : saasGradientOrientation.hashCode())) * 31;
        SaasVideoTagInfoType saasVideoTagInfoType = this.tagInfo;
        int hashCode10 = (hashCode9 + (saasVideoTagInfoType == null ? 0 : saasVideoTagInfoType.hashCode())) * 31;
        TagInfoType tagInfoType = this.infoType;
        return hashCode10 + (tagInfoType != null ? tagInfoType.hashCode() : 0);
    }

    public String toString() {
        return "SaasVideoTagInfo(text=" + this.text + ", bgColor=" + this.bgColor + ", darkBgColor=" + this.darkBgColor + ", iconUrl=" + this.iconUrl + ", darkIconUrl=" + this.darkIconUrl + ", canUseBrandColor=" + this.canUseBrandColor + ", textColor=" + this.textColor + ", darkTextColor=" + this.darkTextColor + ", mode=" + this.mode + ", bgColorOrientation=" + this.bgColorOrientation + ", tagInfo=" + this.tagInfo + ", infoType=" + this.infoType + ')';
    }

    public final List<String> getBgColor() {
        return this.bgColor;
    }

    public final SaasGradientOrientation getBgColorOrientation() {
        return this.bgColorOrientation;
    }

    public final boolean getCanUseBrandColor() {
        return this.canUseBrandColor;
    }

    public final List<String> getDarkBgColor() {
        return this.darkBgColor;
    }

    public final String getDarkIconUrl() {
        return this.darkIconUrl;
    }

    public final String getDarkTextColor() {
        return this.darkTextColor;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final TagInfoType getInfoType() {
        return this.infoType;
    }

    public final SaasVideoTagMode getMode() {
        return this.mode;
    }

    public final SaasVideoTagInfoType getTagInfo() {
        return this.tagInfo;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setBgColor(List<String> list) {
        this.bgColor = list;
    }

    public final void setBgColorOrientation(SaasGradientOrientation saasGradientOrientation) {
        this.bgColorOrientation = saasGradientOrientation;
    }

    public final void setCanUseBrandColor(boolean z) {
        this.canUseBrandColor = z;
    }

    public final void setDarkBgColor(List<String> list) {
        this.darkBgColor = list;
    }

    public final void setDarkIconUrl(String str) {
        this.darkIconUrl = str;
    }

    public final void setDarkTextColor(String str) {
        this.darkTextColor = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setInfoType(TagInfoType tagInfoType) {
        this.infoType = tagInfoType;
    }

    public final void setMode(SaasVideoTagMode saasVideoTagMode) {
        this.mode = saasVideoTagMode;
    }

    public final void setTagInfo(SaasVideoTagInfoType saasVideoTagInfoType) {
        this.tagInfo = saasVideoTagInfoType;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTextColor(String str) {
        this.textColor = str;
    }

    public SaasVideoTagInfo(String str, List<String> list, List<String> list2, String str2, String str3, boolean z, String str4, String str5, SaasVideoTagMode saasVideoTagMode, SaasGradientOrientation saasGradientOrientation, SaasVideoTagInfoType saasVideoTagInfoType, TagInfoType tagInfoType) {
        this.text = str;
        this.bgColor = list;
        this.darkBgColor = list2;
        this.iconUrl = str2;
        this.darkIconUrl = str3;
        this.canUseBrandColor = z;
        this.textColor = str4;
        this.darkTextColor = str5;
        this.mode = saasVideoTagMode;
        this.bgColorOrientation = saasGradientOrientation;
        this.tagInfo = saasVideoTagInfoType;
        this.infoType = tagInfoType;
    }
}
