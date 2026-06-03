// S-box @ 005e081f
// referencing functions: 15

// ===== FUN_0053c0a0 @ 0053c0a0 size=1736 =====

/* WARNING: Type propagation algorithm not settling */

void FUN_0053c0a0(long param_1,int *param_2,undefined8 param_3,short param_4)

{
  size_t __n;
  size_t sVar1;
  char *__s1;
  ulong uVar2;
  void *__s1_00;
  byte bVar3;
  ushort uVar4;
  char cVar5;
  bool bVar6;
  long lVar7;
  int iVar8;
  int iVar9;
  undefined8 uVar10;
  long *plVar11;
  undefined8 *puVar12;
  long lVar13;
  size_t sVar14;
  long lVar15;
  char *pcVar16;
  char *__s2;
  long *plVar17;
  uint uVar18;
  long *plVar19;
  ulong local_160;
  undefined8 local_158;
  char *local_150;
  byte local_148 [16];
  void *local_138;
  ulong local_130;
  ulong local_128;
  void *local_120;
  byte local_118 [16];
  void *local_108;
  ulong local_100;
  undefined8 local_f8;
  char *local_f0;
  byte local_e8 [16];
  void *local_d8;
  ulong local_d0;
  undefined8 local_c8;
  void *local_c0;
  byte local_b8 [16];
  void *local_a8;
  ulong local_a0;
  size_t local_98;
  char *local_90;
  byte local_88 [16];
  void *local_78;
  ulong local_70;
  ulong local_68;
  void *local_60;
  long local_58;
  
  lVar7 = tpidr_el0;
  local_58 = *(long *)(lVar7 + 0x28);
  if (*(char *)(param_1 + 0x18) == '\0') goto LAB_0053c1d8;
  if (*(long *)(param_1 + 0x58) != 0) {
                    /* try { // try from 0053c0e4 to 0063c0ef has its CatchHandler @ 0053c15c */
    FUN_00490d6c();
    plVar19 = *(long **)(param_1 + 0x60);
    *(undefined8 *)(param_1 + 0x58) = 0;
    *(undefined8 *)(param_1 + 0x60) = 0;
    if (plVar19 != (long *)0x0) {
      plVar11 = plVar19 + 1;
      do {
                    /* try { // try from 0053c0f8 to 0063c0fb has its CatchHandler @ 0053c168 */
        lVar15 = *plVar11;
        cVar5 = '\x01';
        bVar6 = (bool)ExclusiveMonitorPass(plVar11,0x10);
        if (bVar6) {
          *plVar11 = lVar15 + -1;
          cVar5 = ExclusiveMonitorsStatus();
        }
      } while (cVar5 != '\0');
      if (lVar15 == 0) {
        (**(code **)(*plVar19 + 0x10))(plVar19);
        std::__ndk1::__shared_weak_count::__release_weak();
      }
    }
  }
  if (*(int *)(param_1 + 0xac) != 4) goto LAB_0053c1d8;
  if ((*param_2 == 0) && (uVar10 = FUN_00489a48(param_3), (int)uVar10 != 0)) {
    local_68 = 0;
    local_60 = (void *)0x0;
    local_70 = 0;
    FUN_0053cff4(uVar10,3,param_3,&local_70);
    uVar2 = local_70 >> 1 & 0x7f;
    if ((local_70 & 1) != 0) {
      uVar2 = local_68;
    }
    if ((uVar2 == 0) && ((param_4 == 0xce || (param_4 == 200)))) {
      uVar10 = FUN_00175474(local_88,&DAT_005e0309);
      local_98 = 0;
      local_90 = (char *)0x0;
      local_a0 = 0;
      FUN_0053a780(uVar10,param_3,local_88,&local_a0);
                    /* try { // try from 0053c334 to 0063c33b has its CatchHandler @ 0053c378 */
      uVar10 = FUN_00175474(local_b8,"//NewInternalClient");
      local_c8 = 0;
      local_c0 = (void *)0x0;
                    /* try { // try from 0053c33c to 0063c3cb has its CatchHandler @ 0053c194 */
      local_d0 = 0;
      FUN_0053a780(uVar10,param_3,local_b8,&local_d0);
      uVar2 = local_a0;
      bVar3 = *(byte *)(param_1 + 400);
      sVar14 = local_a0 >> 1 & 0x7f;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c2d4 with catch @ 0053c368
                        */
      __n = sVar14;
      if ((local_a0 & 1) != 0) {
        __n = local_98;
      }
      sVar1 = (ulong)(bVar3 >> 1);
      if ((bVar3 & 1) != 0) {
        sVar1 = *(size_t *)(param_1 + 0x198);
      }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c334 with catch @ 0053c378
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c2a8 with catch @ 0053c37c
                        */
      if (__n == sVar1) {
        __s2 = *(char **)(param_1 + 0x1a0);
        pcVar16 = (char *)((ulong)&local_a0 | 1);
        __s1 = pcVar16;
        if ((local_a0 & 1) != 0) {
          __s1 = local_90;
        }
        if ((bVar3 & 1) == 0) {
          __s2 = (char *)(param_1 + 0x191);
        }
        sVar1 = __n;
        if ((local_a0 & 1) == 0) {
          while (sVar1 != 0) {
            if (*pcVar16 != *__s2) goto LAB_0053c3e0;
            pcVar16 = pcVar16 + 1;
            __s2 = __s2 + 1;
            sVar14 = sVar14 - 1;
            sVar1 = sVar14;
          }
        }
        else {
                    /* try { // try from 0053c3d4 to 0063c3df has its CatchHandler @ 0053c194 */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c3cc with catch @ 0053c3dc
                        */
          if ((__n != 0) && (iVar8 = memcmp(__s1,__s2,__n), iVar8 != 0)) goto LAB_0053c3e0;
        }
LAB_0053c4a0:
                    /* catch() { ... } // from try @ 0053c56c with catch @ 0053c4a0 */
        uVar10 = FUN_00175474(local_e8,"//NewExternalPort");
        local_f8 = 0;
        local_f0 = (char *)0x0;
        local_100 = 0;
        FUN_0053a780(uVar10,param_3,local_e8,&local_100);
        uVar10 = FUN_00175474(local_118,"//NewProtocol");
        local_128 = 0;
        local_120 = (void *)0x0;
        local_130 = 0;
        FUN_0053a780(uVar10,param_3,local_118,&local_130);
        uVar10 = FUN_00175474(local_148,"//NewInternalPort");
        local_158 = 0;
        local_150 = (char *)0x0;
        local_160 = 0;
        FUN_0053a780(uVar10,param_3,local_148,&local_160);
        uVar2 = local_130 >> 1 & 0x7f;
        if ((local_130 & 1) != 0) {
          uVar2 = local_128;
        }
        if (uVar2 == 3) {
          __s1_00 = (void *)((ulong)&local_130 | 1);
          if ((local_130 & 1) != 0) {
            __s1_00 = local_120;
          }
          iVar8 = memcmp(__s1_00,&DAT_005c1476,3);
                    /* try { // try from 0053c558 to 0063c56b has its CatchHandler @ 0053c5d8 */
          uVar18 = (uint)(iVar8 == 0);
        }
        else {
          uVar18 = 0;
        }
                    /* try { // try from 0053c56c to 0063c627 has its CatchHandler @ 0053c4a0 */
        pcVar16 = (char *)((ulong)&local_160 | 1);
        if ((local_160 & 1) != 0) {
          pcVar16 = local_150;
        }
        uVar2 = local_160 & 1;
        iVar8 = atoi(pcVar16);
        pcVar16 = (char *)((ulong)&local_100 | 1);
        if ((local_100 & 1) != 0) {
          pcVar16 = local_f0;
        }
        iVar9 = atoi(pcVar16);
        uVar4 = *(ushort *)(param_1 + 0x180);
        plVar19 = operator_new(0x20);
        *(short *)((long)plVar19 + 0x14) = (short)iVar8;
        *(short *)((long)plVar19 + 0x16) = (short)iVar9;
        *(undefined4 *)(plVar19 + 2) = 2;
        *(uint *)(plVar19 + 3) = uVar18 ^ 1;
        *(uint *)((long)plVar19 + 0x1c) = uVar4 - 1;
                    /* catch() { ... } // from try @ 0053c558 with catch @ 0053c5d8 */
        plVar19[1] = param_1 + 0x168;
        lVar15 = *(long *)(param_1 + 0x168);
        *plVar19 = lVar15;
        *(long **)(lVar15 + 8) = plVar19;
        *(long **)(param_1 + 0x168) = plVar19;
        *(long *)(param_1 + 0x178) = *(long *)(param_1 + 0x178) + 1;
        if (uVar2 != 0) {
          operator_delete(local_150);
                    /* try { // try from 0053c628 to 0063c70b has its CatchHandler @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c628 with catch @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c740 with catch @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c7a0 with catch @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c7d8 with catch @ 0053c628
                        */
        }
        if ((local_148[0] & 1) != 0) {
          operator_delete(local_138);
        }
        if ((local_130 & 1) != 0) {
          operator_delete(local_120);
        }
        if ((local_118[0] & 1) != 0) {
          operator_delete(local_108);
        }
        if ((local_100 & 1) != 0) {
LAB_0053c6d0:
          operator_delete(local_f0);
        }
      }
      else {
LAB_0053c3e0:
        if (__n == 6) {
          pcVar16 = (char *)((ulong)&local_a0 | 1);
          if ((uVar2 & 1) != 0) {
            pcVar16 = local_90;
          }
          iVar8 = memcmp(pcVar16,"appmap",6);
          if (iVar8 == 0) goto LAB_0053c4a0;
        }
        uVar10 = FUN_00175474(local_e8,"//NewExternalPort");
        local_f8 = 0;
        local_f0 = (char *)0x0;
        local_100 = 0;
        FUN_0053a780(uVar10,param_3,local_e8,&local_100);
        bVar3 = (byte)local_100;
        pcVar16 = (char *)((ulong)&local_100 | 1);
        if ((local_100 & 1) != 0) {
          pcVar16 = local_f0;
        }
        uVar18 = atoi(pcVar16);
        plVar19 = (long *)(param_1 + 0x158);
        plVar11 = *(long **)(param_1 + 0x158);
        if (*(long **)(param_1 + 0x158) == (long *)0x0) {
          lVar15 = *plVar19;
          plVar17 = plVar19;
        }
        else {
          do {
            while (plVar17 = plVar11, (uint)*(ushort *)((long)plVar17 + 0x1a) <= (uVar18 & 0xffff))
            {
              if ((uVar18 & 0xffff) <= (uint)*(ushort *)((long)plVar17 + 0x1a)) goto LAB_0053c678;
              plVar19 = plVar17 + 1;
              plVar11 = (long *)*plVar19;
              if ((long *)*plVar19 == (long *)0x0) goto LAB_0053c678;
            }
            plVar19 = plVar17;
            plVar11 = (long *)*plVar17;
          } while ((long *)*plVar17 != (long *)0x0);
LAB_0053c678:
          lVar15 = *plVar19;
        }
        if (lVar15 == 0) {
          puVar12 = operator_new(0x20);
          *(short *)((long)puVar12 + 0x1a) = (short)uVar18;
          *puVar12 = 0;
          puVar12[1] = 0;
          puVar12[2] = plVar17;
          *plVar19 = (long)puVar12;
          if (**(long **)(param_1 + 0x150) != 0) {
            *(long *)(param_1 + 0x150) = **(long **)(param_1 + 0x150);
            puVar12 = (undefined8 *)*plVar19;
          }
          FUN_00176d70(*(undefined8 *)(param_1 + 0x158),puVar12);
          *(long *)(param_1 + 0x160) = *(long *)(param_1 + 0x160) + 1;
          bVar3 = (byte)local_100;
        }
        if ((bVar3 & 1) != 0) goto LAB_0053c6d0;
      }
      if ((local_e8[0] & 1) != 0) {
                    /* try { // try from 0053c720 to 0063c72b has its CatchHandler @ 0053c7bc */
        operator_delete(local_d8);
      }
      if ((local_d0 & 1) != 0) {
        operator_delete(local_c0);
                    /* try { // try from 0053c738 to 0063c73f has its CatchHandler @ 0053c7b8 */
      }
      if ((local_b8[0] & 1) != 0) {
                    /* try { // try from 0053c740 to 0063c797 has its CatchHandler @ 0053c628 */
        operator_delete(local_a8);
      }
      if ((local_a0 & 1) != 0) {
        operator_delete(local_90);
      }
      if ((local_88[0] & 1) != 0) {
        operator_delete(local_78);
      }
    }
    else {
      *(undefined1 *)(param_1 + 0x148) = 1;
    }
    if ((local_70 & 1) != 0) {
      operator_delete(local_60);
    }
  }
  else {
    *(undefined1 *)(param_1 + 0x148) = 1;
  }
  plVar19 = *(long **)(param_1 + 0x70);
                    /* try { // try from 0053c148 to 0063c153 has its CatchHandler @ 0053c15c */
  lVar15 = *plVar19;
  *(long *)(lVar15 + 8) = plVar19[1];
                    /* try { // try from 0053c154 to 0063c183 has its CatchHandler @ 0053bfcc */
  *(long *)plVar19[1] = lVar15;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c040 with catch @ 0053c15c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c0e4 with catch @ 0053c15c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c148 with catch @ 0053c15c
                        */
  *(long *)(param_1 + 0x78) = *(long *)(param_1 + 0x78) + -1;
  operator_delete(plVar19);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c0f8 with catch @ 0053c168
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c020 with catch @ 0053c16c
                        */
  if (*(char *)(param_1 + 0x148) == '\0') {
    uVar4 = *(ushort *)(param_1 + 0x180);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c09c with catch @ 0053c178
                        */
    *(ushort *)(param_1 + 0x180) = uVar4 + 1;
    if (*(char *)(param_1 + 0x18) != '\0') {
                    /* try { // try from 0053c184 to 0063c187 has its CatchHandler @ 0053c190 */
                    /* try { // try from 0053c188 to 0063c193 has its CatchHandler @ 0053bfcc */
      plVar19 = operator_new(0x20);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c184 with catch @ 0053c190
                        */
      *(undefined8 *)((long)plVar19 + 0x14) = 0;
                    /* try { // try from 0053c194 to 0063c2a7 has its CatchHandler @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c194 with catch @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c2e0 with catch @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c33c with catch @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c3d4 with catch @ 0053c194
                        */
      *(uint *)((long)plVar19 + 0x1c) = (uint)uVar4;
      *(undefined4 *)(plVar19 + 2) = 3;
      lVar15 = *(long *)(param_1 + 0x68);
      *plVar19 = lVar15;
      plVar19[1] = param_1 + 0x68;
      *(long **)(lVar15 + 8) = plVar19;
      *(long **)(param_1 + 0x68) = plVar19;
      *(long *)(param_1 + 0x78) = *(long *)(param_1 + 0x78) + 1;
    }
  }
  *(undefined4 *)(param_1 + 0xac) = 5;
  uVar10 = FUN_00420784();
  *(undefined8 *)(param_1 + 0xb0) = uVar10;
  if (*(long *)(param_1 + 0x78) == 0) {
    if (*(long *)(param_1 + 0x178) == 0) goto LAB_0053c1d8;
    plVar17 = *(long **)(param_1 + 0x170);
    plVar19 = (long *)(param_1 + 0x168);
    plVar11 = plVar19;
    if (plVar19 != plVar17) {
      lVar15 = 1;
      do {
        plVar11 = operator_new(0x20);
        lVar13 = plVar17[2];
        plVar11[3] = plVar17[3];
        plVar11[2] = lVar13;
        lVar13 = *(long *)(param_1 + 0x68);
        *plVar11 = lVar13;
        plVar11[1] = param_1 + 0x68;
        *(long **)(lVar13 + 8) = plVar11;
        *(long **)(param_1 + 0x68) = plVar11;
        *(long *)(param_1 + 0x78) = lVar15;
        plVar17 = (long *)plVar17[1];
        lVar15 = lVar15 + 1;
      } while (plVar19 != plVar17);
      plVar11 = *(long **)(param_1 + 0x170);
                    /* try { // try from 0053c2a8 to 0063c2af has its CatchHandler @ 0053c37c */
    }
    lVar15 = *(long *)(param_1 + 0x168);
    lVar13 = *plVar11;
    *(undefined8 *)(lVar13 + 8) = *(undefined8 *)(lVar15 + 8);
    **(long **)(lVar15 + 8) = lVar13;
    *(undefined8 *)(param_1 + 0x178) = 0;
    while (plVar11 != plVar19) {
                    /* try { // try from 0053c2d4 to 0063c2df has its CatchHandler @ 0053c368 */
      plVar17 = (long *)plVar11[1];
      operator_delete(plVar11);
                    /* try { // try from 0053c2e0 to 0063c333 has its CatchHandler @ 0053c194 */
      plVar11 = plVar17;
    }
  }
  FUN_0053a8e8(param_1);
LAB_0053c1d8:
  if (*(long *)(lVar7 + 0x28) != local_58) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}



// ===== FUN_0054039c @ 0054039c size=356 =====

void FUN_0054039c(undefined8 *param_1,undefined8 param_2,undefined8 param_3)

{
  long lVar1;
  long *plVar2;
  undefined8 uVar3;
  long lVar4;
  long *plVar5;
  bad_alloc *this;
  long *local_b0;
  undefined8 auStack_a8 [2];
  undefined8 local_98;
  undefined8 uStack_90;
  int local_88;
  undefined8 local_80;
  undefined8 uStack_78;
  undefined8 *local_70;
  long local_48;
  
  lVar1 = tpidr_el0;
  local_48 = *(long *)(lVar1 + 0x28);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00540338 with catch @ 005403c0
                        */
  param_1[1] = "Internal error";
  *param_1 = 0;
  param_1[2] = 0;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054038c with catch @ 005403d8
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054030c with catch @ 005403dc
                        */
  plVar2 = (long *)(*(code *)PTR_malloc_006f1270)(0x1028);
  *plVar2 = 0;
  plVar2[3] = 0;
  plVar5 = plVar2 + 1;
  *plVar5 = (long)(plVar2 + 3);
  plVar2[2] = 0;
  plVar2[4] = 0x1000;
  if (plVar2 == (long *)0x0) {
    this = (bad_alloc *)__cxa_allocate_exception(8);
    std::bad_alloc::bad_alloc(this);
                    /* WARNING: Subroutine does not return */
    __cxa_throw(this,PTR_typeinfo_006ef978,PTR__bad_alloc_006effb8);
  }
                    /* try { // try from 00540420 to 00640427 has its CatchHandler @ 00540430 */
                    /* try { // try from 00540428 to 00640433 has its CatchHandler @ 00540228 */
  local_98 = 0;
  uStack_90 = 0;
  local_b0 = plVar5;
  auStack_a8[0] = param_2;
  FUN_00548530(auStack_a8);
  local_80 = param_2;
  uStack_78 = param_3;
  local_70 = param_1 + 1;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00540420 with catch @ 00540430
                        */
                    /* try { // try from 00540434 to 006404f7 has its CatchHandler @ 00540434
                       catch(type#1 @ 00000000) { ... } // from try @ 00540434 with catch @ 00540434
                        */
  uVar3 = FUN_005489d0(&local_b0);
  lVar4 = FUN_00548854(&local_b0,uVar3,0);
  if (local_88 == 0x1a) {
    *plVar2 = lVar4;
    if (lVar4 == 0) {
      plVar5 = (long *)*plVar5;
      while( true ) {
        plVar5 = (long *)*plVar5;
        if (plVar5 == (long *)0x0) break;
        (*(code *)PTR_free_006f1268)();
      }
      (*(code *)PTR_free_006f1268)(plVar2);
    }
    else {
      FUN_00540548(lVar4,plVar5);
      *param_1 = plVar2;
      param_1[1] = 0;
    }
    if (*(long *)(lVar1 + 0x28) == local_48) {
      return;
    }
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
                    /* WARNING: Subroutine does not return */
                    /* try { // try from 005404f8 to 006404ff has its CatchHandler @ 0054051c */
  FUN_00548800(&local_b0,"Incorrect query");
}



// ===== FUN_00546028 @ 00546028 size=420 =====

ulong FUN_00546028(ulong param_1,char *param_2,ulong param_3)

{
  char cVar1;
  char cVar2;
  char cVar3;
  char cVar4;
  bool bVar5;
  bool bVar6;
  uint uVar7;
  uint uVar8;
  
                    /* try { // try from 00546040 to 00646073 has its CatchHandler @ 005460b4 */
  switch(param_1 & 0xffffffff) {
  case 0:
    if (param_3 < 4) {
      return 1;
    }
    cVar1 = *param_2;
    cVar2 = param_2[1];
    cVar3 = param_2[2];
    cVar4 = param_2[3];
                    /* try { // try from 0054607c to 00646083 has its CatchHandler @ 005460b0 */
                    /* try { // try from 00546084 to 006460b7 has its CatchHandler @ 00545fb8 */
    if (((cVar2 != '\0' || cVar1 != '\0') || (cVar3 != -2)) || (cVar4 != -1)) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054607c with catch @ 005460b0
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00546040 with catch @ 005460b4
                        */
      if ((cVar1 == -1 && cVar2 == -2) && (cVar4 == '\0' && cVar3 == '\0')) {
        return 5;
      }
                    /* try { // try from 005460b8 to 006460bf has its CatchHandler @ 005460c8 */
                    /* try { // try from 005460c0 to 006460cb has its CatchHandler @ 00545fb8 */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 005460b8 with catch @ 005460c8
                        */
      uVar8 = 2;
      if (cVar1 == -2 && cVar2 == -1) {
        uVar8 = 3;
      }
      if (cVar1 == -2 && cVar2 == -1 || cVar1 == -1 && cVar2 == -2) {
        return (ulong)uVar8;
      }
      if (((cVar1 == -0x11) && (cVar2 == -0x45)) && (cVar3 == -0x41)) {
        return 1;
      }
      if (((cVar2 != '\0' || cVar1 != '\0') || cVar3 != '\0') || (cVar4 != '<')) {
        bVar5 = cVar2 == '\0';
        bVar6 = cVar1 == '<';
        if ((bVar6 && bVar5) && (cVar4 == '\0' && cVar3 == '\0')) {
          return 5;
        }
        if (((cVar1 == '\0' && cVar2 == '<') && (cVar3 == '\0')) && (cVar4 == '?')) {
          return 3;
        }
        if (((bVar6 && bVar5) && cVar3 == '?') && (cVar4 == '\0')) {
          return 2;
        }
        uVar8 = 3;
        if (((cVar1 == '<' && cVar2 == '?') && cVar3 == 'x') && cVar4 == 'm') {
          uVar8 = 1;
        }
        uVar7 = 1;
        if (bVar6 && bVar5) {
          uVar7 = 2;
        }
        if ((cVar1 != '\0' || cVar2 != '<') &&
            (((cVar1 != '<' || cVar2 != '?') || cVar3 != 'x') || cVar4 != 'm')) {
          uVar8 = uVar7;
        }
        return (ulong)uVar8;
      }
    }
    param_1 = 6;
    break;
  case 4:
    return 2;
  case 7:
  case 8:
    return 5;
  }
  return param_1;
}



