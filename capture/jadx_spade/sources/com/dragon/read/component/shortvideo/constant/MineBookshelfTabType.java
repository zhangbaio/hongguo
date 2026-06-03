package com.dragon.read.component.shortvideo.constant;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MineBookshelfTabType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MineBookshelfTabType[] $VALUES;
    public static final MineBookshelfTabType CelebrityWorks;
    public static final a Companion;
    public static final MineBookshelfTabType FollowUpdate;
    public static final MineBookshelfTabType FollowedVideo;
    public static final MineBookshelfTabType History;
    public static final MineBookshelfTabType Like;
    public static final MineBookshelfTabType ProduceVideo;
    public static final MineBookshelfTabType Published;
    public static final MineBookshelfTabType Reservation;
    public static final MineBookshelfTabType Select;
    private final int value;

    private static final /* synthetic */ MineBookshelfTabType[] $values() {
        return new MineBookshelfTabType[]{History, FollowedVideo, Like, Published, CelebrityWorks, ProduceVideo, Select, Reservation, FollowUpdate};
    }

    public static EnumEntries<MineBookshelfTabType> getEntries() {
        return $ENTRIES;
    }

    public static final String getModuleName(int i) {
        return Companion.a(i);
    }

    public static final String getModuleName(MineBookshelfTabType mineBookshelfTabType) {
        return Companion.b(mineBookshelfTabType);
    }

    public final int getValue() {
        return this.value;
    }

    public static MineBookshelfTabType[] values() {
        return (MineBookshelfTabType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599007);
        History = new MineBookshelfTabType("History", 0, 0);
        FollowedVideo = new MineBookshelfTabType("FollowedVideo", 1, 1);
        Like = new MineBookshelfTabType("Like", 2, 2);
        Published = new MineBookshelfTabType("Published", 3, 3);
        CelebrityWorks = new MineBookshelfTabType("CelebrityWorks", 4, 4);
        ProduceVideo = new MineBookshelfTabType("ProduceVideo", 5, 5);
        Select = new MineBookshelfTabType("Select", 6, 6);
        Reservation = new MineBookshelfTabType("Reservation", 7, 7);
        FollowUpdate = new MineBookshelfTabType("FollowUpdate", 8, 8);
        MineBookshelfTabType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static MineBookshelfTabType valueOf(String str) {
        return (MineBookshelfTabType) Enum.valueOf(MineBookshelfTabType.class, str);
    }

    public static final class a {

        /* renamed from: com.dragon.read.component.shortvideo.constant.MineBookshelfTabType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0016a {
            public static final /* synthetic */ int[] a;

            static {
                Covode.recordClassIndex(599009);
                int[] iArr = new int[MineBookshelfTabType.values().length];
                try {
                    iArr[MineBookshelfTabType.History.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MineBookshelfTabType.FollowedVideo.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MineBookshelfTabType.FollowUpdate.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MineBookshelfTabType.Like.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[MineBookshelfTabType.Published.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[MineBookshelfTabType.Reservation.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[MineBookshelfTabType.CelebrityWorks.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[MineBookshelfTabType.ProduceVideo.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[MineBookshelfTabType.Select.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                a = iArr;
            }
        }

        static {
            Covode.recordClassIndex(599008);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MineBookshelfTabType c(int i) {
            for (MineBookshelfTabType mineBookshelfTabType : MineBookshelfTabType.values()) {
                if (mineBookshelfTabType.getValue() == i) {
                    return mineBookshelfTabType;
                }
            }
            return null;
        }

        public final String a(int i) {
            if (i == MineBookshelfTabType.History.getValue()) {
                return "浏览历史";
            }
            if (i == MineBookshelfTabType.FollowedVideo.getValue()) {
                return "my_followed_video";
            }
            if (i == MineBookshelfTabType.FollowUpdate.getValue()) {
                return "follow_update";
            }
            if (i == MineBookshelfTabType.Like.getValue()) {
                return "我的点赞";
            }
            if (i == MineBookshelfTabType.Published.getValue()) {
                return "my_post";
            }
            if (i == MineBookshelfTabType.Select.getValue()) {
                return "profile_star_info";
            }
            if (i == MineBookshelfTabType.Reservation.getValue()) {
                return "预约";
            }
            return "";
        }

        public final String b(MineBookshelfTabType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            switch (C0016a.a[type.ordinal()]) {
                case 1:
                    return "浏览历史";
                case 2:
                    return "my_followed_video";
                case 3:
                    return "follow_update";
                case 4:
                    return "我的点赞";
                case 5:
                    return "my_post";
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return "预约";
                case 7:
                    return "starring";
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    return "playlet";
                case 9:
                    return "profile_star_info";
                default:
                    return "";
            }
        }
    }

    private MineBookshelfTabType(String str, int i, int i2) {
        this.value = i2;
    }
}
