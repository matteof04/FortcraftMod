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

package org.altervista.emefz.fortcraft.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.altervista.emefz.fortcraft.Fortcraft;
import org.altervista.emefz.fortcraft.network.message.MessageJetpackSync;
import org.altervista.emefz.fortcraft.network.message.MessageKeyboardSync;

public abstract class NetworkHandler {

    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(Fortcraft.MODID);

    public static void init() {
        instance.registerMessage(MessageJetpackSync.class, MessageJetpackSync.class, nextID(), Side.CLIENT);
        instance.registerMessage(MessageKeyboardSync.class, MessageKeyboardSync.class, nextID(), Side.SERVER);
    }

}
