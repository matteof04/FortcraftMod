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

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

public enum Rarity {
    COMMON(null, 200),
    RARE(TextFormatting.DARK_BLUE, 160),
    EPIC(TextFormatting.DARK_PURPLE, 110),
    MYTHICAL(TextFormatting.DARK_RED, 77),
    LEGGENDARY(TextFormatting.GOLD,37);
    private final int value;
    private final Style style;
    Rarity(TextFormatting color, int value){
        this.value = value;
        this.style = new Style();
        this.style.setColor(color);
    }

    public int getValue() {
        return value;
    }

    public Style getStyle() {
        return style;
    }
}
