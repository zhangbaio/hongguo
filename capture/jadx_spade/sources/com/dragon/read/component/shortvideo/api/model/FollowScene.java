package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FollowScene {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FollowScene[] $VALUES;
    public static final FollowScene ACTOR_RELATED_SERIES_PANEL;
    public static final FollowScene ALBUM_MENU_PAGE;
    public static final FollowScene ALBUM_MENU_PAGE_BOTTOM;
    public static final FollowScene ALBUM_PAGE;
    public static final FollowScene BOOKSHELF_MORE_DETAIL;
    public static final FollowScene BRAND_RELATED_SERIES_PANEL;
    public static final FollowScene COLD_START;
    public static final a Companion;
    public static final FollowScene DRAMA_TAB;
    public static final FollowScene EXIT_SERIES;
    public static final FollowScene LOGIN;
    public static final FollowScene MOVIE_TAB;
    public static final FollowScene PLAYER_BUTTON;
    public static final FollowScene READER_CHAPTER_AUTO;
    public static final FollowScene SERIES_MORE;
    public static final FollowScene TAB_INFINITE_AUTO;
    public static final FollowScene UNKNOWN;
    public static final FollowScene VIDEO_EDIT_BOTTOM;
    public static final FollowScene VIDEO_HISTORY;
    public static final FollowScene VIDEO_PAGE;
    public static final FollowScene VIDEO_PAGE_RELATIVE_SERIES_ITEM;
    public static final FollowScene VIDEO_PLAYER;
    public static final FollowScene VIDEO_PLAYER_POPUP;
    public static final FollowScene VIDEO_RELATION_SERIES_PANEL;
    public static final FollowScene VIDEO_TAB;

    private static final /* synthetic */ FollowScene[] $values() {
        return new FollowScene[]{UNKNOWN, VIDEO_PLAYER, SERIES_MORE, VIDEO_PAGE, VIDEO_PAGE_RELATIVE_SERIES_ITEM, TAB_INFINITE_AUTO, EXIT_SERIES, PLAYER_BUTTON, VIDEO_EDIT_BOTTOM, VIDEO_HISTORY, VIDEO_PLAYER_POPUP, VIDEO_TAB, MOVIE_TAB, DRAMA_TAB, BOOKSHELF_MORE_DETAIL, LOGIN, COLD_START, READER_CHAPTER_AUTO, VIDEO_RELATION_SERIES_PANEL, ACTOR_RELATED_SERIES_PANEL, BRAND_RELATED_SERIES_PANEL, ALBUM_MENU_PAGE, ALBUM_MENU_PAGE_BOTTOM, ALBUM_PAGE};
    }

    public static EnumEntries<FollowScene> getEntries() {
        return $ENTRIES;
    }

    public static FollowScene[] values() {
        return (FollowScene[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598766);
        UNKNOWN = new FollowScene("UNKNOWN", 0);
        VIDEO_PLAYER = new FollowScene("VIDEO_PLAYER", 1);
        SERIES_MORE = new FollowScene("SERIES_MORE", 2);
        VIDEO_PAGE = new FollowScene("VIDEO_PAGE", 3);
        VIDEO_PAGE_RELATIVE_SERIES_ITEM = new FollowScene("VIDEO_PAGE_RELATIVE_SERIES_ITEM", 4);
        TAB_INFINITE_AUTO = new FollowScene("TAB_INFINITE_AUTO", 5);
        EXIT_SERIES = new FollowScene("EXIT_SERIES", 6);
        PLAYER_BUTTON = new FollowScene("PLAYER_BUTTON", 7);
        VIDEO_EDIT_BOTTOM = new FollowScene("VIDEO_EDIT_BOTTOM", 8);
        VIDEO_HISTORY = new FollowScene("VIDEO_HISTORY", 9);
        VIDEO_PLAYER_POPUP = new FollowScene("VIDEO_PLAYER_POPUP", 10);
        VIDEO_TAB = new FollowScene("VIDEO_TAB", 11);
        MOVIE_TAB = new FollowScene("MOVIE_TAB", 12);
        DRAMA_TAB = new FollowScene("DRAMA_TAB", 13);
        BOOKSHELF_MORE_DETAIL = new FollowScene("BOOKSHELF_MORE_DETAIL", 14);
        LOGIN = new FollowScene("LOGIN", 15);
        COLD_START = new FollowScene("COLD_START", 16);
        READER_CHAPTER_AUTO = new FollowScene("READER_CHAPTER_AUTO", 17);
        VIDEO_RELATION_SERIES_PANEL = new FollowScene("VIDEO_RELATION_SERIES_PANEL", 18);
        ACTOR_RELATED_SERIES_PANEL = new FollowScene("ACTOR_RELATED_SERIES_PANEL", 19);
        BRAND_RELATED_SERIES_PANEL = new FollowScene("BRAND_RELATED_SERIES_PANEL", 20);
        ALBUM_MENU_PAGE = new FollowScene("ALBUM_MENU_PAGE", 21);
        ALBUM_MENU_PAGE_BOTTOM = new FollowScene("ALBUM_MENU_PAGE_BOTTOM", 22);
        ALBUM_PAGE = new FollowScene("ALBUM_PAGE", 23);
        FollowScene[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static FollowScene valueOf(String str) {
        return (FollowScene) Enum.valueOf(FollowScene.class, str);
    }

    public static final class a {

        /* renamed from: com.dragon.read.component.shortvideo.api.model.FollowScene$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0014a {
            public static final /* synthetic */ int[] a;

            static {
                Covode.recordClassIndex(598768);
                int[] iArr = new int[FollowScene.values().length];
                try {
                    iArr[FollowScene.VIDEO_PLAYER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FollowScene.SERIES_MORE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FollowScene.VIDEO_PAGE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FollowScene.DRAMA_TAB.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FollowScene.PLAYER_BUTTON.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[FollowScene.VIDEO_PAGE_RELATIVE_SERIES_ITEM.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                a = iArr;
            }
        }

        static {
            Covode.recordClassIndex(598767);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean c(FollowScene followScene) {
            Intrinsics.checkNotNullParameter(followScene, "followScene");
            if (followScene != FollowScene.ALBUM_PAGE && followScene != FollowScene.ALBUM_MENU_PAGE) {
                return false;
            }
            return true;
        }

        public final FollowScene a(String value) {
            Object m773constructorimpl;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                Result.Companion companion = Result.Companion;
                String upperCase = value.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                m773constructorimpl = Result.m773constructorimpl(FollowScene.valueOf(upperCase));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m779isFailureimpl(m773constructorimpl)) {
                m773constructorimpl = null;
            }
            FollowScene followScene = (FollowScene) m773constructorimpl;
            if (followScene == null) {
                return FollowScene.UNKNOWN;
            }
            return followScene;
        }

        public final String b(FollowScene followScene) {
            int i;
            if (followScene == null) {
                i = -1;
            } else {
                i = C0014a.a[followScene.ordinal()];
            }
            switch (i) {
                case 1:
                    return "video_player";
                case 2:
                    return "series_more";
                case 3:
                    return "video_page";
                case 4:
                    return "drama_cover";
                case 5:
                    return "play_button";
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return "detail_page_similar_video";
                default:
                    return null;
            }
        }
    }

    public final String getValue(FollowScene followScene) {
        Intrinsics.checkNotNullParameter(followScene, "<this>");
        String lowerCase = followScene.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private FollowScene(String str, int i) {
    }
}
