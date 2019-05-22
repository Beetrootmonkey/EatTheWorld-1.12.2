package com.beetrootmonkey.eattheworld.crafting;

import com.beetrootmonkey.eattheworld.Main;
import com.beetrootmonkey.eattheworld.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.beetrootmonkey.eattheworld.config.ModConfig.RECIPES;
import static com.beetrootmonkey.eattheworld.crafting.RecipeUtils.removeRecipes;

public class ModRecipes {

    private static List<IRecipe> recipes = new ArrayList<>();

    private static void registerCraftingRecipes() {
        String group = Main.MOD_ID;

        if (RECIPES.cocoaPowder && !Loader.isModLoaded("harvestcraft")) {
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.cocoa_powder), toIngredients(
                    new ItemStack(Items.DYE, 1, 3))).setRegistryName("cocoa_powder"));
        }

        if (RECIPES.dough && !Loader.isModLoaded("harvestcraft")) {
            if (OreDictionary.doesOreNameExist("foodFlour")) {
                for (int i = 1; i < 9; i++) {
                    Ingredient[] ingredients = new Ingredient[i + 1];
                    Arrays.fill(ingredients, toIngredient("foodFlour"));
                    ingredients[0] = Ingredient.fromItem(Items.WATER_BUCKET);
                    recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.dough, i),
                            toIngredients(ingredients)).setRegistryName("dough_" + i));
                }
            }
        }


        if (RECIPES.fuelPellet) {
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.fuel_pellet, 8),
                    toIngredients(Ingredient.fromStacks(new ItemStack(Items.COAL), new ItemStack(Items.COAL, 1, 1)))).setRegistryName("fuel_pellet_coal"));

            if (OreDictionary.doesOreNameExist("fuelCoke")) {
                recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.fuel_pellet, 16),
                        toIngredients(toIngredient("fuelCoke"))).setRegistryName("fuel_pellet_coke"));
            }
        }

        if (RECIPES.horseHairToString) {
            recipes.add(new ShapedRecipes(group, 3, 1, toIngredients(ModItems.horse_hair, ModItems.horse_hair,
                    ModItems.horse_hair), new ItemStack(Items.STRING, 2)).setRegistryName("horse_hair_to_string"));
        }

        if (RECIPES.jelly) {
            if (OreDictionary.doesOreNameExist("listAllsugar")) {
                recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.jelly_cube),
                        toIngredients(toIngredient("slimeball"), toIngredient("listAllsugar"))).setRegistryName("sugar_to_jelly"));
            } else {
                recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.jelly_cube),
                        toIngredients(toIngredient("slimeball"), Ingredient.fromItem(Items.SUGAR))).setRegistryName("sugar_to_jelly"));
            }
        }

        if (!Loader.isModLoaded("harvestcraft")) {
            switch (RECIPES.bread) {
                case 4:
                    removeRecipes("minecraft:bread");
                    GameRegistry.addSmelting(ModItems.raw_bread, new ItemStack(Items.BREAD), 0.35f);
                case 3:
                    recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.raw_bread),
                            toIngredients(toIngredient("foodDough"), toIngredient("foodDough"),
                                    toIngredient("foodDough"))).setRegistryName("bread_from_dough"));
                    break;
                case 2:
                    removeRecipes("minecraft:bread");
                    recipes.add(new ShapelessRecipes(group, new ItemStack(Items.BREAD),
                            toIngredients(toIngredient("foodDough"), toIngredient("foodDough"),
                                    toIngredient("foodDough"))).setRegistryName("bread_from_dough"));
                    break;
                case 1:
                    removeRecipes("minecraft:bread");
                    break;
            }
        } else {
            removeRecipes("minecraft:bread");
        }


        if (RECIPES.torchesPerFat > 0) {
            if(OreDictionary.doesOreNameExist("stickWood")) {
                recipes.add(new ShapedRecipes(group, 1, 2, toIngredients(toIngredient("itemFat"), toIngredient("stickWood")),
                        new ItemStack(Item.getItemFromBlock(Blocks.TORCH), RECIPES.torchesPerFat)).setRegistryName("torches_from_fat"));
            } else {
                recipes.add(new ShapedRecipes(group, 1, 2, toIngredients(toIngredient("itemFat"), Ingredient.fromItem(Items.STICK)),
                        new ItemStack(Item.getItemFromBlock(Blocks.TORCH), RECIPES.torchesPerFat)).setRegistryName("torches_from_fat"));
            }

        }

        switch (RECIPES.cookie) {
            case 4:
                removeRecipes("minecraft:cookie");
                GameRegistry.addSmelting(ModItems.raw_cookie, new ItemStack(Items.COOKIE), 0.35f);
            case 3:
                if(OreDictionary.doesOreNameExist("foodChocolatebar")) {
                    recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.raw_cookie, 8),
                            toIngredients(toIngredient("foodChocolatebar"), toIngredient("foodDough"),
                                    toIngredient("foodDough"))).setRegistryName("cookies_from_dough"));
                } else {
                    recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.raw_cookie, 8),
                            toIngredients(toIngredient("foodCocoapowder"), toIngredient("foodDough"),
                                    toIngredient("foodDough"), Ingredient.fromItem(Items.SUGAR))).setRegistryName("cookies_from_dough"));
                }
                break;
            case 2:
                if(OreDictionary.doesOreNameExist("foodChocolatebar")) {
                    recipes.add(new ShapelessRecipes(group, new ItemStack(Items.COOKIE, 8),
                            toIngredients(toIngredient("foodChocolatebar"), toIngredient("foodDough"),
                                    toIngredient("foodDough"))).setRegistryName("cookies_from_dough"));
                } else {
                    recipes.add(new ShapelessRecipes(group, new ItemStack(Items.COOKIE, 8),
                            toIngredients(toIngredient("foodCocoapowder"), toIngredient("foodDough"),
                                    toIngredient("foodDough"), Ingredient.fromItem(Items.SUGAR))).setRegistryName("cookies_from_dough"));
                }
                break;
            case 1:
                removeRecipes("minecraft:cookie");
                break;
        }

        if (RECIPES.seedsToFlour > 0 && !Loader.isModLoaded("harvestcraft")) {
            Item[] arr = new Item[RECIPES.seedsToFlour];
            Arrays.fill(arr, Items.WHEAT_SEEDS);
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.flour),
                    toIngredients(arr)).setRegistryName("seeds_to_flour"));
        }

        if (RECIPES.wheatToFlour > 0 && !Loader.isModLoaded("harvestcraft")) {
            Item[] arr = new Item[RECIPES.wheatToFlour];
            Arrays.fill(arr, Items.WHEAT);
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.flour),
                    toIngredients(arr)).setRegistryName("wheat_to_flour"));
        }

        if (RECIPES.wheatToSeeds > 0) {
            recipes.add(new ShapelessRecipes(group, new ItemStack(Items.WHEAT_SEEDS, RECIPES.wheatToSeeds),
                    toIngredients(Ingredient.fromItem(Items.WHEAT))).setRegistryName("wheat_to_seeds"));
        }
    }

    private static void registerSmeltingRecipes() {

        if (RECIPES.cookedBat) {
            GameRegistry.addSmelting(ModItems.raw_bat, new ItemStack(ModItems.cooked_bat), 0.35f);
        }
        if (RECIPES.cookedCat) {
            GameRegistry.addSmelting(ModItems.raw_cat, new ItemStack(ModItems.cooked_cat), 0.35f);
        }

        if (RECIPES.cookedDragon) {
            GameRegistry.addSmelting(ModItems.raw_dragon, new ItemStack(ModItems.cooked_dragon), 0.35f);
        }

        if (RECIPES.cookedGuardian) {
            GameRegistry.addSmelting(ModItems.raw_guardian, new ItemStack(ModItems.cooked_guardian), 0.35f);
        }

        if (RECIPES.cookedHorse) {
            GameRegistry.addSmelting(ModItems.raw_horse, new ItemStack(ModItems.cooked_horse), 0.35f);
        }

        if (RECIPES.cookedShulker) {
            GameRegistry.addSmelting(ModItems.raw_shulker, new ItemStack(ModItems.cooked_shulker), 0.35f);
        }

        if (RECIPES.cookedSilverfish) {
            GameRegistry.addSmelting(ModItems.raw_silverfish, new ItemStack(ModItems.cooked_silverfish), 0.35f);
        }

        if (RECIPES.cookedSpiderEye) {
            GameRegistry.addSmelting(Items.SPIDER_EYE, new ItemStack(ModItems.cooked_spider_eye), 0.35f);
        }

        if (RECIPES.cookedSquid) {
            GameRegistry.addSmelting(ModItems.raw_squid, new ItemStack(ModItems.cooked_squid), 0.35f);
        }

        if (RECIPES.cookedVillager) {
            GameRegistry.addSmelting(ModItems.raw_villager, new ItemStack(ModItems.cooked_villager), 0.35f);
        }

        if (RECIPES.cookedWolf) {
            GameRegistry.addSmelting(ModItems.raw_wolf, new ItemStack(ModItems.cooked_wolf), 0.35f);
        }

        if (RECIPES.gelatin) {
            GameRegistry.addSmelting(Items.BONE, new ItemStack(ModItems.gelatin), 0.35f);
        }
    }

    public static void register() {
        registerCraftingRecipes();
        recipes.forEach(ForgeRegistries.RECIPES::register);

        registerSmeltingRecipes();
    }

    private static NonNullList<Ingredient> toIngredients(Ingredient... ingredients) {
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(Arrays.asList(ingredients));
        return list;
    }

    private static NonNullList<Ingredient> toIngredients(Item... ingredients) {
        Ingredient[] list = Arrays.stream(ingredients).map(Ingredient::fromItems).toArray(Ingredient[]::new);
        return toIngredients(list);
    }

    private static NonNullList<Ingredient> toIngredients(ItemStack... ingredients) {
        Ingredient[] list = Arrays.stream(ingredients).map(Ingredient::fromStacks).toArray(Ingredient[]::new);
        return toIngredients(list);
    }

    private static Ingredient toIngredient(String oreDictName) {
        if (OreDictionary.doesOreNameExist(oreDictName)) {
            List<ItemStack> ingredients = OreDictionary.getOres(oreDictName);
            ItemStack[] stacks = new ItemStack[ingredients.size()];
            return Ingredient.fromStacks(ingredients.toArray(stacks));
        }
        return null;
    }
}
