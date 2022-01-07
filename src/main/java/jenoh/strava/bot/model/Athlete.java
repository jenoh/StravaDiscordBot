package jenoh.strava.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(	name = "athletes")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="strava_id")
    @JsonProperty("id")
    public String strava_id;

    @Column(name="username")
    @JsonProperty("username")
    public String username;

    @Column(name="bio")
    @JsonProperty("bio")
    public String bio;

    @Column(name="city")
    @JsonProperty("city")
    public String city;

    @Column(name="state")
    @JsonProperty("state")
    public String state;

    @Column(name="country")
    @JsonProperty("country")
    public String country;

    @Column(name="sex")
    @JsonProperty("sex")
    public String sex;

    @Column(name="premium")
    @JsonProperty("premium")
    public String premium;

    @Column(name="firstname")
    @JsonProperty("firstname")
    public String firstname;

    @Column(name="lastname")
    @JsonProperty("lastname")
    public String lastname;

    @Column(name="profileMedium")
    @JsonProperty("profile_medium")
    public String profileMedium;

    @Column(name="profile")
    @JsonProperty("profile")
    public String profile;

    @Column(name="follower")
    @JsonProperty("follower")
    public String follower;

    @Column(name="friend")
    @JsonProperty("friend")
    public String friend;

    @Column(name="weight")
    @JsonProperty("weight")
    public String weight;

    @Column(name="summit")
    @JsonProperty("summit")
    public String summit;

    @Column(name="badge_type_id")
    @JsonProperty("badge_type_id")
    public String badgeTypeId;

    @Column(name="resource_state")
    @JsonProperty("resource_state")
    public String resourceState;

    @Column(name="created_at")
    @JsonProperty("created_at")
    public String createdAt;

    @Column(name="updated_at")
    @JsonProperty("updated_at")
    public String updatedAt;

    public String getStrava_id() {
        return strava_id;
    }

    public void setStrava_id(String strava_id) {
        this.strava_id = strava_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfileMedium() {
        return profileMedium;
    }

    public void setProfileMedium(String profileMedium) {
        this.profileMedium = profileMedium;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSummit() {
        return summit;
    }

    public void setSummit(String summit) {
        this.summit = summit;
    }

    public String getBadgeTypeId() {
        return badgeTypeId;
    }

    public void setBadgeTypeId(String badgeTypeId) {
        this.badgeTypeId = badgeTypeId;
    }

    public String getResourceState() {
        return resourceState;
    }

    public void setResourceState(String resourceState) {
        this.resourceState = resourceState;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
