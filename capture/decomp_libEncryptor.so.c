// ===== FUN_00100a30 @ 00100a30 size=20 =====

void FUN_00100a30(void)

{
  (*(code *)PTR_00117f68)();
  return;
}



// ===== __cxa_finalize @ 00100a50 size=16 =====

void __cxa_finalize(void)

{
  (*(code *)PTR___cxa_finalize_00117f70)();
  return;
}



// ===== __deregister_frame_info @ 00100a60 size=16 =====

void __deregister_frame_info(void)

{
  (*(code *)PTR___deregister_frame_info_00117f78)();
  return;
}



// ===== srand @ 00100a70 size=16 =====

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void srand(uint __seed)

{
  (*(code *)PTR_srand_00117f80)(__seed);
  return;
}



// ===== time @ 00100a80 size=16 =====

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

time_t time(time_t *__timer)

{
  time_t tVar1;
  
  tVar1 = (*(code *)PTR_time_00117f88)();
  return tVar1;
}



// ===== rand @ 00100a90 size=16 =====

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

int rand(void)

{
  int iVar1;
  
  iVar1 = (*(code *)PTR_rand_00117f90)();
  return iVar1;
}



// ===== __stack_chk_fail @ 00100aa0 size=16 =====

void __stack_chk_fail(void)

{
  (*(code *)PTR___stack_chk_fail_00117f98)();
  return;
}



// ===== __register_frame_info @ 00100ab0 size=16 =====

void __register_frame_info(void)

{
  (*(code *)PTR___register_frame_info_00117fa0)();
  return;
}



// ===== malloc @ 00100ac0 size=16 =====

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_malloc_00117fa8)();
  return pvVar1;
}



// ===== memcpy @ 00100ad0 size=16 =====

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * memcpy(void *__dest,void *__src,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_memcpy_00117fb0)();
  return pvVar1;
}



// ===== memset @ 00100ae0 size=16 =====

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * memset(void *__s,int __c,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_memset_00117fb8)(__s,__c);
  return pvVar1;
}



// ===== free @ 00100af0 size=16 =====

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
  (*(code *)PTR_free_00117fc0)();
  return;
}



// ===== entry @ 00100b00 size=64 =====

/* WARNING: Removing unreachable block (ram,0x00100b28) */
/* WARNING: Removing unreachable block (ram,0x00100b34) */

void entry(void)

{
  return;
}



// ===== FUN_00100b40 @ 00100b40 size=68 =====

/* WARNING: Removing unreachable block (ram,0x00100b6c) */
/* WARNING: Removing unreachable block (ram,0x00100b78) */

void FUN_00100b40(void)

{
  return;
}



// ===== _FINI_0 @ 00100b84 size=100 =====

void _FINI_0(void)

{
  if (DAT_00118020 == '\0') {
    if (PTR___cxa_finalize_00117fd0 != (undefined *)0x0) {
      __cxa_finalize(PTR_LOOP_00118000);
    }
    entry();
    if (PTR___deregister_frame_info_00117fd8 != (undefined *)0x0) {
      __deregister_frame_info(&cie_00110ae0);
    }
    DAT_00118020 = '\x01';
  }
  return;
}



// ===== _INIT_0 @ 00100be8 size=80 =====

void _INIT_0(void)

{
  if (PTR___register_frame_info_00117ff0 != (undefined *)0x0) {
    __register_frame_info(&cie_00110ae0,&DAT_00118028);
  }
  if ((DAT_00117cc8 != 0) && (PTR__Jv_RegisterClasses_00117fe0 != (undefined *)0x0)) {
    (*(code *)PTR__Jv_RegisterClasses_00117fe0)();
  }
  FUN_00100b40();
  return;
}



// ===== JNI_OnLoad @ 00100c38 size=124 =====

void JNI_OnLoad(undefined8 param_1,undefined8 param_2)

{
  long lVar1;
  undefined8 local_390;
  undefined8 uStack_388;
  undefined4 local_380;
  code *local_378;
  undefined1 *puStack_370;
  undefined1 auStack_30 [8];
  long local_28;
  
  lVar1 = tpidr_el0;
  local_28 = *(long *)(lVar1 + 0x28);
  puStack_370 = auStack_30;
  local_378 = FUN_00100d88;
  local_390 = param_1;
  uStack_388 = param_2;
  FUN_00100d94(&DAT_00108890,&local_390,0,&DAT_00117cd0,&local_378);
  if (*(long *)(lVar1 + 0x28) == local_28) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail(local_380);
}



// ===== FUN_00100cb4 @ 00100cb4 size=36 =====

void FUN_00100cb4(undefined8 *param_1)

{
  undefined4 uVar1;
  
  uVar1 = (*(code *)*param_1)(param_1[1],param_1[2],*(undefined4 *)(param_1 + 3));
  *(undefined4 *)((long)param_1 + 0x1c) = uVar1;
  return;
}



// ===== FUN_00100cd8 @ 00100cd8 size=176 =====

void FUN_00100cd8(undefined8 *param_1)

{
  ulong uVar1;
  uint uVar2;
  long lVar3;
  long *plVar4;
  
  plVar4 = (long *)*param_1;
  if (DAT_00118094 == 0) {
    lVar3 = 0;
    do {
      (&DAT_00118060)[lVar3] = (&DAT_00108850)[lVar3] ^ 0x73;
      lVar3 = lVar3 + 1;
    } while (lVar3 != 0x30);
  }
  DAT_00118094 = 1;
  lVar3 = (**(code **)(*plVar4 + 0x30))(plVar4,&DAT_00118060);
  uVar2 = 0;
  if (lVar3 != 0) {
    uVar1 = (**(code **)(*plVar4 + 0x6b8))(plVar4,lVar3,&PTR_s_ttEncrypt_00118008,1);
    uVar2 = (uint)(uVar1 >> 0x1f) & 1 ^ 1;
  }
  *(uint *)(param_1 + 1) = uVar2;
  return;
}



// ===== FUN_00100d88 @ 00100d88 size=12 =====

void FUN_00100d88(code *UNRECOVERED_JUMPTABLE,undefined8 param_2)

{
                    /* WARNING: Could not recover jumptable at 0x00100d90. Too many branches */
                    /* WARNING: Treating indirect jump as call */
  (*UNRECOVERED_JUMPTABLE)(param_2);
  return;
}



// ===== FUN_00100d94 @ 00100d94 size=6476 =====

void FUN_00100d94(code *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 *param_5)

{
  bool bVar1;
  ulong *puVar2;
  long *plVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  undefined8 uVar8;
  code *pcVar9;
  long lVar10;
  undefined4 uVar11;
  undefined4 uVar12;
  uint uVar13;
  uint uVar14;
  ushort uVar15;
  undefined1 auVar16 [16];
  undefined1 auVar17 [16];
  ushort uVar18;
  ushort uVar19;
  ushort uVar20;
  ushort uVar21;
  ushort uVar22;
  ushort uVar23;
  bool bVar24;
  long lVar25;
  ulong *puVar26;
  ulong *puVar27;
  uint uVar28;
  ulong uVar29;
  code *pcVar30;
  undefined8 *puVar31;
  ulong uVar32;
  long lVar33;
  int iVar34;
  uint uVar35;
  ulong uVar36;
  byte bVar37;
  uint uVar38;
  ulong uVar39;
  code *pcVar40;
  byte bVar41;
  bool bVar42;
  uint uVar43;
  uint uVar44;
  uint uVar45;
  uint uVar46;
  code *pcVar47;
  ulong uVar48;
  long *plVar49;
  
  pcVar9 = (code *)*param_5;
  lVar10 = param_5[1];
  *(undefined8 *)(lVar10 + -0x38) = 0;
  *(undefined8 *)(lVar10 + -0x130) = 0;
  plVar49 = (long *)(lVar10 + -0x138);
  *(ulong *)(lVar10 + -0x48) = lVar10 - 0x148U & 0xfffffffffffffff0;
  *(undefined8 *)(lVar10 + -0x20) = 0;
  *(undefined8 *)(lVar10 + -0x110) = param_2;
  *(undefined8 *)(lVar10 + -0x108) = param_3;
  *(undefined8 *)(lVar10 + -0x100) = param_4;
  *(code **)(lVar10 + -0xf8) = pcVar9;
  *plVar49 = (long)param_1;
  *(code **)(lVar10 + -8) = param_1;
  if (param_1 == (code *)0x0) {
    return;
  }
  lVar25 = 0;
  puVar26 = (ulong *)(lVar10 + -0x28);
  puVar27 = (ulong *)(lVar10 + -0x30);
LAB_00100e44:
  uVar38 = *(uint *)param_1;
  if (lVar25 == 2) {
    lVar25 = 3;
    *(undefined8 *)(lVar10 + -0x20) = 3;
  }
  if (0x3f < (uVar38 & 0x3f)) goto switchD_00100eb8_caseD_1;
  uVar46 = uVar38 >> 0xb;
  uVar45 = uVar38 & 0x10000000;
  uVar13 = uVar45 >> 0x1a;
  uVar43 = uVar38 & 0x20000000;
  uVar7 = uVar38 >> 0x1a;
  uVar44 = uVar38 & 0x40000000;
  uVar35 = uVar46 & 2 | uVar38 >> 0x1f | uVar46 & 4 | uVar46 & 8 | uVar46 & 0x10;
  uVar36 = (ulong)uVar35;
  uVar46 = uVar43 >> 0x1a;
  uVar32 = (ulong)(uVar38 >> 0x15 & 0x1f);
  uVar29 = (ulong)(uVar38 >> 0x10 & 0x1f);
  uVar4 = uVar38 & 0x80000000;
  uVar5 = uVar38 & 0x4000000;
  uVar6 = uVar38 & 0x8000000;
  uVar28 = uVar44 >> 0x1a;
  uVar14 = uVar13 | uVar7 & 3 | uVar46 | uVar28;
  uVar39 = (ulong)uVar14;
  uVar15 = (ushort)(uVar4 >> 0x10);
  uVar18 = (ushort)(uVar44 >> 0x10);
  uVar19 = (ushort)(uVar43 >> 0x10);
  uVar20 = (ushort)(uVar45 >> 0x10);
  uVar21 = (ushort)(uVar6 >> 0x10);
  uVar22 = (ushort)uVar38;
  uVar23 = (ushort)(uVar5 >> 0x10);
  switch(uVar38 & 0x3f) {
  case 0:
  case 2:
  case 8:
  case 0x12:
  case 0x1f:
  case 0x21:
  case 0x22:
  case 0x27:
  case 0x2b:
  case 0x30:
  case 0x31:
  case 0x33:
  case 0x37:
    if ((uVar38 & 0x3f) < 0x38) {
      puVar2 = (ulong *)(plVar49[uVar32 + 1] +
                        (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                      uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                     uVar15 >> 4));
      switch(uVar38 & 0x3f) {
      case 0:
        uVar32 = (ulong)(short)*puVar2;
        break;
      default:
        goto switchD_00100eb8_caseD_1;
      case 2:
        uVar32 = *puVar2;
        break;
      case 8:
        uVar32 = (ulong)(char)*puVar2;
        break;
      case 0x12:
        uVar38 = (uint)puVar2 & 3;
        uVar32 = (ulong)(*(uint *)(plVar49 + uVar29 + 1) & -1 << (ulong)(uVar38 * -8 + 0x20 & 0x1f)
                        | *(uint *)((ulong)puVar2 & 0xfffffffffffffffc) >> (ulong)(uVar38 * 8));
        break;
      case 0x21:
        uVar32 = (ulong)(byte)*puVar2;
        break;
      case 0x22:
        uVar32 = (plVar49 + uVar29)[1] & -1L << (((ulong)puVar2 & 7) * -8 + 0x40 & 0x3f) |
                 *(ulong *)((ulong)puVar2 & 0xfffffffffffffff8) >> ((ulong)puVar2 & 7) * 8;
        break;
      case 0x27:
      case 0x31:
        uVar32 = (plVar49 + uVar29)[1] & 0xffffffffffffffU >> ((ulong)puVar2 & 7) * 8 |
                 *(long *)((ulong)puVar2 & 0xfffffffffffffff8) <<
                 (((ulong)puVar2 & 7) * -8 + 0x38 & 0x3f);
        break;
      case 0x2b:
        uVar32 = (ulong)(int)(uint)*puVar2;
        break;
      case 0x30:
        uVar32 = (ulong)(ushort)*puVar2;
        break;
      case 0x33:
        uVar32 = (ulong)(uint)*puVar2;
        break;
      case 0x37:
        uVar38 = (uint)puVar2 & 3;
        uVar32 = (ulong)(*(uint *)(plVar49 + uVar29 + 1) & 0xffffffU >> (ulong)(uVar38 * 8) |
                        *(int *)((ulong)puVar2 & 0xfffffffffffffffc) <<
                        (ulong)(uVar38 * -8 + 0x18 & 0x1f));
      }
LAB_00101c8c:
      (plVar49 + uVar29)[1] = uVar32;
    }
    break;
  case 3:
  case 5:
  case 0xf:
  case 0x1a:
  case 0x2c:
  case 0x2d:
  case 0x3a:
  case 0x3f:
    if ((lVar25 != 0) || (0x3c < (uVar38 & 0x3f) - 3)) break;
    iVar34 = 0;
    lVar25 = 0;
    uVar46 = -((uVar38 & 0xf000) >> 0xf) & 0xfffc0000 |
             (uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14
              | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    switch(uVar38 & 0x3f) {
    case 3:
    case 0x1a:
    case 0x2d:
    case 0x3f:
      goto switchD_00100f84_caseD_3;
    default:
      break;
    case 5:
    case 0xf:
    case 0x2c:
    case 0x3a:
      goto switchD_00100f84_caseD_5;
    case 0x11:
      iVar34 = 0x1f;
    case 0x2a:
      bVar37 = 0;
      bVar1 = false;
      bVar41 = 1;
      pcVar47 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar46);
      goto LAB_001016a8;
    }
  case 4:
  case 0x20:
  case 0x38:
  case 0x3e:
    uVar46 = uVar38 & 0x3f;
    uVar38 = uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14 |
             uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14;
    if (uVar46 < 0x38) {
      if (uVar46 == 4) {
        uVar38 = uVar38 << 0x10;
LAB_001015ec:
        uVar32 = (ulong)(int)uVar38;
        goto LAB_00101c8c;
      }
      if (uVar46 == 0x20) {
        *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
             *(ulong *)(lVar10 + -0x130 + uVar32 * 8) & (ulong)uVar38;
      }
    }
    else if (uVar46 == 0x38) {
      *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
           *(ulong *)(lVar10 + -0x130 + uVar32 * 8) ^ (ulong)uVar38;
    }
    else if (uVar46 == 0x3e) {
      *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
           *(ulong *)(lVar10 + -0x130 + uVar32 * 8) | (ulong)uVar38;
    }
    break;
  case 10:
  case 0xb:
  case 0xe:
  case 0x14:
  case 0x16:
  case 0x24:
  case 0x36:
  case 0x3b:
    if (0x31 < (uVar38 & 0x3f) - 10) break;
    plVar3 = (long *)(plVar49[uVar32 + 1] +
                     (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                   uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                  uVar15 >> 4));
    switch(uVar38 & 0x3f) {
    case 10:
      uVar29 = (ulong)plVar49[uVar29 + 1] >> (((ulong)plVar3 & 7) * -8 + 0x38 & 0x3f);
      uVar32 = *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) & -0x100L << ((ulong)plVar3 & 7) * 8;
      goto LAB_00101538;
    case 0xb:
      uVar29 = plVar49[uVar29 + 1] << ((ulong)plVar3 & 7) * 8;
      uVar32 = *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) &
               0xffffffffffffffffU >> (((ulong)plVar3 & 7) * -8 + 0x40 & 0x3f);
LAB_00101538:
      *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) = uVar32 | uVar29;
      break;
    case 0xe:
      *(char *)plVar3 = (char)(int)plVar49[uVar29 + 1];
      break;
    case 0x14:
      *(short *)plVar3 = (short)(int)plVar49[uVar29 + 1];
      break;
    case 0x16:
      uVar38 = (uint)plVar3 & 3;
      uVar46 = *(uint *)(plVar49 + uVar29 + 1) >> (ulong)(uVar38 * -8 + 0x18 & 0x1f);
      uVar38 = *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) & -0x100 << (ulong)(uVar38 * 8);
      goto LAB_001015bc;
    case 0x24:
      uVar38 = (uint)plVar3 & 3;
      uVar46 = (int)plVar49[uVar29 + 1] << (ulong)(uVar38 * 8);
      uVar38 = *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) &
               0xffffffffU >> (ulong)(uVar38 * -8 + 0x20 & 0x1f);
LAB_001015bc:
      *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) = uVar38 | uVar46;
      break;
    case 0x36:
      *(int *)plVar3 = (int)plVar49[uVar29 + 1];
      break;
    case 0x3b:
      *plVar3 = plVar49[uVar29 + 1];
    }
    break;
  case 0xd:
  case 0x15:
  case 0x1b:
  case 0x28:
    uVar46 = uVar38 & 0x3f;
    uVar15 = uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f | uVar21 >> 4 |
             uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 | uVar15 >> 4;
    if ((uVar46 == 0xd) || (uVar46 == 0x28)) {
      *(long *)(lVar10 + -0x130 + uVar29 * 8) =
           *(long *)(lVar10 + -0x130 + uVar32 * 8) + (long)(short)uVar15;
    }
    else if (uVar46 == 0x15) {
      *(long *)(lVar10 + -0x130 + uVar29 * 8) =
           (long)*(int *)(lVar10 + -0x130 + uVar32 * 8) + (long)(int)(short)uVar15;
    }
    break;
  case 0x10:
    uVar45 = uVar38 & 0xfff;
    if (0xa4f < uVar45) {
      if (uVar45 < 0xe90) {
        if (uVar45 == 0xa50) {
LAB_00101918:
          if ((uint)uVar39 <= (uint)uVar36) {
            lVar25 = lVar10 + -0x130;
            uVar48 = *(ulong *)(lVar25 + uVar29 * 8);
            *(ulong *)(lVar25 + uVar29 * 8) =
                 uVar48 & -1L << uVar36 |
                 (*(ulong *)(lVar25 + uVar32 * 8) &
                 (-1L << ((ulong)(((uint)uVar36 + 1) - (uint)uVar39) & 0x3f) ^ 0xffffffffffffffffU))
                 << uVar39 | uVar48 & (-1L << uVar39 ^ 0xffffffffffffffffU);
          }
        }
        else if ((uVar45 == 0xad0) && (uVar14 <= uVar35)) {
          lVar25 = lVar10 + -0x130;
          uVar38 = *(uint *)(lVar25 + uVar29 * 8);
          *(long *)(lVar25 + uVar29 * 8) =
               (long)(int)(uVar38 & -1 << (ulong)uVar35 |
                           (*(uint *)(lVar25 + uVar32 * 8) &
                           (-1 << (ulong)((1 - uVar14) + uVar35 & 0x1f) ^ 0xffffffffU)) <<
                           (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) |
                          uVar38 & (-1 << (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) ^
                                   0xffffffffU));
        }
      }
      else {
        if (uVar45 != 0xe90) {
          if (uVar45 == 0xed0) {
            uVar39 = (ulong)(uVar14 | 0x20);
          }
          else {
            if (uVar45 != 0xf90) break;
            uVar35 = uVar35 | 0x20;
          }
        }
        if ((int)uVar39 + uVar35 < 0x40) {
          uVar32 = plVar49[uVar32 + 1];
          if (uVar35 != 0x3f) {
            uVar32 = uVar32 >> uVar39 & (-1L << ((ulong)(uVar35 + 1) & 0x3f) ^ 0xffffffffffffffffU);
          }
          goto LAB_00101c8c;
        }
      }
      break;
    }
    if (uVar45 < 0x290) {
      if (uVar45 == 0x10) {
        if (uVar35 + uVar14 < 0x20) {
          uVar38 = *(uint *)(plVar49 + uVar32 + 1);
          if (uVar35 != 0x1f) {
            uVar38 = uVar38 >> (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) &
                     (-2 << (ulong)uVar35 ^ 0xffffffffU);
          }
          goto LAB_001015ec;
        }
      }
      else if (uVar45 == 0x90) {
        uVar39 = (ulong)(uVar14 | 0x20);
        goto LAB_001018a4;
      }
      break;
    }
    if ((uVar45 != 0x290) && (uVar45 != 0x690)) {
      if (uVar45 == 0x8d0) {
LAB_001018a4:
        uVar36 = (ulong)(uVar35 | 0x20);
        goto LAB_00101918;
      }
      break;
    }
    uVar38 = uVar38 & 0x7c000fff;
    if (uVar38 < 0x4c000290) {
      if (uVar38 == 0xc000690) {
        uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        uVar29 = (uVar29 & 0xffff0000ffff) << 0x10 | uVar29 >> 0x10 & 0xffff0000ffff;
        *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> 0x20 | uVar29 << 0x20;
      }
      else if (uVar38 == 0x38000290) {
        *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)*(char *)(lVar10 + -0x130 + uVar29 * 8);
      }
      break;
    }
    if (uVar38 == 0x4c000290) {
      *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)*(short *)(lVar10 + -0x130 + uVar29 * 8);
      break;
    }
    if (uVar38 == 0x54000690) {
      uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
      *(ulong *)(lVar10 + -0x130 + uVar36 * 8) =
           (uVar29 & 0xff00ff00ff00ff) << 8 | uVar29 >> 8 & 0xff00ff00ff00ff;
      break;
    }
    if (uVar38 != 0x74000290) break;
    uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
    uVar38 = (uVar38 & 0xff00ff) << 8 | uVar38 >> 8 & 0xff00ff;
    goto LAB_00102398;
  case 0x11:
  case 0x2a:
    if (lVar25 != 0) break;
    uVar46 = uVar38 & 0x3f;
    uVar38 = (uVar38 & 0x3fff000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 |
              uVar45 >> 0x14 | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    if (uVar46 == 0x11) {
      uVar28 = 0x1f;
LAB_00101728:
      bVar1 = false;
      bVar24 = false;
      pcVar47 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar38);
      bVar42 = true;
    }
    else {
      if (uVar46 == 0x2a) {
        uVar28 = 0;
        goto LAB_00101728;
      }
      if (uVar46 != 0x1a) break;
      lVar25 = plVar49[uVar32 + 1];
      bVar1 = lVar25 < 1;
      uVar28 = 0;
      bVar42 = 0 < lVar25;
      pcVar47 = param_1 + (long)(int)uVar38 + 4;
      if (lVar25 < 1) {
        pcVar47 = param_1 + 8;
      }
      bVar24 = true;
    }
    *(code **)(lVar10 + -0x18) = pcVar47;
    if ((((bool)(bVar1 & bVar24)) || (!bVar24)) || ((bool)(bVar42 & bVar24))) {
      uVar8 = 1;
      if (!(bool)(bVar1 & bVar24)) {
        uVar8 = 2;
      }
      *(undefined8 *)(lVar10 + -0x20) = uVar8;
    }
    goto joined_r0x001026a8;
  case 0x17:
    uVar46 = uVar38 & 0x1f003f;
    uVar28 = uVar46 - 0x10017 >> 0x10;
    if (((0x1a < (uVar28 | (uVar46 - 0x10017) * 0x10000)) ||
        ((1 << (ulong)(uVar28 & 0x1f) & 0x4842861U) == 0)) || (lVar25 != 0)) break;
    uVar38 = -((uVar38 & 0xf000) >> 0xf) & 0xfffc0000 |
             (uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14
              | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    if (0x10016 < uVar46) {
      if (uVar46 < 0xe0017) {
        if (uVar46 < 0x70017) {
          if ((uVar46 == 0x10017) || (uVar46 == 0x60017)) {
switchD_00101294_caseD_3:
            pcVar47 = (code *)0x0;
            goto switchD_00101294_caseD_5;
          }
        }
        else if ((uVar46 == 0x70017) || (uVar46 == 0xc0017)) goto switchD_00101294_caseD_3;
      }
      else if (uVar46 < 0x180017) {
        if ((uVar46 == 0xe0017) || (uVar46 == 0x130017)) goto switchD_00101294_caseD_3;
      }
      else if ((uVar46 == 0x1b0017) || (uVar46 == 0x180017)) goto switchD_00101294_caseD_3;
      break;
    }
    iVar34 = 0;
    pcVar47 = param_1;
    switch(uVar46) {
    case 3:
    case 0x1a:
    case 0x2d:
    case 0x3f:
      goto switchD_00101294_caseD_3;
    default:
      goto switchD_00100eb8_caseD_1;
    case 5:
    case 0xf:
    case 0x2c:
    case 0x3a:
switchD_00101294_caseD_5:
      pcVar40 = (code *)plVar49[uVar32 + 1];
      pcVar30 = param_1 + (int)(uVar38 + 4);
      if (0x10016 < uVar46) {
        if (uVar46 < 0xe0017) {
          if (uVar46 < 0x70017) {
            if (uVar46 == 0x10017) {
              if (-1 < (long)pcVar40) goto LAB_00101fb4;
              goto LAB_001012e8;
            }
            if (uVar46 != 0x60017) goto switchD_00100eb8_caseD_1;
            iVar34 = 0x1f;
            if ((long)pcVar40 < 0) {
LAB_00101c18:
              iVar34 = 0x1f;
              bVar1 = false;
              goto LAB_00101f70;
            }
            goto LAB_00101fb8;
          }
          if (uVar46 == 0x70017) {
            if ((long)pcVar40 < 0) goto LAB_00101f68;
            goto LAB_00101f94;
          }
          if (uVar46 == 0xc0017) {
            iVar34 = 0x1f;
            if (-1 < (long)pcVar40) goto LAB_00101c18;
            goto LAB_00101fb8;
          }
          goto switchD_00100eb8_caseD_1;
        }
        if (0x180016 < uVar46) {
          if (uVar46 == 0x180017) {
            if (-1 < (long)pcVar40) goto LAB_00101f68;
            goto LAB_00101f94;
          }
          if (uVar46 == 0x1b0017) {
            iVar34 = 0x1f;
            bVar1 = true;
            if ((long)pcVar40 < 0) goto LAB_00102018;
            goto LAB_00101fbc;
          }
          goto switchD_00100eb8_caseD_1;
        }
        if (uVar46 != 0xe0017) {
          if (uVar46 == 0x130017) {
            if ((long)pcVar40 < 0) goto LAB_00101fb4;
            goto LAB_001012e8;
          }
          goto switchD_00100eb8_caseD_1;
        }
        iVar34 = 0x1f;
        bVar1 = true;
        if ((long)pcVar40 < 0) goto LAB_00101fbc;
LAB_00102018:
        bVar1 = true;
        iVar34 = 0x1f;
        goto LAB_00101f70;
      }
      break;
    case 0x11:
      iVar34 = 0x1f;
    case 0x2a:
      bVar1 = false;
      pcVar30 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar38);
      goto LAB_00101f70;
    }
    switch(uVar46) {
    case 3:
      if (0 < (long)pcVar40) break;
LAB_00101fb4:
      iVar34 = 0;
LAB_00101fb8:
      bVar1 = false;
      goto LAB_00101fbc;
    default:
      goto switchD_00100eb8_caseD_1;
    case 5:
      if (pcVar40 == pcVar47) goto LAB_00101fb4;
      break;
    case 0xf:
      if (pcVar40 != pcVar47) goto LAB_00101fb4;
      break;
    case 0x1a:
      if ((long)pcVar40 < 1) goto LAB_00101f94;
LAB_00101f68:
      bVar1 = true;
      goto LAB_00101f6c;
    case 0x2c:
      if (pcVar40 == pcVar47) goto LAB_00101f68;
      goto LAB_00101f94;
    case 0x2d:
      if ((long)pcVar40 < 1) goto LAB_00101f68;
      goto LAB_00101f94;
    case 0x3a:
      if (pcVar40 != pcVar47) goto LAB_00101f68;
LAB_00101f94:
      bVar1 = true;
      iVar34 = 0;
LAB_00101fbc:
      bVar42 = false;
      pcVar30 = param_1 + 8;
      bVar37 = 1;
      goto LAB_00101fc8;
    case 0x3f:
      if (0 < (long)pcVar40) goto LAB_00101fb4;
    }
LAB_001012e8:
    bVar1 = false;
LAB_00101f6c:
    iVar34 = 0;
LAB_00101f70:
    bVar37 = 0;
    bVar42 = true;
