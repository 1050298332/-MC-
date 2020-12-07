package top.mccsdl.aclles;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import top.mccsdl.Listener.AcListener;

import java.io.File;


public final class Aclles extends JavaPlugin{
    String qz = "§6[Ac-aclles]";
    Double bb = 2.0;

    String s ="													 \r\n" +
            " _______  _______  _        _        _______  _______ \r\n" +
            "(  ___  )(  ____ \\( \\      ( \\      (  ____ \\(  ____ \\\r\n" +
            "| (   ) || (    \\/| (      | (      | (    \\/| (    \\/\r\n" +
            "| (___) || |      | |      | |      | (__    | (_____ \r\n" +
            "|  ___  || |      | |      | |      |  __)   (_____  )\r\n" +
            "| (   ) || |      | |      | |      | (            ) |\r\n" +
            "| )   ( || (____/\\| (____/\\| (____/\\| (____/\\/\\____) |\r\n" +
            "|/     \\|(_______/(_______/(_______/(_______/\\_______)";


    @Override
    public void onEnable() {

        getLogger().info(s);
        Bukkit.getConsoleSender().sendMessage(qz+"§a插件启动成功.");
        Bukkit.getConsoleSender().sendMessage(qz+"§a作者：Aclles 版本："+bb);
        Bukkit.getConsoleSender().sendMessage(qz+"§c如有对此插件任何疑问或建议 请联系作者qq:1050298332.");
        //监听器
        Bukkit.getPluginManager().registerEvents(new AcListener(), this);
        LoadConfig();
    }
    public void LoadConfig(){
        if (!new File(getDataFolder()+ File.separator+"config.yml").exists()){
            saveDefaultConfig();
            getLogger().severe("未发现config.yml，已保存初始设置");
        }try{
            reloadConfig();
            getLogger().info("已加载config");
        }catch (Exception e){
            getServer().getPluginManager().disablePlugin(this);
            getLogger().warning("无法加载config.yml，插件结束");
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(qz+"§c插件关闭成功.");
    }
    //锁定服务器版本对除1.12.2以外的版本进行不兼容处理
    public void onLoad() {
        if (Bukkit.getServer().getVersion().contains("1.12")) {
            Bukkit.getConsoleSender().sendMessage("§a服务器版本兼容，正在启动");
        } else {
            getLogger().info("服务器版本不兼容本插件，为了服务器与用户的安全,服务器已关闭!");
            Bukkit.getServer().shutdown();
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd,String label,String... args){
        if (!(sender instanceof Player)) {
            getLogger().info("后台无法执行玩家命令!请使用玩家身份执行.");
            return true;
        }else  if (cmd.getName().equalsIgnoreCase("Ac")){
            if (args.length == 0 ){
                sender.sendMessage(qz+"§a========[§6Ac-测试插件]§a========");
                sender.sendMessage(qz+"§a作者：Aclles");
                sender.sendMessage(qz+"§a指令:");
                sender.sendMessage(qz+"§a  /Ac open gui ----- 打开GUI界面");
                sender.sendMessage(qz+"§a- /Ac info   --- 查看插件信息");
                //检测用户是否拥有重载权限 显示指令
                if (sender.hasPermission("Ac.admin")){
                    sender.sendMessage(qz+"§a- /Ac reload --- 重载插件");
                }
                sender.sendMessage(qz+"§a=============================");
            }else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("info")) {
                        sender.sendMessage(qz + "§a========[§6Ac-测试插件]§a========");
                        sender.sendMessage(qz + "§a指令info执行");
                        sender.sendMessage(qz + "§a作者：Aclles");
                        sender.sendMessage(qz + "§a=============================");
                    }
                    if (args[0].equalsIgnoreCase("reload")) {
                        if (!sender.hasPermission("Ac.admin")) {
                            sender.sendMessage(qz + "§c你没权限,垃圾");
                            return true;
                        }

                        this.reloadConfig();
                        sender.sendMessage(qz + "§a重载完成！");
                    }
                    if (args[0].equalsIgnoreCase("open")) {
                        if (args[1].equalsIgnoreCase("gui")) {
                            if (sender.hasPermission("Ac.gui")) {
                                return true;
                            } else sender.sendMessage("§2您没有执行打开GUI的权限,请联系管理员获取!");
                        }

                        }
                    }
            }
        return true;
        }
}
