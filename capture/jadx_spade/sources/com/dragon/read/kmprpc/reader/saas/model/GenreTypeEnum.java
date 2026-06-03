package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = a2.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum GenreTypeEnum {
    NOVEL(0),
    AUDIOBOOK(1),
    AUDIO(2),
    COMIC_GENRE_TYPE(110),
    OTHER_GENRE_TYPE(120),
    VIDEO_GENRE_TYPE(130),
    MAGAZINE_GENRE_TYPE(150),
    PUBLISH_GENRE_TYPE(160),
    CONTE_GENRE_TYPE(170),
    STORY_GENRE_TYPE(180),
    DIALOGUE_GENRE_TYPE(190),
    DOUYIN_VIDEO(252),
    PRODUCT_GENRE_TYPE(256),
    NOVEL_STORY_GENRE_TYPE(280),
    CP_SHORT_PLAY_GENRE_TYPE(2130),
    MOTION_COMIC_GENRE_TYPE(2150),
    ANCIENTBOOK_GENRE_TYPE(2140),
    UNCOPYRIGHTED_PUBLISH_GENRE_TYPE(2660),
    STORY_ALBUM_GENRE_TYPE(9120);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610172);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GenreTypeEnum> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) GenreTypeEnum.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610171);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.GenreTypeEnum$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return a2.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    GenreTypeEnum(int i) {
        this.value = i;
    }
}
