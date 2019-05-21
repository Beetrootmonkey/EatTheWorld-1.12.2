package com.beetrootmonkey.eattheworld.crafting;

import com.beetrootmonkey.eattheworld.config.Cfg;
import com.beetrootmonkey.eattheworld.config.Cfg.Recipes;
import com.beetrootmonkey.eattheworld.init.Main;
import com.beetrootmonkey.eattheworld.item.ModItems;
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
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.beetrootmonkey.eattheworld.crafting.RecipeUtils.*;

public class ModRecipes {

    private static List<IRecipe> recipes = new ArrayList<>();

    private static void registerCraftingRecipes() {
        String group = Main.MOD_ID;

        if (Recipes.cocoaPowder && !Loader.isModLoaded("harvestcraft")) {
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.cocoa_powder), toIngredients(
                    new ItemStack(Items.DYE, 1, 3))).setRegistryName("cocoa_powder"));
        }

        if (Recipes.dough && !Loader.isModLoaded("harvestcraft")) {
            if (OreDictionary.doesOreNameExist("foodFlour")) {
                recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.fuel_pellet, 16),
                        toIngredients(toIngredient("foodFlour"), Ingredient.fromItem(Items.WATER_BUCKET))).setRegistryName("dough"));
            }
        }


        if (Recipes.fuelPellet) {
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.fuel_pellet, 8),
                    toIngredients(Ingredient.fromStacks(new ItemStack(Items.COAL), new ItemStack(Items.COAL, 1, 1)))).setRegistryName("fuel_pellet_coal"));

            if (OreDictionary.doesOreNameExist("fuelCoke")) {
                recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.fuel_pellet, 16),
                        toIngredients(toIngredient("fuelCoke"))).setRegistryName("fuel_pellet_coke"));
            }
        }

        if (Recipes.horseHairToString) {
            recipes.add(new ShapedRecipes(group, 3, 1, toIngredients(ModItems.horse_hair, ModItems.horse_hair,
                    ModItems.horse_hair), new ItemStack(Items.STRING, 2)).setRegistryName("horse_hair_to_string"));
        }

        if (Recipes.jelly) {
            if (OreDictionary.doesOreNameExist("listAllsugar")) {
                recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.jelly_cube),
                        toIngredients(toIngredient("slimeball"), toIngredient("listAllsugar"))).setRegistryName("sugar_to_jelly"));
            } else {
                recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.jelly_cube),
                        toIngredients(toIngredient("slimeball"), Ingredient.fromItem(Items.SUGAR))).setRegistryName("sugar_to_jelly"));
            }
        }

        if(!Loader.isModLoaded("harvestcraft")) {
            switch (Recipes.bread) {
                case 4:
                    removeRecipes(Items.BREAD, Items.WHEAT);
                    GameRegistry.addSmelting(ModItems.raw_bread, new ItemStack(Items.BREAD), 0.35f);
                case 3:
                    recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.raw_bread),
                            toIngredients(toIngredient("foodDough"))).setRegistryName("bread_from_dough"));
                    break;
                case 2:
                    removeRecipes(Items.BREAD, Items.WHEAT);
                    recipes.add(new ShapelessRecipes(group, new ItemStack(Items.BREAD),
                            toIngredients(toIngredient("foodDough"))).setRegistryName("bread_from_dough"));
                    break;
                case 1:
                    removeRecipes(Items.BREAD, Items.WHEAT);
                    break;
            }
        } else {
            removeRecipes(Items.BREAD, Items.WHEAT);
        }


//        if (Cfg.Recipes.fatForTorches > 0) {
//            if(OreDictionary.doesOreNameExist("stickWood")) {
//                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(Blocks.TORCH), Cfg.Recipes.fatForTorches),
//                        "F", "S", 'F', "itemFat", 'S', "stickWood"));
//            } else {
//                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(Blocks.TORCH), Cfg.Recipes.fatForTorches),
//                        "F", "S", 'F', "itemFat",'S', Items.STICK));
//            }
//
//        }

