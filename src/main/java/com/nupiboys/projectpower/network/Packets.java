package com.nupiboys.projectpower.network;

import static com.nupiboys.projectpower.ProjectPower.NET;

import com.nupiboys.projectpower.network.packet.SSetActiveChannel;
import com.nupiboys.projectpower.network.packet.SSetActiveChannelItem;

public class Packets {
    public static void register() {
        NET.register(new SSetActiveChannel());
        NET.register(new SSetActiveChannelItem());
    }
}