LAB_00101fc8:
    *(code **)(lVar10 + -0x18) = pcVar30;
    if ((((bool)(bVar37 & bVar1)) || (!bVar1)) || (bVar42)) {
      uVar8 = 1;
      if (!(bool)(bVar37 & bVar1)) {
        uVar8 = 2;
      }
      *(undefined8 *)(lVar10 + -0x20) = uVar8;
    }
    goto joined_r0x00101ffc;
  case 0x23:
    *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
         (ulong)(*(ulong *)(lVar10 + -0x130 + uVar32 * 8) <
                (ulong)(long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                     uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                    uVar15 >> 4));
    break;
  case 0x29:
    uVar28 = (uVar38 & 0xfff) - 0x1a9;
    uVar46 = uVar28 >> 6;
    uVar28 = uVar46 | uVar28 * 0x4000000;
    if (0x1a < uVar28) break;
    if ((1 << (ulong)(uVar46 & 0x1f) & 0x4000032U) != 0) {
      uVar46 = uVar38 & 0xfff;
      if (uVar46 < 0x76f) {
        if (uVar46 < 0x2e9) {
          if (uVar46 == 0x1af) goto LAB_001024b0;
          if (uVar46 == 0x1e9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00101eb0;
          }
          if (uVar46 == 0x2a9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00101e88;
          }
        }
        else {
          if (uVar46 == 0x2e9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00101eb0:
            uVar29 = CONCAT44(uVar11,uVar12) - uVar29 * uVar32;
LAB_00101eb8:
            uVar36 = uVar29 & 0xffffffff;
            uVar29 = uVar29 >> 0x20;
            goto LAB_001024d0;
          }
          if (uVar46 == 0x52f) {
LAB_00102480:
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = 0;
            if (uVar46 != 0) {
              uVar28 = uVar38 / uVar46;
            }
            goto LAB_00102498;
          }
joined_r0x00102438:
          if ((uVar38 & 0xfff) == 0x72f) {
            uVar32 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
            uVar36 = SUB168(SEXT816((long)uVar29) * SEXT816((long)uVar32),8);
            goto LAB_00102554;
          }
        }
      }
      else if (uVar46 < 0x92f) {
        if (uVar46 != 0x76f) {
          if (uVar46 != 0x829) goto joined_r0x0010253c;
          uVar11 = *(undefined4 *)puVar26;
          uVar12 = *(undefined4 *)puVar27;
          uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00101e88:
          uVar29 = CONCAT44(uVar11,uVar12) + uVar29 * uVar32;
          goto LAB_00101eb8;
        }
LAB_00102544:
        uVar32 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
        uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        auVar16._8_8_ = 0;
        auVar16._0_8_ = uVar29;
        auVar17._8_8_ = 0;
        auVar17._0_8_ = uVar32;
        uVar36 = SUB168(auVar16 * auVar17,8);
LAB_00102554:
        *puVar27 = uVar29 * uVar32;
        *puVar26 = uVar36;
      }
      else {
        if (uVar46 == 0x92f) {
LAB_001020e8:
          uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
          goto LAB_001024c4;
        }
        if (uVar46 == 0xb2f) goto LAB_00102510;
        if (uVar46 == 0xdaf) goto LAB_00101a88;
      }
      break;
    }
    if (uVar28 != 2) break;
    uVar46 = uVar38 & 0xfff;
    if (uVar46 < 0x86f) {
      if (uVar46 < 0x3af) {
        if (uVar46 != 0x1ef) goto LAB_00101bc8;
        goto LAB_00101d6c;
      }
      goto LAB_00101d90;
    }
    if (0x9ee < uVar46) goto LAB_001013e4;
LAB_00101868:
    if ((uVar38 & 0xfff) != 0x86f) {
      if ((uVar38 & 0xfff) == 0x96f) goto LAB_00101878;
      break;
    }
LAB_00101d0c:
    uVar38 = *(int *)(lVar10 + -0x130 + uVar32 * 8) - *(int *)(lVar10 + -0x130 + uVar29 * 8);
    goto LAB_00101d84;
  case 0x2f:
    uVar45 = uVar38 & 0xfff;
    switch(uVar45 - 0x6f >> 6 | (uVar45 - 0x6f) * 0x4000000) {
    case 0:
    case 3:
    case 9:
    case 0xf:
    case 0x2e:
    case 0x3d:
      break;
    case 1:
    case 0xb:
    case 0x34:
      uVar46 = 0x400032f;
      if ((uVar38 & 0x4000fff) != 0x400032f) {
        uVar46 = uVar45;
      }
      goto LAB_00102190;
    case 2:
      lVar25 = lVar10 + -0x130;
      puVar31 = (undefined8 *)(lVar25 + uVar36 * 8);
      if (*(ulong *)(lVar25 + uVar29 * 8) <= *(ulong *)(lVar25 + uVar32 * 8)) goto LAB_001020b0;
LAB_00102298:
      *puVar31 = 1;
      break;
    default:
      if (0x92e < uVar45) {
        if (uVar45 < 0xdaf) {
          if (uVar45 < 0xb2f) {
            if (uVar45 == 0x92f) goto LAB_001020e8;
            if (uVar45 == 0x9af) {
              uVar29 = *puVar27;
              goto LAB_001026b4;
            }
          }
          else if (uVar45 == 0xb2f) {
LAB_00102510:
            uVar36 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
            uVar32 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
            uVar29 = 0;
            if (uVar32 != 0) {
              uVar29 = (long)uVar36 / (long)uVar32;
            }
LAB_00102520:
            *puVar26 = uVar36 - uVar29 * uVar32;
            *puVar27 = uVar29;
          }
          else if (uVar45 == 0xcef) {
            *puVar26 = plVar49[uVar32 + 1];
          }
        }
        else if (uVar45 < 0xe2f) {
          if (uVar45 == 0xdaf) {
LAB_00101a88:
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = 0;
            if (uVar46 != 0) {
              uVar28 = (int)uVar38 / (int)uVar46;
            }
LAB_00102498:
            *puVar26 = (long)(int)(uVar38 - uVar28 * uVar46);
            *puVar27 = (long)(int)uVar28;
          }
          else if (uVar45 == 0xdef) {
            *puVar27 = plVar49[uVar32 + 1];
          }
        }
        else if (uVar45 == 0xe2f) {
          uVar29 = *puVar26;
LAB_001026b4:
          plVar49[uVar36 + 1] = uVar29;
        }
        else if ((uVar45 == 0xeaf) && (plVar49[uVar29 + 1] != 0)) goto LAB_0010264c;
        break;
      }
      if (uVar45 < 0x6af) {
        if (uVar45 == 0x1af) {
LAB_001024b0:
          uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
LAB_001024c4:
          uVar36 = (ulong)(int)(uVar29 * uVar32);
          uVar29 = (long)(uVar29 * uVar32) >> 0x20;
LAB_001024d0:
          *puVar27 = uVar36;
          *puVar26 = uVar29;
        }
        else if (uVar45 == 0x4ef) {
          if (plVar49[uVar29 + 1] == 0) {
LAB_0010264c:
            *(undefined8 *)(lVar10 + -0x130 + uVar36 * 8) =
                 *(undefined8 *)(lVar10 + -0x130 + uVar32 * 8);
          }
        }
        else if (uVar45 == 0x52f) goto LAB_00102480;
        break;
      }
      if (0x76e < uVar45) {
        if (uVar45 == 0x76f) goto LAB_00102544;
joined_r0x0010253c:
        if ((uVar38 & 0xfff) == 0x8af) {
          uVar36 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
          uVar32 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar29 = 0;
          if (uVar32 != 0) {
            uVar29 = uVar36 / uVar32;
          }
          goto LAB_00102520;
        }
        break;
      }
      if (uVar45 != 0x6af) goto joined_r0x00102438;
      if (lVar25 != 0) break;
      lVar25 = plVar49[uVar32 + 1];
      param_1 = param_1 + 4;
      *(undefined8 *)(lVar10 + -0x20) = 2;
      *(long *)(lVar10 + -0x18) = lVar25;
      *plVar49 = (long)param_1;
      if (param_1 == (code *)0x0) {
        return;
      }
      goto LAB_00100e40;
    case 6:
    case 0xd:
    case 0x1a:
    case 0x20:
    case 0x24:
    case 0x26:
    case 0x28:
    case 0x33:
      uVar46 = uVar38 & 0xfff;
      if (uVar46 < 0x86f) {
        if (uVar46 < 0x3af) {
          if (uVar46 == 0x1ef) {
LAB_00101d6c:
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) + *(int *)(lVar10 + -0x130 + uVar32 * 8)
            ;
            goto LAB_00101d84;
          }
LAB_00101bc8:
          if ((uVar38 & 0xfff) == 0x229) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 (long)*(int *)(lVar25 + uVar29 * 8) * (long)*(int *)(lVar25 + uVar32 * 8);
          }
        }
        else {
LAB_00101d90:
          if (((uVar38 & 0xfff) == 0x3af) || ((uVar38 & 0xfff) == 0x6ef)) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 *(long *)(lVar25 + uVar32 * 8) - *(long *)(lVar25 + uVar29 * 8);
          }
        }
      }
      else {
        if (uVar46 < 0x9ef) goto LAB_00101868;
LAB_001013e4:
        uVar38 = uVar38 & 0xfff;
        if (uVar38 == 0x9ef) {
LAB_00101878:
          lVar25 = lVar10 + -0x130;
          *(long *)(lVar25 + uVar36 * 8) =
               *(long *)(lVar25 + uVar29 * 8) + *(long *)(lVar25 + uVar32 * 8);
        }
        else {
          if (uVar38 == 0xa6f) goto LAB_00101d0c;
          if (uVar38 == 0xd2f) goto LAB_00101d6c;
        }
      }
      break;
    case 10:
    case 0x30:
      goto switchD_001013cc_caseD_a;
    case 0xc:
    case 0x17:
    case 0x1f:
    case 0x3c:
      uVar38 = uVar38 & 0xfff;
      if (uVar38 < 0x82f) {
        if (uVar38 == 0x36f) {
          lVar25 = lVar10 + -0x130;
          *(ulong *)(lVar25 + uVar36 * 8) =
               *(ulong *)(lVar25 + uVar29 * 8) ^ *(ulong *)(lVar25 + uVar32 * 8);
        }
        else if (uVar38 == 0x62f) {
          lVar25 = lVar10 + -0x130;
          *(ulong *)(lVar25 + uVar36 * 8) =
               *(ulong *)(lVar25 + uVar29 * 8) | *(ulong *)(lVar25 + uVar32 * 8);
        }
      }
      else if (uVar38 == 0x82f) {
        lVar25 = lVar10 + -0x130;
        *(ulong *)(lVar25 + uVar36 * 8) =
             ~(*(ulong *)(lVar25 + uVar29 * 8) | *(ulong *)(lVar25 + uVar32 * 8));
      }
      else if (uVar38 == 0xf6f) {
        lVar25 = lVar10 + -0x130;
        *(ulong *)(lVar25 + uVar36 * 8) =
             *(ulong *)(lVar25 + uVar29 * 8) & *(ulong *)(lVar25 + uVar32 * 8);
      }
      break;
    case 0xe:
    case 0x10:
    case 0x22:
    case 0x2c:
    case 0x31:
      uVar43 = 0x2008ef;
      if ((uVar38 & 0x200fff) != 0x2008ef) {
        uVar43 = uVar45;
      }
      goto LAB_00101ab4;
    case 0x15:
      if (lVar25 != 0) break;
      uVar46 = uVar38 & 0xfff;
      uVar28 = 0;
      lVar25 = 0;
      switch(uVar46) {
      case 3:
      case 0x1a:
      case 0x2d:
      case 0x3f:
        goto switchD_00102130_caseD_3;
      case 4:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 0xb:
      case 0xc:
      case 0xd:
      case 0xe:
      case 0x10:
      case 0x12:
      case 0x13:
      case 0x14:
      case 0x15:
      case 0x16:
      case 0x17:
      case 0x18:
      case 0x19:
      case 0x1b:
      case 0x1c:
      case 0x1d:
      case 0x1e:
      case 0x1f:
      case 0x20:
      case 0x21:
      case 0x22:
      case 0x23:
      case 0x24:
      case 0x25:
      case 0x26:
      case 0x27:
      case 0x28:
      case 0x29:
      case 0x2b:
      case 0x2e:
      case 0x2f:
      case 0x30:
      case 0x31:
      case 0x32:
      case 0x33:
      case 0x34:
      case 0x35:
      case 0x36:
      case 0x37:
      case 0x38:
      case 0x39:
      case 0x3b:
      case 0x3c:
      case 0x3d:
      case 0x3e:
        break;
      case 5:
      case 0xf:
      case 0x2c:
      case 0x3a:
        goto switchD_00102130_caseD_5;
      case 0x11:
        uVar28 = 0x1f;
      case 0x2a:
        bVar1 = false;
        pcVar47 = (code *)(*(long *)(lVar10 + -8) + uVar39);
        goto LAB_00102670;
      default:
        if ((uVar46 != 0x5af) && (uVar35 = uVar28, uVar46 != 0x6af)) break;
        uVar28 = uVar35;
        pcVar47 = (code *)plVar49[uVar32 + 1];
        bVar1 = false;
        goto LAB_00102670;
      }
    case 0x16:
    case 0x3e:
      goto switchD_001013cc_caseD_16;
    case 0x18:
      uVar46 = uVar45;
LAB_00102190:
      uVar45 = 0x400066f;
      if ((uVar38 & 0x4000fff) != 0x400066f) {
        uVar45 = uVar46;
      }
switchD_001013cc_caseD_16:
      if (uVar45 < 0xd6f) {
        if (uVar45 < 0x5ef) {
          if (uVar45 == 0xaf) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 *(long *)(lVar25 + uVar29 * 8) >> (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
          }
          else if (uVar45 == 0x32f) {
            lVar25 = lVar10 + -0x130;
            *(ulong *)(lVar25 + uVar36 * 8) =
                 *(ulong *)(lVar25 + uVar29 * 8) >> (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
          }
        }
        else {
          if (uVar45 == 0x5ef) {
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          }
          else {
            if (uVar45 != 0x66f) break;
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (ulong)(*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          }
LAB_00101d84:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)(int)uVar38;
        }
      }
      else if (uVar45 < 0x400032f) {
        if (uVar45 == 0xd6f) {
          lVar25 = lVar10 + -0x130;
          *(long *)(lVar25 + uVar36 * 8) =
               *(long *)(lVar25 + uVar29 * 8) << (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
        }
        else if (uVar45 == 0xfef) {
          uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) <<
                   (ulong)(*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          goto LAB_00101d84;
        }
      }
      else if (uVar45 == 0x400032f) {
        lVar25 = lVar10 + -0x130;
        uVar29 = *(ulong *)(lVar25 + uVar29 * 8);
        uVar32 = (ulong)(*(uint *)(lVar25 + uVar32 * 8) & 0x3f);
        *(ulong *)(lVar25 + uVar36 * 8) = uVar29 >> uVar32 | uVar29 << 0x40 - uVar32;
      }
      else if (uVar45 == 0x400066f) {
        uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
        uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f;
        uVar38 = uVar46 >> uVar38 | uVar46 << 0x20 - uVar38;
        goto LAB_00101d84;
      }
      break;
    case 0x29:
      lVar25 = lVar10 + -0x130;
      puVar31 = (undefined8 *)(lVar25 + uVar36 * 8);
      if (*(long *)(lVar25 + uVar32 * 8) < *(long *)(lVar25 + uVar29 * 8)) goto LAB_00102298;
LAB_001020b0:
      *puVar31 = 0;
      break;
    case 0x2d:
      uVar44 = uVar45;
      goto LAB_00101ac0;
    case 0x3b:
      uVar43 = uVar45;
LAB_00101ab4:
      uVar44 = 0x200f2f;
      if ((uVar38 & 0x200fff) != 0x200f2f) {
        uVar44 = uVar43;
      }
LAB_00101ac0:
      uVar45 = 0x200baf;
      if ((uVar38 & 0x200fff) != 0x200baf) {
        uVar45 = uVar44;
      }
switchD_001013cc_caseD_a:
      if (uVar45 < 0xc6f) {
        if (uVar45 < 0x8ef) {
          if (uVar45 == 0x2ef) {
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (uVar13 | uVar7 & 3 | uVar46 | uVar28);
            goto LAB_00102398;
          }
          if (uVar45 == 0x3ef) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            uVar39 = (ulong)(uVar14 | 0x20);
LAB_00102368:
            *(long *)(lVar10 + -0x130 + uVar36 * 8) = lVar25 >> uVar39;
          }
          else if (uVar45 == 0x46f) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00102340;
          }
        }
        else if (uVar45 == 0x8ef) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00102354:
          *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> uVar39;
        }
        else {
          if (uVar45 == 0xb6f) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00102368;
          }
          if (uVar45 == 0xbaf) {
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28);
            goto LAB_00102398;
          }
        }
      }
      else if (uVar45 < 0x2008ef) {
        if (uVar45 == 0xc6f) {
          uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) <<
                   (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28);
LAB_00102398:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)(int)uVar38;
        }
        else if (uVar45 == 0xcaf) {
          lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
LAB_00102340:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = lVar25 << uVar39;
        }
        else if (uVar45 == 0xf2f) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
          goto LAB_00102354;
        }
      }
      else {
        if (uVar45 == 0x2008ef) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        }
        else {
          if (uVar45 == 0x200baf) {
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = uVar13 | uVar7 & 3 | uVar46 | uVar28;
            uVar38 = uVar38 >> uVar28 | uVar38 << 0x20 - uVar28;
            goto LAB_00102398;
          }
          if (uVar45 != 0x200f2f) break;
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
        }
        *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> uVar39 | uVar29 << 0x40 - uVar39;
      }
    }
    break;
  case 0x32:
    *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
         (ulong)(*(long *)(lVar10 + -0x130 + uVar32 * 8) <
                (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                              uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 | uVar15 >> 4));
  }
switchD_00100eb8_caseD_1:
  lVar25 = *(long *)(lVar10 + -0x20);
  param_1 = (code *)(*plVar49 + 4);
  *plVar49 = (long)param_1;
  if (lVar25 != 2) {
    if ((lVar25 == 3) || (lVar25 == 1)) {
      param_1 = *(code **)(lVar10 + -0x18);
      *(undefined8 *)(lVar10 + -0x20) = 0;
      *plVar49 = (long)param_1;
    }
    if (param_1 == pcVar9) {
      (*pcVar9)(*(undefined8 *)(lVar10 + -0x110),*(undefined8 *)(lVar10 + -0x108));
      param_1 = *(code **)(lVar10 + -0x10);
      *plVar49 = (long)param_1;
    }
  }
  if (param_1 == (code *)0x0) {
    return;
  }
LAB_00100e40:
  lVar25 = *(long *)(lVar10 + -0x20);
  goto LAB_00100e44;
switchD_00102130_caseD_5:
  lVar25 = plVar49[uVar36 + 1];
switchD_00102130_caseD_3:
  if (0x3c < (uVar38 & 0xfff) - 3) goto switchD_00100eb8_caseD_1;
  lVar33 = plVar49[uVar32 + 1];
  pcVar47 = param_1 + (uVar14 + 4);
  switch(uVar38 & 0xfff) {
  case 3:
    if (lVar33 < 1) {
LAB_00102604:
      bVar1 = false;
      goto LAB_00102608;
    }
    break;
  default:
    goto switchD_00100eb8_caseD_1;
  case 5:
    if (lVar33 == lVar25) goto LAB_00102604;
    break;
  case 0xf:
    if (lVar33 != lVar25) goto LAB_00102604;
    break;
  case 0x1a:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_00102608;
LAB_001025f0:
    bVar1 = true;
    goto LAB_001025f4;
  case 0x2c:
    bVar1 = true;
    if (lVar33 == lVar25) goto LAB_001025f0;
    goto LAB_00102608;
  case 0x2d:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_001025f0;
    goto LAB_00102608;
  case 0x3a:
    bVar1 = true;
    if (lVar33 != lVar25) goto LAB_001025f0;
LAB_00102608:
    bVar37 = 0;
    uVar28 = 0;
    pcVar47 = param_1 + 8;
    bVar41 = 1;
    goto LAB_00102674;
  case 0x3f:
    if (0 < lVar33) goto LAB_00102604;
  }
  bVar1 = false;
LAB_001025f4:
  uVar28 = 0;
LAB_00102670:
  bVar41 = 0;
  bVar37 = 1;
LAB_00102674:
  *(code **)(lVar10 + -0x18) = pcVar47;
  if ((((bool)(bVar41 & bVar1)) || (!bVar1)) || ((bool)(bVar37 & bVar1))) {
    uVar8 = 1;
    if (!(bool)(bVar41 & bVar1)) {
      uVar8 = 2;
    }
    *(undefined8 *)(lVar10 + -0x20) = uVar8;
  }
joined_r0x001026a8:
  if (uVar28 != 0) {
    plVar49[(long)(int)uVar28 + 1] = (long)(param_1 + 8);
    *(code **)(lVar10 + -0x10) = param_1 + 8;
  }
  goto switchD_00100eb8_caseD_1;
switchD_00100f84_caseD_5:
  lVar25 = plVar49[uVar29 + 1];
switchD_00100f84_caseD_3:
  if (0x3c < (uVar38 & 0x3f) - 3) goto switchD_00100eb8_caseD_1;
  lVar33 = plVar49[uVar32 + 1];
  pcVar47 = param_1 + (int)(uVar46 + 4);
  switch(uVar38 & 0x3f) {
  case 3:
    if (lVar33 < 1) {
LAB_00101694:
      bVar1 = false;
      goto LAB_00101698;
    }
    break;
  default:
    goto switchD_00100eb8_caseD_1;
  case 5:
    if (lVar33 == lVar25) goto LAB_00101694;
    break;
  case 0xf:
    if (lVar33 != lVar25) goto LAB_00101694;
    break;
  case 0x1a:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_00101698;
LAB_0010167c:
    bVar1 = true;
    goto LAB_00101680;
  case 0x2c:
    bVar1 = true;
    if (lVar33 == lVar25) goto LAB_0010167c;
    goto LAB_00101698;
  case 0x2d:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_0010167c;
    goto LAB_00101698;
  case 0x3a:
    bVar1 = true;
    if (lVar33 != lVar25) goto LAB_0010167c;
LAB_00101698:
    bVar41 = 0;
    iVar34 = 0;
    pcVar47 = param_1 + 8;
    bVar37 = 1;
    goto LAB_001016a8;
  case 0x3f:
    if (0 < lVar33) goto LAB_00101694;
  }
  bVar1 = false;
LAB_00101680:
  bVar37 = 0;
  iVar34 = 0;
  bVar41 = 1;
LAB_001016a8:
  *(code **)(lVar10 + -0x18) = pcVar47;
  if ((((bool)(bVar37 & bVar1)) || (!bVar1)) || ((bool)(bVar41 & bVar1))) {
    uVar8 = 1;
    if (!(bool)(bVar37 & bVar1)) {
      uVar8 = 2;
    }
    *(undefined8 *)(lVar10 + -0x20) = uVar8;
  }
joined_r0x00101ffc:
  if (iVar34 != 0) {
    plVar49[(long)iVar34 + 1] = (long)(param_1 + 8);
    *(code **)(lVar10 + -0x10) = param_1 + 8;
  }
  goto switchD_00100eb8_caseD_1;
}



// ===== FUN_001026e0 @ 001026e0 size=892 =====

