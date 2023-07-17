package com.example.jpa.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
// 모든 entity들이 가져야 할 속성에 대해 정의하고 싶을 때
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;
    // 언제 생성됐는지
    
    @LastModifiedDate
    @Column(updatable = true)
    private Instant UpdatedAt;
    // 갱신된 시간

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        UpdatedAt = updatedAt;
    }

}
