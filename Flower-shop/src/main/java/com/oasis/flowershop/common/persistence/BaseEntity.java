package com.oasis.flowershop.common.persistence;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, SoftDeleteListener.class})
@SuperBuilder(toBuilder = true)
public class BaseEntity {

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Timestamp createdDate;

	@LastModifiedDate
	@Column(nullable = false)
	private Timestamp updatedDate;

	@Builder.Default
	@Column(nullable = false)
	private boolean isDeleted = false;

	public void delete() {
		this.isDeleted = true;
	}
}
