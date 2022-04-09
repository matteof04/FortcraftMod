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

package org.altervista.emefz.fortcraft.client.handler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.altervista.emefz.fortcraft.Fortcraft;
import org.altervista.emefz.fortcraft.handler.SyncHandler;
import org.altervista.emefz.fortcraft.network.NetworkHandler;
import org.altervista.emefz.fortcraft.network.message.MessageKeyboardSync;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Fortcraft.MODID)
public class KeybindHandler {
    static final Minecraft mc = Minecraft.getMinecraft();
    private static boolean lastFlyState = false;
    private static boolean lastDescendState = false;
    private static boolean lastForwardState = false;
    private static boolean lastBackwardState = false;
    private static boolean lastLeftState = false;
    private static boolean lastRightState = false;

    private static void tickStart() {
        if (mc.player != null) {
            boolean flyState = mc.gameSettings.keyBindJump.isKeyDown();
            boolean descendState = mc.gameSettings.keyBindSneak.isKeyDown();
            boolean forwardState = mc.gameSettings.keyBindForward.isKeyDown();
            boolean backwardState = mc.gameSettings.keyBindBack.isKeyDown();
            boolean leftState = mc.gameSettings.keyBindLeft.isKeyDown();
            boolean rightState = mc.gameSettings.keyBindRight.isKeyDown();
            if (flyState != lastFlyState || descendState != lastDescendState || forwardState != lastForwardState || backwardState != lastBackwardState || leftState != lastLeftState || rightState != lastRightState) {
                lastFlyState = flyState;
                lastDescendState = descendState;
                lastForwardState = forwardState;
                lastBackwardState = backwardState;
                lastLeftState = leftState;
                lastRightState = rightState;
                NetworkHandler.instance.sendToServer(new MessageKeyboardSync(flyState, descendState, forwardState, backwardState, leftState, rightState));
                SyncHandler.processKeyUpdate(mc.player, flyState, descendState, forwardState, backwardState, leftState, rightState);
            }
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent evt) {
        if (evt.phase == TickEvent.Phase.START) {
            tickStart();
        }
    }
}
