package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Code extends TableOfContents.Section.Item<Code> {
    public CatchHandler[] catchHandlers;
    public int debugInfoOffset;
    public int insSize;
    public short[] instructions;
    public int outsSize;
    public int registersSize;
    public Try[] tries;

    static {
        Covode.recordClassIndex(653591);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.registersSize), Integer.valueOf(this.insSize), Integer.valueOf(this.outsSize), Integer.valueOf(this.debugInfoOffset), this.instructions, this.tries, this.catchHandlers);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        int signedLeb128Size;
        int length = this.instructions.length;
        int i = (length * 2) + 16;
        Try[] tryArr = this.tries;
        if (tryArr.length > 0) {
            if ((length & 1) == 1) {
                i += 2;
            }
            i = i + (tryArr.length * 8) + Leb128.unsignedLeb128Size(this.catchHandlers.length);
            for (CatchHandler catchHandler : this.catchHandlers) {
                int length2 = catchHandler.typeIndexes.length;
                if (catchHandler.catchAllAddress != -1) {
                    signedLeb128Size = Leb128.signedLeb128Size(-length2) + Leb128.unsignedLeb128Size(catchHandler.catchAllAddress);
                } else {
                    signedLeb128Size = Leb128.signedLeb128Size(length2);
                }
                i += signedLeb128Size;
                for (int i2 = 0; i2 < length2; i2++) {
                    i += Leb128.unsignedLeb128Size(catchHandler.typeIndexes[i2]) + Leb128.unsignedLeb128Size(catchHandler.addresses[i2]);
                }
            }
        }
        return i;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof Code) || compareTo((Code) obj) != 0) {
            return false;
        }
        return true;
    }

    public static class CatchHandler implements Comparable<CatchHandler> {
        public int[] addresses;
        public int catchAllAddress;
        public int offset;
        public int[] typeIndexes;

        static {
            Covode.recordClassIndex(653592);
        }

        @Override // java.lang.Comparable
        public int compareTo(CatchHandler catchHandler) {
            int sArrCompare = CompareUtils.sArrCompare(this.typeIndexes, catchHandler.typeIndexes);
            if (sArrCompare != 0) {
                return sArrCompare;
            }
            int sArrCompare2 = CompareUtils.sArrCompare(this.addresses, catchHandler.addresses);
            if (sArrCompare2 != 0) {
                return sArrCompare2;
            }
            return CompareUtils.sCompare(this.catchAllAddress, catchHandler.catchAllAddress);
        }

        public CatchHandler(int[] iArr, int[] iArr2, int i, int i2) {
            this.typeIndexes = iArr;
            this.addresses = iArr2;
            this.catchAllAddress = i;
            this.offset = i2;
        }
    }

    public static class Try implements Comparable<Try> {
        public int catchHandlerIndex;
        public int instructionCount;
        public int startAddress;

        static {
            Covode.recordClassIndex(653593);
        }

        @Override // java.lang.Comparable
        public int compareTo(Try r3) {
            int sCompare = CompareUtils.sCompare(this.startAddress, r3.startAddress);
            if (sCompare != 0) {
                return sCompare;
            }
            int sCompare2 = CompareUtils.sCompare(this.instructionCount, r3.instructionCount);
            if (sCompare2 != 0) {
                return sCompare2;
            }
            return CompareUtils.sCompare(this.catchHandlerIndex, r3.catchHandlerIndex);
        }

        public Try(int i, int i2, int i3) {
            this.startAddress = i;
            this.instructionCount = i2;
            this.catchHandlerIndex = i3;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Code code) {
        int sCompare = CompareUtils.sCompare(this.registersSize, code.registersSize);
        if (sCompare != 0) {
            return sCompare;
        }
        int sCompare2 = CompareUtils.sCompare(this.insSize, code.insSize);
        if (sCompare2 != 0) {
            return sCompare2;
        }
        int sCompare3 = CompareUtils.sCompare(this.outsSize, code.outsSize);
        if (sCompare3 != 0) {
            return sCompare3;
        }
        int sCompare4 = CompareUtils.sCompare(this.debugInfoOffset, code.debugInfoOffset);
        if (sCompare4 != 0) {
            return sCompare4;
        }
        int uArrCompare = CompareUtils.uArrCompare(this.instructions, code.instructions);
        if (uArrCompare != 0) {
            return uArrCompare;
        }
        int aArrCompare = CompareUtils.aArrCompare(this.tries, code.tries);
        if (aArrCompare != 0) {
            return aArrCompare;
        }
        return CompareUtils.aArrCompare(this.catchHandlers, code.catchHandlers);
    }

    public Code(int i, int i2, int i3, int i4, int i5, short[] sArr, Try[] tryArr, CatchHandler[] catchHandlerArr) {
        super(i);
        this.registersSize = i2;
        this.insSize = i3;
        this.outsSize = i4;
        this.debugInfoOffset = i5;
        this.instructions = sArr;
        this.tries = tryArr;
        this.catchHandlers = catchHandlerArr;
    }
}
