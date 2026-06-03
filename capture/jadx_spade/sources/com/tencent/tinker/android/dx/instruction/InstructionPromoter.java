package com.tencent.tinker.android.dx.instruction;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;
import com.tencent.tinker.android.utils.SparseIntArray;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class InstructionPromoter extends InstructionVisitor {
    private final SparseIntArray addressMap;
    private int currentPromotedAddress;

    static {
        Covode.recordClassIndex(653635);
    }

    public int getPromotedAddressCount() {
        return this.addressMap.size();
    }

    public InstructionPromoter() {
        super(null);
        this.addressMap = new SparseIntArray();
        this.currentPromotedAddress = 0;
    }

    private void mapAddressIfNeeded(int i) {
        int i2 = this.currentPromotedAddress;
        if (i != i2) {
            this.addressMap.append(i, i2);
        }
    }

    public int getPromotedAddress(int i) {
        int indexOfKey = this.addressMap.indexOfKey(i);
        if (indexOfKey < 0) {
            return i;
        }
        return this.addressMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        mapAddressIfNeeded(i);
        int i4 = this.currentPromotedAddress + 4;
        this.currentPromotedAddress = i4;
        this.currentPromotedAddress = i4 + (iArr.length * 2);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        mapAddressIfNeeded(i);
        int i3 = this.currentPromotedAddress + 2;
        this.currentPromotedAddress = i3;
        int length = i3 + (iArr.length * 2);
        this.currentPromotedAddress = length;
        this.currentPromotedAddress = length + (iArr2.length * 2);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        mapAddressIfNeeded(i);
        int i5 = this.currentPromotedAddress + 4;
        this.currentPromotedAddress = i5;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 == 8) {
                        this.currentPromotedAddress = i5 + (((long[]) obj).length * 4);
                        return;
                    }
                    throw new DexException("bogus element_width: " + Hex.u2(i4));
                }
                this.currentPromotedAddress = i5 + (((int[]) obj).length * 2);
                return;
            }
            this.currentPromotedAddress = i5 + (((short[]) obj).length * 1);
            return;
        }
        int length = ((byte[]) obj).length;
        this.currentPromotedAddress = i5 + (length >> 1) + (length & 1);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        mapAddressIfNeeded(i);
        if (i2 != -1 && i2 != 0 && i2 != 14) {
            if (i2 != 36) {
                switch (i2) {
                    case 40:
                        int target = InstructionCodec.getTarget(i5, this.currentPromotedAddress);
                        if (target != ((byte) target)) {
                            if (target != ((short) target)) {
                                this.currentPromotedAddress += 3;
                                return;
                            } else {
                                this.currentPromotedAddress += 2;
                                return;
                            }
                        }
                        this.currentPromotedAddress++;
                        return;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                        int target2 = InstructionCodec.getTarget(i5, this.currentPromotedAddress);
                        if (target2 != ((short) target2)) {
                            this.currentPromotedAddress += 3;
                            return;
                        } else {
                            this.currentPromotedAddress += 2;
                            return;
                        }
                    case 42:
                        this.currentPromotedAddress += 3;
                        return;
                    default:
                        switch (i2) {
                            case 110:
                            case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                            case 112:
                            case 113:
                            case 114:
                                break;
                            default:
                                throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                        }
                }
            }
            this.currentPromotedAddress += 3;
            return;
        }
        this.currentPromotedAddress++;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        mapAddressIfNeeded(i);
        if (i2 != 34) {
            if (i2 != 36 && i2 != 38) {
                if (i2 != 39) {
                    if (i2 != 43 && i2 != 44) {
                        switch (i2) {
                            default:
                                switch (i2) {
                                    case 15:
                                    case 16:
                                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                    case 18:
                                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                    case 30:
                                        break;
                                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                    case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                    case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                    case 28:
                                    case 31:
                                        break;
                                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                    case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                        break;
                                    case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                        this.currentPromotedAddress += 5;
                                        return;
                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                        if (i3 > 65535) {
                                            this.currentPromotedAddress += 3;
                                            return;
                                        } else {
                                            this.currentPromotedAddress += 2;
                                            return;
                                        }
                                    case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                        this.currentPromotedAddress += 3;
                                        return;
                                    default:
                                        switch (i2) {
                                            default:
                                                switch (i2) {
                                                    case 96:
                                                    case 97:
                                                    case 98:
                                                    case 99:
                                                    case 100:
                                                    case 101:
                                                    case 102:
                                                    case 103:
                                                    case 104:
                                                    case 105:
                                                    case 106:
                                                    case 107:
                                                    case 108:
                                                    case 109:
                                                        break;
                                                    case 110:
                                                    case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                                    case 112:
                                                    case 113:
                                                    case 114:
                                                        break;
                                                    default:
                                                        throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                                                }
                                            case 56:
                                            case 57:
                                            case 58:
                                            case 59:
                                            case 60:
                                            case 61:
                                                this.currentPromotedAddress += 2;
                                        }
                                }
                            case 10:
                            case 11:
                            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                this.currentPromotedAddress++;
                                return;
                        }
                    }
                }
                this.currentPromotedAddress++;
                return;
            }
            this.currentPromotedAddress += 3;
            return;
        }
        this.currentPromotedAddress += 2;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        mapAddressIfNeeded(i);
        if (i2 != 37) {
            switch (i2) {
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
            }
        }
        this.currentPromotedAddress += 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[FALL_THROUGH] */
    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void visitTwoRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9) {
        /*
            r0 = this;
            r0.mapAddressIfNeeded(r1)
            r1 = 32
            if (r2 == r1) goto L55
            r1 = 33
            if (r2 == r1) goto L4e
            r1 = 35
            if (r2 == r1) goto L55
            r1 = 36
            if (r2 == r1) goto L47
            switch(r2) {
                case 1: goto L4e;
                case 2: goto L40;
                case 3: goto L47;
                case 4: goto L4e;
                case 5: goto L40;
                case 6: goto L47;
                case 7: goto L4e;
                case 8: goto L40;
                case 9: goto L47;
                default: goto L16;
            }
        L16:
            switch(r2) {
                case 50: goto L55;
                case 51: goto L55;
                case 52: goto L55;
                case 53: goto L55;
                case 54: goto L55;
                case 55: goto L55;
                default: goto L19;
            }
        L19:
            switch(r2) {
                case 82: goto L55;
                case 83: goto L55;
                case 84: goto L55;
                case 85: goto L55;
                case 86: goto L55;
                case 87: goto L55;
                case 88: goto L55;
                case 89: goto L55;
                case 90: goto L55;
                case 91: goto L55;
                case 92: goto L55;
                case 93: goto L55;
                case 94: goto L55;
                case 95: goto L55;
                default: goto L1c;
            }
        L1c:
            switch(r2) {
                case 110: goto L47;
                case 111: goto L47;
                case 112: goto L47;
                case 113: goto L47;
                case 114: goto L47;
                default: goto L1f;
            }
        L1f:
            switch(r2) {
                case 123: goto L4e;
                case 124: goto L4e;
                case 125: goto L4e;
                case 126: goto L4e;
                case 127: goto L4e;
                case 128: goto L4e;
                case 129: goto L4e;
                case 130: goto L4e;
                case 131: goto L4e;
                case 132: goto L4e;
                case 133: goto L4e;
                case 134: goto L4e;
                case 135: goto L4e;
                case 136: goto L4e;
                case 137: goto L4e;
                case 138: goto L4e;
                case 139: goto L4e;
                case 140: goto L4e;
                case 141: goto L4e;
                case 142: goto L4e;
                case 143: goto L4e;
                default: goto L22;
            }
        L22:
            switch(r2) {
                case 176: goto L4e;
                case 177: goto L4e;
                case 178: goto L4e;
                case 179: goto L4e;
                case 180: goto L4e;
                case 181: goto L4e;
                case 182: goto L4e;
                case 183: goto L4e;
                case 184: goto L4e;
                case 185: goto L4e;
                case 186: goto L4e;
                case 187: goto L4e;
                case 188: goto L4e;
                case 189: goto L4e;
                case 190: goto L4e;
                case 191: goto L4e;
                case 192: goto L4e;
                case 193: goto L4e;
                case 194: goto L4e;
                case 195: goto L4e;
                case 196: goto L4e;
                case 197: goto L4e;
                case 198: goto L4e;
                case 199: goto L4e;
                case 200: goto L4e;
                case 201: goto L4e;
                case 202: goto L4e;
                case 203: goto L4e;
                case 204: goto L4e;
                case 205: goto L4e;
                case 206: goto L4e;
                case 207: goto L4e;
                case 208: goto L55;
                case 209: goto L55;
                case 210: goto L55;
                case 211: goto L55;
                case 212: goto L55;
                case 213: goto L55;
                case 214: goto L55;
                case 215: goto L55;
                case 216: goto L55;
                case 217: goto L55;
                case 218: goto L55;
                case 219: goto L55;
                case 220: goto L55;
                case 221: goto L55;
                case 222: goto L55;
                case 223: goto L55;
                case 224: goto L55;
                case 225: goto L55;
                case 226: goto L55;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unexpected opcode: "
            r3.append(r4)
            java.lang.String r2 = com.tencent.tinker.android.dx.util.Hex.u2or4(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L40:
            int r1 = r0.currentPromotedAddress
            int r1 = r1 + 2
            r0.currentPromotedAddress = r1
            goto L5b
        L47:
            int r1 = r0.currentPromotedAddress
            int r1 = r1 + 3
            r0.currentPromotedAddress = r1
            goto L5b
        L4e:
            int r1 = r0.currentPromotedAddress
            int r1 = r1 + 1
            r0.currentPromotedAddress = r1
            goto L5b
        L55:
            int r1 = r0.currentPromotedAddress
            int r1 = r1 + 2
            r0.currentPromotedAddress = r1
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionPromoter.visitTwoRegisterInsn(int, int, int, int, int, long, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[FALL_THROUGH] */
    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void visitThreeRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9, int r10) {
        /*
            r0 = this;
            r0.mapAddressIfNeeded(r1)
            r1 = 36
            if (r2 == r1) goto L35
            switch(r2) {
                case 45: goto L2e;
                case 46: goto L2e;
                case 47: goto L2e;
                case 48: goto L2e;
                case 49: goto L2e;
                default: goto La;
            }
        La:
            switch(r2) {
                case 68: goto L2e;
                case 69: goto L2e;
                case 70: goto L2e;
                case 71: goto L2e;
                case 72: goto L2e;
                case 73: goto L2e;
                case 74: goto L2e;
                case 75: goto L2e;
                case 76: goto L2e;
                case 77: goto L2e;
                case 78: goto L2e;
                case 79: goto L2e;
                case 80: goto L2e;
                case 81: goto L2e;
                default: goto Ld;
            }
        Ld:
            switch(r2) {
                case 110: goto L35;
                case 111: goto L35;
                case 112: goto L35;
                case 113: goto L35;
                case 114: goto L35;
                default: goto L10;
            }
        L10:
            switch(r2) {
                case 144: goto L2e;
                case 145: goto L2e;
                case 146: goto L2e;
                case 147: goto L2e;
                case 148: goto L2e;
                case 149: goto L2e;
                case 150: goto L2e;
                case 151: goto L2e;
                case 152: goto L2e;
                case 153: goto L2e;
                case 154: goto L2e;
                case 155: goto L2e;
                case 156: goto L2e;
                case 157: goto L2e;
                case 158: goto L2e;
                case 159: goto L2e;
                case 160: goto L2e;
                case 161: goto L2e;
                case 162: goto L2e;
                case 163: goto L2e;
                case 164: goto L2e;
                case 165: goto L2e;
                case 166: goto L2e;
                case 167: goto L2e;
                case 168: goto L2e;
                case 169: goto L2e;
                case 170: goto L2e;
                case 171: goto L2e;
                case 172: goto L2e;
                case 173: goto L2e;
                case 174: goto L2e;
                case 175: goto L2e;
                default: goto L13;
            }
        L13:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unexpected opcode: "
            r3.append(r4)
            java.lang.String r2 = com.tencent.tinker.android.dx.util.Hex.u2or4(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L2e:
            int r1 = r0.currentPromotedAddress
            int r1 = r1 + 2
            r0.currentPromotedAddress = r1
            goto L3b
        L35:
            int r1 = r0.currentPromotedAddress
            int r1 = r1 + 3
            r0.currentPromotedAddress = r1
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionPromoter.visitThreeRegisterInsn(int, int, int, int, int, long, int, int, int):void");
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        mapAddressIfNeeded(i);
        if (i2 != 36) {
            switch (i2) {
                case 110:
                case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                case 112:
                case 113:
                case 114:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
            }
        }
        this.currentPromotedAddress += 3;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        mapAddressIfNeeded(i);
        if (i2 != 36) {
            switch (i2) {
                case 110:
                case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                case 112:
                case 113:
                case 114:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
            }
        }
        this.currentPromotedAddress += 3;
    }
}
