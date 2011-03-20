package fr.michaelpereira.pfiftokml;
// Generated Mar 12, 2011 12:16:10 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Note generated by hbm2java
 */
@Entity
@Table(name="note"
    ,catalog="missingpeoplejapan"
)
public class Note  implements java.io.Serializable {


     private String noteRecordId;
     private Person personByPersonRecordId;
     private Person personByLinkedPersonRecordId;
     private Date entryDate;
     private String authorName;
     private String authorEmail;
     private String authorPhone;
     private Date sourceDate;
     private Boolean found;
     private String emailOfFoundPerson;
     private String phoneOfFoundPerson;
     private String lastKnownLocation;
     private String text;
     private String status;

    public Note() {
    }

	
    public Note(String noteRecordId, Person personByPersonRecordId) {
        this.noteRecordId = noteRecordId;
        this.personByPersonRecordId = personByPersonRecordId;
    }
    public Note(String noteRecordId, Person personByPersonRecordId, Person personByLinkedPersonRecordId, Date entryDate, String authorName, String authorEmail, String authorPhone, Date sourceDate, Boolean found, String emailOfFoundPerson, String phoneOfFoundPerson, String lastKnownLocation, String text, String status) {
       this.noteRecordId = noteRecordId;
       this.personByPersonRecordId = personByPersonRecordId;
       this.personByLinkedPersonRecordId = personByLinkedPersonRecordId;
       this.entryDate = entryDate;
       this.authorName = authorName;
       this.authorEmail = authorEmail;
       this.authorPhone = authorPhone;
       this.sourceDate = sourceDate;
       this.found = found;
       this.emailOfFoundPerson = emailOfFoundPerson;
       this.phoneOfFoundPerson = phoneOfFoundPerson;
       this.lastKnownLocation = lastKnownLocation;
       this.text = text;
       this.status = status;
    }
   
     @Id 
    
    @Column(name="note_record_id", unique=true, nullable=false, length=200)
    public String getNoteRecordId() {
        return this.noteRecordId;
    }
    
    public void setNoteRecordId(String noteRecordId) {
        this.noteRecordId = noteRecordId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_record_id", nullable=false)
    public Person getPersonByPersonRecordId() {
        return this.personByPersonRecordId;
    }
    
    public void setPersonByPersonRecordId(Person personByPersonRecordId) {
        this.personByPersonRecordId = personByPersonRecordId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="linked_person_record_id")
    public Person getPersonByLinkedPersonRecordId() {
        return this.personByLinkedPersonRecordId;
    }
    
    public void setPersonByLinkedPersonRecordId(Person personByLinkedPersonRecordId) {
        this.personByLinkedPersonRecordId = personByLinkedPersonRecordId;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="source_date", length=19)
    public Date getSourceDate() {
        return this.sourceDate;
    }
    
    public void setSourceDate(Date sourceDate) {
        this.sourceDate = sourceDate;
    }
    
    @Column(name="found")
    public Boolean getFound() {
        return this.found;
    }
    
    public void setFound(Boolean found) {
        this.found = found;
    }
    
    @Column(name="email_of_found_person", length=256)
    public String getEmailOfFoundPerson() {
        return this.emailOfFoundPerson;
    }
    
    public void setEmailOfFoundPerson(String emailOfFoundPerson) {
        this.emailOfFoundPerson = emailOfFoundPerson;
    }
    
    @Column(name="phone_of_found_person", length=256)
    public String getPhoneOfFoundPerson() {
        return this.phoneOfFoundPerson;
    }
    
    public void setPhoneOfFoundPerson(String phoneOfFoundPerson) {
        this.phoneOfFoundPerson = phoneOfFoundPerson;
    }
    
    @Column(name="last_known_location", length=256)
    public String getLastKnownLocation() {
        return this.lastKnownLocation;
    }
    
    public void setLastKnownLocation(String lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }
    
    @Column(name="text", length=65535)
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Column(name="status", length=19)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


