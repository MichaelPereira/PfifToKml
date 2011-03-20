package fr.michaelpereira.pfiftokml;
// Generated Mar 12, 2011 12:16:10 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name="person"
    ,catalog="missingpeoplejapan"
)
public class Person  implements java.io.Serializable {


     private String personRecordId;
     private Date entryDate;
     private String authorName;
     private String authorEmail;
     private String authorPhone;
     private String sourceName;
     private Date sourceDate;
     private String sourceUrl;
     private String firstName;
     private String lastName;
     private String homeCity;
     private String homeState;
     private String homeNeighborhood;
     private String homeStreet;
     private String homeZip;
     private String photoUrl;
     private String other;
     private String sex;
     private Date dateOfBirth;
     private Short age;
     private String homeCountry;
     private Set<Note> notesForLinkedPersonRecordId = new HashSet<Note>(0);
     private Set<Note> notesForPersonRecordId = new HashSet<Note>(0);

    public Person() {
    }

	
    public Person(String personRecordId) {
        this.personRecordId = personRecordId;
    }
    public Person(String personRecordId, Date entryDate, String authorName, String authorEmail, String authorPhone, String sourceName, Date sourceDate, String sourceUrl, String firstName, String lastName, String homeCity, String homeState, String homeNeighborhood, String homeStreet, String homeZip, String photoUrl, String other, String sex, Date dateOfBirth, Short age, String homeCountry, Set<Note> notesForLinkedPersonRecordId, Set<Note> notesForPersonRecordId) {
       this.personRecordId = personRecordId;
       this.entryDate = entryDate;
       this.authorName = authorName;
       this.authorEmail = authorEmail;
       this.authorPhone = authorPhone;
       this.sourceName = sourceName;
       this.sourceDate = sourceDate;
       this.sourceUrl = sourceUrl;
       this.firstName = firstName;
       this.lastName = lastName;
       this.homeCity = homeCity;
       this.homeState = homeState;
       this.homeNeighborhood = homeNeighborhood;
       this.homeStreet = homeStreet;
       this.homeZip = homeZip;
       this.photoUrl = photoUrl;
       this.other = other;
       this.sex = sex;
       this.dateOfBirth = dateOfBirth;
       this.age = age;
       this.homeCountry = homeCountry;
       this.notesForLinkedPersonRecordId = notesForLinkedPersonRecordId;
       this.notesForPersonRecordId = notesForPersonRecordId;
    }
   
     @Id 
    
    @Column(name="person_record_id", unique=true, nullable=false, length=200)
    public String getPersonRecordId() {
        return this.personRecordId;
    }
    
    public void setPersonRecordId(String personRecordId) {
        this.personRecordId = personRecordId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="entry_date", length=19)
    public Date getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    
    @Column(name="author_name", length=256)
    public String getAuthorName() {
        return this.authorName;
    }
    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    @Column(name="author_email", length=256)
    public String getAuthorEmail() {
        return this.authorEmail;
    }
    
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
    
    @Column(name="author_phone", length=256)
    public String getAuthorPhone() {
        return this.authorPhone;
    }
    
    public void setAuthorPhone(String authorPhone) {
        this.authorPhone = authorPhone;
    }
    
    @Column(name="source_name", length=256)
    public String getSourceName() {
        return this.sourceName;
    }
    
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="source_date", length=19)
    public Date getSourceDate() {
        return this.sourceDate;
    }
    
    public void setSourceDate(Date sourceDate) {
        this.sourceDate = sourceDate;
    }
    
    @Column(name="source_url", length=256)
    public String getSourceUrl() {
        return this.sourceUrl;
    }
    
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    
    @Column(name="first_name", length=256)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="last_name", length=256)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="home_city", length=256)
    public String getHomeCity() {
        return this.homeCity;
    }
    
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }
    
    @Column(name="home_state", length=256)
    public String getHomeState() {
        return this.homeState;
    }
    
    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }
    
    @Column(name="home_neighborhood", length=256)
    public String getHomeNeighborhood() {
        return this.homeNeighborhood;
    }
    
    public void setHomeNeighborhood(String homeNeighborhood) {
        this.homeNeighborhood = homeNeighborhood;
    }
    
    @Column(name="home_street", length=256)
    public String getHomeStreet() {
        return this.homeStreet;
    }
    
    public void setHomeStreet(String homeStreet) {
        this.homeStreet = homeStreet;
    }
    
    @Column(name="home_zip", length=256)
    public String getHomeZip() {
        return this.homeZip;
    }
    
    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }
    
    @Column(name="photo_url", length=65535)
    public String getPhotoUrl() {
        return this.photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
    @Column(name="other", length=65535)
    public String getOther() {
        return this.other;
    }
    
    public void setOther(String other) {
        this.other = other;
    }
    
    @Column(name="sex", length=6)
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth", length=10)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    @Column(name="age")
    public Short getAge() {
        return this.age;
    }
    
    public void setAge(Short age) {
        this.age = age;
    }
    
    @Column(name="home_country", length=256)
    public String getHomeCountry() {
        return this.homeCountry;
    }
    
    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="personByLinkedPersonRecordId")
    public Set<Note> getNotesForLinkedPersonRecordId() {
        return this.notesForLinkedPersonRecordId;
    }
    
    public void setNotesForLinkedPersonRecordId(Set<Note> notesForLinkedPersonRecordId) {
        this.notesForLinkedPersonRecordId = notesForLinkedPersonRecordId;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="personByPersonRecordId")
    public Set<Note> getNotesForPersonRecordId() {
        return this.notesForPersonRecordId;
    }
    
    public void setNotesForPersonRecordId(Set<Note> notesForPersonRecordId) {
        this.notesForPersonRecordId = notesForPersonRecordId;
    }




}


