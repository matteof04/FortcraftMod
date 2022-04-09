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

package org.altervista.emefz.fortcraft.client;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.altervista.emefz.fortcraft.Fortcraft;
import org.altervista.emefz.fortcraft.init.FortcraftItems;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Fortcraft.MODID)
public class ModelRegistrationHandler {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(FortcraftItems.JUMP, 0);
        registerModel(FortcraftItems.BEDROCK_PICKAXE, 0);
        registerModel(FortcraftItems.LOOT_BOX, 0);
        registerModel(FortcraftItems.JETPACK, 0);
    }

    private static void registerModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
