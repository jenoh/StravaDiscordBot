package jenoh.StravaDiscordBot;
import jenoh.StravaDiscordBot.Class.WebhookPayload;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jenoh.StravaDiscordBot.Class.WebhookPayload;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/")
    public String home() {
        return "Hello !";
    }
    @GetMapping("/webhook")
    @ResponseBody
    public JSONObject getWebhook(@RequestParam("hub.challenge") String hubChallenge) {
        JSONObject JSONObject = new JSONObject();
        JSONObject.put("hub.challenge", hubChallenge);
        return JSONObject;
    }
    @PostMapping("/webhook")
    static void postWebhook(@RequestBody String payload) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        WebhookPayload rootNode = mapper.readValue(payload, WebhookPayload.class);
        System.out.println(rootNode.aspectType);
    }
}