// ===== FUN_0054ad30 @ 0054ad30 size=2336 =====

long * FUN_0054ad30(undefined8 *param_1,long param_2)

{
  undefined8 *puVar1;
  ulong uVar2;
  byte bVar3;
  long lVar4;
  bool bVar5;
  int iVar6;
  long *plVar7;
  long *plVar8;
  undefined8 uVar9;
  long lVar10;
  long *plVar11;
  undefined4 uVar12;
  byte *pbVar13;
  byte *pbVar14;
  byte *pbVar15;
  long lVar16;
  char *pcVar17;
  long *plVar18;
  size_t __n;
  ulong uVar19;
  long *plVar20;
  undefined1 uVar21;
  byte *local_80;
  byte *pbStack_78;
  long local_68;
  
  lVar4 = tpidr_el0;
  local_68 = *(long *)(lVar4 + 0x28);
                    /* try { // try from 0054ad64 to 0064ad6b has its CatchHandler @ 0054ad70 */
                    /* try { // try from 0054ad6c to 0064ad97 has its CatchHandler @ 0054ac28 */
  if ((param_2 != 0) && (*(char *)(param_2 + 1) != '\x01')) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b5a8 with catch @ 0054b5f4
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b528 with catch @ 0054b5f8
                        */
                    /* WARNING: Subroutine does not return */
    FUN_00548800(param_1,"Step has to be applied to node set");
  }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054ad64 with catch @ 0054ad70
                        */
  iVar6 = *(int *)(param_1 + 5);
  puVar1 = param_1 + 1;
  if (iVar6 == 0x18) {
    FUN_00548530(puVar1);
    plVar18 = (long *)*param_1;
    uVar2 = plVar18[1] + 0x28;
    if (*(ulong *)(*plVar18 + 8) < uVar2) {
      plVar7 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar7 == (long *)0x0) {
LAB_0054b5d8:
                    /* WARNING: Subroutine does not return */
        FUN_00548f50();
      }
      *plVar7 = *plVar18;
      plVar7[1] = 0x1000;
      *plVar18 = (long)plVar7;
      plVar18[1] = 0x28;
    }
    else {
      plVar7 = (long *)(*plVar18 + plVar18[1]);
      plVar18[1] = uVar2;
    }
    uVar12 = 0x2090138;
  }
  else {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054ad10 with catch @ 0054ad84
                        */
    if (iVar6 != 0x17) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054acf8 with catch @ 0054ad88
                        */
      bVar5 = iVar6 != 0x16;
      if (bVar5) {
        uVar21 = 3;
      }
      else {
        FUN_00548530(puVar1);
                    /* try { // try from 0054ad98 to 0064ada3 has its CatchHandler @ 0054ada8 */
        iVar6 = *(int *)(param_1 + 5);
        uVar21 = 2;
                    /* try { // try from 0054ada4 to 0064adef has its CatchHandler @ 0054ac28 */
      }
      local_80 = (byte *)0x0;
      pbStack_78 = (byte *)0x0;
      if (iVar6 == 9) {
LAB_0054b33c:
        pbStack_78 = (byte *)0x0;
        local_80 = (byte *)0x0;
        FUN_00548530(puVar1);
        iVar6 = 7;
      }
      else {
        if (iVar6 != 0x14) {
LAB_0054b600:
                    /* WARNING: Subroutine does not return */
          FUN_00548800(param_1,"Unrecognized node test");
        }
        pbStack_78 = (byte *)param_1[4];
        local_80 = (byte *)param_1[3];
                    /* try { // try from 0054ae78 to 0064ae83 has its CatchHandler @ 0054aee0 */
        FUN_00548530(puVar1);
        iVar6 = *(int *)(param_1 + 5);
                    /* try { // try from 0054ae84 to 0064af23 has its CatchHandler @ 0054adf0 */
        if (iVar6 == 0x19) {
          if (!bVar5) {
                    /* WARNING: Subroutine does not return */
            FUN_00548800(param_1,&DAT_005e11ba);
          }
          switch(*local_80) {
          case 0x61:
            lVar10 = (long)pbStack_78 - (long)local_80;
            if (pbStack_78 != local_80) {
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "ancestor";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if (lVar10 == 8) {
                    uVar21 = 0;
                    goto LAB_0054b290;
                  }
                  break;
                }
                    /* catch() { ... } // from try @ 0054ae78 with catch @ 0054aee0 */
                pbVar14 = pbVar14 + -1;
              } while (*pcVar17 == *pbVar13);
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "ancestor-or-self";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b1ac with catch @ 0054b1e8
                        */
                    /* try { // try from 0054b1ec to 0064b273 has its CatchHandler @ 0054b1ec
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b1ec with catch @ 0054b1ec
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b2b8 with catch @ 0054b1ec
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b2f4 with catch @ 0054b1ec
                        */
                  if (lVar10 == 0x10) {
                    uVar21 = 1;
                    goto LAB_0054b290;
                  }
                  break;
                }
                pbVar14 = pbVar14 + -1;
              } while (*pcVar17 == *pbVar13);
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pbVar15 = &DAT_005e0e44;
              pbVar13 = local_80;
LAB_0054b20c:
              pbVar13 = pbVar13 + 1;
              if (pbVar14 != (byte *)0x0) goto code_r0x0054b210;
              if (lVar10 == 9) {
                uVar21 = 2;
LAB_0054b290:
                FUN_00548530(puVar1);
                if (*(int *)(param_1 + 5) == 9) goto LAB_0054b33c;
                if (*(int *)(param_1 + 5) != 0x14) goto LAB_0054b600;
                pbStack_78 = (byte *)param_1[4];
                local_80 = (byte *)param_1[3];
                    /* try { // try from 0054b2b0 to 0064b2b7 has its CatchHandler @ 0054b2e4 */
                    /* try { // try from 0054b2b8 to 0064b2eb has its CatchHandler @ 0054b1ec */
                FUN_00548530(puVar1);
                iVar6 = *(int *)(param_1 + 5);
                goto LAB_0054b2c0;
              }
              break;
            }
            break;
          case 99:
            if (pbStack_78 != local_80) {
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pbVar15 = &LAB_005e12c4_1;
              pbVar13 = local_80;
              do {
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if ((long)pbStack_78 - (long)local_80 == 5) {
                    uVar21 = 3;
                    goto LAB_0054b290;
                  }
                  break;
                }
                bVar3 = *pbVar15;
                pbVar14 = pbVar14 + -1;
                pbVar15 = pbVar15 + 1;
              } while (bVar3 == *pbVar13);
            }
            break;
          case 100:
            if (pbStack_78 != local_80) {
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pbVar15 = &LAB_005e12c8_3;
              pbVar13 = local_80;
              do {
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if ((long)pbStack_78 - (long)local_80 == 10) {
                    uVar21 = 4;
                    goto LAB_0054b290;
                  }
                  break;
                }
                bVar3 = *pbVar15;
                pbVar14 = pbVar14 + -1;
                pbVar15 = pbVar15 + 1;
              } while (bVar3 == *pbVar13);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b0b8 with catch @ 0054b168
                        */
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "descendant-or-self";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if ((long)pbStack_78 - (long)local_80 == 0x12) {
                    uVar21 = 5;
                    goto LAB_0054b290;
                  }
                  break;
                }
                pbVar14 = pbVar14 + -1;
              } while (*pcVar17 == *pbVar13);
            }
            break;
          case 0x66:
            if (pbStack_78 != local_80) {
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "following";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if ((long)pbStack_78 - (long)local_80 == 9) {
                    uVar21 = 6;
                    goto LAB_0054b290;
                  }
                  break;
                }
                pbVar14 = pbVar14 + -1;
              } while (*pcVar17 == *pbVar13);
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "following-sibling";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if ((long)pbStack_78 - (long)local_80 == 0x11) {
                    uVar21 = 7;
                    goto LAB_0054b290;
                  }
                  break;
                }
                    /* try { // try from 0054b0f4 to 0064b1ab has its CatchHandler @ 0054b018 */
                pbVar14 = pbVar14 + -1;
              } while (*pcVar17 == *pbVar13);
            }
            break;
          case 0x6e:
            if (pbStack_78 != local_80) {
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pbVar15 = &LAB_005e1304_1;
              pbVar13 = local_80;
              do {
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                    /* try { // try from 0054b0b8 to 0064b0f3 has its CatchHandler @ 0054b168 */
                  if ((long)pbStack_78 - (long)local_80 == 9) {
                    uVar21 = 8;
                    goto LAB_0054b290;
                  }
                  break;
                }
                bVar3 = *pbVar15;
                pbVar14 = pbVar14 + -1;
                pbVar15 = pbVar15 + 1;
              } while (bVar3 == *pbVar13);
            }
            break;
          case 0x70:
            lVar10 = (long)pbStack_78 - (long)local_80;
            if (pbStack_78 != local_80) {
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "parent";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                    /* try { // try from 0054b1ac to 0064b1af has its CatchHandler @ 0054b1e8 */
                  if (lVar10 == 6) {
                    /* try { // try from 0054b1b0 to 0064b1eb has its CatchHandler @ 0054b018 */
                    uVar21 = 9;
                    goto LAB_0054b290;
                  }
                  break;
                }
                pbVar14 = pbVar14 + -1;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b0f4 with catch @ 0054b018
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b1b0 with catch @ 0054b018
                        */
              } while (*pcVar17 == *pbVar13);
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "preceding";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if (lVar10 == 9) {
                    uVar21 = 10;
                    goto LAB_0054b290;
                  }
                  break;
                }
                pbVar14 = pbVar14 + -1;
              } while (*pcVar17 == *pbVar13);
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pcVar17 = "preceding-sibling";
              pbVar13 = local_80;
              do {
                pcVar17 = pcVar17 + 1;
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if (lVar10 == 0x11) {
                    uVar21 = 0xb;
                    goto LAB_0054b290;
                  }
                  break;
                }
                pbVar14 = pbVar14 + -1;
              } while (*pcVar17 == *pbVar13);
            }
            break;
          case 0x73:
            if (pbStack_78 != local_80) {
              pbVar14 = pbStack_78 + ~(ulong)local_80;
              pbVar15 = (byte *)0x5e12c0;
              pbVar13 = local_80;
              do {
                pbVar13 = pbVar13 + 1;
                if (pbVar14 == (byte *)0x0) {
                  if ((long)pbStack_78 - (long)local_80 == 4) {
                    uVar21 = 0xc;
                    goto LAB_0054b290;
                  }
                  break;
                }
                bVar3 = *pbVar15;
                pbVar14 = pbVar14 + -1;
                pbVar15 = pbVar15 + 1;
              } while (bVar3 == *pbVar13);
            }
          }
switchD_0054aeb4_caseD_62:
                    /* try { // try from 0054b274 to 0064b2a7 has its CatchHandler @ 0054b2e8 */
                    /* WARNING: Subroutine does not return */
          FUN_00548800(param_1,"Unknown axis");
        }
LAB_0054b2c0:
        if (iVar6 == 0xc) {
          FUN_00548530(puVar1);
          if (*(int *)(param_1 + 5) == 0xd) {
            FUN_00548530(puVar1);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b2b0 with catch @ 0054b2e4
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b274 with catch @ 0054b2e8
                        */
            iVar6 = FUN_00549330(&local_80);
                    /* try { // try from 0054b2ec to 0064b2f3 has its CatchHandler @ 0054b2fc */
            if (iVar6 == 0) {
                    /* WARNING: Subroutine does not return */
              FUN_00548800(param_1,"Unrecognized node type");
            }
                    /* try { // try from 0054b2f4 to 0064b2ff has its CatchHandler @ 0054b1ec */
            local_80 = (byte *)0x0;
            pbStack_78 = (byte *)0x0;
          }
          else {
                    /* try { // try from 0054b554 to 0064b55f has its CatchHandler @ 0054b5dc */
            lVar10 = (long)pbStack_78 - (long)local_80;
            if (lVar10 == 0) {
LAB_0054b5dc:
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b554 with catch @ 0054b5dc
                        */
                    /* WARNING: Subroutine does not return */
              FUN_00548800(param_1,"Unmatched brace near node type test");
            }
                    /* try { // try from 0054b560 to 0064b5a7 has its CatchHandler @ 0054b440 */
            pcVar17 = "processing-instruction";
            pbVar14 = local_80;
            lVar16 = lVar10;
            do {
              if (*pcVar17 != *pbVar14) goto LAB_0054b5dc;
              pcVar17 = pcVar17 + 1;
              lVar16 = lVar16 + -1;
              pbVar14 = pbVar14 + 1;
            } while (lVar16 != 0);
            if (lVar10 != 0x16) goto LAB_0054b5dc;
            if (*(int *)(param_1 + 5) != 0xe) {
                    /* WARNING: Subroutine does not return */
                    /* try { // try from 0054b63c to 0064b643 has its CatchHandler @ 0054b64c */
              FUN_00548800(param_1,
                           "Only literals are allowed as arguments to processing-instruction()");
            }
            pbStack_78 = (byte *)param_1[4];
            local_80 = (byte *)param_1[3];
                    /* try { // try from 0054b5a8 to 0064b5af has its CatchHandler @ 0054b5f4 */
            FUN_00548530(puVar1);
                    /* try { // try from 0054b5b0 to 0064b63b has its CatchHandler @ 0054b440 */
            if (*(int *)(param_1 + 5) != 0xd) {
                    /* try { // try from 0054b644 to 0064b64f has its CatchHandler @ 0054b440 */
                    /* WARNING: Subroutine does not return */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b63c with catch @ 0054b64c
                        */
              FUN_00548800(param_1,"Unmatched brace near processing-instruction()");
            }
            FUN_00548530(puVar1);
            iVar6 = 6;
          }
        }
        else {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054b2ec with catch @ 0054b2fc
                        */
          if ((((long)pbStack_78 - (long)local_80 < 3) || (pbStack_78[-2] != 0x3a)) ||
             (pbStack_78[-1] != 0x2a)) {
            iVar6 = 1;
          }
          else {
            iVar6 = 8;
            pbStack_78 = pbStack_78 + -1;
          }
        }
      }
      plVar18 = (long *)*param_1;
      uVar2 = plVar18[1] + 0x28;
      if (*(ulong *)(*plVar18 + 8) < uVar2) {
        plVar7 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
        if (plVar7 == (long *)0x0) goto LAB_0054b5d8;
        *plVar7 = *plVar18;
        plVar7[1] = 0x1000;
        *plVar18 = (long)plVar7;
        plVar18[1] = 0x28;
      }
      else {
        plVar7 = (long *)(*plVar18 + plVar18[1]);
        plVar18[1] = uVar2;
      }
      pbVar14 = local_80;
      plVar18 = plVar7 + 2;
      if (local_80 == (byte *)0x0) {
        plVar8 = (long *)0x0;
      }
      else {
        plVar20 = (long *)*param_1;
        __n = (long)pbStack_78 - (long)local_80;
        uVar19 = __n + 8 & 0xfffffffffffffff8;
        uVar2 = uVar19 + plVar20[1];
        if (*(ulong *)(*plVar20 + 8) < uVar2) {
          uVar2 = uVar19 + 0x400;
          if (uVar2 < 0x1001) {
            uVar2 = 0x1000;
          }
          plVar8 = (long *)(*(code *)PTR_malloc_006f1270)(uVar2 + 0x10);
          if (plVar8 == (long *)0x0) goto LAB_0054b5d8;
          *plVar8 = *plVar20;
          plVar8[1] = uVar2;
          *plVar20 = (long)plVar8;
          plVar20[1] = uVar19;
        }
        else {
          plVar8 = (long *)(*plVar20 + plVar20[1]);
          plVar20[1] = uVar2;
        }
        plVar8 = plVar8 + 2;
        memcpy(plVar8,pbVar14,__n);
        *(undefined1 *)((long)plVar8 + __n) = 0;
      }
      *(char *)((long)plVar7 + 0x13) = (char)iVar6;
      *(undefined1 *)((long)plVar7 + 0x12) = uVar21;
                    /* try { // try from 0054b440 to 0064b527 has its CatchHandler @ 0054b440
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b440 with catch @ 0054b440
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b560 with catch @ 0054b440
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b5b0 with catch @ 0054b440
                       catch(type#1 @ 00000000) { ... } // from try @ 0054b644 with catch @ 0054b440
                        */
      plVar7[3] = param_2;
      plVar7[5] = 0;
      plVar7[6] = (long)plVar8;
      *(undefined2 *)plVar18 = 0x138;
      plVar7[4] = 0;
      if (*(int *)(param_1 + 5) == 0x12) {
        plVar8 = (long *)0x0;
        do {
          FUN_00548530(puVar1);
          uVar9 = FUN_005489d0(param_1);
          lVar10 = FUN_00548854(param_1,uVar9,0);
          plVar20 = (long *)*param_1;
          uVar2 = plVar20[1] + 0x28;
          if (*(ulong *)(*plVar20 + 8) < uVar2) {
            plVar11 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
            if (plVar11 == (long *)0x0) goto LAB_0054b5d8;
            *plVar11 = *plVar20;
            plVar11[1] = 0x1000;
            *plVar20 = (long)plVar11;
            plVar20[1] = 0x28;
          }
          else {
            plVar11 = (long *)(*plVar20 + plVar20[1]);
            plVar20[1] = uVar2;
          }
          plVar20 = plVar11 + 2;
          *(undefined4 *)plVar20 = 0x110;
          plVar11[3] = 0;
          plVar11[4] = lVar10;
          plVar11[5] = 0;
          if (*(int *)(param_1 + 5) != 0x13) {
                    /* WARNING: Subroutine does not return */
            FUN_00548800(param_1,"Unmatched square brace");
          }
          FUN_00548530(puVar1);
          plVar11 = plVar7 + 4;
          if (plVar8 != (long *)0x0) {
            plVar11 = plVar8 + 3;
          }
          *plVar11 = (long)plVar20;
          plVar8 = plVar20;
        } while (*(int *)(param_1 + 5) == 0x12);
      }
      goto LAB_0054b520;
    }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054ad98 with catch @ 0054ada8
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054ace4 with catch @ 0054adac
                        */
    FUN_00548530(puVar1);
    plVar18 = (long *)*param_1;
    uVar2 = plVar18[1] + 0x28;
    if (*(ulong *)(*plVar18 + 8) < uVar2) {
      plVar7 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar7 == (long *)0x0) goto LAB_0054b5d8;
      *plVar7 = *plVar18;
      plVar7[1] = 0x1000;
                    /* catch() { ... } // from try @ 0054ae84 with catch @ 0054adf0 */
      *plVar18 = (long)plVar7;
      plVar18[1] = 0x28;
    }
    else {
      plVar7 = (long *)(*plVar18 + plVar18[1]);
      plVar18[1] = uVar2;
    }
    uVar12 = 0x20c0138;
  }
  plVar18 = plVar7 + 2;
  plVar7[3] = param_2;
  plVar7[4] = 0;
  *(undefined4 *)plVar18 = uVar12;
  plVar7[5] = 0;
  plVar7[6] = 0;
LAB_0054b520:
                    /* try { // try from 0054b528 to 0064b52f has its CatchHandler @ 0054b5f8 */
  if (*(long *)(lVar4 + 0x28) == local_68) {
    return plVar18;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
code_r0x0054b210:
  bVar3 = *pbVar15;
  pbVar14 = pbVar14 + -1;
  pbVar15 = pbVar15 + 1;
  if (bVar3 != *pbVar13) goto switchD_0054aeb4_caseD_62;
  goto LAB_0054b20c;
}



// ===== FUN_0053d77c @ 0053d77c size=276 =====

void FUN_0053d77c(undefined1 *param_1,undefined1 *param_2)

