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

package org.altervista.emefz.fortcraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.altervista.emefz.fortcraft.handler.SyncHandler;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;

public class ItemJetpack extends ItemArmor {
    private final Double accelVertical = 0.12;
    private final Double speedVertical = 0.6;
    private final Double speedSideways = 0.16;
    private final Double sprintSpeedModifier = 1.4;
    private static Field floatingTickCount;
    public ItemJetpack(ArmorMaterial material){
        super(material, 0, EntityEquipmentSlot.CHEST);
        setMaxStackSize(1);
    }
    @Override
    public void onArmorTick(@Nonnull World world, @Nonnull EntityPlayer player, @Nonnull ItemStack stack){
        if(!player.isSpectator()){
            flyUser(player);
        }
    }
    @Override
    public String getArmorTexture(ItemStack stack, @Nonnull Entity entity, @Nonnull EntityEquipmentSlot slot, @Nonnull String type) {
        return "fortcraft:textures/armor/jetpack_layer_1.png";
    }
    public void flyUser(EntityPlayer user) {
        boolean flyKeyDown = SyncHandler.isFlyKeyDown(user);
        double currentAccel = accelVertical * (user.motionY < 0.3D ? 2.5D : 1.0D);
        double currentSpeedVertical = speedVertical * (user.isInWater() ? 0.4D : 1.0D);
        if (flyKeyDown && !user.onGround) {
            if (flyKeyDown) {
                user.motionY = Math.min(user.motionY + currentAccel, currentSpeedVertical);
                user.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 0.2F, 0.8F);
            } else {
                user.fall(user.fallDistance, 1);
            }
            float speedSideways = (float) (user.isSneaking() ? this.speedSideways * 0.5F : this.speedSideways);
            float speedForward = (float) (user.isSprinting() ? speedSideways * sprintSpeedModifier : speedSideways);
            if (SyncHandler.isForwardKeyDown(user)) {
                user.moveRelative(0, 0, speedForward, speedForward);
            }
            if (SyncHandler.isBackwardKeyDown(user)) {
                user.moveRelative(0, 0, -speedSideways, speedSideways * 0.8F);
            }
            if (SyncHandler.isLeftKeyDown(user)) {
                user.moveRelative(speedSideways, 0, 0, speedSideways);
            }
            if (SyncHandler.isRightKeyDown(user)) {
                user.moveRelative(-speedSideways, 0, 0, speedSideways);
            }
            if (!user.world.isRemote) {
                user.fallDistance = 0.0F;
                if (user instanceof EntityPlayerMP) {
                    try {
                        if(floatingTickCount != null) {
                            floatingTickCount.setInt(((EntityPlayerMP) user).connection, 0);
                        }else{
                            floatingTickCount = ObfuscationReflectionHelper.findField(NetHandlerPlayServer.class, "field_147365_f");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

