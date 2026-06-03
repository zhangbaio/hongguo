package com.tencent.tinker.android.dx.instruction;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.ITTVideoEngineInternal;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class InstructionWriter extends InstructionVisitor {
    private final ShortArrayCodeOutput codeOut;
    private final boolean hasPromoter;
    private final InstructionPromoter insnPromoter;

    static {
        Covode.recordClassIndex(653638);
    }

    public InstructionWriter(ShortArrayCodeOutput shortArrayCodeOutput, InstructionPromoter instructionPromoter) {
        super(null);
        boolean z;
        this.codeOut = shortArrayCodeOutput;
        this.insnPromoter = instructionPromoter;
        if (instructionPromoter != null) {
            z = true;
        } else {
            z = false;
        }
        this.hasPromoter = z;
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        int baseAddressForCursor = this.codeOut.baseAddressForCursor();
        this.codeOut.write((short) i2);
        this.codeOut.write(InstructionCodec.asUnsignedUnit(iArr.length));
        this.codeOut.writeInt(i3);
        int i4 = 0;
        if (this.hasPromoter) {
            int length = iArr.length;
            while (i4 < length) {
                this.codeOut.writeInt(this.insnPromoter.getPromotedAddress(iArr[i4]) - baseAddressForCursor);
                i4++;
            }
            return;
        }
        int length2 = iArr.length;
        while (i4 < length2) {
            this.codeOut.writeInt(iArr[i4] - baseAddressForCursor);
            i4++;
        }
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        int baseAddressForCursor = this.codeOut.baseAddressForCursor();
        this.codeOut.write((short) i2);
        this.codeOut.write(InstructionCodec.asUnsignedUnit(iArr2.length));
        int i3 = 0;
        for (int i4 : iArr) {
            this.codeOut.writeInt(i4);
        }
        if (this.hasPromoter) {
            int length = iArr2.length;
            while (i3 < length) {
                this.codeOut.writeInt(this.insnPromoter.getPromotedAddress(iArr2[i3]) - baseAddressForCursor);
                i3++;
            }
            return;
        }
        int length2 = iArr2.length;
        while (i3 < length2) {
            this.codeOut.writeInt(iArr2[i3] - baseAddressForCursor);
            i3++;
        }
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        this.codeOut.write((short) i2);
        this.codeOut.write((short) i4);
        this.codeOut.writeInt(i3);
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 == 8) {
                        this.codeOut.write((long[]) obj);
                        return;
                    }
                    throw new DexException("bogus element_width: " + Hex.u2(i4));
                }
                this.codeOut.write((int[]) obj);
                return;
            }
            this.codeOut.write((short[]) obj);
            return;
        }
        this.codeOut.write((byte[]) obj);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.hasPromoter) {
            i5 = this.insnPromoter.getPromotedAddress(i5);
        }
        if (i2 != -1 && i2 != 0 && i2 != 14) {
            if (i2 != 36) {
                switch (i2) {
                    case 40:
                        if (this.hasPromoter) {
                            int target = InstructionCodec.getTarget(i5, this.codeOut.cursor());
                            if (target != ((byte) target)) {
                                short s = (short) target;
                                if (target != s) {
                                    this.codeOut.write((short) 42, InstructionCodec.unit0(target), InstructionCodec.unit1(target));
                                    return;
                                } else {
                                    this.codeOut.write((short) 41, s);
                                    return;
                                }
                            }
                            this.codeOut.write(InstructionCodec.codeUnit(i2, target & 255));
                            return;
                        }
                        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.getTargetByte(i5, this.codeOut.cursor())));
                        return;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                        if (this.hasPromoter) {
                            int target2 = InstructionCodec.getTarget(i5, this.codeOut.cursor());
                            short s2 = (short) target2;
                            if (target2 != s2) {
                                this.codeOut.write((short) 42, InstructionCodec.unit0(target2), InstructionCodec.unit1(target2));
                                return;
                            } else {
                                this.codeOut.write((short) i2, s2);
                                return;
                            }
                        }
                        this.codeOut.write((short) i2, InstructionCodec.getTargetUnit(i5, this.codeOut.cursor()));
                        return;
                    case 42:
                        int target3 = InstructionCodec.getTarget(i5, this.codeOut.cursor());
                        this.codeOut.write((short) i2, InstructionCodec.unit0(target3), InstructionCodec.unit1(target3));
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
            this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 0)), (short) i3, InstructionCodec.codeUnit(0, 0, 0, 0));
            return;
        }
        this.codeOut.write((short) i2);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        char c;
        if (this.hasPromoter) {
            i5 = this.insnPromoter.getPromotedAddress(i5);
        }
        if (i2 != 34) {
            if (i2 != 36) {
                if (i2 != 38) {
                    if (i2 != 39) {
                        if (i2 != 43 && i2 != 44) {
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        case 15:
                                        case 16:
                                        case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                        case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                        case 30:
                                            break;
                                        case 18:
                                            this.codeOut.write(InstructionCodec.codeUnit((short) i2, InstructionCodec.makeByte(i6, InstructionCodec.getLiteralNibble(j))));
                                            return;
                                        case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                        case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.getLiteralUnit(j));
                                            return;
                                        case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                        case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                            int literalInt = InstructionCodec.getLiteralInt(j);
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(literalInt), InstructionCodec.unit1(literalInt));
                                            return;
                                        case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                        case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                            if (i2 == 21) {
                                                c = 16;
                                            } else {
                                                c = '0';
                                            }
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) (j >> c));
                                            return;
                                        case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(j), InstructionCodec.unit1(j), InstructionCodec.unit2(j), InstructionCodec.unit3(j));
                                            return;
                                        case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                            if (this.hasPromoter) {
                                                if (i3 > 65535) {
                                                    this.codeOut.write(InstructionCodec.codeUnit(27, i6), InstructionCodec.unit0(i3), InstructionCodec.unit1(i3));
                                                    return;
                                                } else {
                                                    this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) i3);
                                                    return;
                                                }
                                            }
                                            if (i3 <= 65535) {
                                                this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) i3);
                                                return;
                                            } else {
                                                throw new DexException("string index out of bound: " + Hex.u4(i3) + ", perhaps you need to enable force jumbo mode.");
                                            }
                                        case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(i3), InstructionCodec.unit1(i3));
                                            return;
                                        default:
                                            switch (i2) {
                                                case 56:
                                                case 57:
                                                case 58:
                                                case 59:
                                                case 60:
                                                case 61:
                                                    this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.getTargetUnit(i5, this.codeOut.cursor()));
                                                    return;
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
                                            }
                                        case 28:
                                        case 31:
                                            this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) i3);
                                    }
                                case 10:
                                case 11:
                                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                    this.codeOut.write(InstructionCodec.codeUnit(i2, i6));
                                    return;
                            }
                        }
                    }
                    this.codeOut.write(InstructionCodec.codeUnit(i2, i6));
                    return;
                }
                if (i2 == 43 || i2 == 44) {
                    ShortArrayCodeOutput shortArrayCodeOutput = this.codeOut;
                    shortArrayCodeOutput.setBaseAddress(i5, shortArrayCodeOutput.cursor());
                }
                int target = InstructionCodec.getTarget(i5, this.codeOut.cursor());
                this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.unit0(target), InstructionCodec.unit1(target));
                return;
            }
            this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 1)), (short) i3, InstructionCodec.codeUnit(i6, 0, 0, 0));
            return;
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, i6), (short) i3);
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
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
        this.codeOut.write(InstructionCodec.codeUnit(i2, i7), (short) i3, InstructionCodec.getAUnit(i6));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.hasPromoter) {
            i5 = this.insnPromoter.getPromotedAddress(i5);
        }
        if (i2 != 32) {
            if (i2 != 33) {
                if (i2 != 35) {
                    if (i2 != 36) {
                        switch (i2) {
                            case 1:
                            case 4:
                            case 7:
                                break;
                            case 2:
                            case 5:
                            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.getBUnit(i7));
                                return;
                            case 3:
                            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            case 9:
                                this.codeOut.write((short) i2, InstructionCodec.getAUnit(i6), InstructionCodec.getBUnit(i7));
                                return;
                            default:
                                switch (i2) {
                                    case 50:
                                    case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                                    case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                                    case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                                    case 54:
                                    case 55:
                                        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i6, i7)), InstructionCodec.getTargetUnit(i5, this.codeOut.cursor()));
                                        return;
                                    default:
                                        switch (i2) {
                                            case 82:
                                            case 83:
                                            case 84:
                                            case 85:
                                            case 86:
                                            case 87:
                                            case 88:
                                            case 89:
                                            case 90:
                                            case 91:
                                            case 92:
                                            case 93:
                                            case 94:
                                            case DataLoaderHelper.DATALOADER_KEY_INT_ENABLE_P2P_STRAGETY_CONTROL /* 95 */:
                                                break;
                                            default:
                                                switch (i2) {
                                                    case 110:
                                                    case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                                    case 112:
                                                    case 113:
                                                    case 114:
                                                        break;
                                                    default:
                                                        switch (i2) {
                                                            case 123:
                                                            case 124:
                                                            case 125:
                                                            case 126:
                                                            case 127:
                                                            case 128:
                                                            case 129:
                                                            case 130:
                                                            case 131:
                                                            case 132:
                                                            case 133:
                                                            case 134:
                                                            case 135:
                                                            case 136:
                                                            case 137:
                                                            case 138:
                                                            case 139:
                                                            case 140:
                                                            case 141:
                                                            case 142:
                                                            case 143:
                                                                break;
                                                            default:
                                                                switch (i2) {
                                                                    case 176:
                                                                    case 177:
                                                                    case 178:
                                                                    case 179:
                                                                    case 180:
                                                                    case 181:
                                                                    case 182:
                                                                    case 183:
                                                                    case 184:
                                                                    case 185:
                                                                    case 186:
                                                                    case 187:
                                                                    case 188:
                                                                    case 189:
                                                                    case 190:
                                                                    case 191:
                                                                    case 192:
                                                                    case 193:
                                                                    case 194:
                                                                    case 195:
                                                                    case 196:
                                                                    case 197:
                                                                    case 198:
                                                                    case 199:
                                                                    case 200:
                                                                    case 201:
                                                                    case 202:
                                                                    case 203:
                                                                    case 204:
                                                                    case 205:
                                                                    case 206:
                                                                    case 207:
                                                                        break;
                                                                    case 208:
                                                                    case 209:
                                                                    case TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES /* 210 */:
                                                                    case TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA /* 211 */:
                                                                    case TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH /* 212 */:
                                                                    case 213:
                                                                    case 214:
                                                                    case 215:
                                                                        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i6, i7)), InstructionCodec.getLiteralUnit(j));
                                                                        return;
                                                                    case 216:
                                                                    case 217:
                                                                    case 218:
                                                                    case 219:
                                                                    case 220:
                                                                    case 221:
                                                                    case 222:
                                                                    case 223:
                                                                    case 224:
                                                                    case 225:
                                                                    case 226:
                                                                        this.codeOut.write(InstructionCodec.codeUnit(i2, i6), InstructionCodec.codeUnit(i7, InstructionCodec.getLiteralByte(j)));
                                                                        return;
                                                                    default:
                                                                        throw new IllegalStateException("unexpected opcode: " + Hex.u2or4(i2));
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    }
                    this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 2)), (short) i3, InstructionCodec.codeUnit(i6, i7, 0, 0));
                    return;
                }
            }
            this.codeOut.write(InstructionCodec.codeUnit((short) i2, InstructionCodec.makeByte(i6, i7)));
            return;
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i6, i7)), (short) i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[FALL_THROUGH] */
    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void visitThreeRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9, int r10) {
        /*
            r0 = this;
            r1 = 36
            if (r2 == r1) goto L39
            switch(r2) {
                case 45: goto L2b;
                case 46: goto L2b;
                case 47: goto L2b;
                case 48: goto L2b;
                case 49: goto L2b;
                default: goto L7;
            }
        L7:
            switch(r2) {
                case 68: goto L2b;
                case 69: goto L2b;
                case 70: goto L2b;
                case 71: goto L2b;
                case 72: goto L2b;
                case 73: goto L2b;
                case 74: goto L2b;
                case 75: goto L2b;
                case 76: goto L2b;
                case 77: goto L2b;
                case 78: goto L2b;
                case 79: goto L2b;
                case 80: goto L2b;
                case 81: goto L2b;
                default: goto La;
            }
        La:
            switch(r2) {
                case 110: goto L39;
                case 111: goto L39;
                case 112: goto L39;
                case 113: goto L39;
                case 114: goto L39;
                default: goto Ld;
            }
        Ld:
            switch(r2) {
                case 144: goto L2b;
                case 145: goto L2b;
                case 146: goto L2b;
                case 147: goto L2b;
                case 148: goto L2b;
                case 149: goto L2b;
                case 150: goto L2b;
                case 151: goto L2b;
                case 152: goto L2b;
                case 153: goto L2b;
                case 154: goto L2b;
                case 155: goto L2b;
                case 156: goto L2b;
                case 157: goto L2b;
                case 158: goto L2b;
                case 159: goto L2b;
                case 160: goto L2b;
                case 161: goto L2b;
                case 162: goto L2b;
                case 163: goto L2b;
                case 164: goto L2b;
                case 165: goto L2b;
                case 166: goto L2b;
                case 167: goto L2b;
                case 168: goto L2b;
                case 169: goto L2b;
                case 170: goto L2b;
                case 171: goto L2b;
                case 172: goto L2b;
                case 173: goto L2b;
                case 174: goto L2b;
                case 175: goto L2b;
                default: goto L10;
            }
        L10:
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
        L2b:
            com.tencent.tinker.android.dx.instruction.ShortArrayCodeOutput r1 = r0.codeOut
            short r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r8)
            short r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r9, r10)
            r1.write(r2, r3)
            goto L4d
        L39:
            short r1 = (short) r3
            com.tencent.tinker.android.dx.instruction.ShortArrayCodeOutput r3 = r0.codeOut
            r4 = 3
            r5 = 0
            int r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r5, r4)
            short r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r4)
            short r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r9, r10, r5)
            r3.write(r2, r1, r4)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionWriter.visitThreeRegisterInsn(int, int, int, int, int, long, int, int, int):void");
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
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
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 4)), (short) i3, InstructionCodec.codeUnit(i6, i7, i8, i9));
    }

    @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
    public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
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
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i10, 5)), (short) i3, InstructionCodec.codeUnit(i6, i7, i8, i9));
    }
}