void FUN_001026e0(uint *param_1,uint *param_2)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  long lVar5;
  uint *puVar6;
  ulong uVar7;
  long lVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  
  uVar9 = (*param_2 & 0xff00ff00) >> 8 | (*param_2 & 0xff00ff) << 8;
  uVar9 = *param_1 ^ (uVar9 >> 0x10 | uVar9 << 0x10);
  uVar10 = (param_2[1] & 0xff00ff00) >> 8 | (param_2[1] & 0xff00ff) << 8;
  uVar10 = param_1[1] ^ (uVar10 >> 0x10 | uVar10 << 0x10);
  uVar11 = (param_2[2] & 0xff00ff00) >> 8 | (param_2[2] & 0xff00ff) << 8;
  uVar4 = (param_2[3] & 0xff00ff00) >> 8 | (param_2[3] & 0xff00ff) << 8;
  uVar7 = *(ulong *)(param_1 + 0x78) >> 1;
  uVar11 = param_1[2] ^ (uVar11 >> 0x10 | uVar11 << 0x10);
  lVar5 = uVar7 * 8;
  puVar6 = param_1 + 6;
  uVar4 = param_1[3] ^ (uVar4 >> 0x10 | uVar4 << 0x10);
  lVar8 = -uVar7;
  while( true ) {
    lVar8 = lVar8 + 1;
    uVar1 = *(uint *)(&DAT_00108d70 + (ulong)(uVar10 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00108970 + (ulong)(uVar9 >> 0x18) * 4) ^
            *(uint *)(&DAT_00109170 + (ulong)(uVar11 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_00109570 + (ulong)(uVar4 & 0xff) * 4) ^ puVar6[-2];
    uVar2 = *(uint *)(&DAT_00108d70 + (ulong)(uVar11 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00108970 + (ulong)(uVar10 >> 0x18) * 4) ^
            *(uint *)(&DAT_00109170 + (ulong)(uVar4 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_00109570 + (ulong)(uVar9 & 0xff) * 4) ^ puVar6[-1];
    uVar3 = *(uint *)(&DAT_00108d70 + (ulong)(uVar4 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00108970 + (ulong)(uVar11 >> 0x18) * 4) ^
            *(uint *)(&DAT_00109170 + (ulong)(uVar9 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_00109570 + (ulong)(uVar10 & 0xff) * 4) ^ *puVar6;
    uVar4 = *(uint *)(&DAT_00108d70 + (ulong)(uVar9 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00108970 + (ulong)(uVar4 >> 0x18) * 4) ^
            *(uint *)(&DAT_00109170 + (ulong)(uVar10 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_00109570 + (ulong)(uVar11 & 0xff) * 4) ^ puVar6[1];
    if (lVar8 == 0) break;
    uVar9 = *(uint *)(&DAT_00108d70 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00108970 + (ulong)(uVar1 >> 0x18) * 4) ^
            *(uint *)(&DAT_00109170 + (ulong)(uVar3 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_00109570 + (ulong)(uVar4 & 0xff) * 4) ^ puVar6[2];
    uVar10 = *(uint *)(&DAT_00108d70 + (ulong)(uVar3 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_00108970 + (ulong)(uVar2 >> 0x18) * 4) ^
             *(uint *)(&DAT_00109170 + (ulong)(uVar4 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_00109570 + (ulong)(uVar1 & 0xff) * 4) ^ puVar6[3];
    uVar11 = *(uint *)(&DAT_00108d70 + (ulong)(uVar4 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_00108970 + (ulong)(uVar3 >> 0x18) * 4) ^
             *(uint *)(&DAT_00109170 + (ulong)(uVar1 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_00109570 + (ulong)(uVar2 & 0xff) * 4) ^ puVar6[4];
    uVar4 = *(uint *)(&DAT_00108d70 + (ulong)(uVar1 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00108970 + (ulong)(uVar4 >> 0x18) * 4) ^
            *(uint *)(&DAT_00109170 + (ulong)(uVar2 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_00109570 + (ulong)(uVar3 & 0xff) * 4) ^ puVar6[5];
    puVar6 = puVar6 + 8;
  }
  uVar9 = *(uint *)(&DAT_00109d70 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) ^
          *(uint *)(&DAT_00109970 + (ulong)(uVar1 >> 0x18) * 4) ^
          *(uint *)(&DAT_0010a170 + (ulong)(uVar3 >> 8 & 0xff) * 4) ^
          *(uint *)(&DAT_0010a570 + (ulong)(uVar4 & 0xff) * 4) ^ param_1[uVar7 * 8];
  uVar10 = *(uint *)(&DAT_00109d70 + (ulong)(uVar3 >> 0x10 & 0xff) * 4) ^
           *(uint *)(&DAT_00109970 + (ulong)(uVar2 >> 0x18) * 4) ^
           *(uint *)(&DAT_0010a170 + (ulong)(uVar4 >> 8 & 0xff) * 4) ^
           *(uint *)(&DAT_0010a570 + (ulong)(uVar1 & 0xff) * 4) ^ param_1[lVar5 + 1];
  uVar11 = *(uint *)(&DAT_00109d70 + (ulong)(uVar4 >> 0x10 & 0xff) * 4) ^
           *(uint *)(&DAT_00109970 + (ulong)(uVar3 >> 0x18) * 4) ^
           *(uint *)(&DAT_0010a170 + (ulong)(uVar1 >> 8 & 0xff) * 4) ^
           *(uint *)(&DAT_0010a570 + (ulong)(uVar2 & 0xff) * 4) ^ param_1[lVar5 + 2];
  uVar4 = *(uint *)(&DAT_00109d70 + (ulong)(uVar1 >> 0x10 & 0xff) * 4) ^
          *(uint *)(&DAT_00109970 + (ulong)(uVar4 >> 0x18) * 4) ^
          *(uint *)(&DAT_0010a170 + (ulong)(uVar2 >> 8 & 0xff) * 4) ^
          *(uint *)(&DAT_0010a570 + (ulong)(uVar3 & 0xff) * 4) ^ param_1[lVar5 + 3];
  *(char *)((long)param_2 + 3) = (char)uVar9;
  *(char *)((long)param_2 + 7) = (char)uVar10;
  *(char *)((long)param_2 + 0xb) = (char)uVar11;
  *(char *)param_2 = (char)(uVar9 >> 0x18);
  *(char *)((long)param_2 + 1) = (char)(uVar9 >> 0x10);
  *(char *)((long)param_2 + 2) = (char)(uVar9 >> 8);
  *(char *)(param_2 + 1) = (char)(uVar10 >> 0x18);
  *(char *)((long)param_2 + 5) = (char)(uVar10 >> 0x10);
  *(char *)((long)param_2 + 6) = (char)(uVar10 >> 8);
  *(char *)(param_2 + 2) = (char)(uVar11 >> 0x18);
  *(char *)((long)param_2 + 9) = (char)(uVar11 >> 0x10);
  *(char *)((long)param_2 + 10) = (char)(uVar11 >> 8);
  *(char *)(param_2 + 3) = (char)(uVar4 >> 0x18);
  *(char *)((long)param_2 + 0xd) = (char)(uVar4 >> 0x10);
  *(char *)((long)param_2 + 0xe) = (char)(uVar4 >> 8);
  *(char *)((long)param_2 + 0xf) = (char)uVar4;
  return;
}



// ===== FUN_00102a5c @ 00102a5c size=380 =====

void FUN_00102a5c(undefined8 param_1,undefined4 param_2,undefined8 param_3,long param_4,
                 ulong param_5,undefined8 *param_6,ulong *param_7)

{
  long lVar1;
  char cVar2;
  ulong uVar3;
  size_t __n;
  ulong __n_00;
  undefined8 *puVar4;
  undefined1 auStack_458 [488];
  undefined1 auStack_270 [488];
  undefined8 local_88;
  undefined8 uStack_80;
  undefined1 auStack_78 [16];
  long local_68;
  
  lVar1 = tpidr_el0;
  local_68 = *(long *)(lVar1 + 0x28);
  __n_00 = param_5 & 0xf;
  uVar3 = *param_7;
  __n = 0x10 - __n_00;
  *param_7 = 0;
  if ((__n + param_5 <= uVar3) && (cVar2 = FUN_00104678(auStack_458,param_1,param_2), cVar2 == '\0')
     ) {
    FUN_001066d4(auStack_270,auStack_458,param_3);
    uVar3 = param_5 >> 4;
    memset(auStack_78 + __n_00,0,__n);
    memcpy(auStack_78,(void *)(param_4 + (param_5 - __n_00)),__n_00);
    memset(auStack_78 + __n_00,(int)__n,__n);
    puVar4 = param_6;
    if (uVar3 == 0) {
      uVar3 = 0;
    }
    else {
      do {
        FUN_001065d0(&local_88,param_4);
        FUN_001026e0(auStack_270,&local_88);
        uVar3 = uVar3 - 1;
        param_4 = param_4 + 0x10;
        puVar4[1] = uStack_80;
        *puVar4 = local_88;
        puVar4 = puVar4 + 2;
      } while (uVar3 != 0);
      uVar3 = param_5 & 0xfffffffffffffff0;
    }
    FUN_001065d0(&local_88,auStack_78);
    FUN_001026e0(auStack_270,&local_88);
    ((undefined8 *)((long)param_6 + uVar3))[1] = uStack_80;
    *(undefined8 *)((long)param_6 + uVar3) = local_88;
    *param_7 = __n + param_5;
  }
  if (*(long *)(lVar1 + 0x28) != local_68) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}



// ===== FUN_00102bd8 @ 00102bd8 size=124 =====

void FUN_00102bd8(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)

{
  long lVar1;
  undefined8 local_538;
  undefined8 uStack_530;
  undefined8 local_528;
  undefined8 uStack_520;
  code *local_518;
  undefined1 *puStack_510;
  undefined1 auStack_30 [8];
  long local_28;
  
  lVar1 = tpidr_el0;
  local_28 = *(long *)(lVar1 + 0x28);
  puStack_510 = auStack_30;
  local_518 = FUN_00102d20;
  local_538 = param_1;
  uStack_530 = param_2;
  local_528 = param_3;
  uStack_520 = param_4;
  FUN_00102d2c(&DAT_0010b2d0,&local_538,0,&DAT_00117ce0,&local_518);
  if (*(long *)(lVar1 + 0x28) == local_28) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00102c54 @ 00102c54 size=28 =====

void FUN_00102c54(size_t *param_1)

{
  void *pvVar1;
  
  pvVar1 = malloc(*param_1);
  param_1[1] = (size_t)pvVar1;
  return;
}



// ===== FUN_00102c70 @ 00102c70 size=56 =====

void FUN_00102c70(undefined8 *param_1)

{
  undefined1 *puVar1;
  long lVar2;
  int iVar3;
  time_t tVar4;
  
  puVar1 = (undefined1 *)*param_1;
  lVar2 = param_1[1];
  tVar4 = time((time_t *)0x0);
  srand((uint)tVar4);
  for (; lVar2 != 0; lVar2 = lVar2 + -1) {
    iVar3 = rand();
    *puVar1 = (char)iVar3;
    puVar1 = puVar1 + 1;
  }
  return;
}



// ===== FUN_00102ca8 @ 00102ca8 size=20 =====

void FUN_00102ca8(undefined8 *param_1)

{
  FUN_00104b00(*param_1,param_1[1],param_1[2],param_1[3],param_1[4],param_1[5]);
  return;
}



// ===== FUN_00102cbc @ 00102cbc size=16 =====

void FUN_00102cbc(undefined8 *param_1)

{
  FUN_00106dac(*param_1,param_1[1],param_1[2]);
  return;
}



// ===== FUN_00102ccc @ 00102ccc size=16 =====

void FUN_00102ccc(undefined8 *param_1)

{
  memcpy((void *)*param_1,(void *)param_1[1],param_1[2]);
  return;
}



// ===== FUN_00102cdc @ 00102cdc size=32 =====

void FUN_00102cdc(undefined8 *param_1)

{
  undefined4 *puVar1;
  void *__src;
  uint uVar2;
  
  puVar1 = (undefined4 *)*param_1;
  __src = (void *)param_1[1];
  uVar2 = *(uint *)(param_1 + 2);
  *puVar1 = 0x10056374;
  *(undefined2 *)(puVar1 + 1) = 0;
  memcpy((void *)((long)puVar1 + 6),__src,(ulong)uVar2);
  return;
}



// ===== FUN_00102cfc @ 00102cfc size=28 =====

void FUN_00102cfc(undefined8 *param_1)

{
  FUN_00102a5c(*param_1,*(undefined4 *)(param_1 + 1),param_1[2],param_1[3],param_1[4],param_1[5],
               param_1[6]);
  return;
}



// ===== FUN_00102d18 @ 00102d18 size=8 =====

void FUN_00102d18(undefined8 *param_1)

{
  free((void *)*param_1);
  return;
}



// ===== FUN_00102d20 @ 00102d20 size=12 =====

void FUN_00102d20(code *UNRECOVERED_JUMPTABLE,undefined8 param_2)

{
                    /* WARNING: Could not recover jumptable at 0x00102d28. Too many branches */
                    /* WARNING: Treating indirect jump as call */
  (*UNRECOVERED_JUMPTABLE)(param_2);
  return;
}



// ===== FUN_00102d2c @ 00102d2c size=6476 =====

void FUN_00102d2c(code *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 *param_5)

{
  bool bVar1;
  ulong *puVar2;
  long *plVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  undefined8 uVar8;
  code *pcVar9;
  long lVar10;
  undefined4 uVar11;
  undefined4 uVar12;
  uint uVar13;
  uint uVar14;
  ushort uVar15;
  undefined1 auVar16 [16];
  undefined1 auVar17 [16];
  ushort uVar18;
  ushort uVar19;
  ushort uVar20;
  ushort uVar21;
  ushort uVar22;
  ushort uVar23;
  bool bVar24;
  long lVar25;
  ulong *puVar26;
  ulong *puVar27;
  uint uVar28;
  ulong uVar29;
  code *pcVar30;
  undefined8 *puVar31;
  ulong uVar32;
  long lVar33;
  int iVar34;
  uint uVar35;
  ulong uVar36;
  byte bVar37;
  uint uVar38;
  ulong uVar39;
  code *pcVar40;
  byte bVar41;
  bool bVar42;
  uint uVar43;
  uint uVar44;
  uint uVar45;
  uint uVar46;
  code *pcVar47;
  ulong uVar48;
  long *plVar49;
  
  pcVar9 = (code *)*param_5;
  lVar10 = param_5[1];
  *(undefined8 *)(lVar10 + -0x38) = 0;
  *(undefined8 *)(lVar10 + -0x130) = 0;
  plVar49 = (long *)(lVar10 + -0x138);
  *(ulong *)(lVar10 + -0x48) = lVar10 - 0x148U & 0xfffffffffffffff0;
  *(undefined8 *)(lVar10 + -0x20) = 0;
  *(undefined8 *)(lVar10 + -0x110) = param_2;
  *(undefined8 *)(lVar10 + -0x108) = param_3;
  *(undefined8 *)(lVar10 + -0x100) = param_4;
  *(code **)(lVar10 + -0xf8) = pcVar9;
  *plVar49 = (long)param_1;
  *(code **)(lVar10 + -8) = param_1;
  if (param_1 == (code *)0x0) {
    return;
  }
  lVar25 = 0;
  puVar26 = (ulong *)(lVar10 + -0x28);
  puVar27 = (ulong *)(lVar10 + -0x30);
LAB_00102ddc:
  uVar38 = *(uint *)param_1;
  if (lVar25 == 2) {
    lVar25 = 3;
    *(undefined8 *)(lVar10 + -0x20) = 3;
  }
  if (0x3f < (uVar38 & 0x3f)) goto switchD_00102e50_caseD_1;
  uVar46 = uVar38 >> 0xb;
  uVar45 = uVar38 & 0x10000000;
  uVar13 = uVar45 >> 0x1a;
  uVar43 = uVar38 & 0x20000000;
  uVar7 = uVar38 >> 0x1a;
  uVar44 = uVar38 & 0x40000000;
  uVar35 = uVar46 & 2 | uVar38 >> 0x1f | uVar46 & 4 | uVar46 & 8 | uVar46 & 0x10;
  uVar36 = (ulong)uVar35;
  uVar46 = uVar43 >> 0x1a;
  uVar32 = (ulong)(uVar38 >> 0x15 & 0x1f);
  uVar29 = (ulong)(uVar38 >> 0x10 & 0x1f);
  uVar4 = uVar38 & 0x80000000;
  uVar5 = uVar38 & 0x4000000;
  uVar6 = uVar38 & 0x8000000;
  uVar28 = uVar44 >> 0x1a;
  uVar14 = uVar13 | uVar7 & 3 | uVar46 | uVar28;
  uVar39 = (ulong)uVar14;
  uVar15 = (ushort)(uVar4 >> 0x10);
  uVar18 = (ushort)(uVar44 >> 0x10);
  uVar19 = (ushort)(uVar43 >> 0x10);
  uVar20 = (ushort)(uVar45 >> 0x10);
  uVar21 = (ushort)(uVar6 >> 0x10);
  uVar22 = (ushort)uVar38;
  uVar23 = (ushort)(uVar5 >> 0x10);
  switch(uVar38 & 0x3f) {
  case 0:
  case 2:
  case 8:
  case 0x12:
  case 0x1f:
  case 0x21:
  case 0x22:
  case 0x27:
  case 0x2b:
  case 0x30:
  case 0x31:
  case 0x33:
  case 0x37:
    if ((uVar38 & 0x3f) < 0x38) {
      puVar2 = (ulong *)(plVar49[uVar32 + 1] +
                        (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                      uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                     uVar15 >> 4));
      switch(uVar38 & 0x3f) {
      case 0:
        uVar32 = (ulong)(short)*puVar2;
        break;
      default:
        goto switchD_00102e50_caseD_1;
      case 2:
        uVar32 = *puVar2;
        break;
      case 8:
        uVar32 = (ulong)(char)*puVar2;
        break;
      case 0x12:
        uVar38 = (uint)puVar2 & 3;
        uVar32 = (ulong)(*(uint *)(plVar49 + uVar29 + 1) & -1 << (ulong)(uVar38 * -8 + 0x20 & 0x1f)
                        | *(uint *)((ulong)puVar2 & 0xfffffffffffffffc) >> (ulong)(uVar38 * 8));
        break;
      case 0x21:
        uVar32 = (ulong)(byte)*puVar2;
        break;
      case 0x22:
        uVar32 = (plVar49 + uVar29)[1] & -1L << (((ulong)puVar2 & 7) * -8 + 0x40 & 0x3f) |
                 *(ulong *)((ulong)puVar2 & 0xfffffffffffffff8) >> ((ulong)puVar2 & 7) * 8;
        break;
      case 0x27:
      case 0x31:
        uVar32 = (plVar49 + uVar29)[1] & 0xffffffffffffffU >> ((ulong)puVar2 & 7) * 8 |
                 *(long *)((ulong)puVar2 & 0xfffffffffffffff8) <<
                 (((ulong)puVar2 & 7) * -8 + 0x38 & 0x3f);
        break;
      case 0x2b:
        uVar32 = (ulong)(int)(uint)*puVar2;
        break;
      case 0x30:
        uVar32 = (ulong)(ushort)*puVar2;
        break;
      case 0x33:
        uVar32 = (ulong)(uint)*puVar2;
        break;
      case 0x37:
        uVar38 = (uint)puVar2 & 3;
        uVar32 = (ulong)(*(uint *)(plVar49 + uVar29 + 1) & 0xffffffU >> (ulong)(uVar38 * 8) |
                        *(int *)((ulong)puVar2 & 0xfffffffffffffffc) <<
                        (ulong)(uVar38 * -8 + 0x18 & 0x1f));
      }
LAB_00103c24:
      (plVar49 + uVar29)[1] = uVar32;
    }
    break;
  case 3:
  case 5:
  case 0xf:
  case 0x1a:
  case 0x2c:
  case 0x2d:
  case 0x3a:
  case 0x3f:
    if ((lVar25 != 0) || (0x3c < (uVar38 & 0x3f) - 3)) break;
    iVar34 = 0;
    lVar25 = 0;
    uVar46 = -((uVar38 & 0xf000) >> 0xf) & 0xfffc0000 |
             (uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14
              | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    switch(uVar38 & 0x3f) {
    case 3:
    case 0x1a:
    case 0x2d:
    case 0x3f:
      goto switchD_00102f1c_caseD_3;
    default:
      break;
    case 5:
    case 0xf:
    case 0x2c:
    case 0x3a:
      goto switchD_00102f1c_caseD_5;
    case 0x11:
      iVar34 = 0x1f;
    case 0x2a:
      bVar37 = 0;
      bVar1 = false;
      bVar41 = 1;
      pcVar47 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar46);
      goto LAB_00103640;
    }
  case 4:
  case 0x20:
  case 0x38:
  case 0x3e:
    uVar46 = uVar38 & 0x3f;
    uVar38 = uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14 |
             uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14;
    if (uVar46 < 0x38) {
      if (uVar46 == 4) {
        uVar38 = uVar38 << 0x10;
LAB_00103584:
        uVar32 = (ulong)(int)uVar38;
        goto LAB_00103c24;
      }
      if (uVar46 == 0x20) {
        *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
             *(ulong *)(lVar10 + -0x130 + uVar32 * 8) & (ulong)uVar38;
      }
    }
    else if (uVar46 == 0x38) {
      *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
           *(ulong *)(lVar10 + -0x130 + uVar32 * 8) ^ (ulong)uVar38;
    }
    else if (uVar46 == 0x3e) {
      *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
           *(ulong *)(lVar10 + -0x130 + uVar32 * 8) | (ulong)uVar38;
    }
    break;
  case 10:
  case 0xb:
  case 0xe:
  case 0x14:
  case 0x16:
  case 0x24:
  case 0x36:
  case 0x3b:
    if (0x31 < (uVar38 & 0x3f) - 10) break;
    plVar3 = (long *)(plVar49[uVar32 + 1] +
                     (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                   uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                  uVar15 >> 4));
    switch(uVar38 & 0x3f) {
    case 10:
      uVar29 = (ulong)plVar49[uVar29 + 1] >> (((ulong)plVar3 & 7) * -8 + 0x38 & 0x3f);
      uVar32 = *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) & -0x100L << ((ulong)plVar3 & 7) * 8;
      goto LAB_001034d0;
    case 0xb:
      uVar29 = plVar49[uVar29 + 1] << ((ulong)plVar3 & 7) * 8;
      uVar32 = *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) &
               0xffffffffffffffffU >> (((ulong)plVar3 & 7) * -8 + 0x40 & 0x3f);
LAB_001034d0:
      *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) = uVar32 | uVar29;
      break;
    case 0xe:
      *(char *)plVar3 = (char)(int)plVar49[uVar29 + 1];
      break;
    case 0x14:
      *(short *)plVar3 = (short)(int)plVar49[uVar29 + 1];
      break;
    case 0x16:
      uVar38 = (uint)plVar3 & 3;
      uVar46 = *(uint *)(plVar49 + uVar29 + 1) >> (ulong)(uVar38 * -8 + 0x18 & 0x1f);
      uVar38 = *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) & -0x100 << (ulong)(uVar38 * 8);
      goto LAB_00103554;
    case 0x24:
      uVar38 = (uint)plVar3 & 3;
      uVar46 = (int)plVar49[uVar29 + 1] << (ulong)(uVar38 * 8);
      uVar38 = *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) &
               0xffffffffU >> (ulong)(uVar38 * -8 + 0x20 & 0x1f);
LAB_00103554:
      *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) = uVar38 | uVar46;
      break;
    case 0x36:
      *(int *)plVar3 = (int)plVar49[uVar29 + 1];
      break;
    case 0x3b:
      *plVar3 = plVar49[uVar29 + 1];
    }
    break;
  case 0xd:
  case 0x15:
  case 0x1b:
  case 0x28:
    uVar46 = uVar38 & 0x3f;
    uVar15 = uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f | uVar21 >> 4 |
             uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 | uVar15 >> 4;
    if ((uVar46 == 0xd) || (uVar46 == 0x28)) {
      *(long *)(lVar10 + -0x130 + uVar29 * 8) =
           *(long *)(lVar10 + -0x130 + uVar32 * 8) + (long)(short)uVar15;
    }
    else if (uVar46 == 0x15) {
      *(long *)(lVar10 + -0x130 + uVar29 * 8) =
           (long)*(int *)(lVar10 + -0x130 + uVar32 * 8) + (long)(int)(short)uVar15;
    }
    break;
  case 0x10:
    uVar45 = uVar38 & 0xfff;
    if (0xa4f < uVar45) {
      if (uVar45 < 0xe90) {
        if (uVar45 == 0xa50) {
LAB_001038b0:
          if ((uint)uVar39 <= (uint)uVar36) {
            lVar25 = lVar10 + -0x130;
            uVar48 = *(ulong *)(lVar25 + uVar29 * 8);
            *(ulong *)(lVar25 + uVar29 * 8) =
                 uVar48 & -1L << uVar36 |
                 (*(ulong *)(lVar25 + uVar32 * 8) &
                 (-1L << ((ulong)(((uint)uVar36 + 1) - (uint)uVar39) & 0x3f) ^ 0xffffffffffffffffU))
                 << uVar39 | uVar48 & (-1L << uVar39 ^ 0xffffffffffffffffU);
          }
        }
        else if ((uVar45 == 0xad0) && (uVar14 <= uVar35)) {
          lVar25 = lVar10 + -0x130;
          uVar38 = *(uint *)(lVar25 + uVar29 * 8);
          *(long *)(lVar25 + uVar29 * 8) =
               (long)(int)(uVar38 & -1 << (ulong)uVar35 |
                           (*(uint *)(lVar25 + uVar32 * 8) &
                           (-1 << (ulong)((1 - uVar14) + uVar35 & 0x1f) ^ 0xffffffffU)) <<
                           (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) |
                          uVar38 & (-1 << (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) ^
                                   0xffffffffU));
        }
      }
      else {
        if (uVar45 != 0xe90) {
          if (uVar45 == 0xed0) {
            uVar39 = (ulong)(uVar14 | 0x20);
          }
          else {
            if (uVar45 != 0xf90) break;
            uVar35 = uVar35 | 0x20;
          }
        }
        if ((int)uVar39 + uVar35 < 0x40) {
          uVar32 = plVar49[uVar32 + 1];
          if (uVar35 != 0x3f) {
            uVar32 = uVar32 >> uVar39 & (-1L << ((ulong)(uVar35 + 1) & 0x3f) ^ 0xffffffffffffffffU);
          }
          goto LAB_00103c24;
        }
      }
      break;
    }
    if (uVar45 < 0x290) {
      if (uVar45 == 0x10) {
        if (uVar35 + uVar14 < 0x20) {
          uVar38 = *(uint *)(plVar49 + uVar32 + 1);
          if (uVar35 != 0x1f) {
            uVar38 = uVar38 >> (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) &
                     (-2 << (ulong)uVar35 ^ 0xffffffffU);
          }
          goto LAB_00103584;
        }
      }
      else if (uVar45 == 0x90) {
        uVar39 = (ulong)(uVar14 | 0x20);
        goto LAB_0010383c;
      }
      break;
    }
    if ((uVar45 != 0x290) && (uVar45 != 0x690)) {
      if (uVar45 == 0x8d0) {
LAB_0010383c:
        uVar36 = (ulong)(uVar35 | 0x20);
        goto LAB_001038b0;
      }
      break;
    }
    uVar38 = uVar38 & 0x7c000fff;
    if (uVar38 < 0x4c000290) {
      if (uVar38 == 0xc000690) {
        uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        uVar29 = (uVar29 & 0xffff0000ffff) << 0x10 | uVar29 >> 0x10 & 0xffff0000ffff;
        *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> 0x20 | uVar29 << 0x20;
      }
      else if (uVar38 == 0x38000290) {
        *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)*(char *)(lVar10 + -0x130 + uVar29 * 8);
      }
      break;
    }
    if (uVar38 == 0x4c000290) {
      *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)*(short *)(lVar10 + -0x130 + uVar29 * 8);
      break;
    }
    if (uVar38 == 0x54000690) {
      uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
      *(ulong *)(lVar10 + -0x130 + uVar36 * 8) =
           (uVar29 & 0xff00ff00ff00ff) << 8 | uVar29 >> 8 & 0xff00ff00ff00ff;
      break;
    }
    if (uVar38 != 0x74000290) break;
    uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
    uVar38 = (uVar38 & 0xff00ff) << 8 | uVar38 >> 8 & 0xff00ff;
    goto LAB_00104330;
  case 0x11:
  case 0x2a:
    if (lVar25 != 0) break;
    uVar46 = uVar38 & 0x3f;
    uVar38 = (uVar38 & 0x3fff000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 |
              uVar45 >> 0x14 | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    if (uVar46 == 0x11) {
      uVar28 = 0x1f;
LAB_001036c0:
      bVar1 = false;
      bVar24 = false;
      pcVar47 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar38);
      bVar42 = true;
    }
    else {
      if (uVar46 == 0x2a) {
        uVar28 = 0;
        goto LAB_001036c0;
      }
      if (uVar46 != 0x1a) break;
      lVar25 = plVar49[uVar32 + 1];
      bVar1 = lVar25 < 1;
      uVar28 = 0;
      bVar42 = 0 < lVar25;
      pcVar47 = param_1 + (long)(int)uVar38 + 4;
      if (lVar25 < 1) {
        pcVar47 = param_1 + 8;
      }
      bVar24 = true;
    }
    *(code **)(lVar10 + -0x18) = pcVar47;
    if ((((bool)(bVar1 & bVar24)) || (!bVar24)) || ((bool)(bVar42 & bVar24))) {
      uVar8 = 1;
      if (!(bool)(bVar1 & bVar24)) {
        uVar8 = 2;
      }
      *(undefined8 *)(lVar10 + -0x20) = uVar8;
    }
    goto joined_r0x00104640;
  case 0x17:
    uVar46 = uVar38 & 0x1f003f;
    uVar28 = uVar46 - 0x10017 >> 0x10;
    if (((0x1a < (uVar28 | (uVar46 - 0x10017) * 0x10000)) ||
        ((1 << (ulong)(uVar28 & 0x1f) & 0x4842861U) == 0)) || (lVar25 != 0)) break;
    uVar38 = -((uVar38 & 0xf000) >> 0xf) & 0xfffc0000 |
             (uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14
              | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    if (0x10016 < uVar46) {
      if (uVar46 < 0xe0017) {
        if (uVar46 < 0x70017) {
          if ((uVar46 == 0x10017) || (uVar46 == 0x60017)) {
switchD_0010322c_caseD_3:
            pcVar47 = (code *)0x0;
            goto switchD_0010322c_caseD_5;
          }
        }
        else if ((uVar46 == 0x70017) || (uVar46 == 0xc0017)) goto switchD_0010322c_caseD_3;
      }
      else if (uVar46 < 0x180017) {
        if ((uVar46 == 0xe0017) || (uVar46 == 0x130017)) goto switchD_0010322c_caseD_3;
      }
      else if ((uVar46 == 0x1b0017) || (uVar46 == 0x180017)) goto switchD_0010322c_caseD_3;
      break;
    }
    iVar34 = 0;
    pcVar47 = param_1;
    switch(uVar46) {
    case 3:
    case 0x1a:
    case 0x2d:
    case 0x3f:
      goto switchD_0010322c_caseD_3;
    default:
      goto switchD_00102e50_caseD_1;
    case 5:
    case 0xf:
    case 0x2c:
    case 0x3a:
switchD_0010322c_caseD_5:
      pcVar40 = (code *)plVar49[uVar32 + 1];
      pcVar30 = param_1 + (int)(uVar38 + 4);
      if (0x10016 < uVar46) {
        if (uVar46 < 0xe0017) {
          if (uVar46 < 0x70017) {
            if (uVar46 == 0x10017) {
              if (-1 < (long)pcVar40) goto LAB_00103f4c;
              goto LAB_00103280;
            }
            if (uVar46 != 0x60017) goto switchD_00102e50_caseD_1;
            iVar34 = 0x1f;
            if ((long)pcVar40 < 0) {
LAB_00103bb0:
              iVar34 = 0x1f;
              bVar1 = false;
              goto LAB_00103f08;
            }
            goto LAB_00103f50;
          }
          if (uVar46 == 0x70017) {
            if ((long)pcVar40 < 0) goto LAB_00103f00;
            goto LAB_00103f2c;
          }
          if (uVar46 == 0xc0017) {
            iVar34 = 0x1f;
            if (-1 < (long)pcVar40) goto LAB_00103bb0;
            goto LAB_00103f50;
          }
          goto switchD_00102e50_caseD_1;
        }
        if (0x180016 < uVar46) {
          if (uVar46 == 0x180017) {
            if (-1 < (long)pcVar40) goto LAB_00103f00;
            goto LAB_00103f2c;
          }
          if (uVar46 == 0x1b0017) {
            iVar34 = 0x1f;
            bVar1 = true;
            if ((long)pcVar40 < 0) goto LAB_00103fb0;
            goto LAB_00103f54;
          }
          goto switchD_00102e50_caseD_1;
        }
        if (uVar46 != 0xe0017) {
          if (uVar46 == 0x130017) {
            if ((long)pcVar40 < 0) goto LAB_00103f4c;
            goto LAB_00103280;
          }
          goto switchD_00102e50_caseD_1;
        }
        iVar34 = 0x1f;
        bVar1 = true;
        if ((long)pcVar40 < 0) goto LAB_00103f54;
LAB_00103fb0:
        bVar1 = true;
        iVar34 = 0x1f;
        goto LAB_00103f08;
      }
      break;
    case 0x11:
      iVar34 = 0x1f;
    case 0x2a:
      bVar1 = false;
      pcVar30 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar38);
      goto LAB_00103f08;
    }
    switch(uVar46) {
    case 3:
      if (0 < (long)pcVar40) break;
LAB_00103f4c:
      iVar34 = 0;
LAB_00103f50:
      bVar1 = false;
      goto LAB_00103f54;
    default:
      goto switchD_00102e50_caseD_1;
    case 5:
      if (pcVar40 == pcVar47) goto LAB_00103f4c;
      break;
    case 0xf:
      if (pcVar40 != pcVar47) goto LAB_00103f4c;
      break;
    case 0x1a:
      if ((long)pcVar40 < 1) goto LAB_00103f2c;
LAB_00103f00:
      bVar1 = true;
      goto LAB_00103f04;
    case 0x2c:
      if (pcVar40 == pcVar47) goto LAB_00103f00;
      goto LAB_00103f2c;
    case 0x2d:
      if ((long)pcVar40 < 1) goto LAB_00103f00;
      goto LAB_00103f2c;
    case 0x3a:
      if (pcVar40 != pcVar47) goto LAB_00103f00;
LAB_00103f2c:
      bVar1 = true;
      iVar34 = 0;
LAB_00103f54:
      bVar42 = false;
      pcVar30 = param_1 + 8;
      bVar37 = 1;
      goto LAB_00103f60;
    case 0x3f:
      if (0 < (long)pcVar40) goto LAB_00103f4c;
    }
LAB_00103280:
    bVar1 = false;
LAB_00103f04:
    iVar34 = 0;
LAB_00103f08:
    bVar37 = 0;
    bVar42 = true;
LAB_00103f60:
    *(code **)(lVar10 + -0x18) = pcVar30;
    if ((((bool)(bVar37 & bVar1)) || (!bVar1)) || (bVar42)) {
      uVar8 = 1;
      if (!(bool)(bVar37 & bVar1)) {
        uVar8 = 2;
      }
      *(undefined8 *)(lVar10 + -0x20) = uVar8;
    }
    goto joined_r0x00103f94;
  case 0x23:
    *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
         (ulong)(*(ulong *)(lVar10 + -0x130 + uVar32 * 8) <
                (ulong)(long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                     uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                    uVar15 >> 4));
    break;
  case 0x29:
    uVar28 = (uVar38 & 0xfff) - 0x1a9;
    uVar46 = uVar28 >> 6;
    uVar28 = uVar46 | uVar28 * 0x4000000;
    if (0x1a < uVar28) break;
    if ((1 << (ulong)(uVar46 & 0x1f) & 0x4000032U) != 0) {
      uVar46 = uVar38 & 0xfff;
      if (uVar46 < 0x76f) {
        if (uVar46 < 0x2e9) {
          if (uVar46 == 0x1af) goto LAB_00104448;
          if (uVar46 == 0x1e9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00103e48;
          }
          if (uVar46 == 0x2a9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00103e20;
          }
        }
        else {
          if (uVar46 == 0x2e9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00103e48:
            uVar29 = CONCAT44(uVar11,uVar12) - uVar29 * uVar32;
LAB_00103e50:
            uVar36 = uVar29 & 0xffffffff;
            uVar29 = uVar29 >> 0x20;
            goto LAB_00104468;
          }
          if (uVar46 == 0x52f) {
LAB_00104418:
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = 0;
            if (uVar46 != 0) {
              uVar28 = uVar38 / uVar46;
            }
            goto LAB_00104430;
          }
joined_r0x001043d0:
          if ((uVar38 & 0xfff) == 0x72f) {
            uVar32 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
            uVar36 = SUB168(SEXT816((long)uVar29) * SEXT816((long)uVar32),8);
            goto LAB_001044ec;
          }
        }
      }
      else if (uVar46 < 0x92f) {
        if (uVar46 != 0x76f) {
          if (uVar46 != 0x829) goto joined_r0x001044d4;
          uVar11 = *(undefined4 *)puVar26;
          uVar12 = *(undefined4 *)puVar27;
          uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00103e20:
          uVar29 = CONCAT44(uVar11,uVar12) + uVar29 * uVar32;
          goto LAB_00103e50;
        }
LAB_001044dc:
        uVar32 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
        uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        auVar16._8_8_ = 0;
        auVar16._0_8_ = uVar29;
        auVar17._8_8_ = 0;
        auVar17._0_8_ = uVar32;
        uVar36 = SUB168(auVar16 * auVar17,8);
LAB_001044ec:
        *puVar27 = uVar29 * uVar32;
        *puVar26 = uVar36;
      }
      else {
        if (uVar46 == 0x92f) {
LAB_00104080:
          uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
          goto LAB_0010445c;
        }
        if (uVar46 == 0xb2f) goto LAB_001044a8;
        if (uVar46 == 0xdaf) goto LAB_00103a20;
      }
      break;
    }
    if (uVar28 != 2) break;
    uVar46 = uVar38 & 0xfff;
    if (uVar46 < 0x86f) {
      if (uVar46 < 0x3af) {
        if (uVar46 != 0x1ef) goto LAB_00103b60;
        goto LAB_00103d04;
      }
      goto LAB_00103d28;
    }
    if (0x9ee < uVar46) goto LAB_0010337c;
LAB_00103800:
    if ((uVar38 & 0xfff) != 0x86f) {
      if ((uVar38 & 0xfff) == 0x96f) goto LAB_00103810;
      break;
    }
LAB_00103ca4:
    uVar38 = *(int *)(lVar10 + -0x130 + uVar32 * 8) - *(int *)(lVar10 + -0x130 + uVar29 * 8);
    goto LAB_00103d1c;
  case 0x2f:
    uVar45 = uVar38 & 0xfff;
    switch(uVar45 - 0x6f >> 6 | (uVar45 - 0x6f) * 0x4000000) {
    case 0:
    case 3:
    case 9:
    case 0xf:
    case 0x2e:
    case 0x3d:
      break;
    case 1:
    case 0xb:
    case 0x34:
      uVar46 = 0x400032f;
      if ((uVar38 & 0x4000fff) != 0x400032f) {
        uVar46 = uVar45;
      }
      goto LAB_00104128;
    case 2:
      lVar25 = lVar10 + -0x130;
      puVar31 = (undefined8 *)(lVar25 + uVar36 * 8);
      if (*(ulong *)(lVar25 + uVar29 * 8) <= *(ulong *)(lVar25 + uVar32 * 8)) goto LAB_00104048;
LAB_00104230:
      *puVar31 = 1;
      break;
    default:
      if (0x92e < uVar45) {
        if (uVar45 < 0xdaf) {
          if (uVar45 < 0xb2f) {
            if (uVar45 == 0x92f) goto LAB_00104080;
            if (uVar45 == 0x9af) {
              uVar29 = *puVar27;
              goto LAB_0010464c;
            }
          }
          else if (uVar45 == 0xb2f) {
LAB_001044a8:
            uVar36 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
            uVar32 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
            uVar29 = 0;
            if (uVar32 != 0) {
              uVar29 = (long)uVar36 / (long)uVar32;
            }
LAB_001044b8:
            *puVar26 = uVar36 - uVar29 * uVar32;
            *puVar27 = uVar29;
          }
          else if (uVar45 == 0xcef) {
            *puVar26 = plVar49[uVar32 + 1];
          }
        }
        else if (uVar45 < 0xe2f) {
          if (uVar45 == 0xdaf) {
LAB_00103a20:
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = 0;
            if (uVar46 != 0) {
              uVar28 = (int)uVar38 / (int)uVar46;
            }
LAB_00104430:
            *puVar26 = (long)(int)(uVar38 - uVar28 * uVar46);
            *puVar27 = (long)(int)uVar28;
          }
          else if (uVar45 == 0xdef) {
            *puVar27 = plVar49[uVar32 + 1];
          }
        }
        else if (uVar45 == 0xe2f) {
          uVar29 = *puVar26;
LAB_0010464c:
          plVar49[uVar36 + 1] = uVar29;
        }
        else if ((uVar45 == 0xeaf) && (plVar49[uVar29 + 1] != 0)) goto LAB_001045e4;
        break;
      }
      if (uVar45 < 0x6af) {
        if (uVar45 == 0x1af) {
LAB_00104448:
          uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
LAB_0010445c:
          uVar36 = (ulong)(int)(uVar29 * uVar32);
          uVar29 = (long)(uVar29 * uVar32) >> 0x20;
LAB_00104468:
          *puVar27 = uVar36;
          *puVar26 = uVar29;
        }
        else if (uVar45 == 0x4ef) {
          if (plVar49[uVar29 + 1] == 0) {
LAB_001045e4:
            *(undefined8 *)(lVar10 + -0x130 + uVar36 * 8) =
                 *(undefined8 *)(lVar10 + -0x130 + uVar32 * 8);
          }
        }
        else if (uVar45 == 0x52f) goto LAB_00104418;
        break;
      }
      if (0x76e < uVar45) {
        if (uVar45 == 0x76f) goto LAB_001044dc;
joined_r0x001044d4:
        if ((uVar38 & 0xfff) == 0x8af) {
          uVar36 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
          uVar32 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar29 = 0;
          if (uVar32 != 0) {
            uVar29 = uVar36 / uVar32;
          }
          goto LAB_001044b8;
        }
        break;
      }
      if (uVar45 != 0x6af) goto joined_r0x001043d0;
      if (lVar25 != 0) break;
      lVar25 = plVar49[uVar32 + 1];
      param_1 = param_1 + 4;
      *(undefined8 *)(lVar10 + -0x20) = 2;
      *(long *)(lVar10 + -0x18) = lVar25;
      *plVar49 = (long)param_1;
      if (param_1 == (code *)0x0) {
        return;
      }
      goto LAB_00102dd8;
    case 6:
    case 0xd:
    case 0x1a:
    case 0x20:
    case 0x24:
    case 0x26:
    case 0x28:
    case 0x33:
      uVar46 = uVar38 & 0xfff;
      if (uVar46 < 0x86f) {
        if (uVar46 < 0x3af) {
          if (uVar46 == 0x1ef) {
LAB_00103d04:
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) + *(int *)(lVar10 + -0x130 + uVar32 * 8)
            ;
            goto LAB_00103d1c;
          }
LAB_00103b60:
          if ((uVar38 & 0xfff) == 0x229) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 (long)*(int *)(lVar25 + uVar29 * 8) * (long)*(int *)(lVar25 + uVar32 * 8);
          }
        }
        else {
LAB_00103d28:
          if (((uVar38 & 0xfff) == 0x3af) || ((uVar38 & 0xfff) == 0x6ef)) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 *(long *)(lVar25 + uVar32 * 8) - *(long *)(lVar25 + uVar29 * 8);
          }
        }
      }
      else {
        if (uVar46 < 0x9ef) goto LAB_00103800;
LAB_0010337c:
        uVar38 = uVar38 & 0xfff;
        if (uVar38 == 0x9ef) {
LAB_00103810:
          lVar25 = lVar10 + -0x130;
          *(long *)(lVar25 + uVar36 * 8) =
               *(long *)(lVar25 + uVar29 * 8) + *(long *)(lVar25 + uVar32 * 8);
        }
        else {
          if (uVar38 == 0xa6f) goto LAB_00103ca4;
          if (uVar38 == 0xd2f) goto LAB_00103d04;
        }
      }
      break;
    case 10:
    case 0x30:
      goto switchD_00103364_caseD_a;
    case 0xc:
    case 0x17:
    case 0x1f:
    case 0x3c:
      uVar38 = uVar38 & 0xfff;
      if (uVar38 < 0x82f) {
        if (uVar38 == 0x36f) {
          lVar25 = lVar10 + -0x130;
          *(ulong *)(lVar25 + uVar36 * 8) =
               *(ulong *)(lVar25 + uVar29 * 8) ^ *(ulong *)(lVar25 + uVar32 * 8);
        }
        else if (uVar38 == 0x62f) {
          lVar25 = lVar10 + -0x130;
          *(ulong *)(lVar25 + uVar36 * 8) =
               *(ulong *)(lVar25 + uVar29 * 8) | *(ulong *)(lVar25 + uVar32 * 8);
        }
      }
      else if (uVar38 == 0x82f) {
        lVar25 = lVar10 + -0x130;
        *(ulong *)(lVar25 + uVar36 * 8) =
             ~(*(ulong *)(lVar25 + uVar29 * 8) | *(ulong *)(lVar25 + uVar32 * 8));
      }
      else if (uVar38 == 0xf6f) {
        lVar25 = lVar10 + -0x130;
        *(ulong *)(lVar25 + uVar36 * 8) =
             *(ulong *)(lVar25 + uVar29 * 8) & *(ulong *)(lVar25 + uVar32 * 8);
      }
      break;
    case 0xe:
    case 0x10:
    case 0x22:
    case 0x2c:
    case 0x31:
      uVar43 = 0x2008ef;
      if ((uVar38 & 0x200fff) != 0x2008ef) {
        uVar43 = uVar45;
      }
      goto LAB_00103a4c;
    case 0x15:
      if (lVar25 != 0) break;
      uVar46 = uVar38 & 0xfff;
      uVar28 = 0;
      lVar25 = 0;
      switch(uVar46) {
      case 3:
      case 0x1a:
      case 0x2d:
      case 0x3f:
        goto switchD_001040c8_caseD_3;
      case 4:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 0xb:
      case 0xc:
      case 0xd:
      case 0xe:
      case 0x10:
      case 0x12:
      case 0x13:
      case 0x14:
      case 0x15:
      case 0x16:
      case 0x17:
      case 0x18:
      case 0x19:
      case 0x1b:
      case 0x1c:
      case 0x1d:
      case 0x1e:
      case 0x1f:
      case 0x20:
      case 0x21:
      case 0x22:
      case 0x23:
      case 0x24:
      case 0x25:
      case 0x26:
      case 0x27:
      case 0x28:
      case 0x29:
      case 0x2b:
      case 0x2e:
      case 0x2f:
      case 0x30:
      case 0x31:
      case 0x32:
      case 0x33:
      case 0x34:
      case 0x35:
      case 0x36:
      case 0x37:
      case 0x38:
      case 0x39:
      case 0x3b:
      case 0x3c:
      case 0x3d:
      case 0x3e:
        break;
      case 5:
      case 0xf:
      case 0x2c:
      case 0x3a:
        goto switchD_001040c8_caseD_5;
      case 0x11:
        uVar28 = 0x1f;
      case 0x2a:
        bVar1 = false;
        pcVar47 = (code *)(*(long *)(lVar10 + -8) + uVar39);
        goto LAB_00104608;
      default:
        if ((uVar46 != 0x5af) && (uVar35 = uVar28, uVar46 != 0x6af)) break;
        uVar28 = uVar35;
        pcVar47 = (code *)plVar49[uVar32 + 1];
        bVar1 = false;
        goto LAB_00104608;
      }
    case 0x16:
    case 0x3e:
      goto switchD_00103364_caseD_16;
    case 0x18:
      uVar46 = uVar45;
LAB_00104128:
      uVar45 = 0x400066f;
      if ((uVar38 & 0x4000fff) != 0x400066f) {
        uVar45 = uVar46;
      }
switchD_00103364_caseD_16:
      if (uVar45 < 0xd6f) {
        if (uVar45 < 0x5ef) {
          if (uVar45 == 0xaf) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 *(long *)(lVar25 + uVar29 * 8) >> (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
          }
          else if (uVar45 == 0x32f) {
            lVar25 = lVar10 + -0x130;
            *(ulong *)(lVar25 + uVar36 * 8) =
                 *(ulong *)(lVar25 + uVar29 * 8) >> (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
          }
        }
        else {
          if (uVar45 == 0x5ef) {
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          }
          else {
            if (uVar45 != 0x66f) break;
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (ulong)(*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          }
LAB_00103d1c:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)(int)uVar38;
        }
      }
      else if (uVar45 < 0x400032f) {
        if (uVar45 == 0xd6f) {
          lVar25 = lVar10 + -0x130;
          *(long *)(lVar25 + uVar36 * 8) =
               *(long *)(lVar25 + uVar29 * 8) << (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
        }
        else if (uVar45 == 0xfef) {
          uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) <<
                   (ulong)(*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          goto LAB_00103d1c;
        }
      }
      else if (uVar45 == 0x400032f) {
        lVar25 = lVar10 + -0x130;
        uVar29 = *(ulong *)(lVar25 + uVar29 * 8);
        uVar32 = (ulong)(*(uint *)(lVar25 + uVar32 * 8) & 0x3f);
        *(ulong *)(lVar25 + uVar36 * 8) = uVar29 >> uVar32 | uVar29 << 0x40 - uVar32;
      }
      else if (uVar45 == 0x400066f) {
        uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
        uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f;
        uVar38 = uVar46 >> uVar38 | uVar46 << 0x20 - uVar38;
        goto LAB_00103d1c;
      }
      break;
    case 0x29:
      lVar25 = lVar10 + -0x130;
      puVar31 = (undefined8 *)(lVar25 + uVar36 * 8);
      if (*(long *)(lVar25 + uVar32 * 8) < *(long *)(lVar25 + uVar29 * 8)) goto LAB_00104230;
LAB_00104048:
      *puVar31 = 0;
      break;
    case 0x2d:
      uVar44 = uVar45;
      goto LAB_00103a58;
    case 0x3b:
      uVar43 = uVar45;
LAB_00103a4c:
      uVar44 = 0x200f2f;
      if ((uVar38 & 0x200fff) != 0x200f2f) {
        uVar44 = uVar43;
      }
LAB_00103a58:
      uVar45 = 0x200baf;
      if ((uVar38 & 0x200fff) != 0x200baf) {
        uVar45 = uVar44;
      }
switchD_00103364_caseD_a:
      if (uVar45 < 0xc6f) {
        if (uVar45 < 0x8ef) {
          if (uVar45 == 0x2ef) {
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (uVar13 | uVar7 & 3 | uVar46 | uVar28);
            goto LAB_00104330;
          }
          if (uVar45 == 0x3ef) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            uVar39 = (ulong)(uVar14 | 0x20);
LAB_00104300:
            *(long *)(lVar10 + -0x130 + uVar36 * 8) = lVar25 >> uVar39;
          }
          else if (uVar45 == 0x46f) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_001042d8;
          }
        }
        else if (uVar45 == 0x8ef) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
LAB_001042ec:
          *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> uVar39;
        }
        else {
          if (uVar45 == 0xb6f) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00104300;
          }
          if (uVar45 == 0xbaf) {
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28);
            goto LAB_00104330;
          }
        }
      }
      else if (uVar45 < 0x2008ef) {
        if (uVar45 == 0xc6f) {
          uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) <<
                   (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28);
LAB_00104330:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)(int)uVar38;
        }
        else if (uVar45 == 0xcaf) {
          lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
LAB_001042d8:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = lVar25 << uVar39;
        }
        else if (uVar45 == 0xf2f) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
          goto LAB_001042ec;
        }
      }
      else {
        if (uVar45 == 0x2008ef) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        }
        else {
          if (uVar45 == 0x200baf) {
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = uVar13 | uVar7 & 3 | uVar46 | uVar28;
            uVar38 = uVar38 >> uVar28 | uVar38 << 0x20 - uVar28;
            goto LAB_00104330;
          }
          if (uVar45 != 0x200f2f) break;
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
        }
        *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> uVar39 | uVar29 << 0x40 - uVar39;
      }
    }
    break;
  case 0x32:
    *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
         (ulong)(*(long *)(lVar10 + -0x130 + uVar32 * 8) <
                (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                              uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 | uVar15 >> 4));
  }
