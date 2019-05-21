package com.beetrootmonkey.eattheworld.drops;

import com.beetrootmonkey.eattheworld.config.Cfg.Drops;
import com.beetrootmonkey.eattheworld.init.Main;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableLoadEventHandler {

	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent evt) {
		String prefix = "minecraft:";
		String name = evt.getName().toString();

		if (name.startsWith(prefix)) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			if (file.equals("entities/bat")) {
				if (Drops.bat) {
					evt.getTable().addPool(getInjectPool("entities/bat"));
				}
			} else if (file.equals("entities/ocelot")) {
				if (Drops.cat) {
					evt.getTable().addPool(getInjectPool("entities/ocelot"));
				}
			} else if (file.equals("entities/elder_guardian")) {
				if (Drops.elderGuardian) {
					evt.getTable().getPool("pool1").removeEntry("minecraft:fish");
					evt.getTable().getPool("pool1").addEntry(getInjectEntry("entities/elder_guardian", 1));
				}
			} else if (file.equals("entities/ghast")) {
				if (Drops.ghast) {
					evt.getTable().addPool(getInjectPool("entities/ghast"));
				}
			} else if (file.equals("entities/guardian")) {
				if (Drops.guardian) {
					evt.getTable().getPool("pool1").removeEntry("minecraft:fish");
					evt.getTable().getPool("pool1").addEntry(getInjectEntry("entities/guardian", 1));
				}
			} else if (file.equals("entities/horse")) {
				if (Drops.horse) {
					evt.getTable().addPool(getInjectPool("entities/horse_meat", 0));
				}
				if (Drops.horseHair) {
					evt.getTable().addPool(getInjectPool("entities/horse_hair", 1));
				}
			} else if (file.equals("entities/donkey")) {
				if (Drops.horse) {
					evt.getTable().addPool(getInjectPool("entities/donkey_meat", 0));
				}
				if (Drops.horseHair) {
					evt.getTable().addPool(getInjectPool("entities/donkey_hair", 1));
				}
			} else if (file.equals("entities/pig")) {
				if (Drops.fat) {
					evt.getTable().addPool(getInjectPool("entities/pig"));
				}
			} else if (file.equals("entities/shulker")) {
				if (Drops.shulker) {
					evt.getTable().addPool(getInjectPool("entities/shulker"));
				}
			} else if (file.equals("entities/silverfish")) {
				if (Drops.silverfish) {
					evt.getTable().addPool(getInjectPool("entities/silverfish"));
				}
			} else if (file.equals("entities/spider")) {
				if (Drops.cookedSpiderEye) {
					evt.getTable().removePool("pool1");
					evt.getTable().addPool(getInjectPool("entities/spider_eye", 0));
				}
				if (Drops.spiderLeg) {
					evt.getTable().addPool(getInjectPool("entities/spider_leg", 1));
				}
			} else if (file.equals("entities/cave_spider")) {
				if (Drops.cookedSpiderEye) {
					evt.getTable().removePool("pool1");
					evt.getTable().addPool(getInjectPool("entities/spider_eye", 0));
				}
				if (Drops.spiderLeg) {
					evt.getTable().addPool(getInjectPool("entities/spider_leg", 1));
				}
			} else if (file.equals("entities/squid")) {
				if (Drops.squid == 2 || Drops.squid == 1 && !Loader.isModLoaded("harvestcraft")) {
					evt.getTable().addPool(getInjectPool("entities/squid"));
				}
			} else if (file.equals("entities/villager")) {
				if (Drops.villager) {
					evt.getTable().addPool(getInjectPool("entities/villager"));
				}
			} else if (file.equals("entities/wither_skeleton")) {
				if (false) {
					evt.getTable().addPool(getInjectPool("entities/wither_skeleton"));
				}
			} else if (file.equals("entities/wolf")) {
				if (Drops.wolf) {
					evt.getTable().addPool(getInjectPool("entities/wolf"));
				}
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
