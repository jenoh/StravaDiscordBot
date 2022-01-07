package jenoh.strava.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

//    public WebhookPayload(String aspect_type, String event_time, String object_id, String object_type, String owner_id, String subscription_id, Object updates ) {
//        this.aspectType = aspect_type;
//        this.eventTime = event_time;
//        this.objectId = object_id;
//        this.objectType = object_type;
//        this.ownerId = owner_id;
//        this.subscriptionId = subscription_id;
//        this.updates = updates;
//
//    }
    public String getAspectType() {
        return aspectType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public Object getUpdates() {
        return updates;
    }

}
