package imsr.Istom1n.Commands;

import imsr.Istom1n.IMSROnliner;
import imsr.Istom1n.DB.MySQL;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class IMSROnlinerCommand implements CommandExecutor {

	private static MySQL mysql = IMSROnliner.getMySQL();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args[0].equalsIgnoreCase("backup")) {
			if (!sender.hasPermission("imsronliner.backup") && !sender.isOp()) {
				sender.sendMessage(ChatColor.RED + "Ошибка: вы не имеете прав.");
				return true;
			}
			
			mysql.backupMySQL();
			sender.sendMessage(ChatColor.GREEN + "[IMSROnliner]: Загрузка выполнена успешно!");
			return true;
		}
		
		return false;
	}

}