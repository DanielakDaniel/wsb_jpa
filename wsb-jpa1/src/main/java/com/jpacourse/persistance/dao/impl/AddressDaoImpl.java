package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.AddressDao;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao {

}
