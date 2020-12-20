package top.mccsdl.Listener;
import org.bukkit.Bukkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import top.mccsdl.aclles.Aclles;
public final class AcListener implements Listener {
    private final Aclles ac;
    public AcListener(Aclles ac) {
        this.ac = ac;
        ac.getServer().getPluginManager().registerEvents(this,ac);
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent event){

        //玩家进入服务器通告
        event.setJoinMessage(
                String.valueOf(
                        Bukkit.broadcastMessage(
                                event.getPlayer().getName()+"加入了"+ac.getConfig().getString("msg"))));
    }
    @EventHandler
    public void onGO(){

    }
}
