package com.nupiboys.projectpower.network.packet;

import static com.nupiboys.projectpower.ProjectPower.NET;

public class Packets {
    public static void register() {
        NET.register(new SNextEnergyConfigPacket());
        NET.register(new SNextRedstoneModePacket());
        NET.register(new SNextTransferConfigPacket());
    }
}