{
  byte *pbVar1;
  ulong uVar2;
  byte bVar3;
  byte bVar4;
  ulong uVar5;
  byte bVar6;
  byte bVar7;
  
  uVar2 = 4;
                    /* try { // try from 0053d788 to 0063d78f has its CatchHandler @ 0053d85c */
  *param_1 = *param_2;
  param_1[1] = param_2[1];
  param_1[2] = param_2[2];
  param_1[3] = param_2[3];
  param_1[4] = param_2[4];
                    /* try { // try from 0053d7b4 to 0063d7bf has its CatchHandler @ 0053d848 */
  param_1[5] = param_2[5];
  param_1[6] = param_2[6];
                    /* try { // try from 0053d7c0 to 0063d813 has its CatchHandler @ 0053d650 */
  param_1[7] = param_2[7];
  param_1[8] = param_2[8];
  param_1[9] = param_2[9];
  param_1[10] = param_2[10];
  param_1[0xb] = param_2[0xb];
  param_1[0xc] = param_2[0xc];
  param_1[0xd] = param_2[0xd];
  param_1[0xe] = param_2[0xe];
  param_1[0xf] = param_2[0xf];
  pbVar1 = param_1 + 0x13;
                    /* try { // try from 0053d814 to 0063d81b has its CatchHandler @ 0053d858 */
  do {
    bVar3 = pbVar1[-7];
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d814 with catch @ 0053d858
                        */
    bVar4 = pbVar1[-6];
    uVar5 = (ulong)bVar4;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d788 with catch @ 0053d85c
                        */
    bVar6 = pbVar1[-5];
    bVar7 = pbVar1[-4];
    if ((uVar2 & 3) == 0) {
      bVar4 = (&DAT_005e081f)[bVar6];
      bVar6 = (&DAT_005e081f)[bVar7];
      bVar7 = (&DAT_005e081f)[bVar3];
      bVar3 = (&UNK_005e091f)[uVar2 >> 2 & 0x3fffffff] ^ (&DAT_005e081f)[uVar5];
    }
                    /* try { // try from 0053d81c to 0063d8ab has its CatchHandler @ 0053d650 */
    uVar2 = uVar2 + 1;
    pbVar1[-3] = pbVar1[-0x13] ^ bVar3;
    pbVar1[-2] = pbVar1[-0x12] ^ bVar4;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d7b4 with catch @ 0053d848
                        */
    pbVar1[-1] = pbVar1[-0x11] ^ bVar6;
    *pbVar1 = pbVar1[-0x10] ^ bVar7;
    pbVar1 = pbVar1 + 4;
  } while (uVar2 != 0x2c);
  return;
}



// ===== FUN_00548d48 @ 00548d48 size=520 =====

undefined1  [16] FUN_00548d48(long param_1)

{
  long lVar1;
  undefined8 uVar2;
  ulong uVar3;
  ulong uVar4;
  char *pcVar5;
  char *pcVar6;
  char *pcVar7;
  long lVar8;
  undefined1 auVar9 [16];
  undefined1 auVar10 [16];
  undefined1 auVar11 [16];
  undefined1 auVar12 [16];
  undefined1 auVar13 [16];
  undefined1 auVar14 [16];
  undefined1 auVar15 [16];
  
  uVar3 = 0x400000000;
  uVar2 = 3;
  uVar4 = 3;
  switch(*(undefined4 *)(param_1 + 0x20)) {
  case 2:
    auVar9._8_8_ = 3;
    auVar9._0_8_ = 0x400000004;
    return auVar9;
  case 3:
    uVar3 = 5;
    break;
  case 4:
    uVar3 = 6;
    break;
  case 5:
    uVar3 = 7;
    break;
  case 6:
    uVar3 = 8;
    break;
  case 7:
    uVar3 = 9;
    goto LAB_00548ddc;
  case 8:
    uVar3 = 10;
LAB_00548ddc:
    auVar11._0_8_ = uVar3 | 0x200000000;
    auVar11._8_8_ = 5;
    return auVar11;
  case 9:
    uVar3 = 0xb;
    goto LAB_00548df0;
  case 10:
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00548d24 with catch @ 00548dfc
                        */
    uVar3 = 0x100000000;
                    /* try { // try from 00548e00 to 00648e07 has its CatchHandler @ 00548e10 */
    uVar4 = 0xf;
    uVar2 = 7;
  case 1:
                    /* try { // try from 00548e08 to 00648e13 has its CatchHandler @ 00548c7c */
    auVar13._0_8_ = uVar4 | uVar3;
    auVar13._8_8_ = uVar2;
    return auVar13;
  default:
    goto switchD_00548d78_caseD_b;
  case 0x14:
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00548e00 with catch @ 00548e10
                        */
    pcVar5 = *(char **)(param_1 + 0x10);
                    /* try { // try from 00548e14 to 0064902f has its CatchHandler @ 00548e14
                       catch(type#1 @ 00000000) { ... } // from try @ 00548e14 with catch @ 00548e14
                        */
    lVar1 = *(long *)(param_1 + 0x18) - (long)pcVar5;
    if (lVar1 != 0) {
      pcVar6 = "or";
      pcVar7 = pcVar5;
      lVar8 = lVar1;
      do {
        if (*pcVar6 != *pcVar7) goto LAB_00548e68;
        pcVar6 = pcVar6 + 1;
        lVar8 = lVar8 + -1;
        pcVar7 = pcVar7 + 1;
      } while (lVar8 != 0);
      if (lVar1 == 2) {
        auVar14._8_8_ = 1;
        auVar14._0_8_ = 0x400000001;
        return auVar14;
      }
LAB_00548e68:
      if (lVar1 != 0) {
        pcVar6 = "and";
        pcVar7 = pcVar5;
        lVar8 = lVar1;
        do {
          if (*pcVar6 != *pcVar7) goto LAB_00548eb8;
          pcVar6 = pcVar6 + 1;
          lVar8 = lVar8 + -1;
          pcVar7 = pcVar7 + 1;
        } while (lVar8 != 0);
        if (lVar1 == 3) {
          auVar15._8_8_ = 2;
          auVar15._0_8_ = 0x400000002;
          return auVar15;
        }
LAB_00548eb8:
        if (lVar1 != 0) {
          pcVar6 = "div";
          pcVar7 = pcVar5;
          lVar8 = lVar1;
          do {
            if (*pcVar6 != *pcVar7) goto LAB_00548f00;
            pcVar6 = pcVar6 + 1;
            lVar8 = lVar8 + -1;
            pcVar7 = pcVar7 + 1;
          } while (lVar8 != 0);
          if (lVar1 == 3) {
            uVar3 = 0xc;
LAB_00548df0:
            auVar12._0_8_ = uVar3 | 0x200000000;
            auVar12._8_8_ = 6;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00548dbc with catch @ 00548df8
                        */
            return auVar12;
          }
LAB_00548f00:
          if (lVar1 != 0) {
            pcVar6 = "mod";
            lVar8 = lVar1;
            do {
              if (*pcVar6 != *pcVar5) goto switchD_00548d78_caseD_b;
              pcVar6 = pcVar6 + 1;
              lVar8 = lVar8 + -1;
              pcVar5 = pcVar5 + 1;
            } while (lVar8 != 0);
            if (lVar1 == 3) {
              uVar3 = 0xd;
              goto LAB_00548df0;
            }
          }
        }
      }
    }
    goto switchD_00548d78_caseD_b;
  }
                    /* try { // try from 00548dbc to 00648dc3 has its CatchHandler @ 00548df8 */
  auVar10._0_8_ = uVar3 | 0x400000000;
  auVar10._8_8_ = 4;
                    /* try { // try from 00548dc4 to 00648dff has its CatchHandler @ 00548c7c */
  return auVar10;
switchD_00548d78_caseD_b:
  return ZEXT816(0);
}



// ===== FUN_0054c7ec @ 0054c7ec size=4812 =====

/* WARNING: Removing unreachable block (ram,0x0054d6b4) */
/* WARNING: Removing unreachable block (ram,0x0054d144) */

void FUN_0054c7ec(long *param_1,undefined1 *param_2,long *param_3,long *param_4)

