package com.beetrootmonkey.eattheworld.drops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber
public class BlockDropEventHandler {

	@SubscribeEvent
	public static void onBlockDrop(HarvestDropsEvent event) {
//		int x = event.getPos().getX();
//		int y = event.getPos().getY();
//		int z = event.getPos().getZ();
//
//		if (event.getWorld().isRemote) {
//			Main.LOG.info("CLIENT - aborting");
//			return;
//		}
//
//		Block block = event.getState().getBlock();
//		if (block.equals(Blocks.LEAVES) || block.equals(Blocks.LEAVES2)) {
//			Main.LOG.info("Leaves detected");
////			if (Math.random() < 0.5) {
////
////			}
//			Entity entity = new EntitySilverfish(event.getWorld());
//			entity.setLocationAndAngles(x + 0.5, y, z + 0.5, (float) (360 * Math.random()), (float) (360 * Math.random()));
//			event.getWorld().spawnEntity(entity);
//		}
	}


	private static void replaceDrop(Item filter, ItemStack replacement, HarvestDropsEvent event) {
		List<ItemStack> toRemove = new ArrayList<ItemStack>();
		for (ItemStack itemStack : event.getDrops()) {
			if (itemStack.getItem().equals(filter)) {
				replacement.setCount(itemStack.getCount());
				toRemove.add(itemStack);
				break;
			}
		}

		if(!toRemove.isEmpty()) {
			event.getDrops().removeAll(toRemove);
			event.getDrops().add(replacement);
		}
	}
}
