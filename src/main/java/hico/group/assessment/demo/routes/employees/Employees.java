package hico.group.assessment.demo.routes.employees;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name = "employees")
public class Employees {
    public enum Gender {
        MALE, FEMALE, UNSPECIFIED;
    }

    public enum Salutation {
        DR, MR, MS, MRS, MX;
    }

    public enum ProfileColor {
        RED, BLUE, GREEN, DEFAULT;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Salutation salutation;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer employeeCode;

    private Integer grossSalary;

    @Enumerated(EnumType.STRING)
    private ProfileColor profileColor;

    @Column(name = "createdAt")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private final Date createdAt = new Date();

    @UpdateTimestamp
    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private final Date updatedAt = new Date();

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the salutation
     */
    public Salutation getSalutation() {
        return salutation;
    }

    /**
     * @param salutation the salutation to set
     */
    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the employeeCode
     */
    public Integer getEmployeeCode() {
        return employeeCode;
    }

    /**
     * @param employeeCode the employeeCode to set
     */
    public void setEmployeeCode(Integer employeeCode) {
        this.employeeCode = employeeCode;
    }

    /**
     * @return the grossSalary
     */
    public Integer getGrossSalary() {
        return grossSalary;
    }

    /**
     * @param grossSalary the grossSalary to set
     */
    public void setGrossSalary(Integer grossSalary) {
        this.grossSalary = grossSalary;
    }

    /**
     * @return the profileColor
     */
    public ProfileColor getProfileColor() {
        return profileColor;
    }

    /**
     * @param profileColor the profileColor to set
     */
    public void setProfileColor(ProfileColor profileColor) {
        this.profileColor = profileColor;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

}
