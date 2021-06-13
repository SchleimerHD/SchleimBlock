package de.schleimer.skyblockre.api;


import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class Tablist {
    public static void sendTablist(Player p, String Title, String subTitle) {
        if (Title == null) {
            Title = "";
        }
        if (subTitle == null) subTitle = "";
        /*
        IChatBaseComponent tabTitle = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + Title + "\"}");
        IChatBaseComponent tabSubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + subTitle + "\"}");

        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabSubTitle);
        try {
            Field field = packet.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(packet, tabSubTitle);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }

         */
    }
}
