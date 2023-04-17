package Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    private Long id;
    private String fname;
    private String lname;
    private String road;
    private String nbr_house;
    private String nbr_ap;
    private String post_code;
    private String city;
    private String phone;
    private String mail;
    private String username;
    private String password;
    private String acc_type;

    protected Client() {    }


    public Client(String name) {
        this.fname = name;
    }


    @Override
    public String toString() {
        return String.format(
                "[%d.%s]",id, fname);
    }

    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }

    public String getFname() {        return fname;    }
    public void setFname(String fname) {        this.fname = fname;    }

    public String getLname() {        return lname;    }
    public void setLname(String lname) {        this.lname = lname;    }

    public String getRoad() {        return road;    }
    public void setRoad(String road) {        this.road = road;    }

    public String getNbr_house() {        return nbr_house;    }
    public void setNbr_house(String nbr_house) {        this.nbr_house = nbr_house;    }

    public String getNbr_ap() {        return nbr_ap;    }
    public void setNbr_ap(String nbr_ap) {        this.nbr_ap = nbr_ap;    }

    public String getPost_code() {        return post_code;    }
    public void setPost_code(String post_code) {        this.post_code = post_code;    }

    public String getCity() {        return city;    }
    public void setCity(String city) {        this.city = city;    }

    public String getPhone() {        return phone;    }
    public void setPhone(String phone) {        this.phone = phone;    }

    public String getMail() {        return mail;    }
    public void setMail(String mail) {        this.mail = mail;    }

    public String getUsername() {        return username;    }
    public void setUsername(String username) {        this.username = username;    }

    public String getPassword() {        return password;    }
    public void setPassword(String password) {        this.password = password;    }

    public String getAcc_type() {        return acc_type;    }
    public void setAcc_type(String acc_type) {        this.acc_type = acc_type;    }
}