{
  ulong uVar1;
  uint uVar2;
  char cVar3;
  char cVar4;
  long lVar5;
  long *plVar6;
  uint uVar7;
  size_t sVar8;
  undefined1 *puVar9;
  ulong uVar10;
  char *pcVar11;
  char **ppcVar12;
  long lVar13;
  long *plVar14;
  bad_alloc *pbVar15;
  undefined1 uVar16;
  undefined1 *puVar17;
  char **ppcVar18;
  byte *pbVar19;
  byte *pbVar20;
  long *plVar21;
  char **ppcVar22;
  long *plVar23;
  byte *pbVar24;
  byte *pbVar25;
  ulong uVar26;
  long lVar27;
  char **ppcVar28;
  uint uVar29;
  long *plVar30;
  long lVar31;
  byte bVar32;
  char **ppcVar33;
  char *pcVar34;
  double dVar35;
  double dVar36;
  long *local_110;
  char *pcStack_108;
  char *local_100;
  long *local_f0;
  long local_e8;
  char *local_e0;
  long *plStack_d8;
  long *local_d0;
  undefined1 *puStack_c8;
  undefined1 local_c0;
  undefined8 local_b8;
  undefined1 *puStack_b0;
  undefined1 local_a8;
  undefined8 local_a0;
  undefined1 *puStack_98;
  undefined1 local_90;
  undefined8 local_88;
  long local_78;
  
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054c7e4 with catch @ 0054c7ec
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054c7cc with catch @ 0054c7f0
                        */
                    /* catch() { ... } // from try @ 0054c8d8 with catch @ 0054c804
                       catch() { ... } // from try @ 0054c97c with catch @ 0054c804 */
  lVar5 = tpidr_el0;
  local_78 = *(long *)(lVar5 + 0x28);
  pcVar34 = "";
  switch(*param_2) {
  case 0x12:
    lVar13 = *(long *)(param_2 + 0x20);
    *(undefined1 *)(param_1 + 1) = 0;
    param_1[2] = 0;
    *param_1 = lVar13;
    break;
  default:
    cVar4 = param_2[1];
LAB_0054cea0:
    if (cVar4 != '\x01') {
      if (cVar4 == '\x02') {
                    /* try { // try from 0054cf44 to 0064cfe7 has its CatchHandler @ 0054d060 */
        pcVar34 = (char *)FUN_00542e60(param_2,param_3,param_4);
        param_4 = (long *)*param_4;
        local_e0 = pcVar34;
        if ((double)pcVar34 == 0.0) {
          *param_1 = (long)&DAT_005e4693;
        }
        else {
          if ((double)pcVar34 + (double)pcVar34 != (double)pcVar34) {
            FUN_00545d88(pcVar34,&local_e0,0x20,&DAT_005e1348,0xf);
            ppcVar12 = (char **)__strchr_chk(&local_e0,0x65,0x20);
            uVar7 = atoi((char *)((long)ppcVar12 + 1));
            uVar29 = uVar7 + 1;
            ppcVar33 = (char **)((ulong)&local_e0 | 1);
            if ((char)local_e0 != '-') {
              ppcVar33 = &local_e0;
            }
                    /* try { // try from 0054d8d8 to 0064d8df has its CatchHandler @ 0054d914 */
            ppcVar28 = (char **)((long)ppcVar33 + 1);
            *(char *)ppcVar28 = *(char *)((ulong)&local_e0 | (ulong)((char)local_e0 == '-'));
            do {
              ppcVar22 = (char **)((long)ppcVar12 + -1);
                    /* try { // try from 0054d8e0 to 0064d91b has its CatchHandler @ 0054d798 */
              ppcVar18 = ppcVar28;
              if (ppcVar33 == ppcVar22) break;
              ppcVar18 = ppcVar12;
              ppcVar12 = ppcVar22;
            } while (*(char *)ppcVar22 == '0');
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054d8d8 with catch @ 0054d914
                        */
            *(char *)ppcVar18 = '\0';
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054d840 with catch @ 0054d918
                        */
            lVar13 = __strlen_chk(&local_e0,0x20);
                    /* try { // try from 0054d91c to 0064d923 has its CatchHandler @ 0054d92c */
            uVar2 = uVar29;
                    /* try { // try from 0054d924 to 0064d92f has its CatchHandler @ 0054d798 */
            if ((int)uVar29 < 0) {
              uVar2 = ~uVar7;
            }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054d91c with catch @ 0054d92c
                        */
                    /* try { // try from 0054d930 to 0064db63 has its CatchHandler @ 0054d930
                       catch(type#1 @ 00000000) { ... } // from try @ 0054d930 with catch @ 0054d930
                        */
            uVar26 = (ulong)uVar2 + lVar13 + 0xb & 0xfffffffffffffff8;
            uVar10 = uVar26 + param_4[1];
            if (*(ulong *)(*param_4 + 8) < uVar10) {
              uVar10 = uVar26 + 0x400;
              if (uVar10 < 0x1001) {
                uVar10 = 0x1000;
              }
              plVar14 = (long *)(*(code *)PTR_malloc_006f1270)(uVar10 + 0x10);
              if (plVar14 == (long *)0x0) {
                pbVar15 = (bad_alloc *)__cxa_allocate_exception(8);
                std::bad_alloc::bad_alloc(pbVar15);
                    /* WARNING: Subroutine does not return */
                __cxa_throw(pbVar15,PTR_typeinfo_006ef978,PTR__bad_alloc_006effb8);
              }
              *plVar14 = *param_4;
              plVar14[1] = uVar10;
              *param_4 = (long)plVar14;
              param_4[1] = uVar26;
            }
            else {
              plVar14 = (long *)(*param_4 + param_4[1]);
              param_4[1] = uVar10;
            }
            plVar21 = plVar14 + 2;
            plVar30 = plVar21;
            if ((double)pcVar34 < 0.0) {
              plVar30 = (long *)((long)plVar14 + 0x11);
              *(undefined1 *)plVar21 = 0x2d;
            }
            if ((int)uVar7 < 0) {
              plVar14 = (long *)((long)plVar30 + 1);
              *(undefined1 *)plVar30 = 0x30;
            }
            else {
              do {
                cVar3 = *(char *)ppcVar28;
                uVar29 = uVar29 - 1;
                cVar4 = '0';
                if (cVar3 != '\0') {
                  ppcVar28 = (char **)((long)ppcVar28 + 1);
                  cVar4 = cVar3;
                }
                plVar14 = (long *)((long)plVar30 + 1);
                *(char *)plVar30 = cVar4;
                plVar30 = plVar14;
              } while (0 < (int)uVar29);
            }
            if (*(char *)ppcVar28 != '\0') {
              plVar30 = (long *)((long)plVar14 + 1);
              *(undefined1 *)plVar14 = 0x2e;
              if ((int)uVar29 < 0) {
                memset(plVar30,0x30,(ulong)~uVar29 + 1);
                plVar30 = (long *)((long)plVar14 + (ulong)~uVar29 + 2);
              }
              cVar4 = *(char *)ppcVar28;
              plVar14 = plVar30;
              while (cVar4 != '\0') {
                ppcVar28 = (char **)((long)ppcVar28 + 1);
                *(char *)plVar14 = cVar4;
                plVar14 = (long *)((long)plVar14 + 1);
                cVar4 = *(char *)ppcVar28;
              }
            }
            *(undefined1 *)plVar14 = 0;
            *param_1 = (long)plVar21;
            *(undefined1 *)(param_1 + 1) = 1;
            param_1[2] = (long)plVar14 - (long)plVar21;
            break;
          }
          pcVar11 = "Infinity";
          if ((double)pcVar34 <= 0.0) {
            pcVar11 = "-Infinity";
          }
          *param_1 = (long)pcVar11;
        }
      }
      else {
        if (cVar4 == '\x04') {
          uVar10 = FUN_00540998(param_2,param_3,param_4);
          pcVar34 = "true";
          if ((uVar10 & 1) == 0) {
            pcVar34 = "false";
          }
          goto LAB_0054d3f0;
        }
        *param_1 = (long)&DAT_005d4b75;
      }
      goto LAB_0054cfd4;
    }
    pcStack_108 = (char *)*param_4;
    plVar14 = (long *)param_4[1];
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
    local_110 = plVar14;
    FUN_0054389c(&local_e0,param_2,param_3,&local_110,2);
    plVar30 = local_d0;
    if (plStack_d8 == local_d0) {
      *param_1 = (long)&DAT_005d4b75;
      *(undefined1 *)(param_1 + 1) = 0;
      param_1[2] = 0;
    }
    else {
      plVar6 = plStack_d8;
      plVar21 = plStack_d8;
      if ((int)local_e0 == 0) {
        while (plVar23 = plVar6, plVar21 = plVar21 + 2, plVar21 != plVar30) {
          uVar10 = FUN_00548274(plVar21,plVar23);
          plVar6 = plVar21;
          if ((uVar10 & 1) == 0) {
            plVar6 = plVar23;
          }
        }
LAB_0054d788:
        plVar30 = plVar23 + 1;
LAB_0054d78c:
        local_f0 = (long *)*plVar23;
        local_e8 = *plVar30;
      }
      else {
        if ((int)local_e0 == 2) {
          plVar23 = local_d0 + -2;
          plVar30 = local_d0 + -1;
          goto LAB_0054d78c;
        }
        plVar23 = plStack_d8;
        if ((int)local_e0 == 1) goto LAB_0054d788;
        local_f0 = (long *)0x0;
        local_e8 = 0;
      }
                    /* try { // try from 0054d798 to 0064d83f has its CatchHandler @ 0054d798
                       catch(type#1 @ 00000000) { ... } // from try @ 0054d798 with catch @ 0054d798
                       catch(type#1 @ 00000000) { ... } // from try @ 0054d8e0 with catch @ 0054d798
                       catch(type#1 @ 00000000) { ... } // from try @ 0054d924 with catch @ 0054d798
                        */
      FUN_0054dd4c(param_1,&local_f0,*param_4);
    }
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
    goto LAB_0054d7d0;
  case 0x14:
    cVar4 = param_2[1];
    if (cVar4 != '\x03') goto LAB_0054cea0;
    if (**(int **)(param_2 + 0x20) == 3) {
      pcVar11 = *(char **)(*(int **)(param_2 + 0x20) + 4);
    }
    else {
      pcVar11 = (char *)0x0;
    }
    if (pcVar11 != (char *)0x0) {
      pcVar34 = pcVar11;
    }
    goto LAB_0054d3f0;
  case 0x19:
    if (param_3[1] == 0) {
      pcVar34 = "";
      if ((*param_3 != 0) && (pcVar11 = *(char **)(*param_3 + 0x10), pcVar11 != (char *)0x0)) {
        pcVar34 = pcVar11;
      }
    }
    else {
      pcVar11 = *(char **)(param_3[1] + 8);
      if (pcVar11 != (char *)0x0) {
        pcVar34 = pcVar11;
      }
    }
    pcVar11 = strchr(pcVar34,0x3a);
    if (pcVar11 != (char *)0x0) {
      pcVar34 = pcVar11 + 1;
    }
LAB_0054d3f0:
    *(undefined1 *)(param_1 + 1) = 0;
    *param_1 = (long)pcVar34;
    param_1[2] = 0;
    break;
  case 0x1a:
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054cb28 with catch @ 0054cb34
                        */
    plVar14 = (long *)*param_4;
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054cad4 with catch @ 0054cb48
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054cabc with catch @ 0054cb4c
                        */
    FUN_0054389c(&local_e0,*(undefined8 *)(param_2 + 8),param_3,param_4,2);
    plVar30 = local_d0;
                    /* try { // try from 0054cb5c to 0064cb67 has its CatchHandler @ 0054cb6c */
    if (plStack_d8 == local_d0) {
      pcVar34 = "";
    }
    else {
                    /* try { // try from 0054cb68 to 0064cbb3 has its CatchHandler @ 0054c9c8 */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054cb5c with catch @ 0054cb6c
                        */
      plVar6 = plStack_d8;
      plVar21 = plStack_d8;
      if ((int)local_e0 == 0) {
        while (plVar23 = plVar6, plVar21 = plVar21 + 2, plVar21 != plVar30) {
          uVar10 = FUN_00548274(plVar21,plVar23);
          plVar6 = plVar21;
          if ((uVar10 & 1) == 0) {
            plVar6 = plVar23;
          }
        }
LAB_0054d554:
        lVar27 = plVar23[1];
        if (lVar27 != 0) goto LAB_0054d560;
LAB_0054d49c:
        pcVar34 = "";
        if (*plVar23 == 0) goto LAB_0054d56c;
        pcVar11 = *(char **)(*plVar23 + 0x10);
      }
      else {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054caa8 with catch @ 0054cb70
                        */
        if ((int)local_e0 != 2) {
          pcVar34 = "";
          plVar23 = plStack_d8;
          if ((int)local_e0 != 1) goto LAB_0054d56c;
          goto LAB_0054d554;
        }
        plVar23 = local_d0 + -2;
        lVar27 = local_d0[-1];
        if (lVar27 == 0) goto LAB_0054d49c;
LAB_0054d560:
        pcVar11 = *(char **)(lVar27 + 8);
      }
      pcVar34 = "";
      if (pcVar11 != (char *)0x0) {
        pcVar34 = pcVar11;
      }
    }
LAB_0054d56c:
    pcVar11 = strchr(pcVar34,0x3a);
    if (pcVar11 != (char *)0x0) {
      pcVar34 = pcVar11 + 1;
    }
    *(undefined1 *)(param_1 + 1) = 0;
    *param_1 = (long)pcVar34;
    param_1[2] = 0;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
    goto LAB_0054d7d0;
  case 0x1b:
    plStack_d8 = (long *)param_3[1];
    local_e0 = (char *)*param_3;
    lVar13 = FUN_0054e0c0(&local_e0);
    *param_1 = lVar13;
    goto LAB_0054cfd4;
  case 0x1c:
    plVar14 = (long *)*param_4;
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
    FUN_0054389c(&local_e0,*(undefined8 *)(param_2 + 8),param_3,param_4,2);
    plVar30 = local_d0;
    local_110 = (long *)0x0;
    pcStack_108 = (char *)0x0;
                    /* try { // try from 0054caa8 to 0064cab3 has its CatchHandler @ 0054cb70 */
    if (plStack_d8 != local_d0) {
      plVar6 = plStack_d8;
      plVar21 = plStack_d8;
      if ((int)local_e0 == 0) {
        while (plVar23 = plVar6, plVar21 = plVar21 + 2, plVar21 != plVar30) {
          uVar10 = FUN_00548274(plVar21,plVar23);
          plVar6 = plVar21;
          if ((uVar10 & 1) == 0) {
            plVar6 = plVar23;
          }
        }
LAB_0054d4e0:
        pcStack_108 = (char *)plVar23[1];
        local_110 = (long *)*plVar23;
      }
      else {
                    /* try { // try from 0054cabc to 0064cac7 has its CatchHandler @ 0054cb4c */
        if ((int)local_e0 == 2) {
          pcStack_108 = (char *)local_d0[-1];
          local_110 = (long *)local_d0[-2];
        }
        else {
          plVar23 = plStack_d8;
          if ((int)local_e0 == 1) goto LAB_0054d4e0;
        }
      }
    }
    lVar27 = FUN_0054e0c0(&local_110);
    *param_1 = lVar27;
    *(undefined1 *)(param_1 + 1) = 0;
    param_1[2] = 0;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
    goto LAB_0054d7d0;
  case 0x1d:
    if (param_3[1] == 0) {
      puVar9 = &DAT_005d4b75;
      if ((*param_3 != 0) &&
         (puVar17 = *(undefined1 **)(*param_3 + 0x10), puVar17 != (undefined1 *)0x0)) {
        puVar9 = puVar17;
      }
      *param_1 = (long)puVar9;
    }
    else {
      pcVar11 = *(char **)(param_3[1] + 8);
      if (pcVar11 != (char *)0x0) {
        pcVar34 = pcVar11;
      }
      *param_1 = (long)pcVar34;
                    /* catch() { ... } // from try @ 0054ccb4 with catch @ 0054cbb4
                       catch() { ... } // from try @ 0054cd1c with catch @ 0054cbb4 */
    }
LAB_0054cfd4:
    *(undefined1 *)(param_1 + 1) = 0;
    param_1[2] = 0;
    break;
  case 0x1e:
    plVar14 = (long *)*param_4;
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
    FUN_0054389c(&local_e0,*(undefined8 *)(param_2 + 8),param_3,param_4,2);
    plVar30 = local_d0;
    if (plStack_d8 == local_d0) {
      puVar9 = &DAT_005d4b75;
    }
    else {
      plVar6 = plStack_d8;
      plVar21 = plStack_d8;
      if ((int)local_e0 == 0) {
        while (plVar23 = plVar6, plVar21 = plVar21 + 2, plVar21 != plVar30) {
          uVar10 = FUN_00548274(plVar21,plVar23);
          plVar6 = plVar21;
          if ((uVar10 & 1) == 0) {
            plVar6 = plVar23;
          }
        }
LAB_0054d60c:
        lVar27 = plVar23[1];
        if (lVar27 != 0) goto LAB_0054d618;
LAB_0054d5c8:
        puVar9 = &DAT_005d4b75;
        if (*plVar23 == 0) goto LAB_0054d624;
        puVar17 = *(undefined1 **)(*plVar23 + 0x10);
      }
      else {
        if ((int)local_e0 != 2) {
          plVar23 = plStack_d8;
          puVar9 = &DAT_005d4b75;
          if ((int)local_e0 != 1) goto LAB_0054d624;
          goto LAB_0054d60c;
        }
        plVar23 = local_d0 + -2;
        lVar27 = local_d0[-1];
        if (lVar27 == 0) goto LAB_0054d5c8;
LAB_0054d618:
        puVar17 = *(undefined1 **)(lVar27 + 8);
      }
      puVar9 = &DAT_005d4b75;
      if (puVar17 != (undefined1 *)0x0) {
        puVar9 = puVar17;
      }
    }
LAB_0054d624:
    *param_1 = (long)puVar9;
    *(undefined1 *)(param_1 + 1) = 0;
    param_1[2] = 0;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
    goto LAB_0054d7d0;
  case 0x1f:
    FUN_0054dd4c(param_1,param_3,*param_4);
                    /* try { // try from 0054cd14 to 0064cd1b has its CatchHandler @ 0054cd24 */
    break;
  case 0x20:
    FUN_0054c7ec(param_1,*(undefined8 *)(param_2 + 8),param_3,param_4);
    break;
  case 0x21:
    plVar14 = (long *)param_4[1];
    uVar10 = 1;
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
    for (lVar27 = *(long *)(param_2 + 0x10); lVar27 != 0; lVar27 = *(long *)(lVar27 + 0x18)) {
      uVar10 = uVar10 + 1;
    }
    local_e0 = "";
                    /* try { // try from 0054c96c to 0064c97b has its CatchHandler @ 0054c984 */
    plStack_d8 = (long *)((ulong)plStack_d8 & 0xffffffffffffff00);
    local_d0 = (long *)0x0;
    puStack_c8 = &DAT_005d4b75;
    local_c0 = 0;
    local_b8 = 0;
    puStack_b0 = &DAT_005d4b75;
                    /* try { // try from 0054c97c to 0064c9c7 has its CatchHandler @ 0054c804 */
    local_a8 = 0;
    local_a0 = 0;
    puStack_98 = &DAT_005d4b75;
                    /* catch() { ... } // from try @ 0054c8d0 with catch @ 0054c984
                       catch() { ... } // from try @ 0054c96c with catch @ 0054c984 */
    local_90 = 0;
    local_88 = 0;
    local_f0 = plVar14;
    if (uVar10 < 5) {
      ppcVar33 = &local_e0;
    }
    else {
      lVar27 = uVar10 * 0x18;
      if (*(ulong *)(lVar13 + 8) < (ulong)(lVar31 + lVar27)) {
        uVar26 = lVar27 + 0x400;
        if (uVar26 < 0x1001) {
          uVar26 = 0x1000;
        }
        plVar30 = (long *)(*(code *)PTR_malloc_006f1270)(uVar26 + 0x10);
                    /* try { // try from 0054c9c8 to 0064caa7 has its CatchHandler @ 0054c9c8
                       catch(type#1 @ 00000000) { ... } // from try @ 0054c9c8 with catch @ 0054c9c8
                       catch(type#1 @ 00000000) { ... } // from try @ 0054cadc with catch @ 0054c9c8
                       catch(type#1 @ 00000000) { ... } // from try @ 0054cb30 with catch @ 0054c9c8
                       catch(type#1 @ 00000000) { ... } // from try @ 0054cb68 with catch @ 0054c9c8
                        */
        if (plVar30 == (long *)0x0) {
          pbVar15 = (bad_alloc *)__cxa_allocate_exception(8);
          std::bad_alloc::bad_alloc(pbVar15);
                    /* WARNING: Subroutine does not return */
          __cxa_throw(pbVar15,PTR_typeinfo_006ef978,PTR__bad_alloc_006effb8);
        }
        *plVar30 = *plVar14;
        plVar30[1] = uVar26;
        *plVar14 = (long)plVar30;
        plVar14[1] = lVar27;
        ppcVar33 = (char **)(plVar30 + 2);
        local_f0 = (long *)param_4[1];
      }
      else {
        ppcVar33 = (char **)(lVar13 + lVar31 + 0x10);
        plVar14[1] = lVar31 + lVar27;
      }
    }
    local_e8 = *param_4;
                    /* catch() { ... } // from try @ 0054d17c with catch @ 0054d24c */
    FUN_0054c7ec(&local_110,*(undefined8 *)(param_2 + 8),param_3,&local_f0);
    ppcVar33[2] = local_100;
    ppcVar33[1] = pcStack_108;
    *ppcVar33 = (char *)local_110;
    ppcVar12 = ppcVar33;
    for (lVar27 = *(long *)(param_2 + 0x10); lVar27 != 0; lVar27 = *(long *)(lVar27 + 0x18)) {
      FUN_0054c7ec(&local_110,lVar27,param_3,&local_f0);
      ppcVar12[5] = local_100;
      ppcVar12[4] = pcStack_108;
      ppcVar12[3] = (char *)local_110;
      ppcVar12 = ppcVar12 + 3;
    }
                    /* catch() { ... } // from try @ 0054d138 with catch @ 0054d2a0 */
    if (uVar10 != 0) {
      pcVar34 = (char *)0x0;
      ppcVar12 = ppcVar33 + 1;
      uVar26 = uVar10;
      if (*(char *)ppcVar12 != '\0') goto LAB_0054d2d8;
      do {
        pcVar11 = (char *)strlen(ppcVar12[-1]);
        while( true ) {
          pcVar34 = pcVar11 + (long)pcVar34;
          uVar26 = uVar26 - 1;
          ppcVar12 = ppcVar12 + 3;
          if (uVar26 == 0) {
            uVar26 = (ulong)(pcVar34 + 8) & 0xfffffffffffffff8;
            goto LAB_0054d2f0;
          }
          if (*(char *)ppcVar12 == '\0') break;
LAB_0054d2d8:
          pcVar11 = ppcVar12[1];
        }
      } while( true );
    }
    uVar26 = 8;
LAB_0054d2f0:
    param_4 = (long *)*param_4;
    uVar1 = param_4[1] + uVar26;
    if (*(ulong *)(*param_4 + 8) < uVar1) {
      uVar1 = uVar26 + 0x400;
      if (uVar1 < 0x1001) {
        uVar1 = 0x1000;
      }
      plVar30 = (long *)(*(code *)PTR_malloc_006f1270)(uVar1 + 0x10);
      if (plVar30 == (long *)0x0) {
        pbVar15 = (bad_alloc *)__cxa_allocate_exception(8);
        std::bad_alloc::bad_alloc(pbVar15);
                    /* WARNING: Subroutine does not return */
        __cxa_throw(pbVar15,PTR_typeinfo_006ef978,PTR__bad_alloc_006effb8);
      }
      *plVar30 = *param_4;
      plVar30[1] = uVar1;
      *param_4 = (long)plVar30;
      param_4[1] = uVar26;
      plVar30 = plVar30 + 2;
    }
    else {
      plVar30 = (long *)(*param_4 + param_4[1] + 0x10);
      param_4[1] = uVar1;
    }
    plVar21 = plVar30;
    if (uVar10 != 0) {
      uVar26 = 0;
      do {
        pcVar34 = ppcVar33[uVar26 * 3];
        cVar4 = *pcVar34;
        while (cVar4 != '\0') {
          pcVar34 = pcVar34 + 1;
          *(char *)plVar21 = cVar4;
          plVar21 = (long *)((long)plVar21 + 1);
          cVar4 = *pcVar34;
        }
        uVar26 = uVar26 + 1;
      } while (uVar26 != uVar10);
    }
    *(undefined1 *)plVar21 = 0;
    *param_1 = (long)plVar30;
    *(undefined1 *)(param_1 + 1) = 1;
    param_1[2] = (long)plVar21 - (long)plVar30;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
    *plVar14 = lVar13;
    plVar14[1] = lVar31;
    break;
  case 0x24:
    local_e8 = *param_4;
    plVar14 = (long *)param_4[1];
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
                    /* try { // try from 0054cad4 to 0064cadb has its CatchHandler @ 0054cb48 */
                    /* try { // try from 0054cadc to 0064cb27 has its CatchHandler @ 0054c9c8 */
    local_f0 = plVar14;
    FUN_0054c7ec(&local_e0,*(undefined8 *)(param_2 + 8),param_3,&local_f0);
    FUN_0054c7ec(&local_110,*(undefined8 *)(param_2 + 0x10),param_3,&local_f0);
    pcVar34 = local_e0;
    pcVar11 = strstr(local_e0,(char *)local_110);
    if (pcVar11 == (char *)0x0) {
      lVar27 = 0;
LAB_0054d448:
      uVar16 = 0;
      puVar9 = &DAT_005d4b75;
    }
    else {
      lVar27 = (long)pcVar11 - (long)pcVar34;
      if (lVar27 == 0) goto LAB_0054d448;
                    /* try { // try from 0054cb28 to 0064cb2f has its CatchHandler @ 0054cb34 */
      puVar9 = (undefined1 *)FUN_0054e2f4(pcVar34,lVar27,*param_4);
      uVar16 = 1;
                    /* try { // try from 0054cb30 to 0064cb5b has its CatchHandler @ 0054c9c8 */
    }
    *param_1 = (long)puVar9;
    *(undefined1 *)(param_1 + 1) = uVar16;
    param_1[2] = lVar27;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
    goto LAB_0054d7d0;
  case 0x25:
    local_e8 = *param_4;
    plVar14 = (long *)param_4[1];
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
    local_f0 = plVar14;
    FUN_0054c7ec(&local_e0,*(undefined8 *)(param_2 + 8),param_3,&local_f0);
    FUN_0054c7ec(&local_110,*(undefined8 *)(param_2 + 0x10),param_3,&local_f0);
    pcVar11 = local_e0;
    plVar30 = local_110;
    pcVar34 = strstr(local_e0,(char *)local_110);
    if (pcVar34 == (char *)0x0) {
                    /* try { // try from 0054d190 to 0064d2e7 has its CatchHandler @ 0054d0e4 */
      lVar27 = 0;
LAB_0054d664:
      uVar16 = 0;
      pcVar34 = "";
    }
    else {
      if ((char)pcStack_108 == '\0') {
        local_100 = (char *)strlen((char *)plVar30);
      }
      pcVar34 = pcVar34 + (long)local_100;
      if ((char)plStack_d8 == '\0') {
        lVar27 = 0;
        uVar16 = 0;
      }
      else {
        lVar27 = (long)(pcVar11 + (long)local_d0) - (long)pcVar34;
        if (lVar27 == 0) goto LAB_0054d664;
        pcVar34 = (char *)FUN_0054e2f4(pcVar34,lVar27,*param_4);
        uVar16 = 1;
      }
    }
    *param_1 = (long)pcVar34;
    *(undefined1 *)(param_1 + 1) = uVar16;
    param_1[2] = lVar27;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
    goto LAB_0054d69c;
  case 0x26:
    pcStack_108 = (char *)*param_4;
    plVar14 = (long *)param_4[1];
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
    local_110 = plVar14;
    FUN_0054c7ec(&local_e0,*(undefined8 *)(param_2 + 8),param_3,&local_110);
    plVar30 = local_d0;
    if ((char)plStack_d8 == '\0') {
      plVar30 = (long *)strlen(local_e0);
                    /* try { // try from 0054cfe8 to 0064d0a3 has its CatchHandler @ 0054ce7c */
    }
    dVar35 = (double)FUN_00542e60(*(undefined8 *)(param_2 + 0x10),param_3,param_4);
    local_f0 = (long *)(long)(dVar35 + 0.5);
    if ((double)((long)plVar30 + 1) <= (double)local_f0) {
      lVar27 = 0;
LAB_0054d07c:
      uVar16 = 0;
      pcVar34 = "";
    }
    else {
      plVar30 = local_f0;
      if ((double)local_f0 <= 1.0) {
        plVar30 = (long *)0x3ff0000000000000;
      }
      pcVar34 = local_e0 + (long)(double)plVar30 + -1;
      if ((char)plStack_d8 == '\0') {
        uVar16 = 0;
        lVar27 = 0;
      }
      else {
        lVar27 = (long)(local_e0 + (long)local_d0) - (long)pcVar34;
        if (lVar27 == 0) goto LAB_0054d07c;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054cf44 with catch @ 0054d060
                        */
        pcVar34 = (char *)FUN_0054e2f4(pcVar34,lVar27,*param_4);
        uVar16 = 1;
      }
    }
    *param_1 = (long)pcVar34;
    *(undefined1 *)(param_1 + 1) = uVar16;
    param_1[2] = lVar27;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
                    /* try { // try from 0054d0a4 to 0064d0a7 has its CatchHandler @ 0054d0e0 */
      (*(code *)PTR_free_006f1268)();
                    /* try { // try from 0054d0a8 to 0064d0e3 has its CatchHandler @ 0054ce7c */
    }
    goto LAB_0054d69c;
  case 0x27:
    pcStack_108 = (char *)*param_4;
    plVar14 = (long *)param_4[1];
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
    local_110 = plVar14;
    FUN_0054c7ec(&local_e0,*(undefined8 *)(param_2 + 8),param_3,&local_110);
    plVar30 = local_d0;
    if ((char)plStack_d8 == '\0') {
      plVar30 = (long *)strlen(local_e0);
    }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054d0a4 with catch @ 0054d0e0
                        */
                    /* catch() { ... } // from try @ 0054d190 with catch @ 0054d0e4 */
    dVar35 = (double)FUN_00542e60(*(undefined8 *)(param_2 + 0x10),param_3,param_4);
    dVar36 = (double)FUN_00542e60(*(undefined8 *)(*(long *)(param_2 + 0x10) + 0x18),param_3,param_4)
    ;
    dVar35 = (double)(long)(dVar35 + 0.5);
    local_f0 = (long *)(dVar35 + (double)(long)(dVar36 + 0.5));
    pcVar34 = (char *)0x0;
    pcVar11 = "";
    uVar16 = 0;
                    /* try { // try from 0054d138 to 0064d13f has its CatchHandler @ 0054d2a0 */
    if (dVar35 < (double)local_f0) {
      uVar10 = (long)plVar30 + 1;
      uVar16 = 0;
      if ((dVar35 < (double)uVar10) && (pcVar11 = "", 1.0 <= (double)local_f0)) {
        if (dVar35 <= 1.0) {
          dVar35 = 1.0;
        }
        uVar26 = uVar10;
        if ((double)local_f0 < (double)uVar10) {
          uVar26 = (long)(double)local_f0;
        }
        pcVar11 = local_e0 + (long)dVar35 + -1;
        if ((uVar26 == uVar10) && ((char)plStack_d8 == '\0')) {
          uVar16 = 0;
          pcVar34 = (char *)0x0;
        }
        else {
          pcVar34 = local_e0 + ~(ulong)pcVar11 + uVar26;
          if (pcVar34 == (char *)0x0) {
            pcVar11 = "";
            uVar16 = 0;
          }
          else {
            pcVar11 = (char *)FUN_0054e2f4(pcVar11,pcVar34,*param_4);
            uVar16 = 1;
          }
        }
      }
    }
    *param_1 = (long)pcVar11;
    *(undefined1 *)(param_1 + 1) = uVar16;
    param_1[2] = (long)pcVar34;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
                    /* try { // try from 0054d17c to 0064d18f has its CatchHandler @ 0054d24c */
    }
