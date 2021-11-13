package jenoh.StravaDiscordBot;

import java.util.List;

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
public class BotController {
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
    static void postWebhook(@RequestBody String payload) {
        System.out.println(payload);
    }

}   
