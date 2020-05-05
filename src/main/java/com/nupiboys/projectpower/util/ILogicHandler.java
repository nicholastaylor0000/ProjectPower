package com.nupiboys.projectpower.util;

import net.minecraft.util.Direction;

import javax.annotation.Nullable;

import com.nupiboys.projectpower.util.TransferConfig.Type;

public interface ILogicHandler {
    default TransferConfig.Type getTransferType(@Nullable Direction side) {
        return getTransferConfig().getType(side);
    }

    TransferConfig getTransferConfig();
}
