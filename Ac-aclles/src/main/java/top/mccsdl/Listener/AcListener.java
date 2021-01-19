package top.mccsdl.Listener;
import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
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
    public void onGO(PlayerMoveEvent event){
        //得到玩家坐标
        Location location = event.getPlayer().getLocation();
        //设置目标为玩家头顶1格处
        location.setY(location.getY()+3);
        //得到目标坐标的方块
        Block b = location.getBlock();
        //将目标坐标的方块改为萤石
        b.setType(Material.GLOWSTONE);
    }

}
