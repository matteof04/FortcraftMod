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

package org.altervista.emefz.fortcraft.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class FortcraftMaterials {
    public static final Item.ToolMaterial BEDROCK_MATERIAL = EnumHelper.addToolMaterial("BEDROCK", 5,-1, 1000000000.0F,1, 0);
    public static final Material LOOT_BOX_MATERIAL = new Material(MapColor.WOOD){
        @Override
        public boolean isReplaceable(){ return false; }
        @Override
        public boolean isToolNotRequired(){ return false; }
    };
    public static final ItemArmor.ArmorMaterial JETPACK_MATERIAL = EnumHelper.addArmorMaterial("JETPACK", "fortcraft:jetpack", 999999, new int[]{0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
}
