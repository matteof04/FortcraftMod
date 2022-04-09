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

import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.Locale;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.altervista.emefz.fortcraft.Fortcraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TranslationHelper {
    public static void preInit(FMLPreInitializationEvent event){
        Fortcraft.DROPS_LANG = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/fortcraft/drops.lang");
        if(!new File(event.getModConfigurationDirectory().getAbsolutePath() + "/fortcraft/").exists()){
            new File(event.getModConfigurationDirectory().getAbsolutePath() + "/fortcraft/").mkdir();
        }
        if(!Fortcraft.DROPS_LANG.exists()){
            try {
                Fortcraft.DROPS_LANG.createNewFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        try {
            PrintWriter pw = new PrintWriter(Fortcraft.DROPS_LANG);
            pw.print("");
            pw.flush();
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void postInit(){
        if(FMLCommonHandler.instance().getSide().isClient()) {
            try {
                if(Fortcraft.DROPS_LANG.canRead()) {
                    LanguageMap.inject(new FileInputStream(Fortcraft.DROPS_LANG));
                    Fortcraft.logger.info("Injecting colorized translations...");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void registerItemTranslation(ItemStack stack, Rarity rarity){
        if(FMLCommonHandler.instance().getSide().isClient()) {
            try {
                if(Fortcraft.DROPS_LANG.canWrite()) {
                    PrintWriter writer = new PrintWriter(new FileOutputStream(Fortcraft.DROPS_LANG, true));
                    writer.println(stack.getUnlocalizedName() + ".name." + rarity.getStyle().getFormattingCode() + "=" + rarity.getStyle().getFormattingCode() + I18n.format(stack.getUnlocalizedName()+".name"));
                    writer.flush();
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static String getTranslatableName(ItemStack stack, Rarity rarity){
        return stack.getUnlocalizedName() + ".name." + rarity.getStyle().getFormattingCode();
    }
}
