package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasLongPressAction implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 1;

    @SerializedName("dislike_object_type")
    private SaasUgcActionObjectType dislikeObjectType;

    @SerializedName("dislike_report_extra")
    private Map<String, String> dislikeReportExtra;

    @SerializedName("long_press_action_card")
    private SaasLongPressActionCard longPressActionCard;

    @SerializedName("long_press_action_card_v2_type")
    private Integer longPressActionCardV2Type;

    @SerializedName("new_long_press_action_card_playlet")
    private List<SaasLongPressActionCardV2Selection> newLongPressActionCardPlaylet;
    private String toast;
    private SaasLongPressActionType type;

    public static final class a {
        static {
            Covode.recordClassIndex(599094);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599093);
        Companion = new a(null);
    }

    public static final class SaasLongPressActionCard implements Serializable {
        public static final a Companion;
        private static final long serialVersionUID = 1;
        private List<String> selections;
        private String title;

        public static final class a {
            static {
                Covode.recordClassIndex(599096);
            }

            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            Covode.recordClassIndex(599095);
            Companion = new a(null);
        }

        public final List<String> getSelections() {
            return this.selections;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setSelections(List<String> list) {
            this.selections = list;
        }

        public final void setTitle(String str) {
            this.title = str;
        }
    }

    public static final class SaasLongPressActionCardV2Selection implements Serializable {
        public static final a Companion;
        private static final long serialVersionUID = 1;

        @SerializedName("selection_dislike_report_extra")
        private Map<String, String> selectionDislikeReportExtra;

        @SerializedName("selection_head")
        private String selectionHead;

        @SerializedName("selection_id")
        private Integer selectionId;

        @SerializedName("selection_text")
        private String selectionText;

        public static final class a {
            static {
                Covode.recordClassIndex(599098);
            }

            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            Covode.recordClassIndex(599097);
            Companion = new a(null);
        }

        public final Map<String, String> getSelectionDislikeReportExtra() {
            return this.selectionDislikeReportExtra;
        }

        public final String getSelectionHead() {
            return this.selectionHead;
        }

        public final Integer getSelectionId() {
            return this.selectionId;
        }

        public final String getSelectionText() {
            return this.selectionText;
        }

        public final void setSelectionDislikeReportExtra(Map<String, String> map) {
            this.selectionDislikeReportExtra = map;
        }

        public final void setSelectionHead(String str) {
            this.selectionHead = str;
        }

        public final void setSelectionId(Integer num) {
            this.selectionId = num;
        }

        public final void setSelectionText(String str) {
            this.selectionText = str;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class SaasLongPressActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SaasLongPressActionType[] $VALUES;
        public static final a Companion;

        @SerializedName("0")
        public static final SaasLongPressActionType Disable;

        @SerializedName("1")
        public static final SaasLongPressActionType Dislike;

        @SerializedName("3")
        public static final SaasLongPressActionType DislikeCard;

        @SerializedName("4")
        public static final SaasLongPressActionType DislikeCardV2;

        @SerializedName("2")
        public static final SaasLongPressActionType ShowToast;
        private final int value;

        private static final /* synthetic */ SaasLongPressActionType[] $values() {
            return new SaasLongPressActionType[]{Disable, Dislike, ShowToast, DislikeCard, DislikeCardV2};
        }

        public static EnumEntries<SaasLongPressActionType> getEntries() {
            return $ENTRIES;
        }

        public final int getValue() {
            return this.value;
        }

        public static SaasLongPressActionType[] values() {
            return (SaasLongPressActionType[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(599099);
            Disable = new SaasLongPressActionType("Disable", 0, 0);
            Dislike = new SaasLongPressActionType("Dislike", 1, 1);
            ShowToast = new SaasLongPressActionType("ShowToast", 2, 2);
            DislikeCard = new SaasLongPressActionType("DislikeCard", 3, 3);
            DislikeCardV2 = new SaasLongPressActionType("DislikeCardV2", 4, 4);
            SaasLongPressActionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new a(null);
        }

        public static SaasLongPressActionType valueOf(String str) {
            return (SaasLongPressActionType) Enum.valueOf(SaasLongPressActionType.class, str);
        }

        public static final class a {
            static {
                Covode.recordClassIndex(599100);
            }

            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SaasLongPressActionType a(int i) {
                boolean z;
                for (SaasLongPressActionType saasLongPressActionType : SaasLongPressActionType.values()) {
                    if (saasLongPressActionType.getValue() == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return saasLongPressActionType;
                    }
                }
                return null;
            }
        }

        private SaasLongPressActionType(String str, int i, int i2) {
            this.value = i2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class SaasUgcActionObjectType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SaasUgcActionObjectType[] $VALUES;

        @SerializedName("17")
        public static final SaasUgcActionObjectType AdvertiseCreative;

        @SerializedName("13")
        public static final SaasUgcActionObjectType Author;

        @SerializedName("10")
        public static final SaasUgcActionObjectType Book;

        @SerializedName("14")
        public static final SaasUgcActionObjectType BookEndForum;

        @SerializedName("11")
        public static final SaasUgcActionObjectType Category;

        @SerializedName("2")
        public static final SaasUgcActionObjectType Comment;
        public static final a Companion;

        @SerializedName("21")
        public static final SaasUgcActionObjectType Danmaku;

        @SerializedName("9")
        public static final SaasUgcActionObjectType DouyinUser;

        @SerializedName("7")
        public static final SaasUgcActionObjectType DouyinVideo;

        @SerializedName("20")
        public static final SaasUgcActionObjectType FamousScene;

        @SerializedName("5")
        public static final SaasUgcActionObjectType Forum;

        @SerializedName("6")
        public static final SaasUgcActionObjectType Item;

        @SerializedName("15")
        public static final SaasUgcActionObjectType MaterialVideo;

        @SerializedName("18")
        public static final SaasUgcActionObjectType MissingVideo;

        @SerializedName("4")
        public static final SaasUgcActionObjectType Post;

        @SerializedName("8")
        public static final SaasUgcActionObjectType Reply;

        @SerializedName("3")
        public static final SaasUgcActionObjectType Topic;

        @SerializedName("12")
        public static final SaasUgcActionObjectType UgcVideo;

        @SerializedName("1")
        public static final SaasUgcActionObjectType User;

        @SerializedName("16")
        public static final SaasUgcActionObjectType VideoSeriesPost;

        @SerializedName("19")
        public static final SaasUgcActionObjectType WishVideo;
        private final int value;

        private static final /* synthetic */ SaasUgcActionObjectType[] $values() {
            return new SaasUgcActionObjectType[]{User, Comment, Topic, Post, Forum, Item, DouyinVideo, Reply, DouyinUser, Book, Category, UgcVideo, Author, BookEndForum, MaterialVideo, VideoSeriesPost, AdvertiseCreative, MissingVideo, WishVideo, FamousScene, Danmaku};
        }

        public static EnumEntries<SaasUgcActionObjectType> getEntries() {
            return $ENTRIES;
        }

        public final int getValue() {
            return this.value;
        }

        public static SaasUgcActionObjectType[] values() {
            return (SaasUgcActionObjectType[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(599101);
            User = new SaasUgcActionObjectType("User", 0, 1);
            Comment = new SaasUgcActionObjectType("Comment", 1, 2);
            Topic = new SaasUgcActionObjectType("Topic", 2, 3);
            Post = new SaasUgcActionObjectType("Post", 3, 4);
            Forum = new SaasUgcActionObjectType("Forum", 4, 5);
            Item = new SaasUgcActionObjectType("Item", 5, 6);
            DouyinVideo = new SaasUgcActionObjectType("DouyinVideo", 6, 7);
            Reply = new SaasUgcActionObjectType("Reply", 7, 8);
            DouyinUser = new SaasUgcActionObjectType("DouyinUser", 8, 9);
            Book = new SaasUgcActionObjectType("Book", 9, 10);
            Category = new SaasUgcActionObjectType("Category", 10, 11);
            UgcVideo = new SaasUgcActionObjectType("UgcVideo", 11, 12);
            Author = new SaasUgcActionObjectType("Author", 12, 13);
            BookEndForum = new SaasUgcActionObjectType("BookEndForum", 13, 14);
            MaterialVideo = new SaasUgcActionObjectType("MaterialVideo", 14, 15);
            VideoSeriesPost = new SaasUgcActionObjectType("VideoSeriesPost", 15, 16);
            AdvertiseCreative = new SaasUgcActionObjectType("AdvertiseCreative", 16, 17);
            MissingVideo = new SaasUgcActionObjectType("MissingVideo", 17, 18);
            WishVideo = new SaasUgcActionObjectType("WishVideo", 18, 19);
            FamousScene = new SaasUgcActionObjectType("FamousScene", 19, 20);
            Danmaku = new SaasUgcActionObjectType("Danmaku", 20, 21);
            SaasUgcActionObjectType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new a(null);
        }

        public static SaasUgcActionObjectType valueOf(String str) {
            return (SaasUgcActionObjectType) Enum.valueOf(SaasUgcActionObjectType.class, str);
        }

        public static final class a {
            static {
                Covode.recordClassIndex(599102);
            }

            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SaasUgcActionObjectType a(int i) {
                boolean z;
                for (SaasUgcActionObjectType saasUgcActionObjectType : SaasUgcActionObjectType.values()) {
                    if (saasUgcActionObjectType.getValue() == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return saasUgcActionObjectType;
                    }
                }
                return null;
            }
        }

        private SaasUgcActionObjectType(String str, int i, int i2) {
            this.value = i2;
        }
    }

    public final SaasUgcActionObjectType getDislikeObjectType() {
        return this.dislikeObjectType;
    }

    public final Map<String, String> getDislikeReportExtra() {
        return this.dislikeReportExtra;
    }

    public final SaasLongPressActionCard getLongPressActionCard() {
        return this.longPressActionCard;
    }

    public final Integer getLongPressActionCardV2Type() {
        return this.longPressActionCardV2Type;
    }

    public final List<SaasLongPressActionCardV2Selection> getNewLongPressActionCardPlaylet() {
        return this.newLongPressActionCardPlaylet;
    }

    public final String getToast() {
        return this.toast;
    }

    public final SaasLongPressActionType getType() {
        return this.type;
    }

    public final void setDislikeObjectType(SaasUgcActionObjectType saasUgcActionObjectType) {
        this.dislikeObjectType = saasUgcActionObjectType;
    }

    public final void setDislikeReportExtra(Map<String, String> map) {
        this.dislikeReportExtra = map;
    }

    public final void setLongPressActionCard(SaasLongPressActionCard saasLongPressActionCard) {
        this.longPressActionCard = saasLongPressActionCard;
    }

    public final void setLongPressActionCardV2Type(Integer num) {
        this.longPressActionCardV2Type = num;
    }

    public final void setNewLongPressActionCardPlaylet(List<SaasLongPressActionCardV2Selection> list) {
        this.newLongPressActionCardPlaylet = list;
    }

    public final void setToast(String str) {
        this.toast = str;
    }

    public final void setType(SaasLongPressActionType saasLongPressActionType) {
        this.type = saasLongPressActionType;
    }
}
