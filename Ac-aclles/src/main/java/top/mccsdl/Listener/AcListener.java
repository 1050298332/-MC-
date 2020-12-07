package top.mccsdl.Listener;

import com.oracle.jrockit.jfr.ValueDefinition;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class AcListener implements Listener {
    private String msg = "&a传说大陆";
    @EventHandler
    public void onLogin(PlayerJoinEvent event){

        //玩家进入服务器通告
        event.setJoinMessage(
                String.valueOf(
                        Bukkit.broadcastMessage(
                                event.getPlayer().getName()+"加入了"+msg)));


    }
}
