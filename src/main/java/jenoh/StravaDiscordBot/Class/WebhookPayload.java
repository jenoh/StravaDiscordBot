package jenoh.StravaDiscordBot.Class;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class WebhookPayload {
    @JsonProperty("aspect_type")
    public String aspectType;

    @JsonProperty("event_time")
    public String eventTime;

    @JsonProperty("object_id")
    public String objectId;

    @JsonProperty("object_type")
    public String objectType;

    @JsonProperty("owner_id")
    public String ownerId;

    @JsonProperty("subscription_id")
    public String subscriptionId;

    @JsonProperty("updates")
    public Object updates;

}
