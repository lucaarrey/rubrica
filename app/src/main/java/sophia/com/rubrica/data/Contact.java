package sophia.com.rubrica.data;

/**
 * Created by archimede on 16/05/17.
 */

public class Contact {

    private String name;
    private String lastname;
    private String nickname;
    private String phone;
    private String mobile;
    private String email;

    public Contact(String name, String lastname, String nickname, String phone, String mobile, String email) {
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFullname() {
        return this.name + " " + this.lastname;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (lastname != null ? !lastname.equals(contact.lastname) : contact.lastname != null)
            return false;
        if (nickname != null ? !nickname.equals(contact.nickname) : contact.nickname != null)
            return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (mobile != null ? !mobile.equals(contact.mobile) : contact.mobile != null) return false;
        return email != null ? email.equals(contact.email) : contact.email == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
