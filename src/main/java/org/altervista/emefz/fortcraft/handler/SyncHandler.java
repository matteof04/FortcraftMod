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

package org.altervista.emefz.fortcraft.handler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.altervista.emefz.fortcraft.handler.particle.ParticleType;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class SyncHandler {

    private static final Map<EntityPlayer, Boolean> flyKeyState = new HashMap<>();
    private static final Map<EntityPlayer, Boolean> descendKeyState = new HashMap<>();
    private static final Map<EntityPlayer, Boolean> forwardKeyState = new HashMap<>();
    private static final Map<EntityPlayer, Boolean> backwardKeyState = new HashMap<>();
    private static final Map<EntityPlayer, Boolean> leftKeyState = new HashMap<>();
    private static final Map<EntityPlayer, Boolean> rightKeyState = new HashMap<>();

    private static final Map<Integer, ParticleType> jetpackState = new HashMap<>();

    public static boolean isFlyKeyDown(EntityLivingBase user) {
        return !(user instanceof EntityPlayer) || flyKeyState.containsKey(user) && flyKeyState.get(user);
    }

    public static boolean isDescendKeyDown(EntityLivingBase user) {
        return user instanceof EntityPlayer && descendKeyState.containsKey(user) && descendKeyState.get(user);
    }

    public static boolean isForwardKeyDown(EntityLivingBase user) {
        return !(user instanceof EntityPlayer) || forwardKeyState.containsKey(user) && forwardKeyState.get(user);
    }

    public static boolean isBackwardKeyDown(EntityLivingBase user) {
        return user instanceof EntityPlayer && backwardKeyState.containsKey(user) && backwardKeyState.get(user);
    }

    public static boolean isLeftKeyDown(EntityLivingBase user) {
        return user instanceof EntityPlayer && leftKeyState.containsKey(user) && leftKeyState.get(user);
    }

    public static boolean isRightKeyDown(EntityLivingBase user) {
        return user instanceof EntityPlayer && rightKeyState.containsKey(user) && rightKeyState.get(user);
    }

    public static void processKeyUpdate(EntityPlayer player, boolean keyFly, boolean keyDescend, boolean keyForward, boolean keyBackward, boolean keyLeft, boolean keyRight) {
        flyKeyState.put(player, keyFly);
        descendKeyState.put(player, keyDescend);
        forwardKeyState.put(player, keyForward);
        backwardKeyState.put(player, keyBackward);
        leftKeyState.put(player, keyLeft);
        rightKeyState.put(player, keyRight);
    }

    public static void processJetpackUpdate(int entityId, ParticleType particleType) {
        if (particleType != null) {
            jetpackState.put(entityId, particleType);
        } else {
            jetpackState.remove(entityId);
        }
    }

    public static Map<Integer, ParticleType> getJetpackStates() {
        return jetpackState;
    }

    public static void clearAll() {
        flyKeyState.clear();
        forwardKeyState.clear();
        descendKeyState.clear();
        backwardKeyState.clear();
        leftKeyState.clear();
        rightKeyState.clear();
    }

    private static void removeFromAll(EntityPlayer player) {
        flyKeyState.remove(player);
        forwardKeyState.remove(player);
        descendKeyState.remove(player);
        backwardKeyState.remove(player);
        leftKeyState.remove(player);
        rightKeyState.remove(player);
    }

    @SubscribeEvent
    public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        removeFromAll(event.player);
    }

    @SubscribeEvent
    public void onDimChanged(PlayerEvent.PlayerChangedDimensionEvent event) {
        removeFromAll(event.player);
    }
}