package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = i8.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserEventReportType {
    ChapterUnblock(1),
    ToneGuide(2),
    ChaseBook(3),
    BookFeedDislike(4),
    TopicDislike(5),
    AddWidgets(6),
    InterestExplore(7),
    ReaderToastGuide(8),
    ChaseBookDislike(9),
    BookRecommendComic(10),
    LeaveFromTab(11),
    BrowseChapterUnlocked(12),
    ActionDislike(13),
    RecommendComicDislike(14),
    BookExcerpt(15),
    ShowModel(16),
    ExtraChapterBannerShow(17),
    VIPAction(18),
    BookEndBannerShow(19),
    UserResearch(20),
    SubscribedPublishBannerShow(21),
    CloseVideoRelatedBookCard(22),
    SnackBar(24),
    SwitchTone(25),
    ShareCount(26),
    ClickFastFeedbackItem(27),
    PublishVipActivity(28),
    SubscribeOnlineShow(29),
    IMCResource(30),
    PublishLotteryReadTime(31),
    HistoryBanner(32),
    SyncToutiaoPUGC(33),
    BookCommentInviteShow(34),
    BrandEntryVerify(35),
    ChunjieBanner(36),
    AuthorPageDislike(37);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611102);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UserEventReportType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) UserEventReportType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(611101);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.UserEventReportType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return i8.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    UserEventReportType(int i) {
        this.value = i;
    }
}
