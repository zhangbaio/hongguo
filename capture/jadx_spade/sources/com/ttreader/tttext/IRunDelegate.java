package com.ttreader.tttext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IRunDelegate {

    /* renamed from: com.ttreader.tttext.IRunDelegate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static float $default$GetAdvance(IRunDelegate iRunDelegate) {
            return 0.0f;
        }

        public static float $default$GetAscent(IRunDelegate iRunDelegate) {
            return 0.0f;
        }

        public static float $default$GetDescent(IRunDelegate iRunDelegate) {
            return 0.0f;
        }

        public static int $default$GetVerticalAlign(IRunDelegate iRunDelegate) {
            return 0;
        }

        public static boolean $default$Hide(IRunDelegate iRunDelegate) {
            return false;
        }

        public static boolean $default$Selectable(IRunDelegate iRunDelegate) {
            return false;
        }
    }

    float GetAdvance();

    float GetAscent();

    float GetDescent();

    int GetVerticalAlign();

    boolean Hide();

    boolean Selectable();
}
