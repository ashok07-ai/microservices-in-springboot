package com.stack.accounts.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @MappedSuperclass
 * ----------------
 * This annotation indicates that this class is a base class whose
 * fields are inherited by JPA entity classes.
 *
 * - No separate table will be created for this class.
 * - All fields will be mapped to the database tables of child entities.
 * - Used to define common properties like audit fields.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    /**
     * updatable = false
     * -----------------
     * This field can be inserted when the record is created,
     * but it cannot be modified during an update operation.
     */

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    /**
     * insertable = false
     * ------------------
     * This field will NOT be included in SQL INSERT statements.
     * It is only updated during UPDATE operations.
     * Useful for fields that should be set after creation.
     */
    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by", insertable = false)
    private String updatedBy;

    /**
     * @PrePersist
     * ------------
     * This lifecycle callback method is automatically executed
     * before the entity is inserted into the database.
     *
     * - Used to initialize fields like createdAt and createdBy.
     * - Runs only once when the record is first saved.
     */
//    @PrePersist
//    public void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.createdBy = "SYSTEM";
//    }

    /**
     * @PreUpdate
     * -----------
     * This lifecycle callback method is automatically executed
     * before the entity is updated in the database.
     *
     * - Used to update audit fields like updatedAt and updatedBy.
     * - Runs every time the entity is modified.
     */
//    @PreUpdate
//    public void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//        this.updatedBy = "SYSTEM";
//    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
