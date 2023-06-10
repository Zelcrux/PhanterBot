package net.zelcrux.bot.discord;

import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.zelcrux.bot.Config;

import javax.management.StringValueExp;

public class Discord {
    private JDA bot;
    public Discord() throws Exception {
        bot = JDABuilder.createDefault(new Config().getBotToken())
                .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.ROLE_TAGS, CacheFlag.STICKER, CacheFlag.ACTIVITY, CacheFlag.CLIENT_STATUS, CacheFlag.ONLINE_STATUS)
                .enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                        GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_PRESENCES,
                        GatewayIntent.GUILD_MODERATION, GatewayIntent.DIRECT_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_INVITES, GatewayIntent.DIRECT_MESSAGE_TYPING,
                        GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.GUILD_VOICE_STATES,
                        GatewayIntent.GUILD_WEBHOOKS, GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGE_TYPING)
                .setActivity(Activity.streaming("mit panter_black09", "https://www.twitch.tv/panter_black09"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setAutoReconnect(true)
                .build().awaitReady();
        Status();
    }
    private void Status() {
        WebhookEmbedBuilder embed = new WebhookEmbedBuilder();
        embed.setAuthor(new WebhookEmbed.EmbedAuthor(getBot().getSelfUser().getName(), getBot().getSelfUser().getAvatarUrl(), "https://Zelcrux.net"));
        embed.addField(new WebhookEmbed.EmbedField(false, "[Status]", "ONLINE"));
        embed.addField(new WebhookEmbed.EmbedField(false, "Guild's", String.valueOf(bot.getGuilds().stream().count())));
        embed.addField(new WebhookEmbed.EmbedField(false, "Type", ""));
        embed.setFooter(new WebhookEmbed.EmbedFooter("@Zelcrux", getBot().getSelfUser().getAvatarUrl()));
        new WebhookClientBuilder(new Config().getWebhook()).build().send(embed.build());
    }
    public JDA getBot() {
        return bot;
    }
}
