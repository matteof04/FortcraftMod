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

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.altervista.emefz.fortcraft.blocks.LootBoxBlock;
import org.altervista.emefz.fortcraft.init.FortcraftBlocks;
import org.altervista.emefz.fortcraft.items.ItemBedrockPickaxe;
import org.altervista.emefz.fortcraft.items.ItemJetpack;
import org.altervista.emefz.fortcraft.items.ItemJump;
import org.altervista.emefz.fortcraft.items.ItemLootBoxBlock;
import org.altervista.emefz.fortcraft.materials.FortcraftMaterials;
import org.altervista.emefz.fortcraft.util.RegistryUtil;

@Mod.EventBusSubscriber(modid = Fortcraft.MODID)
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        final Item[] items = {
                RegistryUtil.setItemName(new ItemJump(), "jump").setCreativeTab(Fortcraft.FORTCRAFT_TAB),
                RegistryUtil.setItemName(new ItemBedrockPickaxe(FortcraftMaterials.BEDROCK_MATERIAL), "bedrock_pickaxe").setCreativeTab(Fortcraft.FORTCRAFT_TAB),
                RegistryUtil.setItemName(new ItemLootBoxBlock(FortcraftBlocks.LOOT_BOX), "loot_box").setCreativeTab(Fortcraft.FORTCRAFT_TAB),
                RegistryUtil.setItemName(new ItemJetpack(FortcraftMaterials.JETPACK_MATERIAL), "jetpack").setCreativeTab(Fortcraft.FORTCRAFT_TAB)
        };
        event.getRegistry().registerAll(items);
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
                RegistryUtil.setBlockName(new LootBoxBlock(FortcraftMaterials.LOOT_BOX_MATERIAL), "loot_box").setCreativeTab(Fortcraft.FORTCRAFT_TAB)
        };
        event.getRegistry().registerAll(blocks);
    }
}
