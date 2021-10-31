package de.kaleidox.modvote;

import org.comroid.common.io.FileHandle;
import org.comroid.crystalshard.DiscordAPI;
import org.comroid.crystalshard.DiscordBotBase;
import org.comroid.crystalshard.gateway.GatewayIntent;

public final class ModVote extends DiscordBotBase {
    public static final FileHandle dir;
    public static final DiscordAPI api;
    public static final ModVote instance;

    static {
        dir = new FileHandle("/srv/dcb/modVote/", true);
        api = new DiscordAPI();
        instance = new ModVote(api, dir.createSubFile("token.cred").getContent(true), GatewayIntent.ALL_UNPRIVILEGED);
    }

    public static void main(String[] args) throws Throwable {
        instance.initialize();
    }

    public ModVote(DiscordAPI context, String token, GatewayIntent... intents) {
        super(context, token, intents);
    }
}
