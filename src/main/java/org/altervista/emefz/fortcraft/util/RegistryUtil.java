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

package org.altervista.emefz.fortcraft.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.altervista.emefz.fortcraft.Fortcraft;

public class RegistryUtil {
    public static Item setItemName(final Item item, final String name) {
        item.setRegistryName(Fortcraft.MODID, name).setUnlocalizedName(Fortcraft.MODID + "." + name);
        return item;
    }

    public static Block setBlockName(final Block block, final String name) {
        block.setRegistryName(Fortcraft.MODID, name).setUnlocalizedName(Fortcraft.MODID + "." + name);
        return block;
    }
}
