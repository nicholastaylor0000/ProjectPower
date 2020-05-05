package com.nupiboys.projectpower.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.nupiboys.projectpower.blocks.IBlocks;
import com.nupiboys.projectpower.blocks.Tier;
import com.nupiboys.projectpower.ProjectPower;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IItems {
    public static final List<Item> ITEMS = new ArrayList<>(IBlocks.BLOCK_ITEMS);
    public static final Item CAPACITOR_BASIC = register("capacitor_basic", new CapacitorItem(new Item.Properties().group(ProjectPower.TAB)));
    public static final Item BATTERY_BASIC = register("battery_basic", new BatteryItem(new Item.Properties().group(ProjectPower.TAB).maxStackSize(1), Tier.BASIC));

    static <T extends net.minecraft.item.Item> T register(final String name, final T item) {
        item.setRegistryName(name);
        IItems.ITEMS.add(item);
        return item;
    }

    @SubscribeEvent
    public static void onRegistry(final RegistryEvent.Register<Item> event) {
        IItems.ITEMS.forEach(item -> event.getRegistry().register(item));
    }
}
