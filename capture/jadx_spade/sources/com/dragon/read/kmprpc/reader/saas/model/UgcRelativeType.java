package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = y7.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcRelativeType {
    Book(1),
    Category(2),
    Post(3),
    Comment(4),
    Forum(5),
    Topic(6),
    MixedForum(0),
    BookshelfBooklist(7),
    TtsNovel(8),
    Reply(9),
    VideoPost(10),
    BookstoreVideoPost(11),
    Forward(12),
    ReqBookTopic(13),
    Story(14),
    Item(15),
    Tag(16),
    AuthorSpeak(17),
    Bonus(18),
    MagicForum(19),
    OriginalClassroomNotice(20),
    Template(21),
    OriginalTopic(22),
    User(100),
    Author(101),
    Task(23),
    IMRobot(24),
    RobotScript(25),
    Vote(26),
    Report(27),
    UserRobotRelation(28),
    UserScriptRelation(29),
    SeriesVideo(30),
    AIGC(31),
    Rank(32),
    Message(33),
    UniversalCard(34),
    PUGC(35),
    AIGCImage(36),
    AIGCVideo(37),
    AdvertiseCreative(38),
    FamousScene(39),
    AIGCCharacter(40),
    AIGCImageV2(41),
    Series(42),
    UgcFeature(43),
    UserDislikeRule(44);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611015);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UgcRelativeType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) UgcRelativeType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(611014);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.UgcRelativeType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return y7.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    UgcRelativeType(int i) {
        this.value = i;
    }
}