LAB_0054d69c:
    *plVar14 = lVar13;
    plVar14[1] = lVar31;
    break;
  case 0x2a:
    FUN_0054dd4c(param_1,param_3,*param_4);
    pbVar24 = (byte *)*param_1;
    if ((char)param_1[1] == '\0') {
      lVar13 = *param_4;
      sVar8 = strlen((char *)pbVar24);
      pbVar24 = (byte *)FUN_0054e2f4(pbVar24,sVar8,lVar13);
      *param_1 = (long)pbVar24;
      *(undefined1 *)(param_1 + 1) = 1;
      param_1[2] = sVar8;
    }
    uVar10 = (ulong)*pbVar24;
    pbVar25 = pbVar24;
    pbVar19 = pbVar24;
    if (*pbVar24 != 0) {
      do {
                    /* try { // try from 0054ccb4 to 0064cd13 has its CatchHandler @ 0054cbb4 */
        while (bVar32 = (byte)uVar10, ((byte)(&DAT_005e1396)[uVar10] >> 3 & 1) == 0) {
                    /* try { // try from 0054cca4 to 0064ccb3 has its CatchHandler @ 0054cd24 */
          pbVar19 = pbVar19 + 1;
LAB_0054cca8:
          *pbVar25 = bVar32;
          uVar10 = (ulong)*pbVar19;
          pbVar20 = pbVar25 + 1;
          pbVar25 = pbVar25 + 1;
          if (*pbVar19 == 0) goto LAB_0054ce78;
        }
        do {
          pbVar19 = pbVar19 + 1;
        } while (((byte)(&DAT_005e1396)[*pbVar19] >> 3 & 1) != 0);
        if (pbVar25 != pbVar24) {
          bVar32 = 0x20;
          goto LAB_0054cca8;
        }
        uVar10 = (ulong)*pbVar19;
        pbVar20 = pbVar24;
        pbVar25 = pbVar24;
      } while (*pbVar19 != 0);
LAB_0054ce78:
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054cfe8 with catch @ 0054ce7c
                       catch(type#1 @ 00000000) { ... } // from try @ 0054d0a8 with catch @ 0054ce7c
                        */
      if ((pbVar20 != pbVar24) && (pbVar24 = pbVar20, ((&DAT_005e1396)[pbVar20[-1]] & 8) != 0)) {
        pbVar24 = pbVar20 + -1;
      }
    }
    goto LAB_0054ce94;
  case 0x2b:
    FUN_0054c7ec(param_1,*(undefined8 *)(param_2 + 8),param_3,param_4);
    pbVar24 = (byte *)*param_1;
    if ((char)param_1[1] == '\0') {
      lVar13 = *param_4;
      sVar8 = strlen((char *)pbVar24);
      pbVar24 = (byte *)FUN_0054e2f4(pbVar24,sVar8,lVar13);
      *param_1 = (long)pbVar24;
      *(undefined1 *)(param_1 + 1) = 1;
      param_1[2] = sVar8;
    }
    uVar10 = (ulong)*pbVar24;
    pbVar25 = pbVar24;
    pbVar19 = pbVar24;
    if (*pbVar24 != 0) {
      do {
        while (bVar32 = (byte)uVar10, ((byte)(&DAT_005e1396)[uVar10] >> 3 & 1) == 0) {
          pbVar19 = pbVar19 + 1;
LAB_0054ce38:
          *pbVar25 = bVar32;
          uVar10 = (ulong)*pbVar19;
          pbVar20 = pbVar25 + 1;
          pbVar25 = pbVar25 + 1;
          if (*pbVar19 == 0) goto LAB_0054ce78;
        }
        do {
          pbVar19 = pbVar19 + 1;
        } while (((byte)(&DAT_005e1396)[*pbVar19] >> 3 & 1) != 0);
        if (pbVar25 != pbVar24) {
          bVar32 = 0x20;
          goto LAB_0054ce38;
        }
        uVar10 = (ulong)*pbVar19;
        pbVar20 = pbVar24;
        pbVar25 = pbVar24;
      } while (*pbVar19 != 0);
      goto LAB_0054ce78;
    }
    goto LAB_0054ce94;
  case 0x2c:
    local_e8 = *param_4;
    plVar14 = (long *)param_4[1];
                    /* try { // try from 0054cd1c to 0064cd67 has its CatchHandler @ 0054cbb4 */
    lVar13 = *plVar14;
    lVar31 = plVar14[1];
                    /* catch() { ... } // from try @ 0054cca4 with catch @ 0054cd24
                       catch() { ... } // from try @ 0054cd14 with catch @ 0054cd24 */
    local_f0 = plVar14;
    FUN_0054c7ec(param_1,*(undefined8 *)(param_2 + 8),param_3,param_4);
    FUN_0054c7ec(&local_e0,*(undefined8 *)(param_2 + 0x10),param_3,&local_f0);
    FUN_0054c7ec(&local_110,*(undefined8 *)(*(long *)(param_2 + 0x10) + 0x18),param_3,&local_f0);
    pbVar24 = (byte *)*param_1;
    if ((char)param_1[1] == '\0') {
      lVar27 = *param_4;
      sVar8 = strlen((char *)pbVar24);
      pbVar24 = (byte *)FUN_0054e2f4(pbVar24,sVar8,lVar27);
      *param_1 = (long)pbVar24;
      *(undefined1 *)(param_1 + 1) = 1;
      param_1[2] = sVar8;
    }
    pcVar34 = local_e0;
    plVar30 = local_110;
    pbVar19 = pbVar24;
    if ((char)pcStack_108 == '\0') {
      local_100 = (char *)strlen((char *)local_110);
      bVar32 = *pbVar24;
    }
    else {
      bVar32 = *pbVar24;
    }
    while (bVar32 != 0) {
      pbVar24 = pbVar24 + 1;
      pcVar11 = strchr(pcVar34,(uint)bVar32);
      if (pcVar11 == (char *)0x0) {
LAB_0054d1c8:
        pbVar25 = pbVar19 + 1;
        *pbVar19 = bVar32;
      }
      else {
        pbVar25 = pbVar19;
        if (pcVar11 + -(long)pcVar34 < local_100) {
          bVar32 = *(byte *)((long)plVar30 + (long)(pcVar11 + -(long)pcVar34));
          goto LAB_0054d1c8;
        }
      }
      pbVar19 = pbVar25;
      bVar32 = *pbVar24;
    }
    *pbVar19 = 0;
    plVar30 = (long *)*plVar14;
    while (plVar30 != (long *)lVar13) {
      plVar30 = (long *)*plVar30;
      (*(code *)PTR_free_006f1268)();
    }
LAB_0054d7d0:
    *plVar14 = lVar13;
    plVar14[1] = lVar31;
    break;
  case 0x3a:
    FUN_0054c7ec(param_1,*(undefined8 *)(param_2 + 8),param_3,param_4);
    pbVar24 = (byte *)*param_1;
    if ((char)param_1[1] == '\0') {
      lVar13 = *param_4;
      sVar8 = strlen((char *)pbVar24);
      pbVar24 = (byte *)FUN_0054e2f4(pbVar24,sVar8,lVar13);
      *param_1 = (long)pbVar24;
      *(undefined1 *)(param_1 + 1) = 1;
      param_1[2] = sVar8;
    }
    bVar32 = *pbVar24;
    uVar10 = (ulong)bVar32;
    if (bVar32 != 0) {
      lVar13 = *(long *)(param_2 + 0x20);
                    /* try { // try from 0054c8d0 to 0064c8d7 has its CatchHandler @ 0054c984 */
      pbVar19 = pbVar24 + 1;
                    /* try { // try from 0054c8d8 to 0064c96b has its CatchHandler @ 0054c804 */
      if (-1 < (char)bVar32) goto LAB_0054c8f0;
      do {
        *pbVar24 = (byte)uVar10;
        bVar32 = *pbVar19;
        pbVar24 = pbVar24 + 1;
        while( true ) {
          if (bVar32 == 0) goto LAB_0054ce94;
          uVar10 = (ulong)bVar32;
          pbVar19 = pbVar19 + 1;
          if ((char)bVar32 < '\0') break;
LAB_0054c8f0:
          bVar32 = *(byte *)(lVar13 + uVar10);
          *pbVar24 = bVar32;
          pbVar24 = pbVar24 + ((ulong)(bVar32 >> 7) ^ 1);
          bVar32 = *pbVar19;
        }
      } while( true );
    }
LAB_0054ce94:
    *pbVar24 = 0;
  }
  if (*(long *)(lVar5 + 0x28) == local_78) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_0053d8b8 @ 0053d8b8 size=972 =====

void FUN_0053d8b8(byte *param_1,byte *param_2)

{
  byte *pbVar1;
  byte bVar2;
  byte bVar3;
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
  long lVar14;
  byte bVar15;
  byte bVar16;
  byte bVar17;
  byte bVar18;
  byte bVar19;
  uint uVar20;
  
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d8ac with catch @ 0053d8bc
                        */
  bVar12 = *param_1 ^ *param_2;
  *param_1 = bVar12;
  bVar9 = param_1[1] ^ param_2[1];
  param_1[1] = bVar9;
  bVar10 = param_1[2] ^ param_2[2];
  param_1[2] = bVar10;
  uVar20 = 1;
  bVar11 = param_1[3] ^ param_2[3];
  param_1[3] = bVar11;
  bVar16 = param_1[4] ^ param_2[4];
  param_1[4] = bVar16;
  bVar13 = param_1[5] ^ param_2[5];
  param_1[5] = bVar13;
  bVar15 = param_1[6] ^ param_2[6];
  param_1[6] = bVar15;
  bVar17 = param_1[7] ^ param_2[7];
  param_1[7] = bVar17;
  bVar19 = param_1[8] ^ param_2[8];
                    /* try { // try from 0053d980 to 0063da43 has its CatchHandler @ 0053d980
                       catch(type#1 @ 00000000) { ... } // from try @ 0053d980 with catch @ 0053d980
                        */
  param_1[8] = bVar19;
  bVar18 = param_1[9] ^ param_2[9];
  param_1[9] = bVar18;
  bVar3 = param_1[10] ^ param_2[10];
  param_1[10] = bVar3;
  bVar4 = param_1[0xb] ^ param_2[0xb];
  param_1[0xb] = bVar4;
  bVar5 = param_1[0xc] ^ param_2[0xc];
  param_1[0xc] = bVar5;
  bVar6 = param_1[0xd] ^ param_2[0xd];
  param_1[0xd] = bVar6;
  bVar7 = param_1[0xe] ^ param_2[0xe];
  param_1[0xe] = bVar7;
  bVar8 = param_1[0xf] ^ param_2[0xf];
  param_1[0xf] = bVar8;
  while( true ) {
                    /* try { // try from 0053da44 to 0063da4b has its CatchHandler @ 0053da68 */
                    /* try { // try from 0053da5c to 0063da63 has its CatchHandler @ 0053da64 */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053da5c with catch @ 0053da64
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053da44 with catch @ 0053da68
                        */
                    /* catch() { ... } // from try @ 0053db88 with catch @ 0053da7c
                       catch() { ... } // from try @ 0053dbdc with catch @ 0053da7c */
    bVar12 = (&DAT_005e081f)[bVar12];
    bVar16 = (&DAT_005e081f)[bVar16];
    bVar19 = (&DAT_005e081f)[bVar19];
    bVar5 = (&DAT_005e081f)[bVar5];
    bVar2 = (&DAT_005e081f)[bVar9];
    bVar9 = (&DAT_005e081f)[bVar13];
    bVar13 = (&DAT_005e081f)[bVar18];
    bVar18 = (&DAT_005e081f)[bVar6];
    bVar6 = (&DAT_005e081f)[bVar10];
    bVar15 = (&DAT_005e081f)[bVar15];
    bVar10 = (&DAT_005e081f)[bVar3];
    bVar3 = (&DAT_005e081f)[bVar7];
    bVar7 = (&DAT_005e081f)[bVar11];
    bVar17 = (&DAT_005e081f)[bVar17];
    bVar4 = (&DAT_005e081f)[bVar4];
    bVar11 = (&DAT_005e081f)[bVar8];
    *param_1 = bVar12;
    param_1[4] = bVar16;
    param_1[8] = bVar19;
    param_1[0xc] = bVar5;
    param_1[1] = bVar9;
    param_1[5] = bVar13;
    param_1[9] = bVar18;
    param_1[0xd] = bVar2;
    param_1[2] = bVar10;
    param_1[10] = bVar6;
    param_1[6] = bVar3;
    param_1[0xe] = bVar15;
    param_1[3] = bVar11;
    param_1[0xf] = bVar4;
    param_1[0xb] = bVar17;
    param_1[7] = bVar7;
    if ((uVar20 & 0xff) == 10) break;
    lVar14 = 0;
    while( true ) {
      bVar16 = bVar9 ^ bVar12;
      bVar13 = bVar16 ^ bVar10 ^ bVar11;
      pbVar1 = param_1 + lVar14;
      pbVar1[2] = bVar11 ^ bVar16 ^ (bVar11 ^ bVar10) << 1 ^
                  (byte)((uint)(int)(char)(bVar11 ^ bVar10) >> 7) & 0x1b;
                    /* try { // try from 0053db80 to 0063db87 has its CatchHandler @ 0053dc44 */
      *pbVar1 = bVar12 ^ bVar16 << 1 ^ (byte)((uint)(int)(char)bVar16 >> 7) & 0x1b ^ bVar13;
      pbVar1[1] = bVar9 ^ (bVar10 ^ bVar9) << 1 ^ bVar13 ^
                  (byte)((uint)(int)(char)(bVar10 ^ bVar9) >> 7) & 0x1b;
                    /* try { // try from 0053db88 to 0063dbcb has its CatchHandler @ 0053da7c */
      pbVar1[3] = bVar16 ^ bVar10 ^ (bVar11 ^ bVar12) << 1 ^
                  (byte)((uint)(int)(char)(bVar11 ^ bVar12) >> 7) & 0x1b;
      if (lVar14 == 0xc) break;
      bVar12 = pbVar1[4];
      bVar9 = pbVar1[5];
      bVar10 = pbVar1[6];
      bVar11 = pbVar1[7];
      lVar14 = lVar14 + 4;
    }
    FUN_0053e4ac(uVar20,param_1,param_2);
    bVar12 = *param_1;
    bVar16 = param_1[4];
    bVar19 = param_1[8];
    bVar5 = param_1[0xc];
    bVar9 = param_1[1];
    bVar13 = param_1[5];
    bVar18 = param_1[9];
    bVar6 = param_1[0xd];
    bVar10 = param_1[2];
    bVar15 = param_1[6];
    bVar3 = param_1[10];
    bVar7 = param_1[0xe];
    bVar11 = param_1[3];
    bVar17 = param_1[7];
    bVar4 = param_1[0xb];
    bVar8 = param_1[0xf];
    uVar20 = uVar20 + 1;
  }
  *param_1 = param_2[0xa0] ^ bVar12;
  param_1[1] = param_2[0xa1] ^ bVar9;
  param_1[2] = param_2[0xa2] ^ bVar10;
                    /* try { // try from 0053dbcc to 0063dbdb has its CatchHandler @ 0053dc44 */
  param_1[3] = param_2[0xa3] ^ bVar11;
                    /* try { // try from 0053dbdc to 0063dc93 has its CatchHandler @ 0053da7c */
  param_1[4] = param_2[0xa4] ^ bVar16;
  param_1[5] = param_2[0xa5] ^ bVar13;
  param_1[6] = param_2[0xa6] ^ bVar3;
  param_1[7] = param_2[0xa7] ^ bVar7;
  param_1[8] = param_2[0xa8] ^ bVar19;
  param_1[9] = param_2[0xa9] ^ bVar18;
  param_1[10] = param_2[0xaa] ^ bVar6;
  param_1[0xb] = param_2[0xab] ^ bVar17;
  param_1[0xc] = param_2[0xac] ^ bVar5;
                    /* catch() { ... } // from try @ 0053db80 with catch @ 0053dc44
                       catch() { ... } // from try @ 0053dbcc with catch @ 0053dc44 */
  param_1[0xd] = param_2[0xad] ^ bVar2;
  param_1[0xe] = param_2[0xae] ^ bVar15;
  param_1[0xf] = param_2[0xaf] ^ bVar4;
  return;
}



// ===== FUN_00548854 @ 00548854 size=380 =====

long * FUN_00548854(undefined8 *param_1,long *param_2,int param_3)

{
  undefined8 *puVar1;
  ulong uVar2;
  int iVar3;
  long lVar4;
  long *plVar5;
  int extraout_w1;
  int iVar6;
  int extraout_w1_00;
  long *plVar7;
  undefined1 auVar8 [16];
  
  puVar1 = param_1 + 1;
  auVar8 = FUN_00548d48(puVar1);
  if (param_3 <= auVar8._8_4_) {
    iVar3 = auVar8._0_4_;
                    /* try { // try from 00548894 to 006488cf has its CatchHandler @ 005486f8 */
    while (iVar3 != 0) {
      FUN_00548530(puVar1);
      lVar4 = FUN_005489d0(param_1);
      iVar3 = FUN_00548d48(puVar1);
      iVar6 = extraout_w1;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00548890 with catch @ 005488cc
                        */
      while ((auVar8._8_4_ < iVar6 && (iVar3 != 0))) {
                    /* catch() { ... } // from try @ 005489d4 with catch @ 005488d0 */
        lVar4 = FUN_00548854(param_1,lVar4);
        iVar3 = FUN_00548d48(puVar1);
        iVar6 = extraout_w1_00;
      }
      if ((auVar8._0_4_ == 0xf) &&
         ((*(char *)((long)param_2 + 1) != '\x01' || (*(char *)(lVar4 + 1) != '\x01')))) {
                    /* WARNING: Subroutine does not return */
        FUN_00548800(param_1,&DAT_005e0f30);
      }
      plVar7 = (long *)*param_1;
      uVar2 = plVar7[1] + 0x28;
      if (*(ulong *)(*plVar7 + 8) < uVar2) {
        plVar5 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
        if (plVar5 == (long *)0x0) {
                    /* WARNING: Subroutine does not return */
          FUN_00548f50();
        }
        *plVar5 = *plVar7;
        plVar5[1] = 0x1000;
        *plVar7 = (long)plVar5;
        plVar7[1] = 0x28;
      }
      else {
        plVar5 = (long *)(*plVar7 + plVar7[1]);
        plVar7[1] = uVar2;
      }
      plVar7 = plVar5 + 2;
      *(char *)plVar7 = auVar8[0];
      *(undefined2 *)((long)plVar5 + 0x12) = 0;
      plVar5[3] = (long)param_2;
      plVar5[4] = lVar4;
      *(char *)((long)plVar5 + 0x11) = auVar8[4];
      plVar5[5] = 0;
      auVar8 = FUN_00548d48(puVar1);
      if (auVar8._8_4_ < param_3) {
        return plVar7;
      }
      param_2 = plVar7;
      iVar3 = auVar8._0_4_;
    }
  }
                    /* try { // try from 005489a0 to 006489d3 has its CatchHandler @ 00548a7c */
  return param_2;
}



// ===== FUN_00542e60 @ 00542e60 size=2096 =====

undefined1  [16] FUN_00542e60(undefined1 *param_1,long param_2,undefined8 *param_3)

{
  long lVar1;
  long lVar2;
  char cVar3;
  byte bVar4;
  long lVar5;
  bool bVar6;
  bool bVar7;
  uint uVar8;
  long *plVar9;
  size_t sVar10;
  long *plVar11;
  byte *pbVar12;
  byte *pbVar13;
  ulong uVar14;
  ulong uVar15;
  long *plVar16;
  long lVar17;
  long lVar18;
  double dVar19;
  undefined8 extraout_var;
  undefined1 auVar20 [16];
  undefined8 extraout_var_00;
  undefined8 extraout_var_01;
  undefined8 extraout_var_02;
  double dVar21;
  undefined8 in_register_00005108;
  byte *local_b0 [3];
  byte *local_98;
  char local_90;
  undefined7 uStack_8f;
  ulong local_88;
  long local_78;
  
  lVar5 = tpidr_el0;
  local_78 = *(long *)(lVar5 + 0x28);
  switch(*param_1) {
  case 9:
    dVar21 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    dVar19 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 0x10),param_2,param_3);
    dVar21 = dVar21 + dVar19;
    in_register_00005108 = 0;
    break;
  case 10:
    dVar21 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    dVar19 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 0x10),param_2,param_3);
    dVar21 = dVar21 - dVar19;
    in_register_00005108 = 0;
    break;
  case 0xb:
    dVar21 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    dVar19 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 0x10),param_2,param_3);
    dVar21 = dVar21 * dVar19;
    in_register_00005108 = 0;
    break;
  case 0xc:
    dVar21 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    dVar19 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 0x10),param_2,param_3);
    dVar21 = dVar21 / dVar19;
    in_register_00005108 = 0;
    break;
  case 0xd:
    dVar21 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    dVar19 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 0x10),param_2,param_3);
    dVar21 = fmod(dVar21,dVar19);
    in_register_00005108 = extraout_var;
    break;
  case 0xe:
    dVar21 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    dVar21 = -dVar21;
    in_register_00005108 = 0;
    break;
  default:
    cVar3 = param_1[1];
