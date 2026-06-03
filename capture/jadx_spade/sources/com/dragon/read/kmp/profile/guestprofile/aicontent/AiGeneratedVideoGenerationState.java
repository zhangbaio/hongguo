package com.dragon.read.kmp.profile.guestprofile.aicontent;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AiGeneratedVideoGenerationState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AiGeneratedVideoGenerationState[] $VALUES;
    public static final a Companion;
    public static final AiGeneratedVideoGenerationState FAILED_AND_RETRYABLE;
    public static final AiGeneratedVideoGenerationState FAILED_AND_UN_RETRYABLE;
    public static final AiGeneratedVideoGenerationState GENERATED;
    public static final AiGeneratedVideoGenerationState GENERATED_AND_PREVIEWABLE;
    public static final AiGeneratedVideoGenerationState GENERATING;
    private final int value;

    public static final class a {
        static {
            Covode.recordClassIndex(608113);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ AiGeneratedVideoGenerationState[] $values() {
        return new AiGeneratedVideoGenerationState[]{GENERATING, GENERATED, GENERATED_AND_PREVIEWABLE, FAILED_AND_RETRYABLE, FAILED_AND_UN_RETRYABLE};
    }

    public static EnumEntries<AiGeneratedVideoGenerationState> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static AiGeneratedVideoGenerationState[] values() {
        return (AiGeneratedVideoGenerationState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608112);
        GENERATING = new AiGeneratedVideoGenerationState("GENERATING", 0, 0);
        GENERATED = new AiGeneratedVideoGenerationState("GENERATED", 1, 1);
        GENERATED_AND_PREVIEWABLE = new AiGeneratedVideoGenerationState("GENERATED_AND_PREVIEWABLE", 2, 2);
        FAILED_AND_RETRYABLE = new AiGeneratedVideoGenerationState("FAILED_AND_RETRYABLE", 3, 3);
        FAILED_AND_UN_RETRYABLE = new AiGeneratedVideoGenerationState("FAILED_AND_UN_RETRYABLE", 4, 4);
        AiGeneratedVideoGenerationState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static AiGeneratedVideoGenerationState valueOf(String str) {
        return (AiGeneratedVideoGenerationState) Enum.valueOf(AiGeneratedVideoGenerationState.class, str);
    }

    private AiGeneratedVideoGenerationState(String str, int i, int i2) {
        this.value = i2;
    }
}
