package Database.entity;

import javax.persistence.*;

@Entity
@Table(name ="producent")
public class Producent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producent_seq")
    private Long id;
    private String name;

    protected Producent() {    }


    public Producent(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.format(
                "[%d.%s]",id, name);
    }

    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }


}

