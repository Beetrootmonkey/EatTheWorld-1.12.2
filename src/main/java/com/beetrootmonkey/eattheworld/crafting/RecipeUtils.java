package com.beetrootmonkey.eattheworld.crafting;

import com.beetrootmonkey.eattheworld.Main;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class RecipeUtils {
    private static List<String> keysToRemove = new ArrayList<>();
    static void removeRecipes(String key) {
        keysToRemove.add(key);
    }

    public static void doRemoval() {
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;

        keysToRemove.forEach(key -> {
            IRecipe recipe = ForgeRegistries.RECIPES.getValue(new ResourceLocation(key));
            if (recipe != null) {
                ResourceLocation registryName = recipe.getRegistryName();
                recipeRegistry.remove(registryName);
                Main.LOG.debug(String.format("Removed recipe '%s'", key));
            } else {

                Main.LOG.warn(String.format("Removal of recipe '%s' failed!", key));
            }
        });
    }
}
