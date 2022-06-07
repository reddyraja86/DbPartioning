/*
 * Copyright (c) 2016 OpenText Corporation. All Rights Reserved.
 * OpenText Confidential: Restricted Internal Distribution
 */
package com.com.DBPartioning.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class StringArrayUserType extends AbstractArrayUserType {

    public static final String NAME = "com.com.DBPartioning.hibernate.StringArrayUserType";

    @Override
    @SuppressWarnings("rawtypes")
    public Class returnedClass() {
        return String[].class;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index,
            SharedSessionContractImplementor sessionImplementor)
            throws HibernateException, SQLException {
        if (value == null) {
            preparedStatement.setNull(index, Types.ARRAY);
        } else {
            Array arrayValue = preparedStatement.getConnection().createArrayOf("text", (String[])value);
            preparedStatement.setArray(index, arrayValue);
        }
    }
}
