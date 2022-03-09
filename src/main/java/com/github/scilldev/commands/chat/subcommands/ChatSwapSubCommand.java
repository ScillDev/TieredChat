package com.github.scilldev.commands.chat.subcommands;

import com.github.scilldev.TieredChat;
import com.github.scilldev.chat.channel.ChatChannel;
import com.github.scilldev.commands.SubCommand;
import com.github.scilldev.data.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChatSwapSubCommand implements SubCommand {

	private final TieredChat plugin;

	public ChatSwapSubCommand(TieredChat plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onCommand(CommandSender sender, String subCommand, String[] args) {
		ChatChannel channel = plugin.getChatManager().getChannelByName(subCommand);
		plugin.getChatManager().getUser((Player) sender).setChannelPreference(channel);
		// TODO success message
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Messages getUsage() {
		return null;
	}

	@Override
	public String getPermission() {
		return "tieredchat.swap";
	}

	@Override
	public String[] getAliases() {
		List<String> channelNames = new ArrayList<>();
		for (ChatChannel channel : plugin.getChatManager().getChannels()) {
			channelNames.add(channel.getName().toLowerCase());
		}

		return channelNames.toArray(new String[1]);
	}
}
