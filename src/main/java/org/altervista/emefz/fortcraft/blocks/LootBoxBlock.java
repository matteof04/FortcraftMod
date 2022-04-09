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

package org.altervista.emefz.fortcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.altervista.emefz.fortcraft.Fortcraft;
import org.altervista.emefz.fortcraft.util.lootbox.DropProcessor;

import java.util.Optional;

public class LootBoxBlock extends Block {
    public LootBoxBlock(Material material){
        super(material);
        setSoundType(SoundType.WOOD);
        setBlockUnbreakable();
        setCreativeTab(Fortcraft.FORTCRAFT_TAB);
        setResistance(6000000.0F);
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.isCreative()){
            worldIn.setBlockToAir(pos);
            ItemStack[] stacks = DropProcessor.getDrops();
            for (ItemStack i : stacks) {
                Block.spawnAsEntity(worldIn, pos, i);
            }
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face){ return false; }
}
