package org.jlf.plugin.server.core.dbPool.c3p0;

import java.sql.Connection;

/**
 * 
 * @ClassName: C3p0ConnectionExt
 * @Description:connection����չ
 * @author Lone Wolf
 * @date 2019��5��26��
 */
public class C3p0ConnectionExt {

	private Connection conn; // conn����

	private boolean allowCommit; // conn�Ƿ���ύ

	public C3p0ConnectionExt(Connection conn) {
		this.conn = conn;
		this.allowCommit = false;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public boolean isAllowCommit() {
		return allowCommit;
	}

	public void setAllowCommit(boolean allowCommit) {
		this.allowCommit = allowCommit;
	}
}