LAB_005432f4:
    if (cVar3 == '\x01') {
      plVar16 = (long *)*param_3;
      lVar17 = *plVar16;
      lVar18 = plVar16[1];
      FUN_0054c7ec(&local_98,param_1,param_2,param_3);
      pbVar13 = local_98;
      do {
        pbVar12 = pbVar13;
        pbVar13 = pbVar12 + 1;
      } while (((byte)(&DAT_005e1396)[*pbVar12] >> 3 & 1) != 0);
      if (*pbVar12 != 0x2d) {
        pbVar13 = pbVar12;
      }
      bVar4 = *pbVar13;
      if ((ulong)bVar4 == 0) {
LAB_00543608:
        dVar21 = NAN;
        in_register_00005108 = 0;
      }
      else {
        if (9 < (ulong)bVar4 - 0x30) {
          if ((bVar4 == 0x2e) && ((ulong)pbVar13[1] - 0x30 < 10)) goto LAB_005435dc;
          goto LAB_00543608;
        }
        do {
                    /* try { // try from 0054341c to 00643423 has its CatchHandler @ 00543458 */
          pbVar13 = pbVar13 + 1;
          uVar15 = (ulong)*pbVar13;
                    /* try { // try from 00543424 to 0064345f has its CatchHandler @ 005432dc */
        } while (uVar15 - 0x30 < 10);
        if (*pbVar13 == 0x2e) {
LAB_005435dc:
          do {
            pbVar13 = pbVar13 + 1;
            uVar15 = (ulong)*pbVar13;
          } while (uVar15 - 0x30 < 10);
        }
        bVar4 = (&DAT_005e1396)[uVar15];
        while ((bVar4 >> 3 & 1) != 0) {
          pbVar13 = pbVar13 + 1;
          uVar15 = (ulong)*pbVar13;
          bVar4 = (&DAT_005e1396)[uVar15];
        }
        if ((int)uVar15 != 0) goto LAB_00543608;
        dVar21 = atof((char *)local_98);
        in_register_00005108 = extraout_var_02;
      }
      plVar11 = (long *)*plVar16;
      while (plVar11 != (long *)lVar17) {
        plVar11 = (long *)*plVar11;
        (*(code *)PTR_free_006f1268)();
      }
    }
    else {
      if (cVar3 != '\x03') {
        dVar21 = 0.0;
        in_register_00005108 = 0;
        if (cVar3 == '\x04') {
          uVar8 = FUN_00540998(param_1,param_2,param_3);
          dVar21 = (double)(uVar8 & 1);
          in_register_00005108 = 0;
        }
        break;
      }
      plVar16 = (long *)*param_3;
      lVar17 = *plVar16;
      lVar18 = plVar16[1];
      FUN_0054c7ec(&local_98,param_1,param_2,param_3);
      pbVar13 = local_98;
      do {
        pbVar12 = pbVar13;
                    /* try { // try from 00543384 to 00643413 has its CatchHandler @ 0054345c */
        pbVar13 = pbVar12 + 1;
      } while (((byte)(&DAT_005e1396)[*pbVar12] >> 3 & 1) != 0);
      if (*pbVar12 != 0x2d) {
        pbVar13 = pbVar12;
      }
      bVar4 = *pbVar13;
      if ((ulong)bVar4 == 0) {
LAB_00543590:
        dVar21 = NAN;
        in_register_00005108 = 0;
      }
      else {
        if (9 < (ulong)bVar4 - 0x30) {
          if ((bVar4 == 0x2e) && ((ulong)pbVar13[1] - 0x30 < 10)) goto LAB_00543564;
          goto LAB_00543590;
        }
        do {
          pbVar13 = pbVar13 + 1;
          uVar15 = (ulong)*pbVar13;
        } while (uVar15 - 0x30 < 10);
        if (*pbVar13 == 0x2e) {
LAB_00543564:
          do {
            pbVar13 = pbVar13 + 1;
            uVar15 = (ulong)*pbVar13;
          } while (uVar15 - 0x30 < 10);
        }
        bVar4 = (&DAT_005e1396)[uVar15];
        while ((bVar4 >> 3 & 1) != 0) {
          pbVar13 = pbVar13 + 1;
          uVar15 = (ulong)*pbVar13;
          bVar4 = (&DAT_005e1396)[uVar15];
        }
        if ((int)uVar15 != 0) goto LAB_00543590;
        dVar21 = atof((char *)local_98);
        in_register_00005108 = extraout_var_01;
      }
      plVar11 = (long *)*plVar16;
      while (plVar11 != (long *)lVar17) {
        plVar11 = (long *)*plVar11;
        (*(code *)PTR_free_006f1268)();
      }
    }
    *plVar16 = lVar17;
    plVar16[1] = lVar18;
    break;
  case 0x13:
    dVar21 = *(double *)(param_1 + 0x20);
    in_register_00005108 = 0;
    break;
  case 0x14:
    cVar3 = param_1[1];
    if (cVar3 != '\x02') goto LAB_005432f4;
    if (**(int **)(param_1 + 0x20) == 2) {
      dVar21 = *(double *)(*(int **)(param_1 + 0x20) + 4);
      in_register_00005108 = 0;
    }
    else {
      dVar21 = NAN;
      in_register_00005108 = 0;
    }
    break;
  case 0x15:
    dVar21 = (double)NEON_ucvtf(*(undefined8 *)(param_2 + 0x18));
    break;
  case 0x16:
    dVar21 = (double)NEON_ucvtf(*(undefined8 *)(param_2 + 0x10));
    break;
  case 0x17:
    plVar16 = (long *)*param_3;
    lVar17 = *plVar16;
    lVar18 = plVar16[1];
    FUN_0054389c(&local_98,*(undefined8 *)(param_1 + 8),param_2,param_3,0);
    plVar11 = (long *)*plVar16;
    while (plVar11 != (long *)lVar17) {
      plVar11 = (long *)*plVar11;
      (*(code *)PTR_free_006f1268)();
    }
    uVar15 = (long)(local_88 - CONCAT71(uStack_8f,local_90)) >> 4;
    goto LAB_00543470;
  case 0x28:
    plVar16 = (long *)*param_3;
    lVar17 = *plVar16;
    lVar18 = plVar16[1];
    FUN_0054dd4c(&local_98,param_2,plVar16);
    sVar10 = local_88;
    if (local_90 == '\0') {
      sVar10 = strlen((char *)local_98);
    }
    plVar11 = (long *)*plVar16;
    while (plVar11 != (long *)lVar17) {
      plVar11 = (long *)*plVar11;
      (*(code *)PTR_free_006f1268)();
    }
    dVar21 = (double)sVar10;
    in_register_00005108 = 0;
    *plVar16 = lVar17;
    plVar16[1] = lVar18;
    break;
  case 0x29:
    plVar16 = (long *)*param_3;
    lVar17 = *plVar16;
    lVar18 = plVar16[1];
    FUN_0054c7ec(&local_98,*(undefined8 *)(param_1 + 8),param_2,param_3);
    uVar15 = local_88;
    if (local_90 == '\0') {
      uVar15 = strlen((char *)local_98);
    }
    plVar11 = (long *)*plVar16;
    while (plVar11 != (long *)lVar17) {
      plVar11 = (long *)*plVar11;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054341c with catch @ 00543458
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00543384 with catch @ 0054345c
                        */
      (*(code *)PTR_free_006f1268)();
                    /* try { // try from 00543460 to 00643467 has its CatchHandler @ 00543470 */
                    /* try { // try from 00543468 to 00643473 has its CatchHandler @ 005432dc */
    }
LAB_00543470:
    in_register_00005108 = 0;
    dVar21 = (double)uVar15;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00543460 with catch @ 00543470
                        */
    *plVar16 = lVar17;
    plVar16[1] = lVar18;
                    /* try { // try from 00543474 to 0064369f has its CatchHandler @ 00543474
                       catch(type#1 @ 00000000) { ... } // from try @ 00543474 with catch @ 00543474
                        */
    break;
  case 0x32:
    plVar16 = (long *)*param_3;
    lVar17 = *plVar16;
    lVar18 = plVar16[1];
    FUN_0054dd4c(&local_98,param_2,plVar16);
    pbVar13 = local_98;
    do {
      pbVar12 = pbVar13;
      pbVar13 = pbVar12 + 1;
    } while (((byte)(&DAT_005e1396)[*pbVar12] >> 3 & 1) != 0);
    if (*pbVar12 != 0x2d) {
      pbVar13 = pbVar12;
    }
    bVar4 = *pbVar13;
    if ((ulong)bVar4 == 0) {
LAB_005434fc:
      dVar21 = NAN;
      in_register_00005108 = 0;
    }
    else {
      if (9 < (ulong)bVar4 - 0x30) {
        if ((bVar4 == 0x2e) && ((ulong)pbVar13[1] - 0x30 < 10)) goto LAB_005434d0;
        goto LAB_005434fc;
      }
      do {
        pbVar13 = pbVar13 + 1;
        uVar15 = (ulong)*pbVar13;
      } while (uVar15 - 0x30 < 10);
      if (*pbVar13 == 0x2e) {
LAB_005434d0:
        do {
          pbVar13 = pbVar13 + 1;
          uVar15 = (ulong)*pbVar13;
        } while (uVar15 - 0x30 < 10);
      }
      bVar4 = (&DAT_005e1396)[uVar15];
      while ((bVar4 >> 3 & 1) != 0) {
        pbVar13 = pbVar13 + 1;
        uVar15 = (ulong)*pbVar13;
        bVar4 = (&DAT_005e1396)[uVar15];
      }
      if ((int)uVar15 != 0) goto LAB_005434fc;
      dVar21 = atof((char *)local_98);
      in_register_00005108 = extraout_var_00;
    }
    plVar11 = (long *)*plVar16;
    while (plVar11 != (long *)lVar17) {
      plVar11 = (long *)*plVar11;
      (*(code *)PTR_free_006f1268)();
    }
    *plVar16 = lVar17;
    plVar16[1] = lVar18;
    break;
  case 0x33:
    auVar20 = FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    if (*(long *)(lVar5 + 0x28) == local_78) {
      return auVar20;
    }
    goto LAB_0054368c;
  case 0x34:
    plVar16 = (long *)*param_3;
    lVar17 = *plVar16;
    lVar18 = plVar16[1];
    FUN_0054389c(&local_98,*(undefined8 *)(param_1 + 8),param_2,param_3,0);
    uVar15 = CONCAT71(uStack_8f,local_90);
    dVar21 = 0.0;
    if (uVar15 != local_88) {
      do {
        plVar11 = (long *)*param_3;
        lVar1 = *plVar11;
        lVar2 = plVar11[1];
        FUN_0054dd4c(local_b0,uVar15,plVar11);
        pbVar13 = local_b0[0];
        do {
          pbVar12 = pbVar13;
          pbVar13 = pbVar12 + 1;
        } while (((byte)(&DAT_005e1396)[*pbVar12] >> 3 & 1) != 0);
        if (*pbVar12 != 0x2d) {
          pbVar13 = pbVar12;
        }
        bVar4 = *pbVar13;
        if ((ulong)bVar4 == 0) {
LAB_00543264:
          dVar19 = NAN;
        }
        else {
          if (9 < (ulong)bVar4 - 0x30) {
            if ((bVar4 == 0x2e) && ((ulong)pbVar13[1] - 0x30 < 10)) goto LAB_00543238;
            goto LAB_00543264;
          }
          do {
            pbVar13 = pbVar13 + 1;
            uVar14 = (ulong)*pbVar13;
          } while (uVar14 - 0x30 < 10);
          if (*pbVar13 == 0x2e) {
LAB_00543238:
            do {
              pbVar13 = pbVar13 + 1;
              uVar14 = (ulong)*pbVar13;
            } while (uVar14 - 0x30 < 10);
          }
          bVar4 = (&DAT_005e1396)[uVar14];
          while ((bVar4 >> 3 & 1) != 0) {
            pbVar13 = pbVar13 + 1;
            uVar14 = (ulong)*pbVar13;
            bVar4 = (&DAT_005e1396)[uVar14];
          }
          if ((int)uVar14 != 0) goto LAB_00543264;
          dVar19 = atof((char *)local_b0[0]);
        }
        plVar9 = (long *)*plVar11;
        while (plVar9 != (long *)lVar1) {
          plVar9 = (long *)*plVar9;
          (*(code *)PTR_free_006f1268)();
        }
        *plVar11 = lVar1;
        plVar11[1] = lVar2;
        uVar15 = uVar15 + 0x10;
        dVar21 = dVar21 + dVar19;
      } while (uVar15 != local_88);
    }
    in_register_00005108 = 0;
    plVar11 = (long *)*plVar16;
    while (plVar11 != (long *)lVar17) {
      plVar11 = (long *)*plVar11;
      (*(code *)PTR_free_006f1268)();
    }
    *plVar16 = lVar17;
    plVar16[1] = lVar18;
    break;
  case 0x35:
                    /* try { // try from 005432dc to 00643383 has its CatchHandler @ 005432dc
                       catch(type#1 @ 00000000) { ... } // from try @ 005432dc with catch @ 005432dc
                       catch(type#1 @ 00000000) { ... } // from try @ 00543424 with catch @ 005432dc
                       catch(type#1 @ 00000000) { ... } // from try @ 00543468 with catch @ 005432dc
                        */
    dVar19 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    goto LAB_005432e4;
  case 0x36:
    dVar19 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
LAB_005432e4:
    dVar21 = (double)(long)dVar19;
    if (NAN(dVar19)) {
      dVar21 = dVar19;
    }
    in_register_00005108 = 0;
    break;
  case 0x37:
    dVar21 = (double)FUN_00542e60(*(undefined8 *)(param_1 + 8),param_2,param_3);
    bVar6 = true;
    bVar7 = false;
    if (dVar21 <= 0.0) {
      bVar6 = false;
      bVar7 = true;
      if (!NAN(dVar21)) {
        bVar6 = dVar21 < -0.5;
        bVar7 = false;
      }
    }
    if (bVar6 != bVar7) {
      dVar21 = dVar21 + 0.5;
    }
    dVar21 = (double)(long)dVar21;
    in_register_00005108 = 0;
  }
  auVar20._8_8_ = in_register_00005108;
  auVar20._0_8_ = dVar21;
  if (*(long *)(lVar5 + 0x28) == local_78) {
    return auVar20;
  }
LAB_0054368c:
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_004061a0 @ 004061a0 size=524 =====

undefined4 FUN_004061a0(long param_1,byte *param_2)

{
  ulong uVar1;
  byte *pbVar2;
  long lVar3;
  int iVar4;
  long lVar5;
  undefined8 uVar6;
  long lVar7;
  char *pcVar8;
  size_t sVar9;
  undefined4 uVar10;
  byte local_368 [16];
  void *local_358;
  undefined1 auStack_350 [776];
  long local_48;
  
  lVar3 = tpidr_el0;
  local_48 = *(long *)(lVar3 + 0x28);
  FUN_00400d38(auStack_350,1,0);
  uVar1 = *(ulong *)(param_2 + 8);
  pbVar2 = *(byte **)(param_2 + 0x10);
  if ((*param_2 & 1) == 0) {
    pbVar2 = param_2 + 1;
    uVar1 = (ulong)(*param_2 >> 1);
  }
  iVar4 = FUN_004014f4(auStack_350,pbVar2,uVar1);
  if ((iVar4 == 0) && (lVar5 = FUN_003ff108(auStack_350,0), lVar5 != 0)) {
    uVar6 = FUN_003ff108(auStack_350,0);
    FUN_00175474(local_368,"NewProtocol");
    lVar5 = FUN_003902ec(uVar6,local_368);
    if ((local_368[0] & 1) != 0) {
      operator_delete(local_358);
    }
    if ((lVar5 != 0) && (lVar7 = FUN_00400480(lVar5), lVar7 != 0)) {
      pcVar8 = (char *)FUN_00400480(lVar5);
      sVar9 = strlen(pcVar8);
      FUN_00174ddc(param_1 + 0x18,pcVar8,sVar9);
      uVar6 = FUN_003ff108(auStack_350,0);
      FUN_00175474(local_368,"NewExternalPort");
      lVar5 = FUN_003902ec(uVar6,local_368);
      if ((local_368[0] & 1) != 0) {
        operator_delete(local_358);
      }
      if ((lVar5 != 0) && (lVar7 = FUN_00400480(lVar5), lVar7 != 0)) {
        pcVar8 = (char *)FUN_00400480(lVar5);
        sVar9 = strlen(pcVar8);
        FUN_00174ddc(param_1,pcVar8,sVar9);
        uVar6 = FUN_003ff108(auStack_350,0);
        FUN_00175474(local_368,&DAT_005e030b);
        lVar5 = FUN_003902ec(uVar6,local_368);
        if ((local_368[0] & 1) != 0) {
          operator_delete(local_358);
        }
        if ((lVar5 != 0) && (lVar7 = FUN_00400480(lVar5), lVar7 != 0)) {
          pcVar8 = (char *)FUN_00400480(lVar5);
          sVar9 = strlen(pcVar8);
          FUN_00174ddc(param_1 + 0x30,pcVar8,sVar9);
          uVar10 = 1;
          goto LAB_00406204;
        }
      }
    }
  }
  uVar10 = 0;
LAB_00406204:
  FUN_00400fec(auStack_350);
  if (*(long *)(lVar3 + 0x28) == local_48) {
    return uVar10;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_005489d0 @ 005489d0 size=888 =====

long * FUN_005489d0(undefined8 *param_1)

{
  undefined8 *puVar1;
  ulong uVar2;
  uint uVar3;
  byte bVar4;
  int iVar5;
  long *plVar6;
  undefined8 uVar7;
  long lVar8;
  long *plVar9;
  byte *pbVar10;
  long *plVar11;
  
                    /* try { // try from 005489d4 to 00648abf has its CatchHandler @ 005488d0 */
  uVar3 = *(uint *)(param_1 + 5);
  if (0x14 < uVar3) goto LAB_00548b7c;
  puVar1 = param_1 + 1;
  if ((1 << (ulong)(uVar3 & 0x1f) & 0xd800U) == 0) {
    if (uVar3 == 8) {
      FUN_00548530(puVar1);
      uVar7 = FUN_005489d0(param_1);
      lVar8 = FUN_00548854(param_1,uVar7,7);
      plVar6 = (long *)*param_1;
      uVar2 = plVar6[1] + 0x28;
      if (uVar2 <= *(ulong *)(*plVar6 + 8)) {
        plVar11 = (long *)(*plVar6 + plVar6[1]);
        plVar6[1] = uVar2;
LAB_00548ce4:
        plVar11[4] = 0;
        plVar11[5] = 0;
        *(undefined4 *)(plVar11 + 2) = 0x20e;
        plVar11[3] = lVar8;
        return plVar11 + 2;
      }
      plVar11 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar11 != (long *)0x0) {
        *plVar11 = *plVar6;
        plVar11[1] = 0x1000;
        *plVar6 = (long)plVar11;
        plVar6[1] = 0x28;
        goto LAB_00548ce4;
      }
      goto LAB_00548d34;
    }
    if (uVar3 != 0x14) {
LAB_00548b7c:
      plVar6 = (long *)FUN_00548f7c(param_1);
      return plVar6;
    }
    pbVar10 = (byte *)*puVar1;
    do {
      bVar4 = *pbVar10;
      pbVar10 = pbVar10 + 1;
    } while (((byte)(&DAT_005e1396)[bVar4] >> 3 & 1) != 0);
    if ((bVar4 != 0x28) || (iVar5 = FUN_00549330(param_1 + 3), iVar5 != 0)) goto LAB_00548b7c;
  }
  plVar6 = (long *)FUN_00549494(param_1);
  while (iVar5 = *(int *)(param_1 + 5), iVar5 == 0x12) {
    FUN_00548530(puVar1);
    uVar7 = FUN_005489d0(param_1);
    lVar8 = FUN_00548854(param_1,uVar7,0);
    if (*(char *)((long)plVar6 + 1) != '\x01') {
                    /* WARNING: Subroutine does not return */
      FUN_00548800(param_1,"Predicate has to be applied to node set");
    }
    plVar11 = (long *)*param_1;
    uVar2 = plVar11[1] + 0x28;
                    /* catch() { ... } // from try @ 005489a0 with catch @ 00548a7c */
    if (*(ulong *)(*plVar11 + 8) < uVar2) {
      plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar9 == (long *)0x0) goto LAB_00548d34;
      *plVar9 = *plVar11;
      plVar9[1] = 0x1000;
      *plVar11 = (long)plVar9;
      plVar11[1] = 0x28;
    }
    else {
      plVar9 = (long *)(*plVar11 + plVar11[1]);
      plVar11[1] = uVar2;
    }
    *(undefined4 *)(plVar9 + 2) = 0x111;
    plVar9[3] = (long)plVar6;
    plVar9[4] = lVar8;
    plVar9[5] = 0;
    if (*(int *)(param_1 + 5) != 0x13) {
                    /* try { // try from 00548d24 to 00648db3 has its CatchHandler @ 00548dfc */
                    /* WARNING: Subroutine does not return */
      FUN_00548800(param_1,"Unmatched square brace");
    }
    FUN_00548530(puVar1);
    plVar6 = plVar9 + 2;
  }
  if (iVar5 == 0x10) {
    FUN_00548530(puVar1);
  }
  else {
    if (iVar5 != 0x11) {
      return plVar6;
    }
    FUN_00548530(puVar1);
    if (*(char *)((long)plVar6 + 1) != '\x01') {
                    /* WARNING: Subroutine does not return */
      FUN_00548800(param_1,"Step has to be applied to node set");
    }
    plVar11 = (long *)*param_1;
    uVar2 = plVar11[1] + 0x28;
    if (*(ulong *)(*plVar11 + 8) < uVar2) {
      plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar9 == (long *)0x0) {
LAB_00548d34:
                    /* WARNING: Subroutine does not return */
        FUN_00548f50();
      }
      *plVar9 = *plVar11;
      plVar9[1] = 0x1000;
      *plVar11 = (long)plVar9;
      plVar11[1] = 0x28;
    }
    else {
      plVar9 = (long *)(*plVar11 + plVar11[1]);
      plVar11[1] = uVar2;
    }
    plVar9[3] = (long)plVar6;
    plVar9[4] = 0;
    *(undefined4 *)(plVar9 + 2) = 0x2050138;
    plVar9[5] = 0;
    plVar9[6] = 0;
    plVar6 = plVar9 + 2;
  }
  do {
    while( true ) {
      plVar6 = (long *)FUN_0054ad30(param_1,plVar6);
                    /* try { // try from 00548c7c to 00648d23 has its CatchHandler @ 00548c7c
                       catch(type#1 @ 00000000) { ... } // from try @ 00548c7c with catch @ 00548c7c
                       catch(type#1 @ 00000000) { ... } // from try @ 00548dc4 with catch @ 00548c7c
                       catch(type#1 @ 00000000) { ... } // from try @ 00548e08 with catch @ 00548c7c
                        */
      if (*(int *)(param_1 + 5) == 0x11) break;
      if (*(int *)(param_1 + 5) != 0x10) {
        return plVar6;
      }
      FUN_00548530(puVar1);
    }
    FUN_00548530(puVar1);
    plVar11 = (long *)*param_1;
    uVar2 = plVar11[1] + 0x28;
    if (*(ulong *)(*plVar11 + 8) < uVar2) {
      plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar9 == (long *)0x0) goto LAB_00548d34;
      *plVar9 = *plVar11;
      plVar9[1] = 0x1000;
      *plVar11 = (long)plVar9;
      plVar11[1] = 0x28;
    }
    else {
      plVar9 = (long *)(*plVar11 + plVar11[1]);
      plVar11[1] = uVar2;
    }
    *(undefined4 *)(plVar9 + 2) = 0x2050138;
    plVar9[3] = (long)plVar6;
    plVar9[4] = 0;
    plVar9[5] = 0;
    plVar9[6] = 0;
    plVar6 = plVar9 + 2;
  } while( true );
}



// ===== FUN_0053cff4 @ 0053cff4 size=400 =====

void FUN_0053cff4(undefined8 param_1,undefined4 param_2,undefined8 param_3,undefined1 *param_4)

