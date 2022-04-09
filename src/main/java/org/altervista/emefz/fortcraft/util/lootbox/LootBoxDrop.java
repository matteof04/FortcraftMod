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

package org.altervista.emefz.fortcraft.util.lootbox;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class LootBoxDrop {
    private final ItemStack[] items;
    private final Rarity fortune;
    public LootBoxDrop(ItemStack[] itemStacks, Rarity fortune){
        ArrayList<ItemStack> tmp = new ArrayList<>();
        if(fortune != Rarity.COMMON) {
            for (ItemStack stack : itemStacks) {
                tmp.add(stack.setTranslatableName(TranslationHelper.getTranslatableName(stack, fortune)));
            }
        }
        this.items = tmp.toArray(new ItemStack[0]);
        this.fortune = fortune;
    }

    public Rarity getFortune() {
        return fortune;
    }

    public ItemStack[] getItems() {
        return items;
    }
}
