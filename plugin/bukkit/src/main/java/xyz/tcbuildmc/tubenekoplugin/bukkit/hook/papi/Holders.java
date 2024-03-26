package xyz.tcbuildmc.tubenekoplugin.bukkit.hook.papi;

public final class Holders {
    private static boolean ACCESSIBLE = false;

    public static boolean isAccessible() {
        return ACCESSIBLE;
    }

    public static void setAccessible(boolean b) {
        Holders.ACCESSIBLE = b;
    }
}
