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

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DropProcessor {
    private static final Random rand = new Random();
    private static final ArrayList<LootBoxDrop> items = new ArrayList<>();
    private static final HashMap<IntRange, LootBoxDrop> indexes = new HashMap<>();
    public static ItemStack[] getDrops(){
        int sum = 0;
        for(LootBoxDrop d : items){
            int lastSum = sum+1;
            sum += d.getFortune().getValue();
            indexes.put(new IntRange(lastSum, sum), d);
        }
        while(true){
            int r = rand.nextInt(sum + 1);
            for(Map.Entry<IntRange, LootBoxDrop> entry : indexes.entrySet()){
                if(entry.getKey().contains(r)){
                    return entry.getValue().getItems();
                }
            }
        }
    }
    public static void registryLoot(LootBoxDrop drop){
        for(ItemStack stack : drop.getItems()){
            if(!stack.isEmpty() && !(stack.getItem() == Items.AIR)){
                items.add(drop);
                if(drop.getFortune() != Rarity.COMMON) {
                    TranslationHelper.registerItemTranslation(stack, drop.getFortune());
                }
            }
        }
    }
    public static Item getItemFromRegistry(String s){
        return Item.REGISTRY.getObject(new ResourceLocation(s));
    }
}
