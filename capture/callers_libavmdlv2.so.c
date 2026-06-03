// target 0x50424c callers found
// target 0x501da0 callers found

// ===== FUN_005304ac @ 005304ac size=504 =====

undefined4 FUN_005304ac(long param_1,undefined8 param_2,undefined8 param_3,undefined4 param_4)

{
  long *plVar1;
  uint uVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  undefined1 uVar6;
  ulong uVar7;
  undefined1 uVar8;
  code *pcVar9;
  long lVar10;
  undefined4 uVar11;
  undefined2 local_104 [2];
  undefined1 auStack_100 [8];
  long *local_f8;
  undefined1 auStack_f0 [32];
  undefined1 local_d0 [4];
  undefined1 local_cc;
  undefined2 local_cb;
  undefined1 local_c9;
  undefined1 local_c8;
  undefined4 local_c4;
  undefined1 auStack_c0 [48];
  long alStack_90 [4];
  long *local_70;
  undefined1 auStack_58 [20];
  undefined4 local_44;
  undefined2 local_40;
  long local_38;
  
  lVar5 = tpidr_el0;
  local_38 = *(long *)(lVar5 + 0x28);
  uVar2 = *(uint *)(param_1 + 0xc);
  uVar6 = 0;
  uVar8 = 0;
  if (uVar2 == 0xffffffff) {
    uVar2 = 1;
  }
  local_cc = (undefined1)uVar2;
  local_d0[0] = 0x12;
  local_cb = 0;
  local_c9 = 3;
  if ((uVar2 & 0xff) == 3) {
    FUN_0041fffc();
    uVar6 = FUN_0042027c();
    uVar8 = 4;
  }
  local_cb = CONCAT11(uVar8,uVar6);
  local_c8 = 0x62;
  local_c4 = param_4;
  FUN_004209e4(auStack_58);
  local_40 = 0;
  local_44 = 1;
  FUN_00420cb4(auStack_58,param_1 + 0x1c);
  local_40 = 0;
  FUN_0048d48c(auStack_100);
  FUN_00489490(auStack_f0,0x5c0,auStack_100);
  if (local_f8 != (long *)0x0) {
    plVar1 = local_f8 + 1;
    do {
      lVar10 = *plVar1;
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(plVar1,0x10);
      if (bVar4) {
        *plVar1 = lVar10 + -1;
        cVar3 = ExclusiveMonitorsStatus();
      }
                    /* try { // try from 00530580 to 0063065b has its CatchHandler @ 00530580
                       catch(type#1 @ 00000000) { ... } // from try @ 00530580 with catch @ 00530580
                       catch(type#1 @ 00000000) { ... } // from try @ 00530660 with catch @ 00530580
                       catch(type#1 @ 00000000) { ... } // from try @ 005306bc with catch @ 00530580
                       catch(type#1 @ 00000000) { ... } // from try @ 00530704 with catch @ 00530580
                        */
    } while (cVar3 != '\0');
    if (lVar10 == 0) {
      (**(code **)(*local_f8 + 0x10))(local_f8);
      std::__ndk1::__shared_weak_count::__release_weak();
    }
  }
  FUN_00501f6c(auStack_c0,auStack_f0);
  FUN_004c18a4(auStack_c0,local_d0);
  FUN_0052a57c(auStack_c0,auStack_58);
  uVar7 = FUN_00502968(auStack_c0);
  if ((uVar7 & 1) == 0) {
    uVar11 = 0;
    goto LAB_00530668;
  }
  local_104[0] = FUN_00502980(auStack_c0);
  FUN_00502970(auStack_c0);
  FUN_00502104(auStack_c0,2);
  FUN_00502624(auStack_c0,local_104);
  FUN_00489b74(auStack_f0,0,local_104[0]);
  local_70 = (long *)0x0;
  FUN_0050424c(*(undefined8 *)(param_1 + 400),auStack_f0,(ulong)local_d0 | 4,param_3,alStack_90);
  if (alStack_90 == local_70) {
                    /* try { // try from 0053065c to 0063065f has its CatchHandler @ 005306f8 */
    pcVar9 = *(code **)(*local_70 + 0x20);
LAB_00530660:
                    /* try { // try from 00530660 to 0063069b has its CatchHandler @ 00530580 */
    (*pcVar9)();
  }
  else if (local_70 != (long *)0x0) {
    pcVar9 = *(code **)(*local_70 + 0x28);
    goto LAB_00530660;
  }
  uVar11 = 1;
LAB_00530668:
  thunk_FUN_0048996c(auStack_c0);
  FUN_0048996c(auStack_f0);
  if (*(long *)(lVar5 + 0x28) == local_38) {
                    /* try { // try from 0053069c to 006306a7 has its CatchHandler @ 005306ec */
    return uVar11;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_0052fa88 @ 0052fa88 size=160 =====

void FUN_0052fa88(char *param_1,undefined8 param_2,undefined8 param_3)

{
  long lVar1;
  undefined8 uVar2;
  code *pcVar3;
  long alStack_60 [4];
  long *local_40;
  long local_28;
  
                    /* catch() { ... } // from try @ 0052fa28 with catch @ 0052fa90 */
  lVar1 = tpidr_el0;
  local_28 = *(long *)(lVar1 + 0x28);
  if ((*param_1 == '\0') || (*(int *)(param_1 + 4) != 4)) {
    uVar2 = 0xffffffff;
    goto LAB_0052fb04;
  }
  local_40 = (long *)0x0;
  FUN_0050424c(*(undefined8 *)(param_1 + 400),param_2,param_3,param_1 + 0x238,alStack_60);
                    /* try { // try from 0052fad4 to 0062fb8f has its CatchHandler @ 0052fad4
                       catch(type#1 @ 00000000) { ... } // from try @ 0052fad4 with catch @ 0052fad4
                       catch(type#1 @ 00000000) { ... } // from try @ 0052fba8 with catch @ 0052fad4
                       catch(type#1 @ 00000000) { ... } // from try @ 0052fc4c with catch @ 0052fad4
                       catch(type#1 @ 00000000) { ... } // from try @ 0052fcec with catch @ 0052fad4
                        */
  if (alStack_60 == local_40) {
    pcVar3 = *(code **)(*local_40 + 0x20);
LAB_0052fafc:
    (*pcVar3)();
  }
  else if (local_40 != (long *)0x0) {
    pcVar3 = *(code **)(*local_40 + 0x28);
    goto LAB_0052fafc;
  }
  uVar2 = 0;
LAB_0052fb04:
  if (*(long *)(lVar1 + 0x28) == local_28) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail(uVar2);
}



// ===== FUN_005309dc @ 005309dc size=660 =====

undefined4 FUN_005309dc(long param_1,undefined8 param_2,short *param_3)

{
  long *plVar1;
  uint uVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  undefined1 uVar6;
  ulong uVar7;
  undefined1 uVar8;
  code *pcVar9;
  long lVar10;
  undefined4 uVar11;
  undefined2 local_104 [2];
  undefined1 auStack_100 [8];
  long *local_f8;
  undefined1 auStack_f0 [32];
  undefined1 local_d0 [4];
  undefined1 local_cc;
  undefined2 local_cb;
  undefined1 local_c9;
  undefined1 local_c8;
  undefined4 local_c4;
  undefined1 auStack_c0 [48];
  long alStack_90 [4];
  long *local_70;
  undefined1 auStack_58 [20];
  undefined4 local_44;
  undefined1 local_40;
  long local_38;
  
                    /* catch() { ... } // from try @ 005308a8 with catch @ 005309e0 */
  lVar5 = tpidr_el0;
  local_38 = *(long *)(lVar5 + 0x28);
  uVar6 = 0;
                    /* catch() { ... } // from try @ 005307f8 with catch @ 00530a00 */
  uVar2 = *(uint *)(param_1 + 0xc);
  uVar8 = 0;
  local_d0[0] = 0x12;
  if (uVar2 == 0xffffffff) {
    uVar2 = 1;
  }
  local_cc = (undefined1)uVar2;
  local_cb = 0;
  local_c9 = 3;
  if ((uVar2 & 0xff) == 3) {
    FUN_0041fffc();
    uVar6 = FUN_0042027c();
    uVar8 = 4;
  }
  local_cb = CONCAT11(uVar8,uVar6);
  local_c8 = 0xa0;
  local_c4 = FUN_0050437c(*(undefined8 *)(param_1 + 400));
                    /* try { // try from 00530a5c to 00630b1f has its CatchHandler @ 00530a5c
                       catch(type#1 @ 00000000) { ... } // from try @ 00530a5c with catch @ 00530a5c
                        */
  FUN_004209e4(auStack_58);
  local_44 = 0;
  local_40 = 0;
  FUN_00420cb4(auStack_58,param_1 + 0x1c);
  local_44 = 1;
  local_40 = 0;
  FUN_0048d48c(auStack_100);
  FUN_00489490(auStack_f0,0x5c0,auStack_100);
  if (local_f8 != (long *)0x0) {
    plVar1 = local_f8 + 1;
    do {
      lVar10 = *plVar1;
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(plVar1,0x10);
      if (bVar4) {
        *plVar1 = lVar10 + -1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
    if (lVar10 == 0) {
      (**(code **)(*local_f8 + 0x10))(local_f8);
      std::__ndk1::__shared_weak_count::__release_weak();
    }
  }
  FUN_00501f6c(auStack_c0,auStack_f0);
  FUN_004c18a4(auStack_c0,local_d0);
  FUN_0052a538(auStack_c0,auStack_58);
  uVar7 = FUN_00502968(auStack_c0);
  if ((uVar7 & 1) != 0) {
    local_104[0] = FUN_00502980(auStack_c0);
    FUN_00502970(auStack_c0);
                    /* try { // try from 00530b20 to 00630b27 has its CatchHandler @ 00530b44 */
    FUN_00502104(auStack_c0,2);
    FUN_00502624(auStack_c0,local_104);
                    /* try { // try from 00530b38 to 00630b3f has its CatchHandler @ 00530b40 */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00530b38 with catch @ 00530b40
                        */
    FUN_00489b74(auStack_f0,0,local_104[0]);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00530b20 with catch @ 00530b44
                        */
    if (*param_3 == 2) {
      if (*(int *)(param_3 + 2) != 0) {
LAB_00530be0:
        local_70 = (long *)0x0;
        FUN_0050424c(*(undefined8 *)(param_1 + 400),auStack_f0,(ulong)local_d0 | 4,param_1 + 0x270,
                     alStack_90);
        if (alStack_90 == local_70) {
          pcVar9 = *(code **)(*local_70 + 0x20);
LAB_00530c2c:
          (*pcVar9)();
        }
        else if (local_70 != (long *)0x0) {
          pcVar9 = *(code **)(*local_70 + 0x28);
          goto LAB_00530c2c;
        }
        uVar11 = 1;
        goto LAB_00530c34;
      }
    }
    else if (((((((((((((((*(char *)((long)param_3 + 9) != '\0' || (char)param_3[4] != '\0') ||
                         (char)param_3[5] != '\0') || *(char *)((long)param_3 + 0xb) != '\0') ||
                       (char)param_3[6] != '\0') || *(char *)((long)param_3 + 0xd) != '\0') ||
                     (char)param_3[7] != '\0') || *(char *)((long)param_3 + 0xf) != '\0') ||
                   (char)param_3[8] != '\0') || *(char *)((long)param_3 + 0x11) != '\0') ||
                 (char)param_3[9] != '\0') || *(char *)((long)param_3 + 0x13) != '\0') ||
               (char)param_3[10] != '\0') || *(char *)((long)param_3 + 0x15) != '\0') ||
             (char)param_3[0xb] != '\0') || *(char *)((long)param_3 + 0x17) != '\0')
    goto LAB_00530be0;
  }
  uVar11 = 0;
LAB_00530c34:
  thunk_FUN_0048996c(auStack_c0);
  FUN_0048996c(auStack_f0);
  if (*(long *)(lVar5 + 0x28) == local_38) {
    return uVar11;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_0050424c @ 0050424c size=248 =====

undefined8
FUN_0050424c(long param_1,undefined8 param_2,char *param_3,undefined8 param_4,undefined8 param_5)

{
  char cVar1;
  int iVar2;
  ulong uVar3;
  uint uVar4;
  long lVar5;
  undefined8 uVar6;
  
  if (*(char *)(param_1 + 0x10) != '\0') {
    uVar4 = 4;
    if (*param_3 == '\x03') {
      uVar4 = 5;
    }
    iVar2 = FUN_00489a48(param_2);
    if (((int)uVar4 <= iVar2) && (lVar5 = *(long *)(param_1 + 0xd8), lVar5 != 0)) {
      cVar1 = *param_3;
      iVar2 = FUN_00489a48(param_2);
      FUN_00501da0(lVar5,cVar1,param_2,iVar2 - uVar4);
      uVar6 = *(undefined8 *)(param_1 + 0xd8);
      lVar5 = FUN_00489a14(param_2);
      iVar2 = FUN_00489a48(param_2);
      uVar3 = FUN_00501b8c(uVar6,param_3,lVar5 + (ulong)uVar4,iVar2 - uVar4);
      if (((uVar3 & 1) != 0) &&
         (uVar3 = FUN_00503dfc(param_1,param_2,param_4,param_5), (uVar3 & 1) != 0)) {
        uVar3 = FUN_00489a48(param_2);
        *(ulong *)(param_1 + 0xe8) = *(long *)(param_1 + 0xe8) + (uVar3 & 0xffffffff);
        return 1;
      }
    }
  }
  return 0;
}



// ===== FUN_004e1858 @ 004e1858 size=320 =====

void FUN_004e1858(long param_1,undefined8 param_2,char param_3,undefined8 param_4,uint param_5)

{
  long lVar1;
  long lVar2;
  long lVar3;
  long lVar4;
  undefined8 uVar5;
  code *pcVar6;
  long *plVar7;
  ulong uVar8;
  ulong uVar9;
  long alStack_60 [4];
  long *local_40;
  long local_28;
  
  lVar4 = tpidr_el0;
  local_28 = *(long *)(lVar4 + 0x28);
                    /* catch() { ... } // from try @ 004e1594 with catch @ 004e1874 */
  if (*(char *)(param_1 + 0x18) != '\0') {
    if (1 < param_5 - 1) {
      if (param_5 != 0) goto LAB_004e195c;
      param_5 = *(byte *)(param_1 + 0x30) & 2;
                    /* catch() { ... } // from try @ 004e1580 with catch @ 004e1894 */
      if ((*(byte *)(param_1 + 0x30) & 1) != 0) {
        param_5 = 1;
      }
    }
    plVar7 = (long *)(param_1 + 0x1a8);
    if (param_5 != 2) {
      plVar7 = (long *)(param_1 + 400);
    }
    lVar1 = 500;
    if (param_5 != 2) {
      lVar1 = 0x1f0;
    }
    if (param_3 == -0x10) {
                    /* catch() { ... } // from try @ 004e1570 with catch @ 004e18c8 */
      lVar2 = 0x1fc;
      if (param_5 != 2) {
        lVar2 = 0x1f8;
      }
      plVar7 = (long *)(param_1 + 0x1d8);
      if (param_5 != 2) {
        plVar7 = (long *)(param_1 + 0x1c0);
      }
      *(undefined4 *)(param_1 + lVar1) = *(undefined4 *)(param_1 + lVar2);
    }
    lVar2 = *plVar7;
                    /* catch() { ... } // from try @ 004e1554 with catch @ 004e18e8 */
    lVar3 = plVar7[1] - lVar2;
                    /* catch() { ... } // from try @ 004e1718 with catch @ 004e18ec */
    if (lVar3 != 0) {
      uVar8 = (ulong)*(uint *)(param_1 + lVar1);
      uVar9 = (lVar3 >> 2) * 0x6db6db6db6db6db7;
      if (uVar9 < uVar8 || uVar9 - uVar8 == 0) {
        uVar8 = 0;
                    /* catch() { ... } // from try @ 004e1704 with catch @ 004e1918 */
        *(undefined4 *)(param_1 + lVar1) = 0;
      }
      local_40 = (long *)0x0;
                    /* catch() { ... } // from try @ 004e16f0 with catch @ 004e1938 */
      FUN_0050424c(*(undefined8 *)(param_1 + 0xd0),param_2,param_4,lVar2 + uVar8 * 0x1c,alStack_60);
      if (alStack_60 == local_40) {
                    /* catch() { ... } // from try @ 004e16e0 with catch @ 004e1964 */
        pcVar6 = *(code **)(*local_40 + 0x20);
LAB_004e196c:
        (*pcVar6)();
      }
      else if (local_40 != (long *)0x0) {
        pcVar6 = *(code **)(*local_40 + 0x28);
        goto LAB_004e196c;
      }
      uVar5 = 0;
      goto LAB_004e1974;
    }
  }
LAB_004e195c:
  uVar5 = 0xffffffff;
LAB_004e1974:
                    /* catch() { ... } // from try @ 004e16c4 with catch @ 004e197c */
                    /* catch() { ... } // from try @ 004e1528 with catch @ 004e1980 */
  if (*(long *)(lVar4 + 0x28) != local_28) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail(uVar5);
  }
  return;
}



// ===== FUN_00537bd8 @ 00537bd8 size=672 =====

undefined4
FUN_00537bd8(long param_1,uint param_2,uint param_3,ulong param_4,ulong param_5,char param_6)

{
  uint uVar1;
  long *plVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  ulong uVar6;
  undefined1 uVar7;
  undefined8 *puVar8;
  code *pcVar9;
  long lVar10;
  long lVar11;
  undefined4 uVar12;
  undefined8 uVar13;
  undefined2 local_12c [2];
  undefined1 auStack_128 [8];
  long *local_120;
  undefined1 auStack_118 [32];
  undefined4 local_f8;
  undefined2 local_f2;
  undefined1 auStack_f0 [48];
  long alStack_c0 [4];
  long *local_a0;
  undefined8 local_90;
  undefined4 uStack_88;
  undefined4 uStack_84;
  undefined4 uStack_80;
  undefined8 uStack_7c;
  undefined1 auStack_70 [20];
  undefined4 local_5c;
  long local_58;
  
  lVar5 = tpidr_el0;
  local_58 = *(long *)(lVar5 + 0x28);
  if (*(char *)(param_1 + 0x10) == '\0') {
LAB_00537c60:
    uVar12 = 0xffffffff;
    goto LAB_00537e44;
  }
  if (param_6 == '\x01') {
    lVar11 = *(long *)(param_1 + 0x38);
    lVar10 = *(long *)(param_1 + 0x40);
LAB_00537c3c:
    if ((ulong)((lVar10 - lVar11 >> 2) * 0x6db6db6db6db6db7) < 2) goto LAB_00537c60;
  }
  else if (param_6 == '\x02') {
    lVar11 = *(long *)(param_1 + 0x58);
    lVar10 = *(long *)(param_1 + 0x60);
    goto LAB_00537c3c;
  }
  FUN_004209e4(auStack_70);
  local_f8 = 0x101;
  local_f2 = 2;
  FUN_0048d48c(auStack_128);
  FUN_00489490(auStack_118,0x5c0,auStack_128);
  if (local_120 != (long *)0x0) {
    plVar2 = local_120 + 1;
    do {
      lVar11 = *plVar2;
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(plVar2,0x10);
      if (bVar4) {
        *plVar2 = lVar11 + -1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
    if (lVar11 == 0) {
      (**(code **)(*local_120 + 0x10))(local_120);
      std::__ndk1::__shared_weak_count::__release_weak();
    }
  }
  FUN_00501f6c(auStack_f0,auStack_118);
  local_5c = 0;
  if (((param_2 & 1) == 0) && ((param_3 & 1) == 0)) {
    uVar7 = 1;
LAB_00537d20:
    local_f2 = CONCAT11(uVar7,(undefined1)local_f2);
LAB_00537d24:
    FUN_004e86e4(auStack_f0,&local_f8);
    FUN_004e875c(auStack_f0,auStack_70);
    uVar6 = FUN_00502968(auStack_f0);
    if ((uVar6 & 1) == 0) goto LAB_00537e1c;
    local_12c[0] = FUN_00502980(auStack_f0);
    FUN_00502970(auStack_f0);
    FUN_00502104(auStack_f0,2);
    FUN_00502624(auStack_f0,local_12c);
    FUN_00489b74(auStack_118,0,local_12c[0]);
    lVar11 = 0x38;
    if (param_6 != '\x01') {
      lVar11 = 0x58;
    }
    puVar8 = (undefined8 *)(*(long *)(param_1 + lVar11) + (param_4 & 1) * 0x1c);
    uStack_7c = *(undefined8 *)((long)puVar8 + 0x14);
    uVar13 = *puVar8;
    uStack_80 = (undefined4)((ulong)*(undefined8 *)((long)puVar8 + 0xc) >> 0x20);
    uStack_88 = (undefined4)puVar8[1];
    uStack_84 = (undefined4)((ulong)puVar8[1] >> 0x20);
    local_90 = uVar13;
    if ((param_5 & 1) != 0) {
      local_90._2_2_ = (ushort)((ulong)uVar13 >> 0x10);
      uVar1 = ((uint)(local_90._2_2_ >> 8) | (local_90._2_2_ & 0xff00ff) << 8) + 1;
      local_90._4_4_ = (undefined4)((ulong)uVar13 >> 0x20);
      local_90._0_4_ =
           CONCAT22((ushort)(uVar1 >> 8) & 0xff | (ushort)((uVar1 & 0xff00ff) << 8),(short)uVar13);
    }
    local_a0 = (long *)0x0;
    FUN_0050424c(*(undefined8 *)(param_1 + 0x28),auStack_118,(ulong)&local_f8 | 1,&local_90,
                 alStack_c0);
    if (alStack_c0 == local_a0) {
      pcVar9 = *(code **)(*local_a0 + 0x20);
LAB_00537e2c:
      (*pcVar9)();
    }
    else if (local_a0 != (long *)0x0) {
      pcVar9 = *(code **)(*local_a0 + 0x28);
      goto LAB_00537e2c;
    }
    uVar12 = 0;
  }
  else {
    if ((((param_2 ^ 1) & 1) == 0) && (((param_3 ^ 1) & 1) == 0)) {
      uVar7 = 2;
      goto LAB_00537d20;
    }
    if (((param_3 ^ 1 | param_2) & 1) == 0) {
      uVar7 = 3;
      goto LAB_00537d20;
    }
    if (((param_2 ^ 1 | param_3) & 1) != 0) goto LAB_00537d24;
LAB_00537e1c:
    uVar12 = 0xffffffff;
  }
  thunk_FUN_0048996c(auStack_f0);
  FUN_0048996c(auStack_118);
LAB_00537e44:
  if (*(long *)(lVar5 + 0x28) != local_58) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return uVar12;
}



// ===== FUN_0052f1e4 @ 0052f1e4 size=1476 =====

undefined4 FUN_0052f1e4(long param_1)

{
  long *plVar1;
  uint uVar2;
  char cVar3;
  long lVar4;
  byte bVar5;
  byte bVar6;
  bool bVar7;
  undefined1 uVar8;
  ulong uVar9;
  undefined8 uVar10;
  code *pcVar11;
  undefined1 uVar12;
  byte bVar13;
  long lVar14;
  undefined4 uVar15;
  byte bVar16;
  undefined2 local_7e4 [2];
  undefined1 auStack_7e0 [8];
  long *local_7d8;
  undefined1 auStack_7d0 [32];
  undefined1 local_7b0 [4];
  undefined1 local_7ac;
  undefined2 local_7ab;
  undefined1 local_7a9;
  undefined1 local_7a8;
  undefined4 local_7a4;
  undefined1 auStack_7a0 [48];
  long alStack_770 [4];
  long *local_750;
  undefined1 auStack_740 [20];
  uint local_72c;
  undefined1 auStack_728 [20];
  undefined8 local_714;
  undefined8 uStack_70c;
  undefined8 local_704;
  undefined8 uStack_6fc;
  undefined8 local_6f4;
  undefined8 uStack_6ec;
  undefined8 local_6e4;
  undefined8 uStack_6dc;
  undefined8 local_6d4;
  undefined8 uStack_6cc;
  undefined8 local_6c4;
  undefined8 uStack_6bc;
  undefined8 local_6b4;
  undefined8 uStack_6ac;
  undefined8 local_6a4;
  undefined8 uStack_69c;
  undefined8 local_694;
  undefined8 uStack_68c;
  undefined8 local_684;
  undefined1 local_67c;
  undefined1 auStack_678 [20];
  undefined8 local_664;
  undefined8 uStack_65c;
  undefined8 local_654;
  undefined8 uStack_64c;
  undefined8 local_644;
  undefined8 uStack_63c;
  undefined8 local_634;
  undefined8 uStack_62c;
  undefined8 local_624;
  undefined8 uStack_61c;
  undefined8 local_614;
  undefined8 uStack_60c;
  undefined8 local_604;
  undefined8 uStack_5fc;
  undefined8 local_5f4;
  undefined8 uStack_5ec;
  undefined8 local_5e4;
  undefined8 uStack_5dc;
  undefined8 local_5d4;
  undefined8 local_5cc;
  undefined8 uStack_5c4;
  undefined8 local_5bc;
  undefined2 local_58;
  undefined2 local_56;
  undefined1 local_54;
  undefined2 local_53;
  undefined1 local_51;
  undefined2 local_50;
  long local_48;
  
  lVar4 = tpidr_el0;
  local_48 = *(long *)(lVar4 + 0x28);
  cVar3 = *(char *)(param_1 + 0x18c);
  if (cVar3 == '\0') {
    if (*(short *)(param_1 + 0x218) == 2) {
      uVar15 = 0;
      if ((*(uint *)(param_1 + 0x21c) == 0) || ((*(uint *)(param_1 + 0x21c) & 0xff) == 0x7f))
      goto LAB_0052f778;
LAB_0052f4cc:
      if (*(short *)(param_1 + 0x21a) != 0) goto LAB_0052f210;
    }
    else if ((((((((((((((((*(char *)(param_1 + 0x221) != '\0' || *(char *)(param_1 + 0x220) != '\0'
                           ) || *(char *)(param_1 + 0x222) != '\0') ||
                         *(char *)(param_1 + 0x223) != '\0') || *(char *)(param_1 + 0x224) != '\0')
                       || *(char *)(param_1 + 0x225) != '\0') || *(char *)(param_1 + 0x226) != '\0')
                     || *(char *)(param_1 + 0x227) != '\0') || *(char *)(param_1 + 0x228) != '\0')
                   || *(char *)(param_1 + 0x229) != '\0') || *(char *)(param_1 + 0x22a) != '\0') ||
                 *(char *)(param_1 + 0x22b) != '\0') || *(char *)(param_1 + 0x22c) != '\0') ||
               *(char *)(param_1 + 0x22d) != '\0') || *(char *)(param_1 + 0x22e) != '\0') ||
              *(char *)(param_1 + 0x22f) != '\0') &&
            (((((((((((((((*(char *)(param_1 + 0x221) != '\0' || *(char *)(param_1 + 0x220) != '\0')
                         || *(char *)(param_1 + 0x222) != '\0') ||
                        *(char *)(param_1 + 0x223) != '\0') || *(char *)(param_1 + 0x224) != '\0')
                      || *(char *)(param_1 + 0x225) != '\0') || *(char *)(param_1 + 0x226) != '\0')
                    || *(char *)(param_1 + 0x227) != '\0') || *(char *)(param_1 + 0x228) != '\0') ||
                  *(char *)(param_1 + 0x229) != '\0') || *(char *)(param_1 + 0x22a) != '\0') ||
                *(char *)(param_1 + 0x22b) != '\0') || *(char *)(param_1 + 0x22c) != '\0') ||
              *(char *)(param_1 + 0x22d) != '\0') || *(char *)(param_1 + 0x22e) != '\0' ||
             (*(char *)(param_1 + 0x22f) != '\x01')))) goto LAB_0052f4cc;
    uVar15 = 0;
    goto LAB_0052f778;
  }
LAB_0052f210:
  uVar2 = *(uint *)(param_1 + 0xc);
  local_7b0[0] = 0x12;
  if (uVar2 == 0xffffffff) {
    uVar2 = 1;
  }
  local_7ac = (undefined1)uVar2;
  local_7ab = 0;
  local_7a9 = 3;
  if ((uVar2 & 0xff) == 3) {
    FUN_0041fffc();
    uVar8 = FUN_0042027c();
    cVar3 = *(char *)(param_1 + 0x18c);
    uVar12 = 4;
  }
  else {
    uVar8 = 0;
    uVar12 = 0;
  }
  local_7a8 = 99;
  if (cVar3 != '\0') {
    local_7a8 = 7;
  }
  local_7ab = CONCAT11(uVar12,uVar8);
  local_7a4 = FUN_0050437c(*(undefined8 *)(param_1 + 400));
  FUN_0052f84c(auStack_740);
  bVar16 = 1;
  local_72c = 1;
  FUN_00420cb4(auStack_728,param_1 + 0x1c);
  uStack_70c = *(undefined8 *)(param_1 + 0x38);
  local_714 = *(undefined8 *)(param_1 + 0x30);
  uStack_6fc = *(undefined8 *)(param_1 + 0x48);
  local_704 = *(undefined8 *)(param_1 + 0x40);
  uStack_6ec = *(undefined8 *)(param_1 + 0x58);
  local_6f4 = *(undefined8 *)(param_1 + 0x50);
  uStack_6dc = *(undefined8 *)(param_1 + 0x68);
  local_6e4 = *(undefined8 *)(param_1 + 0x60);
  uStack_6cc = *(undefined8 *)(param_1 + 0x78);
  local_6d4 = *(undefined8 *)(param_1 + 0x70);
  uStack_6bc = *(undefined8 *)(param_1 + 0x88);
  local_6c4 = *(undefined8 *)(param_1 + 0x80);
  uStack_6ac = *(undefined8 *)(param_1 + 0x98);
  local_6b4 = *(undefined8 *)(param_1 + 0x90);
  uStack_69c = *(undefined8 *)(param_1 + 0xa8);
  local_6a4 = *(undefined8 *)(param_1 + 0xa0);
  local_684 = *(undefined8 *)(param_1 + 0xc0);
  uStack_68c = *(undefined8 *)(param_1 + 0xb8);
  local_694 = *(undefined8 *)(param_1 + 0xb0);
  FUN_00420cb4(auStack_678,param_1 + 200);
  uStack_62c = *(undefined8 *)(param_1 + 0x114);
  local_634 = *(undefined8 *)(param_1 + 0x10c);
  uStack_60c = *(undefined8 *)(param_1 + 0x134);
  local_614 = *(undefined8 *)(param_1 + 300);
  uStack_61c = *(undefined8 *)(param_1 + 0x124);
  local_624 = *(undefined8 *)(param_1 + 0x11c);
  uStack_63c = *(undefined8 *)(param_1 + 0x104);
  local_644 = *(undefined8 *)(param_1 + 0xfc);
  uStack_5ec = *(undefined8 *)(param_1 + 0x154);
  local_5f4 = *(undefined8 *)(param_1 + 0x14c);
  uStack_5dc = *(undefined8 *)(param_1 + 0x164);
  local_5e4 = *(undefined8 *)(param_1 + 0x15c);
  local_5d4 = *(undefined8 *)(param_1 + 0x16c);
  uStack_5fc = *(undefined8 *)(param_1 + 0x144);
  local_604 = *(undefined8 *)(param_1 + 0x13c);
  uStack_65c = *(undefined8 *)(param_1 + 0xe4);
  local_664 = *(undefined8 *)(param_1 + 0xdc);
  uStack_64c = *(undefined8 *)(param_1 + 0xf4);
  local_654 = *(undefined8 *)(param_1 + 0xec);
  uStack_5c4 = *(undefined8 *)(param_1 + 0x17c);
  local_5cc = *(undefined8 *)(param_1 + 0x174);
  local_5bc = *(undefined8 *)(param_1 + 0x184);
  if (*(int *)(param_1 + 0x1dc) == 2) {
    bVar16 = 2;
  }
  if (*(char *)(param_1 + 0x18) == '\0') {
LAB_0052f400:
    bVar7 = false;
  }
  else {
    FUN_0041fffc();
    uVar9 = FUN_00420284(uStack_62c._4_1_);
    if ((uVar9 & 1) == 0) goto LAB_0052f400;
    bVar7 = (((byte)local_664 ^ 0xff) & 0xc) != 0;
  }
  bVar5 = bVar16;
  if (*(int *)(param_1 + 0x1dc) == 2) {
    bVar13 = 8;
    if (!bVar7) {
      bVar6 = *(byte *)(param_1 + 0x30) & 8;
LAB_0052f4e4:
      if (bVar6 != 0) {
        bVar5 = bVar13;
      }
    }
  }
  else {
    bVar13 = 4;
    if (!bVar7) {
                    /* try { // try from 0052f4dc to 0062f5bb has its CatchHandler @ 0052f4dc
                       catch() { ... } // from try @ 0052f4dc with catch @ 0052f4dc
                       catch() { ... } // from try @ 0052f5c4 with catch @ 0052f4dc */
      bVar6 = *(byte *)(param_1 + 0x30) & 4;
      goto LAB_0052f4e4;
    }
  }
  if (((byte)local_664 & bVar13) != 0) {
    bVar16 = bVar13;
  }
  if ((bVar5 == 8) || (bVar5 == 4)) {
    if ((bVar16 == 8) || (bVar16 == 4)) {
      *(int *)(param_1 + 0x340) = *(int *)(param_1 + 0x340) + 1;
    }
    else {
      *(int *)(param_1 + 0x33c) = *(int *)(param_1 + 0x33c) + 1;
    }
  }
  else if ((bVar16 == 8) || (bVar16 == 4)) {
    *(int *)(param_1 + 0x338) = *(int *)(param_1 + 0x338) + 1;
  }
  else {
    *(int *)(param_1 + 0x334) = *(int *)(param_1 + 0x334) + 1;
  }
  local_714 = CONCAT71(local_714._1_7_,bVar5);
  local_67c = 1;
  local_664 = CONCAT71(local_664._1_7_,bVar16);
  if (*(char *)(param_1 + 0x18c) != '\0') {
    local_72c = local_72c | 2;
    FUN_0041fffc();
    local_58 = FUN_0042007c();
    uVar10 = FUN_0041fffc();
    local_56 = FUN_004200d4(uVar10,0);
    FUN_0041fffc();
    local_54 = FUN_00420090();
                    /* try { // try from 0052f5bc to 0062f5c3 has its CatchHandler @ 0052f5c8 */
    local_53 = 2;
                    /* try { // try from 0052f5c4 to 0062f5ef has its CatchHandler @ 0052f4dc */
    local_51 = 0xfc;
                    /* catch() { ... } // from try @ 0052f5bc with catch @ 0052f5c8 */
    local_50 = 4;
  }
  FUN_0048d48c(auStack_7e0);
  FUN_00489490(auStack_7d0,0x5c0,auStack_7e0);
  if (local_7d8 != (long *)0x0) {
    plVar1 = local_7d8 + 1;
    do {
                    /* try { // try from 0052f5f0 to 0062f6b3 has its CatchHandler @ 0052f5f0
                       catch(type#1 @ 00000000) { ... } // from try @ 0052f5f0 with catch @ 0052f5f0
                       catch(type#1 @ 00000000) { ... } // from try @ 0052f6cc with catch @ 0052f5f0
                       catch(type#1 @ 00000000) { ... } // from try @ 0052f700 with catch @ 0052f5f0
                        */
      lVar14 = *plVar1;
      cVar3 = '\x01';
      bVar7 = (bool)ExclusiveMonitorPass(plVar1,0x10);
      if (bVar7) {
        *plVar1 = lVar14 + -1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
    if (lVar14 == 0) {
      (**(code **)(*local_7d8 + 0x10))(local_7d8);
      std::__ndk1::__shared_weak_count::__release_weak();
    }
  }
  FUN_00501f6c(auStack_7a0,auStack_7d0);
  FUN_004c18a4(auStack_7a0,local_7b0);
  FUN_004c2f54(auStack_7a0,auStack_740);
  uVar9 = FUN_00502968(auStack_7a0);
  if ((uVar9 & 1) == 0) {
    uVar15 = 0;
  }
  else {
    local_7e4[0] = FUN_00502980(auStack_7a0);
    FUN_00502970(auStack_7a0);
    FUN_00502104(auStack_7a0,2);
    FUN_00502624(auStack_7a0,local_7e4);
    FUN_00489b74(auStack_7d0,0,local_7e4[0]);
    if (*(int *)(param_1 + 0x1dc) == 1) {
      *(int *)(param_1 + 0x2ec) = *(int *)(param_1 + 0x2ec) + 1;
      if (*(char *)(param_1 + 0x18c) == '\0') goto LAB_0052f6f4;
LAB_0052f6a8:
      if (*(char *)(param_1 + 0x11) != '\0') {
                    /* try { // try from 0052f6b4 to 0062f6bb has its CatchHandler @ 0052f6f4 */
        local_750 = (long *)0x0;
                    /* try { // try from 0052f6c4 to 0062f6cb has its CatchHandler @ 0052f6f0 */
        FUN_0050424c(*(undefined8 *)(param_1 + 400),auStack_7d0,(ulong)local_7b0 | 4,param_1 + 0x218
                     ,alStack_770);
                    /* try { // try from 0052f6cc to 0062f6f7 has its CatchHandler @ 0052f5f0 */
        goto LAB_0052f718;
      }
      (**(code **)(**(long **)(param_1 + 0x1a0) + 0x28))
                (*(long **)(param_1 + 0x1a0),auStack_7d0,local_7a8,(ulong)local_7b0 | 4);
    }
    else {
      *(int *)(param_1 + 0x2f0) = *(int *)(param_1 + 0x2f0) + 1;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0052f6c4 with catch @ 0052f6f0
                        */
      if (*(char *)(param_1 + 0x18c) != '\0') goto LAB_0052f6a8;
LAB_0052f6f4:
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0052f6b4 with catch @ 0052f6f4
                        */
                    /* try { // try from 0052f6f8 to 0062f6ff has its CatchHandler @ 0052f708 */
                    /* try { // try from 0052f700 to 0062f70b has its CatchHandler @ 0052f5f0 */
      local_750 = (long *)0x0;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0052f6f8 with catch @ 0052f708
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0052f794 with catch @ 0052f70c
                       catch(type#1 @ 00000000) { ... } // from try @ 0052f814 with catch @ 0052f70c
                       catch(type#1 @ 00000000) { ... } // from try @ 0052f8d0 with catch @ 0052f70c
                        */
      FUN_0050424c(*(undefined8 *)(param_1 + 400),auStack_7d0,(ulong)local_7b0 | 4,param_1 + 0x218,
                   alStack_770);
LAB_0052f718:
      if (alStack_770 == local_750) {
        pcVar11 = *(code **)(*local_750 + 0x20);
      }
      else {
        if (local_750 == (long *)0x0) goto LAB_0052f764;
        pcVar11 = *(code **)(*local_750 + 0x28);
      }
      (*pcVar11)();
    }
LAB_0052f764:
    uVar15 = 1;
  }
                    /* try { // try from 0052f768 to 0062f76f has its CatchHandler @ 0052f854 */
  thunk_FUN_0048996c(auStack_7a0);
  FUN_0048996c(auStack_7d0);
LAB_0052f778:
  if (*(long *)(lVar4 + 0x28) != local_48) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
                    /* try { // try from 0052f78c to 0062f793 has its CatchHandler @ 0052f838 */
                    /* try { // try from 0052f794 to 0062f80b has its CatchHandler @ 0052f70c */
  return uVar15;
}



// ===== FUN_0052ed50 @ 0052ed50 size=1004 =====

undefined4 FUN_0052ed50(long param_1,undefined8 param_2,short *param_3,int param_4)

{
  uint uVar1;
  char cVar2;
  bool bVar3;
  long lVar4;
  undefined1 uVar5;
  int iVar6;
  ulong uVar7;
  undefined8 uVar8;
  undefined8 *puVar9;
  undefined1 uVar10;
  code *pcVar11;
  long lVar12;
  long *plVar13;
  long *plVar14;
  undefined4 uVar15;
  long *plVar16;
  long *plVar17;
  undefined2 local_124 [2];
  undefined1 auStack_120 [8];
  long *local_118;
  undefined1 auStack_110 [32];
  undefined1 local_f0 [4];
  undefined1 local_ec;
  undefined2 local_eb;
  undefined1 local_e9;
  undefined1 local_e8;
  uint local_e4;
  undefined1 auStack_e0 [48];
  long alStack_b0 [4];
  long *local_90;
  undefined1 auStack_78 [20];
  undefined4 local_64;
  undefined1 local_60;
  long local_58;
  
  lVar4 = tpidr_el0;
  local_58 = *(long *)(lVar4 + 0x28);
  if (*param_3 == 2) {
    uVar15 = 0;
    if ((*(uint *)(param_3 + 2) == 0) || ((*(uint *)(param_3 + 2) & 0xff) == 0x7f))
    goto LAB_0052f108;
LAB_0052ee3c:
    if (param_3[1] != 0) {
      uVar1 = *(uint *)(param_1 + 0xc);
      local_f0[0] = 0x12;
      uVar5 = 0;
      if (uVar1 == 0xffffffff) {
        uVar1 = 1;
      }
      uVar10 = 0;
      local_ec = (undefined1)uVar1;
      local_eb = 0;
      local_e9 = 3;
      if ((uVar1 & 0xff) == 3) {
        FUN_0041fffc();
        uVar5 = FUN_0042027c();
        uVar10 = 4;
      }
      local_eb = CONCAT11(uVar10,uVar5);
      local_e8 = 0x61;
      local_e4 = FUN_0050437c(*(undefined8 *)(param_1 + 400));
      FUN_004209e4(auStack_78);
      local_60 = 0;
      local_64 = 1;
      FUN_00420cb4(auStack_78,param_1 + 0x1c);
                    /* try { // try from 0052eec4 to 0062eecb has its CatchHandler @ 0052ef00 */
      local_60 = 0;
                    /* try { // try from 0052eecc to 0062ef13 has its CatchHandler @ 0052ee24 */
      FUN_0048d48c(auStack_120);
      FUN_00489490(auStack_110,0x5c0,auStack_120);
      if (local_118 != (long *)0x0) {
        plVar13 = local_118 + 1;
        do {
          lVar12 = *plVar13;
          cVar2 = '\x01';
          bVar3 = (bool)ExclusiveMonitorPass(plVar13,0x10);
          if (bVar3) {
            *plVar13 = lVar12 + -1;
            cVar2 = ExclusiveMonitorsStatus();
          }
        } while (cVar2 != '\0');
        if (lVar12 == 0) {
                    /* catch() { ... } // from try @ 0052eec4 with catch @ 0052ef00 */
          (**(code **)(*local_118 + 0x10))(local_118);
          std::__ndk1::__shared_weak_count::__release_weak();
        }
      }
      FUN_00501f6c(auStack_e0,auStack_110);
      FUN_004c18a4(auStack_e0,local_f0);
      FUN_0052a538(auStack_e0,auStack_78);
      uVar7 = FUN_00502968(auStack_e0);
      if ((uVar7 & 1) == 0) {
        uVar15 = 0;
      }
      else {
        local_124[0] = FUN_00502980(auStack_e0);
                    /* catch() { ... } // from try @ 0052ef6c with catch @ 0052ef50 */
        FUN_00502970(auStack_e0);
                    /* try { // try from 0052ef64 to 0062ef6b has its CatchHandler @ 0052f014 */
        FUN_00502104(auStack_e0,2);
                    /* try { // try from 0052ef6c to 0062f033 has its CatchHandler @ 0052ef50 */
        FUN_00502624(auStack_e0,local_124);
        FUN_00489b74(auStack_110,0,local_124[0]);
        if (param_4 < 1) {
          iVar6 = 0;
        }
        else {
          iVar6 = FUN_00504ce0(*(undefined8 *)(param_1 + 400),param_3);
          if (0 < iVar6) {
            FUN_00504e7c(*(undefined8 *)(param_1 + 400),param_3,param_4);
          }
        }
        local_90 = (long *)0x0;
        FUN_0050424c(*(undefined8 *)(param_1 + 400),auStack_110,(ulong)local_f0 | 4,param_3,
                     alStack_b0);
        if (alStack_b0 == local_90) {
                    /* catch() { ... } // from try @ 0052ef64 with catch @ 0052f014 */
          pcVar11 = *(code **)(*local_90 + 0x20);
LAB_0052f018:
          (*pcVar11)();
        }
        else if (local_90 != (long *)0x0) {
          pcVar11 = *(code **)(*local_90 + 0x28);
          goto LAB_0052f018;
        }
        if ((0 < param_4) && (0 < iVar6)) {
          FUN_00504e7c(*(undefined8 *)(param_1 + 400),param_3,iVar6);
        }
        uVar8 = FUN_00420784();
        uVar1 = local_e4;
        plVar13 = (long *)(param_1 + 0x368);
        plVar16 = *(long **)(param_1 + 0x368);
        plVar17 = plVar13;
        while (plVar16 != (long *)0x0) {
          while (plVar14 = plVar16, plVar17 = plVar14, local_e4 < *(uint *)(plVar14 + 4)) {
            plVar13 = plVar14;
            plVar16 = (long *)*plVar14;
            if ((long *)*plVar14 == (long *)0x0) {
              if (*plVar14 != 0) goto LAB_0052f0f4;
              goto LAB_0052f09c;
            }
          }
          if (local_e4 <= *(uint *)(plVar14 + 4)) break;
          plVar13 = plVar14 + 1;
          plVar16 = (long *)*plVar13;
        }
        plVar14 = plVar13;
        if (*plVar14 == 0) {
LAB_0052f09c:
          puVar9 = operator_new(0x30);
          *(uint *)(puVar9 + 4) = uVar1;
          puVar9[5] = uVar8;
          *puVar9 = 0;
          puVar9[1] = 0;
          puVar9[2] = plVar17;
          *plVar14 = (long)puVar9;
          if (**(long **)(param_1 + 0x360) != 0) {
            *(long *)(param_1 + 0x360) = **(long **)(param_1 + 0x360);
            puVar9 = (undefined8 *)*plVar14;
          }
          FUN_00176d70(*(undefined8 *)(param_1 + 0x368),puVar9);
          *(long *)(param_1 + 0x370) = *(long *)(param_1 + 0x370) + 1;
        }
LAB_0052f0f4:
        uVar15 = 1;
      }
      thunk_FUN_0048996c(auStack_e0);
      FUN_0048996c(auStack_110);
      goto LAB_0052f108;
    }
  }
  else {
                    /* try { // try from 0052edd4 to 0062eddb has its CatchHandler @ 0052ee10 */
                    /* try { // try from 0052eddc to 0062ee23 has its CatchHandler @ 0052ed34 */
                    /* catch() { ... } // from try @ 0052edd4 with catch @ 0052ee10 */
                    /* try { // try from 0052ee24 to 0062eec3 has its CatchHandler @ 0052ee24
                       catch() { ... } // from try @ 0052ee24 with catch @ 0052ee24
                       catch() { ... } // from try @ 0052eecc with catch @ 0052ee24 */
    if ((((((((((((((((*(char *)((long)param_3 + 9) != '\0' || (char)param_3[4] != '\0') ||
                     (char)param_3[5] != '\0') || *(char *)((long)param_3 + 0xb) != '\0') ||
                   (char)param_3[6] != '\0') || *(char *)((long)param_3 + 0xd) != '\0') ||
                 (char)param_3[7] != '\0') || *(char *)((long)param_3 + 0xf) != '\0') ||
               (char)param_3[8] != '\0') || *(char *)((long)param_3 + 0x11) != '\0') ||
             (char)param_3[9] != '\0') || *(char *)((long)param_3 + 0x13) != '\0') ||
           (char)param_3[10] != '\0') || *(char *)((long)param_3 + 0x15) != '\0') ||
         (char)param_3[0xb] != '\0') || *(char *)((long)param_3 + 0x17) != '\0') &&
       (((((((((((((((*(char *)((long)param_3 + 9) != '\0' || (char)param_3[4] != '\0') ||
                    (char)param_3[5] != '\0') || *(char *)((long)param_3 + 0xb) != '\0') ||
                  (char)param_3[6] != '\0') || *(char *)((long)param_3 + 0xd) != '\0') ||
                (char)param_3[7] != '\0') || *(char *)((long)param_3 + 0xf) != '\0') ||
              (char)param_3[8] != '\0') || *(char *)((long)param_3 + 0x11) != '\0') ||
            (char)param_3[9] != '\0') || *(char *)((long)param_3 + 0x13) != '\0') ||
          (char)param_3[10] != '\0') || *(char *)((long)param_3 + 0x15) != '\0') ||
         (char)param_3[0xb] != '\0' || (*(char *)((long)param_3 + 0x17) != '\x01'))))
    goto LAB_0052ee3c;
  }
  uVar15 = 0;
LAB_0052f108:
  if (*(long *)(lVar4 + 0x28) == local_58) {
    return uVar15;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00530744 @ 00530744 size=504 =====

undefined4 FUN_00530744(long param_1,undefined8 param_2,undefined4 param_3)

{
  long *plVar1;
  uint uVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  undefined1 uVar6;
  ulong uVar7;
  undefined1 uVar8;
  code *pcVar9;
  long lVar10;
  undefined4 uVar11;
  undefined2 local_104 [2];
  undefined1 auStack_100 [8];
  long *local_f8;
  undefined1 auStack_f0 [32];
  undefined1 local_d0 [4];
  undefined1 local_cc;
  undefined2 local_cb;
  undefined1 local_c9;
  undefined1 local_c8;
  undefined4 local_c4;
  undefined1 auStack_c0 [48];
  long alStack_90 [4];
  long *local_70;
  undefined1 auStack_58 [20];
  undefined4 local_44;
  undefined2 local_40;
  long local_38;
  
                    /* try { // try from 00530750 to 00630757 has its CatchHandler @ 00530998 */
  lVar5 = tpidr_el0;
  local_38 = *(long *)(lVar5 + 0x28);
  uVar2 = *(uint *)(param_1 + 0xc);
                    /* try { // try from 00530770 to 0063079f has its CatchHandler @ 0053099c */
  uVar6 = 0;
  uVar8 = 0;
  if (uVar2 == 0xffffffff) {
    uVar2 = 1;
  }
  local_cc = (undefined1)uVar2;
  local_d0[0] = 0x12;
  local_cb = 0;
  local_c9 = 3;
  if ((uVar2 & 0xff) == 3) {
    FUN_0041fffc();
    uVar6 = FUN_0042027c();
    uVar8 = 4;
  }
  local_cb = CONCAT11(uVar8,uVar6);
  local_c8 = 0x66;
  local_c4 = param_3;
  FUN_004209e4(auStack_58);
  local_40 = 0;
  local_44 = 1;
  FUN_00420cb4(auStack_58,param_1 + 0x1c);
  local_40 = 0;
  FUN_0048d48c(auStack_100);
                    /* try { // try from 005307f8 to 006307ff has its CatchHandler @ 00530a00 */
  FUN_00489490(auStack_f0,0x5c0,auStack_100);
  if (local_f8 != (long *)0x0) {
    plVar1 = local_f8 + 1;
    do {
      lVar10 = *plVar1;
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(plVar1,0x10);
      if (bVar4) {
        *plVar1 = lVar10 + -1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
    if (lVar10 == 0) {
      (**(code **)(*local_f8 + 0x10))(local_f8);
      std::__ndk1::__shared_weak_count::__release_weak();
    }
  }
  FUN_00501f6c(auStack_c0,auStack_f0);
  FUN_004c18a4(auStack_c0,local_d0);
  FUN_0052a604(auStack_c0,auStack_58);
  uVar7 = FUN_00502968(auStack_c0);
  if ((uVar7 & 1) == 0) {
    uVar11 = 0;
    goto LAB_00530900;
  }
  local_104[0] = FUN_00502980(auStack_c0);
  FUN_00502970(auStack_c0);
                    /* try { // try from 0053087c to 00630883 has its CatchHandler @ 005309b0 */
                    /* try { // try from 00530884 to 006308a7 has its CatchHandler @ 00530710 */
  FUN_00502104(auStack_c0,2);
  FUN_00502624(auStack_c0,local_104);
  FUN_00489b74(auStack_f0,0,local_104[0]);
                    /* try { // try from 005308a8 to 006308b3 has its CatchHandler @ 005309e0 */
  local_70 = (long *)0x0;
  FUN_0050424c(*(undefined8 *)(param_1 + 400),auStack_f0,(ulong)local_d0 | 4,param_2,alStack_90);
  if (alStack_90 == local_70) {
    pcVar9 = *(code **)(*local_70 + 0x20);
LAB_005308f8:
    (*pcVar9)();
  }
  else if (local_70 != (long *)0x0) {
    pcVar9 = *(code **)(*local_70 + 0x28);
    goto LAB_005308f8;
  }
  uVar11 = 1;
LAB_00530900:
  thunk_FUN_0048996c(auStack_c0);
  FUN_0048996c(auStack_f0);
                    /* try { // try from 00530914 to 0063091f has its CatchHandler @ 005309c0 */
  if (*(long *)(lVar5 + 0x28) == local_38) {
    return uVar11;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_004d7f80 @ 004d7f80 size=488 =====

void FUN_004d7f80(long param_1,undefined8 param_2,uint param_3,undefined8 param_4,int param_5)

{
  long lVar1;
  long lVar2;
  long lVar3;
  undefined8 uVar4;
  ulong uVar5;
  code *pcVar6;
  ulong uVar7;
  uint *puVar8;
  long lVar9;
  long alStack_60 [4];
  long *local_40;
  long local_28;
  
  lVar3 = tpidr_el0;
                    /* try { // try from 004d7f90 to 005d7fc7 has its CatchHandler @ 004d8454 */
  local_28 = *(long *)(lVar3 + 0x28);
  if (*(char *)(param_1 + 0x18) == '\0') goto LAB_004d8114;
  if (1 < param_5 - 1U) {
    if (param_5 != 0) goto LAB_004d8114;
    param_5 = 1;
    if ((*(byte *)(param_1 + 0x38) & 3) == 2) {
      param_5 = 2;
    }
  }
  if ((param_3 & 0xff) == 0xf0) {
                    /* try { // try from 004d7fd8 to 005d8027 has its CatchHandler @ 004d846c */
    uVar5 = 4;
    if (param_5 != 1) {
      uVar5 = 5;
    }
    uVar7 = 10;
    if (*(char *)(param_1 + 0x35) != '\0') {
      uVar7 = uVar5;
    }
  }
  else if (*(int *)(param_1 + 0x3c) == 0) {
                    /* try { // try from 004d803c to 005d803f has its CatchHandler @ 004d8424 */
    uVar7 = 10;
    if (((param_3 & 0xff) < 0x14) && ((1 << (ulong)(param_3 & 0x1f) & 0xd6aaaU) != 0))
    goto switchD_004d8020_caseD_3;
  }
  else {
    uVar7 = 10;
    switch(param_3 & 0xff) {
    case 1:
    case 9:
    case 0xb:
      uVar7 = 8;
      if (param_5 != 1) {
        uVar7 = 9;
      }
      break;
    case 5:
switchD_004d8020_caseD_5:
      uVar7 = 6;
      if (param_5 != 1) {
        uVar7 = 7;
      }
      break;
    case 7:
      if (*(int *)(param_1 + 0x40) != 0) goto switchD_004d8020_caseD_5;
    case 3:
    case 0xd:
    case 0xe:
    case 0x10:
    case 0x12:
    case 0x13:
switchD_004d8020_caseD_3:
      uVar7 = (ulong)(param_5 != 1);
    }
  }
  lVar1 = *(long *)(param_1 + 0x128);
                    /* try { // try from 004d807c to 005d80b3 has its CatchHandler @ 004d843c */
  uVar5 = (*(long *)(param_1 + 0x130) - lVar1 >> 3) * -0xf0f0f0f0f0f0f0f;
  if (uVar7 <= uVar5 && uVar5 - uVar7 != 0) {
    lVar9 = lVar1 + uVar7 * 0x88;
    lVar2 = *(long *)(lVar9 + 0x60);
    lVar9 = *(long *)(lVar9 + 0x68);
    if (lVar2 != lVar9) {
      puVar8 = (uint *)(lVar1 + uVar7 * 0x88 + 0x10);
      uVar7 = (ulong)*puVar8;
      uVar5 = (lVar9 - lVar2 >> 2) * 0x6db6db6db6db6db7;
                    /* try { // try from 004d80c4 to 005d8113 has its CatchHandler @ 004d846c */
      if (uVar5 < uVar7 || uVar5 - uVar7 == 0) {
        uVar7 = 0;
        *puVar8 = 0;
      }
      local_40 = (long *)0x0;
      FUN_0050424c(*(undefined8 *)(param_1 + 0xd8),param_2,param_4,lVar2 + uVar7 * 0x1c,alStack_60);
      if (alStack_60 == local_40) {
        pcVar6 = *(code **)(*local_40 + 0x20);
LAB_004d8140:
        (*pcVar6)();
      }
      else if (local_40 != (long *)0x0) {
        pcVar6 = *(code **)(*local_40 + 0x28);
        goto LAB_004d8140;
      }
      uVar4 = 0;
      goto LAB_004d8118;
    }
  }
LAB_004d8114:
  uVar4 = 0xffffffff;
LAB_004d8118:
  if (*(long *)(lVar3 + 0x28) == local_28) {
                    /* try { // try from 004d8128 to 005d812b has its CatchHandler @ 004d840c */
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail(uVar4);
}



// ===== FUN_00501da0 @ 00501da0 size=252 =====

void FUN_00501da0(undefined8 param_1,int param_2,undefined8 param_3,int param_4)

{
  long lVar1;
  uint uVar2;
  ulong __n;
  void *pvVar3;
  ulong uVar4;
  ulong local_50;
  ulong local_48;
  void *local_40;
  long local_38;
  
  lVar1 = tpidr_el0;
  local_38 = *(long *)(lVar1 + 0x28);
  if ((param_2 == 2) && (param_4 < 0x10)) {
    __n = -(long)param_4 + 0x10;
    uVar2 = (uint)__n;
    local_48 = 0;
    local_40 = (void *)0x0;
    local_50 = 0;
    if (0xffffffef < uVar2) {
                    /* WARNING: Subroutine does not return */
      FUN_00174d3c(&local_50);
    }
    if (uVar2 < 0x17) {
      pvVar3 = (void *)((ulong)&local_50 | 1);
      local_50 = (ulong)(byte)(uVar2 << 1);
    }
    else {
      uVar4 = -(long)param_4 + 0x20U & 0xfffffffffffffff0;
      pvVar3 = operator_new(uVar4);
      local_50 = uVar4 | 1;
      local_48 = __n;
      local_40 = pvVar3;
    }
    memset(pvVar3,0x74,__n);
    *(undefined1 *)((long)pvVar3 + __n) = 0;
    pvVar3 = (void *)((ulong)&local_50 | 1);
    if ((local_50 & 1) != 0) {
      pvVar3 = local_40;
    }
    FUN_00489b74(param_3,pvVar3,__n & 0xffffffff);
    if ((local_50 & 1) != 0) {
      operator_delete(local_40);
    }
  }
  if (*(long *)(lVar1 + 0x28) == local_38) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00530d74 @ 00530d74 size=508 =====

undefined4 FUN_00530d74(long param_1,undefined8 param_2)

{
  long *plVar1;
  uint uVar2;
  char cVar3;
  bool bVar4;
  long lVar5;
  undefined1 uVar6;
  ulong uVar7;
  undefined1 uVar8;
  code *pcVar9;
  long lVar10;
  undefined4 uVar11;
  undefined2 local_104 [2];
  undefined1 auStack_100 [8];
  long *local_f8;
  undefined1 auStack_f0 [32];
  undefined1 local_d0 [4];
  undefined1 local_cc;
  undefined2 local_cb;
  undefined1 local_c9;
  undefined1 local_c8;
  undefined4 local_c4;
  undefined1 auStack_c0 [48];
  long alStack_90 [4];
  long *local_70;
  undefined1 auStack_58 [20];
  undefined4 local_44;
  undefined1 local_40;
  long local_38;
  
  lVar5 = tpidr_el0;
  local_38 = *(long *)(lVar5 + 0x28);
  uVar6 = 0;
  uVar2 = *(uint *)(param_1 + 0xc);
  uVar8 = 0;
  local_d0[0] = 0x12;
  if (uVar2 == 0xffffffff) {
    uVar2 = 1;
  }
  local_cc = (undefined1)uVar2;
  local_cb = 0;
  local_c9 = 3;
  if ((uVar2 & 0xff) == 3) {
    FUN_0041fffc();
    uVar6 = FUN_0042027c();
    uVar8 = 4;
  }
  local_cb = CONCAT11(uVar8,uVar6);
  local_c8 = 0x65;
  local_c4 = FUN_0050437c(*(undefined8 *)(param_1 + 400));
  FUN_004209e4(auStack_58);
  local_40 = 0;
  local_44 = 1;
  FUN_00420cb4(auStack_58,param_1 + 0x1c);
  local_40 = 1;
  FUN_0048d48c(auStack_100);
  FUN_00489490(auStack_f0,0x5c0,auStack_100);
  if (local_f8 != (long *)0x0) {
    plVar1 = local_f8 + 1;
    do {
      lVar10 = *plVar1;
      cVar3 = '\x01';
      bVar4 = (bool)ExclusiveMonitorPass(plVar1,0x10);
      if (bVar4) {
        *plVar1 = lVar10 + -1;
        cVar3 = ExclusiveMonitorsStatus();
      }
    } while (cVar3 != '\0');
    if (lVar10 == 0) {
      (**(code **)(*local_f8 + 0x10))(local_f8);
      std::__ndk1::__shared_weak_count::__release_weak();
    }
  }
  FUN_00501f6c(auStack_c0,auStack_f0);
  FUN_004c18a4(auStack_c0,local_d0);
  FUN_0052a5c0(auStack_c0,auStack_58);
  uVar7 = FUN_00502968(auStack_c0);
  if ((uVar7 & 1) == 0) {
    uVar11 = 0;
    goto LAB_00530f34;
  }
  local_104[0] = FUN_00502980(auStack_c0);
  FUN_00502970(auStack_c0);
  FUN_00502104(auStack_c0,2);
  FUN_00502624(auStack_c0,local_104);
  FUN_00489b74(auStack_f0,0,local_104[0]);
  local_70 = (long *)0x0;
  FUN_0050424c(*(undefined8 *)(param_1 + 400),auStack_f0,(ulong)local_d0 | 4,param_2,alStack_90);
  if (alStack_90 == local_70) {
    pcVar9 = *(code **)(*local_70 + 0x20);
LAB_00530f2c:
    (*pcVar9)();
  }
  else if (local_70 != (long *)0x0) {
    pcVar9 = *(code **)(*local_70 + 0x28);
    goto LAB_00530f2c;
  }
  uVar11 = 1;
LAB_00530f34:
  thunk_FUN_0048996c(auStack_c0);
  FUN_0048996c(auStack_f0);
  if (*(long *)(lVar5 + 0x28) == local_38) {
    return uVar11;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_0050d3b0 @ 0050d3b0 size=300 =====

undefined4
FUN_0050d3b0(long param_1,undefined8 param_2,char param_3,undefined8 param_4,undefined4 param_5)

{
  long lVar1;
  undefined1 uVar2;
  ulong uVar3;
  undefined1 uVar4;
  code *pcVar5;
  undefined4 uVar6;
  undefined1 auStack_a0 [32];
  undefined1 local_80 [4];
  char local_7c;
  undefined2 local_7b;
  undefined1 local_79;
  long alStack_70 [4];
  long *local_50;
  long local_38;
  
  lVar1 = tpidr_el0;
  local_38 = *(long *)(lVar1 + 0x28);
  if (*(char *)(param_1 + 0x18) == '\0') {
    uVar6 = 0xffffffff;
    goto LAB_0050d4b0;
  }
  uVar2 = 0;
  uVar4 = 0;
                    /* try { // try from 0050d3f4 to 0060d3fb has its CatchHandler @ 0050d6a8 */
  local_7b = 0;
                    /* try { // try from 0050d400 to 0060d403 has its CatchHandler @ 0050d698 */
  local_80[0] = 0x12;
  local_79 = 3;
  local_7c = param_3;
  if (param_3 == '\x03') {
    FUN_0041fffc();
    uVar2 = FUN_0042027c();
    uVar4 = 4;
  }
                    /* try { // try from 0050d420 to 0060d437 has its CatchHandler @ 0050d6b8 */
  local_7b = CONCAT11(uVar4,uVar2);
  FUN_0050d724(auStack_a0,param_1,local_80,param_4,param_5);
                    /* try { // try from 0050d43c to 0060d443 has its CatchHandler @ 0050d688 */
  uVar3 = FUN_00489a54(auStack_a0);
  if ((uVar3 & 1) == 0) {
                    /* try { // try from 0050d464 to 0060d46b has its CatchHandler @ 0050d678 */
    local_50 = (long *)0x0;
    FUN_0050424c(*(undefined8 *)(param_1 + 0x58),auStack_a0,(ulong)local_80 | 4,param_2,alStack_70);
    if (alStack_70 == local_50) {
      pcVar5 = *(code **)(*local_50 + 0x20);
LAB_0050d4a0:
                    /* try { // try from 0050d4a0 to 0060d4ff has its CatchHandler @ 0050d378 */
      (*pcVar5)();
    }
    else if (local_50 != (long *)0x0) {
                    /* try { // try from 0050d490 to 0060d49f has its CatchHandler @ 0050d6c0 */
      pcVar5 = *(code **)(*local_50 + 0x28);
      goto LAB_0050d4a0;
    }
    uVar6 = 0;
  }
  else {
                    /* try { // try from 0050d448 to 0060d45f has its CatchHandler @ 0050d6b0 */
    uVar6 = 0xffffffff;
  }
  FUN_0048996c(auStack_a0);
LAB_0050d4b0:
  if (*(long *)(lVar1 + 0x28) == local_38) {
    return uVar6;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}