switchD_00102e50_caseD_1:
  lVar25 = *(long *)(lVar10 + -0x20);
  param_1 = (code *)(*plVar49 + 4);
  *plVar49 = (long)param_1;
  if (lVar25 != 2) {
    if ((lVar25 == 3) || (lVar25 == 1)) {
      param_1 = *(code **)(lVar10 + -0x18);
      *(undefined8 *)(lVar10 + -0x20) = 0;
      *plVar49 = (long)param_1;
    }
    if (param_1 == pcVar9) {
      (*pcVar9)(*(undefined8 *)(lVar10 + -0x110),*(undefined8 *)(lVar10 + -0x108));
      param_1 = *(code **)(lVar10 + -0x10);
      *plVar49 = (long)param_1;
    }
  }
  if (param_1 == (code *)0x0) {
    return;
  }
LAB_00102dd8:
  lVar25 = *(long *)(lVar10 + -0x20);
  goto LAB_00102ddc;
switchD_001040c8_caseD_5:
  lVar25 = plVar49[uVar36 + 1];
switchD_001040c8_caseD_3:
  if (0x3c < (uVar38 & 0xfff) - 3) goto switchD_00102e50_caseD_1;
  lVar33 = plVar49[uVar32 + 1];
  pcVar47 = param_1 + (uVar14 + 4);
  switch(uVar38 & 0xfff) {
  case 3:
    if (lVar33 < 1) {
LAB_0010459c:
      bVar1 = false;
      goto LAB_001045a0;
    }
    break;
  default:
    goto switchD_00102e50_caseD_1;
  case 5:
    if (lVar33 == lVar25) goto LAB_0010459c;
    break;
  case 0xf:
    if (lVar33 != lVar25) goto LAB_0010459c;
    break;
  case 0x1a:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_001045a0;
LAB_00104588:
    bVar1 = true;
    goto LAB_0010458c;
  case 0x2c:
    bVar1 = true;
    if (lVar33 == lVar25) goto LAB_00104588;
    goto LAB_001045a0;
  case 0x2d:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_00104588;
    goto LAB_001045a0;
  case 0x3a:
    bVar1 = true;
    if (lVar33 != lVar25) goto LAB_00104588;
LAB_001045a0:
    bVar37 = 0;
    uVar28 = 0;
    pcVar47 = param_1 + 8;
    bVar41 = 1;
    goto LAB_0010460c;
  case 0x3f:
    if (0 < lVar33) goto LAB_0010459c;
  }
  bVar1 = false;
LAB_0010458c:
  uVar28 = 0;
LAB_00104608:
  bVar41 = 0;
  bVar37 = 1;
LAB_0010460c:
  *(code **)(lVar10 + -0x18) = pcVar47;
  if ((((bool)(bVar41 & bVar1)) || (!bVar1)) || ((bool)(bVar37 & bVar1))) {
    uVar8 = 1;
    if (!(bool)(bVar41 & bVar1)) {
      uVar8 = 2;
    }
    *(undefined8 *)(lVar10 + -0x20) = uVar8;
  }
joined_r0x00104640:
  if (uVar28 != 0) {
    plVar49[(long)(int)uVar28 + 1] = (long)(param_1 + 8);
    *(code **)(lVar10 + -0x10) = param_1 + 8;
  }
  goto switchD_00102e50_caseD_1;
switchD_00102f1c_caseD_5:
  lVar25 = plVar49[uVar29 + 1];
switchD_00102f1c_caseD_3:
  if (0x3c < (uVar38 & 0x3f) - 3) goto switchD_00102e50_caseD_1;
  lVar33 = plVar49[uVar32 + 1];
  pcVar47 = param_1 + (int)(uVar46 + 4);
  switch(uVar38 & 0x3f) {
  case 3:
    if (lVar33 < 1) {
LAB_0010362c:
      bVar1 = false;
      goto LAB_00103630;
    }
    break;
  default:
    goto switchD_00102e50_caseD_1;
  case 5:
    if (lVar33 == lVar25) goto LAB_0010362c;
    break;
  case 0xf:
    if (lVar33 != lVar25) goto LAB_0010362c;
    break;
  case 0x1a:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_00103630;
LAB_00103614:
    bVar1 = true;
    goto LAB_00103618;
  case 0x2c:
    bVar1 = true;
    if (lVar33 == lVar25) goto LAB_00103614;
    goto LAB_00103630;
  case 0x2d:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_00103614;
    goto LAB_00103630;
  case 0x3a:
    bVar1 = true;
    if (lVar33 != lVar25) goto LAB_00103614;
LAB_00103630:
    bVar41 = 0;
    iVar34 = 0;
    pcVar47 = param_1 + 8;
    bVar37 = 1;
    goto LAB_00103640;
  case 0x3f:
    if (0 < lVar33) goto LAB_0010362c;
  }
  bVar1 = false;
LAB_00103618:
  bVar37 = 0;
  iVar34 = 0;
  bVar41 = 1;
LAB_00103640:
  *(code **)(lVar10 + -0x18) = pcVar47;
  if ((((bool)(bVar37 & bVar1)) || (!bVar1)) || ((bool)(bVar41 & bVar1))) {
    uVar8 = 1;
    if (!(bool)(bVar37 & bVar1)) {
      uVar8 = 2;
    }
    *(undefined8 *)(lVar10 + -0x20) = uVar8;
  }
joined_r0x00103f94:
  if (iVar34 != 0) {
    plVar49[(long)iVar34 + 1] = (long)(param_1 + 8);
    *(code **)(lVar10 + -0x10) = param_1 + 8;
  }
  goto switchD_00102e50_caseD_1;
}



// ===== FUN_00104678 @ 00104678 size=1160 =====

