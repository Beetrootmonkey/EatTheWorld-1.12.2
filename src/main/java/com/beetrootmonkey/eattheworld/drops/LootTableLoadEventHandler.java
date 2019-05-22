package com.beetrootmonkey.eattheworld.drops;

import com.beetrootmonkey.eattheworld.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.beetrootmonkey.eattheworld.config.ModConfig.DROPS;

public class LootTableLoadEventHandler {

	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent evt) {
		String prefix = "minecraft:";
		String name = evt.getName().toString();

		if (name.startsWith(prefix)) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			switch (file) {
				case "entities/bat":
					if (DROPS.bat) {
						evt.getTable().addPool(getInjectPool("entities/bat"));
					}
					break;
				case "entities/ocelot":
					if (DROPS.cat) {
						evt.getTable().addPool(getInjectPool("entities/ocelot"));
					}
					break;
				case "entities/elder_guardian":
					if (DROPS.elderGuardian) {
						evt.getTable().getPool("pool1").removeEntry("minecraft:fish");
						evt.getTable().getPool("pool1").addEntry(getInjectEntry("entities/elder_guardian", 1));
					}
					break;
				case "entities/ghast":
					if (DROPS.ghast) {
						evt.getTable().addPool(getInjectPool("entities/ghast"));
					}
					break;
				case "entities/guardian":
					if (DROPS.guardian) {
						evt.getTable().getPool("pool1").removeEntry("minecraft:fish");
						evt.getTable().getPool("pool1").addEntry(getInjectEntry("entities/guardian", 1));
					}
					break;
				case "entities/horse":
					if (DROPS.horse) {
						evt.getTable().addPool(getInjectPool("entities/horse_meat", 0));
					}
					if (DROPS.horseHair) {
						evt.getTable().addPool(getInjectPool("entities/horse_hair", 1));
					}
					break;
				case "entities/donkey":
					if (DROPS.horse) {
						evt.getTable().addPool(getInjectPool("entities/donkey_meat", 0));
					}
					if (DROPS.horseHair) {
						evt.getTable().addPool(getInjectPool("entities/donkey_hair", 1));
					}
					break;
				case "entities/pig":
					if (DROPS.fat) {
						evt.getTable().addPool(getInjectPool("entities/pig"));
					}
					break;
				case "entities/shulker":
					if (DROPS.shulker) {
						evt.getTable().addPool(getInjectPool("entities/shulker"));
					}
					break;
				case "entities/silverfish":
					if (DROPS.silverfish) {
						evt.getTable().addPool(getInjectPool("entities/silverfish"));
					}
					break;
				case "entities/spider":
					if (DROPS.cookedSpiderEye) {
						evt.getTable().removePool("pool1");
						evt.getTable().addPool(getInjectPool("entities/spider_eye", 0));
					}
					if (DROPS.spiderLeg) {
						evt.getTable().addPool(getInjectPool("entities/spider_leg", 1));
					}
					break;
				case "entities/cave_spider":
					if (DROPS.cookedSpiderEye) {
						evt.getTable().removePool("pool1");
						evt.getTable().addPool(getInjectPool("entities/spider_eye", 0));
					}
					if (DROPS.spiderLeg) {
						evt.getTable().addPool(getInjectPool("entities/spider_leg", 1));
					}
					break;
				case "entities/squid":
					if (DROPS.squid == 2 || DROPS.squid == 1 && !Loader.isModLoaded("harvestcraft")) {
						evt.getTable().addPool(getInjectPool("entities/squid"));
					}
					break;
				case "entities/villager":
					if (DROPS.villager) {
						evt.getTable().addPool(getInjectPool("entities/villager"));
					}
					break;
				case "entities/wither_skeleton":
					if (false) {
						evt.getTable().addPool(getInjectPool("entities/wither_skeleton"));
					}
					break;
				case "entities/wolf":
					if (DROPS.wolf) {
						evt.getTable().addPool(getInjectPool("entities/wolf"));
					}
					break;
			}
			
		}
	}
	
	private static LootPool getInjectPool(String entryName) {
		return getInjectPool(entryName, 0);
	}

	private static LootPool getInjectPool(String entryName, int counter) {
		return new LootPool(new LootEntry[] { getInjectEntry(entryName, 1) }, new LootCondition[0],
				new RandomValueRange(1), new RandomValueRange(0, 1), "eattheworld_inject_pool_" + counter);
	}

	private static LootEntryTable getInjectEntry(String name, int weight) {
		return new LootEntryTable(new ResourceLocation(Main.MOD_ID, "inject/" + name), weight, 0,
				new LootCondition[0], "eattheworld_inject_entry");
	}
}
