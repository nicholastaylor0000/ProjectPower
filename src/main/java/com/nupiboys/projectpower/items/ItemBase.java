package com.nupiboys.projectpower.items;

import com.nupiboys.projectpower.ProjectPower;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(ProjectPower.TAB));
    }
}