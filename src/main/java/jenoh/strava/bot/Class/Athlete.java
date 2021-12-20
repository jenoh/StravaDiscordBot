package jenoh.strava.bot.Class;

public class Athlete {

    public String username;
    public String bio;
    public String city;
    public String state;
    public String country;
    public String sex;
    public String prenium;
    public String firstname;
    public String lastname;

    public Athlete(String username, String bio, String city, String state, String country, String sex, String prenium, String firstname, String lastname) {
        this.username = username;
        this.bio = bio;
        this.city = city;
        this.state = state;
        this.country = country;
        this.sex = sex;
        this.prenium = prenium;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPrenium(String prenium) {
        this.prenium = prenium;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBio() {
        return bio;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getSex() {
        return sex;
    }

    public String getPrenium() {
        return prenium;
    }

}
