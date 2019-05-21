package com.beetrootmonkey.eattheworld.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class ModLootTables {
	public static final ResourceLocation LOOT_TABLE_VILLAGER = register("entities/villager");
	
	private static ResourceLocation register(String id) {
		return LootTableList.register(new ResourceLocation(Main.MOD_ID, id));
	}
}
