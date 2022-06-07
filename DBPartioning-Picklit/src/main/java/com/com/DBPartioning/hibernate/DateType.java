/*
 * Copyright (c) 2018 OpenText Corporation. All Rights Reserved.
 * OpenText Confidential: Restricted Internal Distribution
 */
package com.com.DBPartioning.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.*;
import java.util.Date;

public class DateType extends ImmutableUserType {

    public static final String NAME = "com.opentext.picklist.hibernate.DateType";

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.TIMESTAMP };
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class returnedClass() {
        return Date.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        Timestamp timestamp = rs.getTimestamp(names[0]);
        if (rs.wasNull()) {
            return null;
        }
        return new Date(timestamp.getTime());
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.TIMESTAMP);
        } else {
            Date date = (Date)value;
            Timestamp timestamp = new Timestamp(date.getTime());
            st.setTimestamp(index, timestamp);
        }
    }

}