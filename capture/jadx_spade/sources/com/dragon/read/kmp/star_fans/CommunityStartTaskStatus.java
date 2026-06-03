package com.dragon.read.kmp.star_fans;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.i0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CommunityStartTaskStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CommunityStartTaskStatus[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final CommunityStartTaskStatus ACTION_COMPLETED;
    public static final CommunityStartTaskStatus CLAIMED_UNFINISHED;
    public static final a Companion;
    public static final CommunityStartTaskStatus REQUEST_SUCCEEDED;

    private static final /* synthetic */ CommunityStartTaskStatus[] $values() {
        return new CommunityStartTaskStatus[]{CLAIMED_UNFINISHED, ACTION_COMPLETED, REQUEST_SUCCEEDED};
    }

    public static EnumEntries<CommunityStartTaskStatus> getEntries() {
        return $ENTRIES;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609150);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CommunityStartTaskStatus> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) CommunityStartTaskStatus.$cachedSerializer$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return i0.b("com.dragon.read.kmp.star_fans.CommunityStartTaskStatus", values());
    }

    public static CommunityStartTaskStatus[] values() {
        return (CommunityStartTaskStatus[]) $VALUES.clone();
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609149);
        CLAIMED_UNFINISHED = new CommunityStartTaskStatus("CLAIMED_UNFINISHED", 0);
        ACTION_COMPLETED = new CommunityStartTaskStatus("ACTION_COMPLETED", 1);
        REQUEST_SUCCEEDED = new CommunityStartTaskStatus("REQUEST_SUCCEEDED", 2);
        CommunityStartTaskStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.dragon.read.kmp.star_fans.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = CommunityStartTaskStatus._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    public static CommunityStartTaskStatus valueOf(String str) {
        return (CommunityStartTaskStatus) Enum.valueOf(CommunityStartTaskStatus.class, str);
    }

    private CommunityStartTaskStatus(String str, int i) {
    }
}
