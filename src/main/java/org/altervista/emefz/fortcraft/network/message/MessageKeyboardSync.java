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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.altervista.emefz.fortcraft.Fortcraft;
import org.altervista.emefz.fortcraft.handler.SyncHandler;

public class MessageKeyboardSync implements IMessage, IMessageHandler<MessageKeyboardSync, IMessage> {

    public boolean flyState;
    public boolean descendState;
    public boolean forwardState;
    public boolean backwardState;
    public boolean leftState;
    public boolean rightState;

    public MessageKeyboardSync() {
    }

    public MessageKeyboardSync(boolean flyState, boolean descendState, boolean forwardState, boolean backwardState, boolean leftState, boolean rightState) {
        this.flyState = flyState;
        this.descendState = descendState;
        this.forwardState = forwardState;
        this.backwardState = backwardState;
        this.leftState = leftState;
        this.rightState = rightState;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.flyState = buf.readBoolean();
        this.descendState = buf.readBoolean();
        this.forwardState = buf.readBoolean();
        this.backwardState = buf.readBoolean();
        this.leftState = buf.readBoolean();
        this.rightState = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.flyState);
        buf.writeBoolean(this.descendState);
        buf.writeBoolean(this.forwardState);
        buf.writeBoolean(this.backwardState);
        buf.writeBoolean(this.leftState);
        buf.writeBoolean(this.rightState);
    }

    @Override
    public IMessage onMessage(MessageKeyboardSync msg, MessageContext ctx) {
        EntityPlayerMP entityPlayerMP = ctx.getServerHandler().player;
        WorldServer worldServer = entityPlayerMP.getServerWorld();
        worldServer.addScheduledTask(() -> handleMessage(msg, ctx));
        return null;
    }

    public void handleMessage(MessageKeyboardSync msg, MessageContext ctx) {
        EntityPlayer entityPlayer = ctx.getServerHandler().player;
        if (entityPlayer != null) {
            SyncHandler.processKeyUpdate(entityPlayer, msg.flyState, msg.descendState, msg.forwardState, msg.backwardState, msg.leftState, msg.rightState);
        }
    }
}