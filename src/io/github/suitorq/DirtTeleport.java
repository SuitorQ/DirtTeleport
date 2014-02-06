package io.github.suitorq;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class DirtTeleport extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static DirtTeleport plugin;
	
	@Override
    public void onDisable(){
       PluginDescriptionFile pdfFile = this.getDescription();
       this.logger.info(pdfFile.getName() + " has been DISABLED");
    }
    @Override
    public void onEnable(){
       PluginDescriptionFile pdfFile = this.getDescription();
       this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " has been ENABLED");
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	Player player = (Player) sender;
    	if(commandLabel.equalsIgnoreCase("dtp")){
    		if(args.length == 0) {
    			player.sendMessage(ChatColor.DARK_RED + "Incorrect Syntax.");
    		}
    		else if (args.length == 1){
    			Player targetPlayer = getServer().getPlayer(args[0]);
    			Location targetPlayerLocation = targetPlayer.getLocation();
    			player.teleport(targetPlayerLocation);
    			player.sendMessage(ChatColor.YELLOW + "You have teleported to " + ChatColor.RED + getServer().getPlayer(args[0]).getName());
    			targetPlayer.sendMessage(ChatColor.RED + player.getName() + ChatColor.YELLOW + " has teleported to you");
    		}
    		else if(args.length == 2){
    			Player targetPlayer = player.getServer().getPlayer(args[0]);
    			Player targetPlayer1 = player.getServer().getPlayer(args[1]);
    			Location targetPlayer1Location = targetPlayer1.getLocation();
    			targetPlayer.teleport(targetPlayer1Location);
    			targetPlayer.sendMessage(ChatColor.WHITE + "You have been teleported to " + targetPlayer1.getName());
    			targetPlayer1.sendMessage(ChatColor.WHITE + targetPlayer.getName() + " has been teleported to you");

    			player.sendMessage(ChatColor.YELLOW + ">> " + player.getServer().getPlayer(args[0]).getName());
    			player.sendMessage(ChatColor.YELLOW + ">> " + player.getServer().getPlayer(args[1]).getName());
    			player.sendMessage(ChatColor.YELLOW + ">> " + player.getName());
    			
    			if((player.getName() != player.getServer().getPlayer(args[0]).getName()) && (player.getName() != player.getServer().getPlayer(args[1]).getName())){
    				
    				player.sendMessage(ChatColor.YELLOW + "Teleported " + ChatColor.RED + player.getServer().getPlayer(args[0]).getName() + ChatColor.YELLOW + " to " + ChatColor.RED + player.getServer().getPlayer(args[1]).getName());
    			}		
    		}
    	}
    	return false;
    }
}