undefined8 FUN_00104678(uint *param_1,uint *param_2,uint param_3)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  undefined8 uVar4;
  ulong uVar5;
  uint uVar6;
  uint *puVar7;
  long lVar8;
  ulong uVar9;
  long lVar10;
  long lVar11;
  uint *puVar12;
  
  uVar4 = 0xff;
  if ((param_3 < 0x21) && ((1L << ((ulong)param_3 & 0x3f) & 0x100014000U) != 0)) {
    uVar5 = (ulong)((param_3 >> 2 & 0x3ffffffe) + 6);
    *(ulong *)(param_1 + 0x78) = uVar5;
    uVar6 = (*param_2 & 0xff00ff00) >> 8 | (*param_2 & 0xff00ff) << 8;
    uVar6 = uVar6 >> 0x10 | uVar6 << 0x10;
    *param_1 = uVar6;
    uVar3 = (param_2[1] & 0xff00ff00) >> 8 | (param_2[1] & 0xff00ff) << 8;
    param_1[1] = uVar3 >> 0x10 | uVar3 << 0x10;
    uVar3 = (param_2[2] & 0xff00ff00) >> 8 | (param_2[2] & 0xff00ff) << 8;
    param_1[2] = uVar3 >> 0x10 | uVar3 << 0x10;
    uVar3 = (param_2[3] & 0xff00ff00) >> 8 | (param_2[3] & 0xff00ff) << 8;
    param_1[3] = uVar3 >> 0x10 | uVar3 << 0x10;
    if (param_3 == 0xe) {
      uVar3 = (param_2[4] & 0xff00ff00) >> 8 | (param_2[4] & 0xff00ff) << 8;
      param_1[4] = uVar3 >> 0x10 | uVar3 << 0x10;
      lVar8 = 0;
      uVar3 = (param_2[5] & 0xff00ff00) >> 8 | (param_2[5] & 0xff00ff) << 8;
      param_1[5] = uVar3 >> 0x10 | uVar3 << 0x10;
      puVar7 = param_1;
      while( true ) {
        uVar2 = puVar7[5];
        uVar6 = *(uint *)(&DAT_0010b5c4 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) ^ uVar6 ^
                *(uint *)(&DAT_0010b9c4 + (ulong)(uVar2 >> 8 & 0xff) * 4) ^
                *(uint *)(&DAT_0010bdc4 + ((ulong)uVar2 & 0xff) * 4) ^
                *(uint *)(&DAT_0010c1c4 + (ulong)(uVar2 >> 0x18) * 4) ^
                *(uint *)((long)&DAT_0010c5c4 + lVar8);
        uVar1 = puVar7[2] ^ puVar7[1] ^ uVar6;
        puVar7[6] = uVar6;
        puVar7[7] = puVar7[1] ^ uVar6;
        uVar3 = puVar7[3] ^ uVar1;
        puVar7[8] = uVar1;
        puVar7[9] = uVar3;
        if (lVar8 == 0x1c) break;
        lVar8 = lVar8 + 4;
        uVar3 = puVar7[4] ^ uVar3;
        puVar7[10] = uVar3;
        puVar7[0xb] = uVar3 ^ uVar2;
        puVar7 = puVar7 + 6;
      }
    }
    else if (param_3 == 0x20) {
      uVar3 = (param_2[4] & 0xff00ff00) >> 8 | (param_2[4] & 0xff00ff) << 8;
      param_1[4] = uVar3 >> 0x10 | uVar3 << 0x10;
      lVar8 = 0;
      uVar3 = (param_2[5] & 0xff00ff00) >> 8 | (param_2[5] & 0xff00ff) << 8;
      param_1[5] = uVar3 >> 0x10 | uVar3 << 0x10;
      uVar3 = (param_2[6] & 0xff00ff00) >> 8 | (param_2[6] & 0xff00ff) << 8;
      param_1[6] = uVar3 >> 0x10 | uVar3 << 0x10;
      uVar3 = (param_2[7] & 0xff00ff00) >> 8 | (param_2[7] & 0xff00ff) << 8;
      param_1[7] = uVar3 >> 0x10 | uVar3 << 0x10;
      puVar7 = param_1;
      while( true ) {
        uVar2 = puVar7[7];
        uVar6 = *(uint *)(&DAT_0010b5c4 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) ^ uVar6 ^
                *(uint *)(&DAT_0010b9c4 + (ulong)(uVar2 >> 8 & 0xff) * 4) ^
                *(uint *)(&DAT_0010bdc4 + ((ulong)uVar2 & 0xff) * 4) ^
                *(uint *)(&DAT_0010c1c4 + (ulong)(uVar2 >> 0x18) * 4) ^
                *(uint *)((long)&DAT_0010c5c4 + lVar8);
        uVar3 = puVar7[2] ^ puVar7[1] ^ uVar6;
        puVar7[8] = uVar6;
        puVar7[9] = puVar7[1] ^ uVar6;
        uVar1 = puVar7[3] ^ uVar3;
        puVar7[10] = uVar3;
        puVar7[0xb] = uVar1;
        if (lVar8 == 0x18) break;
        uVar3 = uVar1 >> 8 | uVar1 << 0x18;
        lVar8 = lVar8 + 4;
        uVar3 = *(uint *)(&DAT_0010b5c4 + ((ulong)(uVar3 >> 0x10) & 0xff) * 4) ^ puVar7[4] ^
                *(uint *)(&DAT_0010b9c4 + ((ulong)(uVar3 >> 8) & 0xff) * 4) ^
                *(uint *)(&DAT_0010bdc4 + ((ulong)uVar3 & 0xff) * 4) ^
                *(uint *)(&DAT_0010c1c4 + ((ulong)(uVar3 >> 0x16) & 0x3fc));
        uVar1 = puVar7[5] ^ uVar3;
        puVar7[0xc] = uVar3;
        puVar7[0xd] = uVar1;
        uVar1 = puVar7[6] ^ uVar1;
        puVar7[0xe] = uVar1;
        puVar7[0xf] = uVar1 ^ uVar2;
        puVar7 = puVar7 + 8;
      }
    }
    else if (param_3 == 0x10) {
      lVar8 = 0;
      puVar7 = param_1;
      do {
        uVar1 = puVar7[3];
        puVar12 = (uint *)((long)&DAT_0010c5c4 + lVar8);
        lVar8 = lVar8 + 4;
        uVar6 = *(uint *)(&DAT_0010b5c4 + (ulong)(uVar1 >> 0x10 & 0xff) * 4) ^ uVar6 ^
                *(uint *)(&DAT_0010b9c4 + (ulong)(uVar1 >> 8 & 0xff) * 4) ^
                *(uint *)(&DAT_0010bdc4 + ((ulong)uVar1 & 0xff) * 4) ^
                *(uint *)(&DAT_0010c1c4 + (ulong)(uVar1 >> 0x18) * 4) ^ *puVar12;
        puVar7[4] = uVar6;
        puVar7[5] = puVar7[1] ^ uVar6;
        uVar3 = puVar7[2] ^ puVar7[1] ^ uVar6;
        puVar7[6] = uVar3;
        puVar7[7] = uVar3 ^ uVar1;
        puVar7 = puVar7 + 4;
      } while (lVar8 != 0x28);
    }
    uVar9 = (ulong)(param_3 + 0x1c);
    lVar11 = uVar5 * 4;
    param_1[0x3c] = param_1[uVar9 - 4];
    param_1[0x3d] = param_1[uVar9 - 3];
    lVar10 = (uVar9 - 0x18) - (lVar11 + -0x18);
    puVar7 = param_1 + 0x40;
    param_1[0x3e] = param_1[uVar9 - 2];
    lVar8 = uVar5 - 1;
    param_1[0x3f] = param_1[uVar9 - 1];
    puVar12 = param_1 + (uVar9 - 8);
    do {
      uVar6 = *puVar12;
      lVar8 = lVar8 + -1;
      *puVar7 = *(uint *)(&DAT_0010c9ec + (ulong)(uVar6 >> 0x10 & 0xff) * 4) ^
                *(uint *)(&DAT_0010c5ec + (ulong)(uVar6 >> 0x18) * 4) ^
                *(uint *)(&DAT_0010cdec + (ulong)(uVar6 >> 8 & 0xff) * 4) ^
                *(uint *)(&DAT_0010d1ec + ((ulong)uVar6 & 0xff) * 4);
      uVar6 = puVar12[1];
      puVar7[1] = *(uint *)(&DAT_0010c9ec + (ulong)(uVar6 >> 0x10 & 0xff) * 4) ^
                  *(uint *)(&DAT_0010c5ec + (ulong)(uVar6 >> 0x18) * 4) ^
                  *(uint *)(&DAT_0010cdec + (ulong)(uVar6 >> 8 & 0xff) * 4) ^
                  *(uint *)(&DAT_0010d1ec + ((ulong)uVar6 & 0xff) * 4);
      uVar6 = puVar12[2];
      puVar7[2] = *(uint *)(&DAT_0010c9ec + (ulong)(uVar6 >> 0x10 & 0xff) * 4) ^
                  *(uint *)(&DAT_0010c5ec + (ulong)(uVar6 >> 0x18) * 4) ^
                  *(uint *)(&DAT_0010cdec + (ulong)(uVar6 >> 8 & 0xff) * 4) ^
                  *(uint *)(&DAT_0010d1ec + ((ulong)uVar6 & 0xff) * 4);
      uVar6 = puVar12[3];
      puVar12 = puVar12 + -4;
      puVar7[3] = *(uint *)(&DAT_0010c9ec + (ulong)(uVar6 >> 0x10 & 0xff) * 4) ^
                  *(uint *)(&DAT_0010c5ec + (ulong)(uVar6 >> 0x18) * 4) ^
                  *(uint *)(&DAT_0010cdec + (ulong)(uVar6 >> 8 & 0xff) * 4) ^
                  *(uint *)(&DAT_0010d1ec + ((ulong)uVar6 & 0xff) * 4);
      puVar7 = puVar7 + 4;
    } while (lVar8 != 0);
    param_1[lVar11 + 0x3c] = param_1[(uVar9 - 0x1c) - (lVar11 + -0x18)];
    param_1[lVar11 + 0x3d] = param_1[lVar10 + -3];
    param_1[lVar11 + 0x3e] = param_1[lVar10 + -2];
    param_1[lVar11 + 0x3f] = param_1[lVar10 + -1];
    uVar4 = 0;
  }
  return uVar4;
}



// ===== FUN_00104b00 @ 00104b00 size=128 =====

void FUN_00104b00(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 param_5,undefined8 param_6)

{
  long lVar1;
  undefined8 local_4b8;
  undefined8 uStack_4b0;
  undefined8 local_4a8;
  undefined8 uStack_4a0;
  undefined8 local_498;
  undefined8 uStack_490;
  code *local_488;
  undefined1 *puStack_480;
  undefined1 auStack_30 [8];
  long local_28;
  
  lVar1 = tpidr_el0;
  local_28 = *(long *)(lVar1 + 0x28);
  puStack_480 = auStack_30;
  local_488 = FUN_00104c78;
  local_4b8 = param_1;
  uStack_4b0 = param_2;
  local_4a8 = param_3;
  uStack_4a0 = param_4;
  local_498 = param_5;
  uStack_490 = param_6;
  FUN_00104c84(&DAT_0010dfd0,&local_4b8,0,&DAT_00117d20,&local_488);
  if (*(long *)(lVar1 + 0x28) == local_28) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00104b80 @ 00104b80 size=28 =====

void FUN_00104b80(size_t *param_1)

{
  void *pvVar1;
  
  pvVar1 = malloc(*param_1);
  param_1[1] = (size_t)pvVar1;
  return;
}



// ===== FUN_00104b9c @ 00104b9c size=16 =====

void FUN_00104b9c(undefined8 *param_1)

{
  FUN_00106dac(*param_1,param_1[1],param_1[2]);
  return;
}



// ===== FUN_00104bac @ 00104bac size=16 =====

void FUN_00104bac(undefined8 *param_1)

{
  memcpy((void *)*param_1,(void *)param_1[1],param_1[2]);
  return;
}



// ===== FUN_00104bbc @ 00104bbc size=180 =====

void FUN_00104bbc(long *param_1)

{
  long lVar1;
  long lVar2;
  byte *pbVar3;
  ulong uVar4;
  long lVar5;
  ulong uVar6;
  byte *pbVar7;
  byte *pbVar8;
  undefined8 *puVar9;
  undefined8 *puVar10;
  undefined8 *puVar11;
  ulong uVar12;
  undefined8 uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  undefined8 uVar17;
  undefined8 uVar18;
  undefined8 uVar19;
  undefined8 uVar20;
  
  uVar4 = param_1[2];
  if (uVar4 != 0) {
    lVar1 = *param_1;
    lVar2 = param_1[1];
    if (uVar4 < 0x20) {
      uVar6 = 0;
    }
    else {
      uVar6 = uVar4 & 0xffffffffffffffe0;
      puVar9 = (undefined8 *)(lVar1 + lVar2 + 0x10);
      puVar10 = (undefined8 *)&DAT_0010df60;
      puVar11 = (undefined8 *)&DAT_0010dfa0;
      uVar12 = uVar6;
      do {
        uVar14 = puVar10[-1];
        uVar13 = puVar10[-2];
        uVar16 = puVar10[1];
        uVar15 = *puVar10;
        uVar18 = puVar11[-1];
        uVar17 = puVar11[-2];
        uVar20 = puVar11[1];
        uVar19 = *puVar11;
        puVar10 = puVar10 + 4;
        puVar11 = puVar11 + 4;
        uVar12 = uVar12 - 0x20;
        puVar9[-1] = CONCAT17((byte)((ulong)uVar18 >> 0x38) ^ (byte)((ulong)uVar14 >> 0x38),
                              CONCAT16((byte)((ulong)uVar18 >> 0x30) ^ (byte)((ulong)uVar14 >> 0x30)
                                       ,CONCAT15((byte)((ulong)uVar18 >> 0x28) ^
                                                 (byte)((ulong)uVar14 >> 0x28),
                                                 CONCAT14((byte)((ulong)uVar18 >> 0x20) ^
                                                          (byte)((ulong)uVar14 >> 0x20),
                                                          CONCAT13((byte)((ulong)uVar18 >> 0x18) ^
                                                                   (byte)((ulong)uVar14 >> 0x18),
                                                                   CONCAT12((byte)((ulong)uVar18 >>
                                                                                  0x10) ^
                                                                            (byte)((ulong)uVar14 >>
                                                                                  0x10),
                                                                            CONCAT11((byte)((ulong)
                                                  uVar18 >> 8) ^ (byte)((ulong)uVar14 >> 8),
                                                  (byte)uVar18 ^ (byte)uVar14)))))));
        puVar9[-2] = CONCAT17((byte)((ulong)uVar17 >> 0x38) ^ (byte)((ulong)uVar13 >> 0x38),
                              CONCAT16((byte)((ulong)uVar17 >> 0x30) ^ (byte)((ulong)uVar13 >> 0x30)
                                       ,CONCAT15((byte)((ulong)uVar17 >> 0x28) ^
                                                 (byte)((ulong)uVar13 >> 0x28),
                                                 CONCAT14((byte)((ulong)uVar17 >> 0x20) ^
                                                          (byte)((ulong)uVar13 >> 0x20),
                                                          CONCAT13((byte)((ulong)uVar17 >> 0x18) ^
                                                                   (byte)((ulong)uVar13 >> 0x18),
                                                                   CONCAT12((byte)((ulong)uVar17 >>
                                                                                  0x10) ^
                                                                            (byte)((ulong)uVar13 >>
                                                                                  0x10),
                                                                            CONCAT11((byte)((ulong)
                                                  uVar17 >> 8) ^ (byte)((ulong)uVar13 >> 8),
                                                  (byte)uVar17 ^ (byte)uVar13)))))));
        puVar9[1] = CONCAT17((byte)((ulong)uVar20 >> 0x38) ^ (byte)((ulong)uVar16 >> 0x38),
                             CONCAT16((byte)((ulong)uVar20 >> 0x30) ^ (byte)((ulong)uVar16 >> 0x30),
                                      CONCAT15((byte)((ulong)uVar20 >> 0x28) ^
                                               (byte)((ulong)uVar16 >> 0x28),
                                               CONCAT14((byte)((ulong)uVar20 >> 0x20) ^
                                                        (byte)((ulong)uVar16 >> 0x20),
                                                        CONCAT13((byte)((ulong)uVar20 >> 0x18) ^
                                                                 (byte)((ulong)uVar16 >> 0x18),
                                                                 CONCAT12((byte)((ulong)uVar20 >>
                                                                                0x10) ^
                                                                          (byte)((ulong)uVar16 >>
                                                                                0x10),
                                                                          CONCAT11((byte)((ulong)
                                                  uVar20 >> 8) ^ (byte)((ulong)uVar16 >> 8),
                                                  (byte)uVar20 ^ (byte)uVar16)))))));
        *puVar9 = CONCAT17((byte)((ulong)uVar19 >> 0x38) ^ (byte)((ulong)uVar15 >> 0x38),
                           CONCAT16((byte)((ulong)uVar19 >> 0x30) ^ (byte)((ulong)uVar15 >> 0x30),
                                    CONCAT15((byte)((ulong)uVar19 >> 0x28) ^
                                             (byte)((ulong)uVar15 >> 0x28),
                                             CONCAT14((byte)((ulong)uVar19 >> 0x20) ^
                                                      (byte)((ulong)uVar15 >> 0x20),
                                                      CONCAT13((byte)((ulong)uVar19 >> 0x18) ^
                                                               (byte)((ulong)uVar15 >> 0x18),
                                                               CONCAT12((byte)((ulong)uVar19 >> 0x10
                                                                              ) ^ (byte)((ulong)
                                                  uVar15 >> 0x10),
                                                  CONCAT11((byte)((ulong)uVar19 >> 8) ^
                                                           (byte)((ulong)uVar15 >> 8),
                                                           (byte)uVar19 ^ (byte)uVar15)))))));
        puVar9 = puVar9 + 4;
      } while (uVar12 != 0);
      if (uVar4 == uVar6) {
        return;
      }
    }
    lVar5 = uVar4 - uVar6;
    pbVar3 = (byte *)(lVar1 + uVar6 + lVar2);
    pbVar7 = &DAT_0010df50 + uVar6;
    pbVar8 = &DAT_0010df90 + uVar6;
    do {
      lVar5 = lVar5 + -1;
      *pbVar3 = *pbVar8 ^ *pbVar7;
      pbVar3 = pbVar3 + 1;
      pbVar7 = pbVar7 + 1;
      pbVar8 = pbVar8 + 1;
    } while (lVar5 != 0);
  }
  return;
}



// ===== FUN_00104c70 @ 00104c70 size=8 =====

void FUN_00104c70(undefined8 *param_1)

{
  free((void *)*param_1);
  return;
}



// ===== FUN_00104c78 @ 00104c78 size=12 =====

void FUN_00104c78(code *UNRECOVERED_JUMPTABLE,undefined8 param_2)

{
                    /* WARNING: Could not recover jumptable at 0x00104c80. Too many branches */
                    /* WARNING: Treating indirect jump as call */
  (*UNRECOVERED_JUMPTABLE)(param_2);
  return;
}



// ===== FUN_00104c84 @ 00104c84 size=6476 =====

void FUN_00104c84(code *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 undefined8 *param_5)

{
  bool bVar1;
  ulong *puVar2;
  long *plVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  undefined8 uVar8;
  code *pcVar9;
  long lVar10;
  undefined4 uVar11;
  undefined4 uVar12;
  uint uVar13;
  uint uVar14;
  ushort uVar15;
  undefined1 auVar16 [16];
  undefined1 auVar17 [16];
  ushort uVar18;
  ushort uVar19;
  ushort uVar20;
  ushort uVar21;
  ushort uVar22;
  ushort uVar23;
  bool bVar24;
  long lVar25;
  ulong *puVar26;
  ulong *puVar27;
  uint uVar28;
  ulong uVar29;
  code *pcVar30;
  undefined8 *puVar31;
  ulong uVar32;
  long lVar33;
  int iVar34;
  uint uVar35;
  ulong uVar36;
  byte bVar37;
  uint uVar38;
  ulong uVar39;
  code *pcVar40;
  byte bVar41;
  bool bVar42;
  uint uVar43;
  uint uVar44;
  uint uVar45;
  uint uVar46;
  code *pcVar47;
  ulong uVar48;
  long *plVar49;
  
  pcVar9 = (code *)*param_5;
  lVar10 = param_5[1];
  *(undefined8 *)(lVar10 + -0x38) = 0;
  *(undefined8 *)(lVar10 + -0x130) = 0;
  plVar49 = (long *)(lVar10 + -0x138);
  *(ulong *)(lVar10 + -0x48) = lVar10 - 0x148U & 0xfffffffffffffff0;
  *(undefined8 *)(lVar10 + -0x20) = 0;
  *(undefined8 *)(lVar10 + -0x110) = param_2;
  *(undefined8 *)(lVar10 + -0x108) = param_3;
  *(undefined8 *)(lVar10 + -0x100) = param_4;
  *(code **)(lVar10 + -0xf8) = pcVar9;
  *plVar49 = (long)param_1;
  *(code **)(lVar10 + -8) = param_1;
  if (param_1 == (code *)0x0) {
    return;
  }
  lVar25 = 0;
  puVar26 = (ulong *)(lVar10 + -0x28);
  puVar27 = (ulong *)(lVar10 + -0x30);
LAB_00104d34:
  uVar38 = *(uint *)param_1;
  if (lVar25 == 2) {
    lVar25 = 3;
    *(undefined8 *)(lVar10 + -0x20) = 3;
  }
  if (0x3f < (uVar38 & 0x3f)) goto switchD_00104da8_caseD_1;
  uVar46 = uVar38 >> 0xb;
  uVar45 = uVar38 & 0x10000000;
  uVar13 = uVar45 >> 0x1a;
  uVar43 = uVar38 & 0x20000000;
  uVar7 = uVar38 >> 0x1a;
  uVar44 = uVar38 & 0x40000000;
  uVar35 = uVar46 & 2 | uVar38 >> 0x1f | uVar46 & 4 | uVar46 & 8 | uVar46 & 0x10;
  uVar36 = (ulong)uVar35;
  uVar46 = uVar43 >> 0x1a;
  uVar32 = (ulong)(uVar38 >> 0x15 & 0x1f);
  uVar29 = (ulong)(uVar38 >> 0x10 & 0x1f);
  uVar4 = uVar38 & 0x80000000;
  uVar5 = uVar38 & 0x4000000;
  uVar6 = uVar38 & 0x8000000;
  uVar28 = uVar44 >> 0x1a;
  uVar14 = uVar13 | uVar7 & 3 | uVar46 | uVar28;
  uVar39 = (ulong)uVar14;
  uVar15 = (ushort)(uVar4 >> 0x10);
  uVar18 = (ushort)(uVar44 >> 0x10);
  uVar19 = (ushort)(uVar43 >> 0x10);
  uVar20 = (ushort)(uVar45 >> 0x10);
  uVar21 = (ushort)(uVar6 >> 0x10);
  uVar22 = (ushort)uVar38;
  uVar23 = (ushort)(uVar5 >> 0x10);
  switch(uVar38 & 0x3f) {
  case 0:
  case 2:
  case 8:
  case 0x12:
  case 0x1f:
  case 0x21:
  case 0x22:
  case 0x27:
  case 0x2b:
  case 0x30:
  case 0x31:
  case 0x33:
  case 0x37:
    if ((uVar38 & 0x3f) < 0x38) {
      puVar2 = (ulong *)(plVar49[uVar32 + 1] +
                        (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                      uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                     uVar15 >> 4));
      switch(uVar38 & 0x3f) {
      case 0:
        uVar32 = (ulong)(short)*puVar2;
        break;
      default:
        goto switchD_00104da8_caseD_1;
      case 2:
        uVar32 = *puVar2;
        break;
      case 8:
        uVar32 = (ulong)(char)*puVar2;
        break;
      case 0x12:
        uVar38 = (uint)puVar2 & 3;
        uVar32 = (ulong)(*(uint *)(plVar49 + uVar29 + 1) & -1 << (ulong)(uVar38 * -8 + 0x20 & 0x1f)
                        | *(uint *)((ulong)puVar2 & 0xfffffffffffffffc) >> (ulong)(uVar38 * 8));
        break;
      case 0x21:
        uVar32 = (ulong)(byte)*puVar2;
        break;
      case 0x22:
        uVar32 = (plVar49 + uVar29)[1] & -1L << (((ulong)puVar2 & 7) * -8 + 0x40 & 0x3f) |
                 *(ulong *)((ulong)puVar2 & 0xfffffffffffffff8) >> ((ulong)puVar2 & 7) * 8;
        break;
      case 0x27:
      case 0x31:
        uVar32 = (plVar49 + uVar29)[1] & 0xffffffffffffffU >> ((ulong)puVar2 & 7) * 8 |
                 *(long *)((ulong)puVar2 & 0xfffffffffffffff8) <<
                 (((ulong)puVar2 & 7) * -8 + 0x38 & 0x3f);
        break;
      case 0x2b:
        uVar32 = (ulong)(int)(uint)*puVar2;
        break;
      case 0x30:
        uVar32 = (ulong)(ushort)*puVar2;
        break;
      case 0x33:
        uVar32 = (ulong)(uint)*puVar2;
        break;
      case 0x37:
        uVar38 = (uint)puVar2 & 3;
        uVar32 = (ulong)(*(uint *)(plVar49 + uVar29 + 1) & 0xffffffU >> (ulong)(uVar38 * 8) |
                        *(int *)((ulong)puVar2 & 0xfffffffffffffffc) <<
                        (ulong)(uVar38 * -8 + 0x18 & 0x1f));
      }
LAB_00105b7c:
      (plVar49 + uVar29)[1] = uVar32;
    }
    break;
  case 3:
  case 5:
  case 0xf:
  case 0x1a:
  case 0x2c:
  case 0x2d:
  case 0x3a:
  case 0x3f:
    if ((lVar25 != 0) || (0x3c < (uVar38 & 0x3f) - 3)) break;
    iVar34 = 0;
    lVar25 = 0;
    uVar46 = -((uVar38 & 0xf000) >> 0xf) & 0xfffc0000 |
             (uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14
              | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    switch(uVar38 & 0x3f) {
    case 3:
    case 0x1a:
    case 0x2d:
    case 0x3f:
      goto switchD_00104e74_caseD_3;
    default:
      break;
    case 5:
    case 0xf:
    case 0x2c:
    case 0x3a:
      goto switchD_00104e74_caseD_5;
    case 0x11:
      iVar34 = 0x1f;
    case 0x2a:
      bVar37 = 0;
      bVar1 = false;
      bVar41 = 1;
      pcVar47 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar46);
      goto LAB_00105598;
    }
  case 4:
  case 0x20:
  case 0x38:
  case 0x3e:
    uVar46 = uVar38 & 0x3f;
    uVar38 = uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14 |
             uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14;
    if (uVar46 < 0x38) {
      if (uVar46 == 4) {
        uVar38 = uVar38 << 0x10;
LAB_001054dc:
        uVar32 = (ulong)(int)uVar38;
        goto LAB_00105b7c;
      }
      if (uVar46 == 0x20) {
        *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
             *(ulong *)(lVar10 + -0x130 + uVar32 * 8) & (ulong)uVar38;
      }
    }
    else if (uVar46 == 0x38) {
      *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
           *(ulong *)(lVar10 + -0x130 + uVar32 * 8) ^ (ulong)uVar38;
    }
    else if (uVar46 == 0x3e) {
      *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
           *(ulong *)(lVar10 + -0x130 + uVar32 * 8) | (ulong)uVar38;
    }
    break;
  case 10:
  case 0xb:
  case 0xe:
  case 0x14:
  case 0x16:
  case 0x24:
  case 0x36:
  case 0x3b:
    if (0x31 < (uVar38 & 0x3f) - 10) break;
    plVar3 = (long *)(plVar49[uVar32 + 1] +
                     (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                   uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                  uVar15 >> 4));
    switch(uVar38 & 0x3f) {
    case 10:
      uVar29 = (ulong)plVar49[uVar29 + 1] >> (((ulong)plVar3 & 7) * -8 + 0x38 & 0x3f);
      uVar32 = *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) & -0x100L << ((ulong)plVar3 & 7) * 8;
      goto LAB_00105428;
    case 0xb:
      uVar29 = plVar49[uVar29 + 1] << ((ulong)plVar3 & 7) * 8;
      uVar32 = *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) &
               0xffffffffffffffffU >> (((ulong)plVar3 & 7) * -8 + 0x40 & 0x3f);
LAB_00105428:
      *(ulong *)((ulong)plVar3 & 0xfffffffffffffff8) = uVar32 | uVar29;
      break;
    case 0xe:
      *(char *)plVar3 = (char)(int)plVar49[uVar29 + 1];
      break;
    case 0x14:
      *(short *)plVar3 = (short)(int)plVar49[uVar29 + 1];
      break;
    case 0x16:
      uVar38 = (uint)plVar3 & 3;
      uVar46 = *(uint *)(plVar49 + uVar29 + 1) >> (ulong)(uVar38 * -8 + 0x18 & 0x1f);
      uVar38 = *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) & -0x100 << (ulong)(uVar38 * 8);
      goto LAB_001054ac;
    case 0x24:
      uVar38 = (uint)plVar3 & 3;
      uVar46 = (int)plVar49[uVar29 + 1] << (ulong)(uVar38 * 8);
      uVar38 = *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) &
               0xffffffffU >> (ulong)(uVar38 * -8 + 0x20 & 0x1f);
