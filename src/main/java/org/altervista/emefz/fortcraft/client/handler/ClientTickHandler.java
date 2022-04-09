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
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import org.altervista.emefz.fortcraft.Fortcraft;
import org.altervista.emefz.fortcraft.client.particle.JetpackParticleHelper;
import org.altervista.emefz.fortcraft.handler.SyncHandler;
import org.altervista.emefz.fortcraft.handler.particle.ParticleType;
import org.altervista.emefz.fortcraft.items.ItemJetpack;

import java.lang.reflect.Field;
import java.util.Iterator;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Fortcraft.MODID)
public class ClientTickHandler {

    private static final Minecraft mc = Minecraft.getMinecraft();
    private static ParticleType lastJetpackState = null;
    private static boolean wearingJetpack = false;
    private static boolean sprintKeyCheck = false;
    private static Field sprintToggleTimer;

    private static void tickStart() {
        if (mc.player == null) return;
        if(sprintToggleTimer == null) sprintToggleTimer = ObfuscationReflectionHelper.findField(EntityPlayerSP.class, "field_71156_d");
        ParticleType jetpackState = null;
        ItemStack armor = mc.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        if (armor.getItem() instanceof ItemJetpack) {
            if(SyncHandler.isFlyKeyDown(mc.player) && !mc.player.onGround){
                jetpackState = ParticleType.DEFAULT;
            }else{
                jetpackState = ParticleType.NONE;
            }
            wearingJetpack = true;
        } else {
            wearingJetpack = false;
        }
        if (jetpackState != lastJetpackState) {
            lastJetpackState = jetpackState;
            SyncHandler.processJetpackUpdate(mc.player.getEntityId(), jetpackState);
        }
    }

    private static void tickEnd() {
        if (mc.player == null || mc.world == null) return;
        if (!mc.isGamePaused()) {
            Iterator<Integer> itr = SyncHandler.getJetpackStates().keySet().iterator();
            int currentEntity;
            while (itr.hasNext()) {
                currentEntity = itr.next();
                Entity entity = mc.world.getEntityByID(currentEntity);
                if (!(entity instanceof EntityLivingBase) || entity.dimension != mc.player.dimension) {
                    itr.remove();
                } else {
                    ParticleType particle = SyncHandler.getJetpackStates().get(currentEntity);
                    final boolean isSpectator = entity instanceof EntityPlayer && ((EntityPlayer) entity).isSpectator();
                    if (particle != null && !isSpectator) {
                        JetpackParticleHelper.showJetpackParticles(mc.world, (EntityLivingBase) entity, particle);
                    } else {
                        itr.remove();
                    }
                }
            }
        }
        if (sprintKeyCheck && mc.player.movementInput.moveForward < 1.0F) {
            sprintKeyCheck = false;
        }
        if (!wearingJetpack || mc.player.onGround || mc.player.isSprinting() || mc.player.isHandActive() || mc.player.isPotionActive(MobEffects.POISON)) {
            return;
        }
        if (!sprintKeyCheck && sprintToggleTimer != null && mc.player.movementInput.moveForward >= 1.0F && !mc.player.collidedHorizontally && (mc.player.getFoodStats().getFoodLevel() > 6.0F || mc.player.capabilities.allowFlying)) {
            try {
                if (sprintToggleTimer.getInt(mc.player) <= 0 && !mc.gameSettings.keyBindSprint.isKeyDown()) {
                    sprintToggleTimer.setInt(mc.player, 7);
                    sprintKeyCheck = true;
                } else {
                    mc.player.setSprinting(true);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent evt) {
        if (evt.phase == Phase.START) {
            tickStart();
        } else {
            tickEnd();
        }
    }
}
