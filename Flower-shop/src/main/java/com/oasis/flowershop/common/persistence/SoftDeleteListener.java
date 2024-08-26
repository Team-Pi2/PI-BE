package com.oasis.flowershop.common.persistence;

import javax.persistence.PreRemove;

public class SoftDeleteListener {

	@PreRemove
	private void preRemove(BaseEntity entity) {
		entity.delete();
	}
}