LAB_001054ac:
      *(uint *)((ulong)plVar3 & 0xfffffffffffffffc) = uVar38 | uVar46;
      break;
    case 0x36:
      *(int *)plVar3 = (int)plVar49[uVar29 + 1];
      break;
    case 0x3b:
      *plVar3 = plVar49[uVar29 + 1];
    }
    break;
  case 0xd:
  case 0x15:
  case 0x1b:
  case 0x28:
    uVar46 = uVar38 & 0x3f;
    uVar15 = uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f | uVar21 >> 4 |
             uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 | uVar15 >> 4;
    if ((uVar46 == 0xd) || (uVar46 == 0x28)) {
      *(long *)(lVar10 + -0x130 + uVar29 * 8) =
           *(long *)(lVar10 + -0x130 + uVar32 * 8) + (long)(short)uVar15;
    }
    else if (uVar46 == 0x15) {
      *(long *)(lVar10 + -0x130 + uVar29 * 8) =
           (long)*(int *)(lVar10 + -0x130 + uVar32 * 8) + (long)(int)(short)uVar15;
    }
    break;
  case 0x10:
    uVar45 = uVar38 & 0xfff;
    if (0xa4f < uVar45) {
      if (uVar45 < 0xe90) {
        if (uVar45 == 0xa50) {
LAB_00105808:
          if ((uint)uVar39 <= (uint)uVar36) {
            lVar25 = lVar10 + -0x130;
            uVar48 = *(ulong *)(lVar25 + uVar29 * 8);
            *(ulong *)(lVar25 + uVar29 * 8) =
                 uVar48 & -1L << uVar36 |
                 (*(ulong *)(lVar25 + uVar32 * 8) &
                 (-1L << ((ulong)(((uint)uVar36 + 1) - (uint)uVar39) & 0x3f) ^ 0xffffffffffffffffU))
                 << uVar39 | uVar48 & (-1L << uVar39 ^ 0xffffffffffffffffU);
          }
        }
        else if ((uVar45 == 0xad0) && (uVar14 <= uVar35)) {
          lVar25 = lVar10 + -0x130;
          uVar38 = *(uint *)(lVar25 + uVar29 * 8);
          *(long *)(lVar25 + uVar29 * 8) =
               (long)(int)(uVar38 & -1 << (ulong)uVar35 |
                           (*(uint *)(lVar25 + uVar32 * 8) &
                           (-1 << (ulong)((1 - uVar14) + uVar35 & 0x1f) ^ 0xffffffffU)) <<
                           (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) |
                          uVar38 & (-1 << (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) ^
                                   0xffffffffU));
        }
      }
      else {
        if (uVar45 != 0xe90) {
          if (uVar45 == 0xed0) {
            uVar39 = (ulong)(uVar14 | 0x20);
          }
          else {
            if (uVar45 != 0xf90) break;
            uVar35 = uVar35 | 0x20;
          }
        }
        if ((int)uVar39 + uVar35 < 0x40) {
          uVar32 = plVar49[uVar32 + 1];
          if (uVar35 != 0x3f) {
            uVar32 = uVar32 >> uVar39 & (-1L << ((ulong)(uVar35 + 1) & 0x3f) ^ 0xffffffffffffffffU);
          }
          goto LAB_00105b7c;
        }
      }
      break;
    }
    if (uVar45 < 0x290) {
      if (uVar45 == 0x10) {
        if (uVar35 + uVar14 < 0x20) {
          uVar38 = *(uint *)(plVar49 + uVar32 + 1);
          if (uVar35 != 0x1f) {
            uVar38 = uVar38 >> (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28) &
                     (-2 << (ulong)uVar35 ^ 0xffffffffU);
          }
          goto LAB_001054dc;
        }
      }
      else if (uVar45 == 0x90) {
        uVar39 = (ulong)(uVar14 | 0x20);
        goto LAB_00105794;
      }
      break;
    }
    if ((uVar45 != 0x290) && (uVar45 != 0x690)) {
      if (uVar45 == 0x8d0) {
LAB_00105794:
        uVar36 = (ulong)(uVar35 | 0x20);
        goto LAB_00105808;
      }
      break;
    }
    uVar38 = uVar38 & 0x7c000fff;
    if (uVar38 < 0x4c000290) {
      if (uVar38 == 0xc000690) {
        uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        uVar29 = (uVar29 & 0xffff0000ffff) << 0x10 | uVar29 >> 0x10 & 0xffff0000ffff;
        *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> 0x20 | uVar29 << 0x20;
      }
      else if (uVar38 == 0x38000290) {
        *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)*(char *)(lVar10 + -0x130 + uVar29 * 8);
      }
      break;
    }
    if (uVar38 == 0x4c000290) {
      *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)*(short *)(lVar10 + -0x130 + uVar29 * 8);
      break;
    }
    if (uVar38 == 0x54000690) {
      uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
      *(ulong *)(lVar10 + -0x130 + uVar36 * 8) =
           (uVar29 & 0xff00ff00ff00ff) << 8 | uVar29 >> 8 & 0xff00ff00ff00ff;
      break;
    }
    if (uVar38 != 0x74000290) break;
    uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
    uVar38 = (uVar38 & 0xff00ff) << 8 | uVar38 >> 8 & 0xff00ff;
    goto LAB_00106288;
  case 0x11:
  case 0x2a:
    if (lVar25 != 0) break;
    uVar46 = uVar38 & 0x3f;
    uVar38 = (uVar38 & 0x3fff000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 |
              uVar45 >> 0x14 | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    if (uVar46 == 0x11) {
      uVar28 = 0x1f;
LAB_00105618:
      bVar1 = false;
      bVar24 = false;
      pcVar47 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar38);
      bVar42 = true;
    }
    else {
      if (uVar46 == 0x2a) {
        uVar28 = 0;
        goto LAB_00105618;
      }
      if (uVar46 != 0x1a) break;
      lVar25 = plVar49[uVar32 + 1];
      bVar1 = lVar25 < 1;
      uVar28 = 0;
      bVar42 = 0 < lVar25;
      pcVar47 = param_1 + (long)(int)uVar38 + 4;
      if (lVar25 < 1) {
        pcVar47 = param_1 + 8;
      }
      bVar24 = true;
    }
    *(code **)(lVar10 + -0x18) = pcVar47;
    if ((((bool)(bVar1 & bVar24)) || (!bVar24)) || ((bool)(bVar42 & bVar24))) {
      uVar8 = 1;
      if (!(bool)(bVar1 & bVar24)) {
        uVar8 = 2;
      }
      *(undefined8 *)(lVar10 + -0x20) = uVar8;
    }
    goto joined_r0x00106598;
  case 0x17:
    uVar46 = uVar38 & 0x1f003f;
    uVar28 = uVar46 - 0x10017 >> 0x10;
    if (((0x1a < (uVar28 | (uVar46 - 0x10017) * 0x10000)) ||
        ((1 << (ulong)(uVar28 & 0x1f) & 0x4842861U) == 0)) || (lVar25 != 0)) break;
    uVar38 = -((uVar38 & 0xf000) >> 0xf) & 0xfffc0000 |
             (uVar38 & 0xf000 | uVar5 >> 0x14 | uVar38 >> 6 & 0x3f | uVar6 >> 0x14 | uVar45 >> 0x14
              | uVar43 >> 0x14 | uVar44 >> 0x14 | uVar4 >> 0x14) << 2;
    if (0x10016 < uVar46) {
      if (uVar46 < 0xe0017) {
        if (uVar46 < 0x70017) {
          if ((uVar46 == 0x10017) || (uVar46 == 0x60017)) {
switchD_00105184_caseD_3:
            pcVar47 = (code *)0x0;
            goto switchD_00105184_caseD_5;
          }
        }
        else if ((uVar46 == 0x70017) || (uVar46 == 0xc0017)) goto switchD_00105184_caseD_3;
      }
      else if (uVar46 < 0x180017) {
        if ((uVar46 == 0xe0017) || (uVar46 == 0x130017)) goto switchD_00105184_caseD_3;
      }
      else if ((uVar46 == 0x1b0017) || (uVar46 == 0x180017)) goto switchD_00105184_caseD_3;
      break;
    }
    iVar34 = 0;
    pcVar47 = param_1;
    switch(uVar46) {
    case 3:
    case 0x1a:
    case 0x2d:
    case 0x3f:
      goto switchD_00105184_caseD_3;
    default:
      goto switchD_00104da8_caseD_1;
    case 5:
    case 0xf:
    case 0x2c:
    case 0x3a:
switchD_00105184_caseD_5:
      pcVar40 = (code *)plVar49[uVar32 + 1];
      pcVar30 = param_1 + (int)(uVar38 + 4);
      if (0x10016 < uVar46) {
        if (uVar46 < 0xe0017) {
          if (uVar46 < 0x70017) {
            if (uVar46 == 0x10017) {
              if (-1 < (long)pcVar40) goto LAB_00105ea4;
              goto LAB_001051d8;
            }
            if (uVar46 != 0x60017) goto switchD_00104da8_caseD_1;
            iVar34 = 0x1f;
            if ((long)pcVar40 < 0) {
LAB_00105b08:
              iVar34 = 0x1f;
              bVar1 = false;
              goto LAB_00105e60;
            }
            goto LAB_00105ea8;
          }
          if (uVar46 == 0x70017) {
            if ((long)pcVar40 < 0) goto LAB_00105e58;
            goto LAB_00105e84;
          }
          if (uVar46 == 0xc0017) {
            iVar34 = 0x1f;
            if (-1 < (long)pcVar40) goto LAB_00105b08;
            goto LAB_00105ea8;
          }
          goto switchD_00104da8_caseD_1;
        }
        if (0x180016 < uVar46) {
          if (uVar46 == 0x180017) {
            if (-1 < (long)pcVar40) goto LAB_00105e58;
            goto LAB_00105e84;
          }
          if (uVar46 == 0x1b0017) {
            iVar34 = 0x1f;
            bVar1 = true;
            if ((long)pcVar40 < 0) goto LAB_00105f08;
            goto LAB_00105eac;
          }
          goto switchD_00104da8_caseD_1;
        }
        if (uVar46 != 0xe0017) {
          if (uVar46 == 0x130017) {
            if ((long)pcVar40 < 0) goto LAB_00105ea4;
            goto LAB_001051d8;
          }
          goto switchD_00104da8_caseD_1;
        }
        iVar34 = 0x1f;
        bVar1 = true;
        if ((long)pcVar40 < 0) goto LAB_00105eac;
LAB_00105f08:
        bVar1 = true;
        iVar34 = 0x1f;
        goto LAB_00105e60;
      }
      break;
    case 0x11:
      iVar34 = 0x1f;
    case 0x2a:
      bVar1 = false;
      pcVar30 = (code *)(*(long *)(lVar10 + -8) + (ulong)uVar38);
      goto LAB_00105e60;
    }
    switch(uVar46) {
    case 3:
      if (0 < (long)pcVar40) break;
LAB_00105ea4:
      iVar34 = 0;
LAB_00105ea8:
      bVar1 = false;
      goto LAB_00105eac;
    default:
      goto switchD_00104da8_caseD_1;
    case 5:
      if (pcVar40 == pcVar47) goto LAB_00105ea4;
      break;
    case 0xf:
      if (pcVar40 != pcVar47) goto LAB_00105ea4;
      break;
    case 0x1a:
      if ((long)pcVar40 < 1) goto LAB_00105e84;
LAB_00105e58:
      bVar1 = true;
      goto LAB_00105e5c;
    case 0x2c:
      if (pcVar40 == pcVar47) goto LAB_00105e58;
      goto LAB_00105e84;
    case 0x2d:
      if ((long)pcVar40 < 1) goto LAB_00105e58;
      goto LAB_00105e84;
    case 0x3a:
      if (pcVar40 != pcVar47) goto LAB_00105e58;
LAB_00105e84:
      bVar1 = true;
      iVar34 = 0;
LAB_00105eac:
      bVar42 = false;
      pcVar30 = param_1 + 8;
      bVar37 = 1;
      goto LAB_00105eb8;
    case 0x3f:
      if (0 < (long)pcVar40) goto LAB_00105ea4;
    }
LAB_001051d8:
    bVar1 = false;
LAB_00105e5c:
    iVar34 = 0;
LAB_00105e60:
    bVar37 = 0;
    bVar42 = true;
LAB_00105eb8:
    *(code **)(lVar10 + -0x18) = pcVar30;
    if ((((bool)(bVar37 & bVar1)) || (!bVar1)) || (bVar42)) {
      uVar8 = 1;
      if (!(bool)(bVar37 & bVar1)) {
        uVar8 = 2;
      }
      *(undefined8 *)(lVar10 + -0x20) = uVar8;
    }
    goto joined_r0x00105eec;
  case 0x23:
    *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
         (ulong)(*(ulong *)(lVar10 + -0x130 + uVar32 * 8) <
                (ulong)(long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                                     uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 |
                                    uVar15 >> 4));
    break;
  case 0x29:
    uVar28 = (uVar38 & 0xfff) - 0x1a9;
    uVar46 = uVar28 >> 6;
    uVar28 = uVar46 | uVar28 * 0x4000000;
    if (0x1a < uVar28) break;
    if ((1 << (ulong)(uVar46 & 0x1f) & 0x4000032U) != 0) {
      uVar46 = uVar38 & 0xfff;
      if (uVar46 < 0x76f) {
        if (uVar46 < 0x2e9) {
          if (uVar46 == 0x1af) goto LAB_001063a0;
          if (uVar46 == 0x1e9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00105da0;
          }
          if (uVar46 == 0x2a9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00105d78;
          }
        }
        else {
          if (uVar46 == 0x2e9) {
            uVar11 = *(undefined4 *)puVar26;
            uVar12 = *(undefined4 *)puVar27;
            uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00105da0:
            uVar29 = CONCAT44(uVar11,uVar12) - uVar29 * uVar32;
LAB_00105da8:
            uVar36 = uVar29 & 0xffffffff;
            uVar29 = uVar29 >> 0x20;
            goto LAB_001063c0;
          }
          if (uVar46 == 0x52f) {
LAB_00106370:
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = 0;
            if (uVar46 != 0) {
              uVar28 = uVar38 / uVar46;
            }
            goto LAB_00106388;
          }
joined_r0x00106328:
          if ((uVar38 & 0xfff) == 0x72f) {
            uVar32 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
            uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
            uVar36 = SUB168(SEXT816((long)uVar29) * SEXT816((long)uVar32),8);
            goto LAB_00106444;
          }
        }
      }
      else if (uVar46 < 0x92f) {
        if (uVar46 != 0x76f) {
          if (uVar46 != 0x829) goto joined_r0x0010642c;
          uVar11 = *(undefined4 *)puVar26;
          uVar12 = *(undefined4 *)puVar27;
          uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00105d78:
          uVar29 = CONCAT44(uVar11,uVar12) + uVar29 * uVar32;
          goto LAB_00105da8;
        }
LAB_00106434:
        uVar32 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
        uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        auVar16._8_8_ = 0;
        auVar16._0_8_ = uVar29;
        auVar17._8_8_ = 0;
        auVar17._0_8_ = uVar32;
        uVar36 = SUB168(auVar16 * auVar17,8);
LAB_00106444:
        *puVar27 = uVar29 * uVar32;
        *puVar26 = uVar36;
      }
      else {
        if (uVar46 == 0x92f) {
LAB_00105fd8:
          uVar32 = (ulong)*(int *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(int *)(lVar10 + -0x130 + uVar29 * 8);
          goto LAB_001063b4;
        }
        if (uVar46 == 0xb2f) goto LAB_00106400;
        if (uVar46 == 0xdaf) goto LAB_00105978;
      }
      break;
    }
    if (uVar28 != 2) break;
    uVar46 = uVar38 & 0xfff;
    if (uVar46 < 0x86f) {
      if (uVar46 < 0x3af) {
        if (uVar46 != 0x1ef) goto LAB_00105ab8;
        goto LAB_00105c5c;
      }
      goto LAB_00105c80;
    }
    if (0x9ee < uVar46) goto LAB_001052d4;
LAB_00105758:
    if ((uVar38 & 0xfff) != 0x86f) {
      if ((uVar38 & 0xfff) == 0x96f) goto LAB_00105768;
      break;
    }
LAB_00105bfc:
    uVar38 = *(int *)(lVar10 + -0x130 + uVar32 * 8) - *(int *)(lVar10 + -0x130 + uVar29 * 8);
    goto LAB_00105c74;
  case 0x2f:
    uVar45 = uVar38 & 0xfff;
    switch(uVar45 - 0x6f >> 6 | (uVar45 - 0x6f) * 0x4000000) {
    case 0:
    case 3:
    case 9:
    case 0xf:
    case 0x2e:
    case 0x3d:
      break;
    case 1:
    case 0xb:
    case 0x34:
      uVar46 = 0x400032f;
      if ((uVar38 & 0x4000fff) != 0x400032f) {
        uVar46 = uVar45;
      }
      goto LAB_00106080;
    case 2:
      lVar25 = lVar10 + -0x130;
      puVar31 = (undefined8 *)(lVar25 + uVar36 * 8);
      if (*(ulong *)(lVar25 + uVar29 * 8) <= *(ulong *)(lVar25 + uVar32 * 8)) goto LAB_00105fa0;
LAB_00106188:
      *puVar31 = 1;
      break;
    default:
      if (0x92e < uVar45) {
        if (uVar45 < 0xdaf) {
          if (uVar45 < 0xb2f) {
            if (uVar45 == 0x92f) goto LAB_00105fd8;
            if (uVar45 == 0x9af) {
              uVar29 = *puVar27;
              goto LAB_001065a4;
            }
          }
          else if (uVar45 == 0xb2f) {
LAB_00106400:
            uVar36 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
            uVar32 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
            uVar29 = 0;
            if (uVar32 != 0) {
              uVar29 = (long)uVar36 / (long)uVar32;
            }
LAB_00106410:
            *puVar26 = uVar36 - uVar29 * uVar32;
            *puVar27 = uVar29;
          }
          else if (uVar45 == 0xcef) {
            *puVar26 = plVar49[uVar32 + 1];
          }
        }
        else if (uVar45 < 0xe2f) {
          if (uVar45 == 0xdaf) {
LAB_00105978:
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8);
            uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = 0;
            if (uVar46 != 0) {
              uVar28 = (int)uVar38 / (int)uVar46;
            }
LAB_00106388:
            *puVar26 = (long)(int)(uVar38 - uVar28 * uVar46);
            *puVar27 = (long)(int)uVar28;
          }
          else if (uVar45 == 0xdef) {
            *puVar27 = plVar49[uVar32 + 1];
          }
        }
        else if (uVar45 == 0xe2f) {
          uVar29 = *puVar26;
LAB_001065a4:
          plVar49[uVar36 + 1] = uVar29;
        }
        else if ((uVar45 == 0xeaf) && (plVar49[uVar29 + 1] != 0)) goto LAB_0010653c;
        break;
      }
      if (uVar45 < 0x6af) {
        if (uVar45 == 0x1af) {
LAB_001063a0:
          uVar32 = (ulong)*(uint *)(lVar10 + -0x130 + uVar32 * 8);
          uVar29 = (ulong)*(uint *)(lVar10 + -0x130 + uVar29 * 8);
LAB_001063b4:
          uVar36 = (ulong)(int)(uVar29 * uVar32);
          uVar29 = (long)(uVar29 * uVar32) >> 0x20;
LAB_001063c0:
          *puVar27 = uVar36;
          *puVar26 = uVar29;
        }
        else if (uVar45 == 0x4ef) {
          if (plVar49[uVar29 + 1] == 0) {
LAB_0010653c:
            *(undefined8 *)(lVar10 + -0x130 + uVar36 * 8) =
                 *(undefined8 *)(lVar10 + -0x130 + uVar32 * 8);
          }
        }
        else if (uVar45 == 0x52f) goto LAB_00106370;
        break;
      }
      if (0x76e < uVar45) {
        if (uVar45 == 0x76f) goto LAB_00106434;
joined_r0x0010642c:
        if ((uVar38 & 0xfff) == 0x8af) {
          uVar36 = *(ulong *)(lVar10 + -0x130 + uVar32 * 8);
          uVar32 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar29 = 0;
          if (uVar32 != 0) {
            uVar29 = uVar36 / uVar32;
          }
          goto LAB_00106410;
        }
        break;
      }
      if (uVar45 != 0x6af) goto joined_r0x00106328;
      if (lVar25 != 0) break;
      lVar25 = plVar49[uVar32 + 1];
      param_1 = param_1 + 4;
      *(undefined8 *)(lVar10 + -0x20) = 2;
      *(long *)(lVar10 + -0x18) = lVar25;
      *plVar49 = (long)param_1;
      if (param_1 == (code *)0x0) {
        return;
      }
      goto LAB_00104d30;
    case 6:
    case 0xd:
    case 0x1a:
    case 0x20:
    case 0x24:
    case 0x26:
    case 0x28:
    case 0x33:
      uVar46 = uVar38 & 0xfff;
      if (uVar46 < 0x86f) {
        if (uVar46 < 0x3af) {
          if (uVar46 == 0x1ef) {
LAB_00105c5c:
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) + *(int *)(lVar10 + -0x130 + uVar32 * 8)
            ;
            goto LAB_00105c74;
          }
LAB_00105ab8:
          if ((uVar38 & 0xfff) == 0x229) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 (long)*(int *)(lVar25 + uVar29 * 8) * (long)*(int *)(lVar25 + uVar32 * 8);
          }
        }
        else {
LAB_00105c80:
          if (((uVar38 & 0xfff) == 0x3af) || ((uVar38 & 0xfff) == 0x6ef)) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 *(long *)(lVar25 + uVar32 * 8) - *(long *)(lVar25 + uVar29 * 8);
          }
        }
      }
      else {
        if (uVar46 < 0x9ef) goto LAB_00105758;
LAB_001052d4:
        uVar38 = uVar38 & 0xfff;
        if (uVar38 == 0x9ef) {
LAB_00105768:
          lVar25 = lVar10 + -0x130;
          *(long *)(lVar25 + uVar36 * 8) =
               *(long *)(lVar25 + uVar29 * 8) + *(long *)(lVar25 + uVar32 * 8);
        }
        else {
          if (uVar38 == 0xa6f) goto LAB_00105bfc;
          if (uVar38 == 0xd2f) goto LAB_00105c5c;
        }
      }
      break;
    case 10:
    case 0x30:
      goto switchD_001052bc_caseD_a;
    case 0xc:
    case 0x17:
    case 0x1f:
    case 0x3c:
      uVar38 = uVar38 & 0xfff;
      if (uVar38 < 0x82f) {
        if (uVar38 == 0x36f) {
          lVar25 = lVar10 + -0x130;
          *(ulong *)(lVar25 + uVar36 * 8) =
               *(ulong *)(lVar25 + uVar29 * 8) ^ *(ulong *)(lVar25 + uVar32 * 8);
        }
        else if (uVar38 == 0x62f) {
          lVar25 = lVar10 + -0x130;
          *(ulong *)(lVar25 + uVar36 * 8) =
               *(ulong *)(lVar25 + uVar29 * 8) | *(ulong *)(lVar25 + uVar32 * 8);
        }
      }
      else if (uVar38 == 0x82f) {
        lVar25 = lVar10 + -0x130;
        *(ulong *)(lVar25 + uVar36 * 8) =
             ~(*(ulong *)(lVar25 + uVar29 * 8) | *(ulong *)(lVar25 + uVar32 * 8));
      }
      else if (uVar38 == 0xf6f) {
        lVar25 = lVar10 + -0x130;
        *(ulong *)(lVar25 + uVar36 * 8) =
             *(ulong *)(lVar25 + uVar29 * 8) & *(ulong *)(lVar25 + uVar32 * 8);
      }
      break;
    case 0xe:
    case 0x10:
    case 0x22:
    case 0x2c:
    case 0x31:
      uVar43 = 0x2008ef;
      if ((uVar38 & 0x200fff) != 0x2008ef) {
        uVar43 = uVar45;
      }
      goto LAB_001059a4;
    case 0x15:
      if (lVar25 != 0) break;
      uVar46 = uVar38 & 0xfff;
      uVar28 = 0;
      lVar25 = 0;
      switch(uVar46) {
      case 3:
      case 0x1a:
      case 0x2d:
      case 0x3f:
        goto switchD_00106020_caseD_3;
      case 4:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 0xb:
      case 0xc:
      case 0xd:
      case 0xe:
      case 0x10:
      case 0x12:
      case 0x13:
      case 0x14:
      case 0x15:
      case 0x16:
      case 0x17:
      case 0x18:
      case 0x19:
      case 0x1b:
      case 0x1c:
      case 0x1d:
      case 0x1e:
      case 0x1f:
      case 0x20:
      case 0x21:
      case 0x22:
      case 0x23:
      case 0x24:
      case 0x25:
      case 0x26:
      case 0x27:
      case 0x28:
      case 0x29:
      case 0x2b:
      case 0x2e:
      case 0x2f:
      case 0x30:
      case 0x31:
      case 0x32:
      case 0x33:
      case 0x34:
      case 0x35:
      case 0x36:
      case 0x37:
      case 0x38:
      case 0x39:
      case 0x3b:
      case 0x3c:
      case 0x3d:
      case 0x3e:
        break;
      case 5:
      case 0xf:
      case 0x2c:
      case 0x3a:
        goto switchD_00106020_caseD_5;
      case 0x11:
        uVar28 = 0x1f;
      case 0x2a:
        bVar1 = false;
        pcVar47 = (code *)(*(long *)(lVar10 + -8) + uVar39);
        goto LAB_00106560;
      default:
        if ((uVar46 != 0x5af) && (uVar35 = uVar28, uVar46 != 0x6af)) break;
        uVar28 = uVar35;
        pcVar47 = (code *)plVar49[uVar32 + 1];
        bVar1 = false;
        goto LAB_00106560;
      }
    case 0x16:
    case 0x3e:
      goto switchD_001052bc_caseD_16;
    case 0x18:
      uVar46 = uVar45;
LAB_00106080:
      uVar45 = 0x400066f;
      if ((uVar38 & 0x4000fff) != 0x400066f) {
        uVar45 = uVar46;
      }
switchD_001052bc_caseD_16:
      if (uVar45 < 0xd6f) {
        if (uVar45 < 0x5ef) {
          if (uVar45 == 0xaf) {
            lVar25 = lVar10 + -0x130;
            *(long *)(lVar25 + uVar36 * 8) =
                 *(long *)(lVar25 + uVar29 * 8) >> (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
          }
          else if (uVar45 == 0x32f) {
            lVar25 = lVar10 + -0x130;
            *(ulong *)(lVar25 + uVar36 * 8) =
                 *(ulong *)(lVar25 + uVar29 * 8) >> (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
          }
        }
        else {
          if (uVar45 == 0x5ef) {
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          }
          else {
            if (uVar45 != 0x66f) break;
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (ulong)(*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          }
LAB_00105c74:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)(int)uVar38;
        }
      }
      else if (uVar45 < 0x400032f) {
        if (uVar45 == 0xd6f) {
          lVar25 = lVar10 + -0x130;
          *(long *)(lVar25 + uVar36 * 8) =
               *(long *)(lVar25 + uVar29 * 8) << (*(ulong *)(lVar25 + uVar32 * 8) & 0x3f);
        }
        else if (uVar45 == 0xfef) {
          uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) <<
                   (ulong)(*(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f);
          goto LAB_00105c74;
        }
      }
      else if (uVar45 == 0x400032f) {
        lVar25 = lVar10 + -0x130;
        uVar29 = *(ulong *)(lVar25 + uVar29 * 8);
        uVar32 = (ulong)(*(uint *)(lVar25 + uVar32 * 8) & 0x3f);
        *(ulong *)(lVar25 + uVar36 * 8) = uVar29 >> uVar32 | uVar29 << 0x40 - uVar32;
      }
      else if (uVar45 == 0x400066f) {
        uVar46 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
        uVar38 = *(uint *)(lVar10 + -0x130 + uVar32 * 8) & 0x1f;
        uVar38 = uVar46 >> uVar38 | uVar46 << 0x20 - uVar38;
        goto LAB_00105c74;
      }
      break;
    case 0x29:
      lVar25 = lVar10 + -0x130;
      puVar31 = (undefined8 *)(lVar25 + uVar36 * 8);
      if (*(long *)(lVar25 + uVar32 * 8) < *(long *)(lVar25 + uVar29 * 8)) goto LAB_00106188;
LAB_00105fa0:
      *puVar31 = 0;
      break;
    case 0x2d:
      uVar44 = uVar45;
      goto LAB_001059b0;
    case 0x3b:
      uVar43 = uVar45;
LAB_001059a4:
      uVar44 = 0x200f2f;
      if ((uVar38 & 0x200fff) != 0x200f2f) {
        uVar44 = uVar43;
      }
LAB_001059b0:
      uVar45 = 0x200baf;
      if ((uVar38 & 0x200fff) != 0x200baf) {
        uVar45 = uVar44;
      }
switchD_001052bc_caseD_a:
      if (uVar45 < 0xc6f) {
        if (uVar45 < 0x8ef) {
          if (uVar45 == 0x2ef) {
            uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (uVar13 | uVar7 & 3 | uVar46 | uVar28);
            goto LAB_00106288;
          }
          if (uVar45 == 0x3ef) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            uVar39 = (ulong)(uVar14 | 0x20);
LAB_00106258:
            *(long *)(lVar10 + -0x130 + uVar36 * 8) = lVar25 >> uVar39;
          }
          else if (uVar45 == 0x46f) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00106230;
          }
        }
        else if (uVar45 == 0x8ef) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
LAB_00106244:
          *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> uVar39;
        }
        else {
          if (uVar45 == 0xb6f) {
            lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
            goto LAB_00106258;
          }
          if (uVar45 == 0xbaf) {
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8) >>
                     (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28);
            goto LAB_00106288;
          }
        }
      }
      else if (uVar45 < 0x2008ef) {
        if (uVar45 == 0xc6f) {
          uVar38 = *(int *)(lVar10 + -0x130 + uVar29 * 8) <<
                   (ulong)(uVar13 | uVar7 & 3 | uVar46 | uVar28);
LAB_00106288:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = (long)(int)uVar38;
        }
        else if (uVar45 == 0xcaf) {
          lVar25 = *(long *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
LAB_00106230:
          *(long *)(lVar10 + -0x130 + uVar36 * 8) = lVar25 << uVar39;
        }
        else if (uVar45 == 0xf2f) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
          goto LAB_00106244;
        }
      }
      else {
        if (uVar45 == 0x2008ef) {
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
        }
        else {
          if (uVar45 == 0x200baf) {
            uVar38 = *(uint *)(lVar10 + -0x130 + uVar29 * 8);
            uVar28 = uVar13 | uVar7 & 3 | uVar46 | uVar28;
            uVar38 = uVar38 >> uVar28 | uVar38 << 0x20 - uVar28;
            goto LAB_00106288;
          }
          if (uVar45 != 0x200f2f) break;
          uVar29 = *(ulong *)(lVar10 + -0x130 + uVar29 * 8);
          uVar39 = (ulong)(uVar14 | 0x20);
        }
        *(ulong *)(lVar10 + -0x130 + uVar36 * 8) = uVar29 >> uVar39 | uVar29 << 0x40 - uVar39;
      }
    }
    break;
  case 0x32:
    *(ulong *)(lVar10 + -0x130 + uVar29 * 8) =
         (ulong)(*(long *)(lVar10 + -0x130 + uVar32 * 8) <
                (long)(short)(uVar22 & 0xf000 | uVar23 >> 4 | (ushort)(uVar38 >> 6) & 0x3f |
                              uVar21 >> 4 | uVar20 >> 4 | uVar19 >> 4 | uVar18 >> 4 | uVar15 >> 4));
  }
