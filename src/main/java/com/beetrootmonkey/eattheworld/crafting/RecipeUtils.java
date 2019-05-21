package com.beetrootmonkey.eattheworld.crafting;

import com.beetrootmonkey.eattheworld.init.Main;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeUtils {

    public static List<IRecipe> findRecipes(Object output) {
        if (!isItem(output)) {
            return new ArrayList<IRecipe>();
        }

        return CraftingManager.REGISTRY.getKeys().stream().map(CraftingManager::getRecipe)
                .filter(recipe -> recipe != null && equals(output, recipe.getRecipeOutput())).collect(Collectors.toList());
    }

    static void removeRecipes(Object output, Object... input) { // TODO: hängt sich auf (infinite loop, oder nur seeeehr langsam?). Logging/Debugging angesagt!
        if (!isItem(output)) {
            return;
        }
        List<IRecipe> recipesToRemove = new ArrayList<>();

        for (ResourceLocation key : CraftingManager.REGISTRY.getKeys()) {
            IRecipe recipe = CraftingManager.getRecipe(key);
            if (input.length == 0) {
                if (recipe != null && equals(output, recipe.getRecipeOutput())) {
                    recipesToRemove.add(recipe);
                }
            } else {
                boolean validRecipe = recipe != null && equals(output, recipe.getRecipeOutput());
                if (validRecipe) {
                    if (Arrays.stream(input).anyMatch(objIn -> !isIngredient(recipe, objIn))) {
                        validRecipe = false;
                    }
                    if (validRecipe) {
                        recipesToRemove.add(recipe);
                    }
                }
            }
        }

        // "Remove" (= replace) recipes
        IRecipe dummy = new DummyRecipe();
        for (ResourceLocation key : CraftingManager.REGISTRY.getKeys()) {
            CraftingManager.REGISTRY.putObject(key, dummy);
        }

        if (output instanceof String) {
            Main.LOG.info("Removed " + recipesToRemove.size() + " recipes with output " + output + "!");
        } else {
            ItemStack stack = convertToStack(output);
            Main.LOG.info("Removed " + recipesToRemove.size() + " recipes with output "
                    + (stack != null ? stack.getUnlocalizedName() : "null") + "!");
        }

    }

    public static boolean isObjectInList(Object[] list, Object item) {
        return isObjectInList(Arrays.asList(list), item);
    }

    private static boolean isObjectInList(List<?> list, Object item) {
        return completeList(list).stream().filter(RecipeUtils::isItem).anyMatch(stack -> equals(stack, item));
    }

    private static List<Object> completeList(List<?> list) {
        List<Object> listToReturn = new ArrayList<>();
        for (Object item : list) {
            if (isItem(item)) {
                listToReturn.add(item);
            } else if (item instanceof List<?>) {
                for (Object oreItem : (List<?>) item) {
                    if (isItem(oreItem)) {
                        listToReturn.add(oreItem);
                    }
                }
            }
        }
        return listToReturn;
    }

    private static boolean isIngredient(IRecipe recipe, Object item) {
        List<Ingredient> ingredients = recipe.getIngredients();

        List<ItemStack> input = new LinkedList<>();
        for (Ingredient i : ingredients) {
            input.addAll(Arrays.asList(i.getMatchingStacks()));
        }
        return isObjectInList(input, item);
    }

    private static ItemStack convertToStack(Object object) {
        if (object instanceof Block) {
            return new ItemStack(Item.getItemFromBlock((Block) object), 0);
        } else if (object instanceof Item) {
            return new ItemStack((Item) object, 0);
        } else if (object instanceof ItemStack) {
            ItemStack oldStack = (ItemStack) object;
            return new ItemStack(oldStack.getItem(), 0, oldStack.getMetadata());
        }
        return null;
    }

    private static boolean isItem(Object object) {
        return object instanceof String || object instanceof Item || object instanceof ItemStack
                || object instanceof Block;
    }

    public static boolean equals(Object object1, Object object2) {
        Main.LOG.debug(String.format("equals(%s, %s)", object1, object2));
        if (!isItem(object1) || !isItem(object2)) {
            return false;
        }

        if (object1 instanceof String) {
            if (object2 instanceof String) {
                return isOreEqualToOre((String) object1, (String) object2);
            } else {
                return equals((String) object1, convertToStack(object2));
            }
        } else {
            if (object2 instanceof String) {
                return isItemStackEqualToOre(convertToStack(object1), (String) object2);
            } else {
                return equals(convertToStack(object1), convertToStack(object2)); // TODO: StackOverflowError durch Rekursion fixen
            }
        }
    }

    private static boolean isItemStackEqualToOre(ItemStack stack, String ore) {
        return OreDictionary.getOres((String) ore).stream().map(entry -> new ItemStack(entry.getItem(), 0, entry.getMetadata())).anyMatch(entryStack -> ItemStack.areItemStacksEqual(entryStack, stack));
    }

    public static boolean equals(String ore, ItemStack stack) {
        return isItemStackEqualToOre(stack, ore);
    }

    private static boolean isOreEqualToOre(String ore1, String ore2) {
        return ore1.equals(ore2);
    }
}
