package jenoh.strava.bot;

import com.fasterxml.jackson.databind.ObjectMapper;
import jenoh.strava.bot.Class.WebhookPayload;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class WebController {
    private final OkHttpClient httpClient = new OkHttpClient();

    @GetMapping("/")
    public String home(@RequestParam String code) {
//        StravaDiscordBotApplication.getConfigManager().getToml().getString("strava.discordtoken");
        System.out.println(code);
        // form parameters
        FormBody FormBody = new FormBody.Builder()
                .add("client_id", "73985")
                .add("client_secret", "46d42aed23269a25caed5cbeaa9a8ea135d8d6cc")
                .add("code", code)
                .add("grant_type", "authorization_code")

                .build();

        Request request = new Request.Builder()
                .url("https://www.strava.com/oauth/token")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(FormBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello !";
    }

    @GetMapping("/webhook")
    @ResponseBody
    public JSONObject getWebhook(@RequestParam("hub.challenge") String hubChallenge) {
        /* Return hub.challenge to strava */
        JSONObject JSONObject = new JSONObject();
        JSONObject.put("hub.challenge", hubChallenge);
        return JSONObject;
    }
    @PostMapping("/webhook")
    static void postWebhook(@RequestBody String payload) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        WebhookPayload webhookPayload = mapper.readValue(payload, WebhookPayload.class);

        System.out.println(webhookPayload.objectId);
        System.out.println(webhookPayload.ownerId);

        System.out.println(webhookPayload);

        BotApplication.botMessage();
    }
}