switchD_00104da8_caseD_1:
  lVar25 = *(long *)(lVar10 + -0x20);
  param_1 = (code *)(*plVar49 + 4);
  *plVar49 = (long)param_1;
  if (lVar25 != 2) {
    if ((lVar25 == 3) || (lVar25 == 1)) {
      param_1 = *(code **)(lVar10 + -0x18);
      *(undefined8 *)(lVar10 + -0x20) = 0;
      *plVar49 = (long)param_1;
    }
    if (param_1 == pcVar9) {
      (*pcVar9)(*(undefined8 *)(lVar10 + -0x110),*(undefined8 *)(lVar10 + -0x108));
      param_1 = *(code **)(lVar10 + -0x10);
      *plVar49 = (long)param_1;
    }
  }
  if (param_1 == (code *)0x0) {
    return;
  }
LAB_00104d30:
  lVar25 = *(long *)(lVar10 + -0x20);
  goto LAB_00104d34;
switchD_00106020_caseD_5:
  lVar25 = plVar49[uVar36 + 1];
switchD_00106020_caseD_3:
  if (0x3c < (uVar38 & 0xfff) - 3) goto switchD_00104da8_caseD_1;
  lVar33 = plVar49[uVar32 + 1];
  pcVar47 = param_1 + (uVar14 + 4);
  switch(uVar38 & 0xfff) {
  case 3:
    if (lVar33 < 1) {
LAB_001064f4:
      bVar1 = false;
      goto LAB_001064f8;
    }
    break;
  default:
    goto switchD_00104da8_caseD_1;
  case 5:
    if (lVar33 == lVar25) goto LAB_001064f4;
    break;
  case 0xf:
    if (lVar33 != lVar25) goto LAB_001064f4;
    break;
  case 0x1a:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_001064f8;
LAB_001064e0:
    bVar1 = true;
    goto LAB_001064e4;
  case 0x2c:
    bVar1 = true;
    if (lVar33 == lVar25) goto LAB_001064e0;
    goto LAB_001064f8;
  case 0x2d:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_001064e0;
    goto LAB_001064f8;
  case 0x3a:
    bVar1 = true;
    if (lVar33 != lVar25) goto LAB_001064e0;
LAB_001064f8:
    bVar37 = 0;
    uVar28 = 0;
    pcVar47 = param_1 + 8;
    bVar41 = 1;
    goto LAB_00106564;
  case 0x3f:
    if (0 < lVar33) goto LAB_001064f4;
  }
  bVar1 = false;
LAB_001064e4:
  uVar28 = 0;
LAB_00106560:
  bVar41 = 0;
  bVar37 = 1;
LAB_00106564:
  *(code **)(lVar10 + -0x18) = pcVar47;
  if ((((bool)(bVar41 & bVar1)) || (!bVar1)) || ((bool)(bVar37 & bVar1))) {
    uVar8 = 1;
    if (!(bool)(bVar41 & bVar1)) {
      uVar8 = 2;
    }
    *(undefined8 *)(lVar10 + -0x20) = uVar8;
  }
joined_r0x00106598:
  if (uVar28 != 0) {
    plVar49[(long)(int)uVar28 + 1] = (long)(param_1 + 8);
    *(code **)(lVar10 + -0x10) = param_1 + 8;
  }
  goto switchD_00104da8_caseD_1;
switchD_00104e74_caseD_5:
  lVar25 = plVar49[uVar29 + 1];
switchD_00104e74_caseD_3:
  if (0x3c < (uVar38 & 0x3f) - 3) goto switchD_00104da8_caseD_1;
  lVar33 = plVar49[uVar32 + 1];
  pcVar47 = param_1 + (int)(uVar46 + 4);
  switch(uVar38 & 0x3f) {
  case 3:
    if (lVar33 < 1) {
LAB_00105584:
      bVar1 = false;
      goto LAB_00105588;
    }
    break;
  default:
    goto switchD_00104da8_caseD_1;
  case 5:
    if (lVar33 == lVar25) goto LAB_00105584;
    break;
  case 0xf:
    if (lVar33 != lVar25) goto LAB_00105584;
    break;
  case 0x1a:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_00105588;
LAB_0010556c:
    bVar1 = true;
    goto LAB_00105570;
  case 0x2c:
    bVar1 = true;
    if (lVar33 == lVar25) goto LAB_0010556c;
    goto LAB_00105588;
  case 0x2d:
    bVar1 = true;
    if (lVar33 < 1) goto LAB_0010556c;
    goto LAB_00105588;
  case 0x3a:
    bVar1 = true;
    if (lVar33 != lVar25) goto LAB_0010556c;
LAB_00105588:
    bVar41 = 0;
    iVar34 = 0;
    pcVar47 = param_1 + 8;
    bVar37 = 1;
    goto LAB_00105598;
  case 0x3f:
    if (0 < lVar33) goto LAB_00105584;
  }
  bVar1 = false;
LAB_00105570:
  bVar37 = 0;
  iVar34 = 0;
  bVar41 = 1;
LAB_00105598:
  *(code **)(lVar10 + -0x18) = pcVar47;
  if ((((bool)(bVar37 & bVar1)) || (!bVar1)) || ((bool)(bVar41 & bVar1))) {
    uVar8 = 1;
    if (!(bool)(bVar37 & bVar1)) {
      uVar8 = 2;
    }
    *(undefined8 *)(lVar10 + -0x20) = uVar8;
  }
joined_r0x00105eec:
  if (iVar34 != 0) {
    plVar49[(long)iVar34 + 1] = (long)(param_1 + 8);
    *(code **)(lVar10 + -0x10) = param_1 + 8;
  }
  goto switchD_00104da8_caseD_1;
}



// ===== FUN_001065d0 @ 001065d0 size=260 =====

void FUN_001065d0(byte *param_1,byte *param_2)

{
  *param_1 = *param_1 ^ *param_2;
  param_1[1] = param_1[1] ^ param_2[1];
  param_1[2] = param_1[2] ^ param_2[2];
  param_1[3] = param_1[3] ^ param_2[3];
  param_1[4] = param_1[4] ^ param_2[4];
  param_1[5] = param_1[5] ^ param_2[5];
  param_1[6] = param_1[6] ^ param_2[6];
  param_1[7] = param_1[7] ^ param_2[7];
  param_1[8] = param_1[8] ^ param_2[8];
  param_1[9] = param_1[9] ^ param_2[9];
  param_1[10] = param_1[10] ^ param_2[10];
  param_1[0xb] = param_1[0xb] ^ param_2[0xb];
  param_1[0xc] = param_1[0xc] ^ param_2[0xc];
  param_1[0xd] = param_1[0xd] ^ param_2[0xd];
  param_1[0xe] = param_1[0xe] ^ param_2[0xe];
  param_1[0xf] = param_1[0xf] ^ param_2[0xf];
  return;
}



// ===== FUN_001066d4 @ 001066d4 size=52 =====

void FUN_001066d4(void *param_1,void *param_2,undefined8 *param_3)

{
  undefined8 uVar1;
  
  memcpy(param_1,param_2,0x1e8);
  uVar1 = *param_3;
  *(undefined8 *)((long)param_1 + 0x1f0) = param_3[1];
  *(undefined8 *)((long)param_1 + 0x1e8) = uVar1;
  return;
}



// ===== FUN_00106708 @ 00106708 size=68 =====

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_00106708(undefined8 *param_1)

{
  undefined8 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  
  uVar5 = _UNK_0010e1c8;
  uVar4 = _DAT_0010e1c0;
  uVar3 = _UNK_0010e1b8;
  uVar2 = _DAT_0010e1b0;
  uVar1 = _DAT_0010e1a0;
  param_1[1] = _UNK_0010e1a8;
  *param_1 = uVar1;
  param_1[3] = uVar3;
  param_1[2] = uVar2;
  uVar2 = _UNK_0010e1d8;
  uVar1 = _DAT_0010e1d0;
  *(undefined4 *)(param_1 + 9) = 0;
  param_1[5] = uVar5;
  param_1[4] = uVar4;
  param_1[7] = uVar2;
  param_1[6] = uVar1;
  param_1[8] = 0x5be0cd19137e2179;
  return;
}



// ===== FUN_0010674c @ 0010674c size=240 =====

void FUN_0010674c(long *param_1,void *param_2,ulong param_3)

{
  int iVar1;
  size_t __n;
  uint uVar2;
  
  uVar2 = *(uint *)(param_1 + 9);
  if ((uVar2 < 0x81) && (param_3 != 0)) {
    while( true ) {
      if ((param_3 < 0x80) || (uVar2 != 0)) {
        __n = param_3;
        if (0x80 - uVar2 <= param_3) {
          __n = (ulong)(0x80 - uVar2);
        }
        memcpy((void *)((long)param_1 + (ulong)uVar2 + 0x4c),param_2,__n);
        iVar1 = uVar2 + (int)__n;
        param_2 = (void *)((long)param_2 + __n);
        param_3 = param_3 - __n;
        *(int *)(param_1 + 9) = iVar1;
        if (iVar1 == 0x80) {
          FUN_0010683c(param_1,(long)param_1 + 0x4c);
          *(undefined4 *)(param_1 + 9) = 0;
          *param_1 = *param_1 + 0x400;
        }
      }
      else {
        FUN_0010683c(param_1,param_2);
        param_2 = (void *)((long)param_2 + 0x80);
        *param_1 = *param_1 + 0x400;
        param_3 = param_3 - 0x80;
      }
      if (param_3 == 0) break;
      uVar2 = *(uint *)(param_1 + 9);
    }
  }
  return;
}



// ===== FUN_0010683c @ 0010683c size=1028 =====

void FUN_0010683c(long param_1,long param_2)

{
  long lVar1;
  long lVar2;
  long lVar3;
  ulong uVar4;
  long lVar5;
  ulong *puVar6;
  long *plVar7;
  ulong uVar8;
  ulong uVar9;
  ulong uVar10;
  ulong uVar11;
  ulong uVar12;
  ulong uVar13;
  ulong uVar14;
  ulong uVar15;
  ulong local_300 [80];
  ulong local_80;
  ulong uStack_78;
  ulong local_70;
  ulong uStack_68;
  ulong local_60;
  ulong uStack_58;
  ulong local_50;
  ulong uStack_48;
  long local_38;
  
  lVar3 = tpidr_el0;
  local_38 = *(long *)(lVar3 + 0x28);
  lVar5 = 0;
  uStack_48 = *(ulong *)(param_1 + 0x40);
  local_50 = *(ulong *)(param_1 + 0x38);
  uStack_58 = *(ulong *)(param_1 + 0x30);
  local_60 = *(ulong *)(param_1 + 0x28);
  uStack_68 = *(ulong *)(param_1 + 0x20);
  local_70 = *(ulong *)(param_1 + 0x18);
  uStack_78 = *(ulong *)(param_1 + 0x10);
  local_80 = *(ulong *)(param_1 + 8);
  do {
    uVar9 = (*(ulong *)(param_2 + lVar5) & 0xff00ff00ff00ff00) >> 8 |
            (*(ulong *)(param_2 + lVar5) & 0xff00ff00ff00ff) << 8;
    uVar9 = (uVar9 & 0xffff0000ffff0000) >> 0x10 | (uVar9 & 0xffff0000ffff) << 0x10;
    *(ulong *)((long)local_300 + lVar5) = uVar9 >> 0x20 | uVar9 << 0x20;
    lVar5 = lVar5 + 8;
  } while (lVar5 != 0x80);
  lVar5 = 0;
  do {
    uVar9 = *(ulong *)((long)local_300 + lVar5 + 0x70);
    lVar1 = lVar5 + 8;
    lVar2 = local_300[0] + *(long *)((long)local_300 + lVar5 + 0x48);
    local_300[0] = *(ulong *)((long)local_300 + lVar5 + 8);
    *(ulong *)((long)local_300 + lVar5 + 0x80) =
         lVar2 + ((uVar9 >> 0x3d | uVar9 << 3) ^ uVar9 >> 6 ^ (uVar9 >> 0x13 | uVar9 << 0x2d)) +
         ((local_300[0] >> 8 | local_300[0] << 0x38) ^ local_300[0] >> 7 ^
         (local_300[0] >> 1 | local_300[0] << 0x3f));
    lVar5 = lVar1;
  } while (lVar1 != 0x200);
  uVar9 = 0;
  puVar6 = local_300 + 4;
  plVar7 = &DAT_0010e200;
  uVar4 = uStack_68;
  uVar8 = local_80;
  uVar10 = uStack_78;
  uVar11 = local_50;
  uVar12 = local_70;
  uVar13 = local_60;
  uVar14 = uStack_58;
  uVar15 = uStack_48;
  do {
    lVar5 = plVar7[-4] + uVar15 +
            ((uVar13 >> 0xe | uVar13 << 0x32) ^ (uVar13 >> 0x12 | uVar13 << 0x2e) ^
            (uVar13 >> 0x29 | uVar13 << 0x17)) + puVar6[-4] + ((uVar14 ^ uVar11) & uVar13 ^ uVar11);
    uVar4 = uVar4 + lVar5;
    uVar15 = ((uVar10 | uVar8) & uVar12 | uVar10 & uVar8) + lVar5 +
             ((uVar8 >> 0x1c | uVar8 << 0x24) ^ (uVar8 >> 0x22 | uVar8 << 0x1e) ^
             (uVar8 >> 0x27 | uVar8 << 0x19));
    lVar5 = (uVar4 & (uVar14 ^ uVar13) ^ uVar14) + uVar11 + plVar7[-3] + puVar6[-3] +
            ((uVar4 >> 0xe | uVar4 << 0x32) ^ (uVar4 >> 0x12 | uVar4 << 0x2e) ^
            (uVar4 >> 0x29 | uVar4 * 0x800000));
    uVar12 = lVar5 + uVar12;
    uVar11 = ((uVar15 >> 0x1c | uVar15 << 0x24) ^ (uVar15 >> 0x22 | uVar15 * 0x40000000) ^
             (uVar15 >> 0x27 | uVar15 * 0x2000000)) + ((uVar15 | uVar8) & uVar10 | uVar15 & uVar8) +
             lVar5;
    lVar5 = plVar7[-2] + uVar14 + puVar6[-2] + (uVar12 & (uVar4 ^ uVar13) ^ uVar13) +
            ((uVar12 >> 0xe | uVar12 << 0x32) ^ (uVar12 >> 0x12 | uVar12 << 0x2e) ^
            (uVar12 >> 0x29 | uVar12 * 0x800000));
    uVar10 = lVar5 + uVar10;
    uVar14 = ((uVar11 >> 0x1c | uVar11 << 0x24) ^ (uVar11 >> 0x22 | uVar11 * 0x40000000) ^
             (uVar11 >> 0x27 | uVar11 * 0x2000000)) + ((uVar11 | uVar15) & uVar8 | uVar11 & uVar15)
             + lVar5;
    lVar5 = plVar7[-1] + uVar13 + puVar6[-1] + (uVar10 & (uVar12 ^ uVar4) ^ uVar4) +
            ((uVar10 >> 0xe | uVar10 << 0x32) ^ (uVar10 >> 0x12 | uVar10 << 0x2e) ^
            (uVar10 >> 0x29 | uVar10 * 0x800000));
    uVar8 = lVar5 + uVar8;
    uVar13 = ((uVar14 >> 0x1c | uVar14 << 0x24) ^ (uVar14 >> 0x22 | uVar14 * 0x40000000) ^
             (uVar14 >> 0x27 | uVar14 * 0x2000000)) + ((uVar14 | uVar11) & uVar15 | uVar14 & uVar11)
             + lVar5;
    lVar5 = *plVar7 + uVar4 + *puVar6 + (uVar8 & (uVar10 ^ uVar12) ^ uVar12) +
            ((uVar8 >> 0xe | uVar8 << 0x32) ^ (uVar8 >> 0x12 | uVar8 << 0x2e) ^
            (uVar8 >> 0x29 | uVar8 * 0x800000));
    uVar15 = lVar5 + uVar15;
    uVar4 = ((uVar13 >> 0x1c | uVar13 << 0x24) ^ (uVar13 >> 0x22 | uVar13 * 0x40000000) ^
            (uVar13 >> 0x27 | uVar13 * 0x2000000)) + ((uVar13 | uVar14) & uVar11 | uVar13 & uVar14)
            + lVar5;
    lVar5 = plVar7[1] + uVar12 + puVar6[1] + (uVar15 & (uVar8 ^ uVar10) ^ uVar10) +
            ((uVar15 >> 0xe | uVar15 << 0x32) ^ (uVar15 >> 0x12 | uVar15 << 0x2e) ^
            (uVar15 >> 0x29 | uVar15 * 0x800000));
    uVar11 = lVar5 + uVar11;
    uVar12 = ((uVar4 >> 0x1c | uVar4 << 0x24) ^ (uVar4 >> 0x22 | uVar4 * 0x40000000) ^
             (uVar4 >> 0x27 | uVar4 * 0x2000000)) + ((uVar4 | uVar13) & uVar14 | uVar4 & uVar13) +
             lVar5;
    lVar5 = plVar7[2] + uVar10 + puVar6[2] + (uVar11 & (uVar15 ^ uVar8) ^ uVar8) +
            ((uVar11 >> 0xe | uVar11 << 0x32) ^ (uVar11 >> 0x12 | uVar11 << 0x2e) ^
            (uVar11 >> 0x29 | uVar11 * 0x800000));
    uVar14 = lVar5 + uVar14;
    uVar10 = ((uVar12 >> 0x1c | uVar12 << 0x24) ^ (uVar12 >> 0x22 | uVar12 * 0x40000000) ^
             (uVar12 >> 0x27 | uVar12 * 0x2000000)) + ((uVar12 | uVar4) & uVar13 | uVar12 & uVar4) +
             lVar5;
    uVar9 = uVar9 + 8;
    lVar5 = uVar8 + plVar7[3] + puVar6[3] + (uVar14 & (uVar11 ^ uVar15) ^ uVar15) +
            ((uVar14 >> 0xe | uVar14 << 0x32) ^ (uVar14 >> 0x12 | uVar14 << 0x2e) ^
            (uVar14 >> 0x29 | uVar14 * 0x800000));
    plVar7 = plVar7 + 8;
    uVar13 = lVar5 + uVar13;
    uVar8 = ((uVar10 >> 0x1c | uVar10 << 0x24) ^ (uVar10 >> 0x22 | uVar10 * 0x40000000) ^
            (uVar10 >> 0x27 | uVar10 * 0x2000000)) + ((uVar10 | uVar12) & uVar4 | uVar10 & uVar12) +
            lVar5;
    puVar6 = puVar6 + 8;
  } while (uVar9 < 0x50);
  *(ulong *)(param_1 + 8) = uVar8 + *(long *)(param_1 + 8);
  *(ulong *)(param_1 + 0x10) = uVar10 + *(long *)(param_1 + 0x10);
  *(ulong *)(param_1 + 0x18) = uVar12 + *(long *)(param_1 + 0x18);
  *(ulong *)(param_1 + 0x20) = uVar4 + *(long *)(param_1 + 0x20);
  *(ulong *)(param_1 + 0x28) = uVar13 + *(long *)(param_1 + 0x28);
  *(ulong *)(param_1 + 0x30) = uVar14 + *(long *)(param_1 + 0x30);
  *(ulong *)(param_1 + 0x38) = uVar11 + *(long *)(param_1 + 0x38);
  *(ulong *)(param_1 + 0x40) = uVar15 + *(long *)(param_1 + 0x40);
  if (*(long *)(lVar3 + 0x28) == local_38) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00106c40 @ 00106c40 size=364 =====

void FUN_00106c40(long *param_1,long param_2)

{
  ulong uVar1;
  undefined8 *puVar2;
  undefined1 *puVar3;
  ulong uVar4;
  long lVar5;
  long lVar6;
  uint uVar7;
  
  uVar7 = *(uint *)(param_1 + 9);
  uVar4 = (ulong)uVar7;
  if (uVar7 < 0x80) {
    uVar7 = uVar7 + 1;
    lVar6 = (long)param_1 + 0x4c;
    *(uint *)(param_1 + 9) = uVar7;
    *param_1 = *param_1 + uVar4 * 8;
    *(undefined1 *)(lVar6 + uVar4) = 0x80;
    if (0x70 < uVar7) {
      if (uVar7 < 0x80) {
        do {
          uVar1 = uVar4 + 1;
          *(int *)(param_1 + 9) = (int)uVar4 + 2;
          *(undefined1 *)((long)param_1 + uVar4 + 0x4d) = 0;
          uVar4 = uVar1;
        } while ((int)uVar1 != 0x7f);
      }
      FUN_0010683c(param_1,lVar6);
      uVar7 = 0;
      *(undefined4 *)(param_1 + 9) = 0;
    }
    uVar4 = (ulong)uVar7;
    do {
      uVar1 = uVar4 + 1;
      *(int *)(param_1 + 9) = (int)uVar1;
      *(undefined1 *)((long)param_1 + uVar4 + 0x4c) = 0;
      uVar4 = uVar1;
    } while (uVar1 != 0x78);
    lVar5 = *param_1;
    *(char *)((long)param_1 + 0xc4) = (char)((ulong)lVar5 >> 0x38);
    *(char *)((long)param_1 + 0xc5) = (char)((ulong)lVar5 >> 0x30);
    *(char *)((long)param_1 + 0xc6) = (char)((ulong)lVar5 >> 0x28);
    *(char *)((long)param_1 + 199) = (char)((ulong)lVar5 >> 0x20);
    *(char *)(param_1 + 0x19) = (char)((ulong)lVar5 >> 0x18);
    *(char *)((long)param_1 + 0xc9) = (char)((ulong)lVar5 >> 0x10);
    *(char *)((long)param_1 + 0xca) = (char)((ulong)lVar5 >> 8);
    *(char *)((long)param_1 + 0xcb) = (char)lVar5;
    FUN_0010683c(param_1,lVar6);
    lVar6 = 0;
    do {
      puVar2 = (undefined8 *)((long)param_1 + lVar6 + 8);
      puVar3 = (undefined1 *)(param_2 + 3 + lVar6);
      lVar6 = lVar6 + 8;
      puVar3[-3] = *(undefined1 *)((long)puVar2 + 7);
      puVar3[-2] = (char)*(undefined2 *)((long)puVar2 + 6);
      puVar3[-1] = (char)((ulong)*puVar2 >> 0x28);
      *puVar3 = (char)*(undefined4 *)((long)puVar2 + 4);
      puVar3[1] = (char)((ulong)*puVar2 >> 0x18);
      puVar3[2] = (char)((ulong)*puVar2 >> 0x10);
      puVar3[3] = (char)((ulong)*puVar2 >> 8);
      puVar3[4] = (char)*puVar2;
    } while (lVar6 != 0x40);
  }
  return;
}



// ===== FUN_00106dac @ 00106dac size=356 =====

/* WARNING: Removing unreachable block (ram,0x00106e3c) */
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_00106dac(void *param_1,ulong param_2,undefined8 param_3)

{
  size_t __n;
  long lVar1;
  uint uVar2;
  long local_140;
  undefined8 uStack_138;
  undefined8 uStack_130;
  undefined8 uStack_128;
  undefined8 local_120;
  undefined8 uStack_118;
  undefined8 uStack_110;
  undefined8 uStack_108;
  undefined8 local_100;
  uint local_f8;
  undefined1 auStack_f4 [140];
  long local_68;
  
  lVar1 = tpidr_el0;
  local_68 = *(long *)(lVar1 + 0x28);
  uStack_138 = _UNK_0010e1a8;
  local_140 = _DAT_0010e1a0;
  uStack_128 = _UNK_0010e1b8;
  uStack_130 = _DAT_0010e1b0;
  local_f8 = 0;
  uStack_118 = _UNK_0010e1c8;
  local_120 = _DAT_0010e1c0;
  uStack_108 = _UNK_0010e1d8;
  uStack_110 = _DAT_0010e1d0;
  local_100 = 0x5be0cd19137e2179;
  if (param_2 != 0) {
    do {
      if (param_2 < 0x80) goto LAB_00106e78;
      FUN_0010683c(&local_140,param_1);
      param_1 = (void *)((long)param_1 + 0x80);
      local_140 = local_140 + 0x400;
      param_2 = param_2 - 0x80;
      while( true ) {
        if (param_2 == 0) goto LAB_00106ed0;
        if (local_f8 == 0) break;
LAB_00106e78:
        uVar2 = local_f8;
        __n = param_2;
        if (0x80 - local_f8 <= param_2) {
          __n = (ulong)(0x80 - local_f8);
        }
        memcpy(auStack_f4 + local_f8,param_1,__n);
        local_f8 = uVar2 + (int)__n;
        param_1 = (void *)((long)param_1 + __n);
        param_2 = param_2 - __n;
        if (local_f8 == 0x80) {
          FUN_0010683c(&local_140,auStack_f4);
          local_f8 = 0;
          local_140 = local_140 + 0x400;
        }
      }
    } while( true );
  }
LAB_00106ed0:
  FUN_00106c40(&local_140,param_3);
  if (*(long *)(lVar1 + 0x28) == local_68) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00106f10 @ 00106f10 size=564 =====

undefined8 FUN_00106f10(undefined8 param_1,undefined8 param_2,long param_3)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  undefined4 uVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  uint uVar13;
  uint uVar14;
  undefined8 uVar15;
  long lVar16;
  uint *puVar17;
  int iVar18;
  undefined4 *puVar19;
  long lVar20;
  undefined4 *puVar21;
  
  uVar15 = FUN_001074c0();
  if (-1 < (int)uVar15) {
    iVar18 = *(int *)(param_3 + 0xf0);
    if (0 < iVar18) {
      lVar20 = (long)iVar18 * 4;
      lVar16 = 0;
      puVar19 = (undefined4 *)(param_3 + (long)iVar18 * 0x10 + 8);
      puVar21 = (undefined4 *)(param_3 + 8);
      do {
        lVar20 = lVar20 + -4;
        uVar5 = puVar21[-2];
        lVar16 = lVar16 + 4;
        puVar21[-2] = puVar19[-2];
        puVar19[-2] = uVar5;
        uVar5 = puVar21[-1];
        puVar21[-1] = puVar19[-1];
        puVar19[-1] = uVar5;
        uVar5 = *puVar21;
        *puVar21 = *puVar19;
        *puVar19 = uVar5;
        uVar5 = puVar21[1];
        puVar21[1] = puVar19[1];
        puVar19[1] = uVar5;
        puVar19 = puVar19 + -4;
        puVar21 = puVar21 + 4;
      } while (lVar16 < lVar20);
      if (1 < *(int *)(param_3 + 0xf0)) {
        puVar17 = (uint *)(param_3 + 0x1c);
        iVar18 = 1;
        do {
          uVar1 = puVar17[-3];
          uVar3 = puVar17[-2];
          uVar2 = puVar17[-1];
          uVar4 = *puVar17;
          iVar18 = iVar18 + 1;
          uVar6 = *(uint *)(&DAT_0010e460 +
                           (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar3 >> 0x18) * 4] * 4);
          uVar7 = *(uint *)(&DAT_0010ec60 +
                           (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar3 >> 0x10 & 0xff) * 4] * 4);
          uVar8 = *(uint *)(&DAT_0010e460 +
                           (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar2 >> 0x18) * 4] * 4);
          uVar9 = *(uint *)(&DAT_0010ec60 +
                           (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar2 >> 0x10 & 0xff) * 4] * 4);
          uVar10 = *(uint *)(&DAT_0010e460 +
                            (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar4 >> 0x18) * 4] * 4);
          uVar11 = *(uint *)(&DAT_0010ec60 +
                            (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar4 >> 0x10 & 0xff) * 4] * 4);
          uVar12 = *(uint *)(&DAT_0010f060 +
                            (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar3 >> 8 & 0xff) * 4] * 4);
          uVar13 = *(uint *)(&DAT_0010f060 +
                            (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar2 >> 8 & 0xff) * 4] * 4);
          uVar14 = *(uint *)(&DAT_0010f060 +
                            (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar4 >> 8 & 0xff) * 4] * 4);
          uVar3 = *(uint *)(&DAT_0010f460 +
                           (ulong)(byte)(&DAT_0010e860)[((ulong)uVar3 & 0xff) * 4] * 4);
          uVar2 = *(uint *)(&DAT_0010f460 +
                           (ulong)(byte)(&DAT_0010e860)[((ulong)uVar2 & 0xff) * 4] * 4);
          uVar4 = *(uint *)(&DAT_0010f460 +
                           (ulong)(byte)(&DAT_0010e860)[((ulong)uVar4 & 0xff) * 4] * 4);
          puVar17[-3] = *(uint *)(&DAT_0010ec60 +
                                 (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar1 >> 0x10 & 0xff) * 4] * 4
                                 ) ^
                        *(uint *)(&DAT_0010e460 +
                                 (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar1 >> 0x18) * 4] * 4) ^
                        *(uint *)(&DAT_0010f060 +
                                 (ulong)(byte)(&DAT_0010e860)[(ulong)(uVar1 >> 8 & 0xff) * 4] * 4) ^
                        *(uint *)(&DAT_0010f460 +
                                 (ulong)(byte)(&DAT_0010e860)[((ulong)uVar1 & 0xff) * 4] * 4);
          puVar17[-2] = uVar7 ^ uVar6 ^ uVar12 ^ uVar3;
          puVar17[-1] = uVar9 ^ uVar8 ^ uVar13 ^ uVar2;
          *puVar17 = uVar11 ^ uVar10 ^ uVar14 ^ uVar4;
          puVar17 = puVar17 + 4;
        } while (iVar18 < *(int *)(param_3 + 0xf0));
      }
    }
    uVar15 = 0;
  }
  return uVar15;
}



