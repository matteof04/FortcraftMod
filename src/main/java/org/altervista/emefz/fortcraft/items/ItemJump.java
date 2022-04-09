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

package org.altervista.emefz.fortcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemJump extends Item {
    public ItemJump(){
        setMaxStackSize(1);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(handIn == EnumHand.MAIN_HAND && !playerIn.isInWater()){
            playerIn.getHeldItemMainhand().shrink(1);
            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(25), 30, 125, false, false));
            if((playerIn.getActivePotionEffect(Potion.getPotionById(25))).getPotion() == Potion.getPotionById(25)){
                return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
            }else {
                return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
            }
        }else{
            return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        }
    }
}
