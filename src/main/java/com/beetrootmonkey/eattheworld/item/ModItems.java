package com.beetrootmonkey.eattheworld.item;

import com.beetrootmonkey.eattheworld.config.Cfg.Recipes;
import com.beetrootmonkey.eattheworld.init.Main;
import com.beetrootmonkey.eattheworld.item.edible.ItemModFood;
import com.beetrootmonkey.eattheworld.item.fuel.ItemFuel;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Arrays;

@ObjectHolder(Main.MOD_ID)
public class ModItems {
    @ObjectHolder("cocoa_powder")
    public static Item cocoa_powder;
    @ObjectHolder("cooked_bat")
    public static Item cooked_bat;
    @ObjectHolder("cooked_cat")
    public static Item cooked_cat;
    @ObjectHolder("cooked_dragon")
    public static Item cooked_dragon;
    @ObjectHolder("cooked_endermite")
    public static Item cooked_endermite;
    @ObjectHolder("cooked_guardian")
    public static Item cooked_guardian;
    @ObjectHolder("cooked_horse")
    public static Item cooked_horse;
    @ObjectHolder("cooked_shulker")
    public static Item cooked_shulker;
    @ObjectHolder("cooked_silverfish")
    public static Item cooked_silverfish;
    @ObjectHolder("cooked_spider_eye")
    public static Item cooked_spider_eye;
    @ObjectHolder("cooked_spider_leg")
    public static Item cooked_spider_leg;
    @ObjectHolder("cooked_squid")
    public static Item cooked_squid;
    @ObjectHolder("cooked_villager")
    public static Item cooked_villager;
    @ObjectHolder("cooked_wolf")
    public static Item cooked_wolf;
    @ObjectHolder("dough")
    public static Item dough;
    @ObjectHolder("fat")
    public static Item fat;
    @ObjectHolder("flour")
    public static Item flour;
    @ObjectHolder("fuel_pellet")
    public static Item fuel_pellet;
    @ObjectHolder("gelatin")
    public static Item gelatin;
    @ObjectHolder("horse_hair")
    public static Item horse_hair;
    @ObjectHolder("jelly_cube")
    public static Item jelly_cube;
    @ObjectHolder("raw_bat")
    public static Item raw_bat;
    @ObjectHolder("raw_bread")
    public static Item raw_bread;
    @ObjectHolder("raw_cat")
    public static Item raw_cat;
    @ObjectHolder("raw_cookie")
    public static Item raw_cookie;
    @ObjectHolder("raw_dragon")
    public static Item raw_dragon;
    @ObjectHolder("raw_endermite")
    public static Item raw_endermite;
    @ObjectHolder("raw_ghast")
    public static Item raw_ghast;
    @ObjectHolder("raw_guardian")
    public static Item raw_guardian;
    @ObjectHolder("raw_horse")
    public static Item raw_horse;
    @ObjectHolder("raw_shulker")
    public static Item raw_shulker;
    @ObjectHolder("raw_silverfish")
    public static Item raw_silverfish;
    @ObjectHolder("raw_spider_leg")
    public static Item raw_spider_leg;
    @ObjectHolder("raw_squid")
    public static Item raw_squid;
    @ObjectHolder("raw_villager")
    public static Item raw_villager;
    @ObjectHolder("raw_wolf")
    public static Item raw_wolf;
    @ObjectHolder("withered_bone")
    public static Item withered_bone;

    private static Item[] items = new Item[]
            {
                    new ItemBase("cocoa_powder"),
                    new ItemModFood("cooked_bat", 4, 5f, true),
                    new ItemModFood("cooked_cat", 5, 6f, true),
                    new ItemModFood("cooked_dragon", 1, 1f, true),
                    new ItemModFood("cooked_endermite", 1, 1f),
                    new ItemModFood("cooked_guardian", 5, 6f, true),
                    new ItemModFood("cooked_horse", 8, 12.8f, true),
                    new ItemModFood("cooked_shulker", 4, 8f, true),
                    new ItemModFood("cooked_silverfish", 4, 5f, true),
                    new ItemModFood("cooked_spider_eye", 4, 5f, true),
                    new ItemModFood("cooked_spider_leg", 1, 1f, true),
                    new ItemModFood("cooked_squid", 5, 8f, true),
                    new ItemModFood("cooked_villager", 6, 9.6f, true),
                    new ItemModFood("cooked_wolf", 5, 6f, true),
                    new ItemBase("dough"),
                    new ItemFuel("fat", Recipes.fatAsFuel),
                    new ItemBase("flour"),
                    new ItemFuel("fuel_pellet", 200),
                    new ItemBase("gelatin"),
                    new ItemBase("horse_hair"),
                    new ItemModFood("jelly_cube", 3, 4f, false),
                    new ItemModFood("raw_bat", 1, 0.3f, true),
                    new ItemBase("raw_bread"),
                    new ItemModFood("raw_cat", 2, 0.3f, true),
                    new ItemModFood("raw_cookie", 1, 0.3f),
                    new ItemModFood("raw_dragon", 1, 1f, true),
                    new ItemModFood("raw_endermite", 1, 1f),
                    new ItemModFood("raw_ghast", 4, 6f, true),
                    new ItemModFood("raw_guardian", 2, 0.4f, true),
                    new ItemModFood("raw_horse", 3, 1.8f, true),
                    new ItemModFood("raw_shulker", 1, 0.1f, true),
                    new ItemModFood("raw_silverfish", 1, 0.1f, true),
                    new ItemModFood("raw_spider_leg", 1, 0.2f, true),
                    new ItemModFood("raw_squid", 2, 0.4f, true),
                    new ItemModFood("raw_villager", 2, 0.4f, true),
                    new ItemModFood("raw_wolf", 2, 0.4f, true),
                    new ItemBase("withered_bone")
            };

    public static void register() {
        Arrays.stream(items).forEach(ModItems::register);
    }

    private static void register(Item item) {
        ForgeRegistries.ITEMS.register(item);
        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider) item).registerItemModel();
        }
    }

    public static void registerOres() {
        OreDictionary.registerOre("listAllmeatraw", raw_cat);
        OreDictionary.registerOre("listAllmeatraw", raw_dragon);
        OreDictionary.registerOre("listAllmeatraw", raw_ghast);
        OreDictionary.registerOre("listAllmeatraw", raw_horse);
        OreDictionary.registerOre("listAllmeatraw", raw_villager);
        OreDictionary.registerOre("listAllmeatraw", raw_wolf);

        OreDictionary.registerOre("listAllfishraw", raw_guardian);
        OreDictionary.registerOre("listAllfishraw", raw_squid);

        OreDictionary.registerOre("listAllmeatcooked", cooked_cat);
        OreDictionary.registerOre("listAllmeatcooked", cooked_dragon);
        OreDictionary.registerOre("listAllmeatcooked", cooked_horse);
        OreDictionary.registerOre("listAllmeatcooked", cooked_villager);
        OreDictionary.registerOre("listAllmeatcooked", cooked_wolf);

        OreDictionary.registerOre("listAllfishcooked", cooked_guardian);
        OreDictionary.registerOre("listAllfishcooked", cooked_squid);

        OreDictionary.registerOre("itemFat", fat);
        OreDictionary.registerOre("foodCocoapowder", cocoa_powder);
        OreDictionary.registerOre("foodDough", dough);
        OreDictionary.registerOre("foodFlour", flour);
        OreDictionary.registerOre("slimeball", gelatin);
    }
}