// ===== FUN_00107144 @ 00107144 size=892 =====

void FUN_00107144(uint *param_1,undefined1 *param_2,uint *param_3)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  byte bVar4;
  byte bVar5;
  byte bVar6;
  byte bVar7;
  byte bVar8;
  byte bVar9;
  byte bVar10;
  byte bVar11;
  byte bVar12;
  byte bVar13;
  byte bVar14;
  byte bVar15;
  uint uVar16;
  ulong uVar17;
  uint *puVar18;
  int iVar19;
  uint uVar20;
  uint uVar21;
  uint uVar22;
  
  uVar20 = (*param_1 & 0xff00ff00) >> 8 | (*param_1 & 0xff00ff) << 8;
  uVar20 = (uVar20 >> 0x10 | uVar20 << 0x10) ^ *param_3;
  uVar21 = (param_1[1] & 0xff00ff00) >> 8 | (param_1[1] & 0xff00ff) << 8;
  uVar21 = (uVar21 >> 0x10 | uVar21 << 0x10) ^ param_3[1];
  uVar22 = (param_1[2] & 0xff00ff00) >> 8 | (param_1[2] & 0xff00ff) << 8;
  uVar16 = (param_1[3] & 0xff00ff00) >> 8 | (param_1[3] & 0xff00ff) << 8;
  uVar22 = (uVar22 >> 0x10 | uVar22 << 0x10) ^ param_3[2];
  uVar17 = (ulong)(((int)param_3[0x3c] >> 1) - 1);
  uVar16 = (uVar16 >> 0x10 | uVar16 << 0x10) ^ param_3[3];
  puVar18 = param_3 + 6;
  iVar19 = -((int)param_3[0x3c] >> 1);
  while( true ) {
    iVar19 = iVar19 + 1;
    uVar1 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar16 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_0010e460 + (ulong)(uVar20 >> 0x18) * 4) ^
            *(uint *)(&DAT_0010f060 + (ulong)(uVar22 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_0010f460 + (ulong)(uVar21 & 0xff) * 4) ^ puVar18[-2];
    uVar2 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar20 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_0010e460 + (ulong)(uVar21 >> 0x18) * 4) ^
            *(uint *)(&DAT_0010f060 + (ulong)(uVar16 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_0010f460 + (ulong)(uVar22 & 0xff) * 4) ^ puVar18[-1];
    uVar3 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar21 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_0010e460 + (ulong)(uVar22 >> 0x18) * 4) ^
            *(uint *)(&DAT_0010f060 + (ulong)(uVar20 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_0010f460 + (ulong)(uVar16 & 0xff) * 4) ^ *puVar18;
    uVar16 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar22 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_0010e460 + (ulong)(uVar16 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f060 + (ulong)(uVar21 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010f460 + (ulong)(uVar20 & 0xff) * 4) ^ puVar18[1];
    if (iVar19 == 0) break;
    uVar20 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar16 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_0010e460 + (ulong)(uVar1 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f060 + (ulong)(uVar3 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010f460 + (ulong)(uVar2 & 0xff) * 4) ^ puVar18[2];
    uVar21 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar1 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_0010e460 + (ulong)(uVar2 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f060 + (ulong)(uVar16 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010f460 + (ulong)(uVar3 & 0xff) * 4) ^ puVar18[3];
    uVar22 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_0010e460 + (ulong)(uVar3 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f060 + (ulong)(uVar1 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010f460 + (ulong)(uVar16 & 0xff) * 4) ^ puVar18[4];
    uVar16 = *(uint *)(&DAT_0010ec60 + (ulong)(uVar3 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_0010e460 + (ulong)(uVar16 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f060 + (ulong)(uVar2 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010f460 + (ulong)(uVar1 & 0xff) * 4) ^ puVar18[5];
    puVar18 = puVar18 + 8;
  }
  bVar4 = (&DAT_0010f860)[uVar2 >> 0x18];
  bVar5 = (&DAT_0010f860)[uVar1 >> 0x10 & 0xff];
  bVar6 = (&DAT_0010f860)[uVar16 >> 8 & 0xff];
  bVar7 = (&DAT_0010f860)[uVar3 & 0xff];
  bVar8 = (&DAT_0010f860)[uVar3 >> 0x18];
  bVar9 = (&DAT_0010f860)[uVar2 >> 0x10 & 0xff];
  bVar10 = (&DAT_0010f860)[uVar1 >> 8 & 0xff];
  bVar11 = (&DAT_0010f860)[uVar16 & 0xff];
  bVar12 = (&DAT_0010f860)[uVar16 >> 0x18];
  bVar13 = (&DAT_0010f860)[uVar3 >> 0x10 & 0xff];
  bVar14 = (&DAT_0010f860)[uVar2 >> 8 & 0xff];
  bVar15 = (&DAT_0010f860)[uVar1 & 0xff];
  uVar20 = ((uint)(byte)(&DAT_0010f860)[uVar1 >> 0x18] << 0x18 |
            (uint)(byte)(&DAT_0010f860)[uVar16 >> 0x10 & 0xff] << 0x10 |
            (uint)(byte)(&DAT_0010f860)[uVar3 >> 8 & 0xff] << 8 |
           (uint)(byte)(&DAT_0010f860)[uVar2 & 0xff]) ^ param_3[uVar17 * 8 + 8];
  *param_2 = (char)(uVar20 >> 0x18);
  param_2[3] = (char)uVar20;
  param_2[1] = (char)(uVar20 >> 0x10);
  param_2[2] = (char)(uVar20 >> 8);
  uVar20 = ((uint)bVar4 << 0x18 | (uint)bVar5 << 0x10 | (uint)bVar6 << 8 | (uint)bVar7) ^
           param_3[uVar17 * 8 + 9];
  param_2[4] = (char)(uVar20 >> 0x18);
  param_2[7] = (char)uVar20;
  param_2[5] = (char)(uVar20 >> 0x10);
  param_2[6] = (char)(uVar20 >> 8);
  uVar20 = ((uint)bVar8 << 0x18 | (uint)bVar9 << 0x10 | (uint)bVar10 << 8 | (uint)bVar11) ^
           param_3[uVar17 * 8 + 10];
  param_2[0xb] = (char)uVar20;
  param_2[8] = (char)(uVar20 >> 0x18);
  param_2[9] = (char)(uVar20 >> 0x10);
  param_2[10] = (char)(uVar20 >> 8);
  uVar20 = ((uint)bVar12 << 0x18 | (uint)bVar13 << 0x10 | (uint)bVar14 << 8 | (uint)bVar15) ^
           param_3[uVar17 * 8 + 0xb];
  param_2[0xc] = (char)(uVar20 >> 0x18);
  param_2[0xd] = (char)(uVar20 >> 0x10);
  param_2[0xe] = (char)(uVar20 >> 8);
  param_2[0xf] = (char)uVar20;
  return;
}



// ===== FUN_001074c0 @ 001074c0 size=844 =====

undefined4 FUN_001074c0(uint *param_1,int param_2,uint *param_3)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  undefined4 uVar5;
  long lVar6;
  
  uVar5 = 0xffffffff;
  if ((param_1 != (uint *)0x0) && (param_3 != (uint *)0x0)) {
    if ((param_2 != 0x80) && ((param_2 != 0x100 && (param_2 != 0xc0)))) {
      return 0xfffffffe;
    }
    if (param_2 == 0x80) {
      uVar4 = 10;
    }
    else if (param_2 == 0xc0) {
      uVar4 = 0xc;
    }
    else {
      uVar4 = 0xe;
    }
    param_3[0x3c] = uVar4;
    uVar4 = (*param_1 & 0xff00ff00) >> 8 | (*param_1 & 0xff00ff) << 8;
    uVar4 = uVar4 >> 0x10 | uVar4 << 0x10;
    *param_3 = uVar4;
    uVar3 = (param_1[1] & 0xff00ff00) >> 8 | (param_1[1] & 0xff00ff) << 8;
    param_3[1] = uVar3 >> 0x10 | uVar3 << 0x10;
    uVar3 = (param_1[2] & 0xff00ff00) >> 8 | (param_1[2] & 0xff00ff) << 8;
    param_3[2] = uVar3 >> 0x10 | uVar3 << 0x10;
    uVar3 = (param_1[3] & 0xff00ff00) >> 8 | (param_1[3] & 0xff00ff) << 8;
    param_3[3] = uVar3 >> 0x10 | uVar3 << 0x10;
    if (param_2 == 0x80) {
      lVar6 = 0;
      do {
        uVar1 = param_3[3];
        uVar4 = *(uint *)(&DAT_0010f960 + (ulong)(uVar1 >> 0x10 & 0xff) * 4) & 0xff000000 ^ uVar4 ^
                *(uint *)(&DAT_0010fd60 + (ulong)(uVar1 >> 8 & 0xff) * 4) & 0xff0000 ^
                *(uint *)(&DAT_00110160 + ((ulong)uVar1 & 0xff) * 4) & 0xff00 ^
                (uint)(byte)(&DAT_00110560)[(ulong)(uVar1 >> 0x18) * 4] ^
                *(uint *)((long)&DAT_00110960 + lVar6);
        lVar6 = lVar6 + 4;
        param_3[4] = uVar4;
        param_3[5] = param_3[1] ^ uVar4;
        uVar3 = param_3[2] ^ param_3[1] ^ uVar4;
        param_3[6] = uVar3;
        param_3[7] = uVar3 ^ uVar1;
        param_3 = param_3 + 4;
      } while (lVar6 != 0x28);
    }
    else {
      uVar3 = (param_1[4] & 0xff00ff00) >> 8 | (param_1[4] & 0xff00ff) << 8;
      param_3[4] = uVar3 >> 0x10 | uVar3 << 0x10;
      uVar3 = (param_1[5] & 0xff00ff00) >> 8 | (param_1[5] & 0xff00ff) << 8;
      param_3[5] = uVar3 >> 0x10 | uVar3 << 0x10;
      if (param_2 == 0xc0) {
        lVar6 = 0;
        while( true ) {
          uVar2 = param_3[5];
          uVar4 = *(uint *)(&DAT_0010f960 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) & 0xff000000 ^ uVar4
                  ^ *(uint *)(&DAT_0010fd60 + (ulong)(uVar2 >> 8 & 0xff) * 4) & 0xff0000 ^
                  *(uint *)(&DAT_00110160 + ((ulong)uVar2 & 0xff) * 4) & 0xff00 ^
                  (uint)(byte)(&DAT_00110560)[(ulong)(uVar2 >> 0x18) * 4] ^
                  *(uint *)((long)&DAT_00110960 + lVar6);
          uVar1 = param_3[2] ^ param_3[1] ^ uVar4;
          param_3[6] = uVar4;
          param_3[7] = param_3[1] ^ uVar4;
          uVar3 = param_3[3] ^ uVar1;
          param_3[8] = uVar1;
          param_3[9] = uVar3;
          if (lVar6 == 0x1c) break;
          lVar6 = lVar6 + 4;
          uVar3 = param_3[4] ^ uVar3;
          param_3[10] = uVar3;
          param_3[0xb] = uVar3 ^ uVar2;
          param_3 = param_3 + 6;
        }
      }
      else {
        uVar3 = (param_1[6] & 0xff00ff00) >> 8 | (param_1[6] & 0xff00ff) << 8;
        param_3[6] = uVar3 >> 0x10 | uVar3 << 0x10;
        uVar3 = (param_1[7] & 0xff00ff00) >> 8 | (param_1[7] & 0xff00ff) << 8;
        param_3[7] = uVar3 >> 0x10 | uVar3 << 0x10;
        if (param_2 == 0x100) {
          lVar6 = 0;
          while( true ) {
            uVar2 = param_3[7];
            uVar4 = *(uint *)(&DAT_0010f960 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) & 0xff000000 ^
                    uVar4 ^ *(uint *)(&DAT_0010fd60 + (ulong)(uVar2 >> 8 & 0xff) * 4) & 0xff0000 ^
                    *(uint *)(&DAT_00110160 + ((ulong)uVar2 & 0xff) * 4) & 0xff00 ^
                    (uint)(byte)(&DAT_00110560)[(ulong)(uVar2 >> 0x18) * 4] ^
                    *(uint *)((long)&DAT_00110960 + lVar6);
            uVar3 = param_3[2] ^ param_3[1] ^ uVar4;
            param_3[8] = uVar4;
            param_3[9] = param_3[1] ^ uVar4;
            uVar1 = param_3[3] ^ uVar3;
            param_3[10] = uVar3;
            param_3[0xb] = uVar1;
            if (lVar6 == 0x18) break;
            uVar3 = *(uint *)(&DAT_0010f960 + (ulong)(uVar1 >> 0x18) * 4) & 0xff000000 ^ param_3[4]
                    ^ *(uint *)(&DAT_0010fd60 + (ulong)(uVar1 >> 0x10 & 0xff) * 4) & 0xff0000 ^
                    *(uint *)(&DAT_00110160 + (ulong)(uVar1 >> 8 & 0xff) * 4) & 0xff00 ^
                    (uint)(byte)(&DAT_00110560)[(ulong)(uVar1 & 0xff) * 4];
            uVar1 = param_3[5] ^ uVar3;
            param_3[0xc] = uVar3;
            param_3[0xd] = uVar1;
            lVar6 = lVar6 + 4;
            uVar1 = param_3[6] ^ uVar1;
            param_3[0xe] = uVar1;
            param_3[0xf] = uVar1 ^ uVar2;
            param_3 = param_3 + 8;
          }
        }
      }
    }
    uVar5 = 0;
  }
  return uVar5;
}



// ===== FUN_0010780c @ 0010780c size=932 =====

void FUN_0010780c(uint *param_1,undefined1 *param_2,uint *param_3)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  byte bVar8;
  byte bVar9;
  byte bVar10;
  uint uVar11;
  ulong uVar12;
  uint *puVar13;
  int iVar14;
  uint uVar15;
  uint uVar16;
  uint uVar17;
  
  uVar15 = (*param_1 & 0xff00ff00) >> 8 | (*param_1 & 0xff00ff) << 8;
  uVar15 = (uVar15 >> 0x10 | uVar15 << 0x10) ^ *param_3;
  uVar17 = (param_1[2] & 0xff00ff00) >> 8 | (param_1[2] & 0xff00ff) << 8;
  uVar16 = (param_1[1] & 0xff00ff00) >> 8 | (param_1[1] & 0xff00ff) << 8;
  uVar17 = (uVar17 >> 0x10 | uVar17 << 0x10) ^ param_3[2];
  uVar12 = (ulong)(((int)param_3[0x3c] >> 1) - 1);
  uVar16 = (uVar16 >> 0x10 | uVar16 << 0x10) ^ param_3[1];
  uVar11 = (param_1[3] & 0xff00ff00) >> 8 | (param_1[3] & 0xff00ff) << 8;
  iVar14 = -((int)param_3[0x3c] >> 1);
  puVar13 = param_3 + 6;
  uVar11 = (uVar11 >> 0x10 | uVar11 << 0x10) ^ param_3[3];
  while( true ) {
    iVar14 = iVar14 + 1;
    uVar1 = *(uint *)(&DAT_00110560 + (ulong)(uVar16 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00110160 + (ulong)(uVar15 >> 0x18) * 4) ^
            *(uint *)(&DAT_0010f960 + (ulong)(uVar17 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_0010fd60 + (ulong)(uVar11 & 0xff) * 4) ^ puVar13[-2];
    uVar2 = *(uint *)(&DAT_00110560 + (ulong)(uVar17 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00110160 + (ulong)(uVar16 >> 0x18) * 4) ^
            *(uint *)(&DAT_0010f960 + (ulong)(uVar11 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_0010fd60 + (ulong)(uVar15 & 0xff) * 4) ^ puVar13[-1];
    uVar3 = *(uint *)(&DAT_00110560 + (ulong)(uVar11 >> 0x10 & 0xff) * 4) ^
            *(uint *)(&DAT_00110160 + (ulong)(uVar17 >> 0x18) * 4) ^
            *(uint *)(&DAT_0010f960 + (ulong)(uVar15 >> 8 & 0xff) * 4) ^
            *(uint *)(&DAT_0010fd60 + (ulong)(uVar16 & 0xff) * 4) ^ *puVar13;
    uVar11 = *(uint *)(&DAT_00110560 + (ulong)(uVar15 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_00110160 + (ulong)(uVar11 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f960 + (ulong)(uVar16 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010fd60 + (ulong)(uVar17 & 0xff) * 4) ^ puVar13[1];
    if (iVar14 == 0) break;
    uVar15 = *(uint *)(&DAT_00110560 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_00110160 + (ulong)(uVar1 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f960 + (ulong)(uVar3 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010fd60 + (ulong)(uVar11 & 0xff) * 4) ^ puVar13[2];
    uVar16 = *(uint *)(&DAT_00110560 + (ulong)(uVar3 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_00110160 + (ulong)(uVar2 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f960 + (ulong)(uVar11 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010fd60 + (ulong)(uVar1 & 0xff) * 4) ^ puVar13[3];
    uVar17 = *(uint *)(&DAT_00110560 + (ulong)(uVar11 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_00110160 + (ulong)(uVar3 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f960 + (ulong)(uVar1 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010fd60 + (ulong)(uVar2 & 0xff) * 4) ^ puVar13[4];
    uVar11 = *(uint *)(&DAT_00110560 + (ulong)(uVar1 >> 0x10 & 0xff) * 4) ^
             *(uint *)(&DAT_00110160 + (ulong)(uVar11 >> 0x18) * 4) ^
             *(uint *)(&DAT_0010f960 + (ulong)(uVar2 >> 8 & 0xff) * 4) ^
             *(uint *)(&DAT_0010fd60 + (ulong)(uVar3 & 0xff) * 4) ^ puVar13[5];
    puVar13 = puVar13 + 8;
  }
  uVar17 = *(uint *)(&DAT_0010f960 + (ulong)(uVar2 >> 0x18) * 4);
  uVar16 = *(uint *)(&DAT_0010f960 + (ulong)(uVar3 >> 0x18) * 4);
  uVar4 = *(uint *)(&DAT_0010f960 + (ulong)(uVar11 >> 0x18) * 4);
  uVar5 = *(uint *)(&DAT_0010fd60 + (ulong)(uVar3 >> 0x10 & 0xff) * 4);
  uVar6 = *(uint *)(&DAT_0010fd60 + (ulong)(uVar11 >> 0x10 & 0xff) * 4);
  uVar7 = *(uint *)(&DAT_0010fd60 + (ulong)(uVar1 >> 0x10 & 0xff) * 4);
  bVar8 = (&DAT_00110560)[(ulong)(uVar1 & 0xff) * 4];
  bVar9 = (&DAT_00110560)[(ulong)(uVar2 & 0xff) * 4];
  bVar10 = (&DAT_00110560)[(ulong)(uVar3 & 0xff) * 4];
  uVar15 = (*(uint *)(&DAT_0010fd60 + (ulong)(uVar2 >> 0x10 & 0xff) * 4) & 0xff0000 |
            *(uint *)(&DAT_0010f960 + (ulong)(uVar1 >> 0x18) * 4) & 0xff000000 |
            *(uint *)(&DAT_00110160 + (ulong)(uVar3 >> 8 & 0xff) * 4) & 0xff00 |
           (uint)(byte)(&DAT_00110560)[(ulong)(uVar11 & 0xff) * 4]) ^ param_3[uVar12 * 8 + 8];
  uVar11 = *(uint *)(&DAT_00110160 + (ulong)(uVar11 >> 8 & 0xff) * 4);
  uVar1 = *(uint *)(&DAT_00110160 + (ulong)(uVar1 >> 8 & 0xff) * 4);
  uVar2 = *(uint *)(&DAT_00110160 + (ulong)(uVar2 >> 8 & 0xff) * 4);
  *param_2 = (char)(uVar15 >> 0x18);
  param_2[3] = (char)uVar15;
  param_2[1] = (char)(uVar15 >> 0x10);
  param_2[2] = (char)(uVar15 >> 8);
  uVar15 = (uVar5 & 0xff0000 | uVar17 & 0xff000000 | uVar11 & 0xff00 | (uint)bVar8) ^
           param_3[uVar12 * 8 + 9];
  param_2[7] = (char)uVar15;
  param_2[4] = (char)(uVar15 >> 0x18);
  param_2[5] = (char)(uVar15 >> 0x10);
  param_2[6] = (char)(uVar15 >> 8);
  uVar15 = (uVar6 & 0xff0000 | uVar16 & 0xff000000 | uVar1 & 0xff00 | (uint)bVar9) ^
           param_3[uVar12 * 8 + 10];
  param_2[0xb] = (char)uVar15;
  param_2[8] = (char)(uVar15 >> 0x18);
  param_2[9] = (char)(uVar15 >> 0x10);
  param_2[10] = (char)(uVar15 >> 8);
  uVar15 = (uVar7 & 0xff0000 | uVar4 & 0xff000000 | uVar2 & 0xff00 | (uint)bVar10) ^
           param_3[uVar12 * 8 + 0xb];
  param_2[0xc] = (char)(uVar15 >> 0x18);
  param_2[0xd] = (char)(uVar15 >> 0x10);
  param_2[0xe] = (char)(uVar15 >> 8);
  param_2[0xf] = (char)uVar15;
  return;
}



// ===== FUN_00107bb0 @ 00107bb0 size=204 =====

void FUN_00107bb0(undefined8 param_1,long param_2,ulong param_3,long param_4,ulong *param_5)

{
  long lVar1;
  ulong uVar2;
  undefined1 auStack_150 [248];
  long local_58;
  
  lVar1 = tpidr_el0;
  local_58 = *(long *)(lVar1 + 0x28);
  if (*param_5 < param_3) {
    *param_5 = 0;
  }
  else {
    FUN_00106f10(param_1,0x80,auStack_150);
    if (param_3 != 0) {
      uVar2 = 0;
      do {
        FUN_00107144(param_2 + uVar2,param_4 + uVar2,auStack_150);
        uVar2 = uVar2 + 0x10;
      } while (uVar2 < param_3);
      param_4 = param_4 + uVar2;
    }
    uVar2 = 0;
    if ((byte)(*(byte *)(param_4 + -1) - 1) < 0x10) {
      uVar2 = param_3 - *(byte *)(param_4 + -1);
    }
    *param_5 = uVar2;
  }
  if (*(long *)(lVar1 + 0x28) == local_58) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00107c7c @ 00107c7c size=272 =====

void FUN_00107c7c(undefined8 param_1,void *param_2,ulong param_3,long param_4,ulong *param_5)

{
  long lVar1;
  ulong __n;
  size_t __n_00;
  ulong uVar2;
  undefined1 auStack_170 [248];
  undefined8 local_78;
  undefined8 uStack_70;
  long local_68;
  
  lVar1 = tpidr_el0;
  local_68 = *(long *)(lVar1 + 0x28);
  if (*param_5 < param_3 + 0x10) {
    *param_5 = 0;
  }
  else {
    __n = param_3 & 0xf;
    local_78 = 0;
    uStack_70 = 0;
    FUN_001074c0(param_1,0x80,auStack_170);
    if (param_3 != __n) {
      uVar2 = 0;
      do {
        FUN_0010780c((long)param_2 + uVar2,param_4 + uVar2,auStack_170);
        uVar2 = uVar2 + 0x10;
      } while (uVar2 < param_3 - __n);
      param_2 = (void *)((long)param_2 + uVar2);
      param_4 = param_4 + uVar2;
    }
    __n_00 = 0x10 - __n;
    memcpy(&local_78,param_2,__n);
    memset((void *)((long)&local_78 + __n),(int)__n_00,__n_00);
    FUN_0010780c(&local_78,param_4,auStack_170);
    *param_5 = __n_00 + param_3;
  }
  if (*(long *)(lVar1 + 0x28) == local_68) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00107d8c @ 00107d8c size=344 =====

undefined8 FUN_00107d8c(long *param_1,undefined8 param_2,long param_3,int param_4)

{
  long lVar1;
  long lVar2;
  void *__ptr;
  undefined8 uVar3;
  size_t local_60;
  long local_58;
  
  lVar1 = tpidr_el0;
  local_58 = *(long *)(lVar1 + 0x28);
  uVar3 = 0;
  if ((param_3 != 0) && (0 < param_4)) {
    lVar2 = (**(code **)(*param_1 + 0x5c0))(param_1,param_3,0);
    if (lVar2 == 0) {
      uVar3 = 0;
    }
    else {
      local_60 = (size_t)(param_4 + 0x76);
      __ptr = malloc(local_60);
      if (__ptr == (void *)0x0) {
        (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar2,0);
        uVar3 = 0;
      }
      else {
        FUN_00102bd8(lVar2,(long)param_4,__ptr,&local_60);
        if (local_60 == 0) {
          uVar3 = 0;
        }
        else {
          uVar3 = (**(code **)(*param_1 + 0x580))(param_1);
          (**(code **)(*param_1 + 0x680))(param_1,uVar3,0,local_60 & 0xffffffff,__ptr);
        }
        (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar2,0);
        free(__ptr);
      }
    }
  }
  if (*(long *)(lVar1 + 0x28) == local_58) {
    return uVar3;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== __cxa_finalize @ 00119000 size=1 =====

/* WARNING: Control flow encountered bad instruction data */

void __cxa_finalize(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== __deregister_frame_info @ 00119008 size=1 =====

/* WARNING: Control flow encountered bad instruction data */

void __deregister_frame_info(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== _Jv_RegisterClasses @ 00119010 size=1 =====

/* WARNING: Control flow encountered bad instruction data */

void _Jv_RegisterClasses(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== _ITM_deregisterTMCloneTable @ 00119018 size=1 =====

/* WARNING: Control flow encountered bad instruction data */

void _ITM_deregisterTMCloneTable(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== srand @ 00119020 size=1 =====

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void srand(uint __seed)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== time @ 00119028 size=1 =====

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

time_t time(time_t *__timer)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== rand @ 00119030 size=1 =====

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

int rand(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== __stack_chk_fail @ 00119038 size=1 =====

/* WARNING: Control flow encountered bad instruction data */

void __stack_chk_fail(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== __register_frame_info @ 00119040 size=1 =====

/* WARNING: Control flow encountered bad instruction data */

void __register_frame_info(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== _ITM_registerTMCloneTable @ 00119048 size=1 =====

/* WARNING: Control flow encountered bad instruction data */

void _ITM_registerTMCloneTable(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== malloc @ 00119050 size=1 =====

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== memcpy @ 00119058 size=1 =====

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * memcpy(void *__dest,void *__src,size_t __n)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== memset @ 00119060 size=1 =====

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * memset(void *__s,int __c,size_t __n)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



// ===== free @ 00119068 size=1 =====

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



