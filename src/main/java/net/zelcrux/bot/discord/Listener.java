package net.zelcrux.bot.discord;

import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class Listener extends ListenerAdapter {
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
         TextChannel welcome = Objects.requireNonNull(e.getGuild().getDefaultChannel()).asTextChannel();
         if(!e.getUser().isBot()) {
             welcome.sendMessage("Willkommen " + e.getMember().getEffectiveName() + " auf " + e.getGuild().getName()).queue();
         }
    }
}
