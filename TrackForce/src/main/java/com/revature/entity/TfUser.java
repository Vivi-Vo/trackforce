package com.revature.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TfUser generated by hbm2java
 */
@XmlRootElement
@Entity
@Table(name = "TF_USER", schema="ADMIN")
public class TfUser implements java.io.Serializable {

    private static final long serialVersionUID = 706405344864879997L;
    @Id
    @Column(name = "TF_USER_ID")
    /* ID's 1-14 are resereved for manual insertion */
    @SequenceGenerator(sequenceName = "UserId_seq", name = "UserIdSeq", initialValue=15)
    @GeneratedValue(generator = "UserIdSeq", strategy = GenerationType.SEQUENCE)
    private int tfUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TF_ROLE_ID")
    private TfRole tfRole;

    @Column(name = "TF_USERNAME", length = 20)
    private String tfUserUsername;

    @Column(name = "TF_HASHPASSWORD", length = 200)
    private String tfHashpassword;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TF_ASSOCIATE_ID")
    private TfAssociate tfAssociate;

    public TfUser() {
    }

    public TfUser(int tfUserId) {
        this.tfUserId = tfUserId;
    }

    //Constructor for createAssociate which sets a role of 5.
    public TfUser(TfAssociate associate, String username, String password){
        this.tfAssociate = associate;
        this.tfUserUsername = username;
        this.tfHashpassword = password;
        this.tfRole = new TfRole(5);
    }

    public TfUser(int tfUserId, TfRole tfRole, String tfUserUsername, String tfUserHashpassword) {
        this.tfUserId = tfUserId;
        this.tfRole = tfRole;
        this.tfUserUsername = tfUserUsername;
        this.tfHashpassword = tfUserHashpassword;
    }

    public TfUser(Integer role, String username, String password) {
        this.tfRole = new TfRole(role);
        this.tfUserUsername = username;
        this.tfHashpassword = password;
    }

    public int getTfUserId() {
        return this.tfUserId;
    }

    public void setTfUserId(int tfUserId) {
        this.tfUserId = tfUserId;
    }

    public TfRole getTfRole() {
        return this.tfRole;
    }

    public void setTfRole(TfRole tfRole) {
        this.tfRole = tfRole;
    }


    public String getTfUserUsername() {
        return this.tfUserUsername;
    }

    public void setTfUserUsername(String tfUserUsername) {
        this.tfUserUsername = tfUserUsername;
    }

    public String getTfUserHashpassword() {
        return this.tfHashpassword;
    }

    public void setTfUserHashpassword(String tfUserHashpassword) {
        this.tfHashpassword = tfUserHashpassword;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tfHashpassword == null) ? 0 : tfHashpassword.hashCode());
        result = prime * result + ((tfUserUsername == null) ? 0 : tfUserUsername.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TfUser other = (TfUser) obj;
        if (tfHashpassword == null) {
            if (other.tfHashpassword != null) {
                return false;
            }
        } else if (!tfHashpassword.equals(other.tfHashpassword)) {
            return false;
        }
        if (tfUserId != other.tfUserId) {
            return false;
        }
        if (tfUserUsername == null) {
            if (other.tfUserUsername != null) {
                return false;
            }
        } else if (!tfUserUsername.equals(other.tfUserUsername)) {
            return false;
        }
        return true;
    }
}