{
  ulong uVar1;
  long lVar2;
  void *pvVar3;
  uint uVar4;
  undefined8 uVar5;
  ulong local_80;
  ulong local_78;
  void *local_70;
  byte local_68 [16];
  void *local_58;
  ulong local_50;
  ulong local_48;
  void *local_40;
  long local_38;
  
  lVar2 = tpidr_el0;
  local_38 = *(long *)(lVar2 + 0x28);
  local_48 = 0;
  local_40 = (void *)0x0;
  local_50 = 0;
  switch(param_2) {
  case 1:
    FUN_00174ddc(&local_50,&DAT_005e0372,0x18);
    break;
  case 2:
    FUN_00174ddc(&local_50,&DAT_005e038b,0x1b);
    break;
  case 3:
    FUN_00174ddc(&local_50,&DAT_005e03a7,0x24);
    break;
  case 4:
    FUN_00174ddc(&local_50,"u:GetSpecificPortMappingEntryResponse",0x25);
  }
  uVar1 = local_50 >> 1 & 0x7f;
  if ((local_50 & 1) != 0) {
    uVar1 = local_48;
  }
  if (uVar1 != 0) {
                    /* try { // try from 0053d0b8 to 0063d0cb has its CatchHandler @ 0053d178 */
    uVar5 = FUN_00175474(local_68,&DAT_005e03f2);
    local_78 = 0;
    local_70 = (void *)0x0;
                    /* try { // try from 0053d0cc to 0063d1c7 has its CatchHandler @ 0053cfb4 */
    local_80 = 0;
    uVar4 = FUN_0053a780(uVar5,param_3,local_68,&local_80);
    if ((&local_80 != (ulong *)param_4) && (((uVar4 ^ 1) & 1) == 0)) {
      uVar1 = local_80 >> 1 & 0x7f;
      pvVar3 = (void *)((ulong)&local_80 | 1);
      if ((local_80 & 1) != 0) {
        uVar1 = local_78;
        pvVar3 = local_70;
      }
      FUN_00174ddc(param_4,pvVar3,uVar1);
    }
    if ((local_80 & 1) != 0) {
      operator_delete(local_70);
    }
    if ((local_68[0] & 1) != 0) {
      operator_delete(local_58);
    }
  }
                    /* catch() { ... } // from try @ 0053d0b8 with catch @ 0053d178 */
  if ((local_50 & 1) != 0) {
    operator_delete(local_40);
  }
  if (*(long *)(lVar2 + 0x28) == local_38) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



// ===== FUN_00549330 @ 00549330 size=356 =====

undefined8 FUN_00549330(undefined8 *param_1)

{
  char cVar1;
  long lVar2;
  char *pcVar3;
  char *pcVar4;
  char *pcVar5;
  
  pcVar3 = (char *)*param_1;
  switch(*pcVar3) {
  case 'c':
    pcVar4 = (char *)param_1[1];
    lVar2 = (long)pcVar4 - (long)pcVar3;
    if (pcVar4 != pcVar3) {
      pcVar4 = pcVar4 + ~(ulong)pcVar3;
      pcVar5 = "omment";
      do {
        pcVar3 = pcVar3 + 1;
        if (pcVar4 == (char *)0x0) {
          if (lVar2 != 7) {
            return 0;
          }
          return 3;
        }
        cVar1 = *pcVar5;
        pcVar4 = pcVar4 + -1;
        pcVar5 = pcVar5 + 1;
      } while (cVar1 == *pcVar3);
    }
    break;
  case 'n':
    pcVar4 = (char *)param_1[1];
    lVar2 = (long)pcVar4 - (long)pcVar3;
    if (pcVar4 != pcVar3) {
      pcVar4 = pcVar4 + ~(ulong)pcVar3;
      pcVar5 = "ode";
      do {
        pcVar3 = pcVar3 + 1;
        if (pcVar4 == (char *)0x0) {
          if (lVar2 != 4) {
            return 0;
          }
          return 2;
        }
        cVar1 = *pcVar5;
        pcVar4 = pcVar4 + -1;
        pcVar5 = pcVar5 + 1;
      } while (cVar1 == *pcVar3);
    }
    break;
  case 'p':
    pcVar4 = (char *)param_1[1];
    lVar2 = (long)pcVar4 - (long)pcVar3;
    if (pcVar4 != pcVar3) {
      pcVar4 = pcVar4 + ~(ulong)pcVar3;
      pcVar5 = "processing-instruction";
                    /* try { // try from 005493e8 to 006493ef has its CatchHandler @ 005493f0 */
      do {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 005493e8 with catch @ 005493f0
                        */
        pcVar5 = pcVar5 + 1;
        pcVar3 = pcVar3 + 1;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 005493d0 with catch @ 005493f4
                        */
        if (pcVar4 == (char *)0x0) {
          if (lVar2 != 0x16) {
            return 0;
          }
          return 4;
        }
        pcVar4 = pcVar4 + -1;
                    /* catch() { ... } // from try @ 00549488 with catch @ 00549408 */
      } while (*pcVar5 == *pcVar3);
    }
    break;
  case 't':
    pcVar4 = (char *)param_1[1];
    lVar2 = (long)pcVar4 - (long)pcVar3;
    if (pcVar4 != pcVar3) {
      pcVar4 = pcVar4 + ~(ulong)pcVar3;
      pcVar5 = "ext";
      do {
        pcVar3 = pcVar3 + 1;
        if (pcVar4 == (char *)0x0) {
                    /* try { // try from 0054947c to 00649487 has its CatchHandler @ 005494ec */
          if (lVar2 != 4) {
            return 0;
          }
                    /* try { // try from 00549488 to 0064952f has its CatchHandler @ 00549408 */
          return 5;
        }
        cVar1 = *pcVar5;
        pcVar4 = pcVar4 + -1;
        pcVar5 = pcVar5 + 1;
      } while (cVar1 == *pcVar3);
    }
  }
  return 0;
}



// ===== FUN_00549494 @ 00549494 size=6300 =====

long * FUN_00549494(undefined8 *param_1)

{
  undefined8 *puVar1;
  byte bVar2;
  long lVar3;
  int iVar4;
  byte *pbVar5;
  undefined8 uVar6;
  long lVar7;
  char *pcVar8;
  long *plVar9;
  void *pvVar10;
  undefined4 uVar11;
  bool bVar12;
  char cVar13;
  uint uVar14;
  byte *pbVar15;
  byte *pbVar16;
  char *pcVar17;
  char *pcVar18;
  undefined2 uVar19;
  uint uVar20;
  char *pcVar21;
  char *pcVar22;
  size_t __n;
  ulong uVar23;
  ulong uVar24;
  undefined4 *puVar25;
  long *plVar26;
  long *plVar27;
  long lVar28;
  double dVar29;
  long local_70;
  long lStack_68;
  long local_58;
  
  lVar3 = tpidr_el0;
  local_58 = *(long *)(lVar3 + 0x28);
  if (9 < *(int *)(param_1 + 5) - 0xbU) {
switchD_005494e8_caseD_d:
                    /* WARNING: Subroutine does not return */
    FUN_00548800(param_1,"Unrecognizable primary expression");
  }
  puVar1 = param_1 + 1;
  switch(*(int *)(param_1 + 5)) {
  case 0xb:
                    /* catch() { ... } // from try @ 0054947c with catch @ 005494ec */
    lVar28 = param_1[7];
    if (lVar28 == 0) {
                    /* try { // try from 0054acf8 to 0064ad03 has its CatchHandler @ 0054ad88 */
                    /* WARNING: Subroutine does not return */
      FUN_00548800(param_1,"Unknown variable: variable set is not provided");
    }
    pvVar10 = (void *)param_1[3];
    uVar23 = param_1[4] - (long)pvVar10;
    pbVar5 = (byte *)(param_1 + 9);
    if ((0x1f < uVar23) &&
       (pbVar5 = (byte *)(*(code *)PTR_malloc_006f1270)(uVar23 + 1), pbVar5 == (byte *)0x0)) {
LAB_0054ace0:
                    /* try { // try from 0054ace4 to 0064acef has its CatchHandler @ 0054adac */
                    /* WARNING: Subroutine does not return */
      FUN_00548800(param_1,"Unknown variable: variable set does not contain the given name");
    }
                    /* try { // try from 00549530 to 006495b3 has its CatchHandler @ 00549530
                       catch(type#1 @ 00000000) { ... } // from try @ 00549530 with catch @ 00549530
                       catch(type#1 @ 00000000) { ... } // from try @ 005496a0 with catch @ 00549530
                       catch(type#1 @ 00000000) { ... } // from try @ 005496d8 with catch @ 00549530
                        */
    memcpy(pbVar5,pvVar10,uVar23);
    pbVar5[uVar23] = 0;
    uVar14 = (uint)*pbVar5;
    if (*pbVar5 == 0) {
      uVar20 = 0;
    }
    else {
      uVar20 = 0;
      pbVar16 = pbVar5;
      do {
        pbVar16 = pbVar16 + 1;
        iVar4 = uVar20 + uVar14;
        uVar14 = (uint)*pbVar16;
        uVar20 = iVar4 * 0x401;
        uVar20 = uVar20 ^ uVar20 >> 6;
      } while (uVar14 != 0);
      uVar20 = uVar20 * 9;
    }
    for (puVar25 = *(undefined4 **)(lVar28 + (ulong)((uVar20 ^ uVar20 >> 0xb) & 0x3f) * 8);
        puVar25 != (undefined4 *)0x0; puVar25 = *(undefined4 **)(puVar25 + 2)) {
      switch(*puVar25) {
      case 1:
        pcVar8 = (char *)(puVar25 + 0xe);
        break;
      case 2:
      case 3:
                    /* catch() { ... } // from try @ 00549798 with catch @ 00549800 */
        pcVar8 = (char *)(puVar25 + 6);
        break;
      case 4:
        pcVar8 = (char *)((long)puVar25 + 0x11);
        break;
      default:
        pcVar8 = (char *)0x0;
      }
      iVar4 = strcmp(pcVar8,(char *)pbVar5);
      if (iVar4 == 0) break;
    }
    if (pbVar5 != (byte *)(param_1 + 9)) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00549904 with catch @ 00549844
                       catch(type#1 @ 00000000) { ... } // from try @ 005499c0 with catch @ 00549844
                        */
      (*(code *)PTR_free_006f1268)(pbVar5);
    }
    if (puVar25 == (undefined4 *)0x0) goto LAB_0054ace0;
    FUN_00548530(puVar1);
    plVar27 = (long *)*param_1;
    uVar23 = plVar27[1] + 0x28;
    if (*(ulong *)(*plVar27 + 8) < uVar23) {
      plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar9 == (long *)0x0) goto LAB_0054accc;
      *plVar9 = *plVar27;
      plVar9[1] = 0x1000;
      *plVar27 = (long)plVar9;
      plVar27[1] = 0x28;
    }
    else {
      plVar9 = (long *)(*plVar27 + plVar27[1]);
      plVar27[1] = uVar23;
    }
    plVar26 = plVar9 + 2;
    uVar11 = *puVar25;
    *(undefined2 *)((long)plVar9 + 0x12) = 0;
    plVar9[3] = 0;
    plVar9[4] = 0;
    *(char *)plVar26 = '\x14';
    *(char *)((long)plVar9 + 0x11) = (char)uVar11;
    plVar9[5] = 0;
    plVar9[6] = (long)puVar25;
                    /* try { // try from 005498c4 to 00649903 has its CatchHandler @ 00549978 */
    goto LAB_00549a20;
  case 0xc:
    FUN_00548530(puVar1);
    uVar6 = FUN_005489d0(param_1);
    plVar26 = (long *)FUN_00548854(param_1,uVar6,0);
    if (*(int *)(param_1 + 5) != 0xd) {
                    /* WARNING: Subroutine does not return */
      FUN_00548800(param_1,"Unmatched braces");
    }
    break;
  default:
    goto switchD_005494e8_caseD_d;
  case 0xe:
    pvVar10 = (void *)param_1[3];
    if (pvVar10 == (void *)0x0) {
      plVar27 = (long *)0x0;
    }
    else {
                    /* try { // try from 00549638 to 00649643 has its CatchHandler @ 005496bc */
      plVar26 = (long *)*param_1;
      __n = param_1[4] - (long)pvVar10;
      uVar24 = __n + 8 & 0xfffffffffffffff8;
                    /* try { // try from 00549650 to 00649657 has its CatchHandler @ 005496b8 */
      uVar23 = uVar24 + plVar26[1];
      if (*(ulong *)(*plVar26 + 8) < uVar23) {
        uVar23 = uVar24 + 0x400;
        if (uVar23 < 0x1001) {
          uVar23 = 0x1000;
        }
        plVar27 = (long *)(*(code *)PTR_malloc_006f1270)(uVar23 + 0x10);
        if (plVar27 == (long *)0x0) goto LAB_0054accc;
        *plVar27 = *plVar26;
        plVar27[1] = uVar23;
        *plVar26 = (long)plVar27;
        plVar26[1] = uVar24;
        pvVar10 = (void *)param_1[3];
                    /* try { // try from 00549698 to 0064969f has its CatchHandler @ 005496a4 */
      }
      else {
        plVar27 = (long *)(*plVar26 + plVar26[1]);
        plVar26[1] = uVar23;
      }
      plVar27 = plVar27 + 2;
      memcpy(plVar27,pvVar10,__n);
      *(undefined1 *)((long)plVar27 + __n) = 0;
    }
    plVar26 = (long *)*param_1;
                    /* try { // try from 005499bc to 006499bf has its CatchHandler @ 005499f8 */
                    /* try { // try from 005499c0 to 006499fb has its CatchHandler @ 00549844 */
    uVar23 = plVar26[1] + 0x28;
    if (*(ulong *)(*plVar26 + 8) < uVar23) {
      plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar9 == (long *)0x0) goto LAB_0054accc;
      *plVar9 = *plVar26;
      plVar9[1] = 0x1000;
      *plVar26 = (long)plVar9;
      plVar26[1] = 0x28;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 005499bc with catch @ 005499f8
                        */
    }
    else {
                    /* catch() { ... } // from try @ 00549af4 with catch @ 005499fc */
      plVar9 = (long *)(*plVar26 + plVar26[1]);
      plVar26[1] = uVar23;
    }
    plVar26 = plVar9 + 2;
    plVar9[3] = 0;
    plVar9[4] = 0;
    *(undefined4 *)plVar26 = 0x312;
    plVar9[5] = 0;
    plVar9[6] = (long)plVar27;
    break;
  case 0xf:
    pvVar10 = (void *)param_1[3];
    uVar23 = param_1[4] - (long)pvVar10;
    pbVar5 = (byte *)(param_1 + 9);
    if ((0x1f < uVar23) &&
       (pbVar5 = (byte *)(*(code *)PTR_malloc_006f1270)(uVar23 + 1), pbVar5 == (byte *)0x0))
    goto LAB_0054accc;
    memcpy(pbVar5,pvVar10,uVar23);
    pbVar5[uVar23] = 0;
    pbVar16 = pbVar5;
    do {
      pbVar15 = pbVar16;
                    /* try { // try from 005495b4 to 006495e7 has its CatchHandler @ 005496e0 */
      pbVar16 = pbVar15 + 1;
    } while (((byte)(&DAT_005e1396)[*pbVar15] >> 3 & 1) != 0);
    if (*pbVar15 != 0x2d) {
      pbVar16 = pbVar15;
    }
    bVar2 = *pbVar16;
    if ((ulong)bVar2 == 0) {
LAB_0054990c:
      dVar29 = NAN;
    }
    else {
      if (9 < (ulong)bVar2 - 0x30) {
        if ((bVar2 == 0x2e) && ((ulong)pbVar16[1] - 0x30 < 10)) goto LAB_005498e0;
        goto LAB_0054990c;
      }
      do {
        pbVar16 = pbVar16 + 1;
        uVar23 = (ulong)*pbVar16;
      } while (uVar23 - 0x30 < 10);
      if (*pbVar16 == 0x2e) {
LAB_005498e0:
        do {
          pbVar16 = pbVar16 + 1;
          uVar23 = (ulong)*pbVar16;
        } while (uVar23 - 0x30 < 10);
      }
      bVar2 = (&DAT_005e1396)[uVar23];
      while ((bVar2 >> 3 & 1) != 0) {
        pbVar16 = pbVar16 + 1;
        uVar23 = (ulong)*pbVar16;
        bVar2 = (&DAT_005e1396)[uVar23];
                    /* try { // try from 00549904 to 006499bb has its CatchHandler @ 00549844 */
      }
      if ((int)uVar23 != 0) goto LAB_0054990c;
      dVar29 = atof((char *)pbVar5);
    }
    if (pbVar5 != (byte *)(param_1 + 9)) {
      (*(code *)PTR_free_006f1268)(pbVar5);
    }
    plVar27 = (long *)*param_1;
    uVar23 = plVar27[1] + 0x28;
    if (*(ulong *)(*plVar27 + 8) < uVar23) {
      plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar9 == (long *)0x0) {
LAB_0054accc:
                    /* WARNING: Subroutine does not return */
        FUN_00548f50();
      }
      *plVar9 = *plVar27;
      plVar9[1] = 0x1000;
      *plVar27 = (long)plVar9;
      plVar27[1] = 0x28;
    }
    else {
      plVar9 = (long *)(*plVar27 + plVar27[1]);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 005498c4 with catch @ 00549978
                        */
      plVar27[1] = uVar23;
    }
    plVar26 = plVar9 + 2;
    plVar9[4] = 0;
    plVar9[5] = 0;
    plVar9[3] = 0;
    *(undefined4 *)plVar26 = 0x213;
    plVar9[6] = (long)dVar29;
    break;
  case 0x14:
    local_70 = 0;
    lStack_68 = 0;
                    /* try { // try from 005496a0 to 006496cb has its CatchHandler @ 00549530 */
    pcVar18 = (char *)param_1[3];
    pcVar8 = (char *)param_1[4];
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00549698 with catch @ 005496a4
                        */
    FUN_00548530(puVar1);
    if (*(int *)(param_1 + 5) != 0xc) {
                    /* try { // try from 0054ad10 to 0064ad17 has its CatchHandler @ 0054ad84 */
                    /* try { // try from 0054ad18 to 0064ad63 has its CatchHandler @ 0054ac28 */
                    /* WARNING: Subroutine does not return */
      FUN_00548800(param_1,"Unrecognized function call");
    }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00549650 with catch @ 005496b8
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 00549638 with catch @ 005496bc
                        */
    FUN_00548530(puVar1);
    iVar4 = *(int *)(param_1 + 5);
    if (iVar4 != 0xd) {
                    /* try { // try from 005496d8 to 0064972b has its CatchHandler @ 00549530 */
      uVar6 = FUN_005489d0(param_1);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 005496cc with catch @ 005496dc
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 005495b4 with catch @ 005496e0
                        */
      local_70 = FUN_00548854(param_1,uVar6,0);
    }
    uVar23 = (ulong)(iVar4 != 0xd);
    plVar27 = (long *)((ulong)&local_70 | uVar23 << 3);
    lVar28 = 0;
    while (*(int *)(param_1 + 5) != 0xd) {
      if (*(int *)(param_1 + 5) != 0x15) {
                    /* WARNING: Subroutine does not return */
        FUN_00548800(param_1,"No comma between function arguments");
      }
      FUN_00548530(puVar1);
      uVar6 = FUN_005489d0(param_1);
                    /* catch() { ... } // from try @ 005497a4 with catch @ 0054972c */
      lVar7 = FUN_00548854(param_1,uVar6,0);
      plVar26 = plVar27;
      if (1 < uVar23) {
        plVar26 = (long *)(lVar28 + 0x18);
      }
      uVar23 = uVar23 + 1;
      *plVar26 = lVar7;
      plVar27 = plVar27 + 1;
      lVar28 = lVar7;
    }
    FUN_00548530(puVar1);
    switch(*pcVar18) {
    case 'b':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
                    /* try { // try from 00549798 to 006497a3 has its CatchHandler @ 00549800 */
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "boolean";
        do {
          pcVar21 = pcVar21 + 1;
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
            if ((lVar28 == 7) && (uVar23 == 1)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x42d;
LAB_0054ac3c:
              plVar26[3] = 0;
              *(undefined4 *)plVar26 = uVar11;
LAB_0054ac44:
              plVar26[1] = local_70;
              plVar26[2] = 0;
              goto LAB_00549a20;
            }
            break;
          }
                    /* try { // try from 005497a4 to 00649843 has its CatchHandler @ 0054972c */
          pcVar8 = pcVar8 + -1;
        } while (*pcVar21 == *pcVar18);
      }
      break;
    case 'c':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "ount";
        pcVar17 = pcVar18;
        do {
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 5) && (uVar23 == 1)) {
              if (*(char *)(local_70 + 1) != '\x01') {
LAB_0054ad20:
                    /* WARNING: Subroutine does not return */
                FUN_00548800(param_1,&DAT_005e10bb);
              }
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x217;
              goto LAB_0054ac3c;
            }
            break;
          }
          cVar13 = *pcVar22;
          pcVar21 = pcVar21 + -1;
          pcVar22 = pcVar22 + 1;
        } while (cVar13 == *pcVar17);
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "ontains";
        pcVar17 = pcVar18;
        do {
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 8) && (uVar23 == 2)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x423;
              goto LAB_0054ac78;
            }
            break;
          }
          cVar13 = *pcVar22;
          pcVar21 = pcVar21 + -1;
          pcVar22 = pcVar22 + 1;
        } while (cVar13 == *pcVar17);
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "concat";
        pcVar17 = pcVar18;
        do {
          pcVar22 = pcVar22 + 1;
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 6) && (1 < uVar23)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x321;
                    /* catch() { ... } // from try @ 0054ab74 with catch @ 0054abe4 */
LAB_0054ac78:
              *(undefined4 *)plVar26 = uVar11;
