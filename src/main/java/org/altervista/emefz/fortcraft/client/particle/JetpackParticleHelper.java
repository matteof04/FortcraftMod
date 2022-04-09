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

package org.altervista.emefz.fortcraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import org.altervista.emefz.fortcraft.handler.particle.ParticleType;
import org.altervista.emefz.fortcraft.util.Pos3D;

import java.util.Random;

public abstract class JetpackParticleHelper {
    public static void showJetpackParticles(World world, EntityLivingBase wearer, ParticleType particle) {
        if(particle == ParticleType.DEFAULT) {
            Minecraft mc = Minecraft.getMinecraft();
            if (mc.gameSettings.particleSetting == 0 || mc.gameSettings.particleSetting == 1 && mc.world.getTotalWorldTime() % 4L == 0) {

                Random rand = new Random();
                float random = (rand.nextFloat() - 0.5F) * 0.1F;

                Pos3D playerPos = new Pos3D(wearer).translate(0, 1.5, 0);

                Pos3D vLeft = new Pos3D(-0.28, -0.95, -0.35).rotatePitch(0).rotateYaw(wearer.renderYawOffset);
                Pos3D vRight = new Pos3D(0.28, -0.95, -0.35).rotatePitch(0).rotateYaw(wearer.renderYawOffset);
                Pos3D vCenter = new Pos3D((rand.nextFloat() - 0.5F) * 0.25F, -0.95, -0.38).rotatePitch(0).rotateYaw(wearer.renderYawOffset);

                Pos3D v = playerPos.translate(vLeft).translate(new Pos3D(wearer.motionX, wearer.motionY, wearer.motionZ));
                mc.effectRenderer.addEffect(new EntityCustomFlameFX(world, v.x, v.y, v.z, random, -0.2D, random));

                v = playerPos.translate(vRight).translate(new Pos3D(wearer.motionX, wearer.motionY, wearer.motionZ));
                mc.effectRenderer.addEffect(new EntityCustomFlameFX(world, v.x, v.y, v.z, random, -0.2D, random));

                v = playerPos.translate(vCenter).translate(new Pos3D(wearer.motionX, wearer.motionY, wearer.motionZ));
                mc.effectRenderer.addEffect(new EntityCustomFlameFX(world, v.x, v.y, v.z, random, -0.2D, random));
            }
        }
    }
}
