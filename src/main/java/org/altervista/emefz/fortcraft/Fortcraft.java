/*
 * Copyright (C) 2022 Matteo Franceschini <matteof5730@gmail.com>
 *
 * This file is part of FortcraftMod.
 * FortcraftMod is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * FortcraftMod is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with FortcraftMod.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.altervista.emefz.fortcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.altervista.emefz.fortcraft.network.NetworkHandler;
import org.altervista.emefz.fortcraft.util.lootbox.DropProcessor;
import org.altervista.emefz.fortcraft.util.lootbox.LootBoxDrop;
import org.altervista.emefz.fortcraft.util.lootbox.Rarity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.altervista.emefz.fortcraft.util.lootbox.TranslationHelper;

import java.io.File;

@Mod(modid = Fortcraft.MODID, name = Fortcraft.NAME, version = Fortcraft.VERSION, acceptedMinecraftVersions = Fortcraft.MC_VERSION, updateJSON = Fortcraft.UPDATE_JSON)
public class Fortcraft {
    public static final String MODID = "fortcraft";
    public static final String NAME = "Fortcraft Mod";
    public static final String VERSION = "3.0.1";
    public static final String MC_VERSION = "[1.12.2]";
    public static final String UPDATE_JSON = "";
    public static final Logger logger = LogManager.getLogger(Fortcraft.MODID);
    public static final CreativeTabs FORTCRAFT_TAB = new FortcraftTab("tabFortcraft");
    public static File DROPS_LANG;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        TranslationHelper.preInit(event);
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        NetworkHandler.init();
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        Item jump = DropProcessor.getItemFromRegistry("fortcraft:jump");
        Item grappling_hook = DropProcessor.getItemFromRegistry("grapplemod:grapplinghook");
        Item jetpack = DropProcessor.getItemFromRegistry("fortcraft:jetpack");
        Item swathelmet = DropProcessor.getItemFromRegistry("flansmod:swathelmet");
        Item swatbody = DropProcessor.getItemFromRegistry("flansmod:swatbody");
        Item juggernauthelmet = DropProcessor.getItemFromRegistry("flansmod:juggernauthelmet");
        Item juggernautbody = DropProcessor.getItemFromRegistry("flansmod:juggernautbody");
        Item golddeserteagle = DropProcessor.getItemFromRegistry("flansmod:golddeserteagle");
        Item golddeserteagle_ammo = DropProcessor.getItemFromRegistry("flansmod:deserteagleammo");
        Item mp7 = DropProcessor.getItemFromRegistry("flansmod:mp7");
        Item mp7_ammo = DropProcessor.getItemFromRegistry("flansmod:mp7ammo");
        Item usp = DropProcessor.getItemFromRegistry("flansmod:usp");
        Item usp_ammo = DropProcessor.getItemFromRegistry("flansmod:uspammo");
        Item usp_poison_ammo = DropProcessor.getItemFromRegistry("flansmod:usppoisonammo");
        Item rpg = DropProcessor.getItemFromRegistry("flansmod:rpg");
        Item rpg_ammo = DropProcessor.getItemFromRegistry("flansmod:rpgammo");
        Item judge = DropProcessor.getItemFromRegistry("flansmod:judge");
        Item executioner = DropProcessor.getItemFromRegistry("flansmod:executioner");
        Item w1200ammo = DropProcessor.getItemFromRegistry("flansmod:w1200ammo");
        Item w1200incendiaryammo = DropProcessor.getItemFromRegistry("flansmod:w1200incendiaryammo");
        Item spasammo = DropProcessor.getItemFromRegistry("flansmod:spasammo");
        Item m1887ammo = DropProcessor.getItemFromRegistry("flansmod:m1887ammo");
        Item bazooka = DropProcessor.getItemFromRegistry("flansmod:bazooka");
        Item bazooka_ammo = DropProcessor.getItemFromRegistry("flansmod:bazookaammo");
        Item glock = DropProcessor.getItemFromRegistry("flansmod:glock");
        Item glock_ammo = DropProcessor.getItemFromRegistry("flansmod:glockammo");
        Item skorpion = DropProcessor.getItemFromRegistry("flansmod:skorpion");
        Item skorpion_ammo = DropProcessor.getItemFromRegistry("flansmod:skorpionammo");
        Item aug = DropProcessor.getItemFromRegistry("flansmod:aug");
        Item aug_ammo = DropProcessor.getItemFromRegistry("flansmod:augammo");
        Item kar98k = DropProcessor.getItemFromRegistry("flansmod:kar98k");
        Item kar98k_ammo = DropProcessor.getItemFromRegistry("flansmod:kar98kammo");
        Item g36 = DropProcessor.getItemFromRegistry("flansmod:g36");
        Item g36_ammo = DropProcessor.getItemFromRegistry("flansmod:g36ammo");
        Item ak74 = DropProcessor.getItemFromRegistry("flansmod:ak74");
        Item ak74_ammo = DropProcessor.getItemFromRegistry("flansmod:ak74ammo");
        Item r870 = DropProcessor.getItemFromRegistry("flansmod:r870");
        Item uzi = DropProcessor.getItemFromRegistry("flansmod:uzi");
        Item uzi_ammo = DropProcessor.getItemFromRegistry("flansmod:uziammo");
        Item minigun = DropProcessor.getItemFromRegistry("flansmod:minigun");
        Item minigun_ammo = DropProcessor.getItemFromRegistry("flansmod:minigunammo");
        Item minigun_explosive_ammo = DropProcessor.getItemFromRegistry("flansmod:minigunexplosiveammo");
        Item barrett = DropProcessor.getItemFromRegistry("flansmod:barrett");
        Item barrett_ammo = DropProcessor.getItemFromRegistry("flansmod:barrettammo");
        Item barrett_explosive_ammo = DropProcessor.getItemFromRegistry("flansmod:barrettexplosiveammo");
        Item m67 = DropProcessor.getItemFromRegistry("flansmod:m67");
        Item gl1 = DropProcessor.getItemFromRegistry("flansmod:gl1");
        Item bouncy_gl_ammo = DropProcessor.getItemFromRegistry("flansmod:grenadelauncherbouncyammo");
        Item gl_ammo = DropProcessor.getItemFromRegistry("flansmod:grenadelauncherammo");
        Item incendiary_gl_ammo = DropProcessor.getItemFromRegistry("flansmod:grenadelauncherincendiaryammo");
        Item gas_gl_ammo = DropProcessor.getItemFromRegistry("flansmod:grenadelaunchergasammo");
        Item m1014 = DropProcessor.getItemFromRegistry("flansmod:m1014");
        Item spas = DropProcessor.getItemFromRegistry("flansmod:spas");
        Item m40a3 = DropProcessor.getItemFromRegistry("flansmod:m40a3");
        Item r700_ammo = DropProcessor.getItemFromRegistry("flansmod:r700ammo");
        Item m40a3_ammo = DropProcessor.getItemFromRegistry("flansmod:m40a3ammo");
        Item ak47 = DropProcessor.getItemFromRegistry("flansmod:ak47");
        Item ak47_ammo = DropProcessor.getItemFromRegistry("flansmod:ak47ammo");
        Item acr = DropProcessor.getItemFromRegistry("flansmod:acr");
        Item acr_ammo = DropProcessor.getItemFromRegistry("flansmod:acrammo");
        Item fnscar = DropProcessor.getItemFromRegistry("flansmod:fnscar");
        Item fnscar_ammo = DropProcessor.getItemFromRegistry("flansmod:fnscarammo");
        Item medikit = DropProcessor.getItemFromRegistry("flansmod:ww2medkit");
        Item portable_medikit = DropProcessor.getItemFromRegistry("flansmod:mwmedicbag");
        Item flanmwreddot = DropProcessor.getItemFromRegistry("flansmod:flanmwreddot");
        Item flanmwpistolflashlight = DropProcessor.getItemFromRegistry("flansmod:flanmwpistolflashlight");
        Item jury = DropProcessor.getItemFromRegistry("flansmod:jury");
        Item juryammo = DropProcessor.getItemFromRegistry("flansmod:juryammo");
        Item beartrap = DropProcessor.getItemFromRegistry("flansmod:beartrap");
        Item flanmwautofire = DropProcessor.getItemFromRegistry("flansmod:flanmwautofire");
        Item exoskeletonhelmet = DropProcessor.getItemFromRegistry("flansmod:exoskeletonhelmet");
        Item exoskeletonbody = DropProcessor.getItemFromRegistry("flansmod:exoskeletonbody");
        Item exoskeletonlegs = DropProcessor.getItemFromRegistry("flansmod:exoskeletonlegs");
        Item exoskeletonboots = DropProcessor.getItemFromRegistry("flansmod:exoskeletonboots");
        Item flanmw4xscope = DropProcessor.getItemFromRegistry("flansmod:flanmw4xscope");
        Item claymore = DropProcessor.getItemFromRegistry("flansmod:claymore");
        Item samuraisword = DropProcessor.getItemFromRegistry("flansmod:samuraisword");
        Item flanmwlongbarrel = DropProcessor.getItemFromRegistry("flansmod:flanmwlongbarrel");
        Item flanmwacog = DropProcessor.getItemFromRegistry("flansmod:flanmwacog");
        Item p90 = DropProcessor.getItemFromRegistry("flansmod:p90");
        Item p90ammo = DropProcessor.getItemFromRegistry("flansmod:p90ammo");
        Item c4 = DropProcessor.getItemFromRegistry("flansmod:c4");
        Item c4remote = DropProcessor.getItemFromRegistry("flansmod:c4remote");
        Item flanmwsilencer = DropProcessor.getItemFromRegistry("flansmod:flanmwsilencer");
        Item flanmwforegrip = DropProcessor.getItemFromRegistry("flansmod:flanmwforegrip");
        Item flanmwburstfire = DropProcessor.getItemFromRegistry("flansmod:flanmwburstfire");
        Item flanmwflashlight = DropProcessor.getItemFromRegistry("flansmod:flanmwflashlight");
        Item panzerfaust3 = DropProcessor.getItemFromRegistry("flansmod:panzerfaust3");
        Item panzerfaust3ammo = DropProcessor.getItemFromRegistry("flansmod:panzerfaust3ammo");
        Item sg550 = DropProcessor.getItemFromRegistry("flansmod:sg550");
        Item sg550ammo = DropProcessor.getItemFromRegistry("flansmod:sg550ammo");
        Item hk416 = DropProcessor.getItemFromRegistry("flansmod:hk416");
        Item m16a4 = DropProcessor.getItemFromRegistry("flansmod:m16a4");
        Item m16a4ammo = DropProcessor.getItemFromRegistry("flansmod:m16a4ammo");
        Item mtar = DropProcessor.getItemFromRegistry("flansmod:mtar");
        Item mtarammo = DropProcessor.getItemFromRegistry("flansmod:mtarammo");
        Item stielhandgranate = DropProcessor.getItemFromRegistry("flansmod:stielhandgranate");
        Item magnetupgradeitem = DropProcessor.getItemFromRegistry("grapplemod:magnetupgradeitem");
        Item ropeupgradeitem = DropProcessor.getItemFromRegistry("grapplemod:ropeupgradeitem");
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(jump)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(grappling_hook)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(jetpack)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(swathelmet), new ItemStack(swatbody)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(juggernauthelmet), new ItemStack(juggernautbody)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(golddeserteagle), new ItemStack(golddeserteagle_ammo, 5)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(mp7), new ItemStack(mp7_ammo, 5)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(usp), new ItemStack(usp_ammo, 5)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(usp), new ItemStack(usp_poison_ammo, 5)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(rpg), new ItemStack(rpg_ammo, 6)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(judge), new ItemStack(w1200ammo, 10)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(executioner), new ItemStack(w1200ammo, 10)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(bazooka), new ItemStack(bazooka_ammo, 6)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(glock), new ItemStack(glock_ammo, 5)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(skorpion), new ItemStack(skorpion_ammo, 5)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(aug), new ItemStack(aug_ammo, 6)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(kar98k), new ItemStack(kar98k_ammo, 5)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(g36), new ItemStack(g36_ammo, 6)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(ak74), new ItemStack(ak74_ammo, 5)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(r870), new ItemStack(w1200ammo, 10)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(w1200incendiaryammo, 10)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(m1887ammo, 10)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(spasammo, 10)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(uzi), new ItemStack(uzi_ammo, 5)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(minigun), new ItemStack(minigun_ammo, 3)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(minigun_explosive_ammo, 3)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(barrett), new ItemStack(barrett_ammo, 3)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(barrett_explosive_ammo, 3)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(m67, 4)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(gl1), new ItemStack(bouncy_gl_ammo, 8)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(gl_ammo, 8)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(incendiary_gl_ammo, 8)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(gas_gl_ammo, 8)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(m1014), new ItemStack(w1200ammo, 10)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(spas), new ItemStack(w1200ammo, 10)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(m40a3), new ItemStack(r700_ammo, 12)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(m40a3_ammo, 12)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(ak47), new ItemStack(ak47_ammo, 4)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(acr), new ItemStack(acr_ammo, 6)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(fnscar), new ItemStack(fnscar_ammo, 6)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(medikit)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(portable_medikit)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwreddot)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwpistolflashlight)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(jury), new ItemStack(juryammo, 16)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(beartrap)}, Rarity.MYTHICAL));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwautofire)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(exoskeletonhelmet), new ItemStack(exoskeletonbody), new ItemStack(exoskeletonlegs), new ItemStack(exoskeletonboots)}, Rarity.LEGGENDARY));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(p90), new ItemStack(p90ammo, 6)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(c4remote), new ItemStack(c4, 4)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmw4xscope)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwacog)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwlongbarrel)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(claymore)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(samuraisword)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwsilencer)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwforegrip)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwburstfire)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(flanmwflashlight)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(m16a4), new ItemStack(m16a4ammo, 4)}, Rarity.COMMON));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(mtar), new ItemStack(mtarammo, 6)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(sg550), new ItemStack(sg550ammo, 4)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(panzerfaust3), new ItemStack(panzerfaust3ammo, 6)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(hk416), new ItemStack(m16a4ammo, 4)}, Rarity.RARE));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(stielhandgranate)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(magnetupgradeitem)}, Rarity.EPIC));
        DropProcessor.registryLoot(new LootBoxDrop(new ItemStack[]{new ItemStack(ropeupgradeitem)}, Rarity.MYTHICAL));
        TranslationHelper.postInit();
    }
}
