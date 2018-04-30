package br.org.soujava.model;

import java.util.Objects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mvc.binding.MvcBinding;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Convert;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class Person {

    @FormParam("id")
    @Id
    @Convert(ObjectIdConverter.class)
    private String id;

    @FormParam("name")
    @Column
	@NotEmpty
	@Size(min = 1, max = 20)
    @MvcBinding
    private String name;

    @FormParam("age")
    @Column
    @MvcBinding
    @Min(18)
    private int age;

    @BeanParam
    @Column
    @Valid
    private Address address;

    @FormParam("jugs")
    @Column
    @NotEmpty
	@MvcBinding
    private String jugs;

    @FormParam("description")
    @Column
    @NotEmpty
	@MvcBinding
	@Size(min = 10, max = 20)
    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public String getJugs() {
        return jugs;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", address=").append(address);
        sb.append(", jugs='").append(jugs).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}