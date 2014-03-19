package imsr.Istom1n.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class IMSROnlinerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if (cmd.getName().equalsIgnoreCase("imsronliner")) {
			if (args[0] == "backup") {
				if (!sender.hasPermission("imsronliner.backup") && !sender.isOp()) {
					sender.sendMessage(ChatColor.RED + "Ошибка: вы не имеете прав.");
					return true;
				}
				
				backupMySQL();
				sender.sendMessage(ChatColor.GREEN + "[IMSROnliner]: Загрузка выполнена успешно!");
				return true;
			}
		}
		return false;
	}
	
	public void backupMySQL() {
		//TODO Загрузка в MySQL из Maps
	}

}
