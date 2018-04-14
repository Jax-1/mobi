package com.mobi.dao.util;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import javax.management.RuntimeErrorException;

/**
 * 
 * @author dell
 * @param <E>
 *
 */
public class SQLParam {
	private static final String STRING_TYPE="STRING";
	private static final String BIGDECIMAL_TYPE="BIGDECTMAL";
	private static final String BYTE_TYPE="BYTE";
	private static final String INT_TYPE="INT";
	private static final String DOUBLE_TYPE="DOUBLE";
	private static final String DATE_TYPE="DATE";
	private static final String TIME_TYPE="TIME";
	private static final String TIMESTAMP_TYPE="TAMESTAMP";
	private static final String BLOB_TYPE="BLOB";
	
	
	
	private String type;
	private Object value;
	public SQLParam(String type,Object value) {
		this.type=type;
		this.value=value;
	}
	/**
	 * ��PreparedStatement����һ��ֵ
	 * @param pstmt
	 * @param sqlParams
	 * @throws SQLException 
	 */
	public static void setParams(PreparedStatement pstmt, List<SQLParam> sqlParams) throws SQLException {
		if(sqlParams!=null) {
			int index=0;
			Iterator<SQLParam> iterator = sqlParams.iterator();
			while(iterator.hasNext()) {
				SQLParam sqlParam = iterator.next();
				SQLParam.setParam(pstmt, sqlParam,++index);
			}
		}

	}
	/**
	 * ��PreparedStatement���뵥������
	 * @param pstmt
	 * @param sqlParam
	 * @param index 
	 * @throws SQLException 
	 */
	public static void setParam(PreparedStatement pstmt,SQLParam sqlParam, int index) throws SQLException {
		if(sqlParam.type==null) {
			return;
		}
		if(SQLParam.STRING_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.VARBINARY);
			}else {
				pstmt.setString(index, sqlParam.value.toString());
			}
			
		}else if(SQLParam.BIGDECIMAL_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.NUMERIC);
			}else {
				pstmt.setBigDecimal(index, new BigDecimal(sqlParam.value.toString()));
			}
			
		}else if(SQLParam.BYTE_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.NUMERIC);
			}else {
				pstmt.setByte(index, Byte.valueOf(sqlParam.value.toString()));
			}
			
		}else if(SQLParam.INT_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.NUMERIC);
			}else {
				pstmt.setInt(index, Integer.valueOf(sqlParam.value.toString()));
			}
			
		}else if(SQLParam.DOUBLE_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.NUMERIC);
			}else {
				pstmt.setDouble(index, Double.valueOf(sqlParam.value.toString()));
			}
			
		}else if(SQLParam.DATE_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.DATE);
			}else {
				pstmt.setDate(index, Date.valueOf(sqlParam.value.toString()));
			}
			
		}else if(SQLParam.TIME_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.TIME);
			}else {
				pstmt.setTime(index, Time.valueOf(sqlParam.value.toString()));
			}
			
		}else if(SQLParam.TIMESTAMP_TYPE.equals(sqlParam.type)) {
			if(sqlParam.value==null) {
				pstmt.setNull(index, Types.TIMESTAMP);
			}else {
				pstmt.setTimestamp(index, Timestamp.valueOf(sqlParam.value.toString()));
			}
			
		}else {
			throw new RuntimeErrorException(new Error(), "�޷���ȡ�������ͣ�"+sqlParam.type);
		}
		
		
	}

}
