package jenoh.strava.bot;

import com.fasterxml.jackson.databind.ObjectMapper;
import jenoh.strava.bot.model.Athlete;
import jenoh.strava.bot.model.WebhookPayload;
import jenoh.strava.bot.repository.AthleteRepository;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class WebController {
    private final OkHttpClient httpClient = new OkHttpClient();

    @Autowired
    AthleteRepository athleteRepository;

    @GetMapping("/")
    public String home(@RequestParam String code) {

        FormBody FormBody = new FormBody.Builder()
                .add("client_id", BotApplication.getConfigManager().getToml().getString("strava.client_id"))
                .add("client_secret", BotApplication.getConfigManager().getToml().getString("strava.client_secret"))
                .add("code", code)
                .add("grant_type", "authorization_code")
                .build();

        /* Post the code to receive athlete information */
        Request request = new Request.Builder()
                .url("https://www.strava.com/oauth/token")
                .post(FormBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONParser parser = new JSONParser();
            String s = response.body().string();
            JSONObject athleteJson = (JSONObject) parser.parse(s);

            ObjectMapper mapper = new ObjectMapper();
            Athlete athlete = mapper.readValue(athleteJson.get("athlete").toString(), Athlete.class);

            /* Store the athlete */
            athleteRepository.save(athlete);

        } catch (IOException | ParseException e) {
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


