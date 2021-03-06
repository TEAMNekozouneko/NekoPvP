package com.nekozouneko.nekopvp.cmd;

import com.nekozouneko.nekopvp.NekoPvP;
import com.nekozouneko.nekopvp.util.actionbar;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class teambarCmd implements CommandExecutor, TabCompleter {

    private boolean NowBar = false;
    private NekoPvP plugin = NekoPvP.getInstance();
    private BukkitTask actionTask;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.NowBar) {
            // バーが出てないことにする
            NowBar = false;

            // タスクキャンセル
            actionTask.cancel();
        } else {
            // バーが出てることにする
            NowBar = true;
            // タスク作成
            actionTask = Bukkit.getScheduler().runTaskTimer(this.plugin, new actionbar(), 0L, 10L);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        // 空白
        return new ArrayList<>();
    }
}