LAB_0054ac7c:
              plVar26[2] = lStack_68;
              plVar26[1] = local_70;
              plVar26[3] = 0;
              goto LAB_00549a20;
            }
            break;
          }
          pcVar21 = pcVar21 + -1;
        } while (*pcVar22 == *pcVar17);
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "ceiling";
        do {
          pcVar21 = pcVar21 + 1;
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
            if (lVar28 == 7 && uVar23 == 1) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
                    /* try { // try from 0054a61c to 0064a70b has its CatchHandler @ 0054a61c
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a61c with catch @ 0054a61c
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a744 with catch @ 0054a61c
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a794 with catch @ 0054a61c
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a828 with catch @ 0054a61c
                        */
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x236;
              goto LAB_0054ac3c;
            }
            break;
          }
          pcVar8 = pcVar8 + -1;
        } while (*pcVar21 == *pcVar18);
      }
      break;
    case 'f':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "alse";
        pcVar17 = pcVar18;
        do {
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 5) && (uVar23 == 0)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x430;
LAB_0054aa20:
              plVar26[2] = 0;
              plVar26[3] = 0;
              *(undefined4 *)plVar26 = uVar11;
              plVar26[1] = 0;
              goto LAB_00549a20;
            }
            break;
          }
          cVar13 = *pcVar22;
                    /* try { // try from 00549acc to 00649af3 has its CatchHandler @ 00549b9c */
          pcVar21 = pcVar21 + -1;
          pcVar22 = pcVar22 + 1;
        } while (cVar13 == *pcVar17);
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "floor";
        do {
          pcVar21 = pcVar21 + 1;
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
            if ((lVar28 == 5) && (uVar23 == 1)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x235;
              goto LAB_0054ac3c;
            }
            break;
          }
                    /* catch() { ... } // from try @ 00549e1c with catch @ 00549f30 */
          pcVar8 = pcVar8 + -1;
        } while (*pcVar21 == *pcVar18);
      }
      break;
    case 'i':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "d";
        do {
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
                    /* catch() { ... } // from try @ 00549e38 with catch @ 00549d90 */
            if ((lVar28 == 2) && (uVar23 == 1)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x118;
              goto LAB_0054ac3c;
            }
            break;
          }
          cVar13 = *pcVar21;
          pcVar8 = pcVar8 + -1;
          pcVar21 = pcVar21 + 1;
        } while (cVar13 == *pcVar18);
      }
      break;
    case 'l':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "ast";
        pcVar17 = pcVar18;
        do {
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 4) && (uVar23 == 0)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x215;
              goto LAB_0054aa20;
            }
            break;
          }
          cVar13 = *pcVar22;
          pcVar21 = pcVar21 + -1;
          pcVar22 = pcVar22 + 1;
        } while (cVar13 == *pcVar17);
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "ang";
        pcVar17 = pcVar18;
        do {
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 4) && (uVar23 == 1)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
                    /* try { // try from 0054a44c to 0064a453 has its CatchHandler @ 0054a488 */
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                    /* try { // try from 0054a454 to 0064a48f has its CatchHandler @ 0054a2fc */
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x431;
              goto LAB_0054ac3c;
            }
            break;
          }
          cVar13 = *pcVar22;
          pcVar21 = pcVar21 + -1;
          pcVar22 = pcVar22 + 1;
        } while (cVar13 == *pcVar17);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a3b8 with catch @ 0054a48c
                        */
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "local-name";
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a44c with catch @ 0054a488
                        */
                    /* try { // try from 0054a490 to 0064a497 has its CatchHandler @ 0054a4a0 */
LAB_0054a494:
        pcVar21 = pcVar21 + 1;
        pcVar18 = pcVar18 + 1;
        if (pcVar8 != (char *)0x0) goto LAB_0054a498;
        if ((lVar28 == 10) && (uVar23 < 2)) {
          if ((uVar23 == 1) && (*(char *)(local_70 + 1) != '\x01')) goto LAB_0054ad20;
          plVar27 = (long *)*param_1;
          uVar24 = plVar27[1] + 0x28;
          if (*(ulong *)(*plVar27 + 8) < uVar24) {
            plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
            if (plVar9 == (long *)0x0) goto LAB_0054accc;
            *plVar9 = *plVar27;
            plVar9[1] = 0x1000;
            *plVar27 = (long)plVar9;
            plVar27[1] = 0x28;
          }
          else {
                    /* try { // try from 0054a744 to 0064a78b has its CatchHandler @ 0054a61c */
            plVar9 = (long *)(*plVar27 + plVar27[1]);
            plVar27[1] = uVar24;
          }
          plVar26 = plVar9 + 2;
          uVar19 = 3;
          *(undefined1 *)((long)plVar9 + 0x13) = 0;
          plVar9[5] = 0;
          cVar13 = '\x19';
          if (uVar23 != 0) {
            cVar13 = '\x1a';
          }
LAB_0054ab98:
          *(undefined2 *)((long)plVar26 + 1) = uVar19;
          *(char *)plVar26 = cVar13;
          goto LAB_0054ac44;
        }
        break;
      }
      break;
    case 'n':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "ame";
        pcVar17 = pcVar18;
        do {
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 4) && (uVar23 < 2)) {
              if ((uVar23 == 1) && (*(char *)(local_70 + 1) != '\x01')) goto LAB_0054ad20;
              plVar27 = (long *)*param_1;
              uVar24 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar24) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar24;
              }
              plVar26 = plVar26 + 2;
                    /* try { // try from 0054a9e8 to 0064aaab has its CatchHandler @ 0054a9e8
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a9e8 with catch @ 0054a9e8
                        */
              cVar13 = '\x1d';
              goto LAB_0054ab68;
            }
            break;
          }
          cVar13 = *pcVar22;
          pcVar21 = pcVar21 + -1;
          pcVar22 = pcVar22 + 1;
        } while (cVar13 == *pcVar17);
        bVar12 = uVar23 < 2;
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "namespace-uri";
        pcVar17 = pcVar18;
LAB_0054a0cc:
        pcVar22 = pcVar22 + 1;
        pcVar17 = pcVar17 + 1;
        if (pcVar21 != (char *)0x0) goto code_r0x0054a0d0;
                    /* try { // try from 0054a2fc to 0064a3b7 has its CatchHandler @ 0054a2fc
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a2fc with catch @ 0054a2fc
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a454 with catch @ 0054a2fc
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a498 with catch @ 0054a2fc
                        */
        if (lVar28 == 0xd && bVar12) {
          if ((uVar23 == 1) && (*(char *)(local_70 + 1) != '\x01')) goto LAB_0054ad20;
          plVar27 = (long *)*param_1;
          uVar24 = plVar27[1] + 0x28;
          if (*(ulong *)(*plVar27 + 8) < uVar24) {
            plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
            if (plVar26 == (long *)0x0) goto LAB_0054accc;
            *plVar26 = *plVar27;
            plVar26[1] = 0x1000;
            *plVar27 = (long)plVar26;
            plVar27[1] = 0x28;
          }
          else {
            plVar26 = (long *)(*plVar27 + plVar27[1]);
            plVar27[1] = uVar24;
          }
          plVar26 = plVar26 + 2;
          cVar13 = '\x1b';
LAB_0054ab68:
          uVar19 = 3;
          goto LAB_0054ab8c;
        }
        goto LAB_0054a360;
      }
      break;
    case 'p':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
                    /* catch() { ... } // from try @ 00549acc with catch @ 00549b9c */
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "osition";
        do {
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
            if ((lVar28 == 8) && (uVar23 == 0)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar9 == (long *)0x0) goto LAB_0054accc;
                plVar26 = plVar9 + 2;
                *plVar9 = *plVar27;
                plVar9[1] = 0x1000;
                *plVar27 = (long)plVar9;
                plVar27[1] = 0x28;
                uVar11 = 0x216;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1] + 0x10);
                plVar27[1] = uVar23;
                uVar11 = 0x216;
              }
              goto LAB_0054aa20;
            }
            break;
          }
          cVar13 = *pcVar21;
          pcVar8 = pcVar8 + -1;
          pcVar21 = pcVar21 + 1;
        } while (cVar13 == *pcVar18);
      }
      break;
    case 'r':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
                    /* try { // try from 00549af4 to 00649bdf has its CatchHandler @ 005499fc */
        pcVar21 = "ound";
        do {
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
            if ((lVar28 == 5) && (uVar23 == 1)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x237;
              goto LAB_0054ac3c;
            }
            break;
          }
          cVar13 = *pcVar21;
          pcVar8 = pcVar8 + -1;
          pcVar21 = pcVar21 + 1;
        } while (cVar13 == *pcVar18);
      }
      break;
    case 's':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "tring";
        pcVar17 = pcVar18;
        do {
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 6) && (uVar23 < 2)) {
              plVar27 = (long *)*param_1;
              uVar24 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar24) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar24;
              }
              plVar26 = plVar26 + 2;
              cVar13 = '\x1f';
              goto LAB_0054ab68;
            }
            break;
          }
          cVar13 = *pcVar22;
          pcVar21 = pcVar21 + -1;
          pcVar22 = pcVar22 + 1;
        } while (cVar13 == *pcVar17);
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "string-length";
        pcVar17 = pcVar18;
        do {
          pcVar22 = pcVar22 + 1;
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if (lVar28 == 0xd && uVar23 < 2) {
              plVar27 = (long *)*param_1;
              uVar24 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar24) {
                    /* try { // try from 0054a3b8 to 0064a443 has its CatchHandler @ 0054a48c */
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                    /* try { // try from 0054ab74 to 0064ab7f has its CatchHandler @ 0054abe4 */
                plVar27[1] = uVar24;
              }
                    /* try { // try from 0054ab80 to 0064ac27 has its CatchHandler @ 0054aae4 */
              cVar13 = '(';
              goto LAB_0054ab88;
            }
            break;
          }
          pcVar21 = pcVar21 + -1;
        } while (*pcVar22 == *pcVar17);
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "starts-with";
        pcVar17 = pcVar18;
        do {
          pcVar22 = pcVar22 + 1;
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 0xb) && (uVar23 == 2)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                    /* try { // try from 0054a70c to 0064a713 has its CatchHandler @ 0054a7dc */
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x422;
              goto LAB_0054ac78;
            }
            break;
          }
          pcVar21 = pcVar21 + -1;
        } while (*pcVar22 == *pcVar17);
        bVar12 = uVar23 != 2;
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "substring-before";
        pcVar17 = pcVar18;
        do {
          pcVar22 = pcVar22 + 1;
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if (lVar28 == 0x10 && !bVar12) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x324;
              goto LAB_0054ac78;
            }
            break;
          }
          pcVar21 = pcVar21 + -1;
                    /* try { // try from 0054a738 to 0064a743 has its CatchHandler @ 0054a7c0 */
        } while (*pcVar22 == *pcVar17);
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "substring-after";
        pcVar17 = pcVar18;
        do {
          pcVar22 = pcVar22 + 1;
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
                    /* try { // try from 0054a8f8 to 0064a8ff has its CatchHandler @ 0054a91c */
            if (lVar28 == 0xf && !bVar12) {
              plVar27 = (long *)*param_1;
                    /* try { // try from 0054a910 to 0064a917 has its CatchHandler @ 0054a918 */
              uVar23 = plVar27[1] + 0x28;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a910 with catch @ 0054a918
                        */
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a8f8 with catch @ 0054a91c
                        */
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x325;
              goto LAB_0054ac78;
            }
            break;
          }
          pcVar21 = pcVar21 + -1;
        } while (*pcVar22 == *pcVar17);
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "substring";
        pcVar17 = pcVar18;
        do {
          pcVar22 = pcVar22 + 1;
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 9) && ((uVar23 | 1) == 3)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar9 == (long *)0x0) goto LAB_0054accc;
                *plVar9 = *plVar27;
                plVar9[1] = 0x1000;
                *plVar27 = (long)plVar9;
                plVar27[1] = 0x28;
              }
              else {
                plVar9 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              *(undefined1 *)((long)plVar9 + 0x13) = 0;
              cVar13 = '&';
              if (bVar12) {
                cVar13 = '\'';
              }
              goto LAB_0054acac;
            }
            break;
          }
          pcVar21 = pcVar21 + -1;
        } while (*pcVar22 == *pcVar17);
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "um";
        do {
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054aac4 with catch @ 0054aacc
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054aaac with catch @ 0054aad0
                        */
            if ((lVar28 == 3) && (uVar23 == 1)) {
                    /* catch() { ... } // from try @ 0054ab80 with catch @ 0054aae4 */
              if (*(char *)(local_70 + 1) != '\x01') goto LAB_0054ad20;
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar9 == (long *)0x0) goto LAB_0054accc;
                plVar26 = plVar9 + 2;
                *plVar9 = *plVar27;
                plVar9[1] = 0x1000;
                *plVar27 = (long)plVar9;
                plVar27[1] = 0x28;
                uVar11 = 0x234;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1] + 0x10);
                plVar27[1] = uVar23;
                uVar11 = 0x234;
              }
              goto LAB_0054ac3c;
            }
            break;
          }
          cVar13 = *pcVar21;
                    /* try { // try from 0054aaac to 0064aab3 has its CatchHandler @ 0054aad0 */
          pcVar8 = pcVar8 + -1;
          pcVar21 = pcVar21 + 1;
        } while (cVar13 == *pcVar18);
      }
      break;
    case 't':
      lVar28 = (long)pcVar8 - (long)pcVar18;
      if (pcVar8 != pcVar18) {
        pcVar21 = pcVar8 + ~(ulong)pcVar18;
        pcVar22 = "translate";
        pcVar17 = pcVar18;
        do {
          pcVar22 = pcVar22 + 1;
          pcVar17 = pcVar17 + 1;
          if (pcVar21 == (char *)0x0) {
            if ((lVar28 == 9) && (uVar23 == 3)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                    /* try { // try from 00549e1c to 00649e37 has its CatchHandler @ 00549f30 */
                if (plVar26 == (long *)0x0) goto LAB_0054accc;
                *plVar26 = *plVar27;
                plVar26[1] = 0x1000;
                *plVar27 = (long)plVar26;
                plVar27[1] = 0x28;
                    /* try { // try from 00549e38 to 00649f73 has its CatchHandler @ 00549d90 */
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1]);
                plVar27[1] = uVar23;
              }
              plVar26 = plVar26 + 2;
              uVar11 = 0x32c;
              goto LAB_0054ac78;
            }
            break;
          }
          pcVar21 = pcVar21 + -1;
        } while (*pcVar22 == *pcVar17);
        pcVar8 = pcVar8 + ~(ulong)pcVar18;
        pcVar21 = "rue";
        do {
          pcVar18 = pcVar18 + 1;
          if (pcVar8 == (char *)0x0) {
            if ((lVar28 == 4) && (uVar23 == 0)) {
              plVar27 = (long *)*param_1;
              uVar23 = plVar27[1] + 0x28;
              if (*(ulong *)(*plVar27 + 8) < uVar23) {
                plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                if (plVar9 == (long *)0x0) goto LAB_0054accc;
                plVar26 = plVar9 + 2;
                *plVar9 = *plVar27;
                plVar9[1] = 0x1000;
                *plVar27 = (long)plVar9;
                plVar27[1] = 0x28;
                uVar11 = 0x42f;
              }
              else {
                plVar26 = (long *)(*plVar27 + plVar27[1] + 0x10);
                plVar27[1] = uVar23;
                uVar11 = 0x42f;
              }
              goto LAB_0054aa20;
            }
            break;
          }
          cVar13 = *pcVar21;
          pcVar8 = pcVar8 + -1;
          pcVar21 = pcVar21 + 1;
        } while (cVar13 == *pcVar18);
      }
    }
switchD_00549780_caseD_64:
                    /* WARNING: Subroutine does not return */
                    /* try { // try from 0054aac4 to 0064aacb has its CatchHandler @ 0054aacc */
    FUN_00548800(param_1,&DAT_005e118b);
  }
  FUN_00548530(puVar1);
LAB_00549a20:
  if (*(long *)(lVar3 + 0x28) == local_58) {
    return plVar26;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
code_r0x0054a0d0:
  pcVar21 = pcVar21 + -1;
  if (*pcVar22 != *pcVar17) goto LAB_0054a360;
  goto LAB_0054a0cc;
LAB_0054a360:
  pcVar21 = pcVar8 + ~(ulong)pcVar18;
  pcVar22 = "normalize-space";
  pcVar17 = pcVar18;
LAB_0054a374:
  pcVar22 = pcVar22 + 1;
  pcVar17 = pcVar17 + 1;
  if (pcVar21 != (char *)0x0) goto code_r0x0054a378;
  if (lVar28 == 0xf && bVar12) {
    plVar27 = (long *)*param_1;
    uVar24 = plVar27[1] + 0x28;
    if (*(ulong *)(*plVar27 + 8) < uVar24) {
      plVar9 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
      if (plVar9 == (long *)0x0) goto LAB_0054accc;
      *plVar9 = *plVar27;
      plVar9[1] = 0x1000;
      *plVar27 = (long)plVar9;
      plVar27[1] = 0x28;
    }
    else {
      plVar9 = (long *)(*plVar27 + plVar27[1]);
      plVar27[1] = uVar24;
    }
    cVar13 = '*';
    if (uVar23 != 0) {
      cVar13 = '+';
    }
    *(undefined1 *)((long)plVar9 + 0x13) = 0;
LAB_0054acac:
    plVar26 = plVar9 + 2;
    *(undefined2 *)((long)plVar9 + 0x11) = 3;
    *(char *)plVar26 = cVar13;
    goto LAB_0054ac7c;
  }
  goto LAB_0054a684;
code_r0x0054a378:
  pcVar21 = pcVar21 + -1;
  if (*pcVar22 != *pcVar17) goto LAB_0054a684;
  goto LAB_0054a374;
LAB_0054a684:
  pcVar21 = pcVar8 + ~(ulong)pcVar18;
  pcVar22 = "ot";
  pcVar17 = pcVar18;
  do {
    pcVar17 = pcVar17 + 1;
    if (pcVar21 == (char *)0x0) {
      if ((lVar28 == 3) && (uVar23 == 1)) {
        plVar27 = (long *)*param_1;
                    /* try { // try from 0054a78c to 0064a793 has its CatchHandler @ 0054a7d8 */
        uVar23 = plVar27[1] + 0x28;
                    /* try { // try from 0054a794 to 0064a81f has its CatchHandler @ 0054a61c */
        if (*(ulong *)(*plVar27 + 8) < uVar23) {
          plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
          if (plVar26 == (long *)0x0) goto LAB_0054accc;
          *plVar26 = *plVar27;
          plVar26[1] = 0x1000;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a738 with catch @ 0054a7c0
                        */
          *plVar27 = (long)plVar26;
          plVar27[1] = 0x28;
        }
        else {
                    /* try { // try from 0054ac28 to 0064ace3 has its CatchHandler @ 0054ac28
                       catch(type#1 @ 00000000) { ... } // from try @ 0054ac28 with catch @ 0054ac28
                       catch(type#1 @ 00000000) { ... } // from try @ 0054ad18 with catch @ 0054ac28
                       catch(type#1 @ 00000000) { ... } // from try @ 0054ad6c with catch @ 0054ac28
                       catch(type#1 @ 00000000) { ... } // from try @ 0054ada4 with catch @ 0054ac28
                        */
          plVar26 = (long *)(*plVar27 + plVar27[1]);
          plVar27[1] = uVar23;
        }
        plVar26 = plVar26 + 2;
        uVar11 = 0x42e;
        goto LAB_0054ac3c;
      }
      break;
    }
    cVar13 = *pcVar22;
    pcVar21 = pcVar21 + -1;
    pcVar22 = pcVar22 + 1;
  } while (cVar13 == *pcVar17);
  pcVar8 = pcVar8 + ~(ulong)pcVar18;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a78c with catch @ 0054a7d8
                        */
  pcVar21 = "umber";
LAB_0054a7dc:
  pcVar18 = pcVar18 + 1;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a70c with catch @ 0054a7dc
                        */
  if (pcVar8 != (char *)0x0) goto code_r0x0054a7e0;
  if (lVar28 == 6 && bVar12) {
    plVar27 = (long *)*param_1;
    uVar24 = plVar27[1] + 0x28;
                    /* try { // try from 0054a820 to 0064a827 has its CatchHandler @ 0054a830 */
    if (*(ulong *)(*plVar27 + 8) < uVar24) {
                    /* try { // try from 0054a828 to 0064a833 has its CatchHandler @ 0054a61c */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a820 with catch @ 0054a830
                        */
      plVar26 = (long *)(*(code *)PTR_malloc_006f1270)(0x1010);
                    /* try { // try from 0054a834 to 0064a8f7 has its CatchHandler @ 0054a834
                       catch(type#1 @ 00000000) { ... } // from try @ 0054a834 with catch @ 0054a834
                        */
      if (plVar26 == (long *)0x0) goto LAB_0054accc;
      *plVar26 = *plVar27;
      plVar26[1] = 0x1000;
      *plVar27 = (long)plVar26;
      plVar27[1] = 0x28;
    }
    else {
      plVar26 = (long *)(*plVar27 + plVar27[1]);
      plVar27[1] = uVar24;
    }
    cVar13 = '2';
LAB_0054ab88:
    plVar26 = plVar26 + 2;
    uVar19 = 2;
LAB_0054ab8c:
    if (uVar23 != 0) {
      cVar13 = cVar13 + '\x01';
    }
    *(char *)((long)plVar26 + 3) = '\0';
    plVar26[3] = 0;
    goto LAB_0054ab98;
  }
  goto switchD_00549780_caseD_64;
code_r0x0054a7e0:
  cVar13 = *pcVar21;
  pcVar8 = pcVar8 + -1;
  pcVar21 = pcVar21 + 1;
  if (cVar13 != *pcVar18) goto switchD_00549780_caseD_64;
  goto LAB_0054a7dc;
LAB_0054a498:
                    /* try { // try from 0054a498 to 0064a4a3 has its CatchHandler @ 0054a2fc */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0054a490 with catch @ 0054a4a0
                        */
  pcVar8 = pcVar8 + -1;
  if (*pcVar21 != *pcVar18) goto switchD_00549780_caseD_64;
  goto LAB_0054a494;
}


