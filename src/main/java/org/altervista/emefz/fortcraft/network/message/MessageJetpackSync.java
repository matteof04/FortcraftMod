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

package org.altervista.emefz.fortcraft.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.altervista.emefz.fortcraft.handler.particle.ParticleType;
import org.altervista.emefz.fortcraft.handler.SyncHandler;

public class MessageJetpackSync implements IMessage, IMessageHandler<MessageJetpackSync, IMessage> {

    public int entityId;
    public int particleId;

    public MessageJetpackSync() {
    }

    public MessageJetpackSync(int entityId, int particleId) {
        this.entityId = entityId;
        this.particleId = particleId;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.entityId = buf.readInt();
        this.particleId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.entityId);
        buf.writeInt(this.particleId);
    }

    @Override
    public IMessage onMessage(MessageJetpackSync msg, MessageContext ctx) {
        Minecraft.getMinecraft().addScheduledTask(() -> handleMessage(msg, ctx));
        return null;
    }

    public void handleMessage(MessageJetpackSync msg, MessageContext ctx) {
        Entity entity = FMLClientHandler.instance().getClient().world.getEntityByID(msg.entityId);
        if (entity instanceof EntityLivingBase && entity != FMLClientHandler.instance().getClient().player) {
            if (msg.particleId >= 0) {
                ParticleType particle = ParticleType.values()[msg.particleId];
                SyncHandler.processJetpackUpdate(msg.entityId, particle);
            } else {
                SyncHandler.processJetpackUpdate(msg.entityId, null);
            }
        }
    }
}