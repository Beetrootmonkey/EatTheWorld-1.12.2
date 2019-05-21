package com.beetrootmonkey.eattheworld.config;

import com.beetrootmonkey.eattheworld.init.Main;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeInt;

@Config(modid = Main.MOD_ID)
public class Cfg {
	public static Recipes recipes = new Recipes();
	public static Drops drops = new Drops();

	public static class Recipes {

		@Name("Cocoa Powder")
		public static boolean cocoaPowder = true;
		public static boolean cookedBat = true;
		public static boolean cookedCat = true;
		public static boolean cookedDragon = true;
		public static boolean cookedGuardian = true;
		public static boolean cookedHorse = true;
		public static boolean cookedShulker = true;
		public static boolean cookedSilverfish = true;
		public static boolean cookedSpiderEye = true;
		public static boolean cookedSpiderLeg = true;
		public static boolean cookedSquid = true;
		public static boolean cookedVillager = true;
		public static boolean cookedWolf = true;

		@Comment({ "How much wheat is needed to craft 1 flour (use 0 to disable)" })
		@RangeInt(min = 0, max = 8)
		public static int wheatToFlour = 1;

		@Comment({ "How much seeds 1 wheat yields (use 0 to disable)" })
		@RangeInt(min = 0, max = 64)
		public static int wheatToSeeds = 3;

		@Comment({ "How much seeds are needed for 1 flour (use 0 to disable)" })
		@RangeInt(min = 0, max = 64)
		public static int seedsToFlour = 3;
		public static boolean dough = true;
		// Burntime, 0 = disable
		@RangeInt(min = 0)
		public static int fatAsFuel = 400;
		public static int fatForTorches = 2;
		public static boolean fuelPellet = true;
		public static boolean gelatin = true;
		public static boolean horseHairToString = true;
		public static boolean jelly = true;
		public static int bread = 4;
		public static int cookie = 4;
	}

	public static class Drops {
		public static boolean bat = true;
		public static boolean cat = true;
		public static boolean dragon = true;
		public static boolean elderGuardian = true;
		public static boolean ghast = true;
		public static boolean guardian = true;
		public static boolean horse = true;
		public static boolean shulker = true;
		public static boolean silverfish = true;
		public static boolean cookedSpiderEye = true;
		public static boolean spiderLeg = true;
		public static int squid = 1;
		public static boolean villager = true;
		public static boolean wolf = true;
		public static boolean fat = true;
		public static boolean horseHair = true;
	}
}