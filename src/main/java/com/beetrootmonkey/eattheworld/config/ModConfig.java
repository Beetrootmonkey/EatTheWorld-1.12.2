package com.beetrootmonkey.eattheworld.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.beetrootmonkey.eattheworld.Main.LOG;
import static com.beetrootmonkey.eattheworld.Main.MOD_ID;

@Config(modid = MOD_ID)
public class ModConfig {

    public static final Recipes RECIPES = new Recipes();
    public static final Drops DROPS = new Drops();

    public static class Recipes {

        @Name("Cocoa Powder")
        public boolean cocoaPowder = true;

        @Name("Cooked Bat")
        public boolean cookedBat = true;

        @Name("Cooked Cat")
        public boolean cookedCat = true;

        @Name("Cooked Dragon")
        public boolean cookedDragon = true;

        @Name("Cooked Guardian")
        public boolean cookedGuardian = true;

        @Name("Cooked Horse")
        public boolean cookedHorse = true;

        @Name("Cooked Shulker")
        public boolean cookedShulker = true;

        @Name("Cooked Silverfish")
        public boolean cookedSilverfish = true;

        @Name("Cooked Spider Eye")
        public boolean cookedSpiderEye = true;

        @Name("Cooked Squid")
        public boolean cookedSquid = true;

        @Name("Cooked Villager")
        public boolean cookedVillager = true;

        @Name("Cooked Wolf")
        public boolean cookedWolf = true;

        @Comment({"Use 0 to disable"})
        @RangeInt(min = 0, max = 8)
        @Name("Wheat needed per Flour")
        public int wheatToFlour = 1;

        @Comment({"Use 0 to disable"})
        @RangeInt(min = 0, max = 64)
        @Name("Seeds gotten per Wheat")
        public int wheatToSeeds = 3;

        @Comment({"Use 0 to disable"})
        @RangeInt(min = 0, max = 64)
        @Name("Seeds needed per Flour")
        public int seedsToFlour = 3;

        @Name("Dough")
        public boolean dough = true;

        @RangeInt(min = 0)
        @Comment({"Use 0 to disable"})
        public int fatAsFuel = 400;

        @Comment("Use 0 to disable")
        @RangeInt(min = 0, max = 64)
        @Name("Torches gotten per fat")
        public int torchesPerFat = 2;
        public boolean fuelPellet = true;
        public boolean gelatin = true;
        public boolean horseHairToString = true;
        public boolean jelly = true;
        public int bread = 4;
        public int cookie = 4;
    }

    public static class Drops {
        public boolean bat = true;
        public boolean cat = true;
        public boolean dragon = true;
        public boolean elderGuardian = true;
        public boolean ghast = true;
        public boolean guardian = true;
        public boolean horse = true;
        public boolean shulker = true;
        public boolean silverfish = true;
        public boolean cookedSpiderEye = true;
        public boolean spiderLeg = true;
        public int squid = 1;
        public boolean villager = true;
        public boolean wolf = true;
        public boolean fat = true;
        public boolean horseHair = true;
    }

    @EventBusSubscriber(modid = MOD_ID)
    private static class EventHandler {

        @SubscribeEvent
        public static void onConfigChanged(final OnConfigChangedEvent event) {
            if (event.getModID().equals(MOD_ID)) {
                LOG.debug("Reloading config for EatTheWorld");
                ConfigManager.sync(MOD_ID, Type.INSTANCE);
            }
        }
    }
}