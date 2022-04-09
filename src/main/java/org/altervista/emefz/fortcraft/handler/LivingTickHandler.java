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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;
import org.altervista.emefz.fortcraft.Fortcraft;
import org.altervista.emefz.fortcraft.handler.particle.ParticleType;
import org.altervista.emefz.fortcraft.handler.SyncHandler;
import org.altervista.emefz.fortcraft.items.ItemJetpack;
import org.altervista.emefz.fortcraft.network.NetworkHandler;
import org.altervista.emefz.fortcraft.network.message.MessageJetpackSync;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Mod.EventBusSubscriber(modid = Fortcraft.MODID)
public class LivingTickHandler {

    private static final Map<Integer, ParticleType> lastJetpackState = new ConcurrentHashMap<>();

    @SubscribeEvent
    public static void onLivingTick(LivingUpdateEvent event) {
        if (!event.getEntityLiving().world.isRemote) {
            ParticleType jetpackState = null;
            ItemStack armor = event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            if (armor.getItem() instanceof ItemJetpack) {
                EntityLivingBase user = event.getEntityLiving();
                if(SyncHandler.isFlyKeyDown(user) && !user.onGround){
                    jetpackState = ParticleType.DEFAULT;
                }else{
                    jetpackState = ParticleType.NONE;
                }
            }
            if (jetpackState != lastJetpackState.get(event.getEntityLiving().getEntityId())) {
                if (jetpackState == null) {
                    lastJetpackState.remove(event.getEntityLiving().getEntityId());
                } else {
                    lastJetpackState.put(event.getEntityLiving().getEntityId(), jetpackState);
                }
                NetworkHandler.instance.sendToAllAround(new MessageJetpackSync(event.getEntityLiving().getEntityId(), jetpackState != null ? jetpackState.ordinal() : -1), new TargetPoint(event.getEntityLiving().dimension, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, 256));
            } else if (event.getEntityLiving().world.getTotalWorldTime() % 160L == 0) {
                NetworkHandler.instance.sendToAllAround(new MessageJetpackSync(event.getEntityLiving().getEntityId(), jetpackState != null ? jetpackState.ordinal() : -1), new TargetPoint(event.getEntityLiving().dimension, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, 256));
            }
            if (event.getEntityLiving().world.getTotalWorldTime() % 200L == 0) {
                lastJetpackState.keySet().removeIf(entityId -> event.getEntityLiving().world.getEntityByID(entityId) == null);
            }
        }
    }
}