package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = f0.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookstoreTabType {
    female(0),
    male(1),
    recommend(2),
    new_book(3),
    video(4),
    audio(5),
    publication(6),
    knowledge(7),
    video_episode(8),
    comic(9),
    young(10),
    classic(11),
    knowledge2(12),
    story(13),
    long_video(14),
    ecom_book(15),
    video_feed(16),
    tele_play(17),
    recent(18),
    supervise_video(19),
    danhua_ios_recommend(20),
    video_series_post(21),
    pugc_video_feed(22),
    ranklist(23),
    dynamic_comic(24),
    novel(25),
    ranklist_landpage(26),
    category(27),
    video_subscribe(28),
    video_topic_landpage(29),
    follow(30),
    latest_published_book(31),
    comic_series(32),
    community(33),
    new_series_recommend(34),
    double_col_enter_single_tab(35),
    motion_comic_feed(36),
    topic(101),
    feed(102),
    ugc_story(103),
    chunjie(104);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609853);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BookstoreTabType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) BookstoreTabType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609852);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.BookstoreTabType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return f0.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    BookstoreTabType(int i) {
        this.value = i;
    }
}