//        switch (Cfg.Recipes.cookie) {
//            case 4:
//                removeRecipe(Items.COOKIE);
//                GameRegistry.addSmelting(ModItems.raw_cookie, new ItemStack(Items.COOKIE), 0.35f);
//            case 3:
//                if(OreDictionary.doesOreNameExist("foodChocolatebar")) {
//                    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.raw_cookie, 16), "foodChocolatebar", "foodDough", "foodDough"));
//                } else {
//                    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.raw_cookie, 16), "foodCocoapowder", "foodDough", "foodDough"));
//                }
//                break;
//            case 2:
//                removeRecipe(Items.COOKIE);
//                if(OreDictionary.doesOreNameExist("foodChocolatebar")) {
//                    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.COOKIE, 16), "foodChocolatebar", "foodDough", "foodDough"));
//                } else {
//                    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.COOKIE, 16), "foodCocoapowder", "foodDough", "foodDough"));
//                }
//                break;
//            case 1:
//                removeRecipe(Items.COOKIE);
//                break;
//        }
//
        if (Recipes.seedsToFlour > 0 && !Loader.isModLoaded("harvestcraft")) {
            Object[] arr = IntStream.range(0, Recipes.seedsToFlour).mapToObj(i -> Items.WHEAT_SEEDS).toArray();
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.flour),
                    toIngredients((Item[])arr)).setRegistryName("seeds_to_flour"));
        }

        if (Recipes.wheatToFlour > 0 && !Loader.isModLoaded("harvestcraft")) {
            Object[] arr = IntStream.range(0, Recipes.wheatToFlour).mapToObj(i -> OreDictionary.doesOreNameExist("cropWheat") ? "cropWheat" : Items.WHEAT).toArray();
            recipes.add(new ShapelessRecipes(group, new ItemStack(ModItems.flour),
                    toIngredients((Item[])arr)).setRegistryName("wheat_to_flour"));
        }

        if (Recipes.wheatToSeeds > 0) {
            recipes.add(new ShapelessRecipes(group, new ItemStack(Items.WHEAT_SEEDS, Recipes.wheatToSeeds),
                    toIngredients(Ingredient.fromItem(Items.WHEAT))).setRegistryName("wheat_to_seeds"));
        }
    }

    private static void registerSmeltingRecipes() {

        if (Recipes.cookedBat) {
            GameRegistry.addSmelting(ModItems.raw_bat, new ItemStack(ModItems.cooked_bat), 0.35f);
        }
        if (Recipes.cookedCat) {
            GameRegistry.addSmelting(ModItems.raw_cat, new ItemStack(ModItems.cooked_cat), 0.35f);
        }

        if (Recipes.cookedDragon) {
            GameRegistry.addSmelting(ModItems.raw_dragon, new ItemStack(ModItems.cooked_dragon), 0.35f);
        }

        if (Recipes.cookedGuardian) {
            GameRegistry.addSmelting(ModItems.raw_guardian, new ItemStack(ModItems.cooked_guardian), 0.35f);
        }

        if (Recipes.cookedHorse) {
            GameRegistry.addSmelting(ModItems.raw_horse, new ItemStack(ModItems.cooked_horse), 0.35f);
        }

        if (Recipes.cookedShulker) {
            GameRegistry.addSmelting(ModItems.raw_shulker, new ItemStack(ModItems.cooked_shulker), 0.35f);
        }

        if (Recipes.cookedSilverfish) {
            GameRegistry.addSmelting(ModItems.raw_silverfish, new ItemStack(ModItems.cooked_silverfish), 0.35f);
        }

        if (Recipes.cookedSpiderEye) {
            GameRegistry.addSmelting(Items.SPIDER_EYE, new ItemStack(ModItems.cooked_spider_eye), 0.35f);
        }

        if (Recipes.cookedSpiderLeg) {
            GameRegistry.addSmelting(ModItems.raw_spider_leg, new ItemStack(ModItems.cooked_spider_leg), 0.35f);
        }

        if (Recipes.cookedSquid) {
            GameRegistry.addSmelting(ModItems.raw_squid, new ItemStack(ModItems.cooked_squid), 0.35f);
        }

        if (Recipes.cookedVillager) {
            GameRegistry.addSmelting(ModItems.raw_villager, new ItemStack(ModItems.cooked_villager), 0.35f);
        }

        if (Recipes.cookedWolf) {
            GameRegistry.addSmelting(ModItems.raw_wolf, new ItemStack(ModItems.cooked_wolf), 0.35f);
        }

        if (Recipes.gelatin) {
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

    private static NonNullList<Ingredient> toIngredients(String oreDictName) {
        if (OreDictionary.doesOreNameExist(oreDictName)) {
            List<ItemStack> ingredients = OreDictionary.getOres(oreDictName);
            ItemStack[] stacks = new ItemStack[ingredients.size()];
            return toIngredients(Ingredient.fromStacks(stacks));
        }
        return NonNullList.create();
